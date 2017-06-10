package sobt.api.manage;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
//import java.util.Date;

import sobt.dao.subway.StationDataDao;
import sobt.http.service.HttpService;
import sobt.parser.service.ParserService;
import sobt.parser.service.RealTimeStationArrivalParser;
import sobt.parser.service.SearchFirstAndLastFRCodeParser;
import sobt.util.SOBTConstant;

public class BasicSubwayAPIManager implements SubwayAPIManager{
	private HttpService httpService;
	private ParserService parserService;
	private StationDataDao stationDataDao;
	
	public void setParserService(ParserService parserService) {
		this.parserService = parserService;
	}
	
	public void setHttpService(HttpService httpService) {
		this.httpService = httpService;
	}
	
	public void setStationDataDao(StationDataDao stationDataDao) {
		this.stationDataDao = stationDataDao;
	}
	
	@Override
	public String getRealTimeArrival(String type, String statnNm) throws UnsupportedEncodingException {
		// IOException + Runtime
		String url = String.format(SOBTConstant.REALTIME_SUBWAY_API_URL, SOBTConstant.REALTIME_PRODUCT_KEY, type , URLEncoder.encode(statnNm, "UTF-8"));
		parserService = new RealTimeStationArrivalParser();
		return parserService.Parse(httpService.doHttpGet(url));
	}
	
	@Override
	public String getFirstAndLast(String type, String LINE_NUM, int WEEK_TAG, int INOUT_TAG, String stationName) {
		//IOException + Runtime
		//Date date = new Date(); 
		//date.getDay(); (0 = Sunday, 1 = Monday, 2 = Tuesday, 3 = Wednesday, 4 = Thursday, 5 = Friday, 6 = Saturday)
		String frcode = stationDataDao.getStationFRCode(stationName, LINE_NUM);
		String url = String.format(SOBTConstant.FIRST_AND_LAST_SUBWAY_API_URL, SOBTConstant.FIRST_AND_LAST_PRODUCT_KEY, type , LINE_NUM, WEEK_TAG, INOUT_TAG, frcode);
		parserService = new SearchFirstAndLastFRCodeParser();
		return parserService.Parse(httpService.doHttpGet(url));
		
	}

}
