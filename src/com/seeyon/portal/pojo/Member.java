package com.seeyon.portal.pojo;
/**
 * @author hucuigang 
 * @date 2018.12.1 
 * 人员信息pojo
 */
import java.io.Serializable; 
import java.util.Date;

public class Member implements Serializable{
	private String otypeName;//职务级别
	private String birthday;//出生日期
	private Long per_sort;//排序号
	private String sex;//性别 
	private String ocupationName;//岗位 
	private Long accountId;//单位ID
	private String secondOcupationName;//副岗
	private String trueName;//姓名
	private String discursion;//描述
	private String familyPhone;//家庭电话
	private String officePhone;//办公电话 
	private String departmentName;//部门 
	private String passWord;//密码 
	private Long staffNumber;//员工号
	private String familyAddress;//家庭住址
	private Long id;//单位ID
	private String identity;//身份证（此属性为预留字段，目前不支持） 
	private String mobilePhone;//移动电话 
	private String email;//电子邮件
	private String loginName;//登录名
	
	
	public String getOtypeName() {
		return otypeName;
	}
	public void setOtypeName(String otypeName) {
		this.otypeName = otypeName;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public Long getPer_sort() {
		return per_sort;
	}
	public void setPer_sort(Long per_sort) {
		this.per_sort = per_sort;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getOcupationName() {
		return ocupationName;
	}
	public void setOcupationName(String ocupationName) {
		this.ocupationName = ocupationName;
	}
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public String getSecondOcupationName() {
		return secondOcupationName;
	}
	public void setSecondOcupationName(String secondOcupationName) {
		this.secondOcupationName = secondOcupationName;
	}
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	public String getDiscursion() {
		return discursion;
	}
	public void setDiscursion(String discursion) {
		this.discursion = discursion;
	}
	public String getFamilyPhone() {
		return familyPhone;
	}
	public void setFamilyPhone(String familyPhone) {
		this.familyPhone = familyPhone;
	}
	public String getOfficePhone() {
		return officePhone;
	}
	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public Long getStaffNumber() {
		return staffNumber;
	}
	public void setStaffNumber(Long staffNumber) {
		this.staffNumber = staffNumber;
	}
	public String getFamilyAddress() {
		return familyAddress;
	}
	public void setFamilyAddress(String familyAddress) {
		this.familyAddress = familyAddress;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	@Override
	public String toString() {
		return "Member [otypeName=" + otypeName + ", birthday=" + birthday + ", per_sort=" + per_sort + ", sex=" + sex
				+ ", ocupationName=" + ocupationName + ", accountId=" + accountId + ", secondOcupationName="
				+ secondOcupationName + ", trueName=" + trueName + ", discursion=" + discursion + ", familyPhone="
				+ familyPhone + ", officePhone=" + officePhone + ", departmentName=" + departmentName + ", passWord="
				+ passWord + ", staffNumber=" + staffNumber + ", familyAddress=" + familyAddress + ", id=" + id
				+ ", identity=" + identity + ", mobilePhone=" + mobilePhone + ", email=" + email + ", loginName="
				+ loginName + "]";
	}
	
	

}
