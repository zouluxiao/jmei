package com.jmei.utils;

import java.util.Random;
/**
 * 随机生成用户名方法
 * @author 邹璐
 * @since 2016-04-30
 *
 */

public class GetJname {
	public static String getJname() {
		char[] cn = new char[12];
		Random rand = new Random();
		for(int i=0;i<12;i++){
			int num = rand.nextInt(52);
			if(num >=0 && num <10){
				cn[i] = (char) (rand.nextInt(10)+48);
			}
			else if(num >= 10 && num < 26){
				cn[i] = (char) (rand.nextInt(26)+65);
			}
			else if(num >= 26 && num <52){
				cn[i] = (char) (rand.nextInt(26)+97);
			}	
		}
		String jname= cn.toString();
		return jname;
	}
}
