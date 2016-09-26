package com.yihukurama.websercice.wechat.yunst;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yihukurama.websercice.wechat.yunst.common.Constant;
import com.yihukurama.websercice.wechat.yunst.common.WeChatUtils;


/**
 * 
 * 功能描述: 微信认证入口基类
 * @Author:dengshuai
 * @Date:2016年9月22日 上午9:48:30
 */
public class WeChatBase {
	private Logger logger = Logger.getLogger(WeChatBase.class);
	
    protected String wetChatHome(
		@RequestParam(value="echostr", required=false, defaultValue="null") String echostr,
		@RequestParam(value="timestamp", required=false, defaultValue="null") String timestamp,
		@RequestParam(value="nonce", required=false, defaultValue="null") String nonce,
		@RequestParam(value="encrypt", required=false, defaultValue="null") String encrypt,
		@RequestParam(value="signature", required=false, defaultValue="null") String signature,
		@RequestBody(required=false)String requestBody) {
	String response = "Hello weixin!";
	
	if(echostr.equals("null")){//已认证通过，进入响应方法
		logger.info("微信服务器已认证通过，进入响应方法");
		
	}else{//基础认证
		logger.info("进行微信服务器认证");
		String checkResult = WeChatUtils.check(Constant.TOKEN, timestamp, nonce);
		if(signature.equals(checkResult)){
			logger.info("微信服务器通过认证，按要求返回echostr");
			response = echostr;
		}
	}
	
        return response;
    }

}
