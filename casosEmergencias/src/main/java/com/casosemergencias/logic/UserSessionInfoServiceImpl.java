package com.casosemergencias.logic;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.casosemergencias.dao.UserSessionInfoDAO;
import com.casosemergencias.dao.vo.UserSessionInfoVO;
import com.casosemergencias.model.UserSessionInfo;
import com.casosemergencias.util.ParserModelVO;

public class UserSessionInfoServiceImpl implements UserSessionInfoService {
	final static Logger logger = Logger.getLogger(UserSessionInfoServiceImpl.class);
	
	@Autowired
	private UserSessionInfoDAO userSessionInfoDAO;
	
	@Override
	public List<UserSessionInfo> readUserSessionInfo(UserSessionInfo userSessionInfo) {
		UserSessionInfoVO userSessionInfoVO = new UserSessionInfoVO();
		ParserModelVO.parseDataModelVO(userSessionInfo, userSessionInfoVO);
		List<UserSessionInfoVO> userSessionInfoVOList = userSessionInfoDAO.readUserSessionInfo(userSessionInfoVO);
		List<UserSessionInfo> userSessionInfoList = new ArrayList<UserSessionInfo>();
		if (userSessionInfoVOList != null && !userSessionInfoVOList.isEmpty()) {
			for (UserSessionInfoVO userSessionInfoVOToParse : userSessionInfoVOList) {
				UserSessionInfo userSessionInfoLogic = new UserSessionInfo();
				ParserModelVO.parseDataModelVO(userSessionInfoVOToParse, userSessionInfoLogic);
				userSessionInfoList.add(userSessionInfoLogic);
			}
		}
		return userSessionInfoList;
	}

	@Override
	public Integer insertUserSessionInfo(UserSessionInfo userSessionInfo) {
		UserSessionInfoVO userSessionInfoVO = new UserSessionInfoVO();
		ParserModelVO.parseDataModelVO(userSessionInfo, userSessionInfoVO);
		Integer id = userSessionInfoDAO.insertUserSessionInfo(userSessionInfoVO);
		return id;
	}

	@Override
	public Integer updateUserSessionInfo(UserSessionInfo userSessionInfo) {
		UserSessionInfoVO userSessionInfoVO = new UserSessionInfoVO();
		ParserModelVO.parseDataModelVO(userSessionInfo, userSessionInfoVO);
		Integer id = userSessionInfoDAO.updateUserSessionInfo(userSessionInfoVO);
		return id;
	}
}