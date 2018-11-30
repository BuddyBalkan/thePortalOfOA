package com.seeyon.portal.pojo;

import java.io.Serializable;
import java.util.Date;
public class Principal implements Serializable{
	private long id;//用户id
	private String  loginname;//用户登录名
	private String password;//用户密码
	private Date createDate;//创建时间
	private Date updateDate;//更新时间
	private Integer isEnable;//是否启用  1表示启用，   0，标识未启用
	private Long member_ID;//人员ID，对应people表中主键ID

}
