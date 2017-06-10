package com.sobt.project.api.subway.test;
import static org.junit.Assert.*;
import java.util.Date;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sobt.api.manage.*;
import sobt.http.service.HttpService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/test-applicationContext.xml")
public class SubwayServiceTest {
	//@Autowired
	//private HttpService httpService;
	@Autowired
	private SubwayAPIManager subwayApimanager;
	
	@Test
	public void SubwayServiceTest() throws UnsupportedEncodingException{
		System.out.println(subwayApimanager.getFirstAndLast("json", "1", 1, 2, "소요산"));
		//System.out.println(subwayApimanager.getFirstAndLast("json", "4", 1, 2, "노원"));
		//System.out.println(subwayApimanager.getRealTimeArrival("json", "신이문"));
		//System.out.println(subwayApimanager.getRealTimeArrival("json","상계"));
		//Date date = new Date();
		//System.out.println(date.getDay());
	}
	

}
