package com.wsloan.fanLiWang.util;

import java.util.UUID;
import org.springframework.util.DigestUtils;

/**
 * 密码加密和生成uuid
 * @author liu
 *
 */
public class MD5Util {
	 private static final String SLAT = "2312jjkdakljlksdadl;a%%^&*(9()&***&&&*";
	 //加盐后的MD5
     public static String getMD5(String password){
   		String base = password + "/" + SLAT;
   		String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
   		return md5;	

     }
     //UUID生成ID
     public static  String createId(){
   	 String id= UUID.randomUUID().toString();
   	 return id;
     }
     public static final void main(String[] args) {
		System.out.println(getMD5("123456"));
		System.err.println(createId());
	}
}
