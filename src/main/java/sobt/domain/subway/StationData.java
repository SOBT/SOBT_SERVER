package sobt.domain.subway;

public class StationData {
	private String STATION_CODE;
	private String STATION_NM;
	private String LINE_NUM;
	private String FRCODE;
	
	public StationData() {
		
	}
	
	public StationData(String STATION_CODE, String STATION_NM, String LINE_NUM, String FRCODE) {
		this.STATION_CODE = STATION_CODE;
		this.STATION_NM = STATION_NM;
		this.LINE_NUM = LINE_NUM;
		this.FRCODE = FRCODE;
	}
	
	public String getStationCode() {
		return STATION_CODE;
	}
	
	public void setStationCode(String STATION_CODE) {
		this.STATION_CODE = STATION_CODE;
	}
	
	public String getStationNm() {
		return STATION_NM;
	}
	
	public void setStationNm(String STATION_NM) {
		this.STATION_NM = STATION_NM;
	}
	
	public String getLineNum() {
		return LINE_NUM;
	}
	
	public void setLineNum(String LINE_NUM) {
		this.LINE_NUM = LINE_NUM;
	}
	
	public String getFRCode() {
		return FRCODE;
	}
	
	public void setFRCode(String FRCODE) {
		this.FRCODE = FRCODE;
	}

}
