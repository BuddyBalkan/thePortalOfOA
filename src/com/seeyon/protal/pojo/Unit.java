package com.seeyon.protal.pojo;

import java.io.Serializable;
import java.util.Date;
/*
 * 部门实体类
 */
public class Unit implements Serializable{
	private long id;
	private String name;
	private String secondname;
	private int sortld;
	private String shortName;
	private int code;
	private Date updataTime;
	private Date createTime;
	private int isDeleted;
	private int enabled;
	
	private int status;
	private String description;
	private String path;
	private int isInternal;
	private int isGroup;
	private String parenPath;
	private String address;
	private int telephone;
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
	public String getSecondname() {
		return secondname;
	}
	public void setSecondname(String secondname) {
		this.secondname = secondname;
	}
	public int getSortld() {
		return sortld;
	}
	public void setSortld(int sortld) {
		this.sortld = sortld;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public Date getUpdataTime() {
		return updataTime;
	}
	public void setUpdataTime(Date updataTime) {
		this.updataTime = updataTime;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}
	public int getEnabled() {
		return enabled;
	}
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public int getIsInternal() {
		return isInternal;
	}
	public void setIsInternal(int isInternal) {
		this.isInternal = isInternal;
	}
	public int getIsGroup() {
		return isGroup;
	}
	public void setIsGroup(int isGroup) {
		this.isGroup = isGroup;
	}
	public String getParenPath() {
		return parenPath;
	}
	public void setParenPath(String parenPath) {
		this.parenPath = parenPath;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getTelephone() {
		return telephone;
	}
	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}

}
