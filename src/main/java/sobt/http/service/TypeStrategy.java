package sobt.http.service;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;

public interface TypeStrategy {
	public HttpResponse DoSomethingWithType(HttpClient client, String url) throws ClientProtocolException, IOException;
}
