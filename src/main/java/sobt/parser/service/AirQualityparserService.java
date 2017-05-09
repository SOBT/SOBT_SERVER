package sobt.parser.service;

import com.google.gson.Gson;

import sobt.domain.weather.WeatherAirQualityCurrent;
import sobt.domain.weather.WeatherResponse;;

public class AirQualityparserService implements ParserService {

	@Override
	public String Parse(String json) {
		Gson gson = new Gson();
		WeatherResponse data = gson.fromJson(json, WeatherResponse.class);
		WeatherAirQualityCurrent info = data.getWeather().getAirQuality().getCurrent().get(0);

		String sentence = "�̼����� ���� : "+info.getPm10().getGrade() + "\n"
					   	  + "�̼����� �� : "+info.getPm10().getValue()+ "��/��\n"
					   	  + "�̼����� ���� : "+info.getPm25().getGrade() + "\n"
					   	  + "�̼����� �� : "+info.getPm25().getValue() + "��/��\n";
					   	  
		return sentence;
	}

}
