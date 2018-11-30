package com.seeyon.portal.test;

import java.io.Serializable;

public class User implements Serializable {
	   private  String name ="小汪";
	   private String email ="123165@qq.com" ;
	   private String password = "123456";
	   
	   public User(){}  
	   public User(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	  }
	  public String getName() {
	 	return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", password=" + password
				+ "]";
	} 
}
