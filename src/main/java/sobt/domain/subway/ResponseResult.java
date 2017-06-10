package sobt.domain.subway;

public class ResponseResult {
	String CODE;
	String MESSAGE;
	String code; // 확인
	String message; //
	String status; //
	
	public String getStatus() {
		return status;
	}
	
	public String getCode() {
		return (getStatus()==null)? CODE: code;
		//return CODE;
	}
	
	public String getMessage() {
		return (getStatus()==null)? MESSAGE: message;
		//return MESSAGE;
	}
}
