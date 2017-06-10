package sobt.dao.subway;

import java.util.List;
import java.sql.SQLException;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import sobt.domain.subway.StationData;
import sobt.sql.service.SqlService;


public class JdbcStationDataDao implements StationDataDao{
	
	private JdbcTemplate jdbcTemplate;
	private SqlService sqlService;
	private RowMapper<StationData> stationDataMapper = new RowMapper<StationData>() {
		
		@Override
		public StationData mapRow(ResultSet rs, int rowNum) throws SQLException {
			StationData stationData = new StationData();
			stationData.setStationCode(rs.getString("STATION_CODE"));
			stationData.setStationNm(rs.getString("STATION_NM"));
			stationData.setLineNum(rs.getString("LINE_NUM"));
			stationData.setFRCode(rs.getString("FRCODE"));		
			return stationData;
		}
	};
	
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void setSqlService(SqlService sqlService) {
		this.sqlService = sqlService;
	}
	
	@Override
	public void addStationData(StationData stationData) {
		this.jdbcTemplate.update(this.sqlService.getSql("addStationData"), stationData.getStationNm(),
				stationData.getStationCode(), stationData.getFRCode(), stationData.getLineNum());
	}

	@Override
	public List<StationData> getStationData(String STATION_NM, String LINE_NUM ) {
		return this.jdbcTemplate.query(this.sqlService.getSql("getStationData"), new Object[] {STATION_NM,LINE_NUM}, this.stationDataMapper);
	}
	
	public String getStationFRCode(String STATION_NM, String LINE_NUM) {
		return this.jdbcTemplate.queryForObject(this.sqlService.getSql("getStationFRCode"), new Object[] {STATION_NM, LINE_NUM}, String.class);
	}

}
