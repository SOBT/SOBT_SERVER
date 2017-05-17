package sobt.domain.message;

public class Msg_photo_btn implements Message {
	Photo photo;
	MessageButton message_button;

	public Msg_photo_btn(Photo photo, MessageButton message_button) {
		this.message_button = message_button;
		this.photo = photo;
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

	public void setMessage_button(MessageButton message_button) {
		this.message_button = message_button;
	}
}
