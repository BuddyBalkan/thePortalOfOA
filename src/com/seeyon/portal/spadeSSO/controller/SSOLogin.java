package com.seeyon.portal.spadeSSO.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class SSOLogin {



    @Autowired
    private HttpSession session;

    @Autowired
    private HttpServletRequest request;



    public String createTicket(){

        return new String("tikcet");
    }

    public boolean handShankeWithOA(String ticket){

        return true;
    }

    @RequestMapping(value = "/")
    public void loginToOASystem(@RequestParam String oaUserName){

    }



}
