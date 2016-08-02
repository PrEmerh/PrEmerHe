package com.casosemergencias.controller;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.casosemergencias.controller.views.ContactView;
import com.casosemergencias.dao.ContactVO;
import com.casosemergencias.logic.ContactService;
import com.casosemergencias.model.Contacto;
import com.casosemergencias.util.ParserModelVO;

@Controller
public class ContactController {
	
	final static Logger logger = Logger.getLogger(LoginController.class);
	
	@Autowired
	private ContactService contactService;
	
	@RequestMapping(value = "/private/homeContacts", method = RequestMethod.GET)
	public ModelAndView listadoContactos() {
		
		List<ContactView> listOfContactHome= new ArrayList<ContactView>();
		List<Contacto> listOfContactsTable= contactService.listOfContactsTable();
		ContactView contactview=null;
		
			for(Contacto con:listOfContactsTable){
				
				contactview=new ContactView();
				ParserModelVO.parseDataModelVO(con,contactview );					
				listOfContactHome.add(contactview);
				
			}
		
		ModelAndView model = new ModelAndView();
		model.addObject("listaContactos", listOfContactHome);
		model.setViewName("private/homeContactsPage");

		return model;
	}
	
	

}
