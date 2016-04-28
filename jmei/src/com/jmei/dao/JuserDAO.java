package com.jmei.dao;

import java.util.List;

import com.jmei.bean.Juser;
import com.jmei.exception.DAOException;

/**
 * 操作collectionToBuser表获取数据的DAO
 * @since 2016-4-23
 * @author 邹璐
 * */
public interface JuserDAO {
	/**
	 * 根据普通用户id查询用户基本信息
	 * @param jid 普通用户id
	 * @return Juser 返回的Juser对象
	 * @exception DAOException DAO层获取数据过程发生的异常
	 * 
	 **/
	public Juser queryjUserByJid(int jid)throws DAOException;
	
	/**
	 * 根据普通用户名查询用户基本信息
	 * @param jname 普通用户名
	 * @return Juser 返回的Juser对象
	 * @exception DAOException DAO层获取数据过程发生的异常
	 * 
	 **/
	public Juser queryJuserByJname(String jname)throws DAOException;
	
	/**
	 * 根据电话号码查询用户基本信息
	 * @param jtel 电话号码
	 * @return Juser 返回的Juser对象
	 * @exception DAOException DAO层获取数据过程发生的异常
	 * 
	 **/
	public Juser queryJuserByJtel(String jtel)throws DAOException;
	/**
	 * 根据邮箱查询用户基本信息
	 * @param jemail 邮箱
	 * @return Juser 返回的Juser对象
	 * @exception DAOException DAO层获取数据过程发生的异常
	 * 
	 **/
	public Juser queryJuserByJemail(String jemail)throws DAOException;
	
	/**
	 * 查询所有用户
	 * @param 
	 * @return List<Juser> 返回的Juser对象集合
	 * @exception DAOException DAO层获取数据过程发生的异常
	 * 
	 **/
	public List<Juser> queryAllJuser()throws DAOException;
	
	/**
	 * 根据用户id删除用户
	 * @param jid 普通用户id
	 * @param isVal 用户状态
	 * @return 
	 * @exception DAOException DAO层获取数据过程发生的异常
	 * 
	 **/
	public void updateIsValByjid(int jid,int isVal)throws DAOException;
	
	/**
	 * 根据普通用户id修改用户名
	 * @param jid 普通用户id
	 * @param jname 要修改的用户名
	 * @return 
	 * @exception DAOException DAO层获取数据过程发生的异常
	 * 
	 **/
	public void updateJnameByJid(int jid,String jname)throws DAOException;
	
	/**
	 * 根据普通用户id修改邮箱
	 * @param jid 普通用户id
	 * @param jemail 邮箱
	 * @return 
	 * @exception DAOException DAO层获取数据过程发生的异常
	 * 
	 **/
	public void updateJemailByJid(int jid,String jemail)throws DAOException;
	
	/**
	 * 根据普通用户id修改电话号码
	 * @param jid 普通用户id
	 * @param jtel 电话号码
	 * @return 
	 * @exception DAOException DAO层获取数据过程发生的异常
	 * 
	 **/
	public void updateTelByJid(int jid,String jtel)throws DAOException;
	
	/**
	 * 根据用户id修改其他信息
	 * @param jid 普通用户id
	 * @param other 其他信息
	 * @return 
	 * @exception DAOException DAO层获取数据过程发生的异常
	 * 
	 **/
	public void updateOtherByJid(Juser juser)throws DAOException;
	
	/**
	 * 增加用户 （用户所有的信息）
	 * @param juser Juser对象
	 * @exception DAOException DAO层获取数据过程发生的异常
	 * 
	 **/
	public void addJuser(Juser juser)throws DAOException;
	
	/**
	 * 增加用户（快速注册，添加用户名，密码，电话号码，状态）
	 * @param jname 用户名
	 * @param jpwd
 	 * @param jtel
	 * @param is_val
	 * @exception DAOException DAO层获取数据过程发生的异常
	 */
	public void addJuser(String jname,String jpwd,String jtel,int isVal)throws DAOException;
	
	/**
	 * 通过用户id修改头像
	 * @param jid 用户id
	 * @param jpic 需要修改的头像图片
	 * @exception DAOException DAO层获取数据过程发生的异常
	 */
	public void updateJpic(int jid,String jpic)throws DAOException;
	
	

}
