package com.casosemergencias.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
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
import com.casosemergencias.controller.views.SuministroView;
import com.casosemergencias.logic.ContactService;
import com.casosemergencias.logic.SuministroService;
import com.casosemergencias.model.Contacto;
import com.casosemergencias.util.ParserModelVO;
import com.casosemergencias.util.constants.Constantes;
import com.casosemergencias.util.constants.ConstantesTibcoWS;
import com.casosemergencias.util.datatables.DataTableParser;
import com.casosemergencias.util.datatables.DataTableProperties;

@Controller
public class ContactController {

	final static Logger logger = Logger.getLogger(LoginController.class);

	@Autowired
	private ContactService contactService;

	@Autowired 
	SuministroService suministroService;
	
	@RequestMapping(value = "/private/homeContacts", method = RequestMethod.GET)
	public ModelAndView listadoContactos() {

		logger.info("--- Inicio -- listadoContactos ---");
		
		ModelAndView model = new ModelAndView();
		model.setViewName("private/homeContactsPage");
			
		logger.info("--- Fin -- listadoContactos ---");
		
		return model;
	}

	@RequestMapping(value = "/private/entidadContacto", method = RequestMethod.GET)
	public ModelAndView getContactoData(@RequestParam String sfid,HttpServletRequest request) {
		logger.debug("Ejecutar consulta");
		HttpSession session = request.getSession(true);
		
		
		session.setAttribute(Constantes.SFID_CONTACTO, sfid);
		session.setAttribute(Constantes.FINAL_DETAIL_PAGE, "CONTACTO");

		ModelAndView model = new ModelAndView();		
		model.addObject("sfid", sfid);

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

		
		model.setViewName("private/entidadContactoPage");
		model.addObject("contacto", contactoView);
		
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
			jsonResult.put("run", contacto.getRun());
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
	
}
