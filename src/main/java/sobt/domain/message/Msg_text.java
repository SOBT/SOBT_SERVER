package sobt.domain.message;

public class Msg_text implements Message{
	String text;
	
	public Msg_text(String text){
		this.text = text;
	}
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
