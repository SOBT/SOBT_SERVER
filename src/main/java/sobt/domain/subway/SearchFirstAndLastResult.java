package sobt.domain.subway;

import java.util.List;

public class SearchFirstAndLastResult {
	List<SearchFirstAndLastInfo> row;
	ResponseResult RESULT;
	int list_total_count;
	
	public ResponseResult getResult() {
		return RESULT;
	}
	
	public List<SearchFirstAndLastInfo> getRow() {
		return row;
	}
	
	public int getListTotalCount() {
		return list_total_count;
	}
	
}
