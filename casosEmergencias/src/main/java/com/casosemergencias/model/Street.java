package com.casosemergencias.model;

import java.util.Date;
import java.util.List;

import com.casosemergencias.controller.views.AccountView;
import com.casosemergencias.dao.vo.AccountVO;
import com.casosemergencias.dao.vo.PickListsStreetMunicipalityVO;
import com.casosemergencias.dao.vo.PickListsStreetRegionVO;
import com.casosemergencias.dao.vo.PickListsStreetTypeVO;

//Objeto que tiene el modelo de una street, se utiliza en el Servicio

public class Street extends ObjectLogic {
	
	private Integer id;
	private String sfid;
	private String name;
	private String recordTypeId;
	private String currencyIsoCode;
	private String region;
	private String literalRegion;
	private String municipality;									
	private String literalMunicipality;
	private String street;
	private String streetType;
	private String literalStreetType;
	private String lastModifiedById;
	private String createdById;
	private String ownerId;
	private String country;
	private String company;
	private PickListsStreetMunicipalityVO municipalityPickList;
	private PickListsStreetRegionVO regionPickList;
	private PickListsStreetTypeVO streetTypePickList;
	
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
	public String getRecordTypeId() {
		return recordTypeId;
	}
	public void setRecordTypeId(String recordTypeId) {
		this.recordTypeId = recordTypeId;
	}
	public String getCurrencyIsoCode() {
		return currencyIsoCode;
	}
	public void setCurrencyIsoCode(String currencyIsoCode) {
		this.currencyIsoCode = currencyIsoCode;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getLiteralRegion() {
		return literalRegion;
	}
	public void setLiteralRegion(String literalRegion) {
		this.literalRegion = literalRegion;
	}
	public String getMunicipality() {
		return municipality;
	}
	public void setMunicipality(String municipality) {
		this.municipality = municipality;
	}
	public String getLiteralMunicipality() {
		return literalMunicipality;
	}
	public void setLiteralMunicipality(String literalMunicipality) {
		this.literalMunicipality = literalMunicipality;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getStreetType() {
		return streetType;
	}
	public void setStreetType(String streetType) {
		this.streetType = streetType;
	}
	public String getLiteralStreetType() {
		return literalStreetType;
	}
	public void setLiteralStreetType(String literalStreetType) {
		this.literalStreetType = literalStreetType;
	}
	public String getLastModifiedById() {
		return lastModifiedById;
	}
	public void setLastModifiedById(String lastModifiedById) {
		this.lastModifiedById = lastModifiedById;
	}
	public String getCreatedById() {
		return createdById;
	}
	public void setCreatedById(String createdById) {
		this.createdById = createdById;
	}
	public String getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public PickListsStreetMunicipalityVO getMunicipalityPickList() {
		return municipalityPickList;
	}
	public void setMunicipalityPickList(PickListsStreetMunicipalityVO municipalityPickList) {
		this.municipalityPickList = municipalityPickList;
	}
	public PickListsStreetRegionVO getRegionPickList() {
		return regionPickList;
	}
	public void setRegionPickList(PickListsStreetRegionVO regionPickList) {
		this.regionPickList = regionPickList;
	}
	public PickListsStreetTypeVO getStreetTypePickList() {
		return streetTypePickList;
	}
	public void setStreetTypePickList(PickListsStreetTypeVO streetTypePickList) {
		this.streetTypePickList = streetTypePickList;
	}
	@Override
	public Object instantiateTargetVO() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object instantiateTargetView() {
		// TODO Auto-generated method stub
		return null;
	}

	
	









}