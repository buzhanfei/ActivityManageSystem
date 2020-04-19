package com.ac.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ac.service.ACService;
import com.ac.vo.JsonResult;

@Controller
public class PageController {
	
	@Autowired
	private ACService acService;
	
	
	//显示首页
	@RequestMapping("/index")
	public String getIndex() {
		return "index";
	}
	//转到新增页面
	@RequestMapping("/add")
	public String getEdit() {
		return "add_edit";
	}
	
	//转到修改页面,当前活动信息回显到修改页面
	@RequestMapping("/update")
	public String getUpdate(Model model, Integer id) {
		JsonResult jsonResult = acService.findObjectById(id);
		model.addAttribute("idObject", jsonResult);
		return "update_edit";
	}
	
}
