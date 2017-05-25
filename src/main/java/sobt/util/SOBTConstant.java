package sobt.util;

public class SOBTConstant {
	final public static String SQLMAP_FILE_NAME ="sqlmap.xml";
	
	
	final public static String WEATHER_API_APP_KEY = "1c33a135-5e89-34c1-baf9-ba0d453a29e8";
	final public static String WEATHER_API_URL_MIN = "http://apis.skplanetx.com/weather/current/minutely?version=1&lat=&lon=&city=%s&county=%s&village=%s&stnid=";
	final public static String WEATHER_API_URL_LOC = "http://apis.skplanetx.com/weather/airquality/current?version=1&lat=%f&lon=%f";
	final public static String WEATHER_API_URL_ALL = "http://www.kma.go.kr/weather/forecast/mid-term-rss3.jsp?stnId=108";
	final public static String PAPAGO_API_URL = "https://openapi.naver.com/v1/language/translate";
	final public static String PAPAGO_CLIENT_ID = "ZNWdhtejGiPYnWK55IfZ";
	final public static String PAPAGO_CLIENT_SECRET = "ajrA9jH8iO";
	final public static String FIRST_AND_LAST_SUBWAY_API_URL = "http://openAPI.seoul.go.kr:8088/%s/%s/SearchFirstAndLastTrainbyFRCodeService/1/5/%d/%d/%d/%s/";
	final public static String FIRST_AND_LAST_PRODUCT_KEY = "41455749506c687735304f43775551";
	final public static String REALTIME_SUBWAY_API_URL = "http://swopenAPI.seoul.go.kr/api/subway/%s/%s/realtimeStationArrival/0/5/%s";
	final public static String REALTIME_PRODUCT_KEY = "51646375416c687735364d41484350";

}
