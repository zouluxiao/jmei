package com.jmei.bean;

import java.io.Serializable;
import java.util.*;

/**
 * @author 汤亮
 * @since 2016-04-23
 * 该类对数据表Goods的封装
 * gid number(20) primary key,  --编号--
	bid number(20),				--企业用户id--
	pid number(20),				--商品id--
	bnumber number,				--商品库存数量--
	pri number(20),				--商品价格--
	sale_val number,			--销量--
	col_val number,				--收藏数量--
	uptime varchar2(20),		--上架时间--
	introduction varchar2(200),	--商品简介--
	detailname varchar2(50) 	--详细名称--
 */
public class Goods implements Serializable{
	private int gid;
	private Buser buser;
	private Product pro;
	private int number;
	private double price;
	private int sale_val;
	private int col_val;
	private String uptime;
	private String introduction;
	private String detailname;
	
	public Goods() {
		// TODO Auto-generated constructor stub
	}

	public Goods(int gid, Buser buser, Product pro, int number, double price,
			int sale_val, int col_val, String uptime, String introduction,
			String detailname) {
		super();
		this.gid = gid;
		this.buser = buser;
		this.pro = pro;
		this.number = number;
		this.price = price;
		this.sale_val = sale_val;
		this.col_val = col_val;
		this.uptime = uptime;
		this.introduction = introduction;
		this.detailname = detailname;
	}

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public Buser getBuser() {
		return buser;
	}

	public void setBuser(Buser buser) {
		this.buser = buser;
	}

	public Product getPro() {
		return pro;
	}

	public void setPro(Product pro) {
		this.pro = pro;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getSale_val() {
		return sale_val;
	}

	public void setSale_val(int sale_val) {
		this.sale_val = sale_val;
	}

	public int getCol_val() {
		return col_val;
	}

	public void setCol_val(int col_val) {
		this.col_val = col_val;
	}

	public String getUptime() {
		return uptime;
	}

	public void setUptime(String uptime) {
		this.uptime = uptime;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getDetailname() {
		return detailname;
	}

	public void setDetailname(String detailname) {
		this.detailname = detailname;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((buser == null) ? 0 : buser.hashCode());
		result = prime * result + col_val;
		result = prime * result
				+ ((detailname == null) ? 0 : detailname.hashCode());
		result = prime * result + gid;
		result = prime * result
				+ ((introduction == null) ? 0 : introduction.hashCode());
		result = prime * result + number;
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((pro == null) ? 0 : pro.hashCode());
		result = prime * result + sale_val;
		result = prime * result + ((uptime == null) ? 0 : uptime.hashCode());
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
		Goods other = (Goods) obj;
		if (buser == null) {
			if (other.buser != null)
				return false;
		} else if (!buser.equals(other.buser))
			return false;
		if (col_val != other.col_val)
			return false;
		if (detailname == null) {
			if (other.detailname != null)
				return false;
		} else if (!detailname.equals(other.detailname))
			return false;
		if (gid != other.gid)
			return false;
		if (introduction == null) {
			if (other.introduction != null)
				return false;
		} else if (!introduction.equals(other.introduction))
			return false;
		if (number != other.number)
			return false;
		if (Double.doubleToLongBits(price) != Double
				.doubleToLongBits(other.price))
			return false;
		if (pro == null) {
			if (other.pro != null)
				return false;
		} else if (!pro.equals(other.pro))
			return false;
		if (sale_val != other.sale_val)
			return false;
		if (uptime == null) {
			if (other.uptime != null)
				return false;
		} else if (!uptime.equals(other.uptime))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Goods [gid=" + gid + ", buser=" + buser + ", pro=" + pro
				+ ", number=" + number + ", price=" + price + ", sale_val="
				+ sale_val + ", col_val=" + col_val + ", uptime=" + uptime
				+ ", introduction=" + introduction + ", detailname="
				+ detailname + "]";
	}
	
	
	
}
