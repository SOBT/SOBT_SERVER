package sobt.chat.template;

public class ExpireSessionException extends RuntimeException {
	public ExpireSessionException(){
		super();
	}
	
	public ExpireSessionException(String message){
		super(message);
	}
}
