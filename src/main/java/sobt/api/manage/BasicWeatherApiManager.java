package sobt.api.manage;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import sobt.dao.weather.WeatherDataDao;
import sobt.domain.message.MessageVo;
import sobt.domain.weather.WeatherAllPlaceData;
import sobt.domain.weather.WeatherData;
import sobt.http.service.HttpService;
import sobt.parser.service.ParserService;
import sobt.parser.service.WeatherAllPlaceParser;
import sobt.parser.service.WeatherLocationParser;
import sobt.util.SOBTConstant;


public class BasicWeatherApiManager implements WeatherApiManager{
	
	private HttpService httpService;
	private ParserService parserService;
	private String appKey;
	private WeatherDataDao weatherDataDao;
	
	
	public void setAppkey(String appkey){
		this.appKey = appkey;
	}
	
	public void setParserService(ParserService parserService){
		this.parserService = parserService;
	}
	public void setHttpService(HttpService httpService){
		this.httpService = httpService;
	}
	
	
	
	public void setWeatherDataDao(WeatherDataDao weatherDataDao) {
		this.weatherDataDao = weatherDataDao;
	}

	@Override
	public String getWeatherMin(String city, String county, String village) {
		
		String url = String.format(SOBTConstant.WEATHER_API_URL_MIN, city, county, village);
		parserService = new WeatherLocationParser();
		
		return parserService.Parse(httpService.doHttpGet(url, "AppKey", appKey));
	}

	@Override
	public String getWeatherAll() {

		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String ymd = format.format(date);
		
		WeatherData data = weatherDataDao.getWeather(ymd);
		
		return data.getSentence();
	}

}
