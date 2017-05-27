package sobt.parser.service;

import com.google.gson.Gson;
import sobt.domain.subway.*; 

public class SearchFirstAndLastFRCodeParser implements ParserService{
	
	@Override
	public String Parse(String json) {
		//SearchFirstAndLastResponse response = (new UnmarshallJsonTemplate<SearchFirstAndLastResponse>()).ReturnObjectTemplate(json, new SearchFirstAndLastResponse());
		Gson gson = new Gson();
		SearchFirstAndLastResponse response = gson.fromJson(json, SearchFirstAndLastResponse.class);
		SearchFirstAndLastResult data = response.getSearchFirstAndLastTrainbyFRCodeService();
		SearchFirstAndLastInfo info = data.getRow().get(0);

		if(data.getResult().getCode().equals("INFO-000")) {
			String result;
			
			result = info.getLinenum() + " " + info.getInOutTag() + " " + info.getStationName() + "역"+ "\n"
					+ "첫차 : " + info.getFSubwaySName() + " -> " + info.getFSubwayEName() + " " + info.getFirstTime() + "\n"
					+ "막차 : " + info.getLSubwaySName() + " -> " + info.getLSubwayEName() + " " + info.getLastTime() + "\n";
			return result;
		}		

		return data.getResult().getMessage();
	}

}

