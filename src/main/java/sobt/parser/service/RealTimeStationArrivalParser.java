package sobt.parser.service;

import com.google.gson.Gson;
import sobt.domain.subway.*;
import java.util.List;

public class RealTimeStationArrivalParser implements ParserService{
	
	@Override
	public String Parse(String json) {
		//RealTimeStationArrivalResponse response = (new UnmarshallJsonTemplate<RealTimeStationArrivalResponse>()).ReturnObjectTemplate(json, new RealTimeStationArrivalResponse());
		Gson gson = new Gson();
		RealTimeStationArrivalResponse response = gson.fromJson(json, RealTimeStationArrivalResponse.class);
		List <RealTimeStationArrivalInfo> info=response.getRealtimeArrivalList();
		
		if(response.getErrorMessage().getCode().equals("INFO-000")) {
			String result;
			result = info.get(0).getStatnNm()+"역\n";
			
			for(int i=0;i<info.size();i++)
			{
				result += info.get(i).getSubwayId() + " " + info.get(i).getBstatnNm() + "행 " + info.get(i).getArvlCd() +"("+info.get(i).getArvlMsg3() + ")\n";
			}
			
			return result;
		}		
		return response.getErrorMessage().getMessage();
	}

}
