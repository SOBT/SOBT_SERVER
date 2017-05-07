package sobt.domain.user;

public class User {
	private int seq;
	private String userId;
	private String userText;
	private String rgDt;
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserText() {
		return userText;
	}
	public void setUserText(String userText) {
		this.userText = userText;
	}
	public String getRgDt() {
		return rgDt;
	}
	public void setRgDt(String rgDt) {
		this.rgDt = rgDt;
	}
}
