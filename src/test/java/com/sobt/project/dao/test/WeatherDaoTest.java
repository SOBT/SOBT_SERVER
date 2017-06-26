package com.sobt.project.dao.test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sobt.api.manage.WeatherApiManager;
import sobt.dao.weather.WeatherDataDao;
import sobt.domain.weather.WeatherData;
import sobt.http.service.HttpService;


import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/test-applicationContext.xml")

public class WeatherDaoTest {
	
	@Autowired
	private WeatherApiManager weatehrApiManager;
	@Autowired
	HttpService httpService;
	
	@Autowired
	WeatherDataDao weatherDataDao;
	
	WeatherData weather1;
	
	@Before
	public void setUp(){
		
	}
	
	@Test
	public void addWeather(){
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String ymd = format.format(date);
		weather1 = new WeatherData(weatehrApiManager.getWeatherAll(), ymd);
		weatherDataDao.addWeather(weather1);
		
	}
	
	@Test
	public void getWeather(){
		
//		Date date = new Date(System.currentTimeMillis());
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//		String ymd = format.format(date);
//		WeatherData data = weatherDataDao.getWeather(ymd);
//		System.out.println(data.getSentence());
		
	}
	
}
