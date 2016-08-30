package com.yihukurama.websercice.wechat.house.domain.wechatapi;

import java.util.ArrayList;
import java.util.List;

import com.yihukurama.websercice.utils.JsonUtil;
import com.yihukurama.websercice.utils.http.HttpClientUtil;
import com.yihukurama.websercice.wechat.entity.Menue;
import com.yihukurama.websercice.wechat.entity.Menue.MenuButton;
import com.yihukurama.websercice.wechat.entity.Menue.SubButton;
import com.yihukurama.websercice.wechat.lovebanks.domain.Constants;

/**
 * 微信自定义菜单接口
 * @author dengshuai
 *
 */
public class HouseMenue {
	
	Menue menue;
	
	public String initMenueApi(){
		menue = new Menue();
		
		MenuButton menuButton1 = new MenuButton("查看房源");
		MenuButton menuButton2 = new MenuButton("维修中心");
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
		
		List<MenuButton> button = new ArrayList<MenuButton>();
		button.add(menuButton1);
		button.add(menuButton2);
		button.add(menuButton3);
		menue.setName("button");
		
		return createMenue();
	}
	
	
	


	public String createMenue(){
		String postApi = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token="+Constants.accessToken;
		
		String json = "";
		try {
			json = JsonUtil.beanToJson(this);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String result = HttpClientUtil.doPost(postApi, json, "utf-8");
		return result;
	}
	
	
	
	
	
	
}
