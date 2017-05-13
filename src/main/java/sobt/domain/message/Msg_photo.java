package sobt.domain.message;

import com.sobt.domain.Photo;

public class Msg_photo implements Message {
	Photo photo;
	
	public Msg_photo(Photo photo){
		this.photo = photo;
	}
	
	public Photo getPhoto() {
		return photo;
	}

	public void setPhoto(Photo photo) {
		this.photo = photo;
	}
	
}
