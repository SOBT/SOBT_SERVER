package sobt.dao.weather;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import sobt.domain.user.UserData;
import sobt.domain.weather.WeatherData;
import sobt.sql.service.SqlService;

public class JdbcWeatherDataDao implements WeatherDataDao{

	private JdbcTemplate jdbcTemplate;
	private SqlService sqlService;
	private RowMapper<WeatherData> userDataMapper = new RowMapper<WeatherData>(){

		@Override
		public WeatherData mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			WeatherData weatherData = new WeatherData();
			weatherData.setDate(rs.getString("WEATHER_DATE"));
			weatherData.setSentence(rs.getString("WEATHER_INFO"));;
			return weatherData;
		}
		
	};

	public void setDataSource(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void setSqlService(SqlService sqlService){
		this.sqlService = sqlService;
	}
	
	
	@Override
	public void addWeather(WeatherData weatherData) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update(this.sqlService.getSql("addWeatherData"),weatherData.getDate(), weatherData.getSentence());
		
	}

	@Override
	public WeatherData getWeather(String date) {
		return this.jdbcTemplate.queryForObject(this.sqlService.getSql("getWeatherData"),new Object[] {date},this.userDataMapper);
	}
	
}
