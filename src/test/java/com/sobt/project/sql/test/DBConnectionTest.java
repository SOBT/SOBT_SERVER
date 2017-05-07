package com.sobt.project.sql.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.*;

import javax.sql.DataSource;

import static org.hamcrest.CoreMatchers.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/test-applicationContext.xml")
public class DBConnectionTest {
	@Autowired
	DataSource dataSource;
	
	@Test
	public void getConnection() throws SQLException{
		assertThat(dataSource,nullValue());
	}
}
