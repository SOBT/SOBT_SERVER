package sobt.dao.user;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import sobt.domain.user.UserSubway;
import sobt.domain.user.User;
import sobt.sql.service.SqlService;

public class JdbcUserSubwayDao implements UserSubwayDao {
	private JdbcTemplate jdbcTemplate;
	private SqlService sqlService;
	private RowMapper<UserSubway> userSubwayMapper = new RowMapper<UserSubway>() {
		
		@Override
		public UserSubway mapRow(ResultSet rs, int rowNum) throws SQLException {
			UserSubway userSubway = new UserSubway();
			userSubway.setSeq(rs.getInt("seq"));
			userSubway.setLineNum(rs.getString("line_num"));
			userSubway.setInOut(rs.getString("in_out"));
			userSubway.setStationNm(rs.getString("station_nm"));
			userSubway.setUserId(rs.getString("user_id"));
			return userSubway;
		}
	};
	
	public void setDataSource(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void setSqlService(SqlService sqlService){
		this.sqlService = sqlService;
	}
	
	@Override
	public void addUserSubway(UserSubway userSubway) {
		this.jdbcTemplate.update(this.sqlService.getSql("addUserSubway"), 
				userSubway.getLineNum(), userSubway.getInOut(), userSubway.getStationNm(), userSubway.getUserId());
	}
	
	@Override
	public void addUserLineNum(User user, String line_num) {
		this.jdbcTemplate.update(this.sqlService.getSql("addUserLineNum"), line_num, user.getUserId());
	}
	
	@Override
	public void addUserInOut(User user, String in_out) {
		this.jdbcTemplate.update(this.sqlService.getSql("addUserInOut"), in_out, user.getUserId());
	}
	
	@Override
	public void addUserStationNm(User user, String station_nm) {
		this.jdbcTemplate.update(this.sqlService.getSql("addUserStationNm"), station_nm, user.getUserId());
	}
	
	@Override
	public UserSubway getUserSubway(String user_Id) {
		return this.jdbcTemplate.query(this.sqlService.getSql("getUserSubway"), new Object[] {user_Id}, this.userSubwayMapper).get(0);
	}
	

}
