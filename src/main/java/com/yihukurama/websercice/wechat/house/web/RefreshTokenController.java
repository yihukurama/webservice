package com.yihukurama.websercice.wechat.house.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yihukurama.websercice.wechat.house.service.TokenService;

/**
 * 更新accesstoken
 * @author dengshuai
 *
 */
@RestController
public class RefreshTokenController {
	
	//刷新微信token
    @RequestMapping("/housetoken")
    public String index(@RequestParam(value="pwd", required=false) String pwd) {
        if(pwd!=null && pwd.equals("dengshuai@123")){
        		TokenService tokenService = new TokenService();
        		
        		String result = tokenService.refreshToken();
        		return result;
        }
        	return "param error!";
    }
    
}
