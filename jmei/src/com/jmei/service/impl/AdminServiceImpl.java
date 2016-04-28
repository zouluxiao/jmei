package com.jmei.service.impl;

import com.jmei.bean.Admin;
import com.jmei.dao.AdminDAO;
import com.jmei.exception.AdminIdIsNotExistException;
import com.jmei.exception.AdminIdOrPwdException;
import com.jmei.exception.DAOException;
import com.jmei.factory.DAOFactory;
import com.jmei.service.AdminService;
/**
 * AdminService�ӿ�ʵ����
 * @since 2016-04-27
 * @author ����
 * **/
public class AdminServiceImpl implements AdminService {
	private final static String ADMIN_DAO_KEY = "AdminDAOImpl"; 
	//���չ���Աid��¼�ķ���
	public void loginByAdminId(int adminid, String adminpwd)
			throws DAOException, AdminIdIsNotExistException,
			AdminIdOrPwdException {
		//1.��������AdminDAOImpl����
		AdminDAO adminDAO = (AdminDAO)DAOFactory.newInstance(ADMIN_DAO_KEY);
		//2.���ò�ѯ����Ա��Ϣ�ķ���
		Admin admin = adminDAO.queryAdminById(adminid);
		//3.�ж�admin�Ƿ�Ϊ��
		if(admin == null)
			throw new AdminIdIsNotExistException("����Ա�����ڣ�");
		if(!adminpwd.equals(admin.getAdminpwd()))
			throw new AdminIdOrPwdException("����Աid���������!");
			
	}
	
}
