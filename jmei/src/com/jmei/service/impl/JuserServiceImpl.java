package com.jmei.service.impl;

import java.util.List;

import com.jmei.bean.Juser;
import com.jmei.dao.JuserDAO;
import com.jmei.exception.DAOException;
import com.jmei.exception.EmailHasExist;
import com.jmei.exception.JuserIsNull;
import com.jmei.exception.NotHaveJuser;
import com.jmei.exception.NotHaveThisJuser;
import com.jmei.exception.NotHaveThisNameUser;
import com.jmei.exception.TelHasExist;
import com.jmei.exception.UserNameOrPwdException;
import com.jmei.factory.DAOFactory;
import com.jmei.service.JuserService;
/**
 * 实现JuserService接口的类
 * @author 邹璐
 * @since 2016-04-27
 *
 */

public class JuserServiceImpl implements JuserService {
	
	private final static String JUSER_DAO_KEY = "JuserDAOImpl";

	@Override
	public Juser searchjUserByJid(int jid) throws DAOException,NotHaveThisJuser {
		//1.创建对象JuserDAOImpl对象
		JuserDAO userDAO = (JuserDAO)DAOFactory.newInstance(JUSER_DAO_KEY);
		//调用查询用户方法
		Juser juser = userDAO.queryjUserByJid(jid);
		//判断用户是否为空
		if(juser == null)
			throw new NotHaveThisJuser("用户不存在!");
		return juser;
	}

	@Override
	public Juser searchJuserByJname(String jname) throws DAOException,NotHaveThisNameUser {
		//1.创建对象JuserDAOImpl对象
		JuserDAO userDAO = (JuserDAO)DAOFactory.newInstance(JUSER_DAO_KEY);
		//调用查询用户方法
		Juser juser = userDAO.queryJuserByJname(jname);
		//判断用户是否为空
		if(juser == null)
			throw new NotHaveThisNameUser("用户不存在!");
		return juser;
	}

	@Override
	public void loginByJtel(String jtel,String pwd) throws DAOException,NotHaveThisJuser,UserNameOrPwdException {
		//1.创建对象JuserDAOImpl对象
		JuserDAO userDAO = (JuserDAO)DAOFactory.newInstance(JUSER_DAO_KEY);
		//调用查询用户方法
		Juser juser = userDAO.queryJuserByJtel(jtel);
		//判断用户是否为空
		if(juser == null)
			throw new NotHaveThisJuser("用户不存在!");
		if(!pwd.equals(juser.getJpwd()))
			throw new UserNameOrPwdException("用户不存在或密码错误!");
	}

	@Override
	public void loginByJemail(String jemail,String pwd) throws DAOException,
	NotHaveThisJuser,UserNameOrPwdException {
		//1.创建对象JuserDAOImpl对象
		JuserDAO userDAO = (JuserDAO)DAOFactory.newInstance(JUSER_DAO_KEY);
		//调用查询用户方法
		Juser juser = userDAO.queryJuserByJemail(jemail);
		//判断用户是否存在
		if(juser == null)
			throw new NotHaveThisJuser("用户不存在!");
		if(!pwd.equals(juser.getJpwd()))
			throw new UserNameOrPwdException("用户不存在或密码错误!");
	}

	@Override
	public List<Juser> queryAllJuser() throws DAOException, NotHaveJuser {
		//1.创建对象JuserDAOImpl对象
		JuserDAO userDAO = (JuserDAO)DAOFactory.newInstance(JUSER_DAO_KEY);
		//调用查询用户方法
		List<Juser> list = userDAO.queryAllJuser();
		if(list.size() == 0)
			throw new NotHaveJuser("没有用户!");
		return list;
	}

	@Override
	public void updateIsValByjid(int jid, int isVal) throws DAOException,NotHaveThisJuser {
		//1.创建对象JuserDAOImpl对象
		JuserDAO userDAO = (JuserDAO)DAOFactory.newInstance(JUSER_DAO_KEY);
		//调用通过用户id查询用户方法
		Juser user=userDAO.queryjUserByJid(jid);
		//判断用户是否存在
		if(user == null)
			throw new NotHaveThisJuser("用户不存在!");
		//调用删除用户方法
		userDAO.updateIsValByjid(jid, isVal);	
		

	}

	@Override
	public void updateJnameByJid(int jid, String jname) throws DAOException,NotHaveThisJuser {
		//1.创建对象JuserDAOImpl对象
		JuserDAO userDAO = (JuserDAO)DAOFactory.newInstance(JUSER_DAO_KEY);
		//调用通过用户id查询用户方法
		Juser user=userDAO.queryjUserByJid(jid);
		//判断用户是否存在
		if(user == null)
			throw new NotHaveThisJuser("用户不存在!");
		//调用通过用户id修改用户名方法
		userDAO.updateJnameByJid(jid, jname);
	}

	@Override
	public void updateJemailByJid(int jid, String jemail) throws DAOException,NotHaveThisJuser,EmailHasExist {
		//1.创建对象JuserDAOImpl对象
		JuserDAO userDAO = (JuserDAO)DAOFactory.newInstance(JUSER_DAO_KEY);
		//调用通过用户id查询用户方法
		Juser user=userDAO.queryjUserByJid(jid);
		//判断用户是否存在
		if(user == null)
			throw new NotHaveThisJuser("用户不存在!");
		//调用通过邮箱查询用户方法
		Juser users = userDAO.queryJuserByJemail(jemail);
		//判断邮箱是否已存在
		if(users !=null)
			throw new EmailHasExist("邮箱已存在!");
		//调用通过用户id修改用户名方法
		userDAO.updateJemailByJid(jid, jemail);

	}

	@Override
	public void updateTelByJid(int jid, String jtel) throws DAOException,NotHaveThisJuser,TelHasExist {
		//1.创建对象JuserDAOImpl对象
		JuserDAO userDAO = (JuserDAO)DAOFactory.newInstance(JUSER_DAO_KEY);
		//调用通过用户id查询用户方法
		Juser user=userDAO.queryjUserByJid(jid);
		//判断用户是否存在
		if(user == null)
			throw new NotHaveThisJuser("用户不存在!");
		//调用通过电话号码查找用户方法
		Juser users =userDAO.queryJuserByJtel(jtel);
		//判断电话号码是否已存在
		if(users != null)
			throw new TelHasExist("电话号码已存在!");
		//调用通过用户id修改用户名方法
		userDAO.updateTelByJid(jid, jtel);

	}

	@Override
	public void updateOtherByJid(Juser juser) throws DAOException,JuserIsNull,NotHaveThisJuser,
		TelHasExist,EmailHasExist{
		//1.创建对象JuserDAOImpl对象
		JuserDAO userDAO = (JuserDAO)DAOFactory.newInstance(JUSER_DAO_KEY);
		//判断juser是否为空
		if(juser == null)
			throw new JuserIsNull("用户不能为空!");
		//调用通过用户id查询用户方法
		Juser ju = userDAO.queryjUserByJid(juser.getJid());
		//判断用户是否存在
		if(ju == null)
			throw new NotHaveThisJuser("用户不存在!");
		//调用通过电话号码查询用户方法
		Juser jusers = userDAO.queryJuserByJtel(juser.getJtel());
		//判断电话号码是否已存在
		if(jusers != null)
			throw new TelHasExist("电话号码已存在!");
		//通过调用通过邮箱查询用户方法
		ju = userDAO.queryJuserByJemail(juser.getJemail());
		//判断邮箱是否已存在
		if(ju != null)
			throw new EmailHasExist("邮箱已存在!");
		//调用修改其他信息方法
		userDAO.updateOtherByJid(jusers);

	}

	@Override
	public void addJuser(Juser juser) throws DAOException, EmailHasExist,JuserIsNull,
			TelHasExist {
		//1.创建对象JuserDAOImpl对象
		JuserDAO userDAO = (JuserDAO)DAOFactory.newInstance(JUSER_DAO_KEY);
		//判断juser是否为空
		if(juser == null)
			throw new JuserIsNull("用户不能为空!");
		//调用通过电话号码查询用户方法
		Juser jusers = userDAO.queryJuserByJtel(juser.getJtel());
		//判断电话号码是否已存在
		if(jusers != null)
			throw new TelHasExist("电话号码已存在!");
		//通过调用通过邮箱查询用户方法
		jusers = userDAO.queryJuserByJemail(juser.getJemail());
		//判断邮箱是否已存在
		if(jusers != null)
			throw new EmailHasExist("邮箱已存在!");
		//调用添加用户方法
		userDAO.addJuser(jusers);

	}

	@Override
	public void reg(String jname, String jpwd, String jtel, int isVal)
			throws DAOException, TelHasExist {
		//1.创建对象JuserDAOImpl对象
		JuserDAO userDAO = (JuserDAO)DAOFactory.newInstance(JUSER_DAO_KEY);
		//调用通过电话号码查询用户方法
		Juser jusers = userDAO.queryJuserByJtel(jtel);
		//判断电话号码是否已存在
		if(jusers != null)
			throw new TelHasExist("电话号码已存在!");
		//调用注册方法
		userDAO.addJuser(jname, jpwd, jtel, isVal);
	}

}
