package com.jmei.bean;

import java.io.Serializable;
/**
 * 	adminid number(20) primary key,  --±àºÅ--
	adminpwd varchar2(20)			--¹ÜÀíÔ±ÃÜÂë--**/
public class Admin implements Serializable {
	private int adminid;
	private String adminpwd;
	
	public Admin() {
	}

	public Admin(int adminid, String adminpwd) {
		this.adminid = adminid;
		this.adminpwd = adminpwd;
	}

	public int getAdminid() {
		return adminid;
	}

	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}

	public String getAdminpwd() {
		return adminpwd;
	}

	public void setAdminpwd(String adminpwd) {
		this.adminpwd = adminpwd;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + adminid;
		result = prime * result
				+ ((adminpwd == null) ? 0 : adminpwd.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if(obj instanceof Admin){
			Admin a = (Admin) obj;
			return a.adminid == this.adminid;
		}
		return false;
	}
	@Override
	public String toString() {
		return "Admin [adminid=" + adminid + ", adminpwd=" + adminpwd + "]";
	}
	
	
}
