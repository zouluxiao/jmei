package com.jmei.dao;

import java.util.List;

import com.jmei.bean.Admin;
import com.jmei.bean.Pic;
import com.jmei.exception.DAOException;
/**
 * 	adminid number(20) primary key,  --���--
	adminpwd varchar2(20)			--����Ա����--
	**/

/**
 * ����Admin���ȡ���ݵ�DAO
 * @since 2016-4-24
 * @author ����
 * **/
public interface AdminDAO {	
	/**
	 * ���ӹ���Ա
	 * @param admin  ����Ա����
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * */
	public void insertAdmin(Admin admin)throws DAOException;
	
	/**
	 * ɾ������Ա
	 * @param adminid ����Աid
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * */
	public void deleteAdmin(int adminid)throws DAOException;
	
	/**
	 * ���¹���Ա��Ϣ(����Ա��ţ�����Ա����)
	 * @param admin  ����Ա����
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * */
	public void updateAdmin(Admin admin)throws DAOException;
	
	/**
	 * ��ѯ���й���Ա��Ϣ
	 * @return List<Admin> ���صĹ���Ա���󼯺� 
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * 
	 **/
	public List<Admin> queryAllAdmin()throws DAOException;
	
	/**
	 * ���ݹ���Ա��Ų�ѯ����Ա��Ϣ
	 * @param adminid ����Ա���
	 * @return Admin ���صĹ���Ա���� 
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * 
	 **/
	public Admin queryAdminById(int adminid)throws DAOException;
	
}
