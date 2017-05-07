package sobt.sql.service;

public interface SqlReader {
	//xml의 sql을 읽어와  SqlRegistry객체에 저장
	public void read(SqlRegistry sqlRegistry);
}
