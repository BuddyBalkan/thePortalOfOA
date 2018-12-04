package com.seeyon.apps.portal.utils.XML;

import java.util.ArrayList;
import java.util.List;

import com.seeyon.apps.portal.po.Department;
import org.dom4j.Attribute;
import org.dom4j.Element;

/**
  *部门解析
 * @author hucuigang
 *
 */
public class DepartmentDom4j {
	
	public static List<Department> departmentDatas(Element dataProperty) {
		List<Department> departmentList = new ArrayList<Department>();
		List<Element> dataPojoInList = dataProperty.elements();
		for (Element dataPojoIn : dataPojoInList) {
			Attribute dataPojoInAttr = dataPojoIn.attribute("type");
			if("DepartmentInfoParam_All".equals(dataPojoInAttr.getText())) {
				Department department = departmenData(dataPojoIn);
				departmentList.add(department);
			}	
		}
		return departmentList;
	}

	private static Department departmenData(Element dataPojoIn) {
		Department department = new Department();
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
			toDepartment(department,propertynameAttr, str);	
		}
		return department;
	}
	
	private static void toDepartment(Department department,Attribute propertynameAttr, String str) { 
		if("departmentName".equals(propertynameAttr.getText())) {
			department.setDepartmentName(str);
		}
		if("accountId".equals(propertynameAttr.getText())) {
			department.setAccountId(Long.parseLong(str));
		}
		if("discursion".equals(propertynameAttr.getText())) {
			department.setDiscursion(str);
		}
		if("dep_sort".equals(propertynameAttr.getText())) {
			department.setDep_sort(Long.parseLong(str));
		}
		if("departmentNumber".equals(propertynameAttr.getText())) {
			department.setDepartmentNumber(Long.parseLong(str));
		}
	}
}
