package com.casosemergencias.logic;

import java.util.List;

import com.casosemergencias.model.UserSessionInfo;

public interface UserSessionInfoService {
	public List<UserSessionInfo> readUserSessionInfo(UserSessionInfo userSessionInfo);
	
	public Integer insertUserSessionInfo(UserSessionInfo userSessionInfo);
	
	public Integer updateUserSessionInfo(UserSessionInfo userSessionInfo);
}