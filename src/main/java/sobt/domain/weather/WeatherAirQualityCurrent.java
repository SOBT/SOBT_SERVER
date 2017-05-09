package sobt.domain.weather;

public class WeatherAirQualityCurrent {
	WeatherInfoStation station;
	WeatherInfoPm10 pm10;
	WeatherInfoPm25 pm25;
	public WeatherInfoStation getStation() {
		return station;
	}
	public WeatherInfoPm10 getPm10() {
		return pm10;
	}
	public WeatherInfoPm25 getPm25() {
		return pm25;
	}
	
	
}
