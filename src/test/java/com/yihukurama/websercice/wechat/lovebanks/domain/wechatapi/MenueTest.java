package com.yihukurama.websercice.wechat.lovebanks.domain.wechatapi;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MenueTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateMenue() {
		LoveMenue menue = new LoveMenue();
		menue.createMenue();
	}

}
