package com.jmei.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.jmei.bean.Buser;
import com.jmei.bean.Country;
import com.jmei.bean.Goods;
import com.jmei.bean.GoodsToEffect;
import com.jmei.bean.GoodsToType;
import com.jmei.exception.DAOException;
import com.jmei.exception.NoBuserException;
import com.jmei.exception.NoCountryException;
import com.jmei.exception.NoSuchGoodsException;
import com.jmei.exception.UserNameIsNotExistException;
import com.jmei.exception.UserNameOrPwdException;

public class ServicesTest {
	public static void main(String[] args) {
		/*BuserServiceImpl b = new BuserServiceImpl();
		List<Buser> list = new ArrayList<Buser>();
		try {
			//Buser buser = b.searchByBname("¿¨×ËÀ¼");
			Iterator it = list.iterator();
			while(it.hasNext()){
				Buser buser = (Buser) it.next();
				System.out.println(buser);
			}
			//System.out.println(buser);
			Buser buser = new Buser(1, "º«Êø", "hansu.jpg", 0, "123456", "ÎÞ¼ò½é", "bpic", "bmpic", 0, new Country(10000001,"·¨¹ú","France"));
			b.reg(buser);
			//System.out.println(b.searchByBname("º«Êø"));
			b.updateBuserColval(10000001);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoBuserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		/*CountryServiceImpl c = new CountryServiceImpl();
		Country country = new Country(10000001, "ÖÐ¹ú", "China");
		try {
			System.out.println(c.queryAllCountry());
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoCountryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		GoodsServicesImpl g = new GoodsServicesImpl();
		try {
			List<Goods> goodslist =g.searchGoodsByDetail("x");
			System.out.println(goodslist);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchGoodsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
