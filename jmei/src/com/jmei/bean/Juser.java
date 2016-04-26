package com.jmei.bean;

import java.io.Serializable;
/**
 * @author 邹璐
 * 	jid number(20) primary key,  --编号--
	jname varchar2(50),			--用户名--
	jpwd varchar2(20),			--用户密码--
	jemail varchar2(20),		--用户邮箱--
	jtel varchar2(20),			--用户电话号码--
	jgender number(2),			--用户性别--
	jbir varchar2(20),			--用户生日--
	isval number(2),			--是否删除--
	jpic varchar2(20)			--用户头像--
 **/

public class Juser implements Serializable {
	private int jid;
	private String jname;
	private String jpwd;
	private String jemail;
	private String jtel;
	private int jgender;
	private String jbir;
	private int isVal;
	private String jpic;
	public Juser(){
		
	}
	
	public Juser(int jid,String jname,String jpwd,
			String jemail,String jtel,int jgender,String jbir,int isVal,String jpic){
		this.jid=jid;
		this.jname=jname;
		this.jpwd=jpwd;
		this.jemail=jemail;
		this.jtel=jtel;
		this.jgender=jgender;
		this.jbir=jbir;
		this.isVal=isVal;
		this.jpic=jpic;
	}
	
	/*
	 * 注册构造方法（用户名、密码、电话号码、状态）
	 */
	public Juser(String jname, String jpwd, String jtel, int isVal) {
		super();
		this.jname = jname;
		this.jpwd = jpwd;
		this.jtel = jtel;
		this.isVal = isVal;
	}



	public int getJid() {
		return jid;
	}
	public void setJid(int jid) {
		this.jid = jid;
	}
	public String getJname() {
		return jname;
	}
	public void setJname(String jname) {
		this.jname = jname;
	}
	public String getJpwd() {
		return jpwd;
	}
	public void setJpwd(String jpwd) {
		this.jpwd = jpwd;
	}
	public String getJemail() {
		return jemail;
	}
	public void setJemail(String jemail) {
		this.jemail = jemail;
	}
	public String getJtel() {
		return jtel;
	}
	public void setJtel(String jtel) {
		this.jtel = jtel;
	}
	public int getJgender() {
		return jgender;
	}
	public void setJgender(int jgender) {
		this.jgender = jgender;
	}
	public String getJbir() {
		return jbir;
	}
	public void setJbir(String jbir) {
		this.jbir = jbir;
	}
	public int getIsVal() {
		return isVal;
	}
	public void setIsVal(int isVal) {
		this.isVal = isVal;
	}
	public String getJpic() {
		return jpic;
	}
	public void setJpic(String jpic) {
		this.jpic = jpic;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + isVal;
		result = prime * result + ((jbir == null) ? 0 : jbir.hashCode());
		result = prime * result + ((jemail == null) ? 0 : jemail.hashCode());
		result = prime * result + jgender;
		result = prime * result + jid;
		result = prime * result + ((jname == null) ? 0 : jname.hashCode());
		result = prime * result + ((jpic == null) ? 0 : jpic.hashCode());
		result = prime * result + ((jpwd == null) ? 0 : jpwd.hashCode());
		result = prime * result + ((jtel == null) ? 0 : jtel.hashCode());
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
		Juser other = (Juser) obj;
		if (isVal != other.isVal)
			return false;
		if (jbir == null) {
			if (other.jbir != null)
				return false;
		} else if (!jbir.equals(other.jbir))
			return false;
		if (jemail == null) {
			if (other.jemail != null)
				return false;
		} else if (!jemail.equals(other.jemail))
			return false;
		if (jgender != other.jgender)
			return false;
		if (jid != other.jid)
			return false;
		if (jname == null) {
			if (other.jname != null)
				return false;
		} else if (!jname.equals(other.jname))
			return false;
		if (jpic == null) {
			if (other.jpic != null)
				return false;
		} else if (!jpic.equals(other.jpic))
			return false;
		if (jpwd == null) {
			if (other.jpwd != null)
				return false;
		} else if (!jpwd.equals(other.jpwd))
			return false;
		if (jtel == null) {
			if (other.jtel != null)
				return false;
		} else if (!jtel.equals(other.jtel))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Juser [jid=" + jid + ", jname=" + jname + ", jpwd=" + jpwd
				+ ", jemail=" + jemail + ", jtel=" + jtel + ", jgender="
				+ jgender + ", jbir=" + jbir + ", isVal=" + isVal + ", jpic="
				+ jpic + "]";
	}
	
}
