package sobt.sql.service;

import java.io.IOException;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.oxm.Unmarshaller;

import sobt.sql.service.jaxb.SqlType;
import sobt.sql.service.jaxb.Sqlmap;

public class OxmSqlReader implements SqlReader {
	
	private Unmarshaller unmarshaller;
	private Resource sqlmap = new ClassPathResource("sqlmap.xml");
	
	public void setUnmarshaller(Unmarshaller unmarshaller){
		this.unmarshaller = unmarshaller;
	}
	
	
	@Override
	//xml의 sql을 읽어온다.
	public void read(SqlRegistry sqlRegistry) {
		// TODO Auto-generated method stub
		try{
			//xml Source Stream 생성.
			Source source  = new StreamSource(sqlmap.getInputStream());
			//unmarShall 작업 진행(xml->java object)
			Sqlmap sqlmap = (Sqlmap)this.unmarshaller.unmarshal(source);
			
			//sqlRegistry 객체에 sql 저장.
			for(SqlType sql : sqlmap.getSql()){
				sqlRegistry.register(sql.getKey(), sql.getValue());
			}
		}catch(Exception e){
			new IllegalArgumentException(this.sqlmap.getFilename() + "을 가지고 올 수 없습니다.");
		}
	}

}
