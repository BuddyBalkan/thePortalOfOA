package com.seeyon.portal.pojo;

import org.hibernate.annotations.Entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "target_system_config")
public class TargetSystem implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer targetSys;

    @Column(name = "sso_login_url")
    private String ssoLoginUrl;

    @Column(name = "handshake_bean")
    private String handshakeBean;

    @Column(name = "target_sys_name")
    private String targetSysName;

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

    public Integer getTargetSys() {
        return targetSys;
    }

    public void setTargetSys(Integer targetSyst) {
        this.targetSys = targetSyst;
    }

    public String getTargetSysName() {
        return targetSysName;
    }

    public void setTargetSysName(String targetSysName) {
        this.targetSysName = targetSysName;
    }
}
