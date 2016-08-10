package com.casosemergencias.model;

import java.util.Date;

import com.casosemergencias.controller.views.CaseView;
import com.casosemergencias.dao.vo.CaseVO;

/**
 * @author MPC
 * 
 * Clase que contiene el modelo de un caso. Esta clase es la que utilizaremos en el Servicio.
 *
 */
public class Caso extends ObjectLogic {

	private Integer id;
	private String sfid;

	private String numeroCaso; 	 
	private String numeroInservice;
	private Date fechaApertura;	//createdCate
	private Date fechaEstimadaCierre;
	private String propietarioCaso;	//owner
	private Date fechaCierre;
	private String submotivo;
	private String condicionAgravante;
	private String tipoAtencionInterna;
	private Contacto contactoJoin;
	private Suministro suministroJoin;
	private String direccionSuministro;
	private String comuna;
	private String numeroMedidor;
	private Direccion direccionJoin;
	private Cuenta cuentaJoin;	
	private String cuerpoMail;
	private String estado;
	private String subestado;
	private String canalOrigen;	//origin
	private String parent;	//parent
	private String callCenter;	//call_center
	private String asunto;	//subject
	private String descripcionEstado;
	private String tipoAtencionSEC;
	private String canalNotificacion;
	private String telefonoContacto;
	private String emailNotificacion;
	private String peticion;
	private String description;
	private String facebook;
	private String twitter;
	private boolean actDatosContacto;
	private String ani;
	private String type;
	private String respuestaAlCliente;
	private String favorabilidadDelCaso;
	private String suministro;
	private String direccion;
	private String estadoSuministro;
	/*Joins caso*/
	private String labelSubmotivoPickList;
	private String labelSubestadoPickList;
	private String labelCanalorigenPickList;

	
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
	public Date getFechaEstimadaCierre() {
		return fechaEstimadaCierre;
	}
	public void setFechaEstimadaCierre(Date fechaEstimadaCierre) {
		this.fechaEstimadaCierre = fechaEstimadaCierre;
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
	public String getSubmotivo() {
		return submotivo;
	}
	public void setSubmotivo(String submotivo) {
		this.submotivo = submotivo;
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
	
	public Contacto getContactoJoin() {
		return contactoJoin;
	}
	public void setContactoJoin(Contacto contactoJoin) {
		this.contactoJoin = contactoJoin;
	}
	public Suministro getSuministroJoin() {
		return suministroJoin;
	}
	public void setSuministroJoin(Suministro suministroJoin) {
		this.suministroJoin = suministroJoin;
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
	
	public Direccion getDireccionJoin() {
		return direccionJoin;
	}
	public void setDireccionJoin(Direccion direccionJoin) {
		this.direccionJoin = direccionJoin;
	}
	public Cuenta getCuentaJoin() {
		return cuentaJoin;
	}
	public void setCuentaJoin(Cuenta cuentaJoin) {
		this.cuentaJoin = cuentaJoin;
	}
	public String getCuerpoMail() {
		return cuerpoMail;
	}
	public void setCuerpoMail(String cuerpoMail) {
		this.cuerpoMail = cuerpoMail;
	}

	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getSubestado() {
		return subestado;
	}
	public void setSubestado(String subestado) {
		this.subestado = subestado;
	}
	public String getCanalOrigen() {
		return canalOrigen;
	}
	public void setCanalOrigen(String canalOrigen) {
		this.canalOrigen = canalOrigen;
	}
	public String getCallCenter() {
		return callCenter;
	}
	public void setCallCenter(String callCenter) {
		this.callCenter = callCenter;
	}

	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	public String getDescripcionEstado() {
		return descripcionEstado;
	}
	public void setDescripcionEstado(String descripcionEstado) {
		this.descripcionEstado = descripcionEstado;
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
	public String getFacebook() {
		return facebook;
	}
	public void setFacebook(String facebook) {
		this.facebook = facebook;
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

	public boolean isActDatosContacto() {
		return actDatosContacto;
	}
	public void setActDatosContacto(boolean actDatosContacto) {
		this.actDatosContacto = actDatosContacto;
	}
	public String getPeticion() {
		return peticion;
	}
	public void setPeticion(String peticion) {
		this.peticion = peticion;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRespuestaAlCliente() {
		return respuestaAlCliente;
	}
	public void setRespuestaAlCliente(String respuestaAlCliente) {
		this.respuestaAlCliente = respuestaAlCliente;
	}
	public String getFavorabilidadDelCaso() {
		return favorabilidadDelCaso;
	}
	public void setFavorabilidadDelCaso(String favorabilidadDelCaso) {
		this.favorabilidadDelCaso = favorabilidadDelCaso;
	}
	public String getSuministro() {
		return suministro;
	}
	public void setSuministro(String suministro) {
		this.suministro = suministro;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String getEstadoSuministro() {
		return estadoSuministro;
	}
	public void setEstadoSuministro(String estadoSuministro) {
		this.estadoSuministro = estadoSuministro;
	}
	public String getLabelSubmotivoPickList() {
		return labelSubmotivoPickList;
	}
	public void setLabelSubmotivoPickList(String labelSubmotivoPickList) {
		this.labelSubmotivoPickList = labelSubmotivoPickList;
	}
	public String getLabelSubestadoPickList() {
		return labelSubestadoPickList;
	}
	public void setLabelSubestadoPickList(String labelSubestadoPickList) {
		this.labelSubestadoPickList = labelSubestadoPickList;
	}
	public String getLabelCanalorigenPickList() {
		return labelCanalorigenPickList;
	}
	public void setLabelCanalorigenPickList(String labelCanalorigenPickList) {
		this.labelCanalorigenPickList = labelCanalorigenPickList;
	}
	/**/
	@Override
	public Object instantiateTargetView() {
		CaseView caso = new CaseView();
		return caso;
	}
	
	@Override
	public Object instantiateTargetVO() {
		CaseVO caso = new CaseVO();
		return caso;
	}
}
