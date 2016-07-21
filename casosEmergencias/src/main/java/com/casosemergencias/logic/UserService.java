package com.casosemergencias.logic;

import com.casosemergencias.model.User;

public interface UserService {

	public User readUser(String user, String pass);
	public void insertUser();
}
