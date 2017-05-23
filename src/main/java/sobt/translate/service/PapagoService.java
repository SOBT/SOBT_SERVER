package sobt.translate.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import sobt.http.service.HttpService;
import sobt.util.SOBTConstant;

public class PapagoService implements TranslateService {
	private HttpService httpService;
	
	public void setHttpService(HttpService httpService){
		this.httpService = httpService;
	}
	
	@Override
	public String translateSentence(Translate translate, String sentence){
		Map<String,String> param = new HashMap<String,String>();
		param.put("source", translate.getSource());
		param.put("target", translate.getTarget());
		param.put("text", sentence);
		
		Map<String, String> header = new HashMap<String,String>();
		header.put("X-Naver-Client-Id",SOBTConstant.PAPAGO_CLIENT_ID);
		header.put("X-Naver-Client-Secret", SOBTConstant.PAPAGO_CLIENT_SECRET);
		
		return resultParse(this.httpService.doHttpPostByUrlencoded(SOBTConstant.PAPAGO_API_URL, header, param));
	}
	
	private String resultParse(String jsonString){
		try{
			JSONParser parser = new JSONParser();
			JSONObject obj = (JSONObject)parser.parse(jsonString);
			Iterator itr = obj.keySet().iterator();
			String key = null;
			String translateSentance = null;
			while(itr.hasNext()){
				key = itr.next().toString();
				if(key.equalsIgnoreCase("errorMessage")){
					translateSentance = (String)obj.get(key);
					throw new RuntimeException(translateSentance);
				}
				if(key.equalsIgnoreCase("message")){
					JSONObject message = (JSONObject)obj.get(key);
					JSONObject result =  (JSONObject)message.get("result");
					translateSentance = (String)result.get("translatedText");
				}
				
			}
			return translateSentance;
		}catch(ParseException e){
			throw new RuntimeException(e);
		}
		
	}
	


}
