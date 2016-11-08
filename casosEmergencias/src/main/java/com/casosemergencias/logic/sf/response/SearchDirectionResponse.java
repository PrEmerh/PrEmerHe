package com.casosemergencias.logic.sf.response;

import com.casosemergencias.model.Direccion;

public class SearchDirectionResponse {
	private String idDireccion;
	private ControlErrores controlErrores;
	
	public String getIdDireccion() {
		return idDireccion;
	}
	public void setIdDireccion(String idDireccion) {
		this.idDireccion = idDireccion;
	}
	
	public ControlErrores getControlErrores() {
		return controlErrores;
	}

	public void setControlErrores(ControlErrores controlErrores) {
		this.controlErrores = controlErrores;
	}

	
}