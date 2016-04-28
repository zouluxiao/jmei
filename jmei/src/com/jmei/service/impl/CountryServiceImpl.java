package com.jmei.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.jmei.bean.Country;
import com.jmei.dao.CountryDAO;
import com.jmei.exception.DAOException;
import com.jmei.exception.NoCountryException;
import com.jmei.factory.DAOFactory;
import com.jmei.service.CountryService;

/**
 * 负责国家表请求的逻辑处理
 * @author 汤亮
 * @since 2016-04-27
 */
public class CountryServiceImpl implements CountryService {
	private final static String COUNTRY_KEY = "CountryDAOImpl";
	
	/**
	 * 向数据库中增加数据
	 * @param country 增加的国家对象
 	 * @throws DAOException DAO层获取数据发生异常
 	 * @throws NoCountryException 国家不存在 
	 */
	@Override
	public void addCountry(Country country) 
			throws DAOException,NoCountryException {
		if(country == null){
			throw new NoCountryException("输入国家为空");
		}
		CountryDAO dao = (CountryDAO) DAOFactory.newInstance(COUNTRY_KEY);
		Country cou = dao.queryCountryByName(country.getCountry());
		if(cou != null){
			throw new DAOException("国家已存在");
		}
		dao.addCountry(country);
	}

	/**
	 * 通过国家编号删除国家
	 * @param countryid 国家编号 
	 * @throws DAOException DAO层获取数据发生异常
	 * NoCountryException 没有找到这个国家
	 */
	@Override
	public void deleteCountry(int countryid) throws DAOException,
			NoCountryException {
		CountryDAO dao = (CountryDAO) DAOFactory.newInstance(COUNTRY_KEY);
		Country cou = dao.queryCountryByid(countryid);
		if(cou == null){
			throw new DAOException("国家不存在");
		}
		dao.deleteCountry(countryid);
	}

	/**
	 * 更新国家信息
	 * @param country 更新国家信息（名称，国旗）
	 * @throws DAOException DAO层获取数据发生异常
	 * NoCountryException 没有找到这个国家
	 */
	@Override
	public void updateCountry(Country country) throws DAOException,
			NoCountryException {
		CountryDAO dao = (CountryDAO) DAOFactory.newInstance(COUNTRY_KEY);
		Country cou = dao.queryCountryByid(country.getCountryid());
		if(cou == null){
			throw new DAOException("国家不存在");
		}
		dao.updateCountry(country);
	}

	/**
	 * 通过国家编号查询国家
	 * @param cid 国家编号
	 * @return Country 返回国家对象
	 * @throws DAOException DAO层获取数据发生异常
	 * NoCountryException 没有找到这个国家
	 */
	@Override
	public Country queryCountryByid(int cid) throws DAOException,
			NoCountryException {
		CountryDAO dao = (CountryDAO) DAOFactory.newInstance(COUNTRY_KEY);
		Country cou = dao.queryCountryByid(cid);
		if(cou == null){
			throw new DAOException("国家不存在");
		}
		return cou;
	}

	/**
	 * 通过国家的名称查询国家
	 * @param country 国家的名称
	 * @return Country 返回国家的对象
	 * @throws DAOException DAO层获取数据发生异常
	 * NoCountryException 没有找到这个国家
	 */
	@Override
	public Country queryCountryByName(String country) throws DAOException,
			NoCountryException {
		CountryDAO dao = (CountryDAO) DAOFactory.newInstance(COUNTRY_KEY);
		Country cou = dao.queryCountryByName(country);
		if(cou == null){
			throw new DAOException("国家不存在");
		}
		return cou;
	}

	/**
	 * 查询所有国家
	 * @return List<Country> 返回国家的对象
	 * @throws DAOException DAO层获取数据发生异常
	 * NoCountryException 没有找到国家
	 */
	@Override
	public List<Country> queryAllCountry() throws DAOException,
			NoCountryException {
		List<Country> list = new ArrayList<Country>();
		CountryDAO dao = (CountryDAO) DAOFactory.newInstance(COUNTRY_KEY);
		list = dao.queryAllCountry();
		if(list.size() == 0){
			throw new NoCountryException("没有找到国家");
		}
		return list;
	}

}
