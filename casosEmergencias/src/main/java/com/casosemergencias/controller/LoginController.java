package com.casosemergencias.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.casosemergencias.controller.views.UserView;
import com.casosemergencias.logic.ContactService;
import com.casosemergencias.logic.UserService;
import com.casosemergencias.model.User;
import com.casosemergencias.util.Constantes;


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
	public ModelAndView loginOk(@ModelAttribute("userView") UserView userView, HttpServletRequest request, HttpServletResponse response) {

		logger.info("--- Inicio -- loginOk -- user: " +userView.getUser() +" password: " + userView.getPass() + " ---");
		
		ModelAndView model = new ModelAndView();
		
		User user = userService.readUserPass(userView.getUser(),  userView.getPass());

		if(user != null && ((user.getId() != null) && !"".equals(user.getId()))){
			logger.info("--- Usuario y contraseña correctas ---");
			
			//Guardamos el usuario en la sesion
			HttpSession session = request.getSession(true);
			session.setAttribute("user", user);			
//			model.addObject("title", "Heroku Hello World");
//			model.addObject("name",  user.getName());
//			model.setViewName("private/hello");
			model.setViewName("redirect: tableOfContacts");
		}else{
			logger.info("No existe el usuario");
			userView.setMensajeError(Constantes.MSG_NO_USER_PASS);
			model.addObject(userView);
			model.setViewName("loginPage");
		}
	
		logger.info("--- Fin -- loginOk  ---");
		return model;

	}

	/**
	 * Tras recoger de pantalla un el userName, se comprueba que exista en BBDD un HerokuUser con ese usuario.
	 * Si el existe, se pone a true el campo enviarEmail para que desde Salesforce se active un trigger que enviará un email al usuario para que pueda cambiar la contraseña.
	 * 
	 * @param userEmail Usuario o email recogido del formulario de resetPassPage.jsp
	 * @return
	 */
	@RequestMapping(value = {"/sendEmail"}, method = RequestMethod.POST)
	public ModelAndView sendEmailForChangePass(@RequestParam("userName") String userName) {
		
		User user = new User();
		UserView userView = new UserView();
		
		ModelAndView model = new ModelAndView();
		model.setViewName("resetPassPage");
		userService.insertUser();
		user = this.userService.readUser(userName);
		
		if(user != null && ((user.getId() != null) && !"".equals(user.getId()))){
			//Existe un usuario con el userName --> ponemos a true el campo enviarEmail
			logger.info("--- Existe un HerokuUser con userName: " + userName);
			
			if(user.isEnvioEmail()){
				//Ya se ha enviado un email pero la BBDD no se ha sincronizado con Salesforce. Tenemos que esperar para poder volver a enviar otro email
				userView.setMensajeError(Constantes.MSG_NO_SERVICE);
				
			}else{
				boolean envioEmail = this.userService.changeEnvioEmail(user); 
				
				if(envioEmail){
					userView.setEmail(user.getEmail());
					userView.setMensaje(Constantes.MSG_EMAIL_ENVIADO);
				}else{
					logger.debug("--- Problemas al cambiar el campo envioEmail ---");
					userView.setMensajeError(Constantes.MSG_ERROR_BBDD);
				}
			}
			
		}else{
			//No existe ningun usuario con userName
			logger.info("--- NO existe un HerokuUser con userName: " + userName);
			userView.setMensajeError(Constantes.MSG_NO_USER);
		}

		model.addObject(userView);
		return model;
	
	}

	
	@RequestMapping(value = { "/goChangePassPage/changePass" }, method = RequestMethod.POST)
	public ModelAndView ChangePassPage(@ModelAttribute("userView") UserView userView) {
		
		ModelAndView model = new ModelAndView();
		
		boolean changePass = userService.changePassHerokuUser(userView.getPass(), userView.getSfid());
		if(changePass){
			userView.setMensaje(Constantes.MSG_CHANGED_PASS);
		}else{
			userView.setMensajeError(Constantes.MSG_ERROR_BBDD);
		}
		
		model.addObject(userView);
		model.setViewName("changePassPage");
		
		return model;			

	}
	
	
	/*----- INICIO metodos que solo sirven para la navegacion de paginas, no realizan operaciones -----*/
	
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
	
	/**
	 * Nos lleva a la pagina resetPassPage.jsp para poder resetear la password
	 * 
	 * @return
	 */
	@RequestMapping(value = {"/resetPass"}, method = RequestMethod.GET)
	public String goResetPass() {
		
		logger.info("--- sendResetPass  ---");
		return "resetPassPage";	
		
	}
	
	/**
	 * Nos lleva a la pagina changePassPage.jsp para que el usuario pueda cambiar la password. 
	 * En el path tenemos que recuperar el sfid del usuario.
	 * 
	 * @param sfid - sfid del usuario que va a cambiar la password
	 * @return
	 */
	@RequestMapping(value = { "/goChangePassPage/{sfid}" }, method = RequestMethod.GET)
	public ModelAndView goChangePassPage(@PathVariable("sfid") String sfid) {
		
		ModelAndView model = new ModelAndView();
		UserView userView = new UserView();
		userView.setSfid(sfid);
		
		model.addObject(userView);
		model.setViewName("changePassPage");
		return model;	
	
	}


}
