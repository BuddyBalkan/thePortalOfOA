package com.seeyon.portal.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * @author
 */
@Configuration
@PropertySource("classpath:properties/SSOToOASys.properties")
public class TargetSystemConfig {

    private TheOASysProperties properties;

    @Value("login_url")
    private String loginUrl;

    @Value("handshake_bean")
    private String handshakeBean;

    @Value("redirect_url")
    private String redirectUrl;

    @Bean(name = "The_OA_Properties")
    public TheOASysProperties getProperties(){
        properties = new TheOASysProperties();
        this.properties.setSsoLoginUrl(loginUrl);
        this.properties.setHandshakeBean(handshakeBean);
        this.properties.setRedirectUrl(redirectUrl);
        return this.properties;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }

}
