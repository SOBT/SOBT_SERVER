# SOBT_SERVER

[ MessageService 사용법 ]
@Autowired
MessageService msgService;

MessageVo msgVo = new MessageVo();
// 메시지 작성 ( 사진이나 링크 설정은 인터페이스 참조 )
Message message = msgService.makeMessage("일반텍스트");
// 버튼 추가 (추가 생성은 인터페이스 참조)
Keyboard keyboard = msgService.makeKeyboard("버튼1");
msgVo.setMessage(message);
msgVo.setKeyboard(keyboard);
return msgVo;
