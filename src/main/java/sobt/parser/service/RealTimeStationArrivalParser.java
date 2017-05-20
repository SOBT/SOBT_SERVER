package sobt.parser.service;

import com.google.gson.Gson;
import sobt.domain.subway.*;
// RealTimeStationArrivalResponse, RealTimeStationArrivalInfo

public class RealTimeStationArrivalParser implements ParserService{
	
	@Override
	public String Parse(String json) {
		Gson gson = new Gson();
		RealTimeStationArrivalResponse response = gson.fromJson(json, RealTimeStationArrivalResponse.class);
		int count=response.getRealtimeArrivalList().size();
		RealTimeStationArrivalInfo info;
		
		if(response.getErrorMessage().getCode().equals("INFO-000")) {
			System.out.println(json);
			for(int i=0;i<count;i++)
			{
				info = response.getRealtimeArrivalList().get(i);
				System.out.println(info.getBarvlDt());
				// 필요한 정보 string형태로 변환후 return
			}
			return json;
		}		
		return response.getErrorMessage().getMessage();
	}

}
