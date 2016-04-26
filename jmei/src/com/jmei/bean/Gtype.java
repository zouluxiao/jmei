package com.jmei.bean;

/**
 * @author 汤亮
 * @since 2016-04-24
 *	封装了数据表Gtype
 *	tid number(20) primary key,  --编号--
	tname varchar2(20)		--类型名--
 */
public class Gtype {
	private int tid;
	private String tname;
	
	public Gtype() {
		// TODO Auto-generated constructor stub
	}

	public Gtype(int tid, String tname) {
		super();
		this.tid = tid;
		this.tname = tname;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + tid;
		result = prime * result + ((tname == null) ? 0 : tname.hashCode());
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
		Gtype other = (Gtype) obj;
		if (tid != other.tid)
			return false;
		if (tname == null) {
			if (other.tname != null)
				return false;
		} else if (!tname.equals(other.tname))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Gtype [tid=" + tid + ", tname=" + tname + "]";
	}
	
	
}
