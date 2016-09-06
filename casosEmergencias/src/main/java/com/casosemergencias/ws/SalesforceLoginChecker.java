package com.casosemergencias.ws;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.casosemergencias.logic.UserSessionInfoService;
import com.casosemergencias.model.UserSessionInfo;
import com.casosemergencias.util.constants.ConstantesBatch;
import com.casosemergencias.util.constants.ConstantesSalesforceLogin;
import com.force.api.ApiSession;
import com.force.api.ForceApi;

public class SalesforceLoginChecker {
	final static Logger logger = Logger.getLogger(SalesforceLoginChecker.class);

	@Autowired
	private UserSessionInfoService userSessionInfoService;
	
	/**
	 * M&eacute;todo que obtiene la información de sesión de un usuario.
	 * 
	 * @param username
	 *            Nombre del usuario.
	 * @param password
	 *            Contrase&ntilde;a del usuario.
	 * @param token
	 *            Token de conexi&oacute;n del usuario.
	 * @return UserSessionInfo Datos de la sesi&oacute;n del usuario.
	 */
	public UserSessionInfo getUserSessionInfo (String username, String password, String token) {
		logger.trace("Entrando en getUserSessionInfo() para obtener los datos de sesión del usuario");
		
		UserSessionInfo userSessionInfo = new UserSessionInfo();
		
		// Se comprueba que el usuario exista en BBDD.
		userSessionInfo.setUsername(username);
		userSessionInfo.setPassword(password);
		userSessionInfo.setAccessToken(token);
		userSessionInfo = userSessionInfoService.readUserSessionInfo(userSessionInfo);
		
		if (userSessionInfo != null) {
			//Si el usuario existe, se comprueba si la fecha de conexión es mayor o menor de 12 horas.
			if (!isValidToken(userSessionInfo.getLastConnection())) {
				// Si la fecha es mayor de 12 horas, se hace login, y se actualiza la información en BBDD antes de devolver los datos del usuario.
				userSessionInfo = salesforceLogin(userSessionInfo.getUsername(), userSessionInfo.getPassword(), userSessionInfo.getAccessToken());
				userSessionInfoService.updateUserSessionInfo(userSessionInfo);
			}
		} else {
			// Si el usuario no existe, se hace login, se guardan en BBDD y se devuelven los datos del usuario.
			userSessionInfo = salesforceLogin(username, password, token);
			userSessionInfoService.insertUserSessionInfo(userSessionInfo);
		}
		
		logger.trace("Saliendo de getUserSessionInfo()");
		return userSessionInfo;
	}	
	
	/**
	 * M&eatuce;todo que realiza el login contra SalesForce.
	 * 
	 * @param username
	 *            Usuario con el que hacer el login.
	 * @param password
	 *            Contrase&ntilde;a del usuario.
	 * @return UserSessionInfo Datos del usuario conectado.
	 */
	public UserSessionInfo salesforceLogin(String username, String password, String token) {
		logger.trace("Entrando a salesforceLogin() para hacer el login contra SalesForce");
		
		UserSessionInfo userSessionInfo = null;
		String tokenRequestUri = ConstantesSalesforceLogin.DEV_LOGIN_SALESFORCE_LOGIN_URI + ConstantesSalesforceLogin.DEV_LOGIN_SALESFORCE_TOKEN_PATH_URI; 
		HttpClient httpclient = new HttpClient();
		PostMethod post = new PostMethod(tokenRequestUri);
		
		post.addParameter(ConstantesSalesforceLogin.DEV_LOGIN_SALESFORCE_GRANT_TYPE_KEY, ConstantesSalesforceLogin.DEV_LOGIN_SALESFORCE_GRANT_TYPE_VALUE);
		post.addParameter(ConstantesSalesforceLogin.DEV_LOGIN_SALESFORCE_CLIENT_ID_KEY, ConstantesSalesforceLogin.DEV_LOGIN_SALESFORCE_CLIENT_ID_VALUE);
		post.addParameter(ConstantesSalesforceLogin.DEV_LOGIN_SALESFORCE_CLIENT_SECRET_KEY, ConstantesSalesforceLogin.DEV_LOGIN_SALESFORCE_CLIENT_SECRET_VALUE);
		//post.addParameter(ConstantesSalesforceLogin.DEV_LOGIN_SALESFORCE_REDIRECT_URI_KEY, ConstantesSalesforceLogin.DEV_LOGIN_SALESFORCE_REDIRECT_URI);
		post.addParameter(ConstantesSalesforceLogin.DEV_LOGIN_SALESFORCE_USER_NAME_KEY, username);
		post.addParameter(ConstantesSalesforceLogin.DEV_LOGIN_SALESFORCE_USER_PASS_KEY, password + token);
		
		try {
			logger.info("Intento de llamada POST al servicio " + tokenRequestUri + " para obtener el sessionId del usuario");
			logger.info("Petición: " + post.getRequestEntity());
			
			httpclient.executeMethod(post);
			
			InputStreamReader inputStreamReader = new InputStreamReader(post.getResponseBodyAsStream());
			JSONTokener jsonTokener = new JSONTokener(inputStreamReader);
			JSONObject authResponse = new JSONObject(jsonTokener);

			logger.info("Respuesta: " + authResponse.toString(2));

			Date currentDate = new Date();
			userSessionInfo = new UserSessionInfo();
			userSessionInfo.setUsername(username);
			userSessionInfo.setPassword(password);
			userSessionInfo.setAccessToken(token);
			userSessionInfo.setSessionId(authResponse.getString(ConstantesSalesforceLogin.DEV_LOGIN_SALESFORCE_ACCESS_TOKEN_KEY));
			userSessionInfo.setLastConnection(currentDate);
			
			logger.info("Id de sesión: " + userSessionInfo.getSessionId());
			logger.info("Hora de conexión: " + userSessionInfo.getLastConnection());
		} catch (JSONException jsonException) {
			logger.error("Error realizando el login en SalesForce: ", jsonException);
		} catch (HttpException httpException) {
			logger.error("Error realizando el login en SalesForce: ", httpException);
		} catch (IOException ioException) {
			logger.error("Error realizando el login en SalesForce: ", ioException);
		} finally {
			post.releaseConnection();
		}
		return userSessionInfo;
	}
	
	public ForceApi getSalesforceApi(String username, String password, String token){
		ForceApi api = null;
		logger.trace("Intentamos recuperar los datos o hacemos login.");
		UserSessionInfo datosSesion = this.getUserSessionInfo(username, password, token);
		if (datosSesion != null && !StringUtils.isEmpty(datosSesion.getSessionId())){
			logger.trace("Login correcto.");
			ApiSession s = new ApiSession();
			s.setAccessToken(datosSesion.getSessionId());
			s.setApiEndpoint(ConstantesSalesforceLogin.DEV_LOGIN_SALESFORCE_INSTANCE_URL);
			api = new ForceApi(s);
		}
		return api;
	}

	
	/**
	 * M&eacute;todo que comprueba si la &uacute;ltima fecha de conexi&oacute;n
	 * del usuario es anterior al tiempo de caducidad del token en SalesForce.
	 * 
	 * @param lastConnectionDate
	 *            Fecha de &uacute;ltima conexi&oacute;n del usuario.
	 * @return boolean Se devolv&aacute; un valor <i>true</i> si el token es
	 *         v&aacutelido todav&iacute;a y un valor <i>false</i> si ha
	 *         caducado.
	 */
	private boolean isValidToken(Date lastConnectionDate) {
		logger.trace("Entrando en checkLastConnecionDate() para comprobar el tiempo que ha pasado desde la última conexión");
		
		boolean isValidToken = false;
		Date currentDate = new Date();
		
		logger.info("Fecha de última conexión: " + lastConnectionDate);
		logger.info("Fecha actual: " + currentDate);
				
		long duration  = currentDate.getTime() - lastConnectionDate.getTime();
		long diffInHours = TimeUnit.MILLISECONDS.toHours(duration);

		logger.info("Diferencia en horas: " + diffInHours);
		
		if (diffInHours < 12) {
			isValidToken = true;
		}
		
		logger.trace("Saliendo de checkLastConnecionDate()");
		
		return isValidToken;
	}
}