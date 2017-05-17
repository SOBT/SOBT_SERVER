package sobt.dao.user;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import sobt.domain.user.UserData;
import sobt.sql.service.SqlService;

public class JdbcUserDataDao implements UserDataDao {
	
	
	private JdbcTemplate jdbcTemplate;
	private SqlService sqlService;
	private RowMapper<UserData> userDataMapper = new RowMapper<UserData>(){

		@Override
		public UserData mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			UserData userData = new UserData();
			userData.setSeq(rs.getInt("seq"));
			userData.setUserId(rs.getString("user_Id"));
			userData.setUserContent(rs.getString("user_content"));
			userData.setType(rs.getString("type"));
			userData.setRgDt(rs.getString("rg_dt"));
			return userData;
		}
		
	};
	
	public void setDataSource(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void setSqlService(SqlService sqlService){
		this.sqlService = sqlService;
	}
	
	@Override
	public void addUserData(UserData userData) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update(this.sqlService.getSql("addUserData"),userData.getUserId(),userData.getUserContent()
				, userData.getType());
		
		
	}

	@Override
	public List<UserData> getUserData(String userId) {
		// TODO Auto-generated method stub
		return this.jdbcTemplate.query(this.sqlService.getSql("getUserData"),new Object[] {userId},this.userDataMapper);
	
	}

}
