package com.casosemergencias.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.json.JsonArray;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.casosemergencias.controller.views.CaseView;
import com.casosemergencias.logic.CaseService;
import com.casosemergencias.logic.PickListsService;
import com.casosemergencias.model.Caso;
import com.casosemergencias.util.Constantes;
import com.casosemergencias.util.ParserModelVO;


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
	public ModelAndView listadoCasosHome() {
		
		logger.info("--- Inicio -- listadoCasos ---");

		List<CaseView> listCaseView = new ArrayList<CaseView>();
		List<Caso> listCasos = new ArrayList<Caso>();
		
		ModelAndView model = new ModelAndView();
		model.setViewName("private/homeCasosPage");
		
		logger.info("--- Llamamos al servicio -- listadoCasos ---");
		
		listCasos = casoService.readAllCase();
		for(Caso caso : listCasos){
			CaseView caseView = new CaseView();
			/*caseView.setSfid(caso.getSfid());
			caseView.setNumeroCaso(caso.getNumeroCaso());
			caseView.setNumeroInservice(caso.getNumeroInservice());
			caseView.setSubmotivo(caso.getSubMotivo());
			caseView.setFechaApertura(caso.getFechaApertura());
			caseView.setEstado(caso.getEstado());
			caseView.setSubestado(caso.getSubEstado());
			caseView.setNombreContacto("Nombre del contacto - añadir");
			caseView.setDireccionSuministro(caso.getDireccionSuministro());
			caseView.setComuna(caso.getComuna());
			caseView.setTiempoEstimacion("Tiempo estimado");
			caseView.setCanalOrigen(caso.getCanalOrigen());
			caseView.setEstadoPickList(caso.getEstadoPickList());*/
			ParserModelVO.parseDataModelVO(caso, caseView);
			listCaseView.add(caseView);
		}
		
		model.addObject("listaCasos", listCaseView);
		

		logger.info("--- Fin -- listadoCasos ---");
		
		return model;
	}
	
	@RequestMapping(value = "/private/homeCasosAction", params="goCrearCaso", method = RequestMethod.POST)
	public ModelAndView goCrearCaso() {
		ModelAndView model = new ModelAndView();
		model.setViewName("private/entidadCasoAltaPage");
		return model;
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
	
	private Map<String, String> getPickListPorCampo(Map<String, Map<String, String>> mapaGeneral, String campo){
		Map<String, String> returnMap = null;
		if (mapaGeneral != null && !mapaGeneral.isEmpty() && mapaGeneral.containsKey(campo)){
			returnMap = mapaGeneral.get(campo);
		}
		return returnMap;
	}
	
	@RequestMapping(value = "/private/entidadCasoAlta", method = RequestMethod.GET)
	public ModelAndView altaCaso() {
		
		logger.info("--- Inicio -- altaCaso ---");
		
		ModelAndView model = new ModelAndView();	
		CaseView casoView = new CaseView();
		
		model.addObject("editMode", Constantes.EDIT_MODE_INSERT);
		model.setViewName("private/entidadCasoAltaPage");
		
		Map<String, Map<String, String>> mapaGeneral = pickListsService.getPickListPorObjeto("Case");
		casoView.setMapStatus(this.getPickListPorCampo(mapaGeneral, Constantes.PICKLIST_CASO_STATUS));
		casoView.setMapSubStatus(this.getPickListPorCampo(mapaGeneral, Constantes.PICKLIST_CASO_SUBSTATUS));
		casoView.setMapPeticion(this.getPickListPorCampo(mapaGeneral, Constantes.PICKLIST_CASO_PETICION));
		casoView.setMapOrigin(this.getPickListPorCampo(mapaGeneral, Constantes.PICKLIST_CASO_ORIGIN));
		casoView.setMapCallCenter(this.getPickListPorCampo(mapaGeneral, Constantes.PICKLIST_CASO_CALLCENTER));
		model.addObject("caso", casoView);
		
		return model;
	}
	
}
