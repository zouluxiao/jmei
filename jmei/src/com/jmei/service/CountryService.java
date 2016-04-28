package com.jmei.service;

import java.util.List;

import com.jmei.bean.Country;
import com.jmei.exception.DAOException;
import com.jmei.exception.NoCountryException;

/**
 * 对国家类（Country）进行逻辑处理
 * @author 汤亮
 * @since 2016-04-26
 *
 */
public interface CountryService {
	//增加国家
	/**
	 * 向数据库中增加数据
	 * @param country 增加的国家对象
 	 * @throws DAOException DAO层获取数据发生异常
 	 * @throws NoCountryException 国家不存在 
	 */
	public void addCountry(Country country) 
			throws DAOException,NoCountryException;
	//删除国家
	/**
	 * 通过国家编号删除国家
	 * @param countryid 国家编号 
	 * @throws DAOException DAO层获取数据发生异常
	 * NoCountryException 没有找到这个国家
	 */
	public void deleteCountry(int countryid) 
			throws DAOException,NoCountryException;
	//更新国家
	/**
	 * 更新国家信息
	 * @param country 更新国家信息（名称，国旗）
	 * @throws DAOException DAO层获取数据发生异常
	 * NoCountryException 没有找到这个国家
	 */
	public void updateCountry(Country country) 
			throws DAOException,NoCountryException;
	//查询国家通过编号
	/**
	 * 通过国家编号查询国家
	 * @param cid 国家编号
	 * @return Country 返回国家对象
	 * @throws DAOException DAO层获取数据发生异常
	 * NoCountryException 没有找到这个国家
	 */
	public Country queryCountryByid(int cid) 
			throws DAOException,NoCountryException;
	//查询国家通过国家名称
	/**
	 * 通过国家的名称查询国家
	 * @param country 国家的名称
	 * @return Country 返回国家的对象
	 * @throws DAOException DAO层获取数据发生异常
	 * NoCountryException 没有找到这个国家
	 */
	public Country queryCountryByName(String country) 
			throws DAOException,NoCountryException;
	
	/**
	 * 查询所有国家
	 * @return List<Country> 返回国家的对象
	 * @throws DAOException DAO层获取数据发生异常
	 * NoCountryException 没有找到国家
	 */
	public List<Country> queryAllCountry() 
			throws DAOException,NoCountryException;
}
