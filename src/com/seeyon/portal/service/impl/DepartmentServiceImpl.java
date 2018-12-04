package com.seeyon.portal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.seeyon.portal.dao.DepartmentDao;
import com.seeyon.portal.pojo.Department;
import com.seeyon.portal.service.DepartmentService;

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
