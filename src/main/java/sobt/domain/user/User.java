package sobt.domain.user;

public class User {
	private String userId;
	private Status status;
	private SubStatus subStatus;
	
	public Status getStatus() {
		return status;
	}
	public SubStatus getSubStatus() {
		return subStatus;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public void setSubStatus(SubStatus subStatus) {
		this.subStatus = subStatus;
	}
	public User(){
		
	}
	public User(String userId){
		this.userId = userId;
	}
	
	public void setUserId(String userId){
		this.userId = userId;
	}
	public String getUserId() {
		return userId;
	}
	
	public void setDefaultStatus(){
		this.status = Status.NORMAL;
		this.subStatus = SubStatus.NORMAL;
	}

}
