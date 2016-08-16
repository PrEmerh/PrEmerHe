package com.casosemergencias.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
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
import com.casosemergencias.logic.CaseService;
import com.casosemergencias.logic.PickListsService;
import com.casosemergencias.model.Caso;
import com.casosemergencias.util.ParserModelVO;
import com.casosemergencias.util.constants.Constantes;
import com.casosemergencias.util.datatables.DataTableProperties;
import com.casosemergencias.util.datatables.DataTableRemappedProperties;
import com.casosemergencias.util.datatables.ParseBodyDataTable;

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
	
	@RequestMapping(value = "/private/entidadCasoAlta", method = RequestMethod.GET)
	public ModelAndView casoAlta() {
		
		logger.info("--- Inicio -- altaCaso ---");
		
		ModelAndView model = new ModelAndView();	
		CaseView casoView = new CaseView();
		
		model.addObject("editMode", Constantes.EDIT_MODE_INSERT);
		model.setViewName("/private/entidadCasoAltaPage");
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
		
		model.addObject("caso", casoView);
		
		return model;
	}

	@RequestMapping(value = "/private/altaCaso", params="GuardarCaso", method = RequestMethod.POST)
	public String guardarCaso(CaseView caso){
		//ModelAndView model = new ModelAndView();
		String sfid = this.saveCase(caso);
		/*Borrar y utilizar el recuperado en el alta*/
		sfid = "5005B000000sESVQA2";
		
		return "redirect:entidadCaso?sfid=" + sfid + "&editMode=" + Constantes.EDIT_MODE_VIEW;
	}
	
	@RequestMapping(value = "/private/altaCaso", params="GuardarCasoYNuevo", method = RequestMethod.POST)
	public String guardarCasoYNuevo(CaseView caso) {
		ModelAndView model = new ModelAndView();
		String sfid = this.saveCase(caso);
		return "redirect:entidadCasoAlta";
	}
	
	private void verificarPickList(CaseView caso){
		if (caso.getSubmotivo() != null && Constantes.PICKLIST_CASO_DEFAULT.equalsIgnoreCase(caso.getSubmotivo())){
			caso.setSubmotivo(null);
		}
		if (caso.getCondicionAgravante() != null && Constantes.PICKLIST_CASO_DEFAULT.equalsIgnoreCase(caso.getCondicionAgravante())){
			caso.setCondicionAgravante(null);
		}
		if (caso.getCanalNotificacion() != null && Constantes.PICKLIST_CASO_DEFAULT.equalsIgnoreCase(caso.getCanalNotificacion())){
			caso.setCanalNotificacion(null);
		}		
		if (caso.getFavorabilidadDelCaso() != null && Constantes.PICKLIST_CASO_DEFAULT.equalsIgnoreCase(caso.getFavorabilidadDelCaso())){
			caso.setFavorabilidadDelCaso(null);
		}
	}

	private String saveCase(CaseView casoView){
		String sfid = "";
		
		/**/
		//Llamada a salesforce para generar el caso y recuperar su sfid y su casenumber
		//Seteamos en el objeto caseview el sfid y el casenumber
		/**/
		//Parseamos los datos
		verificarPickList(casoView);
		Caso caso = new Caso();
		ParserModelVO.parseDataModelVO(casoView, caso);
		//Llamamos a al dao para insertar
		
		casoService.insertCase(caso);
		
		//Devolvemos el id de salesforce generado
		return sfid;
	}

	/**
	 * Metodo invocado por la tabla de homeCasosPage. Se recoge del body las propiedades de la tabla, le recupera la liasta con todos los 
	 * casos utilizando estas propiedades y se envian a la tabla en un JSON
	 * 
	 * @param body
	 * @return
	 */
	@RequestMapping(value = "/listarCasos", method = RequestMethod.POST)
	public @ResponseBody String listadoCasosHome(@RequestBody String body){
		
		logger.info("--- Inicio -- listadoCasosHome ---");
		
		DataTableProperties dataTableProperties = ParseBodyDataTable.parseBodyToDataTable(body);
		
		List<Caso> listCasos = new ArrayList<Caso>();
		
		JSONObject jsonResult = new JSONObject();
		JSONArray array = new JSONArray();
		
		listCasos = casoService.readAllCase(dataTableProperties);
		for (Caso caso : listCasos) {
			jsonResult.put("numeroCaso", caso.getNumeroCaso());
			jsonResult.put("numeroInservice", caso.getNumeroInservice());
			jsonResult.put("canalOrigen", caso.getLabelCanalorigenPickList());
			jsonResult.put("estado", caso.getDescripcionEstado());
			jsonResult.put("subestado", caso.getLabelSubestadoPickList());
			jsonResult.put("submotivo", caso.getLabelSubmotivoPickList());
			jsonResult.put("sfid", caso.getSfid());
			array.put(jsonResult);
		}
		
		Integer numCasos = casoService.getNumCasos();

		JSONObject json = new JSONObject();
		json.put("iTotalRecords", numCasos);  //Numero de registros totales en BBDD
		json.put("iTotalDisplayRecords", numCasos); //numero de registros totales filtrados en BBDD -- este numero lo utiliza el datatable para calcular el numero de paginas
		json.put("data", array);
		
		logger.info("--- Inicio -- listadoCasosHome ---");
		
		return json.toString();
	}
	
	@RequestMapping(value = "/private/actualizarCaso", method = RequestMethod.POST)
	public String actualizarCaso(CaseView casoRequest) {
		logger.info("--- Inicio -- actualizarCaso ---");
		
		Caso caso = new Caso();
		ParserModelVO.parseDataModelVO(casoRequest, caso);
		int updatedCase = casoService.updateCase(caso);
		
		logger.info("--- Fin -- actualizarCaso ---");
		
		return "redirect:entidadCaso?sfid=" + caso.getSfid() + "&editMode=" + (updatedCase == 1 ? Constantes.EDIT_MODE_UPDATED_OK : Constantes.EDIT_MODE_UPDATED_ERROR);
	}
}