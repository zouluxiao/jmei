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
			//Buser buser = b.searchByBname("卡姿兰");
			Iterator it = list.iterator();
			while(it.hasNext()){
				Buser buser = (Buser) it.next();
				System.out.println(buser);
			}
			//System.out.println(buser);
			Buser buser = new Buser(1, "韩束", "hansu.jpg", 0, "123456", "无简介", "bpic", "bmpic", 0, new Country(10000001,"法国","France"));
			b.reg(buser);
			//System.out.println(b.searchByBname("韩束"));
			b.updateBuserColval(10000001);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoBuserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		/*CountryServiceImpl c = new CountryServiceImpl();
		Country country = new Country(10000001, "中国", "China");
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
			List list = g.searchGoodsByDetail("x");
			//g.addSaleVol(10000002);
			//g.orderBySaleVol(list);
			//g.orderByUptime(list);
			//g.searchByPriArea(list, low, high);
			ArrayList<GoodsToEffect> arr = new ArrayList<GoodsToEffect>();
			for(int i=0;i<list.size();i++){
				Goods goods = (Goods) list.get(i);
				System.out.println(goods.getGid());
				List glist = g.searchGoodsToEffectByGid(goods.getGid());
				arr.addAll(glist);
			}
			String[] str = new String[2];
			str[0] = "功效1";
			str[1] = "功效2";
			g.searchGoodsByEffect(str, arr);
			Iterator it = arr.iterator();
			while(it.hasNext()){
				GoodsToEffect go = (GoodsToEffect) it.next();
				System.out.println(go.getEffect().getEname());
			}
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchGoodsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
