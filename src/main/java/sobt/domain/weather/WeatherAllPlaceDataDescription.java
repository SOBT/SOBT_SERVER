package sobt.domain.weather;

import javax.xml.bind.annotation.XmlElement;

public class WeatherAllPlaceDataDescription {
	WeatherAllPlaceDataBody body;

	@XmlElement( name = "body" )
	public void setDescription(WeatherAllPlaceDataBody body){
		this.body = body;
	}
	
	public WeatherAllPlaceDataBody getBody(){
		return body;
	}
}
