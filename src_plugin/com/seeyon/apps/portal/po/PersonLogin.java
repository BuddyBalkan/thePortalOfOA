package com.seeyon.apps.portal.po;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
/**
 * 用户登录信息实体类
 * @author 周钇休
 */

@Table(name="person_login")
public class PersonLogin implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;//用户id

	@Column(name = "login_name")
	private String  loginName;//用户登录名

	private String password;//用户密码

	@Column(name = "create_date")
	private Date createDate;//创建时间

	@Column(name = "update_date")
	private Date updateDate;//更新时间

	@Column(name = "is_enable")
	private Integer isEnable;//是否启用  1表示启用，   0，标识未启用

	@Column(name="member_id")
	private Long memberId;//人员ID，对应people表中主键ID

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Integer getIsEnable() {
		return isEnable;
	}

	public void setIsEnable(Integer isEnable) {
		this.isEnable = isEnable;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	@Override
	public String toString() {
		return "PersonLogin{" +
				"id=" + id +
				", loginName='" + loginName + '\'' +
				", password='" + password + '\'' +
				", createDate=" + createDate +
				", updateDate=" + updateDate +
				", isEnable=" + isEnable +
				", memberId=" + memberId +
				'}';
	}
}
