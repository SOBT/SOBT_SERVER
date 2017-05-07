package com.sobt.project;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sobt.domain.Keyboard;

@Controller
public class KeyboardController {

	@RequestMapping(value = "/keyboard", method = RequestMethod.GET, headers = "Accept=application/json; charset=utf-8")
	public @ResponseBody Keyboard keyboard() throws Exception {
		Keyboard keyboard = new Keyboard();
		List<String> buttons = new ArrayList<String>();
		keyboard.setType("text");
		// buttons.add("기능1_ex.지하철");
		// buttons.add("기능2_ex.버스");
		// keyboard.setButtons(buttons);
		buttons.add("기능1_날씨 정보");
		keyboard.setButtons(buttons);
		return keyboard;
	}
}
