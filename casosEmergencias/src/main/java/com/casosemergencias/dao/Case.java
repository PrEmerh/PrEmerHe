package com.casosemergencias.dao;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="salesforce.case")
public class Case implements Serializable{
	
	private static final long serialVersionUID = 1L;

	//campo de Heroku
	//Used to track the IsDeleted field from Salesforce allowing Heroku Connect to handle deletes when polling for updates
	@Column(name = "isdeleted")
	private Boolean isdeleted;
	//campo de Heroku
	//Used to track the IsDeleted field from Salesforce allowing Heroku Connect to handle deletes when polling for updates
	@Column(name = "systemmodstamp")
	private Date systemmodstamp;
	//campo de Heroku
	@Column(name = "_hc_lastop")
	private String _hc_lastop;
	//campo de Heroku
	@Column(name = "_hc_err")
	private String _hc_err;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "sfid")
	private String sfid;
	
	@Column(name = "createddate")
	private Date createddate;
	
	@Column(name = "subject")
	private String subject;
	
	@Column(name = "fecha_estimada_de_cierre__c")
	private Date fecha_estimada_de_cierre;
	
	@Column(name = "accountid")
	private String accountid;
	
	@Column(name = "favorabilidad_del_caso__c")
	private String favorabilidad_del_caso;
	
	@Column(name = "flag_sec__c")
	private String flag_sec;
	
	@Column(name = "lastmodifiedbyid")
	private String lastmodifiedbyid;
	
	@Column(name = "productid")
	private String productid;
	
	@Column(name = "validar_electrodependiente__c")
	private Boolean validar_electrodependiente;
	
	@Column(name = "sf4twitter__twitter_username__c")
	private String sf4twitter__twitter_username;
	
	@Column(name = "ownerid")
	private String ownerid;
	
	@Column(name = "slastartdate")
	private Date slastartdate;
	
	@Column(name = "motivo_empresa__c")
	private String motivo_empresa;
	
	@Column(name = "call_center__c")
	private String call_center;
	
	@Column(name = "fallo_envio_validacion__c")
	private Boolean fallo_envio_validacion;
	
	@Column(name = "literal_comuna__c")
	private String literal_comuna;
	
	@Column(name = "act_datos_contacto__c")
	private Boolean act_datos_contacto;
	
	@Column(name = "fallo_creacion_observacion__c")
	private String fallo_creacion_observacion;
	
	@Column(name = "estado_preingreso__c")
	private Boolean sfidestado_preingreso;
	
	@Column(name = "email_de_notificacion__c")
	private String email_de_notificacion;
	
	@Column(name = "horaap__c")
	private Double horaap;
	
	@Column(name = "numero_de_inservice__c")
	private String numero_de_inservice;
	
	@Column(name = "suppliedphone")
	private String suppliedphone;
	
	@Column(name = "numero_de_medidor__c")
	private String numero_de_medidor;
	
	@Column(name = "isstopped")
	private Boolean isstopped;
	
	@Column(name = "cuerpo_mail__c")
	private String cuerpo_mail;
	
	@Column(name = "telefono_de_contacto__c")
	private String telefono_de_contacto;
	
	@Column(name = "questionid")
	private String questionid;
	
	@Column(name = "hasselfservicecomments")
	private Boolean hasselfservicecomments;
	
	@Column(name = "traza_fallo_inservice__c")
	private String traza_fallo_inservice;
	
	@Column(name = "canal_de_notificacion__c")
	private String canal_de_notificacion;
	
	@Column(name = "createdbyid")
	private String createdbyid;
	
	@Column(name = "categor_a__c")
	private String categor_a;
	
	@Column(name = "flag__c")
	private String flag;
	
	@Column(name = "observaciones__c")
	private String observaciones;
	
	@Column(name = "casenumber")
	private String casenumber;
	
	@Column(name = "url__c")
	private String url;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "sf4twitter__twitterid__c")
	private String sf4twitter__twitterid;
	
	@Column(name = "respuesta_al_cliente__c")
	private String respuesta_al_cliente;
	
	@Column(name = "n_mero_de_caso_ap__c")
	private String n_mero_de_caso_ap;
	
	@Column(name = "isescalated")
	private Boolean isescalated;
	
	@Column(name = "interaccion__c")
	private String interaccion;
	
	@Column(name = "tipo_atencion_sec__c")
	private String tipo_atencion_sec;
	
	@Column(name = "sub_estado__c")
	private String sub_estado;
	
	@Column(name = "isvisibleinselfservice")
	private Boolean isvisibleinselfservice;
	
	@Column(name = "tipo_atencion_interna__c")
	private String tipo_atencion_interna;
	
	@Column(name = "hora_sec__c")
	private Date hora_sec;
	
	@Column(name = "pendientevalidacioncondagr__c")
	private Boolean pendientevalidacioncondagr;
	
	@Column(name = "ejecutivoanterior__c")
	private String ejecutivoanterior;
	
	@Column(name = "entitlementid")
	private String entitlementid;
	
	@Column(name = "assetid")
	private String assetid;
	
	@Column(name = "stopstartdate")
	private Date stopstartdate;
	
	@Column(name = "suppliedcompany")
	private String suppliedcompany;
	
	@Column(name = "isclosedoncreate")
	private Boolean isclosedoncreate;
	
	@Column(name = "estado_condici_n_agravante__c")
	private String estado_condici_n_agravante;
	
	@Column(name = "hora_cancelado__c")
	private Date hora_cancelado;
	
	@Column(name = "suministro__c")
	private String suministro;
	
	@Column(name = "isselfserviceclosed")
	private	Boolean isselfserviceclosed;
	
	@Column(name = "parentid")
	private String parentid;
	
	@Column(name = "ui__c")
	private Boolean ui;
	
	@Column(name = "numsum__c")
	private String numsum;
	
	@Column(name = "twitter__c")
	private String twitter;
	
	@Column(name = "suppliedname")
	private String suppliedname;
	
	@Column(name = "closeddate")
	private Date closeddate;
	
	@Column(name = "fallo_envio_inservice__c")
	private Boolean fallo_envio_inservice;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "hora_arribado__c")
	private Date hora_arribado;
	
	@Column(name = "slaexitdate")
	private Date slaexitdate;
	
	@Column(name = "origin")
	private String origin;
	
	@Column(name = "descripcion_estado__c")
	private String descripcion_estado;
	
	@Column(name = "businesshoursid")
	private String businesshoursid;
	
	@Column(name = "sf4twitter__author_external_id__c")
	private String sf4twitter__author_external_id;
	
	@Column(name = "hascommentsunreadbyowner")
	private Boolean hascommentsunreadbyowner;
	
	@Column(name = "hora_cerrado__c")
	private Date hora_cerrado;
	
	@Column(name = "literal_condici_n_agravante__c")
	private String literal_condici_n_agravante;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "direccion_del_suministro__c")
	private String direccion_del_suministro;
	
	@Column(name = "hora_pendiente__c")
	private Date hora_pendiente;
	
	@Column(name = "ani__c")
	private String ani;
	
	@Column(name = "facebook__c")
	private String facebook;
	
	@Column(name = "petici_n__c")
	private String petici_n;
	
	@Column(name = "communityid")
	private String communityid;
	
	@Column(name = "direccion__c")
	private String direccion;
	
	@Column(name = "hora_asignado__c")
	private Date hora_asignado;
	
	@Column(name = "milestonestatus")
	private String milestonestatus;
	
	@Column(name = "contactid")
	private String contactid;
	
	@Column(name = "hora_predespacho__c")
	private Date hora_predespacho;
	
	@Column(name = "hora_enruta__c")
	private Date hora_enruta;
	
	@Column(name = "reason")
	private String reason;
	
	@Column(name = "id_empresa__c")
	private String id_empresa;
	
	@Column(name = "hora_programado__c")
	private Date hora_programado;
	
	@Column(name = "numero_de_seguidores_del__c")
	private Double numero_de_seguidores_del;
	
	@Column(name = "literal_categoria__c")
	private String literal_categorias;
	
	@Column(name = "recordtypeid")
	private String recordtypeid;
	
	@Column(name = "comuna_f__c")
	private String comuna_f;
	
	@Column(name = "prioridad__c")
	private String prioridad;
	
	@Column(name = "valorsubestadoins__c")
	private String valorsubestadoins;
	
	@Column(name = "control_electrodependiente__c")
	private Boolean control_electrodependiente;
	
	@Column(name = "cancelar__c")
	private Boolean cancelar;
	
	@Column(name = "condici_n_agravante__c")
	private String condici_n_agravante;

	public Case(Boolean isdeleted, Date systemmodstamp, String _hc_lastop, String _hc_err, Integer id, String sfid,
			Date createddate, String subject, Date fecha_estimada_de_cierre, String accountid,
			String favorabilidad_del_caso, String flag_sec, String lastmodifiedbyid, String productid,
			Boolean validar_electrodependiente, String sf4twitter__twitter_username, String ownerid, Date slastartdate,
			String motivo_empresa, String call_center, Boolean fallo_envio_validacion, String literal_comuna,
			Boolean act_datos_contacto, String fallo_creacion_observacion, Boolean sfidestado_preingreso,
			String email_de_notificacion, Double horaap, String numero_de_inservice, String suppliedphone,
			String numero_de_medidor, Boolean isstopped, String cuerpo_mail, String telefono_de_contacto,
			String questionid, Boolean hasselfservicecomments, String traza_fallo_inservice,
			String canal_de_notificacion, String createdbyid, String categor_a, String flag, String observaciones,
			String casenumber, String url, String status, String sf4twitter__twitterid, String respuesta_al_cliente,
			String n_mero_de_caso_ap, Boolean isescalated, String interaccion, String tipo_atencion_sec,
			String sub_estado, Boolean isvisibleinselfservice, String tipo_atencion_interna, Date hora_sec,
			Boolean pendientevalidacioncondagr, String ejecutivoanterior, String entitlementid, String assetid,
			Date stopstartdate, String suppliedcompany, Boolean isclosedoncreate, String estado_condici_n_agravante,
			Date hora_cancelado, String suministro, Boolean isselfserviceclosed, String parentid, Boolean ui,
			String numsum, String twitter, String suppliedname, Date closeddate, Boolean fallo_envio_inservice,
			String description, Date hora_arribado, Date slaexitdate, String origin, String descripcion_estado,
			String businesshoursid, String sf4twitter__author_external_id, Boolean hascommentsunreadbyowner,
			Date hora_cerrado, String literal_condici_n_agravante, String type, String direccion_del_suministro,
			Date hora_pendiente, String ani, String facebook, String petici_n, String communityid, String direccion,
			Date hora_asignado, String milestonestatus, String contactid, Date hora_predespacho, Date hora_enruta,
			String reason, String id_empresa, Date hora_programado, Double numero_de_seguidores_del,
			String literal_categorias, String recordtypeid, String comuna_f, String prioridad, String valorsubestadoins,
			Boolean control_electrodependiente, Boolean cancelar, String condici_n_agravante) {
		super();
		this.isdeleted = isdeleted;
		this.systemmodstamp = systemmodstamp;
		this._hc_lastop = _hc_lastop;
		this._hc_err = _hc_err;
		this.id = id;
		this.sfid = sfid;
		this.createddate = createddate;
		this.subject = subject;
		this.fecha_estimada_de_cierre = fecha_estimada_de_cierre;
		this.accountid = accountid;
		this.favorabilidad_del_caso = favorabilidad_del_caso;
		this.flag_sec = flag_sec;
		this.lastmodifiedbyid = lastmodifiedbyid;
		this.productid = productid;
		this.validar_electrodependiente = validar_electrodependiente;
		this.sf4twitter__twitter_username = sf4twitter__twitter_username;
		this.ownerid = ownerid;
		this.slastartdate = slastartdate;
		this.motivo_empresa = motivo_empresa;
		this.call_center = call_center;
		this.fallo_envio_validacion = fallo_envio_validacion;
		this.literal_comuna = literal_comuna;
		this.act_datos_contacto = act_datos_contacto;
		this.fallo_creacion_observacion = fallo_creacion_observacion;
		this.sfidestado_preingreso = sfidestado_preingreso;
		this.email_de_notificacion = email_de_notificacion;
		this.horaap = horaap;
		this.numero_de_inservice = numero_de_inservice;
		this.suppliedphone = suppliedphone;
		this.numero_de_medidor = numero_de_medidor;
		this.isstopped = isstopped;
		this.cuerpo_mail = cuerpo_mail;
		this.telefono_de_contacto = telefono_de_contacto;
		this.questionid = questionid;
		this.hasselfservicecomments = hasselfservicecomments;
		this.traza_fallo_inservice = traza_fallo_inservice;
		this.canal_de_notificacion = canal_de_notificacion;
		this.createdbyid = createdbyid;
		this.categor_a = categor_a;
		this.flag = flag;
		this.observaciones = observaciones;
		this.casenumber = casenumber;
		this.url = url;
		this.status = status;
		this.sf4twitter__twitterid = sf4twitter__twitterid;
		this.respuesta_al_cliente = respuesta_al_cliente;
		this.n_mero_de_caso_ap = n_mero_de_caso_ap;
		this.isescalated = isescalated;
		this.interaccion = interaccion;
		this.tipo_atencion_sec = tipo_atencion_sec;
		this.sub_estado = sub_estado;
		this.isvisibleinselfservice = isvisibleinselfservice;
		this.tipo_atencion_interna = tipo_atencion_interna;
		this.hora_sec = hora_sec;
		this.pendientevalidacioncondagr = pendientevalidacioncondagr;
		this.ejecutivoanterior = ejecutivoanterior;
		this.entitlementid = entitlementid;
		this.assetid = assetid;
		this.stopstartdate = stopstartdate;
		this.suppliedcompany = suppliedcompany;
		this.isclosedoncreate = isclosedoncreate;
		this.estado_condici_n_agravante = estado_condici_n_agravante;
		this.hora_cancelado = hora_cancelado;
		this.suministro = suministro;
		this.isselfserviceclosed = isselfserviceclosed;
		this.parentid = parentid;
		this.ui = ui;
		this.numsum = numsum;
		this.twitter = twitter;
		this.suppliedname = suppliedname;
		this.closeddate = closeddate;
		this.fallo_envio_inservice = fallo_envio_inservice;
		this.description = description;
		this.hora_arribado = hora_arribado;
		this.slaexitdate = slaexitdate;
		this.origin = origin;
		this.descripcion_estado = descripcion_estado;
		this.businesshoursid = businesshoursid;
		this.sf4twitter__author_external_id = sf4twitter__author_external_id;
		this.hascommentsunreadbyowner = hascommentsunreadbyowner;
		this.hora_cerrado = hora_cerrado;
		this.literal_condici_n_agravante = literal_condici_n_agravante;
		this.type = type;
		this.direccion_del_suministro = direccion_del_suministro;
		this.hora_pendiente = hora_pendiente;
		this.ani = ani;
		this.facebook = facebook;
		this.petici_n = petici_n;
		this.communityid = communityid;
		this.direccion = direccion;
		this.hora_asignado = hora_asignado;
		this.milestonestatus = milestonestatus;
		this.contactid = contactid;
		this.hora_predespacho = hora_predespacho;
		this.hora_enruta = hora_enruta;
		this.reason = reason;
		this.id_empresa = id_empresa;
		this.hora_programado = hora_programado;
		this.numero_de_seguidores_del = numero_de_seguidores_del;
		this.literal_categorias = literal_categorias;
		this.recordtypeid = recordtypeid;
		this.comuna_f = comuna_f;
		this.prioridad = prioridad;
		this.valorsubestadoins = valorsubestadoins;
		this.control_electrodependiente = control_electrodependiente;
		this.cancelar = cancelar;
		this.condici_n_agravante = condici_n_agravante;
	}

	public Case() {
		super();
	}

	public Boolean getIsdeleted() {
		return isdeleted;
	}

	public void setIsdeleted(Boolean isdeleted) {
		this.isdeleted = isdeleted;
	}

	public Date getSystemmodstamp() {
		return systemmodstamp;
	}

	public void setSystemmodstamp(Date systemmodstamp) {
		this.systemmodstamp = systemmodstamp;
	}

	public String get_hc_lastop() {
		return _hc_lastop;
	}

	public void set_hc_lastop(String _hc_lastop) {
		this._hc_lastop = _hc_lastop;
	}

	public String get_hc_err() {
		return _hc_err;
	}

	public void set_hc_err(String _hc_err) {
		this._hc_err = _hc_err;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSfid() {
		return sfid;
	}

	public void setSfid(String sfid) {
		this.sfid = sfid;
	}

	public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Date getFecha_estimada_de_cierre() {
		return fecha_estimada_de_cierre;
	}

	public void setFecha_estimada_de_cierre(Date fecha_estimada_de_cierre) {
		this.fecha_estimada_de_cierre = fecha_estimada_de_cierre;
	}

	public String getAccountid() {
		return accountid;
	}

	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}

	public String getFavorabilidad_del_caso() {
		return favorabilidad_del_caso;
	}

	public void setFavorabilidad_del_caso(String favorabilidad_del_caso) {
		this.favorabilidad_del_caso = favorabilidad_del_caso;
	}

	public String getFlag_sec() {
		return flag_sec;
	}

	public void setFlag_sec(String flag_sec) {
		this.flag_sec = flag_sec;
	}

	public String getLastmodifiedbyid() {
		return lastmodifiedbyid;
	}

	public void setLastmodifiedbyid(String lastmodifiedbyid) {
		this.lastmodifiedbyid = lastmodifiedbyid;
	}

	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public Boolean getValidar_electrodependiente() {
		return validar_electrodependiente;
	}

	public void setValidar_electrodependiente(Boolean validar_electrodependiente) {
		this.validar_electrodependiente = validar_electrodependiente;
	}

	public String getSf4twitter__twitter_username() {
		return sf4twitter__twitter_username;
	}

	public void setSf4twitter__twitter_username(String sf4twitter__twitter_username) {
		this.sf4twitter__twitter_username = sf4twitter__twitter_username;
	}

	public String getOwnerid() {
		return ownerid;
	}

	public void setOwnerid(String ownerid) {
		this.ownerid = ownerid;
	}

	public Date getSlastartdate() {
		return slastartdate;
	}

	public void setSlastartdate(Date slastartdate) {
		this.slastartdate = slastartdate;
	}

	public String getMotivo_empresa() {
		return motivo_empresa;
	}

	public void setMotivo_empresa(String motivo_empresa) {
		this.motivo_empresa = motivo_empresa;
	}

	public String getCall_center() {
		return call_center;
	}

	public void setCall_center(String call_center) {
		this.call_center = call_center;
	}

	public Boolean getFallo_envio_validacion() {
		return fallo_envio_validacion;
	}

	public void setFallo_envio_validacion(Boolean fallo_envio_validacion) {
		this.fallo_envio_validacion = fallo_envio_validacion;
	}

	public String getLiteral_comuna() {
		return literal_comuna;
	}

	public void setLiteral_comuna(String literal_comuna) {
		this.literal_comuna = literal_comuna;
	}

	public Boolean getAct_datos_contacto() {
		return act_datos_contacto;
	}

	public void setAct_datos_contacto(Boolean act_datos_contacto) {
		this.act_datos_contacto = act_datos_contacto;
	}

	public String getFallo_creacion_observacion() {
		return fallo_creacion_observacion;
	}

	public void setFallo_creacion_observacion(String fallo_creacion_observacion) {
		this.fallo_creacion_observacion = fallo_creacion_observacion;
	}

	public Boolean getSfidestado_preingreso() {
		return sfidestado_preingreso;
	}

	public void setSfidestado_preingreso(Boolean sfidestado_preingreso) {
		this.sfidestado_preingreso = sfidestado_preingreso;
	}

	public String getEmail_de_notificacion() {
		return email_de_notificacion;
	}

	public void setEmail_de_notificacion(String email_de_notificacion) {
		this.email_de_notificacion = email_de_notificacion;
	}

	public Double getHoraap() {
		return horaap;
	}

	public void setHoraap(Double horaap) {
		this.horaap = horaap;
	}

	public String getNumero_de_inservice() {
		return numero_de_inservice;
	}

	public void setNumero_de_inservice(String numero_de_inservice) {
		this.numero_de_inservice = numero_de_inservice;
	}

	public String getSuppliedphone() {
		return suppliedphone;
	}

	public void setSuppliedphone(String suppliedphone) {
		this.suppliedphone = suppliedphone;
	}

	public String getNumero_de_medidor() {
		return numero_de_medidor;
	}

	public void setNumero_de_medidor(String numero_de_medidor) {
		this.numero_de_medidor = numero_de_medidor;
	}

	public Boolean getIsstopped() {
		return isstopped;
	}

	public void setIsstopped(Boolean isstopped) {
		this.isstopped = isstopped;
	}

	public String getCuerpo_mail() {
		return cuerpo_mail;
	}

	public void setCuerpo_mail(String cuerpo_mail) {
		this.cuerpo_mail = cuerpo_mail;
	}

	public String getTelefono_de_contacto() {
		return telefono_de_contacto;
	}

	public void setTelefono_de_contacto(String telefono_de_contacto) {
		this.telefono_de_contacto = telefono_de_contacto;
	}

	public String getQuestionid() {
		return questionid;
	}

	public void setQuestionid(String questionid) {
		this.questionid = questionid;
	}

	public Boolean getHasselfservicecomments() {
		return hasselfservicecomments;
	}

	public void setHasselfservicecomments(Boolean hasselfservicecomments) {
		this.hasselfservicecomments = hasselfservicecomments;
	}

	public String getTraza_fallo_inservice() {
		return traza_fallo_inservice;
	}

	public void setTraza_fallo_inservice(String traza_fallo_inservice) {
		this.traza_fallo_inservice = traza_fallo_inservice;
	}

	public String getCanal_de_notificacion() {
		return canal_de_notificacion;
	}

	public void setCanal_de_notificacion(String canal_de_notificacion) {
		this.canal_de_notificacion = canal_de_notificacion;
	}

	public String getCreatedbyid() {
		return createdbyid;
	}

	public void setCreatedbyid(String createdbyid) {
		this.createdbyid = createdbyid;
	}

	public String getCategor_a() {
		return categor_a;
	}

	public void setCategor_a(String categor_a) {
		this.categor_a = categor_a;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getCasenumber() {
		return casenumber;
	}

	public void setCasenumber(String casenumber) {
		this.casenumber = casenumber;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSf4twitter__twitterid() {
		return sf4twitter__twitterid;
	}

	public void setSf4twitter__twitterid(String sf4twitter__twitterid) {
		this.sf4twitter__twitterid = sf4twitter__twitterid;
	}

	public String getRespuesta_al_cliente() {
		return respuesta_al_cliente;
	}

	public void setRespuesta_al_cliente(String respuesta_al_cliente) {
		this.respuesta_al_cliente = respuesta_al_cliente;
	}

	public String getN_mero_de_caso_ap() {
		return n_mero_de_caso_ap;
	}

	public void setN_mero_de_caso_ap(String n_mero_de_caso_ap) {
		this.n_mero_de_caso_ap = n_mero_de_caso_ap;
	}

	public Boolean getIsescalated() {
		return isescalated;
	}

	public void setIsescalated(Boolean isescalated) {
		this.isescalated = isescalated;
	}

	public String getInteraccion() {
		return interaccion;
	}

	public void setInteraccion(String interaccion) {
		this.interaccion = interaccion;
	}

	public String getTipo_atencion_sec() {
		return tipo_atencion_sec;
	}

	public void setTipo_atencion_sec(String tipo_atencion_sec) {
		this.tipo_atencion_sec = tipo_atencion_sec;
	}

	public String getSub_estado() {
		return sub_estado;
	}

	public void setSub_estado(String sub_estado) {
		this.sub_estado = sub_estado;
	}

	public Boolean getIsvisibleinselfservice() {
		return isvisibleinselfservice;
	}

	public void setIsvisibleinselfservice(Boolean isvisibleinselfservice) {
		this.isvisibleinselfservice = isvisibleinselfservice;
	}

	public String getTipo_atencion_interna() {
		return tipo_atencion_interna;
	}

	public void setTipo_atencion_interna(String tipo_atencion_interna) {
		this.tipo_atencion_interna = tipo_atencion_interna;
	}

	public Date getHora_sec() {
		return hora_sec;
	}

	public void setHora_sec(Date hora_sec) {
		this.hora_sec = hora_sec;
	}

	public Boolean getPendientevalidacioncondagr() {
		return pendientevalidacioncondagr;
	}

	public void setPendientevalidacioncondagr(Boolean pendientevalidacioncondagr) {
		this.pendientevalidacioncondagr = pendientevalidacioncondagr;
	}

	public String getEjecutivoanterior() {
		return ejecutivoanterior;
	}

	public void setEjecutivoanterior(String ejecutivoanterior) {
		this.ejecutivoanterior = ejecutivoanterior;
	}

	public String getEntitlementid() {
		return entitlementid;
	}

	public void setEntitlementid(String entitlementid) {
		this.entitlementid = entitlementid;
	}

	public String getAssetid() {
		return assetid;
	}

	public void setAssetid(String assetid) {
		this.assetid = assetid;
	}

	public Date getStopstartdate() {
		return stopstartdate;
	}

	public void setStopstartdate(Date stopstartdate) {
		this.stopstartdate = stopstartdate;
	}

	public String getSuppliedcompany() {
		return suppliedcompany;
	}

	public void setSuppliedcompany(String suppliedcompany) {
		this.suppliedcompany = suppliedcompany;
	}

	public Boolean getIsclosedoncreate() {
		return isclosedoncreate;
	}

	public void setIsclosedoncreate(Boolean isclosedoncreate) {
		this.isclosedoncreate = isclosedoncreate;
	}

	public String getEstado_condici_n_agravante() {
		return estado_condici_n_agravante;
	}

	public void setEstado_condici_n_agravante(String estado_condici_n_agravante) {
		this.estado_condici_n_agravante = estado_condici_n_agravante;
	}

	public Date getHora_cancelado() {
		return hora_cancelado;
	}

	public void setHora_cancelado(Date hora_cancelado) {
		this.hora_cancelado = hora_cancelado;
	}

	public String getSuministro() {
		return suministro;
	}

	public void setSuministro(String suministro) {
		this.suministro = suministro;
	}

	public Boolean getIsselfserviceclosed() {
		return isselfserviceclosed;
	}

	public void setIsselfserviceclosed(Boolean isselfserviceclosed) {
		this.isselfserviceclosed = isselfserviceclosed;
	}

	public String getParentid() {
		return parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

	public Boolean getUi() {
		return ui;
	}

	public void setUi(Boolean ui) {
		this.ui = ui;
	}

	public String getNumsum() {
		return numsum;
	}

	public void setNumsum(String numsum) {
		this.numsum = numsum;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public String getSuppliedname() {
		return suppliedname;
	}

	public void setSuppliedname(String suppliedname) {
		this.suppliedname = suppliedname;
	}

	public Date getCloseddate() {
		return closeddate;
	}

	public void setCloseddate(Date closeddate) {
		this.closeddate = closeddate;
	}

	public Boolean getFallo_envio_inservice() {
		return fallo_envio_inservice;
	}

	public void setFallo_envio_inservice(Boolean fallo_envio_inservice) {
		this.fallo_envio_inservice = fallo_envio_inservice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getHora_arribado() {
		return hora_arribado;
	}

	public void setHora_arribado(Date hora_arribado) {
		this.hora_arribado = hora_arribado;
	}

	public Date getSlaexitdate() {
		return slaexitdate;
	}

	public void setSlaexitdate(Date slaexitdate) {
		this.slaexitdate = slaexitdate;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDescripcion_estado() {
		return descripcion_estado;
	}

	public void setDescripcion_estado(String descripcion_estado) {
		this.descripcion_estado = descripcion_estado;
	}

	public String getBusinesshoursid() {
		return businesshoursid;
	}

	public void setBusinesshoursid(String businesshoursid) {
		this.businesshoursid = businesshoursid;
	}

	public String getSf4twitter__author_external_id() {
		return sf4twitter__author_external_id;
	}

	public void setSf4twitter__author_external_id(String sf4twitter__author_external_id) {
		this.sf4twitter__author_external_id = sf4twitter__author_external_id;
	}

	public Boolean getHascommentsunreadbyowner() {
		return hascommentsunreadbyowner;
	}

	public void setHascommentsunreadbyowner(Boolean hascommentsunreadbyowner) {
		this.hascommentsunreadbyowner = hascommentsunreadbyowner;
	}

	public Date getHora_cerrado() {
		return hora_cerrado;
	}

	public void setHora_cerrado(Date hora_cerrado) {
		this.hora_cerrado = hora_cerrado;
	}

	public String getLiteral_condici_n_agravante() {
		return literal_condici_n_agravante;
	}

	public void setLiteral_condici_n_agravante(String literal_condici_n_agravante) {
		this.literal_condici_n_agravante = literal_condici_n_agravante;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDireccion_del_suministro() {
		return direccion_del_suministro;
	}

	public void setDireccion_del_suministro(String direccion_del_suministro) {
		this.direccion_del_suministro = direccion_del_suministro;
	}

	public Date getHora_pendiente() {
		return hora_pendiente;
	}

	public void setHora_pendiente(Date hora_pendiente) {
		this.hora_pendiente = hora_pendiente;
	}

	public String getAni() {
		return ani;
	}

	public void setAni(String ani) {
		this.ani = ani;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getPetici_n() {
		return petici_n;
	}

	public void setPetici_n(String petici_n) {
		this.petici_n = petici_n;
	}

	public String getCommunityid() {
		return communityid;
	}

	public void setCommunityid(String communityid) {
		this.communityid = communityid;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getHora_asignado() {
		return hora_asignado;
	}

	public void setHora_asignado(Date hora_asignado) {
		this.hora_asignado = hora_asignado;
	}

	public String getMilestonestatus() {
		return milestonestatus;
	}

	public void setMilestonestatus(String milestonestatus) {
		this.milestonestatus = milestonestatus;
	}

	public String getContactid() {
		return contactid;
	}

	public void setContactid(String contactid) {
		this.contactid = contactid;
	}

	public Date getHora_predespacho() {
		return hora_predespacho;
	}

	public void setHora_predespacho(Date hora_predespacho) {
		this.hora_predespacho = hora_predespacho;
	}

	public Date getHora_enruta() {
		return hora_enruta;
	}

	public void setHora_enruta(Date hora_enruta) {
		this.hora_enruta = hora_enruta;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getId_empresa() {
		return id_empresa;
	}

	public void setId_empresa(String id_empresa) {
		this.id_empresa = id_empresa;
	}

	public Date getHora_programado() {
		return hora_programado;
	}

	public void setHora_programado(Date hora_programado) {
		this.hora_programado = hora_programado;
	}

	public Double getNumero_de_seguidores_del() {
		return numero_de_seguidores_del;
	}

	public void setNumero_de_seguidores_del(Double numero_de_seguidores_del) {
		this.numero_de_seguidores_del = numero_de_seguidores_del;
	}

	public String getLiteral_categorias() {
		return literal_categorias;
	}

	public void setLiteral_categorias(String literal_categorias) {
		this.literal_categorias = literal_categorias;
	}

	public String getRecordtypeid() {
		return recordtypeid;
	}

	public void setRecordtypeid(String recordtypeid) {
		this.recordtypeid = recordtypeid;
	}

	public String getComuna_f() {
		return comuna_f;
	}

	public void setComuna_f(String comuna_f) {
		this.comuna_f = comuna_f;
	}

	public String getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
	}

	public String getValorsubestadoins() {
		return valorsubestadoins;
	}

	public void setValorsubestadoins(String valorsubestadoins) {
		this.valorsubestadoins = valorsubestadoins;
	}

	public Boolean getControl_electrodependiente() {
		return control_electrodependiente;
	}

	public void setControl_electrodependiente(Boolean control_electrodependiente) {
		this.control_electrodependiente = control_electrodependiente;
	}

	public Boolean getCancelar() {
		return cancelar;
	}

	public void setCancelar(Boolean cancelar) {
		this.cancelar = cancelar;
	}

	public String getCondici_n_agravante() {
		return condici_n_agravante;
	}

	public void setCondici_n_agravante(String condici_n_agravante) {
		this.condici_n_agravante = condici_n_agravante;
	}
	

	
	

	
	
	

	

	
}