package com.sobt.project;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import sobt.domain.message.MessageVo;
import com.sobt.domain.KakaoUser;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
//	@Autowired
	MessageVo messageVo;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/friend", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	public @ResponseBody MessageVo add_friend(@RequestBody KakaoUser user) throws Exception {
		String text = user.getUser_key();
//		messageVo.setText(text+"님 친구로 추가해주셔서 감사합니다!");
//		messageVo.setKeyboard_buttons("날씨 정보", "지하철 정보", "영화 정보");
		return messageVo;
	}
	
	@RequestMapping(value = "/friend/{user_key}", method = RequestMethod.DELETE, headers = "Accept=application/json; charset=utf-8")
	public @ResponseBody MessageVo del_friend(@PathVariable String user_key) throws Exception {
//		String text = user.getUser_key();
//		messageVo.setText(user_key+"님 다음에 또 만나요!");
		return messageVo;
	}
	
	@RequestMapping(value = "/chat_room/{user_key}", method = RequestMethod.DELETE, headers = "Accept=application/json; charset=utf-8")
	public @ResponseBody MessageVo exit(@PathVariable String user_key) throws Exception {
//		messageVo.setText(user_key+"님 다음에 또 만나요!");
		return messageVo;
	}
}
