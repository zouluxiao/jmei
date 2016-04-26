package com.jmei.bean;

/**
 * @author 汤亮
 * @since 2016-04-24
 * 封装了Mad_rush表
 *	madid number(20) primary key,  --编号--
	madpic varchar2(20),		--今日疯抢图片--
	bid number(20)				--企业id--
 */
public class Mad_rush {
	private int madid;
	private String madpic;
	private Buser buser;
	
	public Mad_rush() {
		// TODO Auto-generated constructor stub
	}

	public Mad_rush(int madid, String madpic, Buser buser) {
		super();
		this.madid = madid;
		this.madpic = madpic;
		this.buser = buser;
	}

	public int getMadid() {
		return madid;
	}

	public void setMadid(int madid) {
		this.madid = madid;
	}

	public String getMadpic() {
		return madpic;
	}

	public void setMadpic(String madpic) {
		this.madpic = madpic;
	}

	public Buser getBuser() {
		return buser;
	}

	public void setBuser(Buser buser) {
		this.buser = buser;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((buser == null) ? 0 : buser.hashCode());
		result = prime * result + madid;
		result = prime * result + ((madpic == null) ? 0 : madpic.hashCode());
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
		Mad_rush other = (Mad_rush) obj;
		if (buser == null) {
			if (other.buser != null)
				return false;
		} else if (!buser.equals(other.buser))
			return false;
		if (madid != other.madid)
			return false;
		if (madpic == null) {
			if (other.madpic != null)
				return false;
		} else if (!madpic.equals(other.madpic))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Mad_rush [madid=" + madid + ", madpic=" + madpic + ", buser="
				+ buser + "]";
	}
	
	
}
