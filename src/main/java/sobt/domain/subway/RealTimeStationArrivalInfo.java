package sobt.domain.subway;

public class RealTimeStationArrivalInfo {
	String subwayId; // 호선
	String updnLine; //상하행선
	String statnNm; // Station name
	String bstatnNm; //종착지
	String barvlDt; //도착예정시간(sec)
	String arvlMsg3; //현재도착위치
	String arvlCd; //도착코드(0:진입, 1:도착, 2:출발, 3:전역출발, 4:전역진입, 5:전역도착, 99:운행중)
	
	private String changeSubwayId(String subwayId) {
		String line;
		switch(Integer.parseInt(subwayId)) {
		case 1001: line="1호선"; break;
		case 1002: line="2호선"; break;
		case 1003: line="3호선"; break;
		case 1004: line="4호선"; break;
		case 1005: line="5호선"; break;
		case 1006: line="6호선"; break;
		case 1007: line="7호선"; break;
		case 1008: line="8호선"; break;
		case 1009: line="9호선"; break;
		case 1063: line = "경의중앙선"; break;
		case 1075: line = "분당선"; break;
		case 1077: line = "신분당선"; break;
		case 1065: line = "공항철도"; break;
		case 1067: line = "경춘선"; break;
		default : line = "error"; break;
		}
		return line;
	}
	
	private String changeArvlCd(String arvlCd) {
		String move;
		switch(Integer.parseInt(arvlCd)) {
		case 0: move="진입"; break;
		case 1: move="도착"; break;
		case 2: move="출발"; break;
		case 3: move="전역출발"; break;
		case 4: move="전역진입"; break;
		case 5: move="전역도착"; break;
		case 99: move="운행중"; break;
		default: move="error"; break;
		}
		return move;
	}

	
	public String getSubwayId() {
		return changeSubwayId(subwayId);
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
		return changeArvlCd(arvlCd);
	}
	
}

