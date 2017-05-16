package sobt.domain.subway;

public class RealTimeStationArrivalInfo {
// SERVICE=realtimeStationArrival
	String subwayId; // 호선
	String updnLine; //상하행선
	String statnNm; // Station name
	String bstatnNm; //종착지
	String barvlDt; //도착예정시간(sec)
	String arvlMsg3; //현재도착위치
	String arvlCd; //도착코드(0:진입, 1:도착, 2:출발, 3:전역출발, 4:전역진입, 5:전역도착, 99:운행중)
	
	public String getSubwayId() {
		return subwayId;
	}
	
	public String getUpdnLine() {
		return updnLine;
	}
	
	public String getStatnNm() {
		return statnNm;
	}
	
	public String getBstatnNm() {
		return bstatnNm;
	}
	
	public String getBarvlDt() {
		return barvlDt;
	}
	
	public String getArvlMsg3() {
		return arvlMsg3;
	}
	
	public String getArvlCd() {
		return arvlCd;
	}
}
