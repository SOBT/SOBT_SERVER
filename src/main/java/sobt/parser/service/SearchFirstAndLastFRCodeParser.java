package sobt.parser.service;

import com.google.gson.Gson;
import sobt.domain.subway.*; 
//SearchFirstAndLastResponse, SearchFirstAndLastResult, SearchFirstAndLastInfo

//SERVICE=SearchFirstAndLastTrainbyFRCodeService
public class SearchFirstAndLastFRCodeParser implements ParserService{
	
	@Override
	public String Parse(String json) {
		Gson gson = new Gson();
		SearchFirstAndLastResponse response = gson.fromJson(json, SearchFirstAndLastResponse.class);
		SearchFirstAndLastResult data = response.getSearchFirstAndLastTrainbyFRCodeService();
		SearchFirstAndLastInfo info = data.getRow().get(0);
		int count=data.getListTotalCount();
		if(count == 0) {
			return data.getResult().getMessage();
		}
		System.out.println(json);
		System.out.println(data.getListTotalCount());
		System.out.println(data.getResult().getMessage());
		
		System.out.println(info.getStationName()); //필요한 정보 추출
		//return data.getRow().get(0).getStation().getStationName();
		return json;// 필요한 정보 string형태로 변환후 return
	}

}

