package com.casosemergencias.logic;

import com.casosemergencias.model.HeokuUser;

public interface HerokuUserService {

	public HeokuUser readUserPass(String user, String pass);
	public void insertUser();
	public HeokuUser readUser(String userName);
}
