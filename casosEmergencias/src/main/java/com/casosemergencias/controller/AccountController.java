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

import com.casosemergencias.controller.views.AccountView;
import com.casosemergencias.logic.AccountService;
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
	
	/**
	 * Método que obtiene los datos de una cuenta a partir de su id. y los
	 * devuelve a la página.
	 * 
	 * @param sfid
	 *            Identificador de la cuenta.
	 * @return ModelAndView Datos de la cuenta a mostrar en la página.
	 */
	@RequestMapping(value = "/private/entidadCuenta", method = RequestMethod.GET)
	public ModelAndView getAccountData(@RequestParam String sfid) {
		logger.trace("Detalle de cuenta");
		AccountView cuentaView = new AccountView();
		ModelAndView model = new ModelAndView();
		Cuenta cuentaBBDD = accountService.getAccountBySfid(sfid);
		
		if (cuentaBBDD != null) {
			ParserModelVO.parseDataModelVO(cuentaBBDD, cuentaView);
		}
		
		model.addObject("sfid", sfid);
		model.setViewName("private/entidadCuentaPage");
		model.addObject("cuenta", cuentaView);
		return model;
	}

}