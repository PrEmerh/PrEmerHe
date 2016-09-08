package com.casosemergencias.logic.sf.rest;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import com.casosemergencias.logic.sf.bean.CasoSalesForce;
import com.casosemergencias.logic.sf.response.CreateCaseResponse;
import com.casosemergencias.model.Caso;
import com.casosemergencias.model.UserSessionInfo;
import com.casosemergencias.util.constants.ConstantesSalesforceLogin;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CreateCase {
	final static Logger logger = Logger.getLogger(CreateCase.class);
	
	public static CreateCaseResponse createCaseInSalesforce(UserSessionInfo userSessionInfo, Caso caseToInsert) {		
		CreateCaseResponse createCaseResponse = null;
		HttpClient httpClient = null;
		HttpPost post = null;
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			if (userSessionInfo.getSessionId() != null) {
				logger.trace("Inicio crear caso");
				httpClient = HttpClientBuilder.create().build();
				post = new HttpPost(ConstantesSalesforceLogin.DEV_LOGIN_SALESFORCE_INSTANCE_URL + ConstantesSalesforceLogin.DEV_LOGIN_SALESFORCE_REST_SERVICE_NEW_CASE_PATH_URI);
				post.setHeader(ConstantesSalesforceLogin.DEV_REST_SALESFORCE_AUTHORIZATION_HEADER_KEY, "Bearer " + userSessionInfo.getSessionId());
				post.setHeader(ConstantesSalesforceLogin.DEV_REST_SALESFORCE_CONTENT_TYPE_HEADER_KEY, ConstantesSalesforceLogin.DEV_REST_SALESFORCE_JSON_CONTENT_TYPE);
				post.setHeader(ConstantesSalesforceLogin.DEV_REST_SALESFORCE_ACCEPT_HEADER_KEY, ConstantesSalesforceLogin.DEV_REST_SALESFORCE_JSON_CONTENT_TYPE);
				
				CasoSalesForce casoSalesforce = CasoSalesForce.copyFieldsFromHerokuToSalesForceCaseBean(caseToInsert);
				String jsonInString = mapper.writeValueAsString(casoSalesforce);
				logger.info("Parseo JSON caso: " + jsonInString);

				StringEntity params = new StringEntity(jsonInString);
				post.setEntity(params);
				
				logger.info("Intento de llamada POST crearCaso");
				
				HttpResponse response = httpClient.execute(post);
				HttpEntity entity = response.getEntity();
				String entityResponse = EntityUtils.toString(entity);
				
				logger.info("Respuesta: " + entityResponse);
				logger.info("Status: " + response.getStatusLine());

				createCaseResponse = mapper.readValue(entityResponse, CreateCaseResponse.class);				
			}
		} catch (Exception exception) {
			logger.error("Error en la llamada al servicio REST de SalesForce: " + exception);
		} finally {
			if (post != null ) {
				post.releaseConnection();
			}
		}
		
		return createCaseResponse;
	}
}