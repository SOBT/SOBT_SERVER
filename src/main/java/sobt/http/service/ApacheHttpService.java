package sobt.http.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

public class ApacheHttpService implements HttpService{

	@Override
	public String getData(String url) {
		return this.getData(url, null);
	}

	@Override
	public String getData(String url, HashMap<String, String> map) {
		HttpClient mClient = new DefaultHttpClient();
		try {
			HttpGet get = new HttpGet(url);
			ResponseHandler<String> rh = new BasicResponseHandler();
			Set<Entry<String, String>>set = map.entrySet();
			Iterator<Entry<String, String>>it = set.iterator();
			
			while(it.hasNext()){
				Map.Entry<String, String> e = (Map.Entry<String, String>)it.next();
				get.addHeader(e.getKey(), e.getValue());
			}
			return mClient.execute(get, rh);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			mClient.getConnectionManager().shutdown();
		}
		
		return "error";
	}
	

}
