package com.jmei.dao;

import java.util.List;

import com.jmei.bean.Address;
import com.jmei.exception.DAOException;

/**
 * ����address���ȡ���ݵ�DAO
 * @since 2016-4-23
 * @author ���
 * */
public interface AddressDAO{
	/**
	 * ������ͨ�û�id��ѯ���е�ַ
	 * @param jid ��ͨ�û�id
	 * @return List<Address> ���ص�Address���󼯺�
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣
	 * 
	 **/
	public List<Address> queryAllAdressByJid(int jid)throws DAOException; 
	
	/**
	 * ��ӵ�ַ
	 * @param Address Address����
	 * @return
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣
	 * 
	 **/
	public void addAddress(Address address)throws DAOException;
	
	/**
	 * ���ݵ�ַidɾ����ַ
	 * @param aid ��ַid
	 * @return
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣
	 * 
	 **/
	public void deleteAddressByJid(int aid)throws DAOException;
	
	/**
	 * �޸��ջ���ַ��Ϣ
	 * @param address Address����
	 * @return
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣
	 * 
	 **/
	public void updateAddressByJid(Address address)throws DAOException;
	
	

}
