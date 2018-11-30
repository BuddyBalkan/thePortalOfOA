package com.seeyon.portal.restusertools;

import org.springframework.stereotype.Component;

/**
 * @author LiuXingkai
 * @date 2018.11.28 16:40
 * 用于封装REST用户的信息 包括访问请求token的URL地址
 */
@Component
public class RestUser {

    private String userName;
    private String password;
    private transient String restUserUrl;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRestUserUrl() {
        return restUserUrl;
    }

    public void setRestUserUrl(String restUserUrl) {
        this.restUserUrl = restUserUrl;
    }

    @Override
    public String toString() {
        return "RestUser{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", restUserUrl='" + restUserUrl + '\'' +
                '}';
    }
}
