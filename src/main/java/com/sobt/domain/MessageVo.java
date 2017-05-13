package com.sobt.domain;

import org.springframework.beans.factory.annotation.Autowired;

import sobt.domain.message.Keyboard;
import sobt.domain.message.Message;

/**
 * 응답 객체 ( Response object )
 * 
 * @author namwoo
 * @method setKeyboard_buttons : 버튼 입력 방식
 */
public class MessageVo {
	private Message message;
	private Keyboard keyboard;

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
}