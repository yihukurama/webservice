package com.yihukurama.websercice.wechat.lovebanks.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.wilddog.client.Wilddog;

/**
 * 键值对数据库，用野狗
 * @author dengshuai
 *
 */
public class KeyValueDB {
	
	public static void saveValue(Wilddog cRef,Object o){
		cRef.setValue(o);
	}
	
	public static void delValue(Wilddog cRef,List<String> key){
		
	}
	
	public static void updateValue(Wilddog cRef,Map<String,String> map){
		
	}
	
	public static List<String> getValue(Wilddog cRef,List<String> key){
		List<String> valueList = new ArrayList<String>();
		
		
		return valueList;
	}
}
