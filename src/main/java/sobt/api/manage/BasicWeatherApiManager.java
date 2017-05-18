package sobt.api.manage;

import sobt.domain.weather.WeatherAllPlaceData;
import sobt.http.service.HttpService;
import sobt.parser.service.ParserService;
import sobt.parser.service.WeatherAllPlaceParser;
import sobt.parser.service.WeatherLocationParser;
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
		parserService = new WeatherLocationParser();
		
		return parserService.Parse(httpService.DoHttpGet(url, "AppKey", appKey));
	}

	@Override
	public String getWeatherAll() {

		String url = SOBTConstant.WEATHER_API_URL_ALL;
		parserService = new WeatherAllPlaceParser();
		
		return parserService.Parse(httpService.DoHttpGet(url));
	}

}
