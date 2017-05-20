package sobt.http.service;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;

public interface TypeStrategy {
	public HttpUriRequest DoSomethingWithType(String url);
}
