package com.casosemergencias.controller;
import java.util.ArrayList;
import java.util.List;

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

import com.casosemergencias.controller.views.SuministroView;
import com.casosemergencias.logic.SuministroService;
import com.casosemergencias.model.Suministro;
import com.casosemergencias.util.ParserModelVO;
import com.casosemergencias.util.datatables.DataTableProperties;
import com.casosemergencias.util.datatables.DataTableParser;

@Controller
public class SuministroController {
	
	final static Logger logger = Logger.getLogger(SuministroController.class);
	
	@Autowired
	private SuministroService suministroService;
	
	@RequestMapping(value = "/private/homeSuministros", method = RequestMethod.GET)
	public ModelAndView detalleSuministro() {
		logger.info("--- Inicio -- listadoSuministros ---");

		ModelAndView model = new ModelAndView();
		model.setViewName("private/homeSuministrosPage");
	
		logger.info("--- Fin -- listadoSuministros ---");
		
		return model;
	}
	
	@RequestMapping(value = "/private/homeSuministrosInicio", method = RequestMethod.GET)
	public ModelAndView detalleSuministroInicio() {
		List<SuministroView> listaAMostrar = new ArrayList<SuministroView>(); 
		List<Suministro> listSuministros = suministroService.readAllSuministros();
		SuministroView suministroView=null;
		for(Suministro sum:listSuministros){
			suministroView = new SuministroView();	
			ParserModelVO.parseDataModelVO(sum, suministroView);
			listaAMostrar.add(suministroView);
		}
		ModelAndView model = new ModelAndView();
		model.addObject("suministros", listaAMostrar);
		model.setViewName("private/homeSuministrosPage");
		
		return model;
	}
	
	@RequestMapping(value = "/private/entidadSuministro", method = RequestMethod.GET)
	public ModelAndView getSuministroData(@RequestParam String sfid) {
		System.out.println("Ejecutar consulta");
		ModelAndView model = new ModelAndView();		
		model.addObject("sfid", sfid);
		
		SuministroView suministroView = new SuministroView();
		
		Suministro suministroBBDD = suministroService.readSuministroBySfid(sfid);
		if (suministroBBDD != null){
			ParserModelVO.parseDataModelVO(suministroBBDD, suministroView);
		}
		model.setViewName("private/entidadSuministroPage");
		model.addObject("suministro", suministroView);
		
		return model;
	}

	/**
	 * M�todo para recuperar los datos de la ventana modal de suministros
	 * 
	 * @param body
	 * @return
	 */
	@RequestMapping(value = "/listarSuministrosPopUp", method = RequestMethod.POST)
	public @ResponseBody String listadoSuministrosPopUp(@RequestBody String body){
		
		logger.info("--- Inicio -- listadoSuministrosPopUp ---");
		
		DataTableProperties propDataTable = DataTableParser.parseBodyToDataTable(body);
		List<Suministro> listSuministros = new ArrayList<Suministro>();
		
		JSONObject jsonResult = new JSONObject();
		JSONArray array = new JSONArray();
		
		listSuministros = suministroService.readAllSuministros(propDataTable);
		for(Suministro suministro : listSuministros){
			jsonResult = new JSONObject();
			jsonResult.put("name", suministro.getName());
			jsonResult.put("idEmpresa", suministro.getIdEmpresa());
			jsonResult.put("comuna", suministro.getComuna());
			jsonResult.put("direccionConcatenada", suministro.getDireccionConcatenada());
			jsonResult.put("sfid", suministro.getSfid());
			array.put(jsonResult);
		}
		
		Integer numCasos = suministroService.getNumSuministros(propDataTable);
		
		JSONObject json = new JSONObject();
		json.put("iTotalRecords", numCasos); 
		json.put("iTotalDisplayRecords", numCasos); 
		json.put("data", array);
		
		logger.info("--- Fin -- listadoSuministrosPopUp ---");
		
		return json.toString();
	}
	
	/**
	 * M�todo para recuperar los datos de la ventana modal de suministros
	 * 
	 * @param body
	 * @return
	 */
	@RequestMapping(value = "/listarSuministros", method = RequestMethod.POST)
	public @ResponseBody String listadoSuministros(@RequestBody String body){
		
		logger.info("--- Inicio -- listadoSuministrosHome ---");
		
		DataTableProperties propDataTable = DataTableParser.parseBodyToDataTable(body);
		List<Suministro> listSuministros = new ArrayList<Suministro>();
		
		JSONObject jsonResult = new JSONObject();
		JSONArray array = new JSONArray();
		
		listSuministros = suministroService.readAllSuministros(propDataTable);
		for(Suministro suministro : listSuministros){
			jsonResult = new JSONObject();
			jsonResult.put("name", suministro.getName());
			jsonResult.put("estadoConexion", suministro.getLabelEstadoConexionPickList());
			jsonResult.put("estadoSuministro", suministro.getLabelEstadoSuministroPickList());
			jsonResult.put("direccion", suministro.getDireccionConcatenada());
			jsonResult.put("comuna", suministro.getComuna());
			jsonResult.put("n_mero_medidor__c", suministro.getNumeroMedidor());
			jsonResult.put("ruta__c", suministro.getRuta());
			jsonResult.put("sfid", suministro.getSfid());
			array.put(jsonResult);
		}
		
		Integer numCasos = suministroService.getNumSuministros(propDataTable);
		
		JSONObject json = new JSONObject();
		json.put("iTotalRecords", numCasos); 
		json.put("iTotalDisplayRecords", numCasos); 
		json.put("data", array);
		
		logger.info("--- Fin -- listadoSuministrosHome ---");
		
		return json.toString();
		
	}
}
