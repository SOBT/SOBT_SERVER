package sobt.user.service;

import sobt.domain.user.User;
import sobt.domain.user.UserData;

public interface UserService {
	public void addUser(String user_id, String content, String type);
	public void addUser(User user , UserData userData);
	public User getUser(String id);

}
