package com.jmei.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.jmei.bean.Buser;
import com.jmei.dao.BuserDAO;
import com.jmei.exception.DAOException;
import com.jmei.exception.NoBuserException;
import com.jmei.exception.UserNameIsNotExistException;
import com.jmei.exception.UserNameOrPwdException;
import com.jmei.factory.DAOFactory;
import com.jmei.service.BuserService;

/**
 * ���û�����Ķ�Buser���������߼�����
 * @author ����
 * @since 2016-04-27
 */
public class BuserServiceImpl implements BuserService {
	private final static String BUSER_KEY = "BuserDAOImpl";
	
	/**
	 * ��ҵ�û����ڵ�½�ķ���
	 * @param uname ��ҵ�û����û���
	 * @param pwd ��ҵ�û�������
	 * @exception DAOException ���ݿ��쳣
	 * @exception UserNameIsNotExistException �û����������쳣
	 * @exception UserNameOrPwdException   �û�������������쳣
	 */
	@Override
	public void login(String uname, String pwd) throws DAOException,
			UserNameIsNotExistException, UserNameOrPwdException {
		if(uname == null){
			throw new UserNameIsNotExistException("�����û�������Ϊ��");
		}
		if(pwd == null){
			throw new UserNameIsNotExistException("�������벻��Ϊ��");
		}
		BuserDAO dao = (BuserDAO) DAOFactory.newInstance(BUSER_KEY);
		Buser buser = dao.queryByBuserName(uname);
		if(buser == null){
			throw new UserNameIsNotExistException("�û�������");
		}
		if(!pwd.equals(buser.getBpwd())){
			throw new UserNameOrPwdException("�û��������벻ƥ��");
		}
		
	}

	/**
	 * �÷���������ҵ�û��ĵǳ�
	 */
	@Override
	public void logout() {
		
	}

	/**
	 * �÷���������ע����ҵ�û�������
	 * @param buser ע�����ҵ�û�
	 * @exception DAOException ���ݿ��쳣
	 * @exception UserNameIsNotExistException �û����������쳣
	 */
	@Override
	public void reg(Buser buser) 
			throws DAOException,UserNameIsNotExistException {
		if(buser == null){
			throw new UserNameIsNotExistException("�����û�������");
		}
		BuserDAO dao = (BuserDAO) DAOFactory.newInstance(BUSER_KEY);
		Buser bname = dao.queryByBuserName(buser.getBname());
		if(bname != null){
			throw new DAOException("�û��Ѵ���");
		}
		dao.addBuser(buser);
	}

	/**
	 * �޸���ҵ�û��Ļ�����Ϣ
	 * @param buser ��ҵ�û�
	 * @exception DAOException ���ݿ��쳣
	 * @exception UserNameIsNotExistException �û����������쳣
	 */
	@Override
	public void updateBuser(Buser buser) 
			throws DAOException, UserNameIsNotExistException {
		if(buser == null){
			throw new UserNameIsNotExistException("�û�Ϊ��");
		}
		BuserDAO dao = (BuserDAO) DAOFactory.newInstance(BUSER_KEY);
		Buser b = dao.queryByBuserId(buser.getBid());
		if(b == null){
			throw new DAOException("�û�������");
		}
		dao.updateBuser(buser);
	}

	/**
	 * ͨ����ҵ�û���Ų�����ҵ�û�
	 * @param bid
	 * @return Buser ��ҵ�û�����
	 * @exception DAOException ���ݿ��쳣
	 * @exception NoBuserException ��ҵ�û�������
	 */
	@Override
	public Buser searchBybid(int bid) 
			throws DAOException, NoBuserException {
		BuserDAO dao = (BuserDAO) DAOFactory.newInstance(BUSER_KEY);
		Buser buser = dao.queryByBuserId(bid);
		if(buser == null){
			throw new NoBuserException("�û�������");
		}
		return buser;
	}

	/**
	 * ͨ����ҵ�û������Ʋ�ѯ��ҵ�û�
	 * @param bname ��ҵ�û�������
	 * @return Buser ��ҵ�û�����
	 * @exception DAOException ���ݿ��쳣
	 * @exception NoBuserException ��ҵ�û�������
	 */
	@Override
	public Buser searchByBname(String bname) throws DAOException,
			NoBuserException {
		BuserDAO dao = (BuserDAO) DAOFactory.newInstance(BUSER_KEY);
		Buser buser = dao.queryByBuserName(bname);
		if(buser == null){
			throw new NoBuserException("�û�������");
		}
		return buser;
	}

	/**
	 * ��ѯ������ҵ�û�
	 * @return ��ҵ�û����󼯺�
	 * @exception DAOException ���ݿ��쳣
	 * @exception NoBuserException ��ҵ�û�������
	 */
	@Override
	public List<Buser> searchAllBusiness() 
			throws DAOException, NoBuserException {
		List<Buser> list = new ArrayList<Buser>();
		BuserDAO dao = (BuserDAO) DAOFactory.newInstance(BUSER_KEY);
		list = dao.queryAllBusiness();
		if(list.size() == 0){
			throw new NoBuserException("û���û�����");
		}
		return list;
	}

	/**
	 * ��ҵ�û����ղ�����1
	 * @param bid ��ҵ�û��ı��
	 * @exception DAOException ���ݿ��쳣
	 * @exception NoBuserException ��ҵ�û�������
	 */
	@Override
	public void updateBuserColval(int bid) throws DAOException,
			NoBuserException {
		BuserDAO dao = (BuserDAO) DAOFactory.newInstance(BUSER_KEY);
		Buser buser = dao.queryByBuserId(bid);
		if(buser == null){
			throw new NoBuserException("�û�������");
		}
		dao.updateBuserColVal(bid);
	}

}
