package com.casosemergencias.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.casosemergencias.controller.views.CaseView;
import com.casosemergencias.controller.views.DireccionView;
import com.casosemergencias.logic.DireccionService;
import com.casosemergencias.model.Caso;
import com.casosemergencias.model.Direccion;
import com.casosemergencias.util.ParserModelVO;

@Controller
public class DireccionController {
	
	final static Logger logger = Logger.getLogger(LoginController.class);
	
	@Autowired
	private DireccionService direccionService;
	
	@RequestMapping(value = "/private/homeDirecciones", method = RequestMethod.GET)
	public ModelAndView listadoDirecciones() {
		
		List<DireccionView> listOfDireccionHome= new ArrayList<DireccionView>();
		List<Direccion> listOfDireccionesTable= direccionService.listOfDireccionesTable();
		DireccionView direccionview=null;
		
			for(Direccion dir:listOfDireccionesTable){
				
				direccionview=new DireccionView();				
				ParserModelVO.parseDataModelVO(dir,direccionview );	
				listOfDireccionHome.add(direccionview);
				
			}
		
		ModelAndView model = new ModelAndView();
		model.addObject("listaDirecciones", listOfDireccionHome);
		model.setViewName("private/homeDireccionesPage");

		return model;
	}
	
	@RequestMapping(value = "/private/entidadDireccion", method = RequestMethod.GET)
	public ModelAndView getDireccionData(@RequestParam String sfid) {
		System.out.println("Ejecutar consulta");
		ModelAndView model = new ModelAndView();		
		model.addObject("sfid", sfid);

		DireccionView direccionView = new DireccionView();		
		Direccion direccionBBDD = direccionService.readDireccionBySfid(sfid);
		if (direccionBBDD != null){
			ParserModelVO.parseDataModelVO(direccionBBDD, direccionView);
		}
		model.setViewName("private/entidadDireccionPage");
		model.addObject("direccion", direccionView);
		
		return model;
	}
	
	

}
