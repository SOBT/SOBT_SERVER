package sobt.parser.service;

import java.util.ArrayList;
import java.util.List;

import sobt.domain.message.MessageVo;
import sobt.domain.weather.WeatherAllPlaceData;
import sobt.domain.weather.WeatherAllPlaceDataLocation;

public class WeatherAllPlaceParser implements ParserService {

	@Override
	public String Parse(String response) {
		WeatherAllPlaceData data = (new UnmarshallXmlTemplate<WeatherAllPlaceData>()).ReturnObjectTemplate(response,
				new WeatherAllPlaceData());
		
		List<WeatherAllPlaceDataLocation> original = data.getChannel().getName().getDescription().getBody().getLocation();
		
		List<WeatherAllPlaceDataLocation> need = new ArrayList<WeatherAllPlaceDataLocation>();

		need.add(new WeatherAllPlaceDataLocation("서울"));
		need.add(new WeatherAllPlaceDataLocation("인천"));
		need.add(new WeatherAllPlaceDataLocation("춘천"));
		need.add(new WeatherAllPlaceDataLocation("강릉"));
		need.add(new WeatherAllPlaceDataLocation("청주"));
		need.add(new WeatherAllPlaceDataLocation("대전"));
		need.add(new WeatherAllPlaceDataLocation("전주"));
		need.add(new WeatherAllPlaceDataLocation("광주"));
		need.add(new WeatherAllPlaceDataLocation("대구"));
		need.add(new WeatherAllPlaceDataLocation("부산"));
		need.add(new WeatherAllPlaceDataLocation("울산"));
		need.add(new WeatherAllPlaceDataLocation("제주"));

		int i = 0;
		int j = 0;
		int nSize = need.size();
		int oSize = original.size();
		while ( i < nSize && j < oSize) {
			if (original.get(j).getCity().equals(need.get(i).getCity())) {
				need.get(i++).setData(original.get(j).getData());
			}
			j++;

		}
		i=0;
		String sentence = null;
		
		sentence = need.get(i).getCity() + " "
				+ TranseEmoticon(need.get(i).getData().get(0).getWf()) +"→"
				+ TranseEmoticon(need.get(i).getData().get(1).getWf()) +" "	
				+ need.get(i).getData().get(0).getTmn()+"℃ → "
				+ need.get(i++).getData().get(0).getTmx()+"℃\n";
		
		while(i < nSize){
			
			sentence += need.get(i).getCity() + " "
					+ TranseEmoticon(need.get(i).getData().get(0).getWf()) +"→"
					+ TranseEmoticon(need.get(i).getData().get(1).getWf()) +" "	
					+ need.get(i).getData().get(0).getTmn()+"℃ → "
					+ need.get(i++).getData().get(0).getTmx()+"℃\n";
		
		}
		
		return sentence;
	}
	
	private String TranseEmoticon(String value){
		if(value.equals("맑음")){
			return "(해)";
		}else if(value.contains("비")){
			return "(비)";
		}else if(value.contains("눈")){
			return "(눈)";
		}else{
			return "(구름)";
		}
		
	}
}
