package sobt.api.manage;

import java.io.UnsupportedEncodingException;

public interface SubwayAPIManager {
	public String getRealTimeArrival(String type, String statnNm) throws UnsupportedEncodingException;
	
	public String getFirstAndLast(String type, String LINE_NUM, int WEEK_TAG, int INOUT_TAG, String stationName);

}
