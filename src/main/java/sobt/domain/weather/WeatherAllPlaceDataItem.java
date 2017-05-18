package sobt.domain.weather;

import javax.xml.bind.annotation.XmlElement;

public class WeatherAllPlaceDataItem {
	WeatherAllPlaceDataDescription description;

	@XmlElement( name = "description" )
	public void setDescription(WeatherAllPlaceDataDescription description){
		this.description = description;
	}
	
	public WeatherAllPlaceDataDescription getDescription(){
		return description;
	}
}
