package sobt.http.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public interface HttpService {
	
	
	//public String doHttpPost(String url, final Map<String, String> entitys, final String ...head);
	public String doHttpGet(String url, final String ...head);
	public String doHttpPostByUrlencoded(String url , final Map<String, String> param);
	public String doHttpPostByUrlencoded(String url , final Map<String, String> Header , final Map<String, String> param);
	public String doHttpPostByJson(String url , final Map<String, String> param);
	public String doHttpPostByJson(String url , final Map<String, String> Header,final Map<String, String> param);
	
}
