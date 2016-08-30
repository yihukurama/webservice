package com.yihukurama.websercice.wechat.common;
/**
 * 
 * @author dengshuai
 * 微信接口命令的封装
 */
public class WeChatCommand {
	
	static WeChatCommand instance = null;
	public static WeChatCommand getInstance(){
		if(instance == null){
			instance = new WeChatCommand();
		}
		return instance;
	}
	private WeChatCommand(){};
	
	private String gTokenCmd="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s";
	private String cMenueCmd="https://api.weixin.qq.com/cgi-bin/menu/create?access_token=%s";
	
	
	
	public String getgTokenCmd(String appid,String secret) {
		return String.format(gTokenCmd,appid, secret);
	}
	public String getcMenueCmd(String token) {
		return String.format(cMenueCmd,token);
	}

	
	
}
