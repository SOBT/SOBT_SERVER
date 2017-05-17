package sobt.domain.message;

public class MessageServiceImpl implements MessageService {

	@Override
	public Message makeMessage(String text, String photo_url, int width, int height, String msg_label, String msg_url) {
		// TODO Auto-generated method stub
		Photo photo = new Photo();
		photo.setHeight(height);
		photo.setWidth(width);
		photo.setUrl(photo_url);
		
		MessageButton msg_btn = new MessageButton();
		msg_btn.setLabel(msg_label);
		msg_btn.setUrl(msg_url);
		
		Message message = new Msg_text_photo_btn(text, msg_btn, photo);
		return message; 
	}
	
	public Message makeMessage(String text, String photo_url, int width, int height) {
		// TODO Auto-generated method stub
		Photo photo = new Photo();
		photo.setHeight(height);
		photo.setWidth(width);
		photo.setUrl(photo_url);
		Message message = new Msg_text_photo(text, photo);
		return message;
	}
	
	
	public Message makeMessage(String text, String msg_label, String msg_url) {
		// TODO Auto-generated method stub
		MessageButton msg_btn = new MessageButton();
		msg_btn.setLabel(msg_label);
		msg_btn.setUrl(msg_url);
		Message message = new Msg_text_btn(text, msg_btn);
		return message;
	}
	
	public Message makeMessage(String photo_url, int width, int height, String msg_label, String msg_url){
		Photo photo = new Photo();
		photo.setHeight(height);
		photo.setWidth(width);
		photo.setUrl(photo_url);
		
		MessageButton msg_btn = new MessageButton();
		msg_btn.setLabel(msg_label);
		msg_btn.setUrl(msg_url);
		Message message = new Msg_photo_btn(photo, msg_btn);
		
		return message;
	}
	
	public Message makeMessage(String photo_url, int width, int height) {
		// TODO Auto-generated method stub
		Photo photo = new Photo();
		photo.setHeight(height);
		photo.setWidth(width);
		photo.setUrl(photo_url);
		Message message = new Msg_photo(photo);
		return message; 
	}
	
	public Message makeMessage(String text) {
		// TODO Auto-generated method stub
		Message message = new Msg_text(text);
		return message;
	}
	
	public Message makeMessage(String msg_label, String msg_url) {
		// TODO Auto-generated method stub
		MessageButton msg_btn = new MessageButton();
		msg_btn.setLabel(msg_label);
		msg_btn.setUrl(msg_url);
		Message message = new Msg_btn(msg_btn);
		return message;
	}
	
	public Keyboard makeKeyboard(String btn1){
		Keyboard keyboard = new Keyboard();
		keyboard.addButton(btn1);
		keyboard.setType("buttons");
		return keyboard;
	}
	public Keyboard makeKeyboard(String btn1, String btn2){
		Keyboard keyboard = new Keyboard();
		keyboard.addButton(btn1);
		keyboard.addButton(btn2);
		keyboard.setType("buttons");
		return keyboard;
	}
	public Keyboard makeKeyboard(String btn1, String btn2, String btn3){
		Keyboard keyboard = new Keyboard();
		keyboard.addButton(btn1);
		keyboard.addButton(btn2);
		keyboard.addButton(btn3);
		keyboard.setType("buttons");
		return keyboard;
	}
}
