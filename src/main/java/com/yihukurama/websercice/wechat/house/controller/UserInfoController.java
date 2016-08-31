package com.yihukurama.websercice.wechat.house.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

/**
 * 租户信息
 * @author dengshuai
 *
 */
@RestController
public class UserInfoController {
	
	@ApiOperation(httpMethod = "GET", value = "打招呼", notes = "Get请求")
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String sayHello(){
		return "hello";
	}
}
