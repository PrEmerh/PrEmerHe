package com.casosemergencias.dao.vo;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.casosemergencias.model.Caso;


@Entity
@Table(name="salesforce.case")
public class CaseVO extends ObjectVO implements Serializable {
	
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
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "sfid")
	private String sfid;
	
	@Column(name = "createddate")
	private Date fechaApertura;
	
	@Column(name = "subject")
	private String asunto;
	
	@Column(name = "fecha_estimada_de_cierre__c")
	private Date fechaEstimadaCierre;
	
	@Column(name = "accountid")
	private String accountid;
	
	@Column(name = "favorabilidad_del_caso__c")
	private String favorabilidadDelCaso;
	
	@Column(name = "flag_sec__c")
	private String flagSec;
	
	@Column(name = "lastmodifiedbyid")
	private String lastmodifiedbyid;
	
	@Column(name = "productid")
	private String productid;
	
	@Column(name = "validar_electrodependiente__c")
	private Boolean validarElectrodependiente;
	
	@Column(name = "sf4twitter__twitter_username__c")
	private String sf4twitterTwitterUsername;
	
	@Column(name = "ownerid")
	private String propietarioCaso;
	
	@Column(name = "slastartdate")
	private Date slastartdate;
	
	@Column(name = "motivo_empresa__c")
	private String motivoEmpresa;
	
	@Column(name = "call_center__c")
	private String callCenter;
	
	@Column(name = "fallo_envio_validacion__c")
	private Boolean falloEnvioValidacion;
	
	@Column(name = "literal_comuna__c")
	private String literalComuna;
	
	@Column(name = "act_datos_contacto__c")
	private Boolean actDatosContacto;
	
	@Column(name = "fallo_creacion_observacion__c")
	private String falloCreacionObservacion;
	
	@Column(name = "estado_preingreso__c")
	private Boolean estadoPreingreso;
	
	@Column(name = "email_de_notificacion__c")
	private String emailNotificacion;
	
	@Column(name = "horaap__c")
	private Double horaap;
	
	@Column(name = "numero_de_inservice__c")
	private String numeroInservice;
	
	@Column(name = "suppliedphone")
	private String suppliedphone;
	
	@Column(name = "numero_de_medidor__c")
	private String numeroMedidor;
	
	@Column(name = "isstopped")
	private Boolean isstopped;
	
	@Column(name = "cuerpo_mail__c")
	private String cuerpoMail;
	
	@Column(name = "telefono_de_contacto__c")
	private String telefonoContacto;
	
	@Column(name = "questionid")
	private String questionid;
	
	@Column(name = "hasselfservicecomments")
	private Boolean hasselfservicecomments;
	
	@Column(name = "traza_fallo_inservice__c")
	private String trazaFalloInservice;
	
	@Column(name = "canal_de_notificacion__c")
	private String canalNotificacion;
	
	@Column(name = "createdbyid")
	private String createdbyid;
	
	@Column(name = "categor_a__c")
	private String categoria;
	
	@Column(name = "flag__c")
	private String flag;
	
	@Column(name = "observaciones__c")
	private String observaciones;
	
	@Column(name = "casenumber")
	private String numeroCaso;
	
	@Column(name = "url__c")
	private String url;
	
	@Column(name = "status")
	private String estado;
	
	@Column(name = "sf4twitter__twitterid__c")
	private String sf4twitterTwitterid;
	
	@Column(name = "respuesta_al_cliente__c")
	private String respuestaAlCliente;
	
	@Column(name = "n_mero_de_caso_ap__c")
	private String numeroCasoAp;
	
	@Column(name = "isescalated")
	private Boolean isescalated;
	
	@Column(name = "interaccion__c")
	private String interaccion;
	
	@Column(name = "tipo_atencion_sec__c")
	private String tipoAtencionSec;
	
	@Column(name = "sub_estado__c")
	private String subEstado;
	
	@Column(name = "isvisibleinselfservice")
	private Boolean isvisibleinselfservice;
	
	@Column(name = "tipo_atencion_interna__c")
	private String tipoAtencionInterna;
	
	@Column(name = "hora_sec__c")
	private Date horaSec;
	
	@Column(name = "pendientevalidacioncondagr__c")
	private Boolean pendienteValidacionCondagr;
	
	@Column(name = "ejecutivoanterior__c")
	private String ejecutivoAnterior;
	
	@Column(name = "entitlementid")
	private String entitlementid;
	
	@Column(name = "assetid")
	private String assetid;
	
	@Column(name = "stopstartdate")
	private Date stopstartDate;
	
	@Column(name = "suppliedcompany")
	private String suppliedCompany;
	
	@Column(name = "isclosedoncreate")
	private Boolean isClosedonCreate;
	
	@Column(name = "estado_condici_n_agravante__c")
	private String estadoCondicionAgravante;
	
	@Column(name = "hora_cancelado__c")
	private Date horaCancelado;
	
	@Column(name = "suministro__c")
	private String suministro;
	
	@Column(name = "isselfserviceclosed")
	private	Boolean isSelfserviceClosed;
	
	@Column(name = "parentid")
	private String parent;
	
	@Column(name = "ui__c")
	private Boolean ui;
	
	@Column(name = "numsum__c")
	private String numSum;
	
	@Column(name = "twitter__c")
	private String twitter;
	
	@Column(name = "suppliedname")
	private String suppliedName;
	
	@Column(name = "closeddate")
	private Date closedDate;
	
	@Column(name = "fallo_envio_inservice__c")
	private Boolean falloEnvioInservice;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "hora_arribado__c")
	private Date horaArribado;
	
	@Column(name = "slaexitdate")
	private Date slaexitDate;
	
	@Column(name = "origin")
	private String canalOrigen;
	
	@Column(name = "descripcion_estado__c")
	private String descripcionEstado;
	
	@Column(name = "businesshoursid")
	private String businessHoursId;
	
	@Column(name = "sf4twitter__author_external_id__c")
	private String sf4twitterAuthorExternalId;
	
	@Column(name = "hascommentsunreadbyowner")
	private Boolean hasCommentSunReadByOwner;
	
	@Column(name = "hora_cerrado__c")
	private Date horaCerrado;
	
	@Column(name = "literal_condici_n_agravante__c")
	private String literalCondicionAgravante;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "direccion_del_suministro__c")
	private String direccionSuministro;
	
	@Column(name = "hora_pendiente__c")
	private Date horaPendiente;
	
	@Column(name = "ani__c")
	private String ani;
	
	@Column(name = "facebook__c")
	private String facebook;
	
	@Column(name = "petici_n__c")
	private String peticion;
	
	@Column(name = "communityid")
	private String communityId;
	
	@Column(name = "direccion__c")
	private String direccion;
	
	@Column(name = "hora_asignado__c")
	private Date horaAsignado;
	
	@Column(name = "milestonestatus")
	private String milestoneStatus;
	
	@Column(name = "contactid")
	private String contactId;
	
	@Column(name = "hora_predespacho__c")
	private Date horaPredespacho;
	
	@Column(name = "hora_enruta__c")
	private Date horaEnruta;
	
	@Column(name = "reason")
	private String reason;
	
	@Column(name = "id_empresa__c")
	private String idEmpresa;
	
	@Column(name = "hora_programado__c")
	private Date horaProgramado;
	
	@Column(name = "numero_de_seguidores_del__c")
	private Double numeroSeguidoresDel;
	
	@Column(name = "literal_categoria__c")
	private String literalCategorias;
	
	@Column(name = "recordtypeid")
	private String recordtypeId;
	
	@Column(name = "comuna_f__c")
	private String comunaF;
	
	@Column(name = "prioridad__c")
	private String prioridad;
	
	@Column(name = "valorsubestadoins__c")
	private String valorSubestadoins;
	
	@Column(name = "control_electrodependiente__c")
	private Boolean controlElectrodependiente;
	
	@Column(name = "cancelar__c")
	private Boolean cancelar;
	
	@Column(name = "condici_n_agravante__c")
	private String condicionAgravante;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="subEstado", referencedColumnName="codigo", insertable = false, updatable=false)
	@Where(clause = "campo ='Sub_Estado__c' and objeto='Case'")
	private PickListsVO subestadoPickList;
//		NO va@ManyToMany
//	    @JoinTable(name="salesforce.case", joinColumns=@JoinColumn(name="status"), inverseJoinColumns=@JoinColumn(name="codigo"))
//		@WhereJoinTable (clause = "campo ='Status' and objeto='Case'")
//	
//		private Set<PickListsVO> estadoPickList;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="motivoEmpresa", referencedColumnName="codigo", insertable = false, updatable=false)
   	@Where(clause = "campo ='Motivo_Empresa__c' and objeto='Case'")
	private PickListsVO submotivoPickList;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="canalOrigen", referencedColumnName="codigo", insertable = false, updatable=false)
   	@Where(clause = "campo ='Origin' and objeto='Case'")
	private PickListsVO canalorigenPickList;

	
	public CaseVO(Boolean isdeleted, Date systemmodstamp, String _hc_lastop, String _hc_err, Integer id, String sfid,
			Date createdDate, String asunto, Date fechaEstimadaCierre, String accountid, String favorabilidadDelCaso,
			String flagSec, String lastmodifiedbyid, String productid, Boolean validarElectrodependiente,
			String sf4twitterTwitterUsername, String propietarioCaso, Date slastartdate, String motivoEmpresa,
			String callCenter, Boolean falloEnvioValidacion, String literalComuna, Boolean actDatosContacto,
			String falloCreacionObservacion, Boolean estadoPreingreso, String emailNotificacion, Double horaap,
			String numeroInservice, String suppliedphone, String numeroMedidor, Boolean isstopped, String cuerpoMail,
			String telefonoContacto, String questionid, Boolean hasselfservicecomments, String trazaFalloInservice,
			String canalNotificacion, String createdbyid, String categoria, String flag, String observaciones,
			String casenumber, String url, String status, String sf4twitterTwitterid, String respuestaAlCliente,
			String numeroCasoAp, Boolean isescalated, String interaccion, String tipoAtencionSec, String subEstado,
			Boolean isvisibleinselfservice, String tipoAtencionInterna, Date horaSec,
			Boolean pendienteValidacionCondagr, String ejecutivoAnterior, String entitlementid, String assetid,
			Date stopstartDate, String suppliedCompany, Boolean isClosedonCreate, String estadoCondicionAgravante,
			Date horaCancelado, String suministro, Boolean isSelfserviceClosed, String parent, Boolean ui,
			String numSum, String twitter, String suppliedName, Date closedDate, Boolean falloEnvioInservice,
			String description, Date horaArribado, Date slaexitDate, String canalOrigen, String descripcionEstado,
			String businessHoursId, String sf4twitterAuthorExternalId, Boolean hasCommentSunReadByOwner,
			Date horaCerrado, String literalCondicionAgravante, String type, String direccionSuministro,
			Date horaPendiente, String ani, String facebook, String peticion, String communityId, String direccion,
			Date horaAsignado, String milestoneStatus, String contactId, Date horaPredespacho, Date horaEnruta,
			String reason, String idEmpresa, Date horaProgramado, Double numeroSeguidoresDel, String literalCategorias,
			String recordtypeId, String comunaF, String prioridad, String valorSubestadoins,
			Boolean controlElectrodependiente, Boolean cancelar, String condicionAgravante, PickListsVO subestadoPickList,
			PickListsVO submotivoPickList) {
		super();
		this.isdeleted = isdeleted;
		this.systemmodstamp = systemmodstamp;
		this._hc_lastop = _hc_lastop;
		this._hc_err = _hc_err;
		this.id = id;
		this.sfid = sfid;
		this.fechaApertura = createdDate;
		this.asunto = asunto;
		this.fechaEstimadaCierre = fechaEstimadaCierre;
		this.accountid = accountid;
		this.favorabilidadDelCaso = favorabilidadDelCaso;
		this.flagSec = flagSec;
		this.lastmodifiedbyid = lastmodifiedbyid;
		this.productid = productid;
		this.validarElectrodependiente = validarElectrodependiente;
		this.sf4twitterTwitterUsername = sf4twitterTwitterUsername;
		this.propietarioCaso = propietarioCaso;
		this.slastartdate = slastartdate;
		this.motivoEmpresa = motivoEmpresa;
		this.callCenter = callCenter;
		this.falloEnvioValidacion = falloEnvioValidacion;
		this.literalComuna = literalComuna;
		this.actDatosContacto = actDatosContacto;
		this.falloCreacionObservacion = falloCreacionObservacion;
		this.estadoPreingreso = estadoPreingreso;
		this.emailNotificacion = emailNotificacion;
		this.horaap = horaap;
		this.numeroInservice = numeroInservice;
		this.suppliedphone = suppliedphone;
		this.numeroMedidor = numeroMedidor;
		this.isstopped = isstopped;
		this.cuerpoMail = cuerpoMail;
		this.telefonoContacto = telefonoContacto;
		this.questionid = questionid;
		this.hasselfservicecomments = hasselfservicecomments;
		this.trazaFalloInservice = trazaFalloInservice;
		this.canalNotificacion = canalNotificacion;
		this.createdbyid = createdbyid;
		this.categoria = categoria;
		this.flag = flag;
		this.observaciones = observaciones;
		this.numeroCaso = casenumber;
		this.url = url;
		this.estado = status;
		this.sf4twitterTwitterid = sf4twitterTwitterid;
		this.respuestaAlCliente = respuestaAlCliente;
		this.numeroCasoAp = numeroCasoAp;
		this.isescalated = isescalated;
		this.interaccion = interaccion;
		this.tipoAtencionSec = tipoAtencionSec;
		this.subEstado = subEstado;
		this.isvisibleinselfservice = isvisibleinselfservice;
		this.tipoAtencionInterna = tipoAtencionInterna;
		this.horaSec = horaSec;
		this.pendienteValidacionCondagr = pendienteValidacionCondagr;
		this.ejecutivoAnterior = ejecutivoAnterior;
		this.entitlementid = entitlementid;
		this.assetid = assetid;
		this.stopstartDate = stopstartDate;
		this.suppliedCompany = suppliedCompany;
		this.isClosedonCreate = isClosedonCreate;
		this.estadoCondicionAgravante = estadoCondicionAgravante;
		this.horaCancelado = horaCancelado;
		this.suministro = suministro;
		this.isSelfserviceClosed = isSelfserviceClosed;
		this.parent = parent;
		this.ui = ui;
		this.numSum = numSum;
		this.twitter = twitter;
		this.suppliedName = suppliedName;
		this.closedDate = closedDate;
		this.falloEnvioInservice = falloEnvioInservice;
		this.description = description;
		this.horaArribado = horaArribado;
		this.slaexitDate = slaexitDate;
		this.canalOrigen = canalOrigen;
		this.descripcionEstado = descripcionEstado;
		this.businessHoursId = businessHoursId;
		this.sf4twitterAuthorExternalId = sf4twitterAuthorExternalId;
		this.hasCommentSunReadByOwner = hasCommentSunReadByOwner;
		this.horaCerrado = horaCerrado;
		this.literalCondicionAgravante = literalCondicionAgravante;
		this.type = type;
		this.direccionSuministro = direccionSuministro;
		this.horaPendiente = horaPendiente;
		this.ani = ani;
		this.facebook = facebook;
		this.peticion = peticion;
		this.communityId = communityId;
		this.direccion = direccion;
		this.horaAsignado = horaAsignado;
		this.milestoneStatus = milestoneStatus;
		this.contactId = contactId;
		this.horaPredespacho = horaPredespacho;
		this.horaEnruta = horaEnruta;
		this.reason = reason;
		this.idEmpresa = idEmpresa;
		this.horaProgramado = horaProgramado;
		this.numeroSeguidoresDel = numeroSeguidoresDel;
		this.literalCategorias = literalCategorias;
		this.recordtypeId = recordtypeId;
		this.comunaF = comunaF;
		this.prioridad = prioridad;
		this.valorSubestadoins = valorSubestadoins;
		this.controlElectrodependiente = controlElectrodependiente;
		this.cancelar = cancelar;
		this.condicionAgravante = condicionAgravante;
		this.subestadoPickList = subestadoPickList;		
		this.submotivoPickList = submotivoPickList;
	}

	public CaseVO() {
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

	public Date getFechaApertura() {
		return fechaApertura;
	}

	public void setFechaApertura(Date fechaApertura) {
		this.fechaApertura = fechaApertura;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public Date getFechaEstimadaCierre() {
		return fechaEstimadaCierre;
	}

	public void setFechaEstimadaCierre(Date fechaEstimadaCierre) {
		this.fechaEstimadaCierre = fechaEstimadaCierre;
	}

	public String getAccountid() {
		return accountid;
	}

	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}

	public String getFavorabilidadDelCaso() {
		return favorabilidadDelCaso;
	}

	public void setFavorabilidadDelCaso(String favorabilidadDelCaso) {
		this.favorabilidadDelCaso = favorabilidadDelCaso;
	}

	public String getFlagSec() {
		return flagSec;
	}

	public void setFlagSec(String flagSec) {
		this.flagSec = flagSec;
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

	public Boolean getValidarElectrodependiente() {
		return validarElectrodependiente;
	}

	public void setValidarElectrodependiente(Boolean validarElectrodependiente) {
		this.validarElectrodependiente = validarElectrodependiente;
	}

	public String getSf4twitterTwitterUsername() {
		return sf4twitterTwitterUsername;
	}

	public void setSf4twitterTwitterUsername(String sf4twitterTwitterUsername) {
		this.sf4twitterTwitterUsername = sf4twitterTwitterUsername;
	}

	public String getPropietarioCaso() {
		return propietarioCaso;
	}

	public void setPropietarioCaso(String propietarioCaso) {
		this.propietarioCaso = propietarioCaso;
	}

	public Date getSlastartdate() {
		return slastartdate;
	}

	public void setSlastartdate(Date slastartdate) {
		this.slastartdate = slastartdate;
	}

	public String getMotivoEmpresa() {
		return motivoEmpresa;
	}

	public void setMotivoEmpresa(String motivoEmpresa) {
		this.motivoEmpresa = motivoEmpresa;
	}

	public String getCallCenter() {
		return callCenter;
	}

	public void setCallCenter(String callCenter) {
		this.callCenter = callCenter;
	}

	public Boolean getFalloEnvioValidacion() {
		return falloEnvioValidacion;
	}

	public void setFalloEnvioValidacion(Boolean falloEnvioValidacion) {
		this.falloEnvioValidacion = falloEnvioValidacion;
	}

	public String getLiteralComuna() {
		return literalComuna;
	}

	public void setLiteralComuna(String literalComuna) {
		this.literalComuna = literalComuna;
	}

	public Boolean getActDatosContacto() {
		return actDatosContacto;
	}

	public void setActDatosContacto(Boolean actDatosContacto) {
		this.actDatosContacto = actDatosContacto;
	}

	public String getFalloCreacionObservacion() {
		return falloCreacionObservacion;
	}

	public void setFalloCreacionObservacion(String falloCreacionObservacion) {
		this.falloCreacionObservacion = falloCreacionObservacion;
	}

	public Boolean getEstadoPreingreso() {
		return estadoPreingreso;
	}

	public void setEstadoPreingreso(Boolean estadoPreingreso) {
		this.estadoPreingreso = estadoPreingreso;
	}

	public String getEmailNotificacion() {
		return emailNotificacion;
	}

	public void setEmailNotificacion(String emailNotificacion) {
		this.emailNotificacion = emailNotificacion;
	}

	public Double getHoraap() {
		return horaap;
	}

	public void setHoraap(Double horaap) {
		this.horaap = horaap;
	}

	public String getNumeroInservice() {
		return numeroInservice;
	}

	public void setNumeroInservice(String numeroInservice) {
		this.numeroInservice = numeroInservice;
	}

	public String getSuppliedphone() {
		return suppliedphone;
	}

	public void setSuppliedphone(String suppliedphone) {
		this.suppliedphone = suppliedphone;
	}

	public String getNumeroMedidor() {
		return numeroMedidor;
	}

	public void setNumeroMedidor(String numeroMedidor) {
		this.numeroMedidor = numeroMedidor;
	}

	public Boolean getIsstopped() {
		return isstopped;
	}

	public void setIsstopped(Boolean isstopped) {
		this.isstopped = isstopped;
	}

	public String getCuerpoMail() {
		return cuerpoMail;
	}

	public void setCuerpoMail(String cuerpoMail) {
		this.cuerpoMail = cuerpoMail;
	}

	public String getTelefonoContacto() {
		return telefonoContacto;
	}

	public void setTelefonoContacto(String telefonoContacto) {
		this.telefonoContacto = telefonoContacto;
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

	public String getTrazaFalloInservice() {
		return trazaFalloInservice;
	}

	public void setTrazaFalloInservice(String trazaFalloInservice) {
		this.trazaFalloInservice = trazaFalloInservice;
	}

	public String getCanalNotificacion() {
		return canalNotificacion;
	}

	public void setCanalNotificacion(String canalNotificacion) {
		this.canalNotificacion = canalNotificacion;
	}

	public String getCreatedbyid() {
		return createdbyid;
	}

	public void setCreatedbyid(String createdbyid) {
		this.createdbyid = createdbyid;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
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

	public String getNumeroCaso() {
		return numeroCaso;
	}

	public void setNumeroCaso(String numeroCaso) {
		this.numeroCaso = numeroCaso;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getSf4twitterTwitterid() {
		return sf4twitterTwitterid;
	}

	public void setSf4twitterTwitterid(String sf4twitterTwitterid) {
		this.sf4twitterTwitterid = sf4twitterTwitterid;
	}

	public String getRespuestaAlCliente() {
		return respuestaAlCliente;
	}

	public void setRespuestaAlCliente(String respuestaAlCliente) {
		this.respuestaAlCliente = respuestaAlCliente;
	}

	public String getNumeroCasoAp() {
		return numeroCasoAp;
	}

	public void setNumeroCasoAp(String numeroCasoAp) {
		this.numeroCasoAp = numeroCasoAp;
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

	public String getTipoAtencionSec() {
		return tipoAtencionSec;
	}

	public void setTipoAtencionSec(String tipoAtencionSec) {
		this.tipoAtencionSec = tipoAtencionSec;
	}

	public String getSubEstado() {
		return subEstado;
	}

	public void setSubEstado(String subEstado) {
		this.subEstado = subEstado;
	}

	public Boolean getIsvisibleinselfservice() {
		return isvisibleinselfservice;
	}

	public void setIsvisibleinselfservice(Boolean isvisibleinselfservice) {
		this.isvisibleinselfservice = isvisibleinselfservice;
	}

	public String getTipoAtencionInterna() {
		return tipoAtencionInterna;
	}

	public void setTipoAtencionInterna(String tipoAtencionInterna) {
		this.tipoAtencionInterna = tipoAtencionInterna;
	}

	public Date getHoraSec() {
		return horaSec;
	}

	public void setHoraSec(Date horaSec) {
		this.horaSec = horaSec;
	}

	public Boolean getPendienteValidacionCondagr() {
		return pendienteValidacionCondagr;
	}

	public void setPendienteValidacionCondagr(Boolean pendienteValidacionCondagr) {
		this.pendienteValidacionCondagr = pendienteValidacionCondagr;
	}

	public String getEjecutivoAnterior() {
		return ejecutivoAnterior;
	}

	public void setEjecutivoAnterior(String ejecutivoAnterior) {
		this.ejecutivoAnterior = ejecutivoAnterior;
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

	public Date getStopstartDate() {
		return stopstartDate;
	}

	public void setStopstartDate(Date stopstartDate) {
		this.stopstartDate = stopstartDate;
	}

	public String getSuppliedCompany() {
		return suppliedCompany;
	}

	public void setSuppliedCompany(String suppliedCompany) {
		this.suppliedCompany = suppliedCompany;
	}

	public Boolean getIsClosedonCreate() {
		return isClosedonCreate;
	}

	public void setIsClosedonCreate(Boolean isClosedonCreate) {
		this.isClosedonCreate = isClosedonCreate;
	}

	public String getEstadoCondicionAgravante() {
		return estadoCondicionAgravante;
	}

	public void setEstadoCondicionAgravante(String estadoCondicionAgravante) {
		this.estadoCondicionAgravante = estadoCondicionAgravante;
	}

	public Date getHoraCancelado() {
		return horaCancelado;
	}

	public void setHoraCancelado(Date horaCancelado) {
		this.horaCancelado = horaCancelado;
	}

	public String getSuministro() {
		return suministro;
	}

	public void setSuministro(String suministro) {
		this.suministro = suministro;
	}

	public Boolean getIsSelfserviceClosed() {
		return isSelfserviceClosed;
	}

	public void setIsSelfserviceClosed(Boolean isSelfserviceClosed) {
		this.isSelfserviceClosed = isSelfserviceClosed;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public Boolean getUi() {
		return ui;
	}

	public void setUi(Boolean ui) {
		this.ui = ui;
	}

	public String getNumSum() {
		return numSum;
	}

	public void setNumSum(String numSum) {
		this.numSum = numSum;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public String getSuppliedName() {
		return suppliedName;
	}

	public void setSuppliedName(String suppliedName) {
		this.suppliedName = suppliedName;
	}

	public Date getClosedDate() {
		return closedDate;
	}

	public void setClosedDate(Date closedDate) {
		this.closedDate = closedDate;
	}

	public Boolean getFalloEnvioInservice() {
		return falloEnvioInservice;
	}

	public void setFalloEnvioInservice(Boolean falloEnvioInservice) {
		this.falloEnvioInservice = falloEnvioInservice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getHoraArribado() {
		return horaArribado;
	}

	public void setHoraArribado(Date horaArribado) {
		this.horaArribado = horaArribado;
	}

	public Date getSlaexitDate() {
		return slaexitDate;
	}

	public void setSlaexitDate(Date slaexitDate) {
		this.slaexitDate = slaexitDate;
	}

	public String getCanalOrigen() {
		return canalOrigen;
	}

	public void setCanalOrigen(String canalOrigen) {
		this.canalOrigen = canalOrigen;
	}

	public String getDescripcionEstado() {
		return descripcionEstado;
	}

	public void setDescripcionEstado(String descripcionEstado) {
		this.descripcionEstado = descripcionEstado;
	}

	public String getBusinessHoursId() {
		return businessHoursId;
	}

	public void setBusinessHoursId(String businessHoursId) {
		this.businessHoursId = businessHoursId;
	}

	public String getSf4twitterAuthorExternalId() {
		return sf4twitterAuthorExternalId;
	}

	public void setSf4twitterAuthorExternalId(String sf4twitterAuthorExternalId) {
		this.sf4twitterAuthorExternalId = sf4twitterAuthorExternalId;
	}

	public Boolean getHasCommentSunReadByOwner() {
		return hasCommentSunReadByOwner;
	}

	public void setHasCommentSunReadByOwner(Boolean hasCommentSunReadByOwner) {
		this.hasCommentSunReadByOwner = hasCommentSunReadByOwner;
	}

	public Date getHoraCerrado() {
		return horaCerrado;
	}

	public void setHoraCerrado(Date horaCerrado) {
		this.horaCerrado = horaCerrado;
	}

	public String getLiteralCondicionAgravante() {
		return literalCondicionAgravante;
	}

	public void setLiteralCondicionAgravante(String literalCondicionAgravante) {
		this.literalCondicionAgravante = literalCondicionAgravante;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDireccionSuministro() {
		return direccionSuministro;
	}

	public void setDireccionSuministro(String direccionSuministro) {
		this.direccionSuministro = direccionSuministro;
	}

	public Date getHoraPendiente() {
		return horaPendiente;
	}

	public void setHoraPendiente(Date horaPendiente) {
		this.horaPendiente = horaPendiente;
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

	public String getPeticion() {
		return peticion;
	}

	public void setPeticion(String peticion) {
		this.peticion = peticion;
	}

	public String getCommunityId() {
		return communityId;
	}

	public void setCommunityId(String communityId) {
		this.communityId = communityId;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getHoraAsignado() {
		return horaAsignado;
	}

	public void setHoraAsignado(Date horaAsignado) {
		this.horaAsignado = horaAsignado;
	}

	public String getMilestoneStatus() {
		return milestoneStatus;
	}

	public void setMilestoneStatus(String milestoneStatus) {
		this.milestoneStatus = milestoneStatus;
	}

	public String getContactId() {
		return contactId;
	}

	public void setContactId(String contactId) {
		this.contactId = contactId;
	}

	public Date getHoraPredespacho() {
		return horaPredespacho;
	}

	public void setHoraPredespacho(Date horaPredespacho) {
		this.horaPredespacho = horaPredespacho;
	}

	public Date getHoraEnruta() {
		return horaEnruta;
	}

	public void setHoraEnruta(Date horaEnruta) {
		this.horaEnruta = horaEnruta;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(String idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public Date getHoraProgramado() {
		return horaProgramado;
	}

	public void setHoraProgramado(Date horaProgramado) {
		this.horaProgramado = horaProgramado;
	}

	public Double getNumeroSeguidoresDel() {
		return numeroSeguidoresDel;
	}

	public void setNumeroSeguidoresDel(Double numeroSeguidoresDel) {
		this.numeroSeguidoresDel = numeroSeguidoresDel;
	}

	public String getLiteralCategorias() {
		return literalCategorias;
	}

	public void setLiteralCategorias(String literalCategorias) {
		this.literalCategorias = literalCategorias;
	}

	public String getRecordtypeId() {
		return recordtypeId;
	}

	public void setRecordtypeId(String recordtypeId) {
		this.recordtypeId = recordtypeId;
	}

	public String getComunaF() {
		return comunaF;
	}

	public void setComunaF(String comunaF) {
		this.comunaF = comunaF;
	}

	public String getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
	}

	public String getValorSubestadoins() {
		return valorSubestadoins;
	}

	public void setValorSubestadoins(String valorSubestadoins) {
		this.valorSubestadoins = valorSubestadoins;
	}

	public Boolean getControlElectrodependiente() {
		return controlElectrodependiente;
	}

	public void setControlElectrodependiente(Boolean controlElectrodependiente) {
		this.controlElectrodependiente = controlElectrodependiente;
	}

	public Boolean getCancelar() {
		return cancelar;
	}

	public void setCancelar(Boolean cancelar) {
		this.cancelar = cancelar;
	}

	public String getCondicionAgravante() {
		return condicionAgravante;
	}

	public void setCondicionAgravante(String condicionAgravante) {
		this.condicionAgravante = condicionAgravante;
	}

	public PickListsVO getSubestadoPickList() {
		return subestadoPickList;
	}

	public void setSubestadoPickList(PickListsVO subestadoPickList) {
		this.subestadoPickList = subestadoPickList;
	}
	
	public String getLabelSubestadoPickList(){
		String result = this.getEstado();
		if (this.getSubestadoPickList() != null ){
			result=this.getSubestadoPickList().getValor();
		}
		return result; 
	}
	
	public PickListsVO getSubmotivoPickList() {
		return submotivoPickList;
	}

	public void setSubmotivoPickList(PickListsVO submotivoPickList) {
		this.submotivoPickList = submotivoPickList;
	}
	
	public String getLabelSubmotivoPickList(){
		String result = this.getMotivoEmpresa();
		if (this.getSubmotivoPickList() != null ){
			result=this.getSubmotivoPickList().getValor();
		}
		return result; 
	}

	public PickListsVO getCanalorigenPickList() {
		return canalorigenPickList;
	}

	public void setCanalorigenPickList(PickListsVO canalorigenPickList) {
		this.canalorigenPickList = canalorigenPickList;
	}
	
	public String getLabelCanalorigenPickList(){
		String result = this.getCanalOrigen();
		if (this.getCanalorigenPickList() != null ){
			result=this.getCanalorigenPickList().getValor();
		}
		return result; 
	}

	@Override
	public Object instantiateTargetLogic() {
		Caso caso = new Caso();
		return caso;
	}
}