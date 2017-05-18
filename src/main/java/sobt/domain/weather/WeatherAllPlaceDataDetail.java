package sobt.domain.weather;

import javax.xml.bind.annotation.XmlElement;

public class WeatherAllPlaceDataDetail {
	
	// WeatherInfo mode A01 = Yesterday A02 = AM, PM
	String mode;
	
	// When is the forecast
	String tmEf;
	
	//Weather foreCast
	String  wf;
	
	//Max temperature
	String tmn;

	//MIN temperature
	String tmx;
	
	//forecast how reliability
	String reliability;

	public String getMode() {
		return mode;
	}
	
	@XmlElement( name = "mode" )
	public void setMode(String mode) {
		this.mode = mode;
	}

	
	public String getTmEf() {
		return tmEf;
	}

	@XmlElement( name = "tmEf" )
	public void setTmEf(String tmEf) {
		this.tmEf = tmEf;
	}

	public String getWf() {
		return wf;
	}
	
	@XmlElement( name = "wf" )
	public void setWf(String wf) {
		this.wf = wf;
	}

	public String getTmn() {
		return tmn;
	}
	
	@XmlElement( name = "tmn" )
	public void setTmn(String tmn) {
		this.tmn = tmn;
	}

	public String getTmx() {
		return tmx;
	}
	
	@XmlElement( name = "tmx" )
	public void setTmx(String tmx) {
		this.tmx = tmx;
	}

	public String getReliability() {
		return reliability;
	}
	
	@XmlElement( name = "reliability" )
	public void setReliability(String reliability) {
		this.reliability = reliability;
	}
	
	
}
