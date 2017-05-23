package com.sobt.project;

import org.springframework.stereotype.Controller;

import java.net.URLDecoder;

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
import sobt.python.service.PapagoService;
import sobt.user.service.UserService;

@Controller
public class MessageController {
	@Autowired
	MessageService msgService;
	@Autowired
	private WeatherApiManager weatehrApiManager;
	@Autowired 
	private UserService userService;
	@Autowired
	private PapagoService papagoService;

	@RequestMapping(value = "/message", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	public @ResponseBody MessageVo message(@RequestBody User user) throws Exception {
//		userService.addUser(user.getUser_key(), user.getContent(), user.getType());
		String text = user.getContent();
		text = URLDecoder.decode(text, "UTF-8");
		
		MessageVo msgVo = new MessageVo();
		Message message = msgService.makeMessage("해당 기능은 아직 준비 중입니다!");
		if( text.equals("날씨 정보")){
			message = msgService.makeMessage(weatehrApiManager.getWeatherAll());
			Keyboard keyboard = msgService.makeKeyboard("날씨 정보","지하철 정보","영화 정보");
			msgVo.setKeyboard(keyboard);
		}else if( text.equals("홈페이지")){
			message = msgService.makeMessage("SOBT 홈페이지 바로가기","바로가기","https://github.com/SOBT/SOBT_SERVER");
		}else{
			return papagoService.getText(text);
		}
		
		msgVo.setMessage(message);
		
		return msgVo;
	}
}