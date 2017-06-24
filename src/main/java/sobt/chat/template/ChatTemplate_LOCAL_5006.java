package sobt.chat.template;

import com.sobt.domain.KakaoUser;

import sobt.api.manage.SubwayAPIManager;
import sobt.api.manage.WeatherApiManager;
import sobt.domain.message.Keyboard;
import sobt.domain.message.Message;
import sobt.domain.message.MessageService;
import sobt.domain.message.MessageVo;
import sobt.domain.user.Status;
import sobt.domain.user.SubStatus;
import sobt.domain.user.User;
import sobt.domain.user.UserData;
import sobt.user.service.UserService;

public class ChatTemplate {
	
	private UserService userService;
	private MessageService msgService;
	private WeatherApiManager weatherApiManager;
	private SubwayAPIManager subwayApiManager;
	public void setUserService(UserService userService){
		this.userService = userService;
	}
	public void setMessageService(MessageService msgService){
		this.msgService = msgService;
	}
	public void setWeatherApiManager(WeatherApiManager weatherApiManager){
		this.weatherApiManager = weatherApiManager;
	}
	public void setSubwayAPIManager(SubwayAPIManager subwayApiManager){
		this.subwayApiManager = subwayApiManager;
	}
	
	public MessageVo doChatProcess(KakaoUser kakaoUser){
		ChatResult cs = null;
		ChatCallback chatCallback = null;
		UserData userData = null;
		boolean update = true;
		User user = userService.getUser(kakaoUser.getUser_key());
		if(user == null){
			user = new User();
			user.setUserId(kakaoUser.getUser_key());
			user.setDefaultStatus();
			update = false;
		}
		userData = new UserData(kakaoUser.getUser_key(),kakaoUser.getContent(),kakaoUser.getType());
		try{
			user = checkStatus(user,userData);
			chatCallback = getChatCallback(user);
			cs = chatCallback.doProcessChat(user, userData.getUserContent());
			user = cs.getUser();
			return cs.getMessageVo();
		}catch(AssertionError e){
			cs = prcsProcessException(user);
			user = cs.getUser();
			return cs.getMessageVo();
		}finally{
			if(update){
				userService.updateUser(user);
			}else{ 
				userService.addUser(user, userData);
			}
		}
		
	}
	
	
	//사용자 상태에 따라 callback 설정.
	private ChatCallback getChatCallback(User user){
		switch(user.getStatus().intValue()){
			case 1 :
				return new ChatCallback(){
					@Override
					public ChatResult doProcessChat(User user, String text) {
						// TODO Auto-generated method stub
						user.setDefaultStatus();
						Message message = msgService.makeMessage(weatherApiManager.getWeatherAll());
						Keyboard keyboard = msgService.makeKeyboard("날씨 정보","지하철 정보","영화 정보");
						MessageVo msgVo = new MessageVo();
						msgVo.setKeyboard(keyboard);
						msgVo.setMessage(message);
						return new ChatResult(user,msgVo);
					}};
			case 2 : 
				user.setSubStatus(SubStatus.SELECT_SUB_SERVICE);
				return new ChatCallback() {
					MessageVo msgVo = new MessageVo();
					Message message;
					Keyboard keyboard;
					
					@Override
					public ChatResult doProcessChat(User user, String text) {
						if(user.getSubStatus().equals(SubStatus.SELECT_SUB_SERVICE)) {
							message = msgService.makeMessage("1. 실시간 지하철 정보\n"+"2. 첫차/막차 정보\n"+"중에서 선택해주세요");
							if(text.equals("1"))
								user.setSubStatus(SubStatus.RT_SUB_NAME);
							else if(text.equals("2"))
								user.setSubStatus(SubStatus.FL_SUB_LINE);
							else
								user.setSubStatus(SubStatus.SELECT_SUB_SERVICE);
						} else if(user.getSubStatus().equals(SubStatus.RT_SUB_NAME)) {
							message = msgService.makeMessage("원하는 지하철역을 입력하세요");
						} else if(user.getSubStatus().equals(SubStatus.RT_RESULT)) {
							/*
							user.setDefaultStatus();
							message = msgService.makeMessage(subwayApiManager.getRealTimeArrival("json", statnNm));
							keyboard = msgService.makeKeyboard("날씨 정보","지하철 정보","영화 정보");
							*/
						} else if(user.getSubStatus().equals(SubStatus.FL_SUB_NAME)) {
							message = msgService.makeMessage("원하는 지하철역을 입력하세요");
						} else if(user.getSubStatus().equals(SubStatus.FL_SUB_LINE)) {
							message = msgService.makeMessage("원하는 호선을 입력하세요");
						} else if(user.getSubStatus().equals(SubStatus.FL_SUB_INOUT)) {
							message = msgService.makeMessage("상/하행선을 입력하세요");
						} else if(user.getSubStatus().equals(SubStatus.FL_RESULT)) {
							/*
							user.setDefaultStatus();
							message = msgService.makeMessage(subwayApiManager.getFirstAndLast("json", LINE_NUM, WEEK_TAG, INOUT_TAG, stationName));
							keyboard = msgService.makeKeyboard("날씨 정보","지하철 정보","영화 정보");
							*/
						}
						msgVo.setKeyboard(keyboard);
						msgVo.setMessage(message);
						return new ChatResult(user,msgVo);
					}
				};
			case 3 : 
				throw new AssertionError();
			default :
				throw new AssertionError();
		}
	}
	
	//사용자 Status 확인 및 설정.
	private User checkStatus(User user, UserData userData) throws AssertionError {
		System.out.println(user.getUserId());
		if (user.getStatus().equals(Status.NORMAL)) {
			user.setStatus(Status.valueOfString(userData.getUserContent()));
			return user;
		} else {
			return user;
		}
	}
	
	//예외 처리 로직.
	private ChatResult prcsProcessException(User user){
		user.setDefaultStatus();
		MessageVo msgVo = new MessageVo();
		Message message = msgService.makeMessage("해당 기능은 아직 준비 중입니다!");
		Keyboard keyboard = msgService.makeKeyboard("날씨 정보","지하철 정보","영화 정보");
		msgVo.setKeyboard(keyboard);
		msgVo.setMessage(message);
		return new ChatResult(user,msgVo);
	}
	
	
}
