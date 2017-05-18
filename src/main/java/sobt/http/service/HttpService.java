package sobt.http.service;

import java.util.List;

import org.apache.http.NameValuePair;

public interface HttpService {
	
	
	public String DoHttpPost(String url,final List<NameValuePair> urlParameters, final String ...head);
	public String DoHttpGet(String url, final String ...head);
	
}
