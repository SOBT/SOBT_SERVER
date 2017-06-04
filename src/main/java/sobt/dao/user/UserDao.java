package sobt.dao.user;

import sobt.domain.user.User;

public interface UserDao {
	//유저등록 
	public void addUser(User user);
	public User getUser(String userId);
	public void updateUser(User user);
	
	
	//테스트용..
	public int getCount();
	public void deleteAll();
}
