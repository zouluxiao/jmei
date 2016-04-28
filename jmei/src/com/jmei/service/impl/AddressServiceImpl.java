package com.jmei.service.impl;

import java.util.List;

import com.jmei.bean.Address;
import com.jmei.dao.AddressDAO;
import com.jmei.exception.AddressExistException;
import com.jmei.exception.AddressIsNotExistException;
import com.jmei.exception.AddressIsNull;
import com.jmei.exception.DAOException;
import com.jmei.exception.NotHasAddress;
import com.jmei.exception.NotHasDetailAddress;
import com.jmei.exception.NotHasUsername;
import com.jmei.exception.TelNotExistException;
import com.jmei.factory.DAOFactory;
import com.jmei.service.AddressService;
/***
 * AddressService接口实现类
 * @author 邹璐
 * @since 2016-04-26
 *
 */

public class AddressServiceImpl implements AddressService {
	private final static String ADDRESS_DAO_KEY = "AddressDAOImpl";
	
	
	@Override
	public List<Address> searchAllAdressByJid(int jid) throws DAOException,
			AddressIsNotExistException {
		//创建AddressDAOImpl对象
		AddressDAO addressDAO=(AddressDAO)DAOFactory.newInstance(ADDRESS_DAO_KEY);
		//调用查找所有用户方法
		List<Address> addresses=addressDAO.queryAllAdressByJid(jid);
		//判断用户是否为空
		if(addresses.size()==0){
			throw new AddressIsNotExistException("没有用户！");
		}
		return addresses;
	}

	@Override
	public void addAddress(Address address) throws DAOException,
			AddressExistException, TelNotExistException, NotHasUsername,
			NotHasAddress, NotHasDetailAddress {
		//创建AddressDAOImpl对象
		AddressDAO addressDAO=(AddressDAO)DAOFactory.newInstance(ADDRESS_DAO_KEY);
		//判断电话号码是否为空
		if(address == null || address.getTel() == null)
			throw new TelNotExistException("电话号码为空!");
		else if(address == null || address.getConsigneename()==null)
			throw new NotHasUsername("收件人姓名为空!");
		else if(address == null || address.getAddress()==null)
			throw new NotHasAddress("地址为空!");
		else if(address == null || address.getDetailaddress()==null)
			throw new NotHasDetailAddress("详细地址为空!");
		//调用添加地址方法
		addressDAO.addAddress(address);
		
	}

	@Override
	public void deleteAddressByJid(int aid) throws DAOException,
			AddressIsNotExistException {
		//创建AddressDAOImpl对象
		AddressDAO addressDAO=(AddressDAO)DAOFactory.newInstance(ADDRESS_DAO_KEY);
		//调用查找地址方法
		Address address=addressDAO.queryAdressByAid(aid);
		//判断地址是否为空
		if(address==null)
			throw new AddressIsNotExistException("地址不存在");
		//调用添加地址方法
		addressDAO.deleteAddressByJid(aid);
	}

	@Override
	public void updateAddressByJid(Address address) throws DAOException,AddressIsNull,TelNotExistException,
	NotHasUsername,NotHasAddress,NotHasDetailAddress{
		//创建AddressDAOImpl对象
		AddressDAO addressDAO=(AddressDAO)DAOFactory.newInstance(ADDRESS_DAO_KEY);
		if(address == null)
			throw new AddressIsNull("地址为空!");
		else if(address.getTel() == null)
			throw new TelNotExistException("电话号码为空!");
		else if(address == null || address.getConsigneename()==null)
			throw new NotHasUsername("收件人姓名为空!");
		else if(address == null || address.getAddress()==null)
			throw new NotHasAddress("地址为空!");
		else if(address == null || address.getDetailaddress()==null)
			throw new NotHasDetailAddress("详细地址为空!");
		//调用修改地址方法
		addressDAO.updateAddressByJid(address);

	}

}
