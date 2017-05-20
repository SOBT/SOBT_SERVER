package sobt.http.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;

public class ApacheHttpService implements HttpService {

	@Override
	public String DoHttpGet(String url, final String... head) {
		return new ApacheHttpTemplate().ConnectHttpTemplate(url, new TypeStrategy() {

			@Override
			public HttpResponse DoSomethingWithType(HttpClient client, String url)
					throws ClientProtocolException, IOException {
				HttpGet request = new HttpGet(url);

				for (int i = 0; i < head.length; i += 2) {
					request.setHeader(head[i], head[i + 1]);
				}

				return client.execute(request);

			}
		});
	}

	@Override
	public String DoHttpPost(String url, final HashMap<String, String> entitys, final String... head) {
		return new ApacheHttpTemplate().ConnectHttpTemplate(url, new TypeStrategy() {

			@Override
			public HttpResponse DoSomethingWithType(HttpClient client, String url)
					throws ClientProtocolException, IOException {
				HttpPost request = new HttpPost(url);

				for (int i = 0; i < head.length; i += 2) {
					request.setHeader(head[i], head[i + 1]);

				}

				List<NameValuePair> nameValuePairList = new ArrayList<NameValuePair>();
				Iterator<String> keys = entitys.keySet().iterator();

				while (keys.hasNext()) {
					String key = keys.next();
					nameValuePairList.add(new BasicNameValuePair(key, entitys.get(key)));
				}

				request.setEntity(new UrlEncodedFormEntity(nameValuePairList, "UTF-8"));

				return client.execute(request);

			}
		});
	}
}
