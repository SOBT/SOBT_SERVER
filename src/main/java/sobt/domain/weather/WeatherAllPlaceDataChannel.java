package sobt.domain.weather;

import javax.xml.bind.annotation.XmlElement;

public class WeatherAllPlaceDataChannel {
	WeatherAllPlaceDataItem title;

	@XmlElement( name = "item" )
	public void setName(WeatherAllPlaceDataItem title)
	{
	this.title = title;
	}
	
	public WeatherAllPlaceDataItem getName(){
		return title;
	}

}
