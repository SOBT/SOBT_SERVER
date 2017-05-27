package sobt.domain.subway;

public class SearchFirstAndLastInfo {
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
		
		private String changeLineNum(String lineNum) {
			String line;
			if(lineNum.equals("1")) line="1호선";
			else if(lineNum.equals("2")) line="2호선";
			else if(lineNum.equals("3")) line="3호선";
			else if(lineNum.equals("4")) line="4호선";
			else if(lineNum.equals("5")) line="5호선";
			else if(lineNum.equals("6")) line="6호선";
			else if(lineNum.equals("7")) line="7호선";
			else if(lineNum.equals("8")) line="8호선";
			else if(lineNum.equals("9")) line="9호선";
			else if(lineNum.equals("I")) line="인천1호선";
			else if(lineNum.equals("K")) line="경의선";
			else if(lineNum.equals("B")) line="분당선";
			else if(lineNum.equals("J")) line="중앙선";
			else if(lineNum.equals("A")) line="공항철도";
			else if(lineNum.equals("G")) line="경춘선";
			else if(lineNum.equals("S")) line="신분당선";
			else if(lineNum.equals("SU")) line="수인선";
			else line="error";
			return line;
		}
		
		private String changeWeekTag(String weekTag) {
			String week;
			switch(Integer.parseInt(weekTag)) {
			case 1: week="평일"; break;
			case 2: week="토요일"; break;
			case 3: week="휴일, 일요일"; break;
			default: week ="error"; break;
			}
			return week;
		}
		
		private String changeInOutTag(String inoutTag) {
			String inout;

			if(inoutTag.equals("1")) inout="상행, 내선";
			else inout="하행, 외선";
			
			return inout;
			
		}
		public String getWeekTag() {
			return changeWeekTag(WEEK_TAG);
		}
		
		public String getFirstTime() {
			return FIRST_TIME;
		}
		
		public String getLastTime() {
			return LAST_TIME;
		}
		
		
		public String getInOutTag() {
			return changeInOutTag(INOUT_TAG);
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
			return changeLineNum(LINE_NUM);
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
