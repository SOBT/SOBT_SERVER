package sobt.domain.weather;

import java.util.List;

public class WeatherResult {
	List<WeatherInfo> minutely;
	WeatherAirQuality airQuality;

	public List<WeatherInfo> getMinutely() {
		return minutely;
	}

	public WeatherAirQuality getAirQuality() {
		return airQuality;
	}
	
	
}
