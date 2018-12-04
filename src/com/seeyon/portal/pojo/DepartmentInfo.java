package com.seeyon.portal.pojo;

import java.io.Serializable; 
import java.util.Date;

/**
 * @author 周钇休
 * 部门实体类
 */
public class DepartmentInfo implements Serializable{
	private Long id;	//部门id
	private Long accountId;	//单位id
	private String name;	//部门名称
	private String secondName;	//英文名称
	private Integer sortId;	//排序号
	private String shortName;	//简称
	private Integer code;	//部门代码
	private Date updataTime;	//更新时间
	private Date createTime;	//创建时间
	private Integer isDeleted;	//是否已删除
	private Integer enabled;	//是否启用
	
	private Integer status;		//状态
	private String description;	//详细描述
	private String path;	//url地址
	private Integer isInternal;	//是否内部编制
	private Integer isGroup;	//是否分组
	private String parenPath;	//父节点url地址
	private String address;		//部门所在地址
	private String telephone;	//部门电话

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public Integer getSortId() {
		return sortId;
	}

	public void setSortId(Integer sortId) {
		this.sortId = sortId;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
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

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Integer getEnabled() {
		return enabled;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
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

	public Integer getIsInternal() {
		return isInternal;
	}

	public void setIsInternal(Integer isInternal) {
		this.isInternal = isInternal;
	}

	public Integer getIsGroup() {
		return isGroup;
	}

	public void setIsGroup(Integer isGroup) {
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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
}
