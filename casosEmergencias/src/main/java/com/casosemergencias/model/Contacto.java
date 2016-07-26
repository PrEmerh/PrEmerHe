package com.casosemergencias.model;

//objeto que tiene el modelo de un contacto, se utiliza en el Servicio
public class Contacto {

	private Integer id;
	private String sfid;
	private String name;
	private String accountRun;
	private String phone;
	private String email;

	
	
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
	public String getAccountRun() {
		return accountRun;
	}
	public void setAccountRun(String accountRun) {
		this.accountRun = accountRun;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
	
	
	
}