package com.sobt.project.chat.test;


import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sobt.domain.KakaoUser;

import sobt.chat.template.ChatCallback;
import sobt.chat.template.ChatResult;
import sobt.chat.template.ChatTemplate;
import sobt.dao.user.UserDao;
import sobt.domain.message.MessageVo;
import sobt.domain.user.User;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/test-applicationContext.xml")
public class ChatTemplateTest {
	
	@Autowired
	ChatTemplate chatTemplate;
	
	KakaoUser kakaoUser;
	
	@Before
	public void setUp(){
		kakaoUser = new KakaoUser();
		kakaoUser.setContent("테스트");
		kakaoUser.setType("button");
		kakaoUser.setUser_key("test1");
	}
	
	@Test
	public void doChatProcessExceptioTest(){
		MessageVo messageVo = chatTemplate.doChatProcess(kakaoUser);		
		assertThat(messageVo,notNullValue());
	}
}
