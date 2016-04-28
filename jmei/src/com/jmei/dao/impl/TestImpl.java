package com.jmei.dao.impl;

import java.util.ArrayList;

import com.jmei.bean.Buser;
import com.jmei.bean.Country;
import com.jmei.bean.Goods;
import com.jmei.bean.GoodsToEffect;
import com.jmei.bean.GoodsToType;
import com.jmei.bean.Jorder;
import com.jmei.bean.Product;
import com.jmei.exception.DAOException;

public class TestImpl {
	public static void main(String[] args) throws DAOException {
		//BuserDAOImpl buserDAO = new BuserDAOImpl();
		//buserDAO.deleteBuser(10000001);
		
		//Buser buser = new Buser(10000005, "珀莱雅", "bolaiya", 0, "654321", "无简介", "wu", "wu", 0, new Country(10000001, "法国", "France"));
		//buserDAO.updateBuser(buser);
		//buserDAO.updateBuserColVal(10000005);
		
		//CountryDAOImpl countrydao = new CountryDAOImpl();
		//System.out.println(countrydao.queryAllCountry());
		//System.out.println(countrydao.queryCountryByid(10000001));
		//countrydao.addCountry(new Country(0, "日本", "Japan"));
		//countrydao.updateCountry(new Country(10000005,"意大利","Itliy"));
		//countrydao.deleteCountry(10000005);
		
		
		//GoodsDAOImpl GoodsDAO = new GoodsDAOImpl();
		//System.out.println(GoodsDAO.queryGoodsByPid(10000001));
		/*ArrayList<Goods> list = (ArrayList<Goods>) GoodsDAO.queryGoodsByPname("粉饼");
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).getBuser().getBname());
		}*/
		/*ArrayList<Goods> list = (ArrayList<Goods>) GoodsDAO.queryGoodsByDetail("");
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).getPro().getPname());
		}*/
		/*Buser buser = new Buser();
		buser.setBid(10000001);
		Product pro = new Product();
		pro.setPid(10000001);
		
		Goods goods = new Goods(10000004, buser, pro, 10, 10, 0, 0, "20160504", "xx", "p");
		GoodsDAO.insertGoods(goods);;*/
		//GoodsToTypeDAOImpl acdao = new GoodsToTypeDAOImpl();
		/*ArrayList<GoodsToType> list = (ArrayList<GoodsToType>) acdao.queryGoodsByType("类型1");
		for(GoodsToType i:list){
			System.out.println(i.getGoods().getPro().getPname()+" "+i.getGoods().getGid()+" "+i.getGoods().getBuser().getBname());
		}*/
		//acdao.updateGoodsToType(10000001, 10000001,10000002);
	
		/*JorderDAOImpl j = new JorderDAOImpl();
		ArrayList<Jorder> list = (ArrayList<Jorder>) j.queryAllOrder(10000001);
		for(Jorder p:list){
			System.out.println(p.getOrid());
		}*/
	}
}
