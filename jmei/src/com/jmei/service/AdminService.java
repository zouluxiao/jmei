package com.jmei.service;

import com.jmei.exception.AdminIdIsNotExistException;
import com.jmei.exception.AdminIdOrPwdException;
import com.jmei.exception.DAOException;
/**
 * AdminService�ӿ�
 * @since 2016-04-27
 * @author ����
 * **/


public interface AdminService {
	/**���չ���Աid��¼�ķ���
	 * @param adminid ����Աid
	 * @param adminpwd  ����Ա����
	 * @exception DAOException ���ݿ��쳣
	 * @exception AdminIdIsNotExistException ����Ա���������쳣
	 * @exception AdminNameOrPwdException   ����Ա������������쳣
	 */
	public void loginByAdminId(int adminid,String adminpwd)
	throws DAOException,AdminIdIsNotExistException,AdminIdOrPwdException;
}
