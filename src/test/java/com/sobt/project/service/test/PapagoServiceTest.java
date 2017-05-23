package com.sobt.project.service.test;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sobt.http.service.HttpService;
import sobt.translate.service.PapagoService;
import sobt.translate.service.Translate;
import sobt.translate.service.TranslateService;

import static org.hamcrest.CoreMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/test-applicationContext.xml")
public class PapagoServiceTest {
	
	@Autowired
	HttpService urlHttpService;
	
	@Autowired
	TranslateService translateService;
	@Test
	public void doHttpGetTest(){
		System.out.println(urlHttpService.doHttpGet("http://localhost:8080/project/keyboard"));
	}
	
	@Test
	public void doHttpPostByJsonTest(){
		Map<String, String> param = new HashMap<String,String>();
		param.put("user_key", "encryptedUserKey");
		param.put("type", "text");
		param.put("content", "날씨 정보");
		System.out.println(urlHttpService.doHttpPostByJson("http://localhost:8080/project/message",param));
	}
	
	@Test
	public void translateTest(){
		System.out.println(translateService.translateSentence(Translate.KO_TO_CN, "만나서 반갑습니다."));
	}
}
