package sobt.http.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.message.BasicNameValuePair;

public class ApacheHttpService implements HttpService {
	
	private ApacheHttpTemplate appacheHttpTemplate;
	
	public void setApacheHttpTemplate(ApacheHttpTemplate appacheHttpTemplate ){
		this.appacheHttpTemplate = appacheHttpTemplate;
	}
	
	@Override
	public String doHttpGet(String url, final String... head){
		return this.appacheHttpTemplate.connectHttpTemplate(url, new TypeStrategy() {


			@Override
			public HttpUriRequest DoSomethingWithType(String url){
				HttpGet request = new HttpGet(url);
				for (int i = 0; i < head.length; i += 2) {
					request.setHeader(head[i], head[i + 1]);
				}
				return request;
			}
		});
	}

	@Override
	public String doHttpPostByUrlencoded(String url, Map<String, String> param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String doHttpPostByUrlencoded(String url, Map<String, String> Header, Map<String, String> param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String doHttpPostByJson(String url, Map<String, String> param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String doHttpPostByJson(String url, Map<String, String> Header, Map<String, String> param) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	@Override
	public String doHttpPost(String url, final Map<String, String> entitys, final String... head) {
		return this.appacheHttpTemplate.connectHttpTemplate(url, new TypeStrategy() {

			@Override
			public HttpUriRequest DoSomethingWithType(String url){

				HttpPost request = new HttpPost(url);

				for (int i = 0; i < head.length; i += 2) {
					System.out.println(head[i] + "  " + head[i+1]);
					request.addHeader(head[i], head[i + 1]);

				}

				List<NameValuePair> nameValuePairList = new ArrayList<NameValuePair>();
				Iterator<String> keys = entitys.keySet().iterator();

				while (keys.hasNext()) {
					String key = keys.next();
					nameValuePairList.add(new BasicNameValuePair(key, entitys.get(key)));
				}

				try {
					request.setEntity(new UrlEncodedFormEntity(nameValuePairList, "UTF-8"));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}

				return request;

			}
		});
	}
	*/
}
