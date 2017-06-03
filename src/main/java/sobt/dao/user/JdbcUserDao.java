package sobt.dao.user;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import sobt.domain.user.Status;
import sobt.domain.user.SubStatus;
import sobt.domain.user.User;
import sobt.sql.service.SqlService;

public class JdbcUserDao implements UserDao {
	private JdbcTemplate jdbcTemplate;
	private SqlService sqlService;
	
	private RowMapper<User> userMapper = new RowMapper<User>(){

		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			User user = new User();
			user.setUserId(rs.getString("user_id"));
			user.setStatus(Status.valueOf(rs.getInt("status")));
			user.setSubStatus(SubStatus.valueOf(rs.getInt("sub_status")));
			return user;
		}};
	
	public void setDataSource(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void setSqlService(SqlService sqlService){
		this.sqlService = sqlService;
	}
	
	
	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		try{
			this.jdbcTemplate.update(this.sqlService.getSql("addUser"),user.getUserId());
		}catch(DuplicateKeyException e){
			//log 처리 
		}
		
	}

	@Override
	public User getUser(String userId) {
		// TODO Auto-generated method stub
		try{
			return this.jdbcTemplate.queryForObject(this.sqlService.getSql("getUser"),new Object[]{userId},this.userMapper);
		}catch(EmptyResultDataAccessException e){
			//데이터가 없을경우 처
			return null; 
		}
		
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return this.jdbcTemplate.query(this.sqlService.getSql("getCount"), new ResultSetExtractor<Integer>(){

			@Override
			public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				rs.next();
				return rs.getInt(1);
			}});
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update(this.sqlService.getSql("deleteAll"));
		
	}

}
