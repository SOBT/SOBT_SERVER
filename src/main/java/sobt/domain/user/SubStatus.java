package sobt.domain.user;

public enum SubStatus {
	NORMAL(0),EN_TO_KO(4), KO_TO_EN(1), KO_TO_JA(2), KO_TO_CN(3)
	,JA_TO_KO(5),CN_TO_KO(6), 
	SELECT_SUB_SERVICE(10), RT_RESULT(12),
	FL_SUB_LINE(13), FL_SUB_NAME(14), FL_SUB_INOUT(15);
	private int subStatus;
	
	SubStatus(int subStatus){
		this.subStatus = subStatus;
	}
	
	public int initValue(){
		return this.subStatus;
	}
	
	public static SubStatus valueOf(int value){
		switch(value){
			case 1 :
				return KO_TO_EN;
			case 2 :
				return KO_TO_JA;
			case 3 :	
				return KO_TO_CN;
			case 4 :
				return EN_TO_KO;
			case 5 :	
				return JA_TO_KO;
			case 6 :
				return CN_TO_KO;
			case 10 :
				return SELECT_SUB_SERVICE;
			case 13 :
				return FL_SUB_LINE;
			case 14 :
				return FL_SUB_NAME;
			case 15 :
				return FL_SUB_INOUT;			
			case 0 :
				return NORMAL;
			default : 
				throw new AssertionError("Unknown value: " + value);
		
		}
		
	}
}
