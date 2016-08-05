package com.casosemergencias.controller.views;

import java.util.Date;
import java.util.List;

import com.casosemergencias.model.Cuenta;

public class AccountView extends ObjectView {
	/*ID*/                                  private Integer id;
	/*SFID*/                                private String sfid;
	/*Nombre de la cuenta*/                 private String name;
	/*Apellido Paterno*/                    private String apellidoPaterno;
	/*Apellido Materno*/                    private String apellidoMaterno;
	/*Tipo de Identidad*/                   private String tipoIdentidad;
//	/*RUN*/                                 private String accountRun;
	/*Fecha nacimiento*/       			    private Date fechaNacimiento;
	/*Teléfono Principal*/                  private String phone;
	/*Teléfono Secundario*/                 private String telefonoSecundario;
	/*Email Principal*/                     private String emailPrincipal;
	/*Email secundario*/                    private String emailSecundario;
	/*Dirección*/        					private String direccion;
	/*Cuenta principal*/ 					private String accountsource;
	/*Id Empresa*/							private String idEmpresa;
	/*Suministros asociados*/				private List<SuministroView> suministros;
	/*Contactos asociados*/					private List<ContactView> contactos;
	//Tipo de registro de cuenta
	
	
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
//	public String getAccountRun() {
//		return accountRun;
//	}
//	public void setAccountRun(String accountRun) {
//		this.accountRun = accountRun;
//	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
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
	public String getEmailPrincipal() {
		return emailPrincipal;
	}
	public void setEmailPrincipal(String emailPrincipal) {
		this.emailPrincipal = emailPrincipal;
	}
	public String getEmailSecundario() {
		return emailSecundario;
	}
	public void setEmailSecundario(String emailSecundario) {
		this.emailSecundario = emailSecundario;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getAccountsource() {
		return accountsource;
	}
	public void setAccountsource(String accountsource) {
		this.accountsource = accountsource;
	}
	public String getIdEmpresa() {
		return idEmpresa;
	}
	public void setIdEmpresa(String idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	public List<SuministroView> getSuministros() {
		return suministros;
	}
	public void setSuministros(List<SuministroView> suministros) {
		this.suministros = suministros;
	}
	public List<ContactView> getContactos() {
		return contactos;
	}
	public void setContactos(List<ContactView> contactos) {
		this.contactos = contactos;
	}
	
	@Override
	public Object instantiateTargetLogic() {
		Cuenta cuenta = new Cuenta();
		return cuenta;
	}
}