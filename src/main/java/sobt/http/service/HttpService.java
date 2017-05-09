package sobt.http.service;

import java.util.HashMap;

public interface HttpService {
	
	// Connect url and get response data
	public String getData(String url);
	
	// Connect url and get response data whit header by keyname and keyvalue
	public String getData(String url, HashMap<String, String> map);
}
