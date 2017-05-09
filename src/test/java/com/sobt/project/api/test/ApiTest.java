package com.sobt.project.api.test;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sobt.api.manage.*;
import sobt.http.service.ApacheHttpService;
import sobt.parser.service.WeatherParserService;
import sobt.util.SOBTConstant;

import static org.hamcrest.CoreMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/test-applicationContext.xml")

public class ApiTest {
	
	@Autowired
	private WeatherApiManager weatehrApiManager;
	@Test
	public void ApiTest(){
	
		
		
		System.out.print(weatehrApiManager.getWeatherMin("서울", "노원구", "월계동"));
	}
}
