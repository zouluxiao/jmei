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
 * AddressService�ӿ�ʵ����
 * @author ���
 * @since 2016-04-26
 *
 */

public class AddressServiceImpl implements AddressService {
	private final static String ADDRESS_DAO_KEY = "AddressDAOImpl";
	
	
	@Override
	public List<Address> searchAllAdressByJid(int jid) throws DAOException,
			AddressIsNotExistException {
		//����AddressDAOImpl����
		AddressDAO addressDAO=(AddressDAO)DAOFactory.newInstance(ADDRESS_DAO_KEY);
		//���ò��������û�����
		List<Address> addresses=addressDAO.queryAllAdressByJid(jid);
		//�ж��û��Ƿ�Ϊ��
		if(addresses.size()==0){
			throw new AddressIsNotExistException("û���û���");
		}
		return addresses;
	}

	@Override
	public void addAddress(Address address) throws DAOException,
			AddressExistException, TelNotExistException, NotHasUsername,
			NotHasAddress, NotHasDetailAddress {
		//����AddressDAOImpl����
		AddressDAO addressDAO=(AddressDAO)DAOFactory.newInstance(ADDRESS_DAO_KEY);
		//�жϵ绰�����Ƿ�Ϊ��
		if(address == null || address.getTel() == null)
			throw new TelNotExistException("�绰����Ϊ��!");
		else if(address == null || address.getConsigneename()==null)
			throw new NotHasUsername("�ռ�������Ϊ��!");
		else if(address == null || address.getAddress()==null)
			throw new NotHasAddress("��ַΪ��!");
		else if(address == null || address.getDetailaddress()==null)
			throw new NotHasDetailAddress("��ϸ��ַΪ��!");
		//������ӵ�ַ����
		addressDAO.addAddress(address);
		
	}

	@Override
	public void deleteAddressByJid(int aid) throws DAOException,
			AddressIsNotExistException {
		//����AddressDAOImpl����
		AddressDAO addressDAO=(AddressDAO)DAOFactory.newInstance(ADDRESS_DAO_KEY);
		//���ò��ҵ�ַ����
		Address address=addressDAO.queryAdressByAid(aid);
		//�жϵ�ַ�Ƿ�Ϊ��
		if(address==null)
			throw new AddressIsNotExistException("��ַ������");
		//������ӵ�ַ����
		addressDAO.deleteAddressByJid(aid);
	}

	@Override
	public void updateAddressByJid(Address address) throws DAOException,AddressIsNull,TelNotExistException,
	NotHasUsername,NotHasAddress,NotHasDetailAddress{
		//����AddressDAOImpl����
		AddressDAO addressDAO=(AddressDAO)DAOFactory.newInstance(ADDRESS_DAO_KEY);
		if(address == null)
			throw new AddressIsNull("��ַΪ��!");
		else if(address.getTel() == null)
			throw new TelNotExistException("�绰����Ϊ��!");
		else if(address == null || address.getConsigneename()==null)
			throw new NotHasUsername("�ռ�������Ϊ��!");
		else if(address == null || address.getAddress()==null)
			throw new NotHasAddress("��ַΪ��!");
		else if(address == null || address.getDetailaddress()==null)
			throw new NotHasDetailAddress("��ϸ��ַΪ��!");
		//�����޸ĵ�ַ����
		addressDAO.updateAddressByJid(address);

	}

}
