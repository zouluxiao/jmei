package com.jmei.bean;

import java.io.Serializable;
/**
 * 
 * @author 邹璐
 * 	cid number(20) primary key,  --编号--
	jid number(20),				--用户id--
	gid number(20)			--商品id--
 *
 */

public class CollectionToGoods implements Serializable {
	private int cid;
	private Juser juser;
	private Goods goods;
	public CollectionToGoods(){
		
	}
	public CollectionToGoods(int cid, Juser juser, Goods goods) {
		super();
		this.cid = cid;
		this.juser = juser;
		this.goods = goods;
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
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cid;
		result = prime * result + ((goods == null) ? 0 : goods.hashCode());
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
		CollectionToGoods other = (CollectionToGoods) obj;
		if (cid != other.cid)
			return false;
		if (goods == null) {
			if (other.goods != null)
				return false;
		} else if (!goods.equals(other.goods))
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
		return "CollectionToGoods [cid=" + cid + ", juser=" + juser
				+ ", goods=" + goods + "]";
	}
	
	

}
