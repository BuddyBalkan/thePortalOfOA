package com.seeyon.apps.portal.po;

import java.io.Serializable;

public class Department implements Serializable {
	
	private Long accountId;//单位ID

	private String discursion;//描述
	
	private String departmentName;//名称

	private Long dep_sort;//排序号
	
	private Long departmentNumber;//部门代码
	
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public String getDiscursion() {
		return discursion;
	}
	public void setDiscursion(String discursion) {
		this.discursion = discursion;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public Long getDep_sort() {
		return dep_sort;
	}
	public void setDep_sort(Long dep_sort) {
		this.dep_sort = dep_sort;
	}
	public Long getDepartmentNumber() {
		return departmentNumber;
	}
	public void setDepartmentNumber(Long departmentNumber) {
		this.departmentNumber = departmentNumber;
	}
	@Override
	public String toString() {
		return "Department [accountId=" + accountId + ", discursion=" + discursion + ", departmentName="
				+ departmentName + ", dep_sort=" + dep_sort + ", departmentNumber=" + departmentNumber + "]";
	}
	
	
}
