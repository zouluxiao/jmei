package com.jmei.bean;

import java.io.Serializable;

/**
 * @author 汤亮
 * @since 2016-04-24
 * 封装了Product表
 *	pid number(20) primary key,  	--编号--
	pname varchar2(20),    			--商品名--
	isVal number (2)				--是否删除--
 */
public class Product implements Serializable{
	private int pid;
	private String pname;
	private int isval;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(int pid, String pname, int isval) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.isval = isval;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + isval;
		result = prime * result + pid;
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
		Product other = (Product) obj;
		if (isval != other.isval)
			return false;
		if (pid != other.pid)
			return false;
		if (pname == null) {
			if (other.pname != null)
				return false;
		} else if (!pname.equals(other.pname))
			return false;
		return true;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getIsval() {
		return isval;
	}

	public void setIsval(int isval) {
		this.isval = isval;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", isval=" + isval
				+ "]";
	}
	
	
}
