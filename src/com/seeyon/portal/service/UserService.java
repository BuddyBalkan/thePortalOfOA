package com.seeyon.portal.service;

import java.io.IOException;

public interface UserService {
	public String loginByPassword(String username,String password) throws IOException;
}
