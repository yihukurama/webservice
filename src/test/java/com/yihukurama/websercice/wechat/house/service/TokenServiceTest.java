package com.yihukurama.websercice.wechat.house.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.yihukurama.websercice.wechat.house.service.scheduled.TokenService;

public class TokenServiceTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		TokenService tokenService = new TokenService();
		String result = tokenService.refreshToken();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(!result.equals("refresh token done!")){
			fail("error");
		};
	}

}
