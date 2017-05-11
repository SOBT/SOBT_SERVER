package com.sobt.domain;

import org.springframework.beans.factory.annotation.Autowired;

public class Message {
	String text;
	@Autowired
	private Photo photo;
	@Autowired
	private MessageButton message_button;

	// ================ Spring 메소드 ===================
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Photo getPhoto() {
		return photo;
	}

	public void setPhoto(Photo photo) {
		this.photo = photo;
	}

	public MessageButton getMessage_button() {
		return message_button;
	}

	public void setMessage_button(MessageButton messageButton) {
		this.message_button = messageButton;
	}

	// ==================================================
	public void add_photo(String url, int width, int height) {
		this.photo.setUrl(url);
		this.photo.setHeight(height);
		this.photo.setWidth(width);
	}

	public void add_messageBtn(String label, String url) {
		this.message_button.setLabel(label);
		this.message_button.setUrl(url);
	}
}