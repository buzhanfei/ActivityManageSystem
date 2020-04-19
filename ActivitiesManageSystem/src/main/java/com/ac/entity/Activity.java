package com.ac.entity;

import java.util.Date;

public class Activity {
	private Integer id;
	private String type;
	private Date startTime;
	private Integer duration;
	private String locus;
	private Integer num;
	private String remark;

	public Activity() {
	}

	public Activity(Integer id, String type, Date startTime, Integer duration, String locus, Integer num,
			String remark) {
		super();
		this.id = id;
		this.type = type;
		this.startTime = startTime;
		this.duration = duration;
		this.locus = locus;
		this.num = num;
		this.remark = remark;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public String getLocus() {
		return locus;
	}

	public void setLocus(String locus) {
		this.locus = locus;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Activity [id=" + id + ", type=" + type + ", startTime=" + startTime + ", duration=" + duration
				+ ", locus=" + locus + ", num=" + num + ", remark=" + remark + "]";
	}




}
