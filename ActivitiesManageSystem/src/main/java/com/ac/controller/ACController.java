package com.ac.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ac.entity.Activity;
import com.ac.service.ACService;
import com.ac.vo.JsonResult;
import com.ac.vo.Status;

@Controller
public class ACController {
	
	@Autowired
	private ACService acService;
	
	//获取所有活动信息
	@RequestMapping("/doGetObject")
	@ResponseBody
	public List<JsonResult> getObject(){
		List<JsonResult> list = acService.findObject();
		return list;
	}
	
	/* 删除操作完成,返回表示操作成功的Status的Json串 */
	@RequestMapping("/doDeleteObject")
	@ResponseBody
	public Status deleteObject(Integer id){
		acService.deleteObject(id);
		return new Status(200, "删除成功！！！");
	}
	
	/* 新增操作完成,重新跳转到首页 */
	@RequestMapping("/doAddObject")
	public String addObject(Activity ac){
		acService.addObject(ac);
		return "redirect:/index";
	}
	
	/* 更新操作完成,重新跳转到首页 */
	@RequestMapping("/doUpdateObject")
	public String updateObject(Activity ac){
		acService.updateObject(ac);
		return "redirect:/index";
	}
	
	
	
	
	/**
	 * 注册一个类型解析器
	 * @param binder
	 */
	@org.springframework.web.bind.annotation.InitBinder
	public void InitBinder(WebDataBinder binder){
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		dateFormat.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	
}
