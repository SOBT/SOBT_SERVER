package com.sobt.domain;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 응답 객체 ( Response object )
 * 
 * @author namwoo
 * @method setKeyboard_buttons : 버튼 입력 방식
 */
public class MessageVo {
	@Autowired
	Message message;
	@Autowired
	Keyboard keyboard;

	// ======== Spring 메소드 ==========
	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public Keyboard getKeyboard() {
		return keyboard;
	}

	public void setKeyboard(Keyboard keyboard) {
		this.keyboard = keyboard;
	}
	// ===============================

	public void setText(String text) {
		this.message.setText(text);
	}

	public void setKeyboard_buttons(String button1) {
		this.keyboard.setType("buttons");
		this.keyboard.addButtons(button1);
	}

	public void setKeyboard_buttons(String button1, String button2) {
		this.keyboard.setType("buttons");
		this.keyboard.addButtons(button1, button2);
	}

	public void setKeyboard_buttons(String btn1, String btn2, String btn3) {
		this.keyboard.setType("buttons");
		this.keyboard.addButtons(btn1, btn2, btn3);
	}

	public void setPhoto(String url, int width, int height) {
		this.message.add_photo(url, width, height);
	}
	public void setMessageBtn(String label, String url){
		this.message.add_messageBtn(label, url);
	}
}