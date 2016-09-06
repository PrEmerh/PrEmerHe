package com.casosemergencias.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import com.casosemergencias.util.constants.Constantes;
import com.casosemergencias.util.datatables.DataTableParser;
import com.casosemergencias.util.datatables.DataTableProperties;

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
	
//	@RequestMapping(value = "/private/homeSuministrosInicio", method = RequestMethod.GET)
//	public ModelAndView detalleSuministroInicio() {
//
//		logger.info("--- Inicio -- homeSuministrosInicio ---");
//		List<SuministroView> listaAMostrar = new ArrayList<SuministroView>(); 
//		List<Suministro> listSuministros = suministroService.readAllSuministros();
//		SuministroView suministroView=null;
//		for(Suministro sum:listSuministros){
//			suministroView = new SuministroView();	
//			ParserModelVO.parseDataModelVO(sum, suministroView);
//			listaAMostrar.add(suministroView);
//		}
//		ModelAndView model = new ModelAndView();
//		model.addObject("suministros", listaAMostrar);
//		model.setViewName("private/homeSuministrosPage");
//		logger.info("--- Fin -- homeSuministrosInicio ---");
//		return model;
//	}
//	
	@RequestMapping(value = "/private/entidadSuministro", method = RequestMethod.GET)
	public ModelAndView getSuministroData(@RequestParam String sfid,HttpServletRequest request) {
		
		logger.info("Ejecutar consulta");
		HttpSession session = request.getSession(true);
		
		session.setAttribute(Constantes.SFID_SUMINISTRO, sfid);	
		session.setAttribute(Constantes.FINAL_DETAIL_PAGE, "SUMINISTRO");

		ModelAndView model = new ModelAndView();		
		model.addObject("sfid", sfid);
	
		SuministroView suministroView = new SuministroView();
		
		Suministro suministroBBDD = suministroService.readSuministroBySfid(sfid);
		if (suministroBBDD != null){
			ParserModelVO.parseDataModelVO(suministroBBDD, suministroView);
		}
		
		//Almacenamos sfid de contactos relacionados en caso de que el suministro seleccionado tenga solo uno asociado.
		
		if(suministroView.getContactosRelacionados()!=null && !suministroView.getContactosRelacionados().isEmpty()  && suministroView.getContactosRelacionados().size()==1 && session.getAttribute(Constantes.SFID_CONTACTO)==null){
			session.setAttribute(Constantes.SFID_CONTACTO, suministroView.getContactosRelacionados().get(0).getSfid());					
		}
		
		logger.info("SFID_CUENTA" + session.getAttribute(Constantes.SFID_CUENTA));
		logger.info("SFID_CONTACTO" + session.getAttribute(Constantes.SFID_CONTACTO));
		logger.info("SFID_SUMINISTRO" + session.getAttribute(Constantes.SFID_SUMINISTRO));
		logger.info("FINAL_DETAIL_PAGE" + session.getAttribute(Constantes.FINAL_DETAIL_PAGE));

		model.setViewName("private/entidadSuministroPage");
		model.addObject("suministro", suministroView);

		return model;
	}

	/**
	 * M&eacute;todo para recuperar los datos de la ventana modal de suministros.
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
			jsonResult.put("DireccionConcatenada__c", suministro.getDireccionConcatenada());
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
	 * M&eacute;todo para recuperar los datos del listado de suministros.
	 * 
	 * @param body
	 * @return
	 */
	@RequestMapping(value = "/listarSuministros", method = RequestMethod.POST)
	public @ResponseBody String listadoSuministros(@RequestBody String body,HttpServletRequest request){
		
		logger.info("--- Inicio -- listadoSuministrosHome ---");
				
		//Limpieza de sfid que arrastramos
		
		HttpSession session = request.getSession(true);	
		
		session.setAttribute(Constantes.SFID_SUMINISTRO, null);	
		session.setAttribute(Constantes.SFID_CONTACTO, null);	
		session.setAttribute(Constantes.SFID_CUENTA, null);
		session.setAttribute(Constantes.FINAL_DETAIL_PAGE, null);	
		
		//Limpieza de sfid que arrastramos
		
		DataTableProperties propDataTable = DataTableParser.parseBodyToDataTable(body);
		List<Suministro> listSuministros = new ArrayList<Suministro>();
		
		JSONObject jsonResult = new JSONObject();
		JSONArray array = new JSONArray();
		
		listSuministros = suministroService.readAllSuministros(propDataTable);

		for (Suministro suministro : listSuministros) {
			jsonResult = new JSONObject();
			jsonResult.put("name", suministro.getName());
			jsonResult.put("estadoConexion", suministro.getLabelEstadoConexionPickList());
			jsonResult.put("estadoSuministro", suministro.getLabelEstadoSuministroPickList());
			jsonResult.put("DireccionConcatenada__c", suministro.getDireccionConcatenada());
			jsonResult.put("comuna", suministro.getComuna());
			jsonResult.put("n_mero_medidor__c", suministro.getNumeroMedidor());
			jsonResult.put("ruta__c", suministro.getRuta());
			jsonResult.put("sfid", suministro.getSfid());
			array.put(jsonResult);
		}
		
		Integer numSuministros = suministroService.getNumSuministros(propDataTable);
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("iTotalRecords", numSuministros); 
		jsonObject.put("iTotalDisplayRecords", numSuministros); 
		jsonObject.put("data", array);
		jsonObject.put("draw", propDataTable.getDraw());
		
		logger.info("SFID_CUENTA" + session.getAttribute(Constantes.SFID_CUENTA));
		logger.info("SFID_CONTACTO" + session.getAttribute(Constantes.SFID_CONTACTO));
		logger.info("SFID_SUMINISTRO" + session.getAttribute(Constantes.SFID_SUMINISTRO));
		
		logger.info("--- Fin -- listadoSuministrosHome ---");
		
		return jsonObject.toString();
	}
	
	//Crear Caso nuevo con Suministro asociado.
	
	@RequestMapping(value = "/private/actualizarSuministro", method = RequestMethod.POST)
	public ModelAndView crearCasoBySuministro() {
				
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:entidadCasoAlta");
		
		return model;
	}
	
	
}