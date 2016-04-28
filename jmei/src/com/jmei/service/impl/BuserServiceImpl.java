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
 * 对用户传入的对Buser的请求做逻辑处理
 * @author 汤亮
 * @since 2016-04-27
 */
public class BuserServiceImpl implements BuserService {
	private final static String BUSER_KEY = "BuserDAOImpl";
	
	/**
	 * 企业用户用于登陆的方法
	 * @param uname 企业用户的用户名
	 * @param pwd 企业用户的密码
	 * @exception DAOException 数据库异常
	 * @exception UserNameIsNotExistException 用户名不存在异常
	 * @exception UserNameOrPwdException   用户名或密码错误异常
	 */
	@Override
	public void login(String uname, String pwd) throws DAOException,
			UserNameIsNotExistException, UserNameOrPwdException {
		if(uname == null){
			throw new UserNameIsNotExistException("输入用户名不能为空");
		}
		if(pwd == null){
			throw new UserNameIsNotExistException("输入密码不能为空");
		}
		BuserDAO dao = (BuserDAO) DAOFactory.newInstance(BUSER_KEY);
		Buser buser = dao.queryByBuserName(uname);
		if(buser == null){
			throw new UserNameIsNotExistException("用户不存在");
		}
		if(!pwd.equals(buser.getBpwd())){
			throw new UserNameOrPwdException("用户名和密码不匹配");
		}
		
	}

	/**
	 * 该方法负责企业用户的登出
	 */
	@Override
	public void logout() {
		
	}

	/**
	 * 该方法负责处理注册企业用户的请求
	 * @param buser 注册的企业用户
	 * @exception DAOException 数据库异常
	 * @exception UserNameIsNotExistException 用户名不存在异常
	 */
	@Override
	public void reg(Buser buser) 
			throws DAOException,UserNameIsNotExistException {
		if(buser == null){
			throw new UserNameIsNotExistException("输入用户不存在");
		}
		BuserDAO dao = (BuserDAO) DAOFactory.newInstance(BUSER_KEY);
		Buser bname = dao.queryByBuserName(buser.getBname());
		if(bname != null){
			throw new DAOException("用户已存在");
		}
		dao.addBuser(buser);
	}

	/**
	 * 修改企业用户的基本信息
	 * @param buser 企业用户
	 * @exception DAOException 数据库异常
	 * @exception UserNameIsNotExistException 用户名不存在异常
	 */
	@Override
	public void updateBuser(Buser buser) 
			throws DAOException, UserNameIsNotExistException {
		if(buser == null){
			throw new UserNameIsNotExistException("用户为空");
		}
		BuserDAO dao = (BuserDAO) DAOFactory.newInstance(BUSER_KEY);
		Buser b = dao.queryByBuserId(buser.getBid());
		if(b == null){
			throw new DAOException("用户不存在");
		}
		dao.updateBuser(buser);
	}

	/**
	 * 通过企业用户编号查找企业用户
	 * @param bid
	 * @return Buser 企业用户对象
	 * @exception DAOException 数据库异常
	 * @exception NoBuserException 企业用户不存在
	 */
	@Override
	public Buser searchBybid(int bid) 
			throws DAOException, NoBuserException {
		BuserDAO dao = (BuserDAO) DAOFactory.newInstance(BUSER_KEY);
		Buser buser = dao.queryByBuserId(bid);
		if(buser == null){
			throw new NoBuserException("用户不存在");
		}
		return buser;
	}

	/**
	 * 通过企业用户的名称查询企业用户
	 * @param bname 企业用户的名称
	 * @return Buser 企业用户对象
	 * @exception DAOException 数据库异常
	 * @exception NoBuserException 企业用户不存在
	 */
	@Override
	public Buser searchByBname(String bname) throws DAOException,
			NoBuserException {
		BuserDAO dao = (BuserDAO) DAOFactory.newInstance(BUSER_KEY);
		Buser buser = dao.queryByBuserName(bname);
		if(buser == null){
			throw new NoBuserException("用户不存在");
		}
		return buser;
	}

	/**
	 * 查询所有企业用户
	 * @return 企业用户对象集合
	 * @exception DAOException 数据库异常
	 * @exception NoBuserException 企业用户不存在
	 */
	@Override
	public List<Buser> searchAllBusiness() 
			throws DAOException, NoBuserException {
		List<Buser> list = new ArrayList<Buser>();
		BuserDAO dao = (BuserDAO) DAOFactory.newInstance(BUSER_KEY);
		list = dao.queryAllBusiness();
		if(list.size() == 0){
			throw new NoBuserException("没有用户存在");
		}
		return list;
	}

	/**
	 * 企业用户的收藏量加1
	 * @param bid 企业用户的编号
	 * @exception DAOException 数据库异常
	 * @exception NoBuserException 企业用户不存在
	 */
	@Override
	public void updateBuserColval(int bid) throws DAOException,
			NoBuserException {
		BuserDAO dao = (BuserDAO) DAOFactory.newInstance(BUSER_KEY);
		Buser buser = dao.queryByBuserId(bid);
		if(buser == null){
			throw new NoBuserException("用户不存在");
		}
		dao.updateBuserColVal(bid);
	}

}
