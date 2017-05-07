package com.sobt.domain;

import java.util.List;
import org.springframework.stereotype.Component;

public class Keyboard {
	private String type;
	private List<String> buttons;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<String> getButtons() {
		return buttons;
	}

	public void setButtons(List<String> buttons) {
		this.buttons = buttons;
	}
}
