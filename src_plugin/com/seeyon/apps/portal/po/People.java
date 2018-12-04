package com.seeyon.apps.portal.po;
/*
 * 用户实体
 *赵相萍
 */
import java.io.Serializable;
import java.util.Date;

public class People implements Serializable{
	private long id;
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public int getSortld() {
		return sortld;
	}
	public void setSortld(int sortld) {
		this.sortld = sortld;
	}
	public int getOrgAccountld() {
		return orgAccountld;
	}
	public void setOrgAccountld(int orgAccountld) {
		this.orgAccountld = orgAccountld;
	}
	public int getOrgLevelld() {
		return orgLevelld;
	}
	public void setOrgLevelld(int orgLevelld) {
		this.orgLevelld = orgLevelld;
	}
	public int getOrgDepartmentld() {
		return orgDepartmentld;
	}
	public void setOrgDepartmentld(int orgDepartmentld) {
		this.orgDepartmentld = orgDepartmentld;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isDeleted() {
		return isDeleted;
	}
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	public boolean isInternal() {
		return isInternal;
	}
	public void setInternal(boolean isInternal) {
		this.isInternal = isInternal;
	}
	public boolean isAssigned() {
		return isAssigned;
	}
	public void setAssigned(boolean isAssigned) {
		this.isAssigned = isAssigned;
	}
	public boolean isAdamin() {
		return isAdamin;
	}
	public void setAdamin(boolean isAdamin) {
		this.isAdamin = isAdamin;
	}
	public int getSate() {
		return sate;
	}
	public void setSate(int sate) {
		this.sate = sate;
	}
	public int getTelNumber() {
		return telNumber;
	}
	public void setTelNumber(int telNumber) {
		this.telNumber = telNumber;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public int getOfficeNum() {
		return officeNum;
	}
	public void setOfficeNum(int officeNum) {
		this.officeNum = officeNum;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	private String name;
	private String code;
	private Date createTime;
	private Date updateTime;
	private int sortld;
	private int orgAccountld;
	private int orgLevelld;
	private int orgDepartmentld;
	private String description;
	private boolean isDeleted;
	private boolean isInternal;
	private boolean isAssigned;
	private boolean isAdamin;
	private int sate;
	private int telNumber;
	private Date birthday;
	private int officeNum;
	private String emailAddress;
	private int gender;

}
