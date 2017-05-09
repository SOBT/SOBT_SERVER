package com.sobt.project.api.test;
import static org.junit.Assert.*;

import org.junit.Test;

import sobt.api.manage.*;
import sobt.http.service.ApacheHttpService;
import sobt.parser.service.WeatherParserService;
import sobt.util.SOBTConstant;

import static org.hamcrest.CoreMatchers.*;

public class ApiTest {
	
	@Test
	public void ApiTest(){
		
		WeatherApiManager a = new BasicWeatherApiManager();
		
		((BasicWeatherApiManager)a).setAppkey(SOBTConstant.WEATHER_API_APP_KEY);;
		((BasicWeatherApiManager)a).setHttpService(new ApacheHttpService());
		((BasicWeatherApiManager)a).setParserService(new WeatherParserService());
		
		System.out.print(a.getWeatherMin("서울", "노원구", "월계동"));
	}
}
