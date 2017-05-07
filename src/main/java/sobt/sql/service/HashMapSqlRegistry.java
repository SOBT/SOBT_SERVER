package sobt.sql.service;

import java.util.HashMap;
import java.util.Map;

import sobt.sql.service.exception.SqlNotFoundException;

public class HashMapSqlRegistry implements SqlRegistry {
	private Map<String,String> sqlmap = new HashMap<String,String>();
	
	@Override
	//Map에 sql저장.
	public void register(String key, String value) {
		// TODO Auto-generated method stub
		sqlmap.put(key, value);
	}

	@Override
	//key에 해당하는 sql이 있을경우 return 
	public String findSql(String key) {
		// TODO Auto-generated method stub
		String sql = sqlmap.get(key);
		if(sql == null){
			throw new SqlNotFoundException(key +"에 해당하는 sql을 찾을 수 없습니다");
		}
		return sql;
	}

}
