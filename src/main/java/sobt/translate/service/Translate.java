package sobt.translate.service;

public enum Translate {
	EN_TO_KO("en","ko"), KO_TO_EN("ko","en"), KO_TO_JA("ko","ja"), KO_TO_CN("ko","zh-CN")
	,JA_TO_KO("ja","ko"),CN_TO_KO("zh-CN","ko");
	
	public String getSource() {
		return source;
	}

	public String getTarget() {
		return target;
	}

	private final String source;
	private final String target;
	
	Translate(String source , String target){
		this.source = source;
		this.target = target;
	}

}
