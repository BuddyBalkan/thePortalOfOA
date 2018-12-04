package com.seeyon.portal.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.seeyon.client.CTPRestClient;
import com.seeyon.client.CTPServiceClientManager;
import com.seeyon.portal.restusertools.RestUser;
import com.seeyon.portal.restusertools.RestUserConfig;


/**
 * @author hucuigang
 * @date 2018.12.1 
 * 封装REST接口JAVA客户端的各种请求。
 */
@Configuration
@PropertySource(value = "classpath:properties/RestWebServiceClient.properties")
public class RestWebServiceClient{
	private Logger LOGGER=LoggerFactory.getLogger(RestWebServiceClient.class);
   //定义REST动态客户机
    private CTPRestClient client = null;
    
    private AnnotationConfigApplicationContext context;
    
    public static RestWebServiceClient getRestWebServiceClientUtil() {
    	return new RestWebServiceClient(); 
    }
	
    public RestWebServiceClient(){
    	context = new AnnotationConfigApplicationContext(RestUserConfig.class);
        RestUser restUser = (RestUser) context.getBean("RestUser");
        LOGGER.debug("REST用户信息为:{}",restUser);
        
    	//取得指定服务主机的客户端管理器。
        //参数为服务主机地址，包含{协议}{Ip}:{端口}，如http://127.0.0.1:8088
        CTPServiceClientManager clientManager = CTPServiceClientManager.getInstance(restUser.getUrlPath());
      //取得REST动态客户机。
        client = clientManager.getRestClient();
        //登录校验,成功返回true,失败返回false,此过程并会把验证通过获取的token保存在缓存中
        //再请求访问其他资源时会自动把token放入请求header中。
        client.authenticate(restUser.getUserName(), restUser.getPassword());
    }
    /**
     * @author hucuigang
     * @param accountName 单位名称
     * @return 导出部门xml数据
     */
    public String getDepartmentsXML(String accountName ) {  
    	String xml =null;
        /*
       * get请求方式代码示例
         */
        //参数类型为QueryParam
        //根据登录名获取人员信息
        try {
        	LOGGER.debug("单位名称为:{}",accountName);
            //URL为中文的部分要进行编码
            String accountN = URLEncoder.encode(accountName, "UTF-8");
            // 此处指定了accept，返回值为xml
            xml = client.get("data/departments/"+accountN, String.class,"application/xml");
        } catch (UnsupportedEncodingException e) {
        	LOGGER.debug("获取部门数据失败！");
            e.printStackTrace();
        }
       LOGGER.debug("部门XML数据为:{}",xml);
       return xml;
    }
    /**
     * @author hucuigang
     * @param accountName 单位名称
     * @return 导出人员信息xml数据
     */
    public String getMembersXML(String accountName ) {  
    	String xml =null;
        /*
       * get请求方式代码示例
         */
        //参数类型为QueryParam
        //根据登录名获取人员信息
        try {
        	LOGGER.debug("单位名称为:{}",accountName);
            //URL为中文的部分要进行编码
            String accountN = URLEncoder.encode(accountName, "UTF-8");
            // 此处指定了accept，返回值为xml
            xml = client.get("data/members/"+accountN, String.class,"application/xml");
        } catch (Exception e) {
        	LOGGER.debug("获取人员信息数据失败！");
            e.printStackTrace();
        }
       LOGGER.debug("人员信息XML数据为:{}",xml);
       return xml;
    }
    /**
     * @author hucuigang
     * @param accountName 单位名称
     * @return 导出组织模型xml数据
     */
    public String getOrganizationXML(String accountName) {  
    	String xml =null;
        /*
       * get请求方式代码示例
         */
        //参数类型为QueryParam
        //根据登录名获取人员信息
        try {
        	LOGGER.debug("单位名称为:{}",accountName);
            //URL为中文的部分要进行编码
            String accountN = URLEncoder.encode(accountName, "UTF-8");
            // 此处指定了accept，返回值为xml
            xml = client.get("data/organization/accountName/"+accountN, String.class,"application/xml");
        } catch (Exception e) {
        	LOGGER.debug("获取人员信息数据失败！");
            e.printStackTrace();
        }
       LOGGER.debug("人员信息XML数据为:{}",xml);
       return xml;
    }
    
    
    /**
     * @author hucuigang
     * @param accountName 单位名称
     * @return 导入组织模型型xml数据
     */
    public void getOrganizationPostXML() {  
    	String accountName ="微鑫通时代科技有限公司";
    	String xml =null;
        /*
       * get请求方式代码示例
         */
        //参数类型为QueryParam
        //根据登录名获取人员信息
        try {
        	LOGGER.debug("单位名称为:{}",accountName);
            //URL为中文的部分要进行编码
            String accountN = URLEncoder.encode(accountName, "UTF-8");
            // 此处指定了accept，返回值为xml
            xml = client.get("data/organization/accountName/"+accountN, String.class,"application/xml");
        } catch (Exception e) {
        	LOGGER.debug("获取人员信息数据失败！");
            e.printStackTrace();
        }
       LOGGER.debug("人员信息XML数据为:{}",xml);
    }
}
