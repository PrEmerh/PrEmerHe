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
public class AccountVO implements Serializable{
	
	private static final long serialVersionUID = 1L;


	//campo de Heroku
	//Used to track the IsDeleted field from Salesforce allowing Heroku Connect to handle deletes when polling for updates
	@Column(name = "isdeleted")
	private Boolean isDeleted;
	//campo de Heroku
	//The date and time (in the UTC time zone) that the Salesforce object was last modified and used by Heroku Connect when polling for updates
	@Column(name = "systemmodstamp")
	private Date systemmodstamp;
	//campo de Heroku
	@Column(name = "_hc_lastop")
	private String hcLastop;
	//campo de Heroku
	@Column(name = "_hc_err")
	private String hcError;
	@Column(name = "createddate")
	private Date createddate;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "sfid")
	private String sfid;	
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "parent__rut_empresa__c")
	private String parentRutEmpresa;
	
	@Column(name = "fecha_nacimiento__c")
	private Date fechaNacimiento;
	
	@Column(name = "tipo_de_usuario_empresa__c")
	private String tipoUsuarioEmpresa;
	
	@Column(name = "id_empresa__c")
	private String idEmpresa;
	
	@Column(name = "masterrecord__run__c")
	private String masterrecordRun;
	
	@Column(name = "recordtypeid")
	private String recordtypeid;
	
	@Column(name = "codigo_cuenta__c")
	private String codigoCuenta;
	
	@Column(name = "tipo_de_identidad__c")
	private String tipoIdentidad;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "ejecutivo__c")
	private String ejecutivo;
	
	@Column(name = "rubro_empresa__c")
	private String rubroEmpresa;
	
	@Column(name = "parentid")
	private String parentid;
	
	@Column(name = "ownerid")
	private String ownerid;
	
	@Column(name = "email_secundario__c")
	private String emailSecundario;
	
	@Column(name = "tel_fono_principal__c")
	private String telefonoPrincipal;
	
	@Column(name = "masterrecordid")
	private String masterrecordid;
	
	@Column(name = "createdbyid")
	private String createdbyid;
	
	@Column(name = "tel_fono_secundario__c")
	private String telefonoSecundario;
	
	@Column(name = "accountsource")
	private String accountsource;
	
	@Column(name = "lastmodifiedbyid")
	private String lastmodifiedbyid;
	
	@Column(name = "giro__c")
	private String giro;
	
	@Column(name = "direccion__c")
	private String direccion;
	
	@Column(name = "raz_n_social_empresa__c")
	private String razonSocialEmpresa;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "email_principal__c")
	private String emailPrincipal;
	
	@Column(name = "apellido_paterno__c")
	private String apellidoPaterno;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "apellido_materno__c")
	private String apellidoMaterno;
	
	@Column(name = "tel_fono_adicional__c")
	private String telefonoAdicional;

	public AccountVO(Boolean isDeleted, Date systemmodstamp, String hcLastop, String hcError, Date createddate,
			Integer id, String sfid, String name, String parentRutEmpresa, Date fechaNacimiento,
			String tipoUsuarioEmpresa, String idEmpresa, String masterrecordRun, String recordtypeid,
			String codigoCuenta, String tipoIdentidad, String type, String ejecutivo, String rubroEmpresa,
			String parentid, String ownerid, String emailSecundario, String telefonoPrincipal, String masterrecordid,
			String createdbyid, String telefonoSecundario, String accountsource, String lastmodifiedbyid, String giro,
			String direccion, String razonSocialEmpresa, String description, String emailPrincipal,
			String apellidoPaterno, String phone, String apellidoMaterno, String telefonoAdicional) {
		super();
		this.isDeleted = isDeleted;
		this.systemmodstamp = systemmodstamp;
		this.hcLastop = hcLastop;
		this.hcError = hcError;
		this.createddate = createddate;
		this.id = id;
		this.sfid = sfid;
		this.name = name;
		this.parentRutEmpresa = parentRutEmpresa;
		this.fechaNacimiento = fechaNacimiento;
		this.tipoUsuarioEmpresa = tipoUsuarioEmpresa;
		this.idEmpresa = idEmpresa;
		this.masterrecordRun = masterrecordRun;
		this.recordtypeid = recordtypeid;
		this.codigoCuenta = codigoCuenta;
		this.tipoIdentidad = tipoIdentidad;
		this.type = type;
		this.ejecutivo = ejecutivo;
		this.rubroEmpresa = rubroEmpresa;
		this.parentid = parentid;
		this.ownerid = ownerid;
		this.emailSecundario = emailSecundario;
		this.telefonoPrincipal = telefonoPrincipal;
		this.masterrecordid = masterrecordid;
		this.createdbyid = createdbyid;
		this.telefonoSecundario = telefonoSecundario;
		this.accountsource = accountsource;
		this.lastmodifiedbyid = lastmodifiedbyid;
		this.giro = giro;
		this.direccion = direccion;
		this.razonSocialEmpresa = razonSocialEmpresa;
		this.description = description;
		this.emailPrincipal = emailPrincipal;
		this.apellidoPaterno = apellidoPaterno;
		this.phone = phone;
		this.apellidoMaterno = apellidoMaterno;
		this.telefonoAdicional = telefonoAdicional;
	}

	public AccountVO() {
		super();
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Date getSystemmodstamp() {
		return systemmodstamp;
	}

	public void setSystemmodstamp(Date systemmodstamp) {
		this.systemmodstamp = systemmodstamp;
	}

	public String getHcLastop() {
		return hcLastop;
	}

	public void setHcLastop(String hcLastop) {
		this.hcLastop = hcLastop;
	}

	public String getHcError() {
		return hcError;
	}

	public void setHcError(String hcError) {
		this.hcError = hcError;
	}

	public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
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

	public String getTipoUsuarioEmpresa() {
		return tipoUsuarioEmpresa;
	}

	public void setTipoUsuarioEmpresa(String tipoUsuarioEmpresa) {
		this.tipoUsuarioEmpresa = tipoUsuarioEmpresa;
	}

	public String getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(String idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getMasterrecordRun() {
		return masterrecordRun;
	}

	public void setMasterrecordRun(String masterrecordRun) {
		this.masterrecordRun = masterrecordRun;
	}

	public String getRecordtypeid() {
		return recordtypeid;
	}

	public void setRecordtypeid(String recordtypeid) {
		this.recordtypeid = recordtypeid;
	}

	public String getCodigoCuenta() {
		return codigoCuenta;
	}

	public void setCodigoCuenta(String codigoCuenta) {
		this.codigoCuenta = codigoCuenta;
	}

	public String getTipoIdentidad() {
		return tipoIdentidad;
	}

	public void setTipoIdentidad(String tipoIdentidad) {
		this.tipoIdentidad = tipoIdentidad;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEjecutivo() {
		return ejecutivo;
	}

	public void setEjecutivo(String ejecutivo) {
		this.ejecutivo = ejecutivo;
	}

	public String getRubroEmpresa() {
		return rubroEmpresa;
	}

	public void setRubroEmpresa(String rubroEmpresa) {
		this.rubroEmpresa = rubroEmpresa;
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

	public String getEmailSecundario() {
		return emailSecundario;
	}

	public void setEmailSecundario(String emailSecundario) {
		this.emailSecundario = emailSecundario;
	}

	public String getTelefonoPrincipal() {
		return telefonoPrincipal;
	}

	public void setTelefonoPrincipal(String telefonoPrincipal) {
		this.telefonoPrincipal = telefonoPrincipal;
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

	public String getTelefonoSecundario() {
		return telefonoSecundario;
	}

	public void setTelefonoSecundario(String telefonoSecundario) {
		this.telefonoSecundario = telefonoSecundario;
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

	public String getRazonSocialEmpresa() {
		return razonSocialEmpresa;
	}

	public void setRazonSocialEmpresa(String razonSocialEmpresa) {
		this.razonSocialEmpresa = razonSocialEmpresa;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmailPrincipal() {
		return emailPrincipal;
	}

	public void setEmailPrincipal(String emailPrincipal) {
		this.emailPrincipal = emailPrincipal;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getTelefonoAdicional() {
		return telefonoAdicional;
	}

	public void setTelefonoAdicional(String telefonoAdicional) {
		this.telefonoAdicional = telefonoAdicional;
	}

		
}
