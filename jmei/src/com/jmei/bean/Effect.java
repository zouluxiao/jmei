package com.jmei.bean;

/**
 * @author 汤亮
 * @since 2016-04-24
 * 封装了Effect表
 *eid number(20) primary key,  --编号--
	ename varchar2(20)			--功效名--
 */
public class Effect {
	private int eid;
	private String ename;
	
	public Effect() {
		// TODO Auto-generated constructor stub
	}

	public Effect(int eid, String ename) {
		super();
		this.eid = eid;
		this.ename = ename;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + eid;
		result = prime * result + ((ename == null) ? 0 : ename.hashCode());
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
		Effect other = (Effect) obj;
		if (eid != other.eid)
			return false;
		if (ename == null) {
			if (other.ename != null)
				return false;
		} else if (!ename.equals(other.ename))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Effect [eid=" + eid + ", ename=" + ename + "]";
	}
	
	
}
