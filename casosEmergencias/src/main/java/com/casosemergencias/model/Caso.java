package com.casosemergencias.model;

import java.util.Date;

/**
 * @author MPC
 * 
 * Clase que contiene el modelo de un caso. Esta clase es la que utilizaremos en el Servicio.
 *
 */
public class Caso {

	private Integer id;
	private String sfid;
	
	private String motivo;  
	private String numeroCaso; 	 
	private String numeroInservice;
	private Date fechaApertura;	//createdCate
	private Date fechaEstimadoNormalizacion;
	private String propietarioCaso;	//owner
	private Date fechaCierre;
	private String subMotivo;
	private String condicionAgravante;
	private String tipoAtencionInterna;
	private Contacto contacto;
	private Suministro suministro;
	private String direccionSuministro;
	private String comuna;
	private String numeroMedidor;
	private Direccion direccion;
	private Cuenta cuenta;	
	private String cuerpoMail;
	private String respuestaCliente;
	private String estado;
	private String subEstado;
	private String canalOrigen;	//origin
	private String unidad;	//call_center
	private String casoPrincipal;	//parent
	private String asunto;	//subject
	private String descripcion;
	private String tipoAtencionSEC;
	private String canalNotificacion;
	private String telefonoContacto;
	private String emailNotificacion;
	private String peticion;
	
	private String idFacebook;
	private String twitter;
	private boolean actualizarDatosContancto;
	private String ani;
	private String favorabilidadCaso;
	
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
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public String getNumeroCaso() {
		return numeroCaso;
	}
	public void setNumeroCaso(String numeroCaso) {
		this.numeroCaso = numeroCaso;
	}
	public String getNumeroInservice() {
		return numeroInservice;
	}
	public void setNumeroInservice(String numeroInservice) {
		this.numeroInservice = numeroInservice;
	}
	public Date getFechaApertura() {
		return fechaApertura;
	}
	public void setFechaApertura(Date fechaApertura) {
		this.fechaApertura = fechaApertura;
	}
	public Date getFechaEstimadoNormalizacion() {
		return fechaEstimadoNormalizacion;
	}
	public void setFechaEstimadoNormalizacion(Date fechaEstimadoNormalizacion) {
		this.fechaEstimadoNormalizacion = fechaEstimadoNormalizacion;
	}
	public String getPropietarioCaso() {
		return propietarioCaso;
	}
	public void setPropietarioCaso(String propietarioCaso) {
		this.propietarioCaso = propietarioCaso;
	}
	public Date getFechaCierre() {
		return fechaCierre;
	}
	public void setFechaCierre(Date fechaCierre) {
		this.fechaCierre = fechaCierre;
	}
	public String getSubMotivo() {
		return subMotivo;
	}
	public void setSubMotivo(String subMotivo) {
		this.subMotivo = subMotivo;
	}
	public String getCondicionAgravante() {
		return condicionAgravante;
	}
	public void setCondicionAgravante(String condicionAgravante) {
		this.condicionAgravante = condicionAgravante;
	}
	public String getTipoAtencionInterna() {
		return tipoAtencionInterna;
	}
	public void setTipoAtencionInterna(String tipoAtencionInterna) {
		this.tipoAtencionInterna = tipoAtencionInterna;
	}
	public Contacto getContacto() {
		return contacto;
	}
	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}
	public Suministro getSuministro() {
		return suministro;
	}
	public void setSuministro(Suministro suministro) {
		this.suministro = suministro;
	}
	public String getDireccionSuministro() {
		return direccionSuministro;
	}
	public void setDireccionSuministro(String direccionSuministro) {
		this.direccionSuministro = direccionSuministro;
	}
	public String getComuna() {
		return comuna;
	}
	public void setComuna(String comuna) {
		this.comuna = comuna;
	}
	public String getNumeroMedidor() {
		return numeroMedidor;
	}
	public void setNumeroMedidor(String numeroMedidor) {
		this.numeroMedidor = numeroMedidor;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	public Cuenta getCuenta() {
		return cuenta;
	}
	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	public String getCuerpoMail() {
		return cuerpoMail;
	}
	public void setCuerpoMail(String cuerpoMail) {
		this.cuerpoMail = cuerpoMail;
	}
	public String getRespuestaCliente() {
		return respuestaCliente;
	}
	public void setRespuestaCliente(String respuestaCliente) {
		this.respuestaCliente = respuestaCliente;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getSubEstado() {
		return subEstado;
	}
	public void setSubEstado(String subEstado) {
		this.subEstado = subEstado;
	}
	public String getCanalOrigen() {
		return canalOrigen;
	}
	public void setCanalOrigen(String canalOrigen) {
		this.canalOrigen = canalOrigen;
	}
	public String getUnidad() {
		return unidad;
	}
	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}
	public String getCasoPrincipal() {
		return casoPrincipal;
	}
	public void setCasoPrincipal(String casoPrincipal) {
		this.casoPrincipal = casoPrincipal;
	}
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getTipoAtencionSEC() {
		return tipoAtencionSEC;
	}
	public void setTipoAtencionSEC(String tipoAtencionSEC) {
		this.tipoAtencionSEC = tipoAtencionSEC;
	}
	public String getCanalNotificacion() {
		return canalNotificacion;
	}
	public void setCanalNotificacion(String canalNotificacion) {
		this.canalNotificacion = canalNotificacion;
	}
	public String getTelefonoContacto() {
		return telefonoContacto;
	}
	public void setTelefonoContacto(String telefonoContacto) {
		this.telefonoContacto = telefonoContacto;
	}
	public String getEmailNotificacion() {
		return emailNotificacion;
	}
	public void setEmailNotificacion(String emailNotificacion) {
		this.emailNotificacion = emailNotificacion;
	}
	public String getIdFacebook() {
		return idFacebook;
	}
	public void setIdFacebook(String idFacebook) {
		this.idFacebook = idFacebook;
	}
	public String getTwitter() {
		return twitter;
	}
	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}
	public String getAni() {
		return ani;
	}
	public void setAni(String ani) {
		this.ani = ani;
	}
	public String getFavorabilidadCaso() {
		return favorabilidadCaso;
	}
	public void setFavorabilidadCaso(String favorabilidadCaso) {
		this.favorabilidadCaso = favorabilidadCaso;
	}
	public boolean isActualizarDatosContancto() {
		return actualizarDatosContancto;
	}
	public void setActualizarDatosContancto(boolean actualizarDatosContancto) {
		this.actualizarDatosContancto = actualizarDatosContancto;
	}
	public String getPeticion() {
		return peticion;
	}
	public void setPeticion(String peticion) {
		this.peticion = peticion;
	}
	
	
	
}
