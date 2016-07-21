package com.casosemergencias.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.casosemergencias.logic.UserService;
import com.casosemergencias.model.User;
import com.casosemergencias.util.Constantes;


//En esta clase trabajaremos con el objeto UserView, cuanos llamemos al Servicio le tenemos que pasar un objeto User y nos devolvera uno User, pero aqui hay que usar el UserView
//Obj UserView tiene datos del usuario y datos que controlaran la pantalla, como por ejemplo mensajes
@Controller
public class LoginController {
	
	final static Logger logger = Logger.getLogger(LoginController.class);
	
	@Autowired
	private UserService userService;

	
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
	public ModelAndView welcomePage(@RequestParam("user") String username, @RequestParam("pass") String password, HttpServletRequest request, HttpServletResponse response) {

		logger.info("Inicio welcomePage, user: " +username +" password: " + password);
		
		ModelAndView model = new ModelAndView();
		userService.insertUser();
		
		User userView = userService.readUser(username,  password);

		if(userView != null && ((userView.getId() != null) && !"".equals(userView.getId()))){
			logger.info("Usuario y contraseña correctas ");
			
			HttpSession session = request.getSession(true);
			session.setAttribute("user", userView);
			
			model.addObject("title", "Heroku Hello World");
			model.addObject("name",  userView.getName());
			model.setViewName("private/hello");
		}else{
			logger.info("No existe el usuario");
			model.addObject("loginNoUser", Constantes.MSG_NO_IS_USER);
			model.setViewName("loginPage");
		}
	
		return model;

	}

	/**
	 * Metodo que nos lleva a la pagina inicial
	 * */
	@RequestMapping(value={"/"}, method = RequestMethod.GET)
	public ModelAndView inicio(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView();
		model.setViewName("loginPage");
		return model;
	}
	
	


}
