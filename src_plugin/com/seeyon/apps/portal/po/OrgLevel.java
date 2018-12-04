package com.seeyon.apps.portal.po;

import java.io.Serializable;

/**
 * 职务
 * @author hucuigang
 *
 */
public class OrgLevel implements Serializable{
	private Long  accountId;//单位ID
	private Long levelId;// 职务级别序号
	private String discursion;// 描述
	private String OTypeName;//名称
	private Long  code;//	代码 
	private String type;//类别
	private String parentName;// 映射职务级别名称
	public long getAccountId() {
		return accountId;
	}
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
	public Long  getLevelId() {
		return levelId;
	}
	public void setLevelId(Long  levelId) {
		this.levelId = levelId;
	}
	public String getDiscursion() {
		return discursion;
	}
	public void setDiscursion(String discursion) {
		this.discursion = discursion;
	}
	public String getOTypeName() {
		return OTypeName;
	}
	public void setOTypeName(String oTypeName) {
		OTypeName = oTypeName;
	}
	public Long  getCode() {
		return code;
	}
	public void setCode(Long  code) {
		this.code = code;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	@Override
	public String toString() {
		return "OrgLevels [accountId=" + accountId + ", levelId=" + levelId + ", discursion=" + discursion
				+ ", OTypeName=" + OTypeName + ", code=" + code + ", type=" + type + ", parentName=" + parentName + "]";
	}
	
	
	
}
