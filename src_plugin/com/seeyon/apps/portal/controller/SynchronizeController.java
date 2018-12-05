/**
 * 
 */
package com.seeyon.apps.portal.controller;

/**
 * @author Y_hr
 *
 */

import java.util.List;

import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.seeyon.apps.portal.po.Department;
import com.seeyon.apps.portal.service.DepartmentService;
import com.seeyon.apps.portal.utils.XMLtoPojo;

@RequestMapping("/org")
public class SynchronizeController {
	@Autowired
	private DepartmentService departmentService;
	
	@RequestMapping("/syn")
	public String synchronize() throws DocumentException {
		
		XMLtoPojo.synchronization();
		List<Department> Departments = XMLtoPojo.departments;
		
		for(Department department : Departments) {
			departmentService.saveDepartment(department);
		}
		
		return null;
	}
}