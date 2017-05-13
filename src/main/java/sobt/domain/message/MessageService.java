package sobt.domain.message;

public interface MessageService{
	public Message makeMessage(String text, String photo_url, int width, int height, String msg_btn, String msg_btn_url);
	public Message makeMessage(String text, String photo_url, int width, int height);
	public Message makeMessage(String photo_url, int width, int height);
	public Message makeMessage(String text);
}
