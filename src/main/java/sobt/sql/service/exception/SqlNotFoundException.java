package sobt.sql.service.exception;

public class SqlNotFoundException extends RuntimeException {
	public SqlNotFoundException(){
		
	}
	
	public SqlNotFoundException(String message){
		super(message);
	}

	public SqlNotFoundException(SqlNotFoundException e) {
		// TODO Auto-generated constructor stub
		super(e);
	}

}
