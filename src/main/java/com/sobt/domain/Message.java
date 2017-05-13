package com.sobt.domain;

public class Message {
	String text;
	Photo photo;
	MessageButton messageButton;
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
	public MessageButton getMessageButton() {
		return messageButton;
	}
	public void setMessageButton(MessageButton messageButton) {
		this.messageButton = messageButton;
	}
	// ==================================================
}