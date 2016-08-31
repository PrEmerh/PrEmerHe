package com.casosemergencias.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.casosemergencias.controller.views.UserView;
import com.casosemergencias.logic.HerokuUserService;
import com.casosemergencias.model.HerokuUser;
import com.casosemergencias.util.constants.Constantes;


/**
 * @author mcasas
 * 
 *Clase encargada de controlar las peticiones de la pantalla login.
 *En esta clase utilizaremos el objeto UserView, pero cuando llamemos al Servicio le tendremos que pasar un objeto User.
 *Objetos UserView, son objetos que controlan la pantalla Login
 */
@Controller
public class LoginController {
	
	final static Logger logger = Logger.getLogger(LoginController.class);
	
	@Autowired
	private HerokuUserService userService;
	
	
	/**
	 * Metodo al que se accede tras hacer submit en el login. Si el usuario existe nos lleva al jsp Hello y se guarda un User en session.
	 * Si el usuario no existe, se muestra en mensaje en la pagina login.
	 * 
	 * @param username
	 * @param password
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	public ModelAndView loginOk(@ModelAttribute("userView") UserView userView, HttpServletRequest request, HttpServletResponse response) {

		logger.info("--- Inicio -- loginOk -- user: " +userView.getUser() + " ---");
		
		ModelAndView model = new ModelAndView();
		
		HerokuUser user = userService.readUserPass(userView.getUser(),  userView.getPass());

		if(user != null && ((user.getId() != null) && !"".equals(user.getId()))){
			logger.info("--- Usuario y contraseña correctas ---");
			
			//Guardamos el usuario en la sesion
			HttpSession session = request.getSession(true);
			session.setAttribute("user", user);			

			model.setViewName("redirect:private/homeCasos");

		}else{
			logger.info("No existe el usuario");
			userView.setMensajeError(Constantes.MSG_NO_USER_PASS);
			model.addObject(userView);
			model.setViewName("loginPage");
		}
	
		logger.info("--- Fin -- loginOk  ---");
		return model;

	}
	
	/*----- metodos que solo sirven para la navegacion de paginas, no realizan operaciones -----*/
	/**
	 * Metodo que nos lleva a la pagina inicial
	 * 
	 *  @return
	 */
	@RequestMapping(value={"/"}, method = RequestMethod.GET)
	public ModelAndView goInicio(HttpServletRequest request, HttpServletResponse response) {
		
		logger.info("--- inicio ---");
		ModelAndView model = new ModelAndView();
		model.setViewName("loginPage");
		return model;
		
	}
	
	@RequestMapping(value = { "/logout" }, method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		logger.info("--- Inicio -- logout ---");
		
		ModelAndView model = new ModelAndView();
		HttpSession session = request.getSession(true);		
		session.setAttribute("user", null);			
		session.invalidate();
		
		model.setViewName("loginPage");
		
		logger.info("--- Fin -- logout ---");
		return model;
	}
}
