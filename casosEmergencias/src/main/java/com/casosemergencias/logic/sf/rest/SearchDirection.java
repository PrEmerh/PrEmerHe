package com.casosemergencias.logic.sf.rest;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import com.casosemergencias.exception.EmergenciasException;
import com.casosemergencias.logic.sf.response.SearchDirectionResponse;
import com.casosemergencias.model.Caso;
import com.casosemergencias.model.UserSessionInfo;
import com.casosemergencias.util.constants.ConstantesError;
import com.casosemergencias.util.constants.ConstantesSalesforceLogin;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SearchDirection {
final static Logger logger = Logger.getLogger(CreateCase.class);
	
	public static SearchDirectionResponse createCaseInSalesforce(UserSessionInfo userSessionInfo, Caso caseToInsert) throws EmergenciasException {
		SearchDirectionResponse searchDirectionResponse = null;
		HttpClient httpClient = null;
		HttpPost post = null;
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			if (userSessionInfo.getSessionId() != null) {
				logger.trace("Inicio buscar direcciono");
				httpClient = HttpClientBuilder.create().build();
				post = new HttpPost(ConstantesSalesforceLogin.DEV_LOGIN_SALESFORCE_INSTANCE_URL/* + ConstantesSalesforceLogin.DEV_LOGIN_SALESFORCE_REST_SERVICE_SEARCH_DIRECTION_PATH_URI*/);
				post.setHeader(ConstantesSalesforceLogin.DEV_REST_SALESFORCE_AUTHORIZATION_HEADER_KEY, "Bearer " + userSessionInfo.getSessionId());
				post.setHeader(ConstantesSalesforceLogin.DEV_REST_SALESFORCE_CONTENT_TYPE_HEADER_KEY, ConstantesSalesforceLogin.DEV_REST_SALESFORCE_JSON_CONTENT_TYPE);
				post.setHeader(ConstantesSalesforceLogin.DEV_REST_SALESFORCE_ACCEPT_HEADER_KEY, ConstantesSalesforceLogin.DEV_REST_SALESFORCE_JSON_CONTENT_TYPE);
				
				//CasoSalesForce casoSalesforce = CasoSalesForce.copyFieldsFromHerokuToSalesForceCaseBean(caseToInsert);
				//String jsonInString = mapper.writeValueAsString(casoSalesforce);
				String jsonInString = mapper.writeValueAsString(null);
				logger.info("Parseo JSON direccion: " + jsonInString);

				StringEntity params = new StringEntity(jsonInString, "UTF-8");
				post.setEntity(params);
				
				logger.info("Intento de llamada POST buscarDireccion");
				
				HttpResponse response = httpClient.execute(post);
				HttpEntity entity = response.getEntity();
				String entityResponse = EntityUtils.toString(entity);
				
				logger.info("Respuesta: " + entityResponse);
				logger.info("Status: " + response.getStatusLine());
				
//				createCaseResponse = mapper.readValue(entityResponse, CreateCaseResponse.class);
//				if (createCaseResponse != null && !"0".equals(createCaseResponse.getControlErrores().getCodigoError())) {
//					logger.error(ConstantesError.SALESFORCE_CASE_CREATION_ERROR);
//					logger.error("Codigo: " + createCaseResponse.getControlErrores().getCodigoError() + ". Mensaje: " + createCaseResponse.getControlErrores().getMensajeError());
//					throw new EmergenciasException(createCaseResponse.getControlErrores().getCodigoError(), createCaseResponse.getControlErrores().getMensajeError());
//				}
			} else {
				logger.error(ConstantesError.SALESFORCE_CASE_CREATION_ERROR + ". El sessionId es nulo.");
				throw new EmergenciasException(ConstantesError.EMERG_ERROR_CODE_002, ConstantesError.SALESFORCE_CASE_CREATION_ERROR);
			}
		} catch(Exception exception) {//Cambiar por IOException
			logger.error(ConstantesError.SALESFORCE_CASE_CREATION_ERROR, exception);
			throw new EmergenciasException(ConstantesError.EMERG_ERROR_CODE_002, ConstantesError.SALESFORCE_CASE_CREATION_ERROR);
		} finally {
			if (post != null) {
				post.releaseConnection();
			}
		}
		return searchDirectionResponse;
	}
}