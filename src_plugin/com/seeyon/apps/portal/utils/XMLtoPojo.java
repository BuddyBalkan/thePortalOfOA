package com.seeyon.apps.portal.utils;



import java.util.List;

import com.seeyon.apps.portal.po.Department;
import com.seeyon.apps.portal.po.Member;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.seeyon.apps.portal.po.OrgLevel;
import com.seeyon.apps.portal.po.OrgPost;
import com.seeyon.apps.portal.utils.XML.DepartmentDom4j;
import com.seeyon.apps.portal.utils.XML.MemberDom4j;
import com.seeyon.apps.portal.utils.XML.OrgLevelDom4j;
import com.seeyon.apps.portal.utils.XML.OrgPostDom4j;

/**
 * @author hucuigang
 * @date 2018.12.3 
 * 同步各组织机构数据到List集合
 */
public class XMLtoPojo {
	private static Logger LOGGER=LoggerFactory.getLogger(RestWebServiceClient.class);
	//获取xml数据
	private static String xml= RestWebServiceClient
			.getRestWebServiceClientUtil().getOrganizationXML("微鑫通时代科技有限公司");
	
	//存放部门信息
	private static List<Department> departments;
	//存放岗位信息
	private static List<OrgPost> orgPosts;
	//存放职位信息
	private static List<OrgLevel> orgLevels;
	//存放人员信息
	private static List<Member> members;
	
	public static void synchronization() throws DocumentException {
		//将字符串转换为document对象
		Document document = DocumentHelper.parseText(xml);
		// 得到xml文档根节点元素
		Element dataPojo = document.getRootElement();
		// 获取根节点的子节点
		List<Element> dataPropertyList = dataPojo.elements();
		// 开始往下遍历
		for (Element dataProperty : dataPropertyList) {
			Attribute dataPropertyAttr = dataProperty.attribute("propertyname");
			String Organization = dataPropertyAttr.getText();
			// 部门数据
			if ("depArray".equals(Organization)) {
				departments = DepartmentDom4j.departmentDatas(dataProperty);
				LOGGER.debug("部门数据为{}", departments.toString());
			}
			// 岗位数据
			if ("ocupationArray".equals(Organization)) {
				orgPosts = OrgPostDom4j.orgpostDatas(dataProperty);
				LOGGER.debug("岗位数据为{}", orgPosts.toString());
			}
			// 职务数据
			if ("otypeArray".equals(Organization)) {
				orgLevels = OrgLevelDom4j.orgLevelDatas(dataProperty);
				LOGGER.debug("职务数据为{}", orgLevels.toString());
			}
			// 人员数据
			if ("personArray".equals(Organization)) {
				members = MemberDom4j.memberDatas(dataProperty);
				LOGGER.debug("人员数据为{}", members.toString());
			}

		}
						
	}
	
}
