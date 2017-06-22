package sobt.domain.user;

public class UserSubway {
	private int seq;
	private String line_num;
	private String in_out;
	private String station_nm;
	private String user_id;
	
	public UserSubway() {
		
	}
	
	
	public UserSubway(String user_id) {
		this.user_id = user_id;
	}
	
	public UserSubway(String line_num, String in_out, String station_nm, String user_id) {
		this.line_num = line_num;
		this.in_out = in_out;
		this.station_nm = station_nm;
		this.user_id = user_id;
	}
	
	public int getSeq() {
		return seq;
	}
	
	public void setSeq(int seq) {
		this.seq = seq;
	}
	
	public String getLineNum() {
		return line_num;
	}
	
	public void setLineNum(String line_num) {
		this.line_num = line_num;
	}
	
	public String getInOut() {
		return in_out;
	}
	
	public void setInOut(String in_out) {
		this.in_out = in_out;
	}
	
	public String getStationNm() {
		return station_nm;
	}
	
	public void setStationNm(String station_nm) {
		this.station_nm = station_nm;
	}
	
	public String getUserId() {
		return user_id;
	}
	
	public void setUserId(String user_id) {
		this.user_id = user_id;
	}

}
