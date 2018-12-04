package com.seeyon.portal.pojo;
/**
 * @author 周钇休
 * 人员信息实体类
 */

import java.io.Serializable;
import java.util.Date;

public class PersonInfo implements Serializable{

	private Long id;//	Id，唯一标识人员

	private String name;//	姓名

	private String code;//人员编码

	private Date createTime;//	创建时间

	private Date updateTime;//更新时间

	private Integer sortId;	//排序号

	private Long orgAccountId;//	人员所属单位Id

	private Long orgDepartmentId;//人员所属部门Id

	private String description;//说明

	private Integer isDeleted;//	删除标记：true为已删除

	private Integer isInternal;//	是否内部人员

	private Integer isAssigned;//	是否已分配人员

	private Integer isAdamin;//是否管理员，集团管理员、系统管理员、审计管理员或单位管理员返回true，否则为false

	private Integer state;//人员状态：1为在职，2 为离职

	private String telNumber;//	手机号码

	private Date birthday;//	出生日期

	private String officeNum;//办公电话

	private String emailAddress;//	电子邮件

	private Integer gender;//性别 -1为未指定、1为男、2为女

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getSortId() {
		return sortId;
	}

	public void setSortId(Integer sortId) {
		this.sortId = sortId;
	}

	public Long getOrgAccountId() {
		return orgAccountId;
	}

	public void setOrgAccountId(Long orgAccountId) {
		this.orgAccountId = orgAccountId;
	}

	public Long getOrgDepartmentId() {
		return orgDepartmentId;
	}

	public void setOrgDepartmentId(Long orgDepartmentId) {
		this.orgDepartmentId = orgDepartmentId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Integer getIsInternal() {
		return isInternal;
	}

	public void setIsInternal(Integer isInternal) {
		this.isInternal = isInternal;
	}

	public Integer getIsAssigned() {
		return isAssigned;
	}

	public void setIsAssigned(Integer isAssigned) {
		this.isAssigned = isAssigned;
	}

	public Integer getIsAdamin() {
		return isAdamin;
	}

	public void setIsAdamin(Integer isAdamin) {
		this.isAdamin = isAdamin;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getTelNumber() {
		return telNumber;
	}

	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getOfficeNum() {
		return officeNum;
	}

	public void setOfficeNum(String officeNum) {
		this.officeNum = officeNum;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}
}
