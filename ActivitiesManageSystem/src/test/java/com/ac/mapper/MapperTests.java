package com.ac.mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ac.entity.Activity;

@SpringBootTest
public class MapperTests {
	
	@Autowired
	private ACMapper acMapper;
	
	@Test
	public void mapperTest() {
		List<Activity> findObject = acMapper.findObject();
		for (Activity ac : findObject) {
			long time = ac.getStartTime().getTime();
			long duration = ac.getDuration();
			time = time + duration;
			Date date = new Date();
			date.setTime(time);
			SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String s1 = s.format(date);
			try {
				System.out.println(s.parse(s1));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		System.out.println(findObject);
	}
	
	@Test
	public void getObjectById() {
		Activity findObjectById = acMapper.findObjectById(10);
		System.out.println(findObjectById);
	}
}
