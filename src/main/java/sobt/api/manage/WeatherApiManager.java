package sobt.api.manage;

public interface WeatherApiManager {

	//get Weather Info by Minute
	public String getWeatherMin(String city, String county, String village);
	
	public String getWeatherAll();
}
