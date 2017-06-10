package sobt.user.service;



import sobt.dao.user.UserDao;
import sobt.dao.user.UserDataDao;
import sobt.domain.user.User;
import sobt.domain.user.UserData;

public class BasicUserService implements UserService{

	private UserDao userDao;
	private UserDataDao userDataDao;
	
	public void setUserDao(UserDao userDao){
		this.userDao = userDao;
	}
	public void setUserDataDao(UserDataDao userDataDao){
		this.userDataDao = userDataDao;
	}
	@Override
	public void addUser(String user_id, String content, String type) {
		// TODO Auto-generated method stub
		User user = new User(user_id);
		UserData userData = new UserData(user_id,content,type);
		
		userDao.addUser(user);
		userDataDao.addUserData(userData);
		
	}
	@Override
	public User getUser(String id) {
		// TODO Auto-generated method stub
		return userDao.getUser(id);
	}
	@Override
	public void addUser(User user, UserData userData) {
		// TODO Auto-generated method stub
		userDao.addUser(user);
		userDataDao.addUserData(userData);
		
	}
	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userDao.updateUser(user);
	}
	@Override
	public void addUserData(UserData userData) {
		// TODO Auto-generated method stub
		userDataDao.addUserData(userData);
		
	}

}
