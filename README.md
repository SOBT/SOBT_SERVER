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
