package sobt.parser.service;

import com.google.gson.Gson;
import sobt.domain.subway.*; 

public class SearchFirstAndLastFRCodeParser implements ParserService{
	
	@Override
	public String Parse(String json) {
		//SearchFirstAndLastResponse response = (new UnmarshallJsonTemplate<SearchFirstAndLastResponse>()).ReturnObjectTemplate(json, new SearchFirstAndLastResponse());
		Gson gson = new Gson();
		if(json.contains("SearchFirstAndLastTrainbyFRCodeService")) {
			SearchFirstAndLastResponse response = gson.fromJson(json, SearchFirstAndLastResponse.class);
			SearchFirstAndLastResult data = response.getSearchFirstAndLastTrainbyFRCodeService();
			SearchFirstAndLastInfo info = data.getRow().get(0);
			String result;
			System.out.println(data.getResult().getMessage());
			result = info.getLinenum() + " " + info.getInOutTag() + " " + info.getStationName() + "역"+ "\n"
					+ "첫차 : " + info.getFSubwaySName() + " -> " + info.getFSubwayEName() + " " + info.getFirstTime() + "\n"
					+ "막차 : " + info.getLSubwaySName() + " -> " + info.getLSubwayEName() + " " + info.getLastTime() + "\n";
			return result;
		}
		else {
			SearchFirstAndLastErrorResponse error = gson.fromJson(json, SearchFirstAndLastErrorResponse.class);
			return error.getResult().getMessage();
		}
	}
}

