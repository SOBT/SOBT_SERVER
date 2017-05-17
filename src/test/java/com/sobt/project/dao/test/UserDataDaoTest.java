package com.sobt.project.dao.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import sobt.dao.user.UserDao;
import sobt.dao.user.UserDataDao;
import sobt.domain.user.User;
import sobt.domain.user.UserData;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;

import static org.hamcrest.CoreMatchers.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/test-applicationContext.xml")
public class UserDataDaoTest {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired 
	UserDataDao userDataDao;
	
	
	
	private User user;
	private UserData userData1;
	private UserData userData2;
	private UserData userData3;
	
	@Before
	public void setUp(){
		user = new User("test1");
		userDao.addUser(user);
		userData1 = new UserData(user.getUserId(),"textContent", "text");
		userData2 = new UserData(user.getUserId(),"textContent", "button");
	}
	
	@After
	public void end(){
		userDao.deleteAll();
	}
	
	@Test
	public void addUserData(){
		userDataDao.addUserData(userData1);
		userDataDao.addUserData(userData2);
		
	}
	
	@Test
	public void getUserData(){
		
		userDataDao.addUserData(userData1);
		userDataDao.addUserData(userData2);
		
		List<UserData> userData = userDataDao.getUserData(user.getUserId());
		assertThat(userData.size(), is(2));
		checkSameUserData(userData.get(0),userData1);
		checkSameUserData(userData.get(1),userData2);
		
	}
	
	@Test
	public void getUserDataFailure(){
		assertThat(userDataDao.getUserData("test3").size(),is(0));
	}
	private void checkSameUserData(UserData data1, UserData data2){
		assertThat(data1.getUserId(),is(data2.getUserId()));
		assertThat(data1.getUserContent(),is(data2.getUserContent()));
		assertThat(data1.getType(),is(data2.getType()));
	}
	
	

}
