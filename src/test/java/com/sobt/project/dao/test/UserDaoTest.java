package com.sobt.project.dao.test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sobt.dao.user.UserDao;
import sobt.domain.user.User;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/test-applicationContext.xml")
public class UserDaoTest {
	
	@Autowired
	UserDao userDao;
	
	User user1;
	User user2;
	User user3;
	
	@Before
	public void setUp(){
		userDao.deleteAll();
		user1 = new User("testUser1");
		user2 = new User("testUser2");
		user3 = new User("testUser3");
		user1.setDefaultStatus();
		user2.setDefaultStatus();
		user3.setDefaultStatus();
	}
	
	@Test
	public void addUser(){
		assertThat(userDao.getCount(), is(0));
		
		userDao.addUser(user1);
		assertThat(userDao.getCount(), is(1));
		
		userDao.addUser(user2);
		assertThat(userDao.getCount(), is(2));
		
		userDao.addUser(user3);
		assertThat(userDao.getCount(), is(3));
		
	}
	
	@Test
	public void getUser(){
		assertThat(userDao.getCount(), is(0));
		
		userDao.addUser(user1);
		assertThat(userDao.getCount(), is(1));
		
		userDao.addUser(user2);
		assertThat(userDao.getCount(), is(2));
		
		userDao.addUser(user3);
		assertThat(userDao.getCount(), is(3));
		
		User getUser1 = userDao.getUser(user1.getUserId());
		checkSameUser(user1,getUser1);
		
		User getUser2 = userDao.getUser(user2.getUserId());
		checkSameUser(user2,getUser2);
		
		User getUser3 = userDao.getUser(user3.getUserId());
		checkSameUser(user3,getUser3);
		
		
	}
	
	private void checkSameUser(User user1 , User user2){
		assertThat(user1.getUserId(),is(user2.getUserId()));
	}
	
	
	@Test//(expected=DuplicateKeyException.class)
	public void addUserDuplicatekeyException(){
		userDao.addUser(user1);
		userDao.addUser(user1);
	}
	
	@Test
	public void addUserDuple(){
		userDao.addUser(user1);
		userDao.addUser(user1);
	}
	
	@Test
	public void getUserNotResut(){
		User user = userDao.getUser("1");
		assertThat(user, nullValue());
	}

}
