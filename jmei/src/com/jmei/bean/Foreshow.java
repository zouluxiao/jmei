package com.jmei.bean;

/**
 * @author 汤亮
 * @since 2016-04-24
 * 封装了表foreshow
 *foreid number(20) primary key,  --编号--
	forepic varchar2(20),		--明日预告图片--
	bid number(20)				--企业id--
 */
public class Foreshow {
	private int foreid;
	private String forepic;
	private Buser buser;
	
	public Foreshow() {
		// TODO Auto-generated constructor stub
	}

	public Foreshow(int foreid, String forepic, Buser buser) {
		super();
		this.foreid = foreid;
		this.forepic = forepic;
		this.buser = buser;
	}

	public int getForeid() {
		return foreid;
	}

	public void setForeid(int foreid) {
		this.foreid = foreid;
	}

	public String getForepic() {
		return forepic;
	}

	public void setForepic(String forepic) {
		this.forepic = forepic;
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
		result = prime * result + foreid;
		result = prime * result + ((forepic == null) ? 0 : forepic.hashCode());
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
		Foreshow other = (Foreshow) obj;
		if (buser == null) {
			if (other.buser != null)
				return false;
		} else if (!buser.equals(other.buser))
			return false;
		if (foreid != other.foreid)
			return false;
		if (forepic == null) {
			if (other.forepic != null)
				return false;
		} else if (!forepic.equals(other.forepic))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Foreshow [foreid=" + foreid + ", forepic=" + forepic
				+ ", buser=" + buser + "]";
	}
	
	
}
