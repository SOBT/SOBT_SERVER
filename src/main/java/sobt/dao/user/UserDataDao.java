package sobt.dao.user;

import java.util.List;

import sobt.domain.user.UserData;

public interface UserDataDao {
	public void addUserData(UserData userData);
	public List<UserData> getUserData(String userId);
}
