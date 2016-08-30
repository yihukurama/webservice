package com.yihukurama.websercice.wechat.common.entity;

import java.util.List;

/**
 * 微信自定义菜单接口
 * @author dengshuai
 *
 */
public class Menue {
	
	String name;
	List<MenuButton> button;
	
	public Menue(){
		
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


	
	
	
	public static class MenuButton{
		private String name;
		List<SubButton> sub_button;
		public MenuButton(String name){
			this.name = name;
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
	public static class SubButton{
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
