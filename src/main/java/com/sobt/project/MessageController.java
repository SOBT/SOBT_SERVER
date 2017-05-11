package com.sobt.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sobt.domain.MessageVo;
import com.sobt.domain.User;

@Controller
public class MessageController {

	@Autowired
	private MessageVo messageVo;

	@RequestMapping(value = "/message", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	public @ResponseBody MessageVo message(@RequestBody User user) throws Exception {
		String text = user.getContent();
		messageVo.setText(text);
		messageVo.setKeyboard_buttons("날씨 정보", "지하철 정보", "영화 정보");
		return messageVo;
	}

}