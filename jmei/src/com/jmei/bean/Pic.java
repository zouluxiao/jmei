package com.jmei.bean;

import java.io.Serializable;
/***
 * 	picid number(20) primary key,		--编号--
	pname varchar2(20),					--商品名--					
	gid number(20)						--商品库存编号--
	flag number
	**/
public class Pic implements Serializable {
	private int picid;
	private String pname;
	private Goods gid;
	private int flag;
	
	public Pic() {
	}

	public Pic(int picid, String pname, Goods gid, int flag) {
		super();
		this.picid = picid;
		this.pname = pname;
		this.gid = gid;
		this.flag = flag;
	}

	public int getPicid() {
		return picid;
	}

	public void setPicid(int picid) {
		this.picid = picid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Goods getGid() {
		return gid;
	}

	public void setGid(Goods gid) {
		this.gid = gid;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + flag;
		result = prime * result + ((gid == null) ? 0 : gid.hashCode());
		result = prime * result + picid;
		result = prime * result + ((pname == null) ? 0 : pname.hashCode());
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
		Pic other = (Pic) obj;
		if (flag != other.flag)
			return false;
		if (gid == null) {
			if (other.gid != null)
				return false;
		} else if (!gid.equals(other.gid))
			return false;
		if (picid != other.picid)
			return false;
		if (pname == null) {
			if (other.pname != null)
				return false;
		} else if (!pname.equals(other.pname))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pic [picid=" + picid + ", pname=" + pname + ", gid=" + gid
				+ ", flag=" + flag + "]";
	}

	
	
	
}
