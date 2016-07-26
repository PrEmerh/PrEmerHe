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
@Table(name="salesforce.contact")
public class Contact implements Serializable{
	
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
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "parent__rut_empresa__c")
	private String parentRutEmpresa;
	
	@Column(name = "fecha_nacimiento__c")
	private Date fechaNacimiento;
	
	@Column(name = "nombre_concatenado__c")
	private String nombreConcatenado;
	
	@Column(name = "rut_empresa_laboral__c")
	private String rutEmpresaLaboral;

	@Column(name = "birthdate")
	private Date birthdate;

	@Column(name = "detalle_relaci_n__c")
	private String detalleRelacion;
	
	@Column(name = "sf4twitter__contact_source__c")
	private String sf4twitterContactSource;
	
	@Column(name = "mobilephone")
	private String mobilePhone;
	
	@Column(name = "masterrecordid")
	private String masterRecordId;
	
	@Column(name = "email_laboral__c")
	private String emailLaboral;
	
	@Column(name = "reportstoid")
	private String reportstoId;
	
	@Column(name = "accountid")
	private String accountId;
	
	@Column(name = "homephone")
	private String homePhone;
	
	@Column(name = "canal_preferente_de_contacto__c")
	private String canalPreferenteContacto;
	
	@Column(name = "tipo_de_cuenta_asociado__c")
	private String tipoCuentaAsociado;
	
	@Column(name = "apellido_materno__c")
	private String apellidoMaterno;
	
	@Column(name = "sf4twitter__origin__c")
	private String sf4twitterOrigin;
	
	@Column(name = "tipo_de_identidad__c")
	private String tipoIdentidad;
	
	@Column(name = "tel_fono_secundario__c")
	private String telefonoSecundario;
	
	@Column(name = "ownerid")
	private String ownerid;
	
	@Column(name = "email_secundario__c")
	private String emailSecundario;
	
	@Column(name = "lastmodifiedbyid")
	private String lastModifiedById;
	
	@Column(name = "tel_fono_adicional__c")
	private String telefonoAdicional;
	
	@Column(name = "assistantname")
	private String assistantName;
	
	@Column(name = "vip__c")
	private Boolean vip;
	
	@Column(name = "sf4twitter__fcbk_username__c")
	private String sf4twitterFcbkUsername;
	
	@Column(name = "direccion__c")
	private String direccion;
	
	@Column(name = "casos_reiterados__c")
	private Boolean casosReiterados;
	
	@Column(name = "reportsto__pruebatwitter__c")
	private String reportstoPruebaTwitter;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "otherphone")
	private String otherPhone;
	
	@Column(name = "department")
	private String department;
	
	@Column(name = "account__run__c")
	private String accountRun;
	
	@Column(name = "longtel2__c")
	private Double longtel2;
	
	@Column(name = "nombrecompleto__c")
	private String nombreCompleto;
	
	@Column(name = "dircontacto__c")
	private String dirContacto;
	
	@Column(name = "sf4twitter__twitter_user_id__c")
	private String sf4twitterTwitterUserId;
	
	@Column(name = "n_mero_serie_c_dula_identidad__c")
	private Double numeroSerieCedulaIdentidad;
	
	@Column(name = "masterrecord__pruebatwitter__c")
	private String masterRecordPruebaTwitter;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "sf4twitter__fcbk_user_id__c")
	private String sf4twitterFcbkUserId;
	
	@Column(name = "sf4twitter__twitter_username__c")
	private String sf4twitterTwitterUsername;
	
	@Column(name = "tipo_relaci_n_suministro__c")
	private String tipoRelacionSuministro;
	
	@Column(name = "id_empresa__c")
	private String idEmpresa;
	
	@Column(name = "tipo_de_contacto__c")
	private String tipoContacto;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "segmento_de_persona__c")
	private String segmentoPersona;
	
	@Column(name = "createdbyid")
	private String createdById;
	
	@Column(name = "apellido_paterno__c")
	private String apellidoPaterno;

	public Contact(Boolean isdeleted, Date systemmodstamp, String _hc_lastop, String _hc_err, Integer id, String sfid,
			Date createddate, String name, String parentRutEmpresa, Date fechaNacimiento, String nombreConcatenado,
			String rutEmpresaLaboral, Date birthdate, String detalleRelacion, String sf4twitterContactSource,
			String mobilePhone, String masterRecordId, String emailLaboral, String reportstoId, String accountId,
			String homePhone, String canalPreferenteContacto, String tipoCuentaAsociado, String apellidoMaterno,
			String sf4twitterOrigin, String tipoIdentidad, String telefonoSecundario, String ownerid,
			String emailSecundario, String lastModifiedById, String telefonoAdicional, String assistantName,
			Boolean vip, String sf4twitterFcbkUsername, String direccion, Boolean casosReiterados,
			String reportstoPruebaTwitter, String email, String otherPhone, String department, String accountRun,
			Double longtel2, String nombreCompleto, String dirContacto, String sf4twitterTwitterUserId,
			Double numeroSerieCedulaIdentidad, String masterRecordPruebaTwitter, String description,
			String sf4twitterFcbkUserId, String sf4twitterTwitterUsername, String tipoRelacionSuministro,
			String idEmpresa, String tipoContacto, String phone, String segmentoPersona, String createdById,
			String apellidoPaterno) {
		super();
		this.isdeleted = isdeleted;
		this.systemmodstamp = systemmodstamp;
		this._hc_lastop = _hc_lastop;
		this._hc_err = _hc_err;
		this.id = id;
		this.sfid = sfid;
		this.createddate = createddate;
		this.name = name;
		this.parentRutEmpresa = parentRutEmpresa;
		this.fechaNacimiento = fechaNacimiento;
		this.nombreConcatenado = nombreConcatenado;
		this.rutEmpresaLaboral = rutEmpresaLaboral;
		this.birthdate = birthdate;
		this.detalleRelacion = detalleRelacion;
		this.sf4twitterContactSource = sf4twitterContactSource;
		this.mobilePhone = mobilePhone;
		this.masterRecordId = masterRecordId;
		this.emailLaboral = emailLaboral;
		this.reportstoId = reportstoId;
		this.accountId = accountId;
		this.homePhone = homePhone;
		this.canalPreferenteContacto = canalPreferenteContacto;
		this.tipoCuentaAsociado = tipoCuentaAsociado;
		this.apellidoMaterno = apellidoMaterno;
		this.sf4twitterOrigin = sf4twitterOrigin;
		this.tipoIdentidad = tipoIdentidad;
		this.telefonoSecundario = telefonoSecundario;
		this.ownerid = ownerid;
		this.emailSecundario = emailSecundario;
		this.lastModifiedById = lastModifiedById;
		this.telefonoAdicional = telefonoAdicional;
		this.assistantName = assistantName;
		this.vip = vip;
		this.sf4twitterFcbkUsername = sf4twitterFcbkUsername;
		this.direccion = direccion;
		this.casosReiterados = casosReiterados;
		this.reportstoPruebaTwitter = reportstoPruebaTwitter;
		this.email = email;
		this.otherPhone = otherPhone;
		this.department = department;
		this.accountRun = accountRun;
		this.longtel2 = longtel2;
		this.nombreCompleto = nombreCompleto;
		this.dirContacto = dirContacto;
		this.sf4twitterTwitterUserId = sf4twitterTwitterUserId;
		this.numeroSerieCedulaIdentidad = numeroSerieCedulaIdentidad;
		this.masterRecordPruebaTwitter = masterRecordPruebaTwitter;
		this.description = description;
		this.sf4twitterFcbkUserId = sf4twitterFcbkUserId;
		this.sf4twitterTwitterUsername = sf4twitterTwitterUsername;
		this.tipoRelacionSuministro = tipoRelacionSuministro;
		this.idEmpresa = idEmpresa;
		this.tipoContacto = tipoContacto;
		this.phone = phone;
		this.segmentoPersona = segmentoPersona;
		this.createdById = createdById;
		this.apellidoPaterno = apellidoPaterno;
	}

	public Contact() {
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParentRutEmpresa() {
		return parentRutEmpresa;
	}

	public void setParentRutEmpresa(String parentRutEmpresa) {
		this.parentRutEmpresa = parentRutEmpresa;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombreConcatenado() {
		return nombreConcatenado;
	}

	public void setNombreConcatenado(String nombreConcatenado) {
		this.nombreConcatenado = nombreConcatenado;
	}

	public String getRutEmpresaLaboral() {
		return rutEmpresaLaboral;
	}

	public void setRutEmpresaLaboral(String rutEmpresaLaboral) {
		this.rutEmpresaLaboral = rutEmpresaLaboral;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getDetalleRelacion() {
		return detalleRelacion;
	}

	public void setDetalleRelacion(String detalleRelacion) {
		this.detalleRelacion = detalleRelacion;
	}

	public String getSf4twitterContactSource() {
		return sf4twitterContactSource;
	}

	public void setSf4twitterContactSource(String sf4twitterContactSource) {
		this.sf4twitterContactSource = sf4twitterContactSource;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getMasterRecordId() {
		return masterRecordId;
	}

	public void setMasterRecordId(String masterRecordId) {
		this.masterRecordId = masterRecordId;
	}

	public String getEmailLaboral() {
		return emailLaboral;
	}

	public void setEmailLaboral(String emailLaboral) {
		this.emailLaboral = emailLaboral;
	}

	public String getReportstoId() {
		return reportstoId;
	}

	public void setReportstoId(String reportstoId) {
		this.reportstoId = reportstoId;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getCanalPreferenteContacto() {
		return canalPreferenteContacto;
	}

	public void setCanalPreferenteContacto(String canalPreferenteContacto) {
		this.canalPreferenteContacto = canalPreferenteContacto;
	}

	public String getTipoCuentaAsociado() {
		return tipoCuentaAsociado;
	}

	public void setTipoCuentaAsociado(String tipoCuentaAsociado) {
		this.tipoCuentaAsociado = tipoCuentaAsociado;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getSf4twitterOrigin() {
		return sf4twitterOrigin;
	}

	public void setSf4twitterOrigin(String sf4twitterOrigin) {
		this.sf4twitterOrigin = sf4twitterOrigin;
	}

	public String getTipoIdentidad() {
		return tipoIdentidad;
	}

	public void setTipoIdentidad(String tipoIdentidad) {
		this.tipoIdentidad = tipoIdentidad;
	}

	public String getTelefonoSecundario() {
		return telefonoSecundario;
	}

	public void setTelefonoSecundario(String telefonoSecundario) {
		this.telefonoSecundario = telefonoSecundario;
	}

	public String getOwnerid() {
		return ownerid;
	}

	public void setOwnerid(String ownerid) {
		this.ownerid = ownerid;
	}

	public String getEmailSecundario() {
		return emailSecundario;
	}

	public void setEmailSecundario(String emailSecundario) {
		this.emailSecundario = emailSecundario;
	}

	public String getLastModifiedById() {
		return lastModifiedById;
	}

	public void setLastModifiedById(String lastModifiedById) {
		this.lastModifiedById = lastModifiedById;
	}

	public String getTelefonoAdicional() {
		return telefonoAdicional;
	}

	public void setTelefonoAdicional(String telefonoAdicional) {
		this.telefonoAdicional = telefonoAdicional;
	}

	public String getAssistantName() {
		return assistantName;
	}

	public void setAssistantName(String assistantName) {
		this.assistantName = assistantName;
	}

	public Boolean getVip() {
		return vip;
	}

	public void setVip(Boolean vip) {
		this.vip = vip;
	}

	public String getSf4twitterFcbkUsername() {
		return sf4twitterFcbkUsername;
	}

	public void setSf4twitterFcbkUsername(String sf4twitterFcbkUsername) {
		this.sf4twitterFcbkUsername = sf4twitterFcbkUsername;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Boolean getCasosReiterados() {
		return casosReiterados;
	}

	public void setCasosReiterados(Boolean casosReiterados) {
		this.casosReiterados = casosReiterados;
	}

	public String getReportstoPruebaTwitter() {
		return reportstoPruebaTwitter;
	}

	public void setReportstoPruebaTwitter(String reportstoPruebaTwitter) {
		this.reportstoPruebaTwitter = reportstoPruebaTwitter;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOtherPhone() {
		return otherPhone;
	}

	public void setOtherPhone(String otherPhone) {
		this.otherPhone = otherPhone;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getAccountRun() {
		return accountRun;
	}

	public void setAccountRun(String accountRun) {
		this.accountRun = accountRun;
	}

	public Double getLongtel2() {
		return longtel2;
	}

	public void setLongtel2(Double longtel2) {
		this.longtel2 = longtel2;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getDirContacto() {
		return dirContacto;
	}

	public void setDirContacto(String dirContacto) {
		this.dirContacto = dirContacto;
	}

	public String getSf4twitterTwitterUserId() {
		return sf4twitterTwitterUserId;
	}

	public void setSf4twitterTwitterUserId(String sf4twitterTwitterUserId) {
		this.sf4twitterTwitterUserId = sf4twitterTwitterUserId;
	}

	public Double getNumeroSerieCedulaIdentidad() {
		return numeroSerieCedulaIdentidad;
	}

	public void setNumeroSerieCedulaIdentidad(Double numeroSerieCedulaIdentidad) {
		this.numeroSerieCedulaIdentidad = numeroSerieCedulaIdentidad;
	}

	public String getMasterRecordPruebaTwitter() {
		return masterRecordPruebaTwitter;
	}

	public void setMasterRecordPruebaTwitter(String masterRecordPruebaTwitter) {
		this.masterRecordPruebaTwitter = masterRecordPruebaTwitter;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSf4twitterFcbkUserId() {
		return sf4twitterFcbkUserId;
	}

	public void setSf4twitterFcbkUserId(String sf4twitterFcbkUserId) {
		this.sf4twitterFcbkUserId = sf4twitterFcbkUserId;
	}

	public String getSf4twitterTwitterUsername() {
		return sf4twitterTwitterUsername;
	}

	public void setSf4twitterTwitterUsername(String sf4twitterTwitterUsername) {
		this.sf4twitterTwitterUsername = sf4twitterTwitterUsername;
	}

	public String getTipoRelacionSuministro() {
		return tipoRelacionSuministro;
	}

	public void setTipoRelacionSuministro(String tipoRelacionSuministro) {
		this.tipoRelacionSuministro = tipoRelacionSuministro;
	}

	public String getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(String idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getTipoContacto() {
		return tipoContacto;
	}

	public void setTipoContacto(String tipoContacto) {
		this.tipoContacto = tipoContacto;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSegmentoPersona() {
		return segmentoPersona;
	}

	public void setSegmentoPersona(String segmentoPersona) {
		this.segmentoPersona = segmentoPersona;
	}

	public String getCreatedById() {
		return createdById;
	}

	public void setCreatedById(String createdById) {
		this.createdById = createdById;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}


	
}