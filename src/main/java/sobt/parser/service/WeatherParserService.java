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
		
		String sentence = info.getStation().getName() + "의 날씨\n"
						  + "하늘 : "+info.getSky().getName() + "\n"
					   	  + "현재 기온 : "+info.getTemperature().getTc()+ "\n"
					   	  + "최고 기온 : "+info.getTemperature().getTmax()+ "\n"
					   	  + "최저 기온 : "+info.getTemperature().getTmin()+ "\n";
		return sentence;
	}

}
