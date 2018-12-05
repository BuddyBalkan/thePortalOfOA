package com.seeyon.apps.portal.service.impl;

import com.seeyon.apps.portal.service.UserService;
import com.seeyon.apps.portal.utils.RestWebServiceClient;

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
		
		String json = RestWebServiceClient.getRestWebServiceClientUtil().
				getClient().get("http://127.0.0.1/seeyon/rest/orgMember/effective/loginName/"+loginName+"?password="+password, 
						String.class);
		return json;
	}
    
   
}
