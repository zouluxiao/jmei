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
 * ��ַģ��service�ӿ�
 * @author ���
 * @since 2014-04-26
 *
 */

public interface AddressService {

	/**
	 * ������ͨ�û�id��ѯ���е�ַ
	 * @param jid ��ͨ�û�id
	 * @return List<Address> ���ص�Address���󼯺�
	 * @exception DAOException ���ݿ��쳣
	 * @exception AddressIsNotExistException û�е�ַ�쳣
	 **/
	public List<Address> searchAllAdressByJid(int jid)throws DAOException,
	AddressIsNotExistException;
	
	/**
	 * ��ӵ�ַ
	 * @param Address Address����
	 * @return
	 * @exception DAOException ���ݿ��쳣
	 * @exception AddressExistException ��ַ�Ѵ����쳣
	 **/
	public void addAddress(Address address)throws DAOException,AddressExistException
	,TelNotExistException,NotHasUsername,NotHasAddress,NotHasDetailAddress;
	
	/**
	 * ���ݵ�ַidɾ����ַ
	 * @param aid ��ַid
	 * @return
	 * @exception DAOException ���ݿ��쳣
	 * @exception AddressIsNotExistException ��ַ�������쳣
	 * 
	 **/
	public void deleteAddressByJid(int aid)throws DAOException,AddressIsNotExistException;
	
	
	/**
	 * �޸��ջ���ַ��Ϣ
	 * @param address Address����
	 * @return
	 * @exception DAOException ���ݿ��쳣
	 * 
	 **/
	public void updateAddressByJid(Address address)throws DAOException;

}
