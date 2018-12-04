package com.seeyon.portal.pojo;

public class TheOASysProperties {

    private String ssoLoginUrl;

    private String handshakeBean;

    private String redirectUrl;

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public String getSsoLoginUrl() {
        return ssoLoginUrl;
    }

    public void setSsoLoginUrl(String ssoLoginUrl) {
        this.ssoLoginUrl = ssoLoginUrl;
    }

    public String getHandshakeBean() {
        return handshakeBean;
    }

    public void setHandshakeBean(String handshakeBean) {
        this.handshakeBean = handshakeBean;
    }

}
