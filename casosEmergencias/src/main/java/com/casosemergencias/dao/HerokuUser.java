package com.casosemergencias.dao;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="salesforce.herokuuser__c")
public class HerokuUser implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "username__c")
	private String username;
	
	@Column(name = "password__c")
	private String password;
	
	@Column(name = "email__c")
	private String email;
	
	@Column(name = "enviomail__c")
	private Boolean envioMail;
	
	@Column(name = "activo__c")
	private Boolean activo;
	
	@Column(name = "sfid")
	private String sfid;
	
	//campo de Heroku
	@Column(name = "_hc_err")
	private String hcError;

	//campo de Heroku
	@Column(name = "_hc_lastop")
	private String hcLastop;
	
	//campo de Heroku
	//Used to track the IsDeleted field from Salesforce allowing Heroku Connect to handle deletes when polling for updates
	@Column(name = "isdeleted")
	private Boolean isDeleted;
	
	//campo de Heroku
	//The date and time (in the UTC time zone) that the Salesforce object was last modified and used by Heroku Connect when polling for updates
	@Column(name="systemmodstamp")
	private Date systemDate;
	
	@Column(name="createddate")
	private Date createdDate;
	

	public HerokuUser(Integer id, String name, String username, String password, String email, Boolean envioMail,
			Boolean activo, String sfid, String hcError, String hcLastop, Boolean isDeleted, Date systemDate,
			Date createdDate) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.envioMail = envioMail;
		this.activo = activo;
		this.sfid = sfid;
		this.hcError = hcError;
		this.hcLastop = hcLastop;
		this.isDeleted = isDeleted;
		this.systemDate = systemDate;
		this.createdDate = createdDate;
	}

	public HerokuUser() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getEnvioMail() {
		return envioMail;
	}

	public void setEnvioMail(Boolean envioMail) {
		this.envioMail = envioMail;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public String getSfid() {
		return sfid;
	}

	public void setSfid(String sfid) {
		this.sfid = sfid;
	}

	public String getHcError() {
		return hcError;
	}

	public void setHcError(String hcError) {
		this.hcError = hcError;
	}

	public String getHcLastop() {
		return hcLastop;
	}

	public void setHcLastop(String hcLastop) {
		this.hcLastop = hcLastop;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Date getSystemDate() {
		return systemDate;
	}

	public void setSystemDate(Date systemDate) {
		this.systemDate = systemDate;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}	
	
}
