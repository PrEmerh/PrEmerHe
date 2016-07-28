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
public class ContactVO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	//campo de Heroku
	//Used to track the IsDeleted field from Salesforce allowing Heroku Connect to handle deletes when polling for updates
	@Column(name = "isdeleted")
	private Boolean isDeleted;
	//campo de Heroku
	//Used to track the IsDeleted field from Salesforce allowing Heroku Connect to handle deletes when polling for updates
	@Column(name = "systemmodstamp")
	private Date systemDate;
	//campo de Heroku
	@Column(name = "_hc_lastop")
	private String hcLastop;
	//campo de Heroku
	@Column(name = "_hc_err")
	private String hcError;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "sfid")
	private String sfid;

	@Column(name = "name")
	private String name;
	
	@Column(name = "fecha_nacimiento__c")
	private Date fechaNacimiento;

	@Column(name = "canal_preferente_de_contacto__c")
	private String canalPreferenteContacto;
	
	@Column(name = "tipo_de_cuenta_asociado__c")
	private String tipoCuentaAsociado;
	
	@Column(name = "apellido_materno__c")
	private String apellidoMaterno;
	
	@Column(name = "tipo_de_identidad__c")
	private String tipoIdentidad;
	
	@Column(name = "tel_fono_secundario__c")
	private String telefonoSecundario;

	@Column(name = "email_secundario__c")
	private String emailSecundario;
		
	@Column(name = "sf4twitter__fcbk_username__c")
	private String sf4twitterFcbkUsername;

	@Column(name = "casos_reiterados__c")
	private Boolean casosReiterados;
	
	@Column(name = "email")
	private String email;
		
	@Column(name = "account__run__c")
	private String accountRun;
		
	@Column(name = "dircontacto__c")
	private String dirContacto;
	
	@Column(name = "sf4twitter__twitter_user_id__c")
	private String sf4twitterTwitterUserId;
	
	@Column(name = "sf4twitter__fcbk_user_id__c")
	private String sf4twitterFcbkUserId;
	
	@Column(name = "sf4twitter__twitter_username__c")
	private String sf4twitterTwitterUsername;
		
	@Column(name = "tipo_de_contacto__c")
	private String tipoContacto;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "apellido_paterno__c")
	private String apellidoPaterno;
	
	/*Nombre de la cuenta/*
	/*Recuento de seguidores de Twitter*/ 
	/*Influencer*/
	/*Influencer Tipo*/
	/*Biografía de Twitter*/

	public ContactVO(Boolean isDeleted, Date systemDate, String hcLastop, String hcError, Integer id, String sfid,
			String name, Date fechaNacimiento, String canalPreferenteContacto, String tipoCuentaAsociado,
			String apellidoMaterno, String tipoIdentidad, String telefonoSecundario, String emailSecundario,
			String sf4twitterFcbkUsername, Boolean casosReiterados, String email, String accountRun, String dirContacto,
			String sf4twitterTwitterUserId, String sf4twitterFcbkUserId, String sf4twitterTwitterUsername,
			String tipoContacto, String phone, String apellidoPaterno) {
		super();
		this.isDeleted = isDeleted;
		this.systemDate = systemDate;
		this.hcLastop = hcLastop;
		this.hcError = hcError;
		this.id = id;
		this.sfid = sfid;
		this.name = name;
		this.fechaNacimiento = fechaNacimiento;
		this.canalPreferenteContacto = canalPreferenteContacto;
		this.tipoCuentaAsociado = tipoCuentaAsociado;
		this.apellidoMaterno = apellidoMaterno;
		this.tipoIdentidad = tipoIdentidad;
		this.telefonoSecundario = telefonoSecundario;
		this.emailSecundario = emailSecundario;
		this.sf4twitterFcbkUsername = sf4twitterFcbkUsername;
		this.casosReiterados = casosReiterados;
		this.email = email;
		this.accountRun = accountRun;
		this.dirContacto = dirContacto;
		this.sf4twitterTwitterUserId = sf4twitterTwitterUserId;
		this.sf4twitterFcbkUserId = sf4twitterFcbkUserId;
		this.sf4twitterTwitterUsername = sf4twitterTwitterUsername;
		this.tipoContacto = tipoContacto;
		this.phone = phone;
		this.apellidoPaterno = apellidoPaterno;
	}

	public ContactVO() {
		super();
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Date getSystemDate() {
		return systemDate;
	}

	public void setSystemDate(Date systemDate) {
		this.systemDate = systemDate;
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

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
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

	public String getEmailSecundario() {
		return emailSecundario;
	}

	public void setEmailSecundario(String emailSecundario) {
		this.emailSecundario = emailSecundario;
	}

	public String getSf4twitterFcbkUsername() {
		return sf4twitterFcbkUsername;
	}

	public void setSf4twitterFcbkUsername(String sf4twitterFcbkUsername) {
		this.sf4twitterFcbkUsername = sf4twitterFcbkUsername;
	}

	public Boolean getCasosReiterados() {
		return casosReiterados;
	}

	public void setCasosReiterados(Boolean casosReiterados) {
		this.casosReiterados = casosReiterados;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAccountRun() {
		return accountRun;
	}

	public void setAccountRun(String accountRun) {
		this.accountRun = accountRun;
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

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	 

	
	
	
	
	
	
}
