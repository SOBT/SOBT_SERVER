package sobt.domain.weather;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "rss")
public class WeatherAllPlaceData {
	WeatherAllPlaceDataChannel channel;

	@XmlElement( name = "channel" )
	public void setName(WeatherAllPlaceDataChannel channel )
	{
	this.channel = channel;
	}
	public WeatherAllPlaceDataChannel getChannel(){
		return channel;
	}


}
