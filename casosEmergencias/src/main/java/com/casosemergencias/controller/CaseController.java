package com.casosemergencias.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
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
			caseView.setSfid(caso.getSfid());
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
			
			listCaseView.add(caseView);
		}
		
		model.addObject("listaCasos", listCaseView);
		

		logger.info("--- Fin -- listadoCasos ---");
		
		return model;
	}
	
	@Autowired
	private PickListsService pickListsService;
	
	@RequestMapping(value = "/private/entidadCaso", method = RequestMethod.GET)
	public ModelAndView getCaseData(@RequestParam String sfid, @RequestParam String editMode) {
		System.out.println("Ejecutar consulta");
		ModelAndView model = new ModelAndView();		
		model.setViewName("private/entidadCasoPage");
		model.addObject("sfid", sfid);
		model.addObject("editMode", editMode);
		
		//List<CaseView> listCaseView = new ArrayList<CaseView>();
		CaseView casoView = new CaseView();
		if (!"insert".equalsIgnoreCase(editMode)){
			Caso casoBBDD = casoService.readCaseBySfid(sfid);
			if (casoBBDD != null){
				ParserModelVO.parseDataModelVO(casoBBDD, casoView);
			}
		}
		Map<String, Map<String, String>> mapaGeneral = pickListsService.getPickListPorObjeto("Case");
		model.addObject("caso", casoView);
		model.addObject("statusList", this.getPickListPorCampo(mapaGeneral, "Status"));
		model.addObject("substatusList", this.getPickListPorCampo(mapaGeneral, "Sub_Estado__c"));
		model.addObject("peticionList", this.getPickListPorCampo(mapaGeneral, "Petici_n__c"));
		model.addObject("canalOrigenList", this.getPickListPorCampo(mapaGeneral, "Origin"));
		
		return model;
	}
	
	private Map<String, String> getPickListPorCampo(Map<String, Map<String, String>> mapaGeneral, String campo){
		Map<String, String> returnMap = null;
		if (mapaGeneral != null && !mapaGeneral.isEmpty() && mapaGeneral.containsKey(campo)){
			returnMap = mapaGeneral.get(campo);
		}
		return returnMap;
	}
	
}
