package com.casosemergencias.logic.sf.response;

public class SearchDirectionResponse {
	private String idDireccion;
	private ControlErrores controlErrores;

	public String getDireccion() {
		return idDireccion;
	}

	public void setDireccion(String idDireccion) {
		this.idDireccion = idDireccion;
	}
	
	public ControlErrores getControlErrores() {
		return controlErrores;
	}

	public void setControlErrores(ControlErrores controlErrores) {
		this.controlErrores = controlErrores;
	}
}