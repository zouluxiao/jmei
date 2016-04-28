package com.jmei.dao;

import java.util.List;

import com.jmei.bean.Buser;
import com.jmei.exception.DAOException;

/**
 * @author 汤亮
 * @since 2016-04-23
 * 操作企业用户的DAO
 */
public interface BuserDAO {
	//根据企业用户编号查询企业用户
	/**
	 * 根据企业用户编号查询企业用户信息
	 * @param bid 企业用户编号
	 * @return Buser 返回的Buser对象 
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * 
	 **/
	public Buser queryByBuserId(int bid) throws DAOException;
	//根据企业用户名查询企业用户
	/**
	 * 根据企业用户名查询企业用户信息
	 * @param bname 企业用户名
	 * @return Buser 返回的Buser对象 
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * 
	 **/
	public Buser queryByBuserName(String bname) throws DAOException;
	//查询所有企业用户
	/**
	 * 查询所有企业用户的信息
	 * @return List<Buser> 返回的Buser对象的集合 
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * 
	 **/
	public List<Buser> queryAllBusiness() throws DAOException;
	//根据企业用户编号删除企业用户
	/**
	 * 根据企业用户编号删除用户（修改isVal字段的值）
	 * @param bid 企业用户编号
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * 
	 **/
	public void deleteBuser(int bid) throws DAOException;
	//添加企业用户
	/**
	 * 添加企业用户
	 * @param bid 企业用户编号
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * 
	 **/
	public void addBuser(Buser buser) throws DAOException;
	//更新企业用户
	/**
	 * 更新企业用户
	 * @param bid 企业用户编号
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * 
	 **/
	public void updateBuser(Buser buser) throws DAOException;
	
	/**
	 * 更新收藏量（收藏量加1）
	 * @param bid 企业用户编号
	 * @throws DAOException DAO层获取数据过程发生的异常。
	 */
	public void updateBuserColVal(int bid) throws DAOException;
}
