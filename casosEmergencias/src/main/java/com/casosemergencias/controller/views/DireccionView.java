package com.casosemergencias.controller.views;

import java.util.Date;

public class DireccionView {

	/*ID*/                                  private Integer id;
	/*SFID*/                              	private String sfid;
	/*Region*/                              private String region;
	/*Comuna*/                    			private String comuna;
	/*Tipo de calle*/                   	private String tipoCalle;
	/*Calle*/                   			private String calle;
	/*Número*/                              private String numero;
	/*Departamento*/        				private String departamento;
	/*Código de Dirección*/                 private String name;
	/*Dirección concatenada*/               private String direccionConcatenada;
	/*Esquina*/                     		private String esquina;
	
	
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
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getComuna() {
		return comuna;
	}
	public void setComuna(String comuna) {
		this.comuna = comuna;
	}
	public String getTipoCalle() {
		return tipoCalle;
	}
	public void setTipoCalle(String tipoCalle) {
		this.tipoCalle = tipoCalle;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDireccionConcatenada() {
		return direccionConcatenada;
	}
	public void setDireccionConcatenada(String direccionConcatenada) {
		this.direccionConcatenada = direccionConcatenada;
	}
	public String getEsquina() {
		return esquina;
	}
	public void setEsquina(String esquina) {
		this.esquina = esquina;
	}


	
	
	
	
}
