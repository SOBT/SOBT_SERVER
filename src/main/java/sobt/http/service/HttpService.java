package sobt.http.service;

import java.util.HashMap;


public interface HttpService {
	
	
	public String DoHttpPost(String url, final HashMap<String, String> entitys, final String ...head);
	public String DoHttpGet(String url, final String ...head);
	
}
