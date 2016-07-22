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
	private String parent__rut_empresa;
	
	@Column(name = "fecha_nacimiento__c")
	private Date fecha_nacimiento;
	
	@Column(name = "nombre_concatenado__c")
	private String nombre_concatenado;
	
	@Column(name = "rut_empresa_laboral__c")
	private String rut_empresa_laboral;

	@Column(name = "birthdate")
	private Date birthdate;

	@Column(name = "detalle_relaci_n__c")
	private String detalle_relaci_n;
	
	@Column(name = "sf4twitter__contact_source__c")
	private String sf4twitter__contact_source;
	
	@Column(name = "mobilephone")
	private String mobilephone;
	
	@Column(name = "masterrecordid")
	private String masterrecordid;
	
	@Column(name = "email_laboral__c")
	private String email_laboral;
	
	@Column(name = "reportstoid")
	private String reportstoid;
	
	@Column(name = "accountid")
	private String accountid;
	
	@Column(name = "homephone")
	private String homephone;
	
	@Column(name = "canal_preferente_de_contacto__c")
	private String canal_preferente_de_contacto;
	
	@Column(name = "tipo_de_cuenta_asociado__c")
	private String tipo_de_cuenta_asociado;
	
	@Column(name = "apellido_materno__c")
	private String apellido_materno;
	
	@Column(name = "sf4twitter__origin__c")
	private String sf4twitter__origin;
	
	@Column(name = "tipo_de_identidad__c")
	private String tipo_de_identidad;
	
	@Column(name = "tel_fono_secundario__c")
	private String tel_fono_secundario;
	
	@Column(name = "ownerid")
	private String ownerid;
	
	@Column(name = "email_secundario__c")
	private String email_secundario;
	
	@Column(name = "lastmodifiedbyid")
	private String lastmodifiedbyid;
	
	@Column(name = "tel_fono_adicional__c")
	private String tel_fono_adicional;
	
	@Column(name = "assistantname")
	private String assistantname;
	
	@Column(name = "vip__c")
	private Boolean vip;
	
	@Column(name = "sf4twitter__fcbk_username__c")
	private String sf4twitter__fcbk_username;
	
	@Column(name = "direccion__c")
	private String direccion;
	
	@Column(name = "casos_reiterados__c")
	private Boolean casos_reiterados;
	
	@Column(name = "reportsto__pruebatwitter__c")
	private String reportsto__pruebatwitter;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "otherphone")
	private String otherphone;
	
	@Column(name = "department")
	private String department;
	
	@Column(name = "account__run__c")
	private String account__run;
	
	@Column(name = "longtel2__c")
	private Double longtel2;
	
	@Column(name = "nombrecompleto__c")
	private String nombrecompleto;
	
	@Column(name = "dircontacto__c")
	private String dircontacto;
	
	@Column(name = "sf4twitter__twitter_user_id__c")
	private String sf4twitter__twitter_user_id;
	
	@Column(name = "n_mero_serie_c_dula_identidad__c")
	private Double n_mero_serie_c_dula_identidad;
	
	@Column(name = "masterrecord__pruebatwitter__c")
	private String masterrecord__pruebatwitter;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "sf4twitter__fcbk_user_id__c")
	private String sf4twitter__fcbk_user_id;
	
	@Column(name = "sf4twitter__twitter_username__c")
	private String sf4twitter__twitter_username;
	
	@Column(name = "tipo_relaci_n_suministro__c")
	private String tipo_relaci_n_suministro;
	
	@Column(name = "id_empresa__c")
	private String id_empresa;
	
	@Column(name = "tipo_de_contacto__c")
	private String tipo_de_contacto;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "segmento_de_persona__c")
	private String segmento_de_persona;
	
	@Column(name = "createdbyid")
	private String createdbyid;
	
	@Column(name = "apellido_paterno__c")
	private String apellido_paterno;

	public Contact(Boolean isdeleted, Date systemmodstamp, String _hc_lastop, String _hc_err, Integer id, String sfid,
			Date createddate, String name, String parent__rut_empresa, Date fecha_nacimiento, String nombre_concatenado,
			String rut_empresa_laboral, Date birthdate, String detalle_relaci_n, String sf4twitter__contact_source,
			String mobilephone, String masterrecordid, String email_laboral, String reportstoid, String accountid,
			String homephone, String canal_preferente_de_contacto, String tipo_de_cuenta_asociado,
			String apellido_materno, String sf4twitter__origin, String tipo_de_identidad, String tel_fono_secundario,
			String ownerid, String email_secundario, String lastmodifiedbyid, String tel_fono_adicional,
			String assistantname, Boolean vip, String sf4twitter__fcbk_username, String direccion,
			Boolean casos_reiterados, String reportsto__pruebatwitter, String email, String otherphone,
			String department, String account__run, Double longtel2, String nombrecompleto, String dircontacto,
			String sf4twitter__twitter_user_id, Double n_mero_serie_c_dula_identidad,
			String masterrecord__pruebatwitter, String description, String sf4twitter__fcbk_user_id,
			String sf4twitter__twitter_username, String tipo_relaci_n_suministro, String id_empresa,
			String tipo_de_contacto, String phone, String segmento_de_persona, String createdbyid,
			String apellido_paterno) {
		super();
		this.isdeleted = isdeleted;
		this.systemmodstamp = systemmodstamp;
		this._hc_lastop = _hc_lastop;
		this._hc_err = _hc_err;
		this.id = id;
		this.sfid = sfid;
		this.createddate = createddate;
		this.name = name;
		this.parent__rut_empresa = parent__rut_empresa;
		this.fecha_nacimiento = fecha_nacimiento;
		this.nombre_concatenado = nombre_concatenado;
		this.rut_empresa_laboral = rut_empresa_laboral;
		this.birthdate = birthdate;
		this.detalle_relaci_n = detalle_relaci_n;
		this.sf4twitter__contact_source = sf4twitter__contact_source;
		this.mobilephone = mobilephone;
		this.masterrecordid = masterrecordid;
		this.email_laboral = email_laboral;
		this.reportstoid = reportstoid;
		this.accountid = accountid;
		this.homephone = homephone;
		this.canal_preferente_de_contacto = canal_preferente_de_contacto;
		this.tipo_de_cuenta_asociado = tipo_de_cuenta_asociado;
		this.apellido_materno = apellido_materno;
		this.sf4twitter__origin = sf4twitter__origin;
		this.tipo_de_identidad = tipo_de_identidad;
		this.tel_fono_secundario = tel_fono_secundario;
		this.ownerid = ownerid;
		this.email_secundario = email_secundario;
		this.lastmodifiedbyid = lastmodifiedbyid;
		this.tel_fono_adicional = tel_fono_adicional;
		this.assistantname = assistantname;
		this.vip = vip;
		this.sf4twitter__fcbk_username = sf4twitter__fcbk_username;
		this.direccion = direccion;
		this.casos_reiterados = casos_reiterados;
		this.reportsto__pruebatwitter = reportsto__pruebatwitter;
		this.email = email;
		this.otherphone = otherphone;
		this.department = department;
		this.account__run = account__run;
		this.longtel2 = longtel2;
		this.nombrecompleto = nombrecompleto;
		this.dircontacto = dircontacto;
		this.sf4twitter__twitter_user_id = sf4twitter__twitter_user_id;
		this.n_mero_serie_c_dula_identidad = n_mero_serie_c_dula_identidad;
		this.masterrecord__pruebatwitter = masterrecord__pruebatwitter;
		this.description = description;
		this.sf4twitter__fcbk_user_id = sf4twitter__fcbk_user_id;
		this.sf4twitter__twitter_username = sf4twitter__twitter_username;
		this.tipo_relaci_n_suministro = tipo_relaci_n_suministro;
		this.id_empresa = id_empresa;
		this.tipo_de_contacto = tipo_de_contacto;
		this.phone = phone;
		this.segmento_de_persona = segmento_de_persona;
		this.createdbyid = createdbyid;
		this.apellido_paterno = apellido_paterno;
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

	public String getParent__rut_empresa() {
		return parent__rut_empresa;
	}

	public void setParent__rut_empresa(String parent__rut_empresa) {
		this.parent__rut_empresa = parent__rut_empresa;
	}

	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getNombre_concatenado() {
		return nombre_concatenado;
	}

	public void setNombre_concatenado(String nombre_concatenado) {
		this.nombre_concatenado = nombre_concatenado;
	}

	public String getRut_empresa_laboral() {
		return rut_empresa_laboral;
	}

	public void setRut_empresa_laboral(String rut_empresa_laboral) {
		this.rut_empresa_laboral = rut_empresa_laboral;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getDetalle_relaci_n() {
		return detalle_relaci_n;
	}

	public void setDetalle_relaci_n(String detalle_relaci_n) {
		this.detalle_relaci_n = detalle_relaci_n;
	}

	public String getSf4twitter__contact_source() {
		return sf4twitter__contact_source;
	}

	public void setSf4twitter__contact_source(String sf4twitter__contact_source) {
		this.sf4twitter__contact_source = sf4twitter__contact_source;
	}

	public String getMobilephone() {
		return mobilephone;
	}

	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}

	public String getMasterrecordid() {
		return masterrecordid;
	}

	public void setMasterrecordid(String masterrecordid) {
		this.masterrecordid = masterrecordid;
	}

	public String getEmail_laboral() {
		return email_laboral;
	}

	public void setEmail_laboral(String email_laboral) {
		this.email_laboral = email_laboral;
	}

	public String getReportstoid() {
		return reportstoid;
	}

	public void setReportstoid(String reportstoid) {
		this.reportstoid = reportstoid;
	}

	public String getAccountid() {
		return accountid;
	}

	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}

	public String getHomephone() {
		return homephone;
	}

	public void setHomephone(String homephone) {
		this.homephone = homephone;
	}

	public String getCanal_preferente_de_contacto() {
		return canal_preferente_de_contacto;
	}

	public void setCanal_preferente_de_contacto(String canal_preferente_de_contacto) {
		this.canal_preferente_de_contacto = canal_preferente_de_contacto;
	}

	public String getTipo_de_cuenta_asociado() {
		return tipo_de_cuenta_asociado;
	}

	public void setTipo_de_cuenta_asociado(String tipo_de_cuenta_asociado) {
		this.tipo_de_cuenta_asociado = tipo_de_cuenta_asociado;
	}

	public String getApellido_materno() {
		return apellido_materno;
	}

	public void setApellido_materno(String apellido_materno) {
		this.apellido_materno = apellido_materno;
	}

	public String getSf4twitter__origin() {
		return sf4twitter__origin;
	}

	public void setSf4twitter__origin(String sf4twitter__origin) {
		this.sf4twitter__origin = sf4twitter__origin;
	}

	public String getTipo_de_identidad() {
		return tipo_de_identidad;
	}

	public void setTipo_de_identidad(String tipo_de_identidad) {
		this.tipo_de_identidad = tipo_de_identidad;
	}

	public String getTel_fono_secundario() {
		return tel_fono_secundario;
	}

	public void setTel_fono_secundario(String tel_fono_secundario) {
		this.tel_fono_secundario = tel_fono_secundario;
	}

	public String getOwnerid() {
		return ownerid;
	}

	public void setOwnerid(String ownerid) {
		this.ownerid = ownerid;
	}

	public String getEmail_secundario() {
		return email_secundario;
	}

	public void setEmail_secundario(String email_secundario) {
		this.email_secundario = email_secundario;
	}

	public String getLastmodifiedbyid() {
		return lastmodifiedbyid;
	}

	public void setLastmodifiedbyid(String lastmodifiedbyid) {
		this.lastmodifiedbyid = lastmodifiedbyid;
	}

	public String getTel_fono_adicional() {
		return tel_fono_adicional;
	}

	public void setTel_fono_adicional(String tel_fono_adicional) {
		this.tel_fono_adicional = tel_fono_adicional;
	}

	public String getAssistantname() {
		return assistantname;
	}

	public void setAssistantname(String assistantname) {
		this.assistantname = assistantname;
	}

	public Boolean getVip() {
		return vip;
	}

	public void setVip(Boolean vip) {
		this.vip = vip;
	}

	public String getSf4twitter__fcbk_username() {
		return sf4twitter__fcbk_username;
	}

	public void setSf4twitter__fcbk_username(String sf4twitter__fcbk_username) {
		this.sf4twitter__fcbk_username = sf4twitter__fcbk_username;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Boolean getCasos_reiterados() {
		return casos_reiterados;
	}

	public void setCasos_reiterados(Boolean casos_reiterados) {
		this.casos_reiterados = casos_reiterados;
	}

	public String getReportsto__pruebatwitter() {
		return reportsto__pruebatwitter;
	}

	public void setReportsto__pruebatwitter(String reportsto__pruebatwitter) {
		this.reportsto__pruebatwitter = reportsto__pruebatwitter;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOtherphone() {
		return otherphone;
	}

	public void setOtherphone(String otherphone) {
		this.otherphone = otherphone;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getAccount__run() {
		return account__run;
	}

	public void setAccount__run(String account__run) {
		this.account__run = account__run;
	}

	public Double getLongtel2() {
		return longtel2;
	}

	public void setLongtel2(Double longtel2) {
		this.longtel2 = longtel2;
	}

	public String getNombrecompleto() {
		return nombrecompleto;
	}

	public void setNombrecompleto(String nombrecompleto) {
		this.nombrecompleto = nombrecompleto;
	}

	public String getDircontacto() {
		return dircontacto;
	}

	public void setDircontacto(String dircontacto) {
		this.dircontacto = dircontacto;
	}

	public String getSf4twitter__twitter_user_id() {
		return sf4twitter__twitter_user_id;
	}

	public void setSf4twitter__twitter_user_id(String sf4twitter__twitter_user_id) {
		this.sf4twitter__twitter_user_id = sf4twitter__twitter_user_id;
	}

	public Double getN_mero_serie_c_dula_identidad() {
		return n_mero_serie_c_dula_identidad;
	}

	public void setN_mero_serie_c_dula_identidad(Double n_mero_serie_c_dula_identidad) {
		this.n_mero_serie_c_dula_identidad = n_mero_serie_c_dula_identidad;
	}

	public String getMasterrecord__pruebatwitter() {
		return masterrecord__pruebatwitter;
	}

	public void setMasterrecord__pruebatwitter(String masterrecord__pruebatwitter) {
		this.masterrecord__pruebatwitter = masterrecord__pruebatwitter;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSf4twitter__fcbk_user_id() {
		return sf4twitter__fcbk_user_id;
	}

	public void setSf4twitter__fcbk_user_id(String sf4twitter__fcbk_user_id) {
		this.sf4twitter__fcbk_user_id = sf4twitter__fcbk_user_id;
	}

	public String getSf4twitter__twitter_username() {
		return sf4twitter__twitter_username;
	}

	public void setSf4twitter__twitter_username(String sf4twitter__twitter_username) {
		this.sf4twitter__twitter_username = sf4twitter__twitter_username;
	}

	public String getTipo_relaci_n_suministro() {
		return tipo_relaci_n_suministro;
	}

	public void setTipo_relaci_n_suministro(String tipo_relaci_n_suministro) {
		this.tipo_relaci_n_suministro = tipo_relaci_n_suministro;
	}

	public String getId_empresa() {
		return id_empresa;
	}

	public void setId_empresa(String id_empresa) {
		this.id_empresa = id_empresa;
	}

	public String getTipo_de_contacto() {
		return tipo_de_contacto;
	}

	public void setTipo_de_contacto(String tipo_de_contacto) {
		this.tipo_de_contacto = tipo_de_contacto;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSegmento_de_persona() {
		return segmento_de_persona;
	}

	public void setSegmento_de_persona(String segmento_de_persona) {
		this.segmento_de_persona = segmento_de_persona;
	}

	public String getCreatedbyid() {
		return createdbyid;
	}

	public void setCreatedbyid(String createdbyid) {
		this.createdbyid = createdbyid;
	}

	public String getApellido_paterno() {
		return apellido_paterno;
	}

	public void setApellido_paterno(String apellido_paterno) {
		this.apellido_paterno = apellido_paterno;
	}
	
	
	
	

	
	
	

	

	
}