package com.casosemergencias.controller.views;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.casosemergencias.dao.PickListsVO;

public class CaseView {

	private String sfid;
	private String numeroCaso;
	private String estado;
	private String numeroInservice;
	private String submotivo;
	private Date fechaApertura;
	private String subestado;
	private String nombreContacto;
	private String direccionSuministro;
	private String comuna;
	private String tiempoEstimacion;
	private String canalOrigen;
	private String nombreCuenta;
	private String suministro;
	private String estadoSuministro;
	private String peticion;
	private String callCenter;
	private String editMode;
	private PickListsVO estadoPickList;
	
	private Map<String, String> mapStatus;
	private Map<String, String> mapSubStatus;
	private Map<String, String> mapPeticion;
	private Map<String, String> mapOrigin;
	private Map<String, String> mapCallCenter;
	
	
	public String getNumeroCaso() {
		return numeroCaso;
	}
	public void setNumeroCaso(String numeroCaso) {
		this.numeroCaso = numeroCaso;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getNumeroInservice() {
		return numeroInservice;
	}
	public void setNumeroInservice(String numeroInservice) {
		this.numeroInservice = numeroInservice;
	}
	public String getSubmotivo() {
		return submotivo;
	}
	public void setSubmotivo(String submotivo) {
		this.submotivo = submotivo;
	}
	public Date getFechaApertura() {
		return fechaApertura;
	}
	public void setFechaApertura(Date fechaApertura) {
		this.fechaApertura = fechaApertura;
	}
	public String getSubestado() {
		return subestado;
	}
	public void setSubestado(String subestado) {
		this.subestado = subestado;
	}
	public String getNombreContacto() {
		return nombreContacto;
	}
	public void setNombreContacto(String nombreContacto) {
		this.nombreContacto = nombreContacto;
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
	public String getTiempoEstimacion() {
		return tiempoEstimacion;
	}
	public void setTiempoEstimacion(String tiempoEstimacion) {
		this.tiempoEstimacion = tiempoEstimacion;
	}
	public String getCanalOrigen() {
		return canalOrigen;
	}
	public void setCanalOrigen(String canalOrigen) {
		this.canalOrigen = canalOrigen;
	}
	public String getNombreCuenta() {
		return nombreCuenta;
	}
	public void setNombreCuenta(String nombreCuenta) {
		this.nombreCuenta = nombreCuenta;
	}
	public String getSuministro() {
		return suministro;
	}
	public void setSuministro(String suministro) {
		this.suministro = suministro;
	}
	public String getEstadoSuministro() {
		return estadoSuministro;
	}
	public void setEstadoSuministro(String estadoSuministro) {
		this.estadoSuministro = estadoSuministro;
	}
	public String getSfid() {
		return sfid;
	}
	public void setSfid(String sfid) {
		this.sfid = sfid;
	}
	public String getPeticion() {
		return peticion;
	}
	public void setPeticion(String peticion) {
		this.peticion = peticion;
	}
	public Map<String, String> getMapStatus() {
		return mapStatus;
	}
	public void setMapStatus(Map<String, String> mapStatus) {
		this.mapStatus = mapStatus;
	}
	public Map<String, String> getMapSubStatus() {
		return mapSubStatus;
	}
	public void setMapSubStatus(Map<String, String> mapSubStatus) {
		this.mapSubStatus = mapSubStatus;
	}
	public Map<String, String> getMapPeticion() {
		return mapPeticion;
	}
	public void setMapPeticion(Map<String, String> mapPeticion) {
		this.mapPeticion = mapPeticion;
	}
	public Map<String, String> getMapOrigin() {
		return mapOrigin;
	}
	public void setMapOrigin(Map<String, String> mapOrigin) {
		this.mapOrigin = mapOrigin;
	}
	public String getCallCenter() {
		return callCenter;
	}
	public void setCallCenter(String callCenter) {
		this.callCenter = callCenter;
	}
	public Map<String, String> getMapCallCenter() {
		return mapCallCenter;
	}
	public void setMapCallCenter(Map<String, String> mapCallCenter) {
		this.mapCallCenter = mapCallCenter;
	}
	public String getEditMode() {
		return editMode;
	}
	public void setEditMode(String editMode) {
		this.editMode = editMode;
	}
	public PickListsVO getEstadoPickList() {
		return estadoPickList;
	}
	public void setEstadoPickList(PickListsVO estadoPickList) {
		this.estadoPickList = estadoPickList;
	}

	public String getLabelEstadoPickList(){
		String result = this.getEstado();
		if (this.getEstadoPickList() != null ){
			result=this.getEstadoPickList().getValor();
		}
		return result; 
	}
}
