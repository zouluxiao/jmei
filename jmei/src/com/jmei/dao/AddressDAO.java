package com.jmei.dao;

import java.util.List;

import com.jmei.bean.Address;
import com.jmei.exception.DAOException;

/**
 * 操作address表获取数据的DAO
 * @since 2016-4-23
 * @author 邹璐
 * */
public interface AddressDAO{
	/**
	 * 根据普通用户id查询所有地址
	 * @param jid 普通用户id
	 * @return List<Address> 返回的Address对象集合
	 * @exception DAOException DAO层获取数据过程发生的异常
	 * 
	 **/
	public List<Address> queryAllAdressByJid(int jid)throws DAOException; 
	
	/**
	 * 添加地址
	 * @param Address Address对象
	 * @return
	 * @exception DAOException DAO层获取数据过程发生的异常
	 * 
	 **/
	public void addAddress(Address address)throws DAOException;
	
	/**
	 * 根据地址id删除地址
	 * @param aid 地址id
	 * @return
	 * @exception DAOException DAO层获取数据过程发生的异常
	 * 
	 **/
	public void deleteAddressByJid(int aid)throws DAOException;
	
	/**
	 * 修改收货地址信息
	 * @param address Address对象
	 * @return
	 * @exception DAOException DAO层获取数据过程发生的异常
	 * 
	 **/
	public void updateAddressByJid(Address address)throws DAOException;
	
	

}
