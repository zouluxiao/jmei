package com.jmei.service;

import java.util.List;

import com.jmei.bean.Buser;
import com.jmei.exception.DAOException;
import com.jmei.exception.NoBuserException;
import com.jmei.exception.UserNameIsNotExistException;
import com.jmei.exception.UserNameOrPwdException;

/**
 * ����ҵ�û������߼������service��
 * @author ����
 * @since 2016-04-26
 *
 */
public interface BuserService {
	/**
	 * ��ҵ�û����ڵ�½�ķ���
	 * @param uname ��ҵ�û����û���
	 * @param pwd ��ҵ�û�������
	 * @exception DAOException ���ݿ��쳣
	 * @exception UserNameIsNotExistException �û����������쳣
	 * @exception UserNameOrPwdException   �û�������������쳣
	 */
	public void login(String uname,String pwd)
			throws DAOException,UserNameIsNotExistException,UserNameOrPwdException;
	/**
	 * �÷���������ҵ�û��ĵǳ�
	 */
	public void logout();
	/**
	 * �÷���������ע����ҵ�û�������
	 * @param buser ע�����ҵ�û�
	 * @exception DAOException ���ݿ��쳣
	 * @exception UserNameIsNotExistException �û����������쳣
	 */
	public void reg(Buser buser)
			throws DAOException,UserNameIsNotExistException;
	/**
	 * �޸���ҵ�û��Ļ�����Ϣ
	 * @param buser ��ҵ�û�
	 * @exception DAOException ���ݿ��쳣
	 * @exception UserNameIsNotExistException �û����������쳣
	 */
	public void updateBuser(Buser buser)
			throws DAOException,UserNameIsNotExistException;
	/**
	 * ͨ����ҵ�û���Ų�����ҵ�û�
	 * @param bid
	 * @return Buser ��ҵ�û�����
	 * @exception DAOException ���ݿ��쳣
	 * @exception NoBuserException ��ҵ�û�������
	 */
	public Buser searchBybid(int bid)
			throws DAOException,NoBuserException;
	/**
	 * ͨ����ҵ�û������Ʋ�ѯ��ҵ�û�
	 * @param bname ��ҵ�û�������
	 * @return Buser ��ҵ�û�����
	 * @exception DAOException ���ݿ��쳣
	 * @exception NoBuserException ��ҵ�û�������
	 */
	public Buser searchByBname(String bname)
			throws DAOException,NoBuserException;
	/**
	 * ��ѯ������ҵ�û�
	 * @return ��ҵ�û����󼯺�
	 * @exception DAOException ���ݿ��쳣
	 * @exception NoBuserException ��ҵ�û�������
	 */
	public List<Buser> searchAllBusiness()
			throws DAOException,NoBuserException;
	/**
	 * ��ҵ�û����ղ�����1
	 * @param bid ��ҵ�û��ı��
	 * @exception DAOException ���ݿ��쳣
	 * @exception NoBuserException ��ҵ�û�������
	 */
	public void updateBuserColval(int bid)
			throws DAOException,NoBuserException;
}
