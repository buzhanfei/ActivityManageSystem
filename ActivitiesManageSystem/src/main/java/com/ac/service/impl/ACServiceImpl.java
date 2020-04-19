package com.ac.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ac.entity.Activity;
import com.ac.mapper.ACMapper;
import com.ac.service.ACService;
import com.ac.vo.JsonResult;

@Service
public class ACServiceImpl implements ACService{

	@Autowired
	private ACMapper acMapper;
	
	@Override
	public List<JsonResult> findObject() {
		List<Activity> list = acMapper.findObject();
		List<JsonResult> jsonList = Collections.synchronizedList(new ArrayList<>(list.size()));
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//遍历list,封装数据到List<JsonResult>集合
		for (Activity ac : list) {
			JsonResult jsonResult = getJsonResult(ac, s);
			jsonList.add(jsonResult);
		}
		return jsonList;
	}

	/**
	 * 用于判断活动时间开始或结束,返回不同JsonResult对象
	 * @param ac
	 * @param s
	 * @return
	 */
	private JsonResult getJsonResult(Activity ac, SimpleDateFormat s) {
		Date date = new Date();
		//比较活动开始时间与当前时间大小
		int compareTo = ac.getStartTime().compareTo(date);
		
		//判断活动是否开始,提供不同的操作和显示
		//已开始：url=doDeleteObject, operation=删除
		//未开始：url=update, operation=修改
		String url = compareTo <= 0 ?"doDeleteObject":"update";
		String operation = compareTo <= 0 ?"删除":"修改";
		
		//格式化开始时间为：yyyy-MM-dd HH:mm:ss 形式
		String startTime = s.format(ac.getStartTime());
		long time = ac.getStartTime().getTime();
		long duration = ac.getDuration()*3600*1000;
		//结束时间：开始时间和持续时间毫秒值之和
		time = time + duration;
		date.setTime(time);
		
		//格式化结束时间为：yyyy-MM-dd HH:mm:ss 形式
		String endTime = s.format(date);
		return new JsonResult(ac, operation, url, endTime, startTime);
	}

	@Override
	public JsonResult findObjectById(Integer id) {
		Activity ac = acMapper.findObjectById(id);
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//返回JsonResult对象用于回显数据
		return getJsonResult(ac, s);
	}
	
	@Override
	public int deleteObject(Integer id) {
		Activity ac = acMapper.findObjectById(id);
		Date date = new Date();
		long timeStart = ac.getStartTime().getTime();
		//持续时长毫秒值
		long duration = ac.getDuration()*3600*1000;
		long timeEnd = timeStart + duration;
		//true: 开始 
		boolean start = timeStart <= date.getTime();
		//true: 未结束
		boolean end = timeEnd > date.getTime();
		//判断活动是否开始？开始后是否结束？未结束则抛出异常
		//已结束则进行删除操作
		if(start && end) {
			throw new RuntimeException("活动未结束,不可删除!!!");
		}
		return acMapper.deleteObject(id);
	}

	@Override
	public int addObject(Activity ac) {
		return acMapper.addObject(ac);
	}

	@Override
	public int updateObject(Activity ac) {
		return acMapper.updateObject(ac);
	}

}
	
