package com.yihukurama.websercice.wechat.lovebanks.domain.wechatapi;

import java.util.ArrayList;
import java.util.List;

import com.yihukurama.websercice.utils.JsonUtil;
import com.yihukurama.websercice.utils.http.HttpClientUtil;
import com.yihukurama.websercice.wechat.lovebanks.domain.Constants;

/**
 * 微信自定义菜单接口
 * @author dengshuai
 *
 */
public class LoveMenue {
	
	String name;
	List<MenuButton> button;
	
	public LoveMenue(){
		
		MenuButton menuButton1 = new MenuButton("查看房源");
		MenuButton menuButton2 = new MenuButton("报修中心");
		MenuButton menuButton3 = new MenuButton("租客中心");
		
		SubButton subButton1 = new SubButton("view", "立刻入住",
				"https://weidian.com/item_classes.html?userid=948973478&c=87465315&des=%E7%AB%8B%E5%88%BB%E5%85%A5%E4%BD%8F");
		SubButton subButton2 = new SubButton("view", "友情转租",
				"https://weidian.com/item_classes.html?userid=948973478&c=87465316");
		SubButton subButton3 = new SubButton("view", "合同到期",
				"https://weidian.com/item_classes.html?userid=948973478&c=87465317");
		menuButton1.getSub_button().add(subButton1);
		menuButton1.getSub_button().add(subButton2);
		menuButton1.getSub_button().add(subButton3);
		
		SubButton subButton4 = new SubButton("view", "有偿报修", "https://weidian.com");
		SubButton subButton5 = new SubButton("view", "无偿报修", "https://weidian.com");
		menuButton2.getSub_button().add(subButton4);
		menuButton2.getSub_button().add(subButton5);
		
		SubButton subButton6 = new SubButton("view", "本月交租", "http://www.lovebanks.cn");
		SubButton subButton7 = new SubButton("view", "交租凭证", "http://www.lovebanks.cn");
		SubButton subButton8 = new SubButton("view", "个人信息", "http://www.lovebanks.cn");
		menuButton3.getSub_button().add(subButton6);
		menuButton3.getSub_button().add(subButton7);
		menuButton3.getSub_button().add(subButton8);
		
		button = new ArrayList<LoveMenue.MenuButton>();
		button.add(menuButton1);
		button.add(menuButton2);
		button.add(menuButton3);
		name = "button";
	}
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<MenuButton> getButton() {
		return button;
	}


	public void setButton(List<MenuButton> button) {
		this.button = button;
	}


	public void createMenue(){
		String postApi = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token="+Constants.accessToken;
		
		String json = "";
		try {
			json = JsonUtil.beanToJson(this);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("自定义菜单："+json);
		HttpClientUtil.doPost(postApi, json, "utf-8");
		
	}
	
	
	class MenuButton{
		private String name;
		List<SubButton> sub_button;
		public MenuButton(String name){
			this.name = name;
			sub_button = new ArrayList<SubButton>();
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public List<SubButton> getSub_button() {
			return sub_button;
		}
		public void setSub_button(List<SubButton> sub_button) {
			this.sub_button = sub_button;
		}
		
		
	}
	class SubButton{
		String type;
		String name;
		String url;
		public SubButton(String t,String n,String u){
			type = t;
			name = n;
			url = u;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		
		
	}
	
		
	
	
	
}
