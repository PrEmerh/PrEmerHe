package com.casosemergencias.logic;

import com.casosemergencias.model.User;

public interface UserService {

	public User readUserPass(String user, String pass);
	public void insertUser();
	public User readUser(String userName);
	public boolean changeEnvioEmail(User userChangEmail);
	public boolean changePassHerokuUser (String newpass,String sfid);
}
