package com.jmei.service;

import java.util.List;

import com.jmei.bean.Buser;
import com.jmei.exception.DAOException;
import com.jmei.exception.NoBuserException;
import com.jmei.exception.UserNameIsNotExistException;
import com.jmei.exception.UserNameOrPwdException;

/**
 * 对企业用户进行逻辑处理的service层
 * @author 汤亮
 * @since 2016-04-26
 *
 */
public interface BuserService {
	/**
	 * 企业用户用于登陆的方法
	 * @param uname 企业用户的用户名
	 * @param pwd 企业用户的密码
	 * @exception DAOException 数据库异常
	 * @exception UserNameIsNotExistException 用户名不存在异常
	 * @exception UserNameOrPwdException   用户名或密码错误异常
	 */
	public void login(String uname,String pwd)
			throws DAOException,UserNameIsNotExistException,UserNameOrPwdException;
	/**
	 * 该方法负责企业用户的登出
	 */
	public void logout();
	/**
	 * 该方法负责处理注册企业用户的请求
	 * @param buser 注册的企业用户
	 * @exception DAOException 数据库异常
	 * @exception UserNameIsNotExistException 用户名不存在异常
	 */
	public void reg(Buser buser)
			throws DAOException,UserNameIsNotExistException;
	/**
	 * 修改企业用户的基本信息
	 * @param buser 企业用户
	 * @exception DAOException 数据库异常
	 * @exception UserNameIsNotExistException 用户名不存在异常
	 */
	public void updateBuser(Buser buser)
			throws DAOException,UserNameIsNotExistException;
	/**
	 * 通过企业用户编号查找企业用户
	 * @param bid
	 * @return Buser 企业用户对象
	 * @exception DAOException 数据库异常
	 * @exception NoBuserException 企业用户不存在
	 */
	public Buser searchBybid(int bid)
			throws DAOException,NoBuserException;
	/**
	 * 通过企业用户的名称查询企业用户
	 * @param bname 企业用户的名称
	 * @return Buser 企业用户对象
	 * @exception DAOException 数据库异常
	 * @exception NoBuserException 企业用户不存在
	 */
	public Buser searchByBname(String bname)
			throws DAOException,NoBuserException;
	/**
	 * 查询所有企业用户
	 * @return 企业用户对象集合
	 * @exception DAOException 数据库异常
	 * @exception NoBuserException 企业用户不存在
	 */
	public List<Buser> searchAllBusiness()
			throws DAOException,NoBuserException;
	/**
	 * 企业用户的收藏量加1
	 * @param bid 企业用户的编号
	 * @exception DAOException 数据库异常
	 * @exception NoBuserException 企业用户不存在
	 */
	public void updateBuserColval(int bid)
			throws DAOException,NoBuserException;
}
