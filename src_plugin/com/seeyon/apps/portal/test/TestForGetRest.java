package com.seeyon.apps.portal.test;


import com.seeyon.apps.portal.utils.config.RestUserConfig;
import com.seeyon.apps.portal.utils.pojo.RestUser;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.seeyon.portal.restusertools.GetRestUserToken;

import java.io.IOException;

/**
 * 测试的时候使用test3方法测试
 */
public class TestForGetRest {

    /**
     * 通过setting时设置的硬编码
     */
    @Test
    public void test1(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RestUserConfig.class);
        RestUser restUser = (RestUser) context.getBean("RestUser");
        restUser.setUserName("111");
        restUser.setPassword("222");
        restUser.setRestUserUrl("333");
        System.out.println(restUser.toString());
    }

    /**
     * 通过properties文件获取值
     */
    @Test
    public void test2(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RestUserConfig.class);
        RestUser restUser = (RestUser) context.getBean("RestUser");
        System.out.println(restUser.toString());
    }

    /**
     * 使用httpclient向OA系统请求Rest用户的token
     * 将在控制台输出OA系统返回的token
     */
    @Test
    public void test3(){
        GetRestUserToken getRestUserToken = new GetRestUserToken();
        try {
            System.out.println(getRestUserToken.getToken());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
