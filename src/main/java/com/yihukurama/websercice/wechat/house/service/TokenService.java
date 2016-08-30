package com.yihukurama.websercice.wechat.house.service;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.wilddog.client.Wilddog;
import com.yihukurama.websercice.sdk.KeyValueDB;
import com.yihukurama.websercice.utils.JsonUtil;
import com.yihukurama.websercice.utils.http.HttpClientUtil;
import com.yihukurama.websercice.wechat.common.entity.AccessToken;
import com.yihukurama.websercice.wechat.house.domain.Constants;
@Component
public class TokenService {
	
	private static Wilddog ref = new Wilddog("https://houserent.wilddogio.com");
	private Logger logger = Logger.getLogger(TokenService.class);
	//token72小时过期重新获取
	@Scheduled(fixedRate = 259000000)
	public String refreshToken(){
		//刷新微信token并存入野狗
		String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s";
		url = String.format(url, Constants.APPID,Constants.APPSECRET);
		String response = HttpClientUtil.doGet(url);
		logger.info("刷新的houserent微信token是："+response);
		
		try {
			AccessToken aT = JsonUtil.jsonToBean(response, AccessToken.class);
			Constants.accessToken = aT.getAccess_token();
			KeyValueDB.saveValue(ref.child("WeiXin").child("Response").child("AccessToken"), aT);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "refresh token done!";
	}
}
