package com.casosemergencias.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.casosemergencias.controller.views.DireccionView;
import com.casosemergencias.logic.DireccionService;
import com.casosemergencias.model.Direccion;

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
				
				direccionview.setName(dir.getName());
				direccionview.setCalle(dir.getCalle());
				direccionview.setNumero(dir.getNumero());
				direccionview.setComuna(dir.getComuna());
				direccionview.setDireccionConcatenada(dir.getDireccionConcatenada());

			
				listOfDireccionHome.add(direccionview);
				
			}
		
		ModelAndView model = new ModelAndView();
		model.addObject("listaDirecciones", listOfDireccionHome);
		model.setViewName("private/homeDireccionesPage");

		return model;
	}
	

}
