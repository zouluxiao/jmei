package com.jmei.service;

import com.jmei.exception.AdminIdIsNotExistException;
import com.jmei.exception.AdminIdOrPwdException;
import com.jmei.exception.DAOException;
/**
 * AdminService接口
 * @since 2016-04-27
 * @author 阳桂东
 * **/


public interface AdminService {
	/**按照管理员id登录的方法
	 * @param adminid 管理员id
	 * @param adminpwd  管理员密码
	 * @exception DAOException 数据库异常
	 * @exception AdminIdIsNotExistException 管理员名不存在异常
	 * @exception AdminNameOrPwdException   管理员名或密码错误异常
	 */
	public void loginByAdminId(int adminid,String adminpwd)
	throws DAOException,AdminIdIsNotExistException,AdminIdOrPwdException;
}
