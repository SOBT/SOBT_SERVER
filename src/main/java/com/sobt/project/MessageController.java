package com.sobt.project;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sobt.domain.User;

import sobt.api.manage.WeatherApiManager;
import sobt.domain.message.Keyboard;
import sobt.domain.message.Message;
import sobt.domain.message.MessageService;
import sobt.domain.message.MessageVo;
import sobt.user.service.UserService;

@Controller
public class MessageController {
	@Autowired
	MessageService msgService;
	@Autowired
	private WeatherApiManager weatehrApiManager;
	@Autowired 
	private UserService userService;

	@RequestMapping(value = "/message", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	public @ResponseBody MessageVo message(@RequestBody User user) throws Exception {
//		userService.addUser(user.getUser_key(), user.getContent(), user.getType());
		String text = user.getContent();
		
		MessageVo msgVo = new MessageVo();
		Message message = msgService.makeMessage("해당 기능은 아직 준비 중입니다!");
		if( text.equals("날씨 정보")){
			message = msgService.makeMessage(weatehrApiManager.getWeatherMin("서울", "노원구", "월계동"));
			// 사용자로부터 버튼 방식으로 응답 받는 예시
			Keyboard keyboard = msgService.makeKeyboard("날씨 정보","지하철 정보","영화 정보");
			msgVo.setKeyboard(keyboard);
		}else if( text.equals("홈페이지")){
			message = msgService.makeMessage("SOBT 깃허브 홈페이지","바로가기","https://github.com/SOBT/SOBT_SERVER");
		}else{}
		
		msgVo.setMessage(message);
		
		return msgVo;
	}
}