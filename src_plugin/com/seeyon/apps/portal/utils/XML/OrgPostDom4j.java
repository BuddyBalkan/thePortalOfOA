package com.seeyon.apps.portal.utils.XML;

import java.util.ArrayList;
import java.util.List;

import com.seeyon.apps.portal.po.OrgPost;
import org.dom4j.Attribute;
import org.dom4j.Element;

/**
 * 岗位解析
 * @author hucuigang
 *
 */
public class OrgPostDom4j {
	public static List<OrgPost> orgpostDatas(Element dataProperty) {
		List<OrgPost> postList = new ArrayList<OrgPost>();
		List<Element> dataPojoInList = dataProperty.elements();
		for (Element dataPojoIn : dataPojoInList) {
			Attribute dataPojoInAttr = dataPojoIn.attribute("type");
			if("OcupationInfoParam_A8_All".equals(dataPojoInAttr.getText())) {
				OrgPost post = postData(dataPojoIn);
				postList.add(post);
			}	
		}
		return postList;
	}

	private static OrgPost postData(Element dataPojoIn) {
		OrgPost post = new OrgPost();
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
			toPost(post,propertynameAttr, str);	
		}
		return post;
	}
	
	private static void toPost(OrgPost post,Attribute propertynameAttr, String str) { 
		if("accountId".equals(propertynameAttr.getText())) {
			post.setAccountId(Long.parseLong(str));;
		}
		if("ocupationName".equals(propertynameAttr.getText())) {
			post.setOcupationName(str);;
		}
		if("discursion".equals(propertynameAttr.getText())) {
			post.setDiscursion(str);
		}
		if("sortId".equals(propertynameAttr.getText())) {
			post.setSortId(Long.parseLong(str));
		}
		if("code".equals(propertynameAttr.getText())) {
			post.setCode(Long.parseLong(str));
		}
		if("type".equals(propertynameAttr.getText())) {
			post.setType(str);
		}
		if("departmentArray".equals(propertynameAttr.getText())) {
			post.setDepartmentArray(str);
		}
	}
}
