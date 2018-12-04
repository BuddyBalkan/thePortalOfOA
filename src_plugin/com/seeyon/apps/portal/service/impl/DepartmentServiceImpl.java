package com.seeyon.apps.portal.service.impl;

import com.seeyon.apps.portal.dao.DepartmentDao;
import org.springframework.beans.factory.annotation.Autowired;

import com.seeyon.apps.portal.po.Department;
import com.seeyon.apps.portal.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired
	private DepartmentDao departmentDao;
	@Override
	public void saveDepartment(Department department) {
		if(department == null) {
			return;
		}
		departmentDao.save(department);
	}
	
	@Override
	public void getAll() {
		departmentDao.getAll();
	}

}
