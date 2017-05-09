package sobt.http.service;

import java.util.HashMap;

public interface HttpService {
	
	// Connect url and get response data
	public String getData(String url);
	
	// Connect url and get response data if u need adding header 
	public String getData(String url, HashMap<String, String> map);
}
