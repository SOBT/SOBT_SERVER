package sobt.dao.subway;

import sobt.domain.subway.StationData;
import java.util.List;

public interface StationDataDao {
	public void addStationData(StationData station);
	public List<StationData> getStationData(String STATION_NM, String LINE_NUM);
	public String getStationFRCode(String STATION_NM, String LINE_NUM);
			
}
