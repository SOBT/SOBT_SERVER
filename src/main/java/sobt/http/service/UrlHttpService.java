package sobt.http.service;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONObject;

public class UrlHttpService implements HttpService {
	
	private UrlHttpTemplate urlHttpTemplate;
	
	public void setUrlHttpTemplate(UrlHttpTemplate urlHttpTemplate){
		this.urlHttpTemplate = urlHttpTemplate;
	}


	@Override
	public String doHttpGet(String url, final String... head) {
		// TODO Auto-generated method stub
		return urlHttpTemplate.httpServiceTemplate(url, new UrlCallback(){

			@Override
			public HttpURLConnection doSomtingWithHttpService(HttpURLConnection con) throws IOException {
				// TODO Auto-generated method stub
				con.setRequestMethod("GET");
				for(int i = 0; i< head.length; i+=2)
				con.setRequestProperty(head[i], head[i+1]);
				return con;
			}});
	}


	@Override
	public String doHttpPostByUrlencoded(String url, final Map<String, String> param) {
		// TODO Auto-generated method stub
		return urlHttpTemplate.httpServiceTemplate(url, new UrlCallback(){

			@Override
			public HttpURLConnection doSomtingWithHttpService(HttpURLConnection con) throws IOException {
				// TODO Auto-generated method stub
				 return doPostRequest(con,makeParamByUrlEncoder(param));
			}});
	}


	@Override
	public String doHttpPostByUrlencoded(String url, final Map<String, String> header, final Map<String, String> param) {
		// TODO Auto-generated method stub
		
		return urlHttpTemplate.httpServiceTemplate(url, new UrlCallback(){

			@Override
			public HttpURLConnection doSomtingWithHttpService(HttpURLConnection con) throws IOException {
				// TODO Auto-generated method stub
				 Iterator<String> keyIterator = header.keySet().iterator();
				 String key = null;
				 while(keyIterator.hasNext()){
					 key = keyIterator.next();
					 con.setRequestProperty(key, header.get(key));
				 }
				 return doPostRequest(con,makeParamByUrlEncoder(param));
			}});
	}


	@Override
	public String doHttpPostByJson(String url, final Map<String, String> param) {
		// TODO Auto-generated method stub
		return urlHttpTemplate.httpServiceTemplate(url, new UrlCallback(){

			@Override
			public HttpURLConnection doSomtingWithHttpService(HttpURLConnection con) throws IOException {
				// TODO Auto-generated method stub
				con.setRequestProperty("Content-Type", "application/json");
				return doPostRequest(con,makeParamByJson(param));
			}});
	}


	@Override
	public String doHttpPostByJson(String url, final Map<String, String> header, final Map<String, String> param) {
		// TODO Auto-generated method stub
		return urlHttpTemplate.httpServiceTemplate(url, new UrlCallback(){

			@Override
			public HttpURLConnection doSomtingWithHttpService(HttpURLConnection con) throws IOException {
				// TODO Auto-generated method stub
				 con.setRequestProperty("Content-Type", "application/json");
				 Iterator<String> keyIterator = header.keySet().iterator();
				 String key = null;
				 while(keyIterator.hasNext()){
					 key = keyIterator.next();
					 con.setRequestProperty(key, header.get(key));
				 }
				 return doPostRequest(con,makeParamByJson(param));
			}});
	}
	
	
	private HttpURLConnection doPostRequest(HttpURLConnection con , String param) throws IOException{
		con.setRequestMethod("POST");
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(param);
        wr.flush();
        wr.close();
		return con;
	}
	private String makeParamByUrlEncoder(Map<String,String> param){
		try{
			String resultParam = null;
			Iterator<String> keyIterator = param.keySet().iterator();
			String key = keyIterator.next();
			resultParam = key + "=" + URLEncoder.encode(param.get(key),"UTF-8");
			
			while(keyIterator.hasNext()){
				key = keyIterator.next();
				resultParam+= "&" + key + "=" + URLEncoder.encode(param.get(key),"UTF-8");
			}
			return resultParam;
		}catch(IOException e){
			throw new RuntimeException(e);
		}
		
	}
	
	private String makeParamByJson(Map<String,String> param){
		try{
			String resultParam = null;
			Iterator<String> keyIterator = param.keySet().iterator();
			String key = null;
			JSONObject obj = new JSONObject();
			while(keyIterator.hasNext()){
				key = keyIterator.next();
				obj.put(key, URLEncoder.encode(param.get(key),"UTF-8"));
			}
			return obj.toJSONString();
		}catch(IOException e){
			throw new RuntimeException(e);
		}
		
	}


}
