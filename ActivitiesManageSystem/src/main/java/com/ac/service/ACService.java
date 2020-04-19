package com.ac.service;

import java.util.List;


import com.ac.entity.Activity;
import com.ac.vo.JsonResult;

public interface ACService {
	List<JsonResult> findObject();
	
	int deleteObject(Integer id);
	
	int addObject(Activity ac);
	
	int updateObject(Activity ac);
	
	JsonResult findObjectById(Integer id);
}
