package com.casosemergencias.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.casosemergencias.controller.views.CaseView;
import com.casosemergencias.controller.views.ContactView;
import com.casosemergencias.logic.CaseService;
import com.casosemergencias.logic.ContactService;
import com.casosemergencias.model.Caso;
import com.casosemergencias.model.Contacto;

public class CabeceraHomeController {
	
	final static Logger logger = Logger.getLogger(LoginController.class);
	
	@Autowired
	private ContactService contactService;
	private CaseService casoService;
	
	@RequestMapping(value = "/private/cabeceraHomePage", method = RequestMethod.GET)
	public ModelAndView listadosCabeceraHome() {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("/private/cabeceraHomePage");
		
		
		/*<------------------ Tabla Casos--------------------->*/
	
		List<CaseView> listCaseView = new ArrayList<CaseView>();
		List<Caso> listCasos = new ArrayList<Caso>();
		
		CaseView caseView = null;
		
		listCasos = casoService.readAllCase();
		for(Caso caso : listCasos){
			
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

		/*<----------------- Tabla Contactos ----------------->*/
				
		List<ContactView> listContactView= new ArrayList<ContactView>();
		List<Contacto> listOfContactsTable= contactService.listOfContactsTable();
				
		ContactView contactview=null;
		
			for(Contacto con:listOfContactsTable){
				
				contactview=new ContactView();			
				contactview.setId(con.getId());
				contactview.setSfid(con.getSfid());
				contactview.setName(con.getName());
				contactview.setAccountRun(con.getAccountRun());
				contactview.setPhone(con.getPhone());
				contactview.setEmail(con.getEmail());
				
				listContactView.add(contactview);
				
			}
		
		/*<--------------------------------------------------->*/
			
		model.addObject("listaCasos", listCaseView);	
		model.addObject("listaContactos", listContactView);
		model.setViewName("private/cabeceraHomePage");

		return model;
	}
	
	
	

}
