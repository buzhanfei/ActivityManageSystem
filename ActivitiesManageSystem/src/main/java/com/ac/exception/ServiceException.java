package com.ac.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ac.vo.Status;

@RestControllerAdvice
public class ServiceException {
	
	/**
	 * 全局异常处理
	 * @param exception
	 * @param request
	 * @return
	 */
	@ExceptionHandler(RuntimeException.class)
	public Object sysResult(RuntimeException exception,HttpServletRequest request) {
			exception.printStackTrace();
		    // 例如业务层在禁止删除操作时,抛出运行时异常 ,返回给浏览器错误状态码和异常信息
			return new Status(201, exception.getMessage());
	}
}
