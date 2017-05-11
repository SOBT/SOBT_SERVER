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

@Controller
public class MessageController {

	@Autowired
	private MessageVo messageVo;
	@Autowired
	private WeatherApiManager weatehrApiManager;

	@RequestMapping(value = "/message", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	public @ResponseBody MessageVo message(@RequestBody User user) throws Exception {
		String text = user.getContent();
		messageVo.setText(text);
		if (text.equals("날씨 정보")){
			messageVo.setText(weatehrApiManager.getWeatherMin("서울", "노원구", "월계동"));
		}else{
			messageVo.setMessageBtn("github 바로가기", "https://github.com/SOBT/SOBT_SERVER");
		}
		messageVo.setKeyboard_buttons("날씨 정보", "지하철 정보", "영화 정보");
		return messageVo;
	}
}