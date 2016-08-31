package com.yihukurama.websercice.wechat.house.service.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
@Component
public class Scheduleder {
	
	@Scheduled(fixedRate = 259000000)
	public void refreshToken(){
		TokenService tS = new TokenService();
		tS.refreshToken();
		
		
		HouseMenue hM = new HouseMenue();
		hM.initMenueApi();
	}

}
