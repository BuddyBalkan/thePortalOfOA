package com.seeyon.portal.restusertools;


import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @author LiuXingkai
 * @date 2018.11.28 16:40
 * 封装用于获取REST用户的token的方法类
 */
public class GetRestUserToken {

    private String restUserTokenId;

    private AnnotationConfigApplicationContext context;

    /**
     * 获取REST用户的token方法
     * @return token
     * @throws IOException
     */
    public String getToken() throws IOException {

        context = new AnnotationConfigApplicationContext(RestUserConfig.class);
        RestUser restUser = (RestUser) context.getBean("RestUser");

        CloseableHttpClient httpClient = HttpClients.createDefault();

        Gson gson = new Gson();
        StringEntity entity = new StringEntity(gson.toJson(restUser));


        HttpPost restUserForToken = new HttpPost(restUser.getRestUserUrl());
        restUserForToken.setHeader("Content-Type","application/json");
        restUserForToken.setHeader("Accept","application/json");
        restUserForToken.setEntity(entity);

        CloseableHttpResponse httpResponse = httpClient.execute(restUserForToken);
        if (httpResponse.getStatusLine().getStatusCode() == 200) {
            HttpEntity responseEntity = httpResponse.getEntity();
            RestUserToken restUserToken = gson.fromJson(EntityUtils.toString(responseEntity), RestUserToken.class);
            httpResponse.close();
            return restUserTokenId = restUserToken.getId();
        }
        httpResponse.close();
        return "出错了，需要Debug跑一下了";
    }

    public String getRestUserTokenId() {
        return restUserTokenId;
    }

    public void setRestUserTokenId(String restUserTokenId) {
        this.restUserTokenId = restUserTokenId;
    }

}
