package sobt.user.service;

import sobt.domain.user.User;
import sobt.domain.user.UserData;
import sobt.domain.user.UserSubway;

public interface UserService {
	public void addUser(String user_id, String content, String type);
	public void updateUser(User user);
	public void addUser(User user , UserData userData);
	public void addUser(User user, UserData userData, UserSubway userSubway);
	public User getUser(String id);
	public void addUserData(UserData userData);
	
	public void addUserSubway(UserSubway userSubway);
	public void addUserLineNum(User user, String line_num);
	public void addUserInOut(User user, String in_out);
	public void addUserStationNm(User user, String station_nm);
	
	public UserSubway getUserSubway(String user_id);
	public String getUserStationNm(String user_id);
	public String getUserInOut(String user_id);
	public String getUserLineNum(String user_id);
	//public String getUserSubwayUser(String user_id);

}
