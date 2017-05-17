package sobt.domain.message;

public class Msg_text_photo_btn implements Message {
	String text;
	MessageButton message_button;
	Photo photo;

	public Msg_text_photo_btn(String text, MessageButton message_button, Photo photo) {
		this.text = text;
		this.message_button = message_button;
		this.photo = photo;
	}

	public Photo getPhoto() {
		return photo;
	}

	public void setPhoto(Photo photo) {
		this.photo = photo;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public MessageButton getMessage_button() {
		return message_button;
	}

	public void setMessage_button(MessageButton message_button) {
		this.message_button = message_button;
	}
}
