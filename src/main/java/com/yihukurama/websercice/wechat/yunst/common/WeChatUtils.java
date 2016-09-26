package com.yihukurama.websercice.wechat.yunst.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;



/**
 * 功能描述:微信通用工具类 
 * @Author:denghsuai
 * @Date:2016年9月22日 上午9:58:32
 */
public abstract class WeChatUtils {
	
	 /**
	  * 功能描述:
	  * @param token
	  * @param timestamp
	  * @param nonce
	  * @return
	  * @Author:dengshuai
	  * @Date:2016年9月22日 上午9:59:45
	  */
     public static String check(String token, String timestamp, String nonce)
     {
             List<String> params = params = new ArrayList<String>();
             params.add(token);  
             params.add(timestamp);  
             params.add(nonce);  
             //1. 将token、timestamp、nonce三个参数进行字典序排序  
             Collections.sort(params, new Comparator<String>() {  
              
             public int compare(String o1, String o2) {  
                 return o1.compareTo(o2);  
             }  
         });   
             //2. 将三个参数字符串拼接成一个字符串进行sha1加密  
             String temp = SHA1.encode(params.get(0) + params.get(1) + params.get(2));  
             return temp;

     }
}
