package com.seeyon.portal.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.seeyon.portal.service.UserService;

@Controller
@RequestMapping(value="/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	private Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(String username,String password) throws IOException{
		String message = "未知错误";
		if(username==null || "".equals(username)){
			LOGGER.info("用户名不能为空");
			return message="用户不能为空";
		}
		if(password==null || "".equals(password)){
			LOGGER.info("密码不能为空");
			return message="密码不能为空";
		}
		LOGGER.info("开始登录,用户名为{}",username);
		
		String result = userService.loginByPassword(username, password);
		
		if(result==null||"".equals(result)){
			LOGGER.info("用户名密码不能为空");
			return message="用户名密码不能为空";
		}
		if(result.equals("false")){
			LOGGER.info("用户名密码错误");
			return message="用户名密码错误";
		}
		if(result.equals("true")){
			LOGGER.info("登录成功");
			message="登录成功";
		}
		return message;
	}
}
