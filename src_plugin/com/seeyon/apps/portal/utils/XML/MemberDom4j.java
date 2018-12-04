package com.seeyon.apps.portal.utils.XML;

import java.util.ArrayList;
import java.util.List;

import com.seeyon.apps.portal.po.Member;
import org.dom4j.Attribute;
import org.dom4j.Element;

/**
 * 人员解析
 * @author hucuigang
 *
 */
public class MemberDom4j {
	public static List<Member> memberDatas(Element dataProperty) {
		List<Member> memberList = new ArrayList<Member>();
		List<Element> dataPojoInList = dataProperty.elements();
		for (Element dataPojoIn : dataPojoInList) {
			Attribute dataPojoInAttr = dataPojoIn.attribute("type");
			if("PersonInfoParam_All".equals(dataPojoInAttr.getText())) {
				Member member = memberData(dataPojoIn);
				memberList.add(member);
			}	
		}
		return memberList;
	}

	private static Member memberData(Element dataPojoIn) {
		Member member = new Member();
		List<Element> dataPropertyInList = dataPojoIn.elements();
		for (Element dataPropertyIn : dataPropertyInList) {
			Attribute propertynameAttr = dataPropertyIn.attribute("propertyname");
			Attribute valueAttr = dataPropertyIn.attribute("value");
			Element dataValue = dataPropertyIn.element("DataValue");
			String dataPropertyInText = dataPropertyIn.getText();
			String str ="";
			if(dataValue!=null) {
				str =dataValue.getText();
			}
			if(valueAttr!=null) {
				str =valueAttr.getText();
			}
			if(dataPropertyInText!=null&&!("".equals(dataPropertyInText.trim()))) {
				str=dataPropertyIn.getText();
			}
			toMember(member,propertynameAttr, str);	
		}
		return member;
	}
	
	private static void toMember(Member member,Attribute propertynameAttr, String str) { 
		if("accountId".equals(propertynameAttr.getText())) {
			member.setAccountId(Long.parseLong(str));;
		}
		if("otypeName".equals(propertynameAttr.getText())) {
			member.setOtypeName(str);;
		}
		if("birthday".equals(propertynameAttr.getText())) {
			member.setBirthday(str);
		}
		if("per_sort".equals(propertynameAttr.getText())) {
			member.setPer_sort(Long.parseLong(str));
		}
		if("sex".equals(propertynameAttr.getText())) {
			member.setSex(str);;
		}
		if("ocupationName".equals(propertynameAttr.getText())) {
			member.setOcupationName(str);
		}
		if("accountId".equals(propertynameAttr.getText())) {
			member.setAccountId(Long.parseLong(str));
		}
		if("secondOcupationName".equals(propertynameAttr.getText())) {
			member.setSecondOcupationName(str);
		}
		if("trueName".equals(propertynameAttr.getText())) {
			member.setTrueName(str);
		}
		if("discursion".equals(propertynameAttr.getText())) {
			member.setDiscursion(str);
		}
		if("familyPhone".equals(propertynameAttr.getText())) {
			member.setFamilyPhone(str);
		}
		if("officePhone".equals(propertynameAttr.getText())) {
			member.setOfficePhone(str);
		}
		if("departmentName".equals(propertynameAttr.getText())) {
			member.setDepartmentName(str);;
		}
		if("passWord".equals(propertynameAttr.getText())) {
			member.setPassWord(str);;
		}
		if("staffNumber".equals(propertynameAttr.getText())) {
			member.setStaffNumber(Long.parseLong(str));
		}
		if("familyAddress".equals(propertynameAttr.getText())) {
			member.setFamilyAddress(str);
		}
		if("id".equals(propertynameAttr.getText())) {
			member.setId(Long.parseLong(str));
		}
		if("mobilePhone".equals(propertynameAttr.getText())) {
			member.setMobilePhone(str);
		}
		if("identity".equals(propertynameAttr.getText())) {
			member.setIdentity(str);;
		}
		if("email".equals(propertynameAttr.getText())) {
			member.setDiscursion(str);
		}
		if("loginName".equals(propertynameAttr.getText())) {
			member.setLoginName(str);
		}
	}
}
