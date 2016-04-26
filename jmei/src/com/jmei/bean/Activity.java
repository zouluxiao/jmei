package com.jmei.bean;

/**
 * @author 汤亮
 * @since 2016-04-24
 * 封装了 activity表
 * acid number(20) primary key,  --编号--
	acpic varchar2(20),			--精选活动图片--
	bid number(20)				--企业id--
 *
 */
public class Activity {
	private int acid;
	private String acpic;
	private Buser buser;
	
	public Activity() {
		// TODO Auto-generated constructor stub
	}

	public Activity(int acid, String acpic, Buser buser) {
		super();
		this.acid = acid;
		this.acpic = acpic;
		this.buser = buser;
	}

	public int getAcid() {
		return acid;
	}

	public void setAcid(int acid) {
		this.acid = acid;
	}

	public String getAcpic() {
		return acpic;
	}

	public void setAcpic(String acpic) {
		this.acpic = acpic;
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
		result = prime * result + acid;
		result = prime * result + ((acpic == null) ? 0 : acpic.hashCode());
		result = prime * result + ((buser == null) ? 0 : buser.hashCode());
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
		Activity other = (Activity) obj;
		if (acid != other.acid)
			return false;
		if (acpic == null) {
			if (other.acpic != null)
				return false;
		} else if (!acpic.equals(other.acpic))
			return false;
		if (buser == null) {
			if (other.buser != null)
				return false;
		} else if (!buser.equals(other.buser))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Activity [acid=" + acid + ", acpic=" + acpic + ", buser="
				+ buser + "]";
	}
	
	
}
