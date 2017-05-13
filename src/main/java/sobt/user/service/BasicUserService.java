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

}