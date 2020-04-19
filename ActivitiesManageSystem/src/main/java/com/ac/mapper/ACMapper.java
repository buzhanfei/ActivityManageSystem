package com.ac.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ac.entity.Activity;

@Mapper
public interface ACMapper {
	//查询所有活动信息
	List<Activity> findObject();
	
	int deleteObject(@Param("id") Integer id);
	
	int addObject(Activity ac);
	
	int updateObject(Activity ac);
	
	//根据ID值查询
	Activity findObjectById(@Param("id") Integer id);
}
