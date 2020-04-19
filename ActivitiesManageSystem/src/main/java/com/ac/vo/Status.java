package com.ac.vo;

import java.io.Serializable;

/**
 * 此对象用于返回给前台,判断操作成功与否
 * @author
 *
 */
public class Status implements Serializable{
	private static final long serialVersionUID = 7159215154382746843L;
	
	private Integer status;//状态码200成功,201失败
	private String message;//失败信息
	
	public Status() {
	}
	public Status(Integer status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "Status [status=" + status + ", message=" + message + "]";
	}
	
}
