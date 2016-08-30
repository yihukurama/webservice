package com.yihukurama.websercice.wechat.lovebanks.web;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wilddog.client.Wilddog;
import com.yihukurama.websercice.sdk.KeyValueDB;
import com.yihukurama.websercice.utils.JsonUtil;
import com.yihukurama.websercice.utils.http.HttpClientUtil;
import com.yihukurama.websercice.wechat.common.entity.AccessToken;
import com.yihukurama.websercice.wechat.house.domain.Constants;

/**
 * 更新accesstoken
 * @author dengshuai
 *
 */
@RestController
public class RefreshTokenController {
	private static Wilddog ref = new Wilddog("https://lovebank.wilddogio.com");
	private Logger logger = Logger.getLogger(RefreshTokenController.class);
	//刷新微信token
    @RequestMapping("/refreshtoken")
    public String index(@RequestParam(value="pwd", required=true) String pwd) {
        if(pwd!=null && pwd.equals("dengshuai@123")){
        		//刷新微信token并存入野狗
        		String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s";
        		url = String.format(url, Constants.APPID,Constants.APPSECRET);
        		String response = HttpClientUtil.doGet(url);
        		logger.info("刷新的lovebanks微信token是："+response);
        		
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
        	return "param error!";
    }
    
}
