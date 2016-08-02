package com.casosemergencias.controller;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.casosemergencias.controller.views.AccountView;
import com.casosemergencias.controller.views.ContactView;
import com.casosemergencias.dao.ContactVO;
import com.casosemergencias.logic.AccountService;
import com.casosemergencias.logic.ContactService;
import com.casosemergencias.model.Contacto;
import com.casosemergencias.model.Cuenta;
import com.casosemergencias.util.ParserModelVO;

@Controller
public class AccountController {
	
	final static Logger logger = Logger.getLogger(LoginController.class);
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value = "/private/homeCuentas", method = RequestMethod.GET)
	public ModelAndView listadoCuentas() {
		
		List<AccountView> listOfAccountHome= new ArrayList<AccountView>();
		List<Cuenta> listOfAccountsTable= accountService.listOfAccountsTable();
		AccountView accountview=null;
		
			for(Cuenta cuen:listOfAccountsTable){
				
				accountview=new AccountView();
				ParserModelVO.parseDataModelVO(cuen,accountview );			
				listOfAccountHome.add(accountview);
				
			}
		
		ModelAndView model = new ModelAndView();
		model.addObject("listaCuentas", listOfAccountHome);
		model.setViewName("private/homeCuentasPage");

		return model;
	}
	
	

}