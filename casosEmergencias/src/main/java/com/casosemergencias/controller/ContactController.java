package com.casosemergencias.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.example.sieme002_schema.CalleType;
import org.example.sieme002_schema.ListadoCallesType;
import org.example.sieme009_schema.ListadoEventosType;
import org.example.sires033_schema.ListadoSuministrosType;
import org.example.sires033_schema.SuministroType;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.casosemergencias.controller.views.CaseView;
import com.casosemergencias.controller.views.ContactView;
import com.casosemergencias.controller.views.DireccionView;
import com.casosemergencias.controller.views.SuministroView;
import com.casosemergencias.logic.ContactService;
import com.casosemergencias.logic.DireccionService;
import com.casosemergencias.logic.PickListsService;
import com.casosemergencias.logic.SuministroService;
import com.casosemergencias.model.Contacto;
import com.casosemergencias.model.Suministro;
import com.casosemergencias.util.ParserModelVO;
import com.casosemergencias.util.PickListByField;
import com.casosemergencias.util.constants.Constantes;
import com.casosemergencias.util.constants.ConstantesTibcoWS;
import com.casosemergencias.util.datatables.DataTableColumnInfo;
import com.casosemergencias.util.datatables.DataTableParser;
import com.casosemergencias.util.datatables.DataTableProperties;

@Controller
public class ContactController {

	final static Logger logger = Logger.getLogger(LoginController.class);

	@Autowired
	private ContactService contactService;

	@Autowired
	private SuministroService suministroService;
	
	@Autowired
	private PickListsService pickListsService;
	
	@Autowired
	private DireccionService direccionService;

	@RequestMapping(value = "/private/homeContacts", method = RequestMethod.GET)
	public ModelAndView listadoContactos() {

		logger.info("--- Inicio -- listadoContactos ---");
		
		ModelAndView model = new ModelAndView();
		model.setViewName("private/homeContactsPage");
			
		logger.info("--- Fin -- listadoContactos ---");
		
		return model;
	}

	@RequestMapping(value = "/private/entidadContacto", method = RequestMethod.GET)
	public ModelAndView getContactoData(@RequestParam String sfid,@RequestParam String editMode,HttpServletRequest request) {
		logger.debug("Ejecutar consulta");
		HttpSession session = request.getSession(true);
		
		
		session.setAttribute(Constantes.SFID_CONTACTO, sfid);
		session.setAttribute(Constantes.FINAL_DETAIL_PAGE, Constantes.FINAL_DETAIL_PAGE_CONTACTO);

		ModelAndView model = new ModelAndView();		
		model.addObject("sfid", sfid);
		model.addObject("editMode", editMode);

		ContactView contactoView = new ContactView();		
		Contacto contactoBBDD = contactService.readContactoBySfid(sfid);
		if (contactoBBDD != null){
			ParserModelVO.parseDataModelVO(contactoBBDD, contactoView);
		}
		
		//Almacenamos sfid de suministro relacionado en caso de que el contacto tenga solo uno asociado.
		
//		if(contactoView.getSuministros()!=null && contactoView.getSuministros().isEmpty()==false  && contactoView.getSuministros().size()==1 && session.getAttribute(Constantes.SFID_SUMINISTRO)==null){
//			session.setAttribute(Constantes.SFID_SUMINISTRO, contactoView.getSuministros().get(0).getSfid());					
//		}
		if(contactoView.getCuentaJoin()!=null && session.getAttribute(Constantes.SFID_CUENTA)==null){
			session.setAttribute(Constantes.SFID_CUENTA, contactoView.getCuentaJoin().getSfid());					
		}
		
		//transformamos las fechas con el gmt de sesion
		long offset = (long)session.getAttribute("difGMTUser");		
		if(contactoView.getCasos() != null && !contactoView.getCasos().isEmpty()){
			for(CaseView miCase : contactoView.getCasos()){
				if(miCase.getFechaApertura() != null){
					Date fechaApertura = miCase.getFechaApertura();
					fechaApertura = new Date(fechaApertura.getTime() + offset);
					miCase.setFechaApertura(fechaApertura);
				}
				if(miCase.getFechaEstimadaCierre() != null){
					Date fechaEstimacion = miCase.getFechaEstimadaCierre();
					fechaEstimacion = new Date(fechaEstimacion.getTime() + offset);
					miCase.setFechaEstimadaCierre(fechaEstimacion);
				}
			}	
		}

		if (contactoView.getSuministros() != null && !contactoView.getSuministros().isEmpty() && contactoView.getSuministros().size() == 1) {
			/* Llamada a los servicios web de Tibco para obtener datos y eventos del suministro para los indicadores */
			SuministroView suministroView = contactoView.getSuministros().get(0);
			Map<String, Object> datosWS = suministroService.getDatosSuministroWS(suministroView.getNumeroSuministro());
			
			if (datosWS.get(ConstantesTibcoWS.SIRES033_RESPONSE_LIST_NAME) != null) {
				suministroView.setListadoSuministros((ListadoSuministrosType) datosWS.get(ConstantesTibcoWS.SIRES033_RESPONSE_LIST_NAME));
				for (SuministroType suministro : suministroView.getListadoSuministros().getSuministro()) {
					if (suministro.getFechaCorteSuministro() != null) {
						Date fechaActual = new Date();
						Date fechaCorteSuministro = suministro.getFechaCorteSuministro().toGregorianCalendar().getTime();
						suministroView.setFechaCorte(fechaCorteSuministro);
						logger.info("La fecha de corte del suministro es " + fechaCorteSuministro);
						if (fechaActual.getTime() > fechaCorteSuministro.getTime()) {
							logger.info("Se ha superado la fecha de corte, por lo que se marca que es corte por deuda");
							suministroView.setCortePorDeuda(true);
						}
					}
				}
			} else {
				// Estos datos se deben rellenar solo desde el WS. Si no, no se muiestra informacion
				suministroView.setFechaCorte(null);
				suministroView.setCortePorDeuda(null);
			}
			
			if (datosWS.get(ConstantesTibcoWS.SIEME009_RESPONSE_LIST_NAME) != null) {
				suministroView.setListadoEventos((ListadoEventosType) datosWS.get(ConstantesTibcoWS.SIEME009_RESPONSE_LIST_NAME));
			}
			
			contactoView.getSuministros().set(0, suministroView);
		}
		
		logger.info("SFID_CUENTA" + session.getAttribute(Constantes.SFID_CUENTA));
		logger.info("SFID_CONTACTO" + session.getAttribute(Constantes.SFID_CONTACTO));
		logger.info("SFID_SUMINISTRO" + session.getAttribute(Constantes.SFID_SUMINISTRO));
		logger.info("FINAL_DETAIL_PAGE" + session.getAttribute(Constantes.FINAL_DETAIL_PAGE));
		
		//Setteamos picklist del campo comuna y region del cuadro de dialogo "Asociar suministro"
		SuministroView suministroViewDial =new SuministroView();
		Map<String, Map<String, String>> mapaGeneral = pickListsService.getPickListPorObjeto("address__c");
		suministroViewDial.setMapComuna(PickListByField.getPickListPorCampo(mapaGeneral, Constantes.PICKLIST_SUMINISTRO_COMUNA, true));
		suministroViewDial.setMapRegion(PickListByField.getPickListPorCampo(mapaGeneral, Constantes.PICKLIST_SUMINISTRO_REGION, true));

		
		model.setViewName("private/entidadContactoPage");
		model.addObject("contacto", contactoView);
		model.addObject("suministroDial",suministroViewDial);
		
		return model;
	}
	
	/**
	 * M&eacute;todo para recuperar los datos del lsitado de de contactos.
	 * 
	 * @param body
	 * @return
	 */
	@RequestMapping(value = "/listarContactos", method = RequestMethod.POST)
	public @ResponseBody String listadoContactos(@RequestBody String body,HttpServletRequest request){
		
		logger.info("--- Inicio -- listadoSuministrosHome ---");
		
		//Limpieza de sfid que arrastramos
		
		HttpSession session = request.getSession(true);	
		
		session.setAttribute(Constantes.SFID_SUMINISTRO, null);	
		session.setAttribute(Constantes.SFID_CONTACTO, null);	
		session.setAttribute(Constantes.SFID_CUENTA, null);	
		session.setAttribute(Constantes.FINAL_DETAIL_PAGE, null);	
		
		//Limpieza de sfid que arrastramos
		
		DataTableProperties propDataTable = DataTableParser.parseBodyToDataTable(body);
		List<Contacto> listaContactos = new ArrayList<Contacto>();
		
		JSONObject jsonResult = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		
		listaContactos = contactService.readAllContactos(propDataTable);

		for (Contacto contacto : listaContactos) {
			jsonResult = new JSONObject();
			jsonResult.put("name", contacto.getApellidoPaterno()+", "+contacto.getFirstname());
			jsonResult.put("identitynumber__c", contacto.getRun());
			jsonResult.put("phone", contacto.getPhone());
			jsonResult.put("email", contacto.getEmail());
			jsonResult.put("sf4twitter__twitter_username__c", contacto.getSf4twitterTwitterUsername());
			jsonResult.put("sfid", contacto.getSfid());
			jsonArray.put(jsonResult);
		}
		
		Integer numContactos = contactService.getNumContactos(propDataTable);
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("iTotalRecords", numContactos); 
		jsonObject.put("iTotalDisplayRecords", numContactos); 
		jsonObject.put("data", jsonArray);
		jsonObject.put("draw", propDataTable.getDraw());
		
		logger.info("SFID_CUENTA" + session.getAttribute(Constantes.SFID_CUENTA));
		logger.info("SFID_CONTACTO" + session.getAttribute(Constantes.SFID_CONTACTO));
		logger.info("SFID_SUMINISTRO" + session.getAttribute(Constantes.SFID_SUMINISTRO));
		
				
		logger.info("--- Fin -- listadoSuministrosHome ---");
		
		return jsonObject.toString();
	}
	
	//Crear Caso nuevo con Contacto asociado.
	
	@RequestMapping(value = "/private/goCrearCasoByContacto", method = RequestMethod.GET)
	public ModelAndView crearCasoByContacto() {
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:entidadCasoAlta");
		
		return model;
	}
	
	
	/**
	 * Metodo invocado desde Asociar Suministros a un Contacto. Si los parametros de filtrado estan vacios, no se
	 * realiza busqueda en BBDD y se devuelve una lista de suministros vacia.
	 * 
	 * @param suministroView
	 * @return
	 */
	@RequestMapping(value = "/private/listarAsociarSuministros", method = RequestMethod.POST)
	public @ResponseBody String listadoSuministrosAsociar(@RequestBody String body) {//@ModelAttribute("asociarSuministro") SuministroView suministroView){
		
		logger.info("--- Inicio -- listadoSuministrosAsociar ---");
		
		//Def variable de la vista
		JSONObject jsonResult = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		
		DataTableProperties propDataTable = DataTableParser.parseBodyToDataTable(body);
		boolean busqueda = realizarBusquedaDataTable(propDataTable.getColumsInfo());
		
		if(busqueda){
			//Realizamos la busqueda en BBDD
			List<Suministro> listaSuministros = new ArrayList<Suministro>();
			listaSuministros = this.suministroService.readAllSuministros(propDataTable);

			
			for(Suministro suministro : listaSuministros){
				jsonResult = new JSONObject();
				jsonResult.put("name", suministro.getName());
				jsonResult.put("direccionConcatenada", suministro.getDireccionConcatenada());
				jsonResult.put("comuna", suministro.getComuna());
				jsonResult.put("estadoSuministroPickList", suministro.getLabelEstadoSuministroPickList());
				jsonResult.put("empresaPickList", suministro.getLabelEmpresaPickList());
				jsonResult.put("sfid", suministro.getSfid());
				jsonArray.put(jsonResult);
			}

		}		

		jsonObject.put("data", jsonArray);
	
				
		logger.info("--- Fin -- listadoSuministrosAsociar ---");
		
		return jsonObject.toString();
	}
	
	/**
	 * Dada una lista con las propiedades de las columnas un DataTable, comprueba si alguna tiene datos para filtrar, en ese caso return true
	 * 
	 * @param propColumns
	 * @return
	 */
	private boolean realizarBusquedaDataTable(List<DataTableColumnInfo> propColumns){
		//Si alguna columna tiene datos para filtrar, ponemos realizarBusqueda a true
		for(DataTableColumnInfo columnInfor : propColumns){
			if(columnInfor.getSearchValue() != null && !"".equals(columnInfor.getSearchValue())){
				return true;				
			}
			
		}
		return false;
	}
	
	@RequestMapping(value = "/private/asociarSuministro", method = RequestMethod.GET)
	public String getDireccionData(@RequestParam String sfid,@RequestParam String contactSfid) {
		logger.debug("Ejecutar consulta");

		boolean asociarSuministro=contactService.asociarSuministro(sfid,contactSfid);	
		if(asociarSuministro==true){
			return "redirect:entidadContacto?editMode="+Constantes.SUM_ASSOCIATION_CONTACT_OK+"&sfid=" + contactSfid;
		}
		else if(asociarSuministro==false){
			return "redirect:entidadContacto?editMode="+Constantes.SUM_ASSOCIATION_CONTACT_ERROR+"&sfid=" + contactSfid;

		}
		else{
			return null;
		}
		
	}
	
	
	/**
	 * Metodo invocado desde Crear Caso por Direccion. Si los parametros de filtrado estan vacios, no se
	 * realiza busqueda en BBDD y se devuelve una lista de suministros vacia.
	 * 
	 * @param direccionView
	 * @return
	 */
	
	@RequestMapping(value = "/private/listarDirecciones", method = RequestMethod.POST)
	public @ResponseBody String listadoDirecciones(@RequestBody String body) {//@ModelAttribute("asociarSuministro") SuministroView suministroView){
		
		logger.info("--- Inicio -- listarDirecciones ---");
		
		//Def variable de la vista
		JSONObject jsonResult = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		
		DataTableProperties propDataTable = DataTableParser.parseBodyToDataTable(body);
		boolean busqueda = realizarBusquedaDataTable(propDataTable.getColumsInfo());
		
		if (busqueda) {
			//Realizamos la busqueda en BBDD
			List<DireccionView> listaDirecciones = new ArrayList<DireccionView>();
			Map<String, Object> datosCallesWS = null;
			String idComuna = "";
			String nombreCalle = "";
			if (propDataTable.getColumsInfo() != null && !propDataTable.getColumsInfo().isEmpty()) {
				for (DataTableColumnInfo columnInfo : propDataTable.getColumsInfo()) {
					if ("comuna".equals(columnInfo.getData()) && columnInfo.getSearchValue() != null && !"".equals(columnInfo.getSearchValue())) {
						idComuna = columnInfo.getSearchValue();
					}
					
					if ("calle".equals(columnInfo.getData()) && columnInfo.getSearchValue() != null && !"".equals(columnInfo.getSearchValue())) {
						nombreCalle = columnInfo.getSearchValue();
					}
				}
			}
			
			datosCallesWS = direccionService.getDatosCalleWS(idComuna, nombreCalle);

			if (datosCallesWS != null && !datosCallesWS.isEmpty() && datosCallesWS.get(ConstantesTibcoWS.SIEME002_RESPONSE_LIST_NAME) != null) {
				//TODO: Buscar direcciones en SF
				logger.info("Se parsean las calles obtenidas en el WS al objeto de direcciones de la vista");
				List<CalleType> listaCalles = ((ListadoCallesType) datosCallesWS.get(ConstantesTibcoWS.SIEME002_RESPONSE_LIST_NAME)).getCalle();
				for (CalleType calle : listaCalles) {
					DireccionView direccion = new DireccionView();
					direccion.setCalle(calle.getNombreCalle());
					direccion.setTipoCalle(calle.getTipoCalle());
					direccion.setComuna(idComuna);
					listaDirecciones.add(direccion);
				}
			}
						
			/*TODO: Al recuperar la calle del WS, sólo se obtiene id, nombre y tipo
			 * Calle con id '4663327', tipo 'CALLE' y nombre 'AUGUSTO LEGUIA SUR'
			 * 
			 * ¿Mostramos los datos en el listado y, una vez seleccionada una hacemos la búsqueda en SF para
			 * crear el caso posteriormente?
			 * 
			 * - ¿Cómo guardamos el tipo? Se guardan 3 letras ahora.
			 */
						
//			listaDirecciones = this.direccionService.readAllDirecciones(propDataTable);
			
			if (listaDirecciones != null && !listaDirecciones.isEmpty()) {
				logger.info("La lista de direcciones tiene datos. Se envian a la pagina");
				for (DireccionView direccion : listaDirecciones) {
					jsonResult = new JSONObject();
					jsonResult.put("comuna", (direccion.getComuna() != null ? direccion.getComuna() : ""));
					jsonResult.put("calle", (direccion.getCalle() != null ? direccion.getCalle() : ""));
					jsonResult.put("tipoCalle", (direccion.getTipoCalle() != null ? direccion.getTipoCalle() : ""));
					jsonResult.put("direccionConcatenada", (direccion.getDireccionConcatenada() != null ? direccion.getDireccionConcatenada() : ""));
					jsonArray.put(jsonResult);
				}
			}
		}		

		jsonObject.put("data", jsonArray);
		//jsonObject.put("iTotalRecords", "10"); 
		//jsonObject.put("iTotalDisplayRecords",  "10"); 
				
		logger.info("--- Fin -- listarDirecciones ---");
		
		return jsonObject.toString();
	}
}