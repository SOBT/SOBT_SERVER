SOBT_SERVER
=======================================================
## Amazon server 접속 설정 방법 ( XSHELL )
<pre>
[-] 연결
이름(N)     : 아무거나
호스트(H)   : ec2-13-124-103-231.ap-northeast-2.compute.amazonaws.com
포트 번호(O) : 22

[-] 사용자 인증
방법(M)      : Public Key
사용자 이름  : ubuntu
사용자 키(K) : 찾아보기 클릭 -> pem 파일 로드
</pre>

## MessageService 사용법
<pre><code>@Autowired
MessageService msgService;

public MessageVo yourMethod(String param){
  MessageVo msgVo = new MessageVo();
  // 메시지 작성 ( 사진이나 링크 설정은 인터페이스 참조 )
  Message message = msgService.makeMessage("일반텍스트");
  // 버튼 추가 (추가 생성은 인터페이스 참조)
  Keyboard keyboard = msgService.makeKeyboard("버튼1");

  msgVo.setMessage(message);
  msgVo.setKeyboard(keyboard);

  return msgVo;
}</code></pre>

## UrlHttpService 사용법
<pre><code>
//객체 생성.
@Autowired
HttpService urlHttpService
//GET 요청 -> Url 및 필요시 Header 정보 전달.
public String doHttpGet(String url, final String ...head);
//Post 요청 -> 요청방식에 따라 urlencoded,json 방식 선택 후 param 및 header값 Map<String,String> 으로 전
public String doHttpPostByUrlencoded(String url , final Map<String, String> param);
public String doHttpPostByUrlencoded(String url , final Map<String, String> Header , final Map<String, String> param);
public String doHttpPostByJson(String url , final Map<String, String> param);
public String doHttpPostByJson(String url , final Map<String, String> Header,final Map<String, String> param);
//예시
public String translateSentence(Translate translate, String sentence){
		Map<String,String> param = new HashMap<String,String>();
		param.put("source", translate.getSource());
		param.put("target", translate.getTarget());
		param.put("text", sentence);

		Map<String, String> header = new HashMap<String,String>();
		header.put("X-Naver-Client-Id",SOBTConstant.PAPAGO_CLIENT_ID);
		header.put("X-Naver-Client-Secret", SOBTConstant.PAPAGO_CLIENT_SECRET);

		return resultParse(this.httpService.doHttpPostByUrlencoded(SOBTConstant.PAPAGO_API_URL, header, param));
}</code></pre>

## PapagoService 사용법
<pre><code>
//객체생성
@Autowired
TranslateService translateService;

//원하는 번역 방식을 Translate enum객체로 전달, 번역할 문장 전달.
public String translateSentence(Translate translate, String sentence)

//Translate enum 객체 종류
EN_TO_KO("en","ko"), KO_TO_EN("ko","en"), KO_TO_JA("ko","ja"), KO_TO_CN("ko","zh-CN")
,JA_TO_KO("ja","ko"),CN_TO_KO("zh-CN","ko");

//예시
public void translateTest(){
		System.out.println(translateService.translateSentence(Translate.KO_TO_CN, "만나서 반갑습니다."));
}</code></pre>

## SubWayService 사용법
<pre><code>
//객체생성
@Autowired
BasicSubwayAPIMananger basicSubwayAPIManager;

//원하는 텍스트 타입(json), 지하철역 전달 - 실시간 지하철 정보
public String getRealTimeArrival(String type, String statnNm)

//원하는 텍스트 타입(json), 호선, 현재시간(서버시간), 상하행선, 지하철역 전달 - 첫차/막차 정보
public String getFirstAndLast(String type, String LINE_NUM, int WEEK_TAG, int INOUT_TAG, String stationName)

//받아온 정보들 parsing
public String Parse(String json)

//예시 - 실시간 지하철 정보
public String Parse(String json) {
    Gson gson = new Gson();
    RealTimeStationArrivalResponse response = gson.fromJson(json, RealTimeStationArrivalResponse.class);
    List <RealTimeStationArrivalInfo> info=response.getRealtimeArrivalList();

    if(response.getErrorMessage().getCode().equals("INFO-000")) {
        String result;
        result = info.get(0).getStatnNm()+"역\n";

        for(int i=0;i<info.size();i++)
        {
            result += info.get(i).getSubwayId() + " " + info.get(i).getBstatnNm() + "행 " + info.get(i).getArvlCd() +"("+info.get(i).getArvlMsg3() + ")\n";
        }

        return result;
    }		
    return response.getErrorMessage().getMessage();
}</code></pre>


## DB연동 방법.
<pre><code>
//연결 정보 설정.
테스트 -> test-applicationContext.xml
운영 -> root-context.xml
------------------------------------------------------------------
DataSource Bean으로 설정 정보 관리.
name = "url" value = "jdbc:mysql://localhost:3306/SOBT?useSSL=false"
name = "username" value = "name"
name = "password" value = "password"
3항목을 환경에 맞게 변경해서 관리.

//Query관리.
*SQL문장을 sqlmap.xml 파일에서 관리.
SqlService 를 통해 쿼리 문장 호출
public String getSql(String key) 함수 호출
-> key 값 전달시 sql 문장 return;

//Query실행
Spring JdbcTemplate 클래스 사용.(http://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/jdbc/core/JdbcTemplate.html);

1.CUD(INSERT,UPDATE,DELETE).
jdbcTemplate.update() 함수사용.

ex)
this.jdbcTemplate.update(this.sqlService.getSql("addUser"),user.getUserId());
-> 첫 인자로 sql, 두번째인자로 Mapping되는 조건들 Parameter로 전달(없을 경우 생략).

2.R(SELECT).
단건 -> jdbcTemplate.queryForObject() 함수사용
다건 -> jdbcTemplate.query() 함수사용

ex ) query(String sql, Object[] args, RowMapper<T> rowMapper)
-> 첫인자로 sql , 두번째 인자로 Mapping되는 조건들, 세번째로 반환된 결과를 RowMapper를 통해 원하는 형식으로 return받음

1)RowMapper 생성.
public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			User user = new User();
			user.setUserId(rs.getString("user_id"));
			user.setStatus(Status.valueOf(rs.getInt("status")));
			user.setSubStatus(SubStatus.valueOf("sub_status"));
			return user;
		}};

2) queryForObject 실행
jdbcTemplate.queryForObject(this.sqlService.getSql("getUser"),new Object[]{userId},this.userMapper);


</code></pre>

## Quartz 사용방법 (BackGround Scheduler)
<pre><code>
    root-context에서 

    id="cronTrigger" class="org.springframework.scheduling.quartz.CronTriggerFactoryBean"
          p:jobDetail-ref="weatherJob"
          p:startDelay="1000"
          p:cronExpression="0 0 16 * * ?"/>

          cronExpression 표현식으로 실행 시간 설정

          예) 
            예를들어 2016년 11월 20일 오후 2시(14시) 10분 36초에 실행하려고 합니다.
            자바기반 yyyy-MM-dd HH:mm:ss 로 표현하면 2016-11-20 14:10:36 입니다.
            크론 표현식으로 표현한다면 아래와 같습니다.
            36 10 14 20 11 ? 2016
            - 여기서 보이는 ? 는 설정값 없음으로 오직 일[day-of-month:1-31], 요일[day-of-week:0-6]에서만 사용 가능합니다.
            좀 더 응용해서 매년 11월 20일 오후 2시(14시) 10분 36초 에 실행하려고한다면 아래와 같이 표현할 수 있습니다.
            36 10 14 20 11 ? * 혹은 36 10 14 20 11 ?
            스프링 스케줄러와 쿼츠에서는 연도를 생략할 수 있습니다.
            또한 *는 모든조건 즉, 와일드카드입니다.

</code></pre>


