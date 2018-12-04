package com.seeyon.portal.utils.XML;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Element;

import com.seeyon.portal.pojo.OrgLevel;
/**
 * 职务解析
 * @author hucuigang
 *
 */
public class OrgLevelDom4j {
	public static List<OrgLevel> orgLevelDatas(Element dataProperty) {
		List<OrgLevel> orgLevelList = new ArrayList<OrgLevel>();
		List<Element> dataPojoInList = dataProperty.elements();
		for (Element dataPojoIn : dataPojoInList) {
			Attribute dataPojoInAttr = dataPojoIn.attribute("type");
			if("OtypeInfoParam_A8_All".equals(dataPojoInAttr.getText())) {
				OrgLevel orgLevel = orgLevelData(dataPojoIn);
				orgLevelList.add(orgLevel);
			}	
		}
		return orgLevelList;
	}

	private static OrgLevel orgLevelData(Element dataPojoIn) {
		OrgLevel orgLevel = new OrgLevel();
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
			toOrgLevel(orgLevel,propertynameAttr, str);	
		}
		return orgLevel;
	}
	
	private static void toOrgLevel(OrgLevel orgLevel,Attribute propertynameAttr, String str) { 
		if("accountId".equals(propertynameAttr.getText())) {
			orgLevel.setAccountId(Long.parseLong(str));;
		}
		if("levelId".equals(propertynameAttr.getText())) {
			orgLevel.setLevelId(Long.parseLong(str));
		}
		if("discursion".equals(propertynameAttr.getText())) {
			orgLevel.setDiscursion(str);
		}
		if("code".equals(propertynameAttr.getText())) {
			orgLevel.setCode(Long.parseLong(str));;
		}
		if("OTypeName".equals(propertynameAttr.getText())) {
			orgLevel.setOTypeName(str);
		}
		if("parentName".equals(propertynameAttr.getText())) {
			orgLevel.setParentName(str);;
		}
	}
}
