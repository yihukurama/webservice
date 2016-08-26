package com.yihukurama.websercice;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.yihukurama.websercice.wechat.lovebanks.LoveBanksMain;
import com.yihukurama.websercice.wechat.lovebanks.web.RefreshTokenController;

import static org.hamcrest.Matchers.equalTo;  
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;  
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class AppTest
{
	private MockMvc mvc;
	private MockMvc mvc2;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new LoveBanksMain()).build();
        mvc2 = MockMvcBuilders.standaloneSetup(new RefreshTokenController()).build();
    }

    @Test
    public void loveBanksMain() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/lovemain").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Welcome to my weixin home!")));
    }
    
    @Test
    public void testRefreshToken() throws Exception {
    
        mvc2.perform(MockMvcRequestBuilders.get("/refreshtoken?pwd=dengshuai@123").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("refresh token done!")));
    }
}
