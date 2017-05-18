package sobt.parser.service;

import com.google.gson.Gson;

import sobt.domain.weather.WeatherInfo;
import sobt.domain.weather.WeatherResponse;

public class WeatherLocationParser implements ParserService{

	@Override
	public String Parse(String json) {
		
		WeatherResponse data = (new UnmarshallJsonTemplate<WeatherResponse>()).ReturnObjectTemplate(json, new WeatherResponse());
		
		WeatherInfo info = data.getWeather().getMinutely().get(0);
		if(data.getError()!= null){
			return data.getError().getMessage();
		}
		
		String sentence = info.getStation().getName() + "의 날씨 (구름)\n"
						  + "현재 날씨 → "+info.getSky().getName() + "\n"
					   	  + "현재 기온 → "+info.getTemperature().getTc()+ "\n"
					   	  + "최고 기온 → "+info.getTemperature().getTmax()+ "\n"
					   	  + "최저 기온 → "+info.getTemperature().getTmin()+ "\n";
		return sentence;
	}

}
