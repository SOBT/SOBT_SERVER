package com.sobt.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import sobt.domain.message.Keyboard;
import sobt.domain.message.MessageService;
import sobt.domain.message.MessageServiceImpl;

/**
 * @author namwoo
 * 사용자가 처음 방에 입장하면 표시되는 화면
 */
@Controller
public class KeyboardController {
	@Autowired
	MessageService msg_service;
	
	@RequestMapping(value = "/keyboard", method = RequestMethod.GET, headers = "Accept=application/json; charset=utf-8")
	public @ResponseBody Keyboard keyboard() throws Exception { 
		Keyboard keyboard = msg_service.makeKeyboard("날씨 정보", "지하철 정보", "영화 정보");
		return keyboard;
	}
}
