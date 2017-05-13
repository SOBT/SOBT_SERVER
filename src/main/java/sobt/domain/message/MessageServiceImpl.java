package sobt.domain.message;

import com.sobt.domain.Photo;

public class MessageServiceImpl implements MessageService {

	@Override
	public Message makeMessage(String text, String photo_url, int width, int height, String msg_btn, String msg_btn_url) {
		// TODO Auto-generated method stub
		Message message = new Msg_text(text);
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
}
