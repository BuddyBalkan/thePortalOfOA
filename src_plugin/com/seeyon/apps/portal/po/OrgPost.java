package com.seeyon.apps.portal.po;

import java.io.Serializable;
/**
 * 岗位实体
 * @author hucuigang
 *
 */
public class OrgPost implements Serializable{
	private Long accountId;//单位ID
	private String ocupationName;//岗位名称
	private Long sortId;//排序号
	private String discursion;//描述
	private Long code;//	代码 
	private String type;//类别
	private String departmentArray;//部门
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public String getOcupationName() {
		return ocupationName;
	}
	public void setOcupationName(String ocupationName) {
		this.ocupationName = ocupationName;
	}
	public Long getSortId() {
		return sortId;
	}
	public void setSortId(Long sortId) {
		this.sortId = sortId;
	}
	public String getDiscursion() {
		return discursion;
	}
	public void setDiscursion(String discursion) {
		this.discursion = discursion;
	}
	public Long getCode() {
		return code;
	}
	public void setCode(Long code) {
		this.code = code;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDepartmentArray() {
		return departmentArray;
	}
	public void setDepartmentArray(String departmentArray) {
		this.departmentArray = departmentArray;
	}
	@Override
	public String toString() {
		return "Posts [accountId=" + accountId + ", ocupationName=" + ocupationName + ", sortId=" + sortId
				+ ", discursion=" + discursion + ", code=" + code + ", type=" + type + ", departmentArray="
				+ departmentArray + "]";
	}
	
	
}
