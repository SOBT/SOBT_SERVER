package sobt.sql.service;

public interface SqlRegistry {
	//sql SqlRegistrty에 저장 
	public void register(String key , String value);
	//key 에 해당하는 sql 리턴 
	public String findSql(String key);
}
