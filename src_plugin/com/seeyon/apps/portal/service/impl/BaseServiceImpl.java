package com.seeyon.apps.portal.service.impl;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;

import com.seeyon.ctp.common.dao.BaseDao;

public class BaseServiceImpl {
	//泛型注入
    @Autowired
    private BaseDao<T> dao;
}
