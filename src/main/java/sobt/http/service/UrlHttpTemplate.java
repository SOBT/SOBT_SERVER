package sobt.http.service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class UrlHttpTemplate {
	
	
	public String httpServiceTemplate(String requestUrl,UrlCallback callback){
		URL url = null;
		HttpURLConnection con = null;
		BufferedReader br = null;
		try{
			url = new URL(requestUrl);
			con = (HttpURLConnection)url.openConnection();
			con = callback.doSomtingWithHttpService(con);
			int responseCode = con.getResponseCode();
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
			return response.toString();
		}catch(IOException e){
			throw new HttpServiceException(e);
		}finally{
			if(con != null){
				con.disconnect();
			}
			
		}
	}
}
