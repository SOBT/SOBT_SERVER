package sobt.http.service;

import java.io.IOException;
import java.util.HashMap;


public interface HttpService {
	
	
	public String doHttpPost(String url, final HashMap<String, String> entitys, final String ...head);
	public String doHttpGet(String url, final String ...head);
	public String doHttpRequest(String url , TypeStrategy strategy);
	
}
