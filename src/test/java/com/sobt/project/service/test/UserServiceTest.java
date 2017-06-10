package com.sobt.project.service.test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sobt.domain.user.User;
import sobt.domain.user.UserData;
import sobt.user.service.UserService;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/test-applicationContext.xml")
public class UserServiceTest {

	
	@Autowired
	private UserService userService;
	
	private User user;
	private UserData userData1;
	private UserData userData2;
	private UserData userData3;
	
	@Before
	public void setUp(){
		user = new User("test1");
		userData1 = new UserData(user.getUserId(),"textContent", "text");
		userData2 = new UserData(user.getUserId(),"textContent", "button");
	}
	
	
	@Test
	public void addUser(){
		userService.addUser(user.getUserId(), userData1.getUserContent(), userData1.getType());
		userService.addUser(user.getUserId(), userData2.getUserContent(), userData2.getType());
	}
	
	@Test
	public void getNullUser(){
		assertThat(userService.getUser("1"),nullValue());
	}
}
