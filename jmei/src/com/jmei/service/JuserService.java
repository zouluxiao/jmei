package com.jmei.service;

import java.util.List;

import com.jmei.bean.Juser;
import com.jmei.exception.DAOException;
import com.jmei.exception.EmailHasExist;
import com.jmei.exception.EmailHasNotExist;
import com.jmei.exception.NotHaveJuser;
import com.jmei.exception.TelHasExist;
import com.jmei.exception.TelHasNotExist;

/**
 * 普通用户模块Service接口 
 * @author 邹璐
 * @since 2016-04-26
 *
 */
public interface JuserService {
	/**
	 * 根据普通用户id查询用户基本信息
	 * @param jid 普通用户id
	 * @return Juser 返回的Juser对象
	 * @exception DAOException 数据库异常
	 * 
	 **/
	public Juser searchjUserByJid(int jid)throws DAOException;
	
	/**
	 * 根据普通用户名查询用户基本信息
	 * @param jname 普通用户名
	 * @return Juser 返回的Juser对象
	 * @exception DAOException 数据库异常
	 * 
	 **/
	public Juser searchJuserByJname(String jname)throws DAOException;
	
	/**
	 * 根据电话号码登录
	 * @param jtel 电话号码
	 * @return Juser 返回的Juser对象
	 * @exception DAOException 数据库异常
	 * @exception TelHasNotExist 电话号码不存在异常
	 **/
	public Juser loginByJtel(String jtel)throws DAOException,TelHasNotExist;
	
	/**
	 * 根据邮箱登录
	 * @param jemail 邮箱
	 * @return Juser 返回的Juser对象
	 * @exception DAOException 数据库异常
	 * @exception EmailHasNotExist 邮箱不存在异常
	 **/
	public Juser loginByJemail(String jemail)throws DAOException,EmailHasNotExist;
	
	/**
	 * 查询所有用户
	 * @param 
	 * @return List<Juser> 返回的Juser对象集合
	 * @exception DAOException 数据库异常
	 * @exception NotHaveJuser 没有用户异常
	 * 
	 **/
	public List<Juser> queryAllJuser()throws DAOException,NotHaveJuser;
	
	/**
	 * 根据用户id删除用户
	 * @param jid 普通用户id
	 * @param isVal 用户状态
	 * @return 
	 * @exception DAOException 数据库异常
	 * 
	 **/
	public void updateIsValByjid(int jid,int isVal)throws DAOException;
	
	/**
	 * 根据普通用户id修改用户名
	 * @param jid 普通用户id
	 * @param jname 要修改的用户名
	 * @return 
	 * @exception DAOException 数据库异常
	 * 
	 **/
	public void updateJnameByJid(int jid,String jname)throws DAOException;
	
	/**
	 * 根据普通用户id修改邮箱
	 * @param jid 普通用户id
	 * @param jemail 邮箱
	 * @return 
	 * @exception DAOException 数据库异常
	 * 
	 **/
	public void updateJemailByJid(int jid,String jemail)throws DAOException;
	
	/**
	 * 根据普通用户id修改电话号码
	 * @param jid 普通用户id
	 * @param jtel 电话号码
	 * @return 
	 * @exception DAOException 数据库异常
	 * 
	 **/
	public void updateTelByJid(int jid,String jtel)throws DAOException;
	
	/**
	 * 根据用户id修改其他信息
	 * @param jid 普通用户id
	 * @param other 其他信息
	 * @return 
	 * @exception DAOException 数据库异常
	 * 
	 **/
	public void updateOtherByJid(Juser juser)throws DAOException;
	
	/**
	 * 增加用户 （用户所有的信息）
	 * @param juser Juser对象
	 * @exception DAOException 数据库异常
	 * @exception EmailHasExist 邮箱已存在异常
	 * @exception TelHasExist  电话号码已存在异常
	 **/
	public void addJuser(Juser juser)throws DAOException,EmailHasExist,TelHasExist;
	
	/**
	 * 注册方法（快速注册，添加用户名，密码，电话号码，状态）
	 * @param jname 用户名
	 * @param jpwd  用户密码
 	 * @param jtel  用户电话号码
	 * @param is_val 用户状态
	 * @exception DAOException 数据库异常
	 * @exception TelHasExist 电话号码已存在异常
	 */
	public void reg(String jname,String jpwd,String jtel,int isVal)throws DAOException,TelHasExist;
	
	
	


}
