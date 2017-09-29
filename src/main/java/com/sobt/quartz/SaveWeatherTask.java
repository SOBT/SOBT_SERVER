package com.sobt.quartz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import sobt.api.manage.WeatherApiManager;
import sobt.dao.weather.WeatherDataDao;
import sobt.domain.weather.WeatherData;
import sobt.http.service.HttpService;
import sobt.parser.service.ParserService;
import sobt.parser.service.WeatherAllPlaceParser;
import sobt.sql.service.BasicSqlService;
import sobt.sql.service.SqlService;
import sobt.util.SOBTConstant;

public class SaveWeatherTask {
	@Autowired
	private WeatherApiManager weatehrApiManager;

	
	public void Excute(){
		weatehrApiManager.addWeatherAll();

	}
}
