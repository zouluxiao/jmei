package com.jmei.bean;


import java.io.Serializable;
/**
 * 
 * @author 邹璐
 * 	cbid number(20) primary key,  --编号--
	jid number(20),				--用户id--
	bid number(20)				--企业id--
 *
 */

public class CollectionToBuser implements Serializable {
	private int cid;
	private Juser juser;
	private Buser buser;
	public CollectionToBuser(){
		
	}
	public CollectionToBuser(int cid,Juser juser,Buser buser){
		this.cid=cid;
		this.juser=juser;
		this.buser=buser;
		
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public Juser getJuser() {
		return juser;
	}
	public void setJuser(Juser juser) {
		this.juser = juser;
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
		result = prime * result + cid;
		result = prime * result + ((juser == null) ? 0 : juser.hashCode());
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
		CollectionToBuser other = (CollectionToBuser) obj;
		if (cid != other.cid)
			return false;
		if (juser == null) {
			if (other.juser != null)
				return false;
		} else if (!juser.equals(other.juser))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CollectionToBuser [cid=" + cid + ", juser=" + juser + "]";
	}
	
	

}
