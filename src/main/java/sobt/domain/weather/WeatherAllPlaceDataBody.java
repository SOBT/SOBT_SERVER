package sobt.domain.weather;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class WeatherAllPlaceDataBody {
	List<WeatherAllPlaceDataLocation> location;
	
	@XmlElement( name = "location" )
	public List<WeatherAllPlaceDataLocation> getLocation() {
		return location;
	}

	public void setLocation(List<WeatherAllPlaceDataLocation> location) {
		this.location = location;
	}


	


	
}
