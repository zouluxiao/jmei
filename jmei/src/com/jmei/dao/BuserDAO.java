package com.jmei.dao;

import java.util.List;

import com.jmei.bean.Buser;
import com.jmei.exception.DAOException;

/**
 * @author ����
 * @since 2016-04-23
 * ������ҵ�û���DAO
 */
public interface BuserDAO {
	//������ҵ�û���Ų�ѯ��ҵ�û�
	/**
	 * ������ҵ�û���Ų�ѯ��ҵ�û���Ϣ
	 * @param bid ��ҵ�û����
	 * @return Buser ���ص�Buser���� 
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * 
	 **/
	public Buser queryByBuserId(int bid) throws DAOException;
	//������ҵ�û�����ѯ��ҵ�û�
	/**
	 * ������ҵ�û�����ѯ��ҵ�û���Ϣ
	 * @param bname ��ҵ�û���
	 * @return Buser ���ص�Buser���� 
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * 
	 **/
	public Buser queryByBuserName(String bname) throws DAOException;
	//��ѯ������ҵ�û�
	/**
	 * ��ѯ������ҵ�û�����Ϣ
	 * @return List<Buser> ���ص�Buser����ļ��� 
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * 
	 **/
	public List<Buser> queryAllBusiness() throws DAOException;
	//������ҵ�û����ɾ����ҵ�û�
	/**
	 * ������ҵ�û����ɾ���û����޸�isVal�ֶε�ֵ��
	 * @param bid ��ҵ�û����
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * 
	 **/
	public void deleteBuser(int bid) throws DAOException;
	//�����ҵ�û�
	/**
	 * �����ҵ�û�
	 * @param bid ��ҵ�û����
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * 
	 **/
	public void addBuser(Buser buser) throws DAOException;
	//������ҵ�û�
	/**
	 * ������ҵ�û�
	 * @param bid ��ҵ�û����
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * 
	 **/
	public void updateBuser(Buser buser) throws DAOException;
	
	/**
	 * �����ղ������ղ�����1��
	 * @param bid ��ҵ�û����
	 * @throws DAOException DAO���ȡ���ݹ��̷������쳣��
	 */
	public void updateBuserColVal(int bid) throws DAOException;
}
