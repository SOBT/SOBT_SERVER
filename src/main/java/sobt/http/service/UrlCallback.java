package sobt.http.service;

import java.io.IOException;
import java.net.HttpURLConnection;

public interface UrlCallback {
	public HttpURLConnection doSomtingWithHttpService(HttpURLConnection con) throws IOException;
}
