package sobt.domain.subway;

import java.util.List;

public class RealTimeStationArrivalResponse {
	ResponseResult errorMessage;
	List <RealTimeStationArrivalInfo> realtimeArrivalList; 
	
	public ResponseResult getErrorMessage() {
		return errorMessage;
	}
	
	public List<RealTimeStationArrivalInfo> getRealtimeArrivalList() {
		return realtimeArrivalList;
	}

}
