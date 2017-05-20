package sobt.http.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;

public class ApacheHttpTemplate {
	public String connectHttpTemplate(String url, TypeStrategy strategy){
		HttpClient client = HttpClientBuilder.create().build();
		HttpResponse response = null;
		HttpUriRequest request = null;
		BufferedReader rd = null;
		StringBuffer result = new StringBuffer();
		String line = "";

		try {
			request = strategy.DoSomethingWithType(url);
			response = client.execute(request);
			rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}

			return result.toString();
		} catch (ClientProtocolException e2) {
			throw new HttpServiceException(e2);
		} catch (IOException e2) {
			throw new HttpServiceException(e2);
		} finally {
			
			if (rd != null) {
				try {
					rd.close();
				} catch (Exception e) {
					throw new HttpServiceException("read buffer null\n");
				}
			}

			if (client != null) {
				try {
					client.getConnectionManager().shutdown();
				} catch (Exception e) {
					throw new HttpServiceException("client null\n");
				}
			}
		}

	}
}
