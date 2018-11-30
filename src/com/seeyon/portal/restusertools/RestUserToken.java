package com.seeyon.portal.restusertools;

/**
 * @author LiuXingkai
 * @date 2018.11.28 16:40
 * 用于封装向OA系统请求REST用户的返回结果
 */
public class RestUserToken {

    private String bindingUser;

    private String id;

    public String getBindingUser() {
        return bindingUser;
    }

    public void setBindingUser(String bindingUser) {
        this.bindingUser = bindingUser;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
