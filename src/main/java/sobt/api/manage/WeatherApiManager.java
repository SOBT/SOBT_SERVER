package sobt.api.manage;

public interface WeatherApiManager {

	//get Weather Info by Minute
	public String getWeatherMin(String city, String county, String village);
	//get Weather Info by lat, lon and include misaemunge
	public String getWeatherLoc(double lat, double lon);
}
