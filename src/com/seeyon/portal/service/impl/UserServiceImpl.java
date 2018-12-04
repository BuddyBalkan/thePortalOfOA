package com.seeyon.portal.service.impl;

import com.seeyon.portal.restusertools.GetRestUserToken;
import com.seeyon.portal.service.UserService;
import com.seeyon.portal.utils.HttpClientUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public String checkLogin(String loginName, String password) {
        if(loginName==null || "".equals(loginName)){
            LOGGER.debug("用户名不能为空");
            return null;
        }

        if(password==null || "".equals(password)){
            LOGGER.debug("密码不能为空");
            return null;
        }
		Map<String , String> param = new HashMap();
		param.put("password", password);
		Map<String ,String> header = new HashMap();
		GetRestUserToken restUser = new GetRestUserToken(); 
		try {
			header.put("token", restUser.getToken().toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		String json = HttpClientUtil.doGet("http://127.0.0.1/seeyon/rest/orgMember/effective/loginName/"+loginName, param, header);
		return json;
	}
    
   
}
