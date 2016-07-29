package com.casosemergencias.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.casosemergencias.logic.UserService;

/**
 * @author MPC
* 
* Clase que contiene el modelo de un Usuario. Esta clase es la que utilizaremos en el Servicio.
*
*/
public class User {

	private Integer id;
	private String name;
	private String user;
	private String pass;
	private String email;
	private String sfid;
	private Boolean envioEmail;
	
	
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
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSfid() {
		return sfid;
	}
	public void setSfid(String sfid) {
		this.sfid = sfid;
	}
	public Boolean isEnvioEmail() {
		return envioEmail;
	}
	public void setEnvioEmail(Boolean envioEmail) {
		this.envioEmail = envioEmail;
	}
	
	
	
	
}
