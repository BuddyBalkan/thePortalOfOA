package com.seeyon.apps.portal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import tk.mybatis.mapper.common.Mapper;

public interface BaseService<T> {
	//根据id查询一个
	public T queryById(Long id);
	
	//根据指定的条件查询一个
	public T queryByWhere(T record);
	
	//根据指定的条件查询多个
	public List<T> queryListByWhere(T record);
	
	//保存
	public void save(T t);
	
    //修改
    public void update(T t);

    //删除
    public void deleteById(Long id);

	
}
