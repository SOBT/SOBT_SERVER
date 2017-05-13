package com.sobt.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sobt.domain.MessageVo;
import com.sobt.domain.User;

import sobt.api.manage.WeatherApiManager;
import sobt.domain.message.Message;
import sobt.domain.message.MessageService;
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
		userService.addUser(user.getUser_key(), user.getContent(), user.getType());
		String text = user.getContent();
		Message message = null;
		if( text.equals("날씨 정보")){
			message = msgService.makeMessage(weatehrApiManager.getWeatherMin("서울", "노원구", "월계동"));
		}
		
		MessageVo msgVo = new MessageVo();
		msgVo.setMessage(message);
		return msgVo;
	}
}