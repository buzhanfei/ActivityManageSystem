package com.ac.vo;
import java.io.Serializable;

import com.ac.entity.Activity;

/**
 * 基于此对象封装控制层要响应到客户端的数据
 */

public class JsonResult implements Serializable{
	private static final long serialVersionUID = 677048178703375661L;
	private Activity data;  //活动原始信息
	private String operation; //修改或删除
	private String url;  //update或doDeleteObject
	private String endTime;  //活动结束时间
	private String startTime; //活动开始时间
	
	public JsonResult() {
	}
	public JsonResult(Activity data, String operation, String url, String endTime, String startTime) {
		super();
		this.data = data;
		this.operation = operation;
		this.url = url;
		this.endTime = endTime;
		this.startTime = startTime;
	}
	
	public Activity getData() {
		return data;
	}
	public void setData(Activity data) {
		this.data = data;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	@Override
	public String toString() {
		return "JsonResult [data=" + data + ", operation=" + operation + ", url=" + url + ", endTime=" + endTime
				+ ", startTime=" + startTime + "]";
	}
	
	
}








