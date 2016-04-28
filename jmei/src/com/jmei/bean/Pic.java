package com.jmei.bean;

import java.io.Serializable;
/***
 * @author Ã¿¡¡
 * @since 2016-04-26
 * 	picid number(20) primary key,		--±‡∫≈--
	picpname varchar2(20),				--…Ã∆∑Õº∆¨√˚--					
	gid number(20)						--…Ã∆∑ø‚¥Ê±‡∫≈--
	flag number
	**/
public class Pic implements Serializable {
	private int picid;
	private String picpname;
	private Goods gid;
	private int flag;
	
	public Pic() {
	}

	public Pic(int picid, String picpname, Goods gid, int flag) {
		super();
		this.picid = picid;
		this.picpname = picpname;
		this.gid = gid;
		this.flag = flag;
	}

	public int getPicid() {
		return picid;
	}

	public void setPicid(int picid) {
		this.picid = picid;
	}

	public String getPicpname() {
		return picpname;
	}

	public void setPicpname(String picpname) {
		this.picpname = picpname;
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
		result = prime * result
				+ ((picpname == null) ? 0 : picpname.hashCode());
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
		if (picpname == null) {
			if (other.picpname != null)
				return false;
		} else if (!picpname.equals(other.picpname))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pic [picid=" + picid + ", picpname=" + picpname + ", gid="
				+ gid + ", flag=" + flag + "]";
	}
	
}
