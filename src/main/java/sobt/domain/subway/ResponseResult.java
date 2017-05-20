package sobt.domain.subway;

public class ResponseResult {
	String CODE;
	String MESSAGE;
	String code; // 확인
	String message; //
	int status; //
	
	public int getStatus() {
		return status;
	}
	
	public String getCode() {
		return (getStatus()==0)? CODE: code;
		//return CODE;
	}
	
	public String getMessage() {
		return (getStatus()==0)? MESSAGE: message;
		//return MESSAGE;
	}
}
