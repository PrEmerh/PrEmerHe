package com.casosemergencias.util.constants;

public class Constantes {

	//Mensajes Login
	public static final String MSG_NO_USER = "error_noUser";
	public static final String MSG_NO_USER_PASS = "error_noUserPass";
	public static final String MSG_EMAIL_ENVIADO = "reset_message_email";
	public static final String MSG_CHANGED_PASS = "changePass_message_changed";
	
	//Mensajes error
	public static final String MSG_NO_SERVICE = "error_noServicioDisponible";
	public static final String MSG_ERROR_BBDD = "error_problemasBBDD";
	
	//Modo edición
	public static final String EDIT_MODE_INSERT = "INSERT";
	public static final String EDIT_MODE_UPDATE = "UPDATE";
	public static final String EDIT_MODE_VIEW = "VIEW";
	public static final String EDIT_MODE_UPDATED_OK = "UPDATED_OK";
	public static final String EDIT_MODE_UPDATED_ERROR = "UPDATED_ERROR";
	public static final String EDIT_MODE_INSERTED_OK = "INSERTED_OK";
	
	//Modo creación
	
	public static final String CREATED_MODE_CREATED_OK = "CREATED_OK";
	public static final String CREATED_MODE_CREATED_ERROR = "CREATED_ERROR";
	
	//PcikLists
	//Caso
	public static final String PICKLIST_CASO_DEFAULT = "Default";
	public static final String PICKLIST_CASO_STATUS = "Status";
	public static final String PICKLIST_CASO_SUBSTATUS = "Sub_Estado__c";
	public static final String PICKLIST_CASO_PETICION = "Petici_n__c";
	public static final String PICKLIST_CASO_ORIGIN = "Origin";
	public static final String PICKLIST_CASO_CALLCENTER = "Call_Center__c";
	public static final String PICKLIST_CASO_PETICION_EMERGENCIA_NAME = "Emergencia";
	public static final String PICKLIST_CASO_SUBMOTIVO = "Motivo_Empresa__c";
	public static final String PICKLIST_CASO_CONDICION_AGRAVANTE = "Condici_n_agravante__c";
	public static final String PICKLIST_CASO_CANAL_NOTIFICACION = "Canal_de_notificaciOn__c";
	public static final String PICKLIST_CASO_FAVORABILIDAD = "Favorabilidad_del_Caso__c";
	
	//
	//Case Object
	public static final String COD_CASO_ORIGEN_WEB = "CAN001";
	public static final String COD_CASO_ORIGEN_WEB_DESC = "Web";
	public static final String COD_CASO_ORIGEN_CALL_CENTER = "CAN005";
	public static final String COD_CASO_ORIGEN_CALL_CENTER_DESC = "Call Center";
	public static final String COD_CASO_TYPE_RECLAMO = "TIP001";
	public static final String COD_CASO_TYPE_RECLAMO_DESC = "Reclamo";
	public static final String COD_CASO_STATUS_INGRESADO = "ESTA001";
	public static final String COD_CASO_STATUS_CERRADO = "ESTA007";
	public static final String COD_CASO_STATUS_CANCELADO = "ESTA008";
	public static final String COD_CASO_SUBMOTIVO_CORTE_DEUDA="FA001";
	public static final String COD_CASO_SUBMOTIVO_CORTE_PROGRAMADO ="FA002";
	public static final String COD_CASO_MOTIVO_EMERGENCIA ="MOT001";
	public static final String COD_CASO_DESC_DEUDA="Se informa a Cliente que corte de suministro es por deuda comercial";			
	public static final String COD_CASO_DESC_PROGRAMADO="Se informa a cliente que corte de suministro es por una mantención programada ";	
	public static final String COD_CASO_SUBSTATUS_COMUNICACION_INTERRUMPIDA = "CI";	
	public static final String COD_CASO_SUBSTATUS_PRUEBA_ERROR_INGRESO = "PEI";	
	public static final String COD_CASO_SUBSTATUS_ERROR_INGRESO = "EI";	
	public static final String COD_CASO_SUBSTATUS_VERIFICADO_OK = "si";
	public static final String COD_CASO_SUBSTATUS_COMUNICACION_INTERRUMPIDA_DESC = "Comunicación Interrumpida";
	public static final String COD_CASO_SUBSTATUS_PRUEBA_ERROR_INGRESO_DESC = "Prueba o Error de Ingreso";	
	public static final String COD_CASO_SUBSTATUS_ERROR_INGRESO_DESC = "Error de Ingreso";	
	public static final String COD_CASO_SUBSTATUS_CLIENTE_LUZ_DESC = "Cliente con Luz, por contacto recibido";
	
	
	//
	//Sesion SFID	
	public static final String SFID_SUMINISTRO= "sfidSuministro";
	public static final String SFID_CONTACTO= "sfidContacto";
	public static final String SFID_CUENTA= "sfidCuenta";
	public static final String SESSION_HEROKU_USER= "user";
	public static final String FINAL_DETAIL_PAGE= "paginaDetalleFinal";
	public static final String FINAL_DETAIL_PAGE_CUENTA = "CUENTA";
	public static final String FINAL_DETAIL_PAGE_CONTACTO = "CONTACTO";
	public static final String FINAL_DETAIL_PAGE_SUMINISTRO = "SUMINISTRO";
	
	//
	//HerokuUser, GMT constantes. (estas constantes las podemos ver 'TimeZone.getTimeZone("America/New_York");')
	public static final String ID_1CHILE = "America/Puerto_Rico"; //"Chile/Continental";
	public static final String ID_2PERU = "Brazil/East";
	public static final String ID_3COLOMBIA = "America/Bogota";
	public static final String ID_4BRASIL = "America/Lima"; 
	
}
