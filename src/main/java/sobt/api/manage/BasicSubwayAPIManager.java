package sobt.api.manage;

import sobt.http.service.HttpService;
import sobt.parser.service.ParserService;
import sobt.parser.service.RealTimeStationArrivalParser;
import sobt.parser.service.SearchFirstAndLastFRCodeParser;
import sobt.util.SOBTConstant;

public class BasicSubwayAPIManager implements SubwayAPIManager{
	private HttpService httpService;
	private ParserService parserService;
	
	public void setParserService(ParserService parserService) {
		this.parserService = parserService;
	}
	
	public void setHttpService(HttpService httpService) {
		this.httpService = httpService;
	}
	
	@Override
	public String getRealTimeArrival(String type, String statnNm) {
		//�삁�쇅泥섎━ IOException + Runtime
		String url = String.format(SOBTConstant.REALTIME_SUBWAY_API_URL, SOBTConstant.REALTIME_PRODUCT_KEY, type , statnNm);
		parserService = new RealTimeStationArrivalParser();
		
		String text = parserService.Parse(httpService.doHttpGet(url));
		System.out.println(text);
		return text;
	}
	
	@Override
	public String getFirstAndLast(String type, int LINE_NUM, int WEEK_TAG, int INOUT_TAG, String FR_CODE) {
		//�삁�쇅泥섎━ IOException + Runtime
		String url = String.format(SOBTConstant.FIRST_AND_LAST_SUBWAY_API_URL, SOBTConstant.FIRST_AND_LAST_PRODUCT_KEY, type , LINE_NUM, WEEK_TAG, INOUT_TAG, FR_CODE);
		parserService = new SearchFirstAndLastFRCodeParser();
		return parserService.Parse(httpService.doHttpGet(url));
		
	}

}
