package sobt.dao.user;

import sobt.domain.user.User;
import sobt.domain.user.UserSubway;

public interface UserSubwayDao {
	public void addUserSubway(UserSubway userSubway);
	public void addUserLineNum(User user, String line_num);
	public void addUserInOut(User user, String in_out);
	public void addUserStationNm(User user, String station_nm);
	
	public UserSubway getUserSubway(String userId);
}
