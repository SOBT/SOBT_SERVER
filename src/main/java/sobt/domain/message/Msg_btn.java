package sobt.domain.message;

public class Msg_btn implements Message {
	MessageButton message_button;
	
	public Msg_btn(MessageButton message_button){
		this.message_button = message_button;
	}

	public MessageButton getMessage_button() {
		return message_button;
	}

	public void setMessage_button(MessageButton message_button) {
		this.message_button = message_button;
	}
}
