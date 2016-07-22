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
@Table(name="salesforce.account")
public class Account implements Serializable{
	
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
	
	@Column(name = "tipo_de_usuario_empresa__c")
	private String tipo_de_usuario_empresa;
	
	@Column(name = "id_empresa__c")
	private String id_empresa;
	
	@Column(name = "masterrecord__run__c")
	private String masterrecord__run;
	
	@Column(name = "recordtypeid")
	private String recordtypeid;
	
	@Column(name = "codigo_cuenta__c")
	private String codigo_cuenta;
	
	@Column(name = "tipo_de_identidad__c")
	private String tipo_de_identidad;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "ejecutivo__c")
	private String ejecutivo__c;
	
	@Column(name = "rubro_empresa__c")
	private String rubro_empresa;
	
	@Column(name = "parentid")
	private String parentid;
	
	@Column(name = "ownerid")
	private String ownerid;
	
	@Column(name = "email_secundario__c")
	private String email_secundario;
	
	@Column(name = "tel_fono_principal__c")
	private String tel_fono_principal;
	
	@Column(name = "masterrecordid")
	private String masterrecordid;
	
	@Column(name = "createdbyid")
	private String createdbyid;
	
	@Column(name = "tel_fono_secundario__c")
	private String tel_fono_secundario;
	
	@Column(name = "accountsource")
	private String accountsource;
	
	@Column(name = "lastmodifiedbyid")
	private String lastmodifiedbyid;
	
	@Column(name = "giro__c")
	private String giro;
	
	@Column(name = "direccion__c")
	private String direccion;
	
	@Column(name = "raz_n_social_empresa__c")
	private String raz_n_social_empresa;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "email_principal__c")
	private String email_principal;
	
	@Column(name = "apellido_paterno__c")
	private String apellido_paterno;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "apellido_materno__c")
	private String apellido_materno;
	
	@Column(name = "tel_fono_adicional__c")
	private String tel_fono_adicional;

	public Account(Boolean isdeleted, Date systemmodstamp, String _hc_lastop, String _hc_err, Integer id, String sfid,
			Date createddate, String name, String parent__rut_empresa, Date fecha_nacimiento,
			String tipo_de_usuario_empresa, String id_empresa, String masterrecord__run, String recordtypeid,
			String codigo_cuenta, String tipo_de_identidad, String type, String ejecutivo__c, String rubro_empresa,
			String parentid, String ownerid, String email_secundario, String tel_fono_principal, String masterrecordid,
			String createdbyid, String tel_fono_secundario, String accountsource, String lastmodifiedbyid, String giro,
			String direccion, String raz_n_social_empresa, String description, String email_principal,
			String apellido_paterno, String phone, String apellido_materno, String tel_fono_adicional) {
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
		this.tipo_de_usuario_empresa = tipo_de_usuario_empresa;
		this.id_empresa = id_empresa;
		this.masterrecord__run = masterrecord__run;
		this.recordtypeid = recordtypeid;
		this.codigo_cuenta = codigo_cuenta;
		this.tipo_de_identidad = tipo_de_identidad;
		this.type = type;
		this.ejecutivo__c = ejecutivo__c;
		this.rubro_empresa = rubro_empresa;
		this.parentid = parentid;
		this.ownerid = ownerid;
		this.email_secundario = email_secundario;
		this.tel_fono_principal = tel_fono_principal;
		this.masterrecordid = masterrecordid;
		this.createdbyid = createdbyid;
		this.tel_fono_secundario = tel_fono_secundario;
		this.accountsource = accountsource;
		this.lastmodifiedbyid = lastmodifiedbyid;
		this.giro = giro;
		this.direccion = direccion;
		this.raz_n_social_empresa = raz_n_social_empresa;
		this.description = description;
		this.email_principal = email_principal;
		this.apellido_paterno = apellido_paterno;
		this.phone = phone;
		this.apellido_materno = apellido_materno;
		this.tel_fono_adicional = tel_fono_adicional;
	}

	public Account() {
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

	public String getTipo_de_usuario_empresa() {
		return tipo_de_usuario_empresa;
	}

	public void setTipo_de_usuario_empresa(String tipo_de_usuario_empresa) {
		this.tipo_de_usuario_empresa = tipo_de_usuario_empresa;
	}

	public String getId_empresa() {
		return id_empresa;
	}

	public void setId_empresa(String id_empresa) {
		this.id_empresa = id_empresa;
	}

	public String getMasterrecord__run() {
		return masterrecord__run;
	}

	public void setMasterrecord__run(String masterrecord__run) {
		this.masterrecord__run = masterrecord__run;
	}

	public String getRecordtypeid() {
		return recordtypeid;
	}

	public void setRecordtypeid(String recordtypeid) {
		this.recordtypeid = recordtypeid;
	}

	public String getCodigo_cuenta() {
		return codigo_cuenta;
	}

	public void setCodigo_cuenta(String codigo_cuenta) {
		this.codigo_cuenta = codigo_cuenta;
	}

	public String getTipo_de_identidad() {
		return tipo_de_identidad;
	}

	public void setTipo_de_identidad(String tipo_de_identidad) {
		this.tipo_de_identidad = tipo_de_identidad;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEjecutivo__c() {
		return ejecutivo__c;
	}

	public void setEjecutivo__c(String ejecutivo__c) {
		this.ejecutivo__c = ejecutivo__c;
	}

	public String getRubro_empresa() {
		return rubro_empresa;
	}

	public void setRubro_empresa(String rubro_empresa) {
		this.rubro_empresa = rubro_empresa;
	}

	public String getParentid() {
		return parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
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

	public String getTel_fono_principal() {
		return tel_fono_principal;
	}

	public void setTel_fono_principal(String tel_fono_principal) {
		this.tel_fono_principal = tel_fono_principal;
	}

	public String getMasterrecordid() {
		return masterrecordid;
	}

	public void setMasterrecordid(String masterrecordid) {
		this.masterrecordid = masterrecordid;
	}

	public String getCreatedbyid() {
		return createdbyid;
	}

	public void setCreatedbyid(String createdbyid) {
		this.createdbyid = createdbyid;
	}

	public String getTel_fono_secundario() {
		return tel_fono_secundario;
	}

	public void setTel_fono_secundario(String tel_fono_secundario) {
		this.tel_fono_secundario = tel_fono_secundario;
	}

	public String getAccountsource() {
		return accountsource;
	}

	public void setAccountsource(String accountsource) {
		this.accountsource = accountsource;
	}

	public String getLastmodifiedbyid() {
		return lastmodifiedbyid;
	}

	public void setLastmodifiedbyid(String lastmodifiedbyid) {
		this.lastmodifiedbyid = lastmodifiedbyid;
	}

	public String getGiro() {
		return giro;
	}

	public void setGiro(String giro) {
		this.giro = giro;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getRaz_n_social_empresa() {
		return raz_n_social_empresa;
	}

	public void setRaz_n_social_empresa(String raz_n_social_empresa) {
		this.raz_n_social_empresa = raz_n_social_empresa;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmail_principal() {
		return email_principal;
	}

	public void setEmail_principal(String email_principal) {
		this.email_principal = email_principal;
	}

	public String getApellido_paterno() {
		return apellido_paterno;
	}

	public void setApellido_paterno(String apellido_paterno) {
		this.apellido_paterno = apellido_paterno;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getApellido_materno() {
		return apellido_materno;
	}

	public void setApellido_materno(String apellido_materno) {
		this.apellido_materno = apellido_materno;
	}

	public String getTel_fono_adicional() {
		return tel_fono_adicional;
	}

	public void setTel_fono_adicional(String tel_fono_adicional) {
		this.tel_fono_adicional = tel_fono_adicional;
	}
	
	
	
	
	
	
	

	

	
}
