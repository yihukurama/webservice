package com.yihukurama.websercice.wechat.house.service.scheduled;

import java.util.ArrayList;
import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.yihukurama.websercice.utils.JsonUtil;
import com.yihukurama.websercice.utils.http.HttpClientUtil;
import com.yihukurama.websercice.wechat.common.WeChatCommand;
import com.yihukurama.websercice.wechat.common.entity.Menue;
import com.yihukurama.websercice.wechat.common.entity.Menue.MenuButton;
import com.yihukurama.websercice.wechat.common.entity.Menue.SubButton;
import com.yihukurama.websercice.wechat.house.domain.HouseConstants;

/**
 * 微信自定义菜单接口
 * @author dengshuai
 * 
 */
@Component
public class HouseMenue {
	
	Menue menue;
	@Scheduled(fixedRate = 259000000)
	public String initMenueApi(){
		menue = new Menue();
		
		MenuButton menuButton1 = new MenuButton("查看房源");
		MenuButton menuButton2 = new MenuButton("报修中心");
		MenuButton menuButton3 = new MenuButton("租客中心");
		
		SubButton subButton1 = new SubButton("view", "真实房源",
				"https://weidian.com/item.html?itemID=1938325808");
		SubButton subButton2 = new SubButton("view", "购买优惠",
				"https://weidian.com/item_classes.html?userid=984504049&c=87813717");
		menuButton1.getSub_button().add(subButton1);
		menuButton1.getSub_button().add(subButton2);
		
		SubButton subButton4 = new SubButton("view", "报修中心", "https://weidian.com/item_classes.html?userid=984504049&c=87807075");
		SubButton subButton5 = new SubButton("view", "投诉建议", "https://im.weidian.com/chat/?from_platform=h&to_platform=a&to_user_id=984504049&im_enter=shop&im_shop_id=984504049");
		menuButton2.getSub_button().add(subButton4);
		menuButton2.getSub_button().add(subButton5);
		
		SubButton subButton6 = new SubButton("view", "本月交租", "https://weidian.com/item_classes.html?userid=984504049&c=87807076");
		SubButton subButton7 = new SubButton("view", "交租凭证", "https://i.weidian.com/order/list.php?type=0");
		SubButton subButton8 = new SubButton("view", "我的信息", "https://i.weidian.com/index.php?umk=984504049");
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
	
	
	


	private String createMenue(){
		String postApi = WeChatCommand.getInstance().getcMenueCmd(HouseConstants.accessToken);
		
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
