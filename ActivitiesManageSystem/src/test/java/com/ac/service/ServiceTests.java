package com.ac.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ac.vo.JsonResult;



@SpringBootTest
public class ServiceTests {
	@Autowired
	private ACService acService;
	
	@Test
	public void findObjectTest() {
		List<JsonResult> findObject = acService.findObject();
		for (JsonResult jsonResult : findObject) {
			System.out.println(jsonResult);
		}
		
	}
	
}
