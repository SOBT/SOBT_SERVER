package sobt.parser.service;

import com.google.gson.Gson;

import sobt.domain.weather.WeatherResponse;

public class UnmarshallJsonTemplate<T> {
	public T ReturnObjectTemplate(String json,T t){
		
		Gson gson = new Gson();
		T result = (T)gson.fromJson(json, t.getClass());
		
		return result;
	}
}
