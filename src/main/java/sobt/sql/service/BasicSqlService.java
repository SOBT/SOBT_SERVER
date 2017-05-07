package sobt.sql.service;

import javax.annotation.PostConstruct;

import sobt.sql.service.exception.SqlNotFoundException;

public class BasicSqlService implements SqlService {

	private SqlReader sqlReader;
	private SqlRegistry sqlRegistry;
	
	public void setSqlReader(SqlReader sqlReader){
		this.sqlReader = sqlReader;
	}
	
	public void setSqlRegistry(SqlRegistry sqlRegistry){
		this.sqlRegistry = sqlRegistry;
	}
	
	
	@Override
	@PostConstruct
	//객체생성고 동시에 xml 
	public void loadSql() {
		// TODO Auto-generated method stub
		sqlReader.read(this.sqlRegistry);
	}

	@Override
	//sql Return
	public String getSql(String key) {
		// TODO Auto-generated method stub
		try{
			String sql = this.sqlRegistry.findSql(key); 
			return sql;
		}catch(SqlNotFoundException e){
			throw new SqlNotFoundException(e);
		}
	}

}
