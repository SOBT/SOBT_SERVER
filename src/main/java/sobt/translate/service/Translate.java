package sobt.translate.service;

public enum Translate {
	EN_TO_KO("en","ko",4), KO_TO_EN("ko","en",1), KO_TO_JA("ko","ja",2), KO_TO_CN("ko","zh-CN",3)
	,JA_TO_KO("ja","ko",5),CN_TO_KO("zh-CN","ko",6);
	
	public String getSource() {
		return source;
	}

	public String getTarget() {
		return target;
	}

	private final String source;
	private final String target;
	private final int value;
	
	Translate(String source , String target, int value){
		this.source = source;
		this.target = target;
		this.value = value;
	}
	
	public Translate valueOf(int value){
		switch(value){
		case 1 : return KO_TO_EN;
		case 2 : return KO_TO_JA;
		case 3 : return KO_TO_CN;
		case 4 : return EN_TO_KO;
		case 5 : return JA_TO_KO;
		case 6 : return CN_TO_KO;
		default :
			throw new AssertionError("Unknown value: " + value);
	}
	}

}
