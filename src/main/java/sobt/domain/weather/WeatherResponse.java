package sobt.domain.weather;

public class WeatherResponse {
	WeatherResult weather;
	ResponseResult result;
	ResponseError error;

	public WeatherResult getWeather() {
		return weather;
	}

	public ResponseResult getResult() {
		return result;
	}

	public ResponseError getError() {
		return error;
	}

}
