package sobt.domain.subway;

public class SearchFirstAndLastInfo {
//SERVICE=SearchFirstAndLastTrainbyFRCodeService
	/* ??
	InfoDate date;
	InfoStation station;
	InfoSubway subway;
	
	public InfoDate getDate() {
		return date;
	}
	
	public InfoStation getStation() {
		return station;
	}
	
	public InfoSubway getSubway() {
		return subway;
	}
	*/
	String WEEK_TAG; // 요일 (평일 : 1 / 토요일 : 2 / 휴일,일요일 : 3) 
	//server에서 받기
	String FIRST_TIME; // first start time
	String LAST_TIME; // last start time
	
	String INOUT_TAG; // 상/하행선 (상행,내선:1, 하행,외선:2)
	String F_SUBWAYSNAME; // first start station name;
	String F_SUBWAYENAME; // first end station name
	String L_SUBWAYSNAME; // last start station name
	String L_SUBWAYENAME; // last end station name
	
	String LINE_NUM; // 호선(1~9: 1~9호선, 
	//I: 인천1호선, K: 경의선, B: 분당선, J: 중앙선, A: 공항철도, G: 경춘선, S:신분당선, SU:수인선)
	String FR_CODE; // 지하철에 역 이름과 함께 적혀있는 코드
	String STATION_NM; // Station name
	String STATION_CD; // Station code 
	
	
	public String getWeekTag() {
		return WEEK_TAG;
	}
	
	public String getFirstTime() {
		return FIRST_TIME;
	}
	
	public String getLastTime() {
		return LAST_TIME;
	}
	
	
	public String getInOutTag() {
		return INOUT_TAG;
	}
	
	public String getFSubwaySName() {
		return F_SUBWAYSNAME;
	}
	
	public String getFSubwayEName() {
		return F_SUBWAYENAME;
	}
	
	public String getLSubwaySName() {
		return L_SUBWAYSNAME;
	}
	
	public String getLSubwayEName() {
		return L_SUBWAYENAME;
	}
	
	public String getLinenum() {
		return LINE_NUM;
	}
	
	public String getFRcode() {
		return FR_CODE;
	}
	
	public String getStationName() {
		return STATION_NM;
	}
	
	public String getStationCode() {
		return STATION_CD;
	}


}
