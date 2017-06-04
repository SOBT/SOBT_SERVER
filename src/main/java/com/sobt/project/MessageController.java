package com.sobt.project;

import org.springframework.stereotype.Controller;

import java.net.URLDecoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sobt.domain.KakaoUser;

import sobt.domain.user.Status;
import sobt.domain.user.SubStatus;
import sobt.domain.user.User;
import sobt.domain.user.UserData;
import sobt.api.manage.SubwayAPIManager;
import sobt.api.manage.WeatherApiManager;
import sobt.chat.template.ChatTemplate;
import sobt.domain.message.Keyboard;
import sobt.domain.message.Message;
import sobt.domain.message.MessageService;
import sobt.domain.message.MessageVo;
import sobt.python.service.PapagoService;
import sobt.user.service.UserService;

@Controller
public class MessageController {
	@Autowired
	ChatTemplate chatTemplate;

	@RequestMapping(value = "/message", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	public @ResponseBody MessageVo message(@RequestBody KakaoUser kakaoUser) throws Exception {
		
		return chatTemplate.doChatProcess(kakaoUser);
	}
}