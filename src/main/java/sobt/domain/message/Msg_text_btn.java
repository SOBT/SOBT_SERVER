package sobt.domain.message;

public class Msg_text_btn implements Message{
	String text;
	MessageButton message_button;
	
	public Msg_text_btn(String text, MessageButton message_button){
		this.text = text;
		this.message_button = message_button;
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
