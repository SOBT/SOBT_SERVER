package sobt.api.manage;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

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
		//역외부코드 받아오기 + 서버시간 받아오기
		//sobt.util 클래스만들어서 서버시간 받아오기
		String frcode = stationDataDao.getStationFRCode(stationName, LINE_NUM);
		String url = String.format(SOBTConstant.FIRST_AND_LAST_SUBWAY_API_URL, SOBTConstant.FIRST_AND_LAST_PRODUCT_KEY, type , LINE_NUM, WEEK_TAG, INOUT_TAG, frcode);
		parserService = new SearchFirstAndLastFRCodeParser();
		return parserService.Parse(httpService.doHttpGet(url));
		
	}

}
