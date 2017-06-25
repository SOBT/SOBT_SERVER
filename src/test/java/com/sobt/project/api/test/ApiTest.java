package com.sobt.project.api.test;
import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sobt.api.manage.*;
import sobt.dao.user.UserDao;
import sobt.dao.weather.JdbcWeatherDataDao;
import sobt.dao.weather.WeatherDataDao;
import sobt.http.service.HttpService;
import sobt.sql.service.SqlService;
import sobt.translate.service.PapagoService;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations="/test-applicationContext.xml")


public class ApiTest {
	
	@Autowired
	private WeatherApiManager weatehrApiManager;
	@Autowired
	HttpService httpService;
	
	@Autowired
	WeatherDataDao weatherDataDao;
	
	@Test
	public void ApiTest(){
//		ApiUmarshal<WeatherAllPlaceData> api = new ApiUmarshal<WeatherAllPlaceData>();
//		WeatherRssData data = api.DoUnmarshal(new ApacheHttpService().DoHttpGet("http://www.kma.go.kr/weather/forecast/mid-term-rss3.jsp?stnId=108"), new WeatherRssData());
//		System.out.println(data.getName().getName());
		System.out.print(weatehrApiManager.getWeatherMin("서울", "노원구", "월계동"));
		System.out.println("");
		System.out.println(weatehrApiManager.getWeatherAll());
		
	}
	

}
