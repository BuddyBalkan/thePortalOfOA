package com.seeyon.apps.spadeSSO;

import com.google.gson.Gson;
import com.seeyon.apps.spadeSSO.po.Ticket;
import com.seeyon.ctp.common.exceptions.BusinessException;
import com.seeyon.ctp.organization.bo.V3xOrgMember;
import com.seeyon.ctp.organization.manager.OrgManager;
import com.seeyon.ctp.portal.sso.SSOLoginHandshakeAbstract;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author 刘星锴
 * 单点登入放入原OA系统的插件 用于验证
 */
@Component(value = "spadeSSOHandshake")
public class SpadeSSOHandshake extends SSOLoginHandshakeAbstract implements ApplicationContextAware {

    private Logger LOGGER = LoggerFactory.getLogger(SpadeSSOHandshake.class);

    private ApplicationContext context;

    private Gson gson = new Gson();

    private static final String ORG_MANAGER = "orgManager";

    /**
     * 重写的handshake方法
     * @param ticket ticket的json字符串
     * @return 根据ticket查询到的用户名
     */
    @Override
    public String handshake(String ticket) {

        String userName;

        if(ticket == null || ticket.equals("")) {
            return null;
        }
        try {
           userName = checkPassport(ticket);
            if (userName != null) {
                LOGGER.info("握手成功，其用户名为：{}", userName);
                return userName;
            }
        } catch (BusinessException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public void logoutNotify(String ticket) {

    }

    /**
     * 握手规则：根据IoC容器获取orgManager的Bean 通过该Bean依据ticket查询人员
     * @param ticketJson json字符串的ticket
     * @return 查询到的人员用户名
     * @throws BusinessException orgManger可能未获取到查询的人员信息
     */
    private String checkPassport(String ticketJson) throws BusinessException {
        Ticket ticket = gson.fromJson(ticketJson, Ticket.class);
        OrgManager orgManager = (OrgManager) context.getBean(ORG_MANAGER);
        if (orgManager == null) {
            LOGGER.warn("未获取到orgManager的Bean");
            return null;
        }
        V3xOrgMember member = orgManager.getMemberByLoginName(ticket.getLoginUserName());
        if (member != null) {
            LOGGER.info("SSO握手查有此人，其登入名为：{}", ticket.getLoginUserName());
            return member.getName();
        }
        LOGGER.warn("SSO握手失败，原因未知。");
        return null;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

}
