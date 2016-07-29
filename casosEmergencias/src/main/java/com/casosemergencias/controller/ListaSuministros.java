package com.casosemergencias.controller;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.casosemergencias.controller.views.SuministroView;
import com.casosemergencias.logic.SuministroService;
import com.casosemergencias.model.Suministro;
import com.casosemergencias.util.ParserModelVO;

@Controller
public class ListaSuministros {
	
	final static Logger logger = Logger.getLogger(ListaSuministros.class);
	
	@Autowired
	private SuministroService suministroService;
	
	@RequestMapping(value = "/private/listSuministros", method = RequestMethod.GET)
	public ModelAndView detalleSuministro() {
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
		
		return model;
	}
	
	

}
