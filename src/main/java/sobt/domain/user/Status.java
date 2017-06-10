package sobt.domain.user;


public enum Status {
	NORMAL(0),WEATHER(1),SUBWAY(2),TRANSLATE(3);
	private int status;
	Status(int status){
		this.status = status;
	}
	
	public int intValue(){
		return status;
	}
	
	public static Status valueOf(int value){
		switch(value){
			case 0 : return NORMAL;
			case 1 : return WEATHER;
			case 2 : return SUBWAY;
			case 3 : return TRANSLATE;
			default :
				throw new AssertionError("Unknown value: " + value);
		}
	}
	public static Status valueOfString(String value){
		if(value.equals("날씨 정보")){
			return WEATHER;
		}else if(value.equals("지하철 정보")){
			return SUBWAY;
		} else if(value.equals("문장번역")){
			return TRANSLATE;
		}else{
			throw new AssertionError("Unknown value: " + value);
		}
	}
}
