package com.jmei.dao;

import java.util.List;

import com.jmei.bean.Admin;
import com.jmei.bean.Pic;
import com.jmei.exception.DAOException;
/**
 * 	adminid number(20) primary key,  --编号--
	adminpwd varchar2(20)			--管理员密码--
	**/

/**
 * 操作Admin表获取数据的DAO
 * @since 2016-4-24
 * @author 阳桂东
 * **/
public interface AdminDAO {	
	/**
	 * 增加管理员
	 * @param admin  管理员对象
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * */
	public void insertAdmin(Admin admin)throws DAOException;
	
	/**
	 * 删除管理员
	 * @param adminid 管理员id
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * */
	public void deleteAdmin(int adminid)throws DAOException;
	
	/**
	 * 更新管理员信息(管理员编号，管理员密码)
	 * @param admin  管理员对象
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * */
	public void updateAdmin(Admin admin)throws DAOException;
	
	/**
	 * 查询所有管理员信息
	 * @return List<Admin> 返回的管理员对象集合 
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * 
	 **/
	public List<Admin> queryAllAdmin()throws DAOException;
	
	/**
	 * 根据管理员编号查询管理员信息
	 * @param adminid 管理员编号
	 * @return Admin 返回的管理员对象 
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * 
	 **/
	public Admin queryAdminById(int adminid)throws DAOException;
	
}
