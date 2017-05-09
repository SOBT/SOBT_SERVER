package com.sobt.project.sql.test;
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
		sqlRegistry.register("test", "test");
		sqlRegistry.register("test1", "test1");
		//찾기 
		assertThat(sqlRegistry.findSql("test"),is("test"));
		assertThat(sqlRegistry.findSql("test1"),is("test1"));
	}
	
	@Test
	public void sqlReaderTest(){
		sqlReader.read(sqlRegistry);
	
		assertThat(sqlRegistry.findSql("test"),is("test"));
		assertThat(sqlRegistry.findSql("test1"),is("test1"));
		
	}
	
	@Test
	public void sqlServiceTest(){
		assertThat(sqlService.getSql("test"),is("test"));
		assertThat(sqlService.getSql("test1"),is("test1"));
	}
	
}
