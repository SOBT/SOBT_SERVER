package sobt.dao.user;

import java.util.List;

import sobt.domain.user.User;
import sobt.domain.user.UserSubway;

public interface UserSubwayDao {
	public void addUserSubway(UserSubway userSubway);
	public void addUserLineNum(User user, String line_num);
	public void addUserInOut(User user, String in_out);
	public void addUserStationNm(User user, String station_nm);
	
	public List<UserSubway> getUserSubway(String userId);
}
