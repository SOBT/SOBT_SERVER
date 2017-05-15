package sobt.domain.message;

public class Msg_text_photo implements Message{
	String text;
	Photo photo;
	public Msg_text_photo(String text, Photo photo){
		this.text = text;
		this.photo = photo;
	}
	
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
}
