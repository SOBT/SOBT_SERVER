package sobt.api.manage;

public interface SubwayAPIManager {
	public String getRealTimeArrival(String type, String statnNm);
	
	public String getFirstAndLast(String type, int LINE_NUM, int WEEK_TAG, int INOUT_TAG, String FR_CODE);

}
