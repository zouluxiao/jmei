package com.jmei.bean;

import java.io.Serializable;

/**
 * @author 汤亮
 * 2016-04-23
 * 对Buser表的封装
 * bid number(20) primary key,  		--编号--
	bname varchar2(50),    				--企业用户名--
	blogo varchar2(100),				--企业用户logo--
	isVal number (2),					--是否删除--
	bpwd varchar2(20),					--企业用户密码--
	bintroduction varchar2(200), 		--企业简介--
	bpic varchar2(100),					--企业图片--
	bmpic varchar2(100),				--中等图片--
	col_val number(10),                 --收藏量--
	countryid number(20)				--国家id--
 */
public class Buser implements Serializable{
	private int bid;
	private String bname;
	private String blogo;
	private int isVal;
	private String bpwd;
	private String bintroduction;
	private String bpic;
	private String bmpic;
	private int col_val;
	private Country country;
	
	public Buser() {
		// TODO Auto-generated constructor stub
	}

	public Buser(int bid, String bname, String blogo, int isVal, String bpwd,
			String bintroduction, String bpic, String bmpic, int col_val,
			Country country) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.blogo = blogo;
		this.isVal = isVal;
		this.bpwd = bpwd;
		this.bintroduction = bintroduction;
		this.bpic = bpic;
		this.bmpic = bmpic;
		this.col_val = col_val;
		this.country = country;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bid;
		result = prime * result
				+ ((bintroduction == null) ? 0 : bintroduction.hashCode());
		result = prime * result + ((blogo == null) ? 0 : blogo.hashCode());
		result = prime * result + ((bmpic == null) ? 0 : bmpic.hashCode());
		result = prime * result + ((bname == null) ? 0 : bname.hashCode());
		result = prime * result + ((bpic == null) ? 0 : bpic.hashCode());
		result = prime * result + ((bpwd == null) ? 0 : bpwd.hashCode());
		result = prime * result + col_val;
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + isVal;
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
		Buser other = (Buser) obj;
		if (bid != other.bid)
			return false;
		if (bintroduction == null) {
			if (other.bintroduction != null)
				return false;
		} else if (!bintroduction.equals(other.bintroduction))
			return false;
		if (blogo == null) {
			if (other.blogo != null)
				return false;
		} else if (!blogo.equals(other.blogo))
			return false;
		if (bmpic == null) {
			if (other.bmpic != null)
				return false;
		} else if (!bmpic.equals(other.bmpic))
			return false;
		if (bname == null) {
			if (other.bname != null)
				return false;
		} else if (!bname.equals(other.bname))
			return false;
		if (bpic == null) {
			if (other.bpic != null)
				return false;
		} else if (!bpic.equals(other.bpic))
			return false;
		if (bpwd == null) {
			if (other.bpwd != null)
				return false;
		} else if (!bpwd.equals(other.bpwd))
			return false;
		if (col_val != other.col_val)
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (isVal != other.isVal)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Buser [bid=" + bid + ", bname=" + bname + ", blogo=" + blogo
				+ ", isVal=" + isVal + ", bpwd=" + bpwd + ", bintroduction="
				+ bintroduction + ", bpic=" + bpic + ", bmpic=" + bmpic
				+ ", col_val=" + col_val + ", country=" + country + "]";
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getBlogo() {
		return blogo;
	}

	public void setBlogo(String blogo) {
		this.blogo = blogo;
	}

	public int getIsVal() {
		return isVal;
	}

	public void setIsVal(int isVal) {
		this.isVal = isVal;
	}

	public String getBpwd() {
		return bpwd;
	}

	public void setBpwd(String bpwd) {
		this.bpwd = bpwd;
	}

	public String getBintroduction() {
		return bintroduction;
	}

	public void setBintroduction(String bintroduction) {
		this.bintroduction = bintroduction;
	}

	public String getBpic() {
		return bpic;
	}

	public void setBpic(String bpic) {
		this.bpic = bpic;
	}

	public String getBmpic() {
		return bmpic;
	}

	public void setBmpic(String bmpic) {
		this.bmpic = bmpic;
	}

	public int getCol_val() {
		return col_val;
	}

	public void setCol_val(int col_val) {
		this.col_val = col_val;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	
	
}
