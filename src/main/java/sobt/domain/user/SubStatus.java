package sobt.domain.user;

public enum SubStatus {
	NORMAL(0),EN_TO_KO(4), KO_TO_EN(1), KO_TO_JA(2), KO_TO_CN(3)
	,JA_TO_KO(5),CN_TO_KO(6), FL_SUB(7), RT_SUB(8);
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
			case 7 :
				return FL_SUB;
			case 8 :
				return RT_SUB;
			case 0 :
				return NORMAL;
			default : 
				throw new AssertionError("Unknown value: " + value);
		
		}
		
	}
}
