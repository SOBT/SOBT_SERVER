package sobt.domain.user;

public class UserData {
	private int seq;
	private String userId;
	private String type;
	private String userContent;
	private String rgDt;
	
	public UserData(){
		
	}
	
	public UserData(String userId, String userText, String type){
		this.userId = userId;
		this.userContent = userText;
		this.type = type;
	}
	
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
	public String getUserContent() {
		return userContent;
	}
	public void setUserContent(String userText) {
		this.userContent = userText;
	}
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRgDt() {
		return rgDt;
	}
	public void setRgDt(String rgDt) {
		this.rgDt = rgDt;
	}
	

}
