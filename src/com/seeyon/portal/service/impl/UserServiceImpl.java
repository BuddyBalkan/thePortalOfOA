package com.seeyon.portal.service.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.seeyon.portal.controller.UserController;
import com.seeyon.portal.restusertools.GetRestUserToken;
import com.seeyon.portal.service.UserService;
import com.seeyon.portal.utils.HttpClientUtil;

public class UserServiceImpl implements UserService{
	
	private GetRestUserToken userToken = new GetRestUserToken();
	
	private Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Override
	public String loginByPassword(String username, String password) throws IOException {
		if(username==null || "".equals(username)){
			LOGGER.info("用户名不能为空");
			return null;
		}
		
		if(password==null || "".equals(password)){
			LOGGER.info("密码不能为空");
			return null;
		}
		
		Map<String,String> param = new HashMap<String,String>();
		param.put("password", password);
		Map<String,String> header = new HashMap<String,String>();
		header.put("token",userToken.getToken().toString());
		String message = HttpClientUtil.doGet("http://127.0.0.1:8084/seeyon/rest/orgMember/effective/loginName/"+username,param,header);
		return message;
	}

}
