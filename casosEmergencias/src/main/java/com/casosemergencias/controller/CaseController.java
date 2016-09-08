package com.casosemergencias.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.casosemergencias.controller.views.CaseCommentView;
import com.casosemergencias.controller.views.CaseView;
import com.casosemergencias.dao.vo.CaseCommentVO;
import com.casosemergencias.dao.vo.CaseHistoryVO;
import com.casosemergencias.logic.CaseCommentService;
import com.casosemergencias.controller.views.AccountView;
import com.casosemergencias.controller.views.CaseView;
import com.casosemergencias.controller.views.ContactView;
import com.casosemergencias.controller.views.DireccionView;
import com.casosemergencias.controller.views.SuministroView;
import com.casosemergencias.logic.AccountService;
import com.casosemergencias.logic.CaseService;
import com.casosemergencias.logic.ContactService;
import com.casosemergencias.logic.DireccionService;
import com.casosemergencias.logic.PickListsService;
import com.casosemergencias.model.CaseComment;
import com.casosemergencias.model.CaseHistory;
import com.casosemergencias.logic.SuministroService;

import com.casosemergencias.model.Caso;
import com.casosemergencias.model.Contacto;
import com.casosemergencias.model.Cuenta;
import com.casosemergencias.model.Direccion;
import com.casosemergencias.model.Suministro;
import com.casosemergencias.util.ParserModelVO;
import com.casosemergencias.util.constants.Constantes;
import com.casosemergencias.util.datatables.DataTableParser;
import com.casosemergencias.util.datatables.DataTableProperties;

/**
 * @author mcasas
 * 
 *Clase encargada de controlar las peticiones dels pantallas donde se muestran los Casos
 *En esta clase utilizaremos el objeto CaseView, pero cuando llamemos al Servicio le tendremos que pasar un objeto Caso.
 *Objetos CaseView, son objetos que controlan las pantallas de Casos
 */
@Controller
public class CaseController {
	
	final static Logger logger = Logger.getLogger(CaseController.class);
	
	@Autowired
	private CaseService casoService;

	@Autowired
	private PickListsService pickListsService;
	
	@Autowired
	private SuministroService suministroService;
	
	@Autowired
	private ContactService contactoService;
	
	@Autowired
	private AccountService cuentaService;
	
	@Autowired
	private DireccionService direccionService;

	@Autowired
	private CaseCommentService caseCommentService;

	private int updatedCase;

	/**
	 * Metodo que recupera una lista con todos los casos que hay creados en BBDD y los muestra en la pantalla homeCasosPage.jsp
	 * 
	 * @return
	 */
	@RequestMapping(value = "/private/homeCasos", method = RequestMethod.GET)
	public ModelAndView goHomeCasos() {
		
		logger.info("--- Inicio -- listadoCasos ---");
		
		ModelAndView model = new ModelAndView();
		model.setViewName("private/homeCasosPage");
	
		logger.info("--- Fin -- listadoCasos ---");
				
		return model;
	}
	
	@RequestMapping(value = "/private/homeCasosAction", params="goCrearCaso", method = RequestMethod.POST)
	public String goCrearCaso() {
		return "redirect:entidadCasoAlta";
	}
	
	@RequestMapping(value = "/private/entidadCaso", method = RequestMethod.GET)
	public ModelAndView getCaseData(@RequestParam String sfid, @RequestParam String editMode) {
		logger.info("--- Inicio -- getCaseData ---");
		
		ModelAndView model = new ModelAndView();		
		model.addObject("sfid", sfid);
		model.addObject("editMode", editMode);
		
		//List<CaseView> listCaseView = new ArrayList<CaseView>();
		CaseView casoView = new CaseView();
		
		Caso casoBBDD = casoService.readCaseBySfid(sfid);
		if (casoBBDD != null){
			ParserModelVO.parseDataModelVO(casoBBDD, casoView);
		}
		model.setViewName("private/entidadCasoPage");
		/*Hay que añadir recuperación de label de los picklists si no sale el código solo*/
		model.addObject("caso", casoView);
		
		logger.info("--- Fin -- getCaseData ---");
		return model;
	}

	@RequestMapping(value = "/private/entidadCasoAlta", method = RequestMethod.GET)
	public ModelAndView cargarPaginaAltaCaso(HttpServletRequest request) {
		logger.info("--- Inicio -- cargarPaginaAltaCaso ---");
		
		ModelAndView model = new ModelAndView();	
		CaseView casoView = new CaseView();
				
		
		model.addObject("editMode", Constantes.EDIT_MODE_INSERT);
		model.setViewName("private/entidadCasoAltaPage");
		//Setteo de datos fijos
		casoView.setCanalOrigen(Constantes.COD_CASO_ORIGEN_WEB);
		casoView.setCanalOrigenLabel(Constantes.COD_CASO_ORIGEN_WEB_DESC);
		casoView.setType(Constantes.COD_CASO_TYPE_RECLAMO);
		casoView.setTypeLabel(Constantes.COD_CASO_TYPE_RECLAMO_DESC);
		casoView.setEstado(Constantes.COD_CASO_STATUS_INGRESADO);

		//Recuperacion mapa picklists
		Map<String, Map<String, String>> mapaGeneral = pickListsService.getPickListPorObjeto("Case");
		casoView.setMapStatus(this.getPickListPorCampo(mapaGeneral, Constantes.PICKLIST_CASO_STATUS, false));
		casoView.setMapPeticion(this.getPickListPorCampo(mapaGeneral, Constantes.PICKLIST_CASO_PETICION, false));
		//Recupero el RecordTypeId de Emergencia. Cambia por entorno
		if (casoView.getMapPeticion() != null && !casoView.getMapPeticion().isEmpty() 
				&& casoView.getMapPeticion().containsValue(Constantes.PICKLIST_CASO_PETICION_EMERGENCIA_NAME)){
	        for (Entry<String, String> entry : casoView.getMapPeticion().entrySet()) {
	            if (Constantes.PICKLIST_CASO_PETICION_EMERGENCIA_NAME.equalsIgnoreCase(entry.getValue())){
	            	casoView.setPeticion(entry.getKey());
	            	casoView.setPeticionLabel(entry.getValue());
	                break;
	            }
	        }
		}
		casoView.setMapSubMotivo(this.getPickListPorCampo(mapaGeneral, Constantes.PICKLIST_CASO_SUBMOTIVO, true));
		casoView.setMapCondicionAgravante(this.getPickListPorCampo(mapaGeneral, Constantes.PICKLIST_CASO_CONDICION_AGRAVANTE, true));
		casoView.setMapCanalNotificacion(this.getPickListPorCampo(mapaGeneral, Constantes.PICKLIST_CASO_CANAL_NOTIFICACION, true));
		casoView.setMapFavorabilidadCaso(this.getPickListPorCampo(mapaGeneral, Constantes.PICKLIST_CASO_FAVORABILIDAD, true));
		
		// Añadir datos de suministro, direccion, cuenta y contacto. Se recupera
		// el sfid a través de la sesión y, a partir de este, se recupera la
		// información de cada entidad.
		HttpSession session = request.getSession(true);
		
		if (session.getAttribute(Constantes.SFID_SUMINISTRO) != null && !"".equals(session.getAttribute(Constantes.SFID_SUMINISTRO))) {
			//Obtener el suministro para guardarlo en el formulario
			Suministro suministro = new Suministro();
			SuministroView suministroVista = new SuministroView();
			String suministroSfid = (String) session.getAttribute(Constantes.SFID_SUMINISTRO);
			suministro = suministroService.readSuministroBySfid(suministroSfid);
			ParserModelVO.parseDataModelVO(suministro, suministroVista);
			casoView.setSuministroJoin(suministroVista);
			
			if (suministro != null && suministro.getDireccion() != null && !"".equals(suministro.getDireccion())) {
				//Obtener la direccion del suministro para guardarla en el formulario
				Direccion direccion = new Direccion();
				DireccionView direccionVista = new DireccionView();
				String direccionSfid = suministro.getDireccion();
				direccion = direccionService.readDireccionBySfid(direccionSfid);
				ParserModelVO.parseDataModelVO(direccion, direccionVista);
				casoView.setDireccionJoin(direccionVista);
			}
		}
		
		if (session.getAttribute(Constantes.SFID_CONTACTO) != null && !"".equals(session.getAttribute(Constantes.SFID_CONTACTO))) {
			//Obtener el contacto para guardarlo en el formulario
			Contacto contacto = new Contacto();
			ContactView contactoVista = new ContactView();
			String contactoSfid = (String) session.getAttribute(Constantes.SFID_CONTACTO);
			contacto = contactoService.readContactoBySfid(contactoSfid);
			ParserModelVO.parseDataModelVO(contacto, contactoVista);
			casoView.setContactoJoin(contactoVista);
		}
		
		if (session.getAttribute(Constantes.SFID_CUENTA) != null && !"".equals(session.getAttribute(Constantes.SFID_CUENTA))) {
			//Obtener la cuenta para guardarla en el formulario
			Cuenta cuenta = new Cuenta();
			AccountView cuentaVista = new AccountView();
			String cuentaSfid = (String) session.getAttribute(Constantes.SFID_CUENTA);
			cuenta = cuentaService.getAccountBySfid(cuentaSfid);
			ParserModelVO.parseDataModelVO(cuenta, cuentaVista);
			casoView.setCuentaJoin(cuentaVista);
		}

		model.addObject("caso", casoView);
		
		logger.info("--- Fin -- cargarPaginaAltaCaso ---");
		
		return model;
	}
	
	@RequestMapping(value = "/private/cancelAltaCaso",method = RequestMethod.GET)
	public String cancelAltaCaso(HttpServletRequest request) {
		HttpSession session = request.getSession();
			
		String suministroSfid= new String();
		String contactoSfid= new String();
		String finalDetailPage= new String();
	
		suministroSfid=(String) session.getAttribute(Constantes.SFID_SUMINISTRO);
		contactoSfid=(String) session.getAttribute(Constantes.SFID_CONTACTO);
		finalDetailPage=(String) session.getAttribute(Constantes.FINAL_DETAIL_PAGE);
			
		if (finalDetailPage=="CONTACTO") {
			return "redirect:entidadContacto?sfid=" + contactoSfid;	
		}
		if (finalDetailPage=="SUMINISTRO") {			
			return "redirect:entidadSuministro?sfid=" + suministroSfid;
	
		} else {
			return null;
		}
	}

	@RequestMapping(value = "/private/altaCaso", method = RequestMethod.POST)
	public String guardarCaso(CaseView caso	, boolean redirectHere) {
//		//ModelAndView model = new ModelAndView();
//		String sfid = saveCase(caso);
//		
//		/*Borrar y utilizar el recuperado en el alta*/
//		sfid = "5005B000000sESVQA2";
//		
////		return "redirect:entidadCaso?sfid=" + sfid + "&editMode=" + Constantes.EDIT_MODE_VIEW;
		if (redirectHere) {
			return "redirect:entidadCasoAlta";
		} else {
			return "redirect:homeCasos";
		}
		
	}
	
//	private String saveCase(CaseView casoView) {
//		String sfid = "";
//		
//		// TODO: Llamada a salesforce para generar el caso y recuperar su sfid y su casenumber
//		
//		// TODO: Seteamos en el objeto caseview el sfid y el casenumber
////		casoView.setSfid(null);
////		casoView.setNumeroCaso(null);
//		
//		verificarPickList(casoView);
//		Caso caso = new Caso();
//		ParserModelVO.parseDataModelVO(casoView, caso);
//		
//		casoService.insertCase(caso);
//		
//		return sfid;
//	}
	
	
	/**
	 * M&eacute;todo invocado por la tabla de homeCasosPage. Se recoge del body
	 * las propiedades de la tabla, le recupera la lista con todos los casos
	 * utilizando estas propiedades y se envian a la tabla en formato JSON.
	 * 
	 * @param body
	 *            Informaci&oacute;n de la request.
	 * @return String Información devuelta de los casos en formato JSON.
	 */
	@RequestMapping(value = "/listarCasos", method = RequestMethod.POST)
	public @ResponseBody String listadoCasosHome(@RequestBody String body,HttpServletRequest request){
		
		logger.info("--- Inicio -- listadoCasosHome ---");
		
		//Limpieza de sfid que arrastramos
		
		HttpSession session = request.getSession(true);	
		
		session.setAttribute(Constantes.SFID_SUMINISTRO, null);	
		session.setAttribute(Constantes.SFID_CONTACTO, null);	
		session.setAttribute(Constantes.SFID_CUENTA, null);	
		session.setAttribute(Constantes.FINAL_DETAIL_PAGE, null);	
		
		//Limpieza de sfid que arrastramos
		
		DataTableProperties dataTableProperties = DataTableParser.parseBodyToDataTable(body);
		
		List<Caso> listCasos = new ArrayList<Caso>();
		
		JSONObject jsonResult;
		JSONArray jsonArray = new JSONArray();
		
		listCasos = casoService.readAllCase(dataTableProperties);
		
		for (Caso caso : listCasos) {
			jsonResult = new JSONObject();
			jsonResult.put("numeroCaso", caso.getNumeroCaso());
			jsonResult.put("numeroInservice", caso.getNumeroInservice());
			jsonResult.put("canalOrigen", caso.getLabelCanalOrigenPickList());
			jsonResult.put("estado", caso.getDescripcionEstado());
			jsonResult.put("subestado", caso.getLabelSubestadoPickList());
			jsonResult.put("submotivo", caso.getLabelSubmotivoPickList());
			jsonResult.put("sfid", caso.getSfid());
			jsonArray.put(jsonResult);
		}
		
		Integer numCasos = casoService.getNumCasos(dataTableProperties);

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("iTotalRecords", numCasos);  //Numero de registros totales en BBDD
		jsonObject.put("iTotalDisplayRecords", numCasos); //numero de registros totales filtrados en BBDD -- este numero lo utiliza el datatable para calcular el numero de paginas
		jsonObject.put("data", jsonArray);
		jsonObject.put("draw", dataTableProperties.getDraw());
		
		logger.info("--- Fin -- listadoCasosHome ---");
		
		return jsonObject.toString();
	}
	
	/**
	 * M&eacute;todo que actualiza la informaci&oacute;n de un caso.
	 * 
	 * @param casoRequest
	 *            Informaci&oacute;n del caso a actualizar.
	 * @return String Redirecci&oacute;n a la p&aacute;gina con la
	 *         informaci&oacute;n del resultado de la actualizaci&oacute;n.
	 */
	@RequestMapping(value = "/private/actualizarCaso", method = RequestMethod.POST)
	public String actualizarCaso(CaseView casoRequest) {
		logger.info("--- Inicio -- actualizarCaso ---");
		
		Caso caso = new Caso();
		ParserModelVO.parseDataModelVO(casoRequest, caso);
		int updatedCase = casoService.updateCase(caso);
		
		logger.info("--- Fin -- actualizarCaso ---");
		
		return "redirect:entidadCaso?sfid=" + caso.getSfid() + "&editMode=" + (updatedCase == 1 ? Constantes.EDIT_MODE_UPDATED_OK : Constantes.EDIT_MODE_UPDATED_ERROR);
	}

	private void verificarPickList(CaseView caso) {
		if (caso.getSubmotivo() != null && Constantes.PICKLIST_CASO_DEFAULT.equalsIgnoreCase(caso.getSubmotivo())) {
			caso.setSubmotivo(null);
		}
		
		if (caso.getCondicionAgravante() != null && Constantes.PICKLIST_CASO_DEFAULT.equalsIgnoreCase(caso.getCondicionAgravante())) {
			caso.setCondicionAgravante(null);
		}
		
		if (caso.getCanalNotificacion() != null && Constantes.PICKLIST_CASO_DEFAULT.equalsIgnoreCase(caso.getCanalNotificacion())) {
			caso.setCanalNotificacion(null);
		}
		
		if (caso.getFavorabilidadDelCaso() != null && Constantes.PICKLIST_CASO_DEFAULT.equalsIgnoreCase(caso.getFavorabilidadDelCaso())) {
			caso.setFavorabilidadDelCaso(null);
		}
	}
	
	private Map<String, String> getPickListPorCampo(Map<String, Map<String, String>> mapaGeneral, String campo, Boolean anniadirDefault){
		Map<String, String> returnMap = null;
		if (mapaGeneral != null && !mapaGeneral.isEmpty() && mapaGeneral.containsKey(campo)){
				returnMap = new LinkedHashMap<String, String>();
			if(anniadirDefault){
				returnMap.put(Constantes.PICKLIST_CASO_DEFAULT, "");
			}
				returnMap.putAll(mapaGeneral.get(campo));
		}
		return returnMap;
	}

	@RequestMapping(value = "/private/casoComentarioPage", method = RequestMethod.GET)
	public ModelAndView comentarioCaso(@ModelAttribute("sfid") String sfidCase) {
		
		logger.info("--- Inicio -- comentarioCaso ---");
		logger.debug("----- comentarioCaso -- sfid del caso: " + sfidCase);
		
		ModelAndView model = new ModelAndView();			
		model.setViewName("private/comentarioCasePage");
		
		Caso caso = this.caseCommentService.obtenerDatosCasoParaComentario(sfidCase);

		model.addObject("description", caso.getDescription());
		model.addObject("asunto", caso.getAsunto());
		model.addObject("numeroCaso", caso.getNumeroCaso());
		
		CaseCommentView caseComment = new CaseCommentView();
		
		List<CaseComment> listaComentariosCasos = caseCommentService.obtenerListaComentariosDeUnCaso(sfidCase);

		List<CaseCommentView> listaComentariosCasoView = new ArrayList<>();
		
		if(listaComentariosCasos!=null && !listaComentariosCasos.isEmpty()){
			for(CaseComment historiaCasoVO: listaComentariosCasos){
				CaseCommentView casoRelacionado = new CaseCommentView();
				ParserModelVO.parseDataModelVO(historiaCasoVO, casoRelacionado);
				listaComentariosCasoView.add(casoRelacionado);
			}
		}
		
		caseComment.setListaOldComment(listaComentariosCasoView);
		caseComment.setCaseid(sfidCase);
		
		model.addObject("caseComment", caseComment);
		logger.info("--- Fin -- comentarioCaso ---");
		
		return model;
	}
	
	@RequestMapping(value ="/private/saveComentarioCaso", method = RequestMethod.POST)
	public String saveComentarioCaso(CaseCommentView casoRequest){
		
		
		logger.info("--- Inicio -- actualizarCaso ---");
		
		CaseComment comentarioCaso = new CaseComment();
		ParserModelVO.parseDataModelVO(casoRequest, comentarioCaso);
		Boolean insertCaseComment = caseCommentService.insertCaseComment(comentarioCaso);
		
		logger.info("--- Fin -- actualizarCaso ---");
		logger.info("UPDATED CASE"+insertCaseComment);
		
		if(insertCaseComment == true){			
			return "redirect:entidadCaso?sfid=" + comentarioCaso.getCaseid() +"&editMode="+Constantes.CREATED_MODE_CREATED_OK;
		}
		else{
			return "redirect:entidadCaso?sfid=" + comentarioCaso.getCaseid() +"&editMode="+Constantes.CREATED_MODE_CREATED_ERROR;
		}		
	}
}