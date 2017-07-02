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
import sobt.domain.user.UserSubway;
import sobt.user.service.UserService;

public class ChatTemplate {

	private UserService userService;
	private WeatherApiManager weatherApiManager;
	private SubwayCallback subwayCallback;
	private MessageService msgService;
	private TranslateCallback translateCallback;

	public void setTranslateCallback(TranslateCallback translateCallback) {
		this.translateCallback = translateCallback;
	}

	public void setMessageService(MessageService msgService) {
		this.msgService = msgService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setWeatherApiManager(WeatherApiManager weatherApiManager) {
		this.weatherApiManager = weatherApiManager;
	}

	public void setSubwayCallback(SubwayCallback subwayCallback) {
		this.subwayCallback = subwayCallback;
	}

	public MessageVo doChatProcess(KakaoUser kakaoUser) {
		ChatResult cs = null;
		ChatCallback chatCallback = null;
		UserData userData = null;
		UserSubway userSubway = null;
		boolean update = true;
		User user = userService.getUser(kakaoUser.getUser_key());
		if (user == null) {
			user = new User();
			user.setUserId(kakaoUser.getUser_key());
			user.setDefaultStatus();
			update = false;
		}else {
			//시간 확인해서 사용자 상태 초기화.
			if(checkFiredSession(user)){
				user.setDefaultStatus();
			}
		}
		userData = new UserData(kakaoUser.getUser_key(), kakaoUser.getContent(), kakaoUser.getType());
		userSubway = new UserSubway(kakaoUser.getUser_key());
		try {
			if (userData.getUserContent().equals("처음")) {
				user.setDefaultStatus();
				Keyboard keyboard = msgService.makeKeyboard("날씨 정보", "지하철 정보", "문장번역");
				MessageVo msgVo = new MessageVo();
				msgVo.setKeyboard(keyboard);
				return msgVo;
			}
			user = checkStatus(user, userData);
			chatCallback = getChatCallback(user);
			cs = chatCallback.doProcessChat(user, userData.getUserContent());
			user = cs.getUser();
			return cs.getMessageVo();
		} catch (AssertionError e) {
			cs = prcsProcessException(user);
			user = cs.getUser();
			return cs.getMessageVo();
		} finally {
			if (update) {
				userService.updateUser(user);
				userService.addUserData(userData);
				userService.addUserSubway(userSubway);
			} else {
				userService.addUser(user, userData, userSubway);
			}
		}

	}

	// 사용자 상태에 따라 callback 설정.
	private ChatCallback getChatCallback(User user) {
		switch (user.getStatus().intValue()) {
		case 1:
			return new ChatCallback() {

				@Override
				public ChatResult doProcessChat(User user, String text) {
					// TODO Auto-generated method stub
					user.setDefaultStatus();
					Message message = msgService.makeMessage(weatherApiManager.getWeatherAll());
					Keyboard keyboard = msgService.makeKeyboard("날씨 정보", "지하철 정보", "문장번역");
					MessageVo msgVo = new MessageVo();
					msgVo.setKeyboard(keyboard);
					msgVo.setMessage(message);
					return new ChatResult(user, msgVo);
				}
			};
		case 2:
			return this.subwayCallback;
		case 3:
			return this.translateCallback;
		default:
			throw new AssertionError();
		}
	}

	// 사용자 Status 확인 및 설정.
	private User checkStatus(User user, UserData userData) throws AssertionError {
		if (user.getStatus().equals(Status.NORMAL)) {
			user.setStatus(Status.valueOfString(userData.getUserContent()));
			return user;
		} else {
			return user;
		}
	}

	// 예외 처리 로직.
	private ChatResult prcsProcessException(User user) {
		user.setDefaultStatus();
		MessageVo msgVo = new MessageVo();
		Message message = msgService.makeMessage("해당 기능은 아직 준비 중입니다!");
		Keyboard keyboard = msgService.makeKeyboard("날씨 정보", "지하철 정보", "문장번역");
		msgVo.setKeyboard(keyboard);
		msgVo.setMessage(message);
		return new ChatResult(user, msgVo);
	}
	private boolean checkFiredSession(User user){
		//ex) rq_Dt : 20170626 210932
		return false;
	}

}
