package sobt.domain.weather;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class WeatherAllPlaceDataLocation {
	String city;
	List<WeatherAllPlaceDataDetail> data;
	
	public WeatherAllPlaceDataLocation(){
	}	
	
	public WeatherAllPlaceDataLocation(String city){
		this.city = city;
	}
	
	
	public String getCity() {
		return city;
	}

	@XmlElement(name = "city")
	public void setCity(String city) {
		this.city = city;
	}

	public List<WeatherAllPlaceDataDetail> getData() {
		return data;
	}

	@XmlElement(name = "data")
	public void setData(List<WeatherAllPlaceDataDetail> data) {
		this.data = data;
	}
	
	
}
