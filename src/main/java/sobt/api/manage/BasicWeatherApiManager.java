package sobt.api.manage;

import java.util.HashMap;

import sobt.http.service.HttpService;
import sobt.http.service.ApacheHttpService;
import sobt.parser.service.AirQualityparserService;
import sobt.parser.service.ParserService;
import sobt.parser.service.WeatherParserService;

public class BasicWeatherApiManager implements WeatherApiManager{
	
	private HttpService httpService;
	private ParserService parserService;
	public void setParserService(ParserService parserService){
		this.parserService = parserService;
	}
	public void setHttpService(HttpService httpService){
		this.httpService = httpService;
	}
	
	
	@Override
	public String getWeatherMin(String city, String county, String village) {
		
		String url = String.format("http://apis.skplanetx.com/weather/current/minutely?version=1&lat=&lon=&city=%s&county=%s&village=%s&stnid=", city, county, village);
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("AppKey", "1c33a135-5e89-34c1-baf9-ba0d453a29e8");
		return parserService.Parse(httpService.getData(url, map));
	}

	@Override
	public String getWeatherLoc(double lat, double lon) {
		String url = String.format("http://apis.skplanetx.com/weather/airquality/current?version=1&lat=%f&lon=%f", lat, lon);
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("AppKey", "1c33a135-5e89-34c1-baf9-ba0d453a29e8");
		return parserService.Parse(httpService.getData(url, map));
	}
	
	

}
