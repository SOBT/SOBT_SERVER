package sobt.parser.service;

import com.google.gson.Gson;

import sobt.domain.weather.WeatherInfo;
import sobt.domain.weather.WeatherResponse;

public class WeatherParserService implements ParserService{

	@Override
	public String Parse(String json) {
		Gson gson = new Gson();
		WeatherResponse data = gson.fromJson(json, WeatherResponse.class);
		WeatherInfo info = data.getWeather().getMinutely().get(0);
		if(data.getError()!= null){
			return data.getError().getMessage();
		}
		
		String sentence = info.getStation().getName() + "�� ����\n"
						  + "�ϴ� : "+info.getSky().getName() + "\n"
					   	  + "���� ��� : "+info.getTemperature().getTc()+ "\n"
					   	  + "�ְ� ��� : "+info.getTemperature().getTmax()+ "\n"
					   	  + "���� ��� : "+info.getTemperature().getTmin()+ "\n";
		return sentence;
	}

}
