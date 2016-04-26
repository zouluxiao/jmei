package com.jmei.bean;

import java.io.Serializable;
/**
 * @author 邹璐
 *	orid number(20) primary key,  --编号--
	gid number(20),				--商品编号--
	jid number(20),				--普通用户id--
	aid number(20),				--地址id--
	is_val number(2),			--订单状态--
	onumber number,				--订单数量商品数量--
	
 * **/
public class Jorder implements Serializable {
	private int orid;
	private Goods goods;
	private Juser juser;
	private Address address;
	private int is_Val;
	private int onumber;
	
	public Jorder(){
		
	}
	public Jorder(int orid,Goods goods,Juser juser
			,Address address,int is_Val,int onumber){
		this.orid=orid;
		this.goods=goods;
		this.juser=juser;
		this.address=address;
		this.is_Val=is_Val;
		this.onumber=onumber;
	}
	public int getOrid() {
		return orid;
	}
	public void setOrid(int orid) {
		this.orid = orid;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public Juser getJuser() {
		return juser;
	}
	public void setJuser(Juser juser) {
		this.juser = juser;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public int getIs_Val() {
		return is_Val;
	}
	public void setIs_Val(int is_Val) {
		this.is_Val = is_Val;
	}
	public int getOnumber() {
		return onumber;
	}
	public void setOnumber(int onumber) {
		this.onumber = onumber;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + is_Val;
		result = prime * result + ((juser == null) ? 0 : juser.hashCode());
		result = prime * result + onumber;
		result = prime * result + orid;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jorder other = (Jorder) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (is_Val != other.is_Val)
			return false;
		if (juser == null) {
			if (other.juser != null)
				return false;
		} else if (!juser.equals(other.juser))
			return false;
		if (onumber != other.onumber)
			return false;
		if (orid != other.orid)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Jorder [orid=" + orid + ", juser=" + juser + ", address="
				+ address + ", is_Val=" + is_Val + ", onumber=" + onumber + "]";
	}
	
	

}
