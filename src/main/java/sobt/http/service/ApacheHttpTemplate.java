package sobt.http.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;

public class ApacheHttpTemplate {
	public String ConnectHttpTemplate(String url, TypeStrategy strategy) {
		HttpClient client = HttpClientBuilder.create().build();
		HttpResponse response = null;

		try {
			response = strategy.DoSomethingWithType(client, url);
		} catch (ClientProtocolException e2) {
		} catch (IOException e2) {
		}

		BufferedReader rd = null;
		try {
			rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		} catch (UnsupportedOperationException e1) {
		} catch (IOException e1) {
		}finally{
		}

		StringBuffer result = new StringBuffer();
		String line = "";
		try {
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
		} catch (IOException e) {
		}

		return result.toString();
	}
}
