package com.seeyon.apps.portal.controller;

import com.google.gson.Gson;
import com.seeyon.apps.portal.utils.config.TargetSystemConfig;
import com.seeyon.apps.portal.utils.pojo.TheOASysProperties;
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
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 刘星锴
 */
@Controller
@RequestMapping(value = "/homepage")
public class HomePageController {

    private Gson gson = new Gson();

    private AnnotationConfigApplicationContext context;

    private static final String SSO_OK = "SSOOK";
    private static final String SSO_ERROR = "SSOError";

    private Logger LOGGER = LoggerFactory.getLogger(HomePageController.class);

    /**
     * 根据目标系统名称以及登入用户名生成ticket
     * ticket为json {"targetSystemName":"utf-8编码后的目标系统名称值" , "loginUserName":"utf-8编码后的登入用户名值"}
     * @param userNameForTargetSys 登入用户名
     * @return ticket的json字符串
     */
    public String createTicket(String userNameForTargetSys){
        Ticket ticket = new Ticket();
        try {
            ticket.setLoginUserName(new String(userNameForTargetSys.getBytes("UTF-8")));
            LOGGER.info("成功生成SSO所需ticket：{}", gson.toJson(ticket));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return gson.toJson(ticket);
    }

    /**
     * 与目标系统握手方法（目前仅限OA系统）
     * @param properties 目标系统的java配置（仅OA）
     * @param ticket ticket的json字符串
     * @return 是否握手成功
     */
    public boolean handShakeWithOA(TheOASysProperties properties, String ticket){
        Map<String, String> params = new HashMap<>(16);
        params.put("from", properties.getHandshakeBean());
        params.put("ticket", ticket);
        Map<String, String> responseHeaders = loginToOtherSysHttpPost(properties.getSsoLoginUrl(), params);
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

    /**
     * 单点登入到OA系统中 并跳转到OA登入后的主页面
     * @param request 获取session用
     * @return 跳转成功 则到OA系统登入后的主页面 失败则跳转登入失败页面
     */
    @RequestMapping(value = "/loginTo", method = RequestMethod.POST)
    public ModelAndView loginToOtherSystem(HttpServletRequest request){

        HttpSession session = request.getSession();
        context = new AnnotationConfigApplicationContext(TargetSystemConfig.class);
        TheOASysProperties properties = (TheOASysProperties) context.getBean("The_OA_Properties");
        LOGGER.info("成功获取到OA单点登入的配置文件信息");
        if (session.getAttribute(UserController.USER_NAME_IN_SESSION) == null){
            return new ModelAndView("/login_error");
        }
        String ticket = createTicket(((String) session.getAttribute(UserController.USER_NAME_IN_SESSION)));
        if (handShakeWithOA(properties, ticket)) {
            LOGGER.info("用户已成功登入到目标系统");
            return new ModelAndView("redirect:" + properties.getRedirectUrl());
        }
        LOGGER.warn("登入目标系统出错");
        return new ModelAndView("/login_error");


    }

    /**
     * 临时使用 用于生成ticket的json类
     */
    class Ticket {

        private String loginUserName;

        public String getLoginUserName() {
            return loginUserName;
        }

        public void setLoginUserName(String loginUserName) {
            this.loginUserName = loginUserName;
        }
    }


}
