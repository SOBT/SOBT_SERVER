package sobt.api.manage;

import java.util.HashMap;

import sobt.http.service.HttpService;
import sobt.http.service.ApacheHttpService;
import sobt.parser.service.AirQualityparserService;
import sobt.parser.service.ParserService;
import sobt.parser.service.WeatherParserService;
import sobt.util.SOBTConstant;

public class BasicWeatherApiManager implements WeatherApiManager{
	
	private HttpService httpService;
	private ParserService parserService;
	private String appKey;
	
	public void setAppkey(String appkey){
		this.appKey = appkey;
	}
	
	public void setParserService(ParserService parserService){
		this.parserService = parserService;
	}
	public void setHttpService(HttpService httpService){
		this.httpService = httpService;
	}
	
	
	@Override
	public String getWeatherMin(String city, String county, String village) {
		
		String url = String.format(SOBTConstant.WEATHER_API_URL_MIN, city, county, village);
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("AppKey", appKey);
		return parserService.Parse(httpService.getData(url, map));
	}

	@Override
	public String getWeatherLoc(double lat, double lon) {
		String url = String.format(SOBTConstant.WEATHER_API_URL_LOC, lat, lon);
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("AppKey", appKey);
		return parserService.Parse(httpService.getData(url, map));
	}
	
	

}
