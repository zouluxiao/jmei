package com.jmei.bean;

import java.io.Serializable;

/**
 * @author 汤亮
 * @since 2016-04-23
 *	封装了数据库中的country表
 *	countryid number(20) primary key,	--编号--
	country varchar2(20),				--国家名--					
	cpic varchar2(20)					--国家图片--
 */
public class Country implements Serializable{
	private int countryid;
	private String country;
	private String cpic;
	
	public Country() {
		// TODO Auto-generated constructor stub
	}

	public Country(int countryid, String country, String cpic) {
		super();
		this.countryid = countryid;
		this.country = country;
		this.cpic = cpic;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + countryid;
		result = prime * result + ((cpic == null) ? 0 : cpic.hashCode());
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
		Country other = (Country) obj;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (countryid != other.countryid)
			return false;
		if (cpic == null) {
			if (other.cpic != null)
				return false;
		} else if (!cpic.equals(other.cpic))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Country [countryid=" + countryid + ", country=" + country
				+ ", cpic=" + cpic + "]";
	}

	public int getCountryid() {
		return countryid;
	}

	public void setCountryid(int countryid) {
		this.countryid = countryid;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCpic() {
		return cpic;
	}

	public void setCpic(String cpic) {
		this.cpic = cpic;
	}
	
	
}
