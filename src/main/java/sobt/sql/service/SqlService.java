package sobt.sql.service;

public interface SqlService {
	//객체생성과 동시에 xml에서 sql 정보 Load 
	public void loadSql();
	// key해당하는 sql 반환 
	public String getSql(String key);
}
