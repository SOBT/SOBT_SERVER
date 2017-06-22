package com.sobt.project.api.subway.test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sobt.sql.service.SqlReader;
import sobt.sql.service.SqlRegistry;
import sobt.sql.service.SqlService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/test-applicationContext.xml")
public class SqlServiceTest {
	
	@Autowired
	SqlRegistry sqlRegistry;
	
	@Autowired
	SqlReader sqlReader;
	
	@Autowired
	SqlService sqlService;
	
	@Test
	public void sqlRegistryTest(){
		//등록 
		sqlRegistry.register("addUserLineNum", "UPDATE USER_SUBWAY SET LINE_NUM = ? WHERE USER_ID = ? ");
		sqlRegistry.register("getStationData", "SELECT STATION_CODE STATION_CODE, STATION_NM STATION_NM, LINE_NUM LINE_NUM, FRCODE FRCODE FROM STATION_DATA WHERE STATION_NM = ? AND LINE_NUM = ? ");
		//sqlRegistry.register("test", "test");
		//찾기 
		assertThat(sqlRegistry.findSql("addUserLineNum"),is("UPDATE USER_SUBWAY SET LINE_NUM = ? WHERE USER_ID = ? "));
		assertThat(sqlRegistry.findSql("getStationData"),is("SELECT STATION_CODE STATION_CODE, STATION_NM STATION_NM, LINE_NUM LINE_NUM, FRCODE FRCODE FROM STATION_DATA WHERE STATION_NM = ? AND LINE_NUM = ? "));
	}
	
	@Test
	public void sqlReaderTest(){
		sqlReader.read(sqlRegistry);
	
		assertThat(sqlRegistry.findSql("addUserLineNum"),is("UPDATE USER_SUBWAY SET LINE_NUM = ? WHERE USER_ID = ? "));
		assertThat(sqlRegistry.findSql("getStationData"),is("SELECT STATION_CODE STATION_CODE, STATION_NM STATION_NM, LINE_NUM LINE_NUM, FRCODE FRCODE FROM STATION_DATA WHERE STATION_NM = ? AND LINE_NUM = ? "));
		
	}
	
	@Test
	public void sqlServiceTest(){
		assertThat(sqlService.getSql("addUserLineNum"),is("UPDATE USER_SUBWAY SET LINE_NUM = ? WHERE USER_ID = ? "));
		assertThat(sqlService.getSql("getStationData"),is("SELECT STATION_CODE STATION_CODE, STATION_NM STATION_NM, LINE_NUM LINE_NUM, FRCODE FRCODE FROM STATION_DATA WHERE STATION_NM = ? AND LINE_NUM = ? "));
	}
	
}
