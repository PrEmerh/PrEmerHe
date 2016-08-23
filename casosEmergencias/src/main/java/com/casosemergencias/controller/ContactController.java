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

import com.casosemergencias.controller.views.ContactView;
import com.casosemergencias.logic.ContactService;
import com.casosemergencias.model.Contacto;
import com.casosemergencias.util.ParserModelVO;
import com.casosemergencias.util.datatables.DataTableParser;
import com.casosemergencias.util.datatables.DataTableProperties;

@Controller
public class ContactController {

	final static Logger logger = Logger.getLogger(LoginController.class);

	@Autowired
	private ContactService contactService;

	@RequestMapping(value = "/private/homeContacts", method = RequestMethod.GET)
	public ModelAndView listadoContactos() {

		logger.info("--- Inicio -- listadoContactos ---");

		ModelAndView model = new ModelAndView();
		model.setViewName("private/homeContactsPage");
	
		logger.info("--- Fin -- listadoContactos ---");
		
		return model;
	}

	@RequestMapping(value = "/private/entidadContacto", method = RequestMethod.GET)
	public ModelAndView getContactoData(@RequestParam String sfid) {
		System.out.println("Ejecutar consulta");
		ModelAndView model = new ModelAndView();		
		model.addObject("sfid", sfid);

		ContactView contactoView = new ContactView();		
		Contacto contactoBBDD = contactService.readContactoBySfid(sfid);
		if (contactoBBDD != null){
			ParserModelVO.parseDataModelVO(contactoBBDD, contactoView);
		}
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
	public @ResponseBody String listadoContactos(@RequestBody String body){
		
		logger.info("--- Inicio -- listadoSuministrosHome ---");
		
		DataTableProperties propDataTable = DataTableParser.parseBodyToDataTable(body);
		List<Contacto> listaContactos = new ArrayList<Contacto>();
		
		JSONObject jsonResult = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		
		listaContactos = contactService.readAllContactos(propDataTable);

		for (Contacto contacto : listaContactos) {
			jsonResult = new JSONObject();
			jsonResult.put("name", contacto.getName());
			jsonResult.put("account__run__c", contacto.getAccountRun());
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
		
		logger.info("--- Fin -- listadoSuministrosHome ---");
		
		return jsonObject.toString();
	}
}
