package com.casosemergencias.util.constants;

public class ConstantesError {
	/** Codigos de error a mostrar en caso de error. */
	public static final String EMERG_ERROR_CODE_001 = "HRK_LOGIN_SF";
	public static final String EMERG_ERROR_CODE_002 = "HRK_CREATE_CASE_SF";
	public static final String EMERG_ERROR_CODE_003 = "HRK_CREATE_CASE_HRK";
	
	/** Mensajes de error a mostrar en caso de error. */
	public static final String SALESFORCE_LOGIN_ERROR = "Error conectando con Salesforce";
	public static final String SALESFORCE_CASE_CREATION_ERROR = "Error creando el caso en SalesForce";
	public static final String HEROKU_CASE_CREATION_ERROR = "Error creando el caso en Heroku";
	public static final String HEROKU_CASE_CREATION_OK_WITH_ERROR = "Se ha insertado el caso con problemas durante el guardado. Espere unos minutos en consultarlo y si no aparece, consulte con el administrador";
}