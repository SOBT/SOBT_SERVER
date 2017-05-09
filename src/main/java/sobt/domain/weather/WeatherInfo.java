package sobt.domain.weather;

public class WeatherInfo {
	WeatherInfoStation station;
	WeatherInfoSky sky;
	WeatherInfoTemperature temperature;
	public WeatherInfoStation getStation() {
		return station;
	}
	public WeatherInfoSky getSky() {
		return sky;
	}
	public WeatherInfoTemperature getTemperature() {
		return temperature;
	}
	
	
}
