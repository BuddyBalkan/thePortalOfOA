package com.seeyon.portal.pojo;

import java.io.Serializable;
import java.util.Date;
/**
 * 单位实体类
 * @author 周钇休
 *
 */
public class OrgAccount implements Serializable{
	private long id;//单位ID
	private String name;//单位名称
	private String code;//单位编码
	private String shortName;//单位简称
	private Date createTime;//	创建时间
	private Date updateTime;//更改时间
	private int sortId;//排序号
	private String description;//单位描述
	private String fax;//单位传真
	private String unitMail;//单位邮箱
	private String chiefLeader;//负责人
	private String telephone;//单位电话
	private String zipCode;//邮编
	private String type;//单位类型
	private String secondName;//单位英文名

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

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
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

	public int getSortId() {
		return sortId;
	}

	public void setSortId(int sortId) {
		this.sortId = sortId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getUnitMail() {
		return unitMail;
	}

	public void setUnitMail(String unitMail) {
		this.unitMail = unitMail;
	}

	public String getChiefLeader() {
		return chiefLeader;
	}

	public void setChiefLeader(String chiefLeader) {
		this.chiefLeader = chiefLeader;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
}
