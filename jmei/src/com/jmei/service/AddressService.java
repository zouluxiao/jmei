package com.jmei.service;

import java.util.List;

import com.jmei.bean.Address;
import com.jmei.exception.AddressExistException;
import com.jmei.exception.AddressIsNotExistException;
import com.jmei.exception.DAOException;
import com.jmei.exception.NotHasAddress;
import com.jmei.exception.NotHasDetailAddress;
import com.jmei.exception.NotHasUsername;
import com.jmei.exception.TelNotExistException;

/**
 * 地址模块service接口
 * @author 邹璐
 * @since 2014-04-26
 *
 */

public interface AddressService {

	/**
	 * 根据普通用户id查询所有地址
	 * @param jid 普通用户id
	 * @return List<Address> 返回的Address对象集合
	 * @exception DAOException 数据库异常
	 * @exception AddressIsNotExistException 没有地址异常
	 **/
	public List<Address> searchAllAdressByJid(int jid)throws DAOException,
	AddressIsNotExistException;
	
	/**
	 * 添加地址
	 * @param Address Address对象
	 * @return
	 * @exception DAOException 数据库异常
	 * @exception AddressExistException 地址已存在异常
	 **/
	public void addAddress(Address address)throws DAOException,AddressExistException
	,TelNotExistException,NotHasUsername,NotHasAddress,NotHasDetailAddress;
	
	/**
	 * 根据地址id删除地址
	 * @param aid 地址id
	 * @return
	 * @exception DAOException 数据库异常
	 * @exception AddressIsNotExistException 地址不存在异常
	 * 
	 **/
	public void deleteAddressByJid(int aid)throws DAOException,AddressIsNotExistException;
	
	
	/**
	 * 修改收货地址信息
	 * @param address Address对象
	 * @return
	 * @exception DAOException 数据库异常
	 * 
	 **/
	public void updateAddressByJid(Address address)throws DAOException;

}
