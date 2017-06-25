package sobt.dao.weather;

import java.sql.Date;
import java.util.List;

import sobt.domain.weather.WeatherData;

public interface WeatherDataDao {
	public void addWeather(WeatherData sentence);
	public WeatherData getWeather(String string);
	
	
}
