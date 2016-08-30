package com.yihukurama.websercice.wechat.house;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yihukurama.websercice.wechat.common.CommonFunction;
import com.yihukurama.websercice.wechat.house.domain.HouseConstants;
import com.yihukurama.websercice.wechat.house.service.HouseResponse;


/**
 * 碧怡房产中介公众号主入口
 * @author dengshuai
 *
 */
@RestController
public class HouseMain {

	private Logger logger = Logger.getLogger(HouseMain.class);
	HouseResponse houseResponse;
	public HouseMain(){
		houseResponse = new HouseResponse();
	}
	
	@RequestMapping("/housemain")
        String wetChatHome(
    		@RequestParam(value="echostr", required=false, defaultValue="null") String echostr,
    		@RequestParam(value="timestamp", required=false, defaultValue="null") String timestamp,
    		@RequestParam(value="nonce", required=false, defaultValue="null") String nonce,
    		@RequestParam(value="encrypt", required=false, defaultValue="null") String encrypt,
    		@RequestParam(value="signature", required=false, defaultValue="null") String signature,
    		@RequestBody(required=false)String requestBody) {
		String response = "Hello weixin!";
		
		if(echostr.equals("null")){//已认证通过，进入响应方法
			logger.info("微信服务器已认证通过，进入响应方法");
			response = houseResponse.response(requestBody);
		}else{//基础认证
			logger.info("进行微信服务器认证");
			String checkResult = CommonFunction.check(HouseConstants.TOKEN, timestamp, nonce);
			if(signature.equals(checkResult)){
				logger.info("微信服务器通过认证，按要求返回echostr");
				response = echostr;
			}
		}
		
            return response;
        }


       
}
