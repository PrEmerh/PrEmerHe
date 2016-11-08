package com.casosemergencias.logic.sf.bean;

import com.casosemergencias.model.Direccion;
import com.casosemergencias.model.Street;

public class DirectionSalesForce {
	
	//Campos Street
	private String region__c;
	private String municipality__c;
	private String street__c;
	private String street_Type__c;
	//Campos Address
	private String number__c;
	private String department__c;
	
	//Getters y Setters
		
	public String getRegion__c() {
		return region__c;
	}

	public void setRegion__c(String region__c) {
		this.region__c = region__c;
	}

	public String getMunicipality__c() {
		return municipality__c;
	}

	public void setMunicipality__c(String municipality__c) {
		this.municipality__c = municipality__c;
	}

	public String getStreet__c() {
		return street__c;
	}

	public void setStreet__c(String street__c) {
		this.street__c = street__c;
	}

	public String getStreet_Type__c() {
		return street_Type__c;
	}

	public void setStreet_Type__c(String street_Type__c) {
		this.street_Type__c = street_Type__c;
	}

	public String getNumber__c() {
		return number__c;
	}

	public void setNumber__c(String number__c) {
		this.number__c = number__c;
	}

	public String getDepartment__c() {
		return department__c;
	}

	public void setDepartment__c(String department__c) {
		this.department__c = department__c;
	}

	public static DirectionSalesForce copyFieldsFromHerokuToSalesForceDirectionBean(Street streetHeroku, Direccion direccionHeroku) {
		DirectionSalesForce directionSF = new DirectionSalesForce();
		
		if(streetHeroku!=null && direccionHeroku!=null){
					
		directionSF.setRegion__c((streetHeroku.getRegion()!= null && !"".equals(streetHeroku.getRegion()) ? streetHeroku.getRegion(): ""));
		directionSF.setMunicipality__c((streetHeroku.getMunicipality()!= null && !"".equals(streetHeroku.getMunicipality()) ? streetHeroku.getMunicipality() : ""));
		directionSF.setStreet__c((streetHeroku.getStreet() != null && !"".equals(streetHeroku.getStreet() ) ? streetHeroku.getStreet()  : ""));
		directionSF.setStreet_Type__c((streetHeroku.getStreetType()  != null && !"".equals(streetHeroku.getStreetType() ) ? streetHeroku.getStreetType()  : ""));
		directionSF.setNumber__c((direccionHeroku.getNumero() != null && !"".equals(direccionHeroku.getNumero() ) ? direccionHeroku.getNumero()  : ""));
		directionSF.setDepartment__c((direccionHeroku.getDepartamento() != null && !"".equals(direccionHeroku.getDepartamento()) ? direccionHeroku.getDepartamento() : ""));
				
		}
		return directionSF;
	}

	

}
