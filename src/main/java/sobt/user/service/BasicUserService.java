package sobt.user.service;

import sobt.dao.user.UserDao;
import sobt.dao.user.UserDataDao;
import sobt.dao.user.UserSubwayDao;
import sobt.domain.user.User;
import sobt.domain.user.UserData;
import sobt.domain.user.UserSubway;

public class BasicUserService implements UserService{

	private UserDao userDao;
	private UserDataDao userDataDao;
	private UserSubwayDao userSubwayDao;
	
	public void setUserDao(UserDao userDao){
		this.userDao = userDao;
	}
	public void setUserDataDao(UserDataDao userDataDao){
		this.userDataDao = userDataDao;
	}
	public void setUserSubwayDao(UserSubwayDao userSubwayDao) {
		this.userSubwayDao = userSubwayDao;
	}
	
	@Override
	public void addUser(String user_id, String content, String type) {
		// TODO Auto-generated method stub
		User user = new User(user_id);
		UserData userData = new UserData(user_id,content,type);
		//UserSubway userSubway = new UserSubway(user_id);
		
		userDao.addUser(user);
		userDataDao.addUserData(userData);
		//userSubwayDao.addUserSubway(userSubway);
		
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
	public void addUser(User user, UserData userData, UserSubway userSubway) {
		// TODO Auto-generated method stub
		userDao.addUser(user);
		userDataDao.addUserData(userData);	
		userSubwayDao.addUserSubway(userSubway);
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
	
	@Override
	public void addUserSubway(UserSubway userSubway) {
		userSubwayDao.addUserSubway(userSubway);
	}
	
	@Override
	public void addUserLineNum(User user, String line_num) {
		userSubwayDao.addUserLineNum(user, line_num);
	}
	
	@Override
	public void addUserInOut(User user, String in_out) {
		userSubwayDao.addUserInOut(user, in_out);
	}
	
	@Override
	public void addUserStationNm(User user, String station_nm) {
		userSubwayDao.addUserStationNm(user, station_nm);
	}
	
	@Override
	public UserSubway getUserSubway(String user_id) {
		return userSubwayDao.getUserSubway(user_id);
	}
	
	@Override
	public String getUserStationNm(String user_id) {
		return userSubwayDao.getUserSubway(user_id).getStationNm();
	}
	@Override
	public String getUserInOut(String user_id) {
		return userSubwayDao.getUserSubway(user_id).getInOut();
	}
	
	@Override
	public String getUserLineNum(String user_id) {
		return userSubwayDao.getUserSubway(user_id).getLineNum();
	}
	
	
}
