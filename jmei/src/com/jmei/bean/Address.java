package com.jmei.bean;

import java.io.Serializable;

/**
 * @author 邹璐
 *	aid number(20) primary key,  --编号--
	jid number(20),				--普通用户名--
	address varchar2(100),		--地址--
	consigneename varchar2(50),	--收货人姓名--
	consigneeid varchar2(20),		--收货人身份证号码--
	detailaddress varchar2(100),--详细地址--
	tel varchar2(20),			--电话号码--
	pnumber varchar2(20)		--固定号码--
 */
public class Address implements Serializable {
	private int aid;
	private Juser juser;
	private String address;
	private String consigneename;
	private String consigneeid;
	private String detailaddress;
	private String tel;
	private String pnumber;
	
	public Address() {
		super();
	}

	public Address(int aid, Juser juser, String address, String consigneename,
			String consigneeid, String detailaddress, String tel, String pnumber) {
		super();
		this.aid = aid;
		this.juser = juser;
		this.address = address;
		this.consigneename = consigneename;
		this.consigneeid = consigneeid;
		this.detailaddress = detailaddress;
		this.tel = tel;
		this.pnumber = pnumber;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public Juser getJuser() {
		return juser;
	}

	public void setJuser(Juser juser) {
		this.juser = juser;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getConsigneename() {
		return consigneename;
	}

	public void setConsigneename(String consigneename) {
		this.consigneename = consigneename;
	}

	public String getConsigneeid() {
		return consigneeid;
	}

	public void setConsigneeid(String consigneeid) {
		this.consigneeid = consigneeid;
	}

	public String getDetailaddress() {
		return detailaddress;
	}

	public void setDetailaddress(String detailaddress) {
		this.detailaddress = detailaddress;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPnumber() {
		return pnumber;
	}

	public void setPnumber(String pnumber) {
		this.pnumber = pnumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + aid;
		result = prime * result
				+ ((consigneeid == null) ? 0 : consigneeid.hashCode());
		result = prime * result
				+ ((consigneename == null) ? 0 : consigneename.hashCode());
		result = prime * result
				+ ((detailaddress == null) ? 0 : detailaddress.hashCode());
		result = prime * result + ((juser == null) ? 0 : juser.hashCode());
		result = prime * result + ((pnumber == null) ? 0 : pnumber.hashCode());
		result = prime * result + ((tel == null) ? 0 : tel.hashCode());
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
		Address other = (Address) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (aid != other.aid)
			return false;
		if (consigneeid == null) {
			if (other.consigneeid != null)
				return false;
		} else if (!consigneeid.equals(other.consigneeid))
			return false;
		if (consigneename == null) {
			if (other.consigneename != null)
				return false;
		} else if (!consigneename.equals(other.consigneename))
			return false;
		if (detailaddress == null) {
			if (other.detailaddress != null)
				return false;
		} else if (!detailaddress.equals(other.detailaddress))
			return false;
		if (juser == null) {
			if (other.juser != null)
				return false;
		} else if (!juser.equals(other.juser))
			return false;
		if (pnumber == null) {
			if (other.pnumber != null)
				return false;
		} else if (!pnumber.equals(other.pnumber))
			return false;
		if (tel == null) {
			if (other.tel != null)
				return false;
		} else if (!tel.equals(other.tel))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Address [aid=" + aid + ", juser=" + juser + ", address="
				+ address + ", consigneename=" + consigneename
				+ ", consigneeid=" + consigneeid + ", detailaddress="
				+ detailaddress + ", tel=" + tel + ", pnumber=" + pnumber + "]";
	}
	

}
