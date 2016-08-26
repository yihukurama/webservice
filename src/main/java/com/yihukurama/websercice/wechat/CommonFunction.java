package com.yihukurama.websercice.wechat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.yihukurama.websercice.utils.SHA1;
/**
 * 微信要求的一些验证算法等
 * @author yizhi01
 *
 */
public class CommonFunction {
	/**
     * 验证微信服务器
     * @param token
     * @param timestamp
     * @param nonce
     * @return 
     */
     public  static String check(String token, String timestamp, String nonce)
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
