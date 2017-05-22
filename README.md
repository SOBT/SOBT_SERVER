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
//객체생
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
 
