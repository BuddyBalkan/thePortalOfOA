package com.seeyon.portal.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.seeyon.portal.pojo.TargetSystem;
import com.seeyon.portal.pojo.Ticket;
import com.seeyon.portal.service.TargetSysService;
import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.seeyon.portal.service.UserService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value="/user")
public class UserController {
	@Autowired
	private UserService userService;

	@Autowired
	private TargetSysService targetSysService;

	private Gson gson = new Gson();

	private static final String SSO_OK = "SSOOK";
	private static final String SSO_ERROR = "SSOError";

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


    /**
     * 根据目标系统名称以及登入用户名生成ticket
     * ticket为json {"targetSystemName":"utf-8编码后的目标系统名称值" , "loginUserName":"utf-8编码后的登入用户名值"}
     * @param tagSys 目标系统的名称
     * @param userNameForTargetSys 登入用户名
     * @return ticket的json字符串
     */
	public String createTicket(String tagSys, String userNameForTargetSys){
        Ticket ticket = new Ticket();
        try {
            ticket.setTargetSystemName(new String(tagSys.getBytes("UTF-8")));
            ticket.setLoginUserName(new String(userNameForTargetSys.getBytes("UTF-8")));
            LOGGER.info("成功生成SSO所需ticket：{}", gson.toJson(ticket));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return gson.toJson(ticket);
	}

    /**
     * 与目标系统握手方法（目前仅限OA系统）
     * @param targetSystemName 目标系统的名称
     * @param ticket ticket的json字符串
     * @return 是否握手成功
     */
	public boolean handShakeWithOA(String targetSystemName, String ticket){
        Map<String, String> params = new HashMap<>(16);
        params.put("from", targetSysService.queryByTargetSysName(targetSystemName).getHandshakeBean());
        params.put("ticket", ticket);
        Map<String, String> responseHeaders = loginToOtherSysHttpPost(targetSysService.queryByTargetSysName(targetSystemName)
                                                                        .getSsoLoginUrl(), params);
        LOGGER.info("已完成与目标系统的握手访问");
        if (responseHeaders.get(SSO_OK) != null) {
            LOGGER.info("握手成功");
            return true;
        }else if (responseHeaders.get(SSO_ERROR) != null) {
            LOGGER.warn("握手失败");
            return false;
        }else {
            LOGGER.warn("握手访问可能失败");
            return false;
        }

	}

    /**
     * 与其他系统握手的访问请求
     * @param url 其他系统要求的握手url
     * @param params 握手时候所要传入的参数
     * @return 目前仅限OA系统 故返回response的headers map形式
     */
	public Map<String, String> loginToOtherSysHttpPost(String url, Map<String, String> params){
        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();


        CloseableHttpResponse response = null;
        Map<String, String> result = new HashMap<>(16);
        try {
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);


            // 创建参数列表
            if (params != null) {
                List<NameValuePair> paramList = new ArrayList<NameValuePair>();
                for (String key : params.keySet()) {
                    paramList.add(new BasicNameValuePair(key, params.get(key)));
                }
                // 模拟表单
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList);
                httpPost.setEntity(entity);
            }
            // 执行http请求
            response = httpClient.execute(httpPost);
            Header[] headers = response.getAllHeaders();
            for (int i = 0; i < headers.length; i++) {
                result.put(headers[i].getName(), headers[i].getValue());
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        return result;
    }

	@RequestMapping(value = "/loginTo", method = RequestMethod.POST)
	public ModelAndView loginToOtherSystem(@RequestParam String oaUserName, @RequestParam String targetSystemName){

        TargetSystem targetSystem = targetSysService.queryByTargetSysName(targetSystemName);
        String ticket = createTicket(targetSystem.getTargetSysName(), oaUserName);
        if (handShakeWithOA(targetSystemName, ticket)) {
            LOGGER.info("用户已成功登入到目标系统");
            return new ModelAndView("http://127.0.0.1:81/seeyon");
        }
        LOGGER.warn("登入目标系统出错");
        return new ModelAndView("/login_error");


    }
}
