package com.jmei.service.impl;

import com.jmei.bean.Admin;
import com.jmei.dao.AdminDAO;
import com.jmei.exception.AdminIdIsNotExistException;
import com.jmei.exception.AdminIdOrPwdException;
import com.jmei.exception.DAOException;
import com.jmei.factory.DAOFactory;
import com.jmei.service.AdminService;
/**
 * AdminService接口实现类
 * @since 2016-04-27
 * @author 阳桂东
 * **/
public class AdminServiceImpl implements AdminService {
	private final static String ADMIN_DAO_KEY = "AdminDAOImpl"; 
	//按照管理员id登录的方法
	public void loginByAdminId(int adminid, String adminpwd)
			throws DAOException, AdminIdIsNotExistException,
			AdminIdOrPwdException {
		//1.创建对象AdminDAOImpl对象
		AdminDAO adminDAO = (AdminDAO)DAOFactory.newInstance(ADMIN_DAO_KEY);
		//2.调用查询管理员信息的方法
		Admin admin = adminDAO.queryAdminById(adminid);
		//3.判断admin是否为空
		if(admin == null)
			throw new AdminIdIsNotExistException("管理员不存在！");
		if(!adminpwd.equals(admin.getAdminpwd()))
			throw new AdminIdOrPwdException("管理员id或密码错误!");
			
	}
	
}
