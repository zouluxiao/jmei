package com.jmei.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.jmei.bean.Address;
import com.jmei.bean.Buser;
import com.jmei.bean.CollectionToBuser;
import com.jmei.bean.CollectionToGoods;
import com.jmei.bean.Country;
import com.jmei.bean.Goods;
import com.jmei.bean.Jorder;
import com.jmei.bean.Juser;
import com.jmei.bean.Product;
import com.jmei.dao.AddressDAO;
import com.jmei.dao.CollectionToBuserDAO;
import com.jmei.dao.CollectionToGoodsDAO;
import com.jmei.dao.JorderDAO;
import com.jmei.exception.DAOException;

public class Test {
	/**�ղر�
	 * cbid number(20) primary key,  --���--
	jid number(20),				--�û�id--
	gid number(20)				--��Ʒid--
	
gid number(20) primary key,  --���--
	bid number(20),				--��ҵ�û�id--
	pid number(20),				--��Ʒid--
	bnumber number,				--��Ʒ�������--
	pri number(20),				--��Ʒ�۸�--
	sale_val number,			--����--
	col_val number,				--�ղ�����--
	uptime varchar2(20),		--�ϼ�ʱ��--
	introduction varchar2(200),	--��Ʒ���--
	detailname varchar2(50) 	--��ϸ����--
	 * @param args
	 */
	//10000003 10000001
	/***
	 * orid number(20) primary key,  --���--
	gid number(20),				--��Ʒ���--10000001
	jid number(20),				--��ͨ�û�id--10000020
	aid number(20),				--��ַid--10000001
	jis_val number(2),			--����״̬--
	onumber number				--����������Ʒ����--
	 * @param args
	 */
	public static void main(String[] args) {
		
		/*Product pro=new Product(10000001,null,0);
		Country cou=new Country(10000001,null,null);
		Buser buser =new Buser(10000020,null,null,0,null,null,null,null,0,cou);
		//CollectionToBuserDAO dao=new CollectionToBuserDAOImpl();
		Juser juser=new Juser(10000020,null,null,null,null,0,null,0,null);
		Goods goods=new Goods(10000001,buser,pro,0,0,0,0,null,null,null);*/
		//Country cou=new Country(10000001,null,null);
		//Buser buser=new Buser(10000001,null,null,0,null,null,null,null,0,cou);
		//CollectionToBuser ctb=new CollectionToBuser(1,juser,buser);
		//CollectionToGoods good=new CollectionToGoods(0,juser,goods);
		//Address ad=new Address(10000001,juser,null,null,null,null,null,null);
		/*String sql = "SELECT OR.ORID,GO.GID,BU.BID,BU.BNAME,"
				+ "BU.BLOGO,BU.B_ISVAL,BU.BPWD,BU.BINTRODUCTION,"
				+ "BU.BPIC,BU.BMPIC,BU.COL_VAL,"
				+ "COU.COUNTRYID,COU.COUNTRY,COU.CPIC,"
				+ "PR.PID,PR.PNAME,PR.P_ISVAL,"
				+ "GO.BNUMBER,GO.PRI,GO.SALE_VAL,GO.COL_VAL,GO.UPTIME,"
				+ "GO.INTRODUCTION,GO.DETAILNAME,"
				+ "JU.JID,JU.JNAME,JU.JPWD,JU.JEMAIL,JU.JTEL,"
				+ "JU.JGENDER,JU.JBIR,JU.JUSERISVAL,JU.JPIC,"
				+ "AD.AID,AD.ADDRESS,AD.CONSIGNEENAME,AD.CONSIGNEEID,"
				+ "AD.DETAILADDRESS,AD.TEL,AD.PNUMBER,"
				+ "OR.IS_VAL,OR.ONUMBER "
				+ "FROM JORDER OR,GOODS GO,JUSER JU,ADDRESS AD,BUSER BU,COUNTRY COU,PRODUCT PR "
				+ "WHERE OR.GID=GO.GID AND OR.JID=JU.JID AND OR.AID=AD.AID AND "
				+ "GO.BID=BU.BID AND BU.COUNTRYID=COU.COUNTRYID AND GO.PID=PR.PID AND AD.JID=JU.JID AND "
				+ "JU.JID=?";*/
		JorderDAO dao =new JorderDAOImpl();
		List<Jorder> list=new ArrayList<Jorder>();
		try {
			list=dao.queryAllOrder(10000020);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(list.size());
	}

}
