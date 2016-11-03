package com.casosemergencias.logic.sf.response;

import com.casosemergencias.model.Direccion;

public class SearchDirectionResponse {
	private Direccion direccion;
	private ControlErrores controlErrores;

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	
	public ControlErrores getControlErrores() {
		return controlErrores;
	}

	public void setControlErrores(ControlErrores controlErrores) {
		this.controlErrores = controlErrores;
	}
}