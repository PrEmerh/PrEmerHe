package com.casosemergencias.model;

import java.util.Date;

//Objeto que tiene el modelo de un contacto, se utiliza en el Servicio


public class Contacto {

	/*ID*/                                  private Integer id;
	/*SFID*/                               private String sfid;
	/*Nombre*/                              private String name;
	/*Apellido Paterno*/                    private String apellidoPaterno;
	/*Apellido Materno*/                    private String apellidoMaterno;
	/*Tipo de Identidad*/                   private String tipoIdentidad;
	/*RUN*/                                 private String accountRun;
	/*Canal Preferente de Contacto*/        private String canalPreferenteContacto;
	/*Teléfono Principal*/                  private String phone;
	/*Teléfono Secundario*/                 private String telefonoSecundario;
	/*Email Principal*/                     private String email;
	/*Fecha nacimiento*/                    private Date fechaNacimiento;
	/*Nombre de la cuenta/*
	/*Dirección Contacto*/                  private String dirContacto;
	/*Email secundario*/                    private String emailSecundario;
	/*Nombre de usuario de Twitter*/        private String sf4twitterTwitterUsername;
	/*Recuento de seguidores de Twitter*/ 
	/*Influencer*/
	/*Influencer Tipo*/
	/*Biografía de Twitter*/
	/*Id. de usuario de Twitter*/           private String sf4twitterTwitterUserId;
	/*Nombre de usuario de Facebook*/       private String sf4twitterFcbkUsername;
	/*Id. de usuario de Facebook*/          private String sf4twitterFcbkUserId; 
	/*Tipo de contacto*/                    private String tipoContacto;
	/*Casos reiterados*/                    private Boolean casosReiterados;
	/*Tipo cuenta asociadas*/               private String tipoCuentaAsociado;
	
	
	
	/* Getters y Setters */
	
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
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
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
	public String getAccountRun() {
		return accountRun;
	}
	public void setAccountRun(String accountRun) {
		this.accountRun = accountRun;
	}
	public String getCanalPreferenteContacto() {
		return canalPreferenteContacto;
	}
	public void setCanalPreferenteContacto(String canalPreferenteContacto) {
		this.canalPreferenteContacto = canalPreferenteContacto;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getTelefonoSecundario() {
		return telefonoSecundario;
	}
	public void setTelefonoSecundario(String telefonoSecundario) {
		this.telefonoSecundario = telefonoSecundario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getDirContacto() {
		return dirContacto;
	}
	public void setDirContacto(String dirContacto) {
		this.dirContacto = dirContacto;
	}
	public String getEmailSecundario() {
		return emailSecundario;
	}
	public void setEmailSecundario(String emailSecundario) {
		this.emailSecundario = emailSecundario;
	}
	public String getSf4twitterTwitterUsername() {
		return sf4twitterTwitterUsername;
	}
	public void setSf4twitterTwitterUsername(String sf4twitterTwitterUsername) {
		this.sf4twitterTwitterUsername = sf4twitterTwitterUsername;
	}
	public String getSf4twitterTwitterUserId() {
		return sf4twitterTwitterUserId;
	}
	public void setSf4twitterTwitterUserId(String sf4twitterTwitterUserId) {
		this.sf4twitterTwitterUserId = sf4twitterTwitterUserId;
	}
	public String getSf4twitterFcbkUsername() {
		return sf4twitterFcbkUsername;
	}
	public void setSf4twitterFcbkUsername(String sf4twitterFcbkUsername) {
		this.sf4twitterFcbkUsername = sf4twitterFcbkUsername;
	}
	public String getSf4twitterFcbkUserId() {
		return sf4twitterFcbkUserId;
	}
	public void setSf4twitterFcbkUserId(String sf4twitterFcbkUserId) {
		this.sf4twitterFcbkUserId = sf4twitterFcbkUserId;
	}
	public String getTipoContacto() {
		return tipoContacto;
	}
	public void setTipoContacto(String tipoContacto) {
		this.tipoContacto = tipoContacto;
	}
	public Boolean getCasosReiterados() {
		return casosReiterados;
	}
	public void setCasosReiterados(Boolean casosReiterados) {
		this.casosReiterados = casosReiterados;
	}
	public String getTipoCuentaAsociado() {
		return tipoCuentaAsociado;
	}
	public void setTipoCuentaAsociado(String tipoCuentaAsociado) {
		this.tipoCuentaAsociado = tipoCuentaAsociado;
	}

	

	
	
	
	
}