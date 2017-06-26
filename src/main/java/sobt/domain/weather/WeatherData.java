package sobt.domain.weather;

import java.sql.Date;

public class WeatherData {
	
	private String sentence;
	private String date;
	
	
	public WeatherData(){
		
	}
	
	public WeatherData(String sentence, String date){
		this.sentence = sentence;
		this.date = date;
	}
	public String getSentence() {
		return sentence;
	}
	public void setSentence(String sentence) {
		this.sentence = sentence;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	

}
