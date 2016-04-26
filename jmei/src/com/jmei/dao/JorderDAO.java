package com.jmei.dao;

import java.util.List;

import com.jmei.bean.Jorder;
import com.jmei.exception.DAOException;
/**
 * 操作jorder表获取数据的DAO
 * @since 2016-4-23
 * @author 邹璐
 * */
public interface JorderDAO {
	/**
	 * 根据普通用户id查询所有订单
	 * @param jid 普通用户id
	 * @return  List<Jorder> 返回的Jorder集合 
	 * @exception DAOException DAO层获取数据过程发生的异常
	 **/
	public List<Jorder> queryAllOrder(int jid) throws DAOException;
	
	/**
	 * 根据普通用户id查询指定状态订单
	 * @param jid 普通用户id
	 * @param is_val 订单状态
	 * @return  List<Jorder> 返回的Jorder集合 
	 * @exception DAOException DAO层获取数据过程发生的异常
	 * 
	 **/
	public List<Jorder> queryOrderByIs_Val(int jid,int is_val) throws DAOException;
	
	/**
	 * 添加订单
	 * @param Jorder Jorder对象
	 * @return  
	 * @exception DAOException DAO层获取数据过程发生的异常
	 **/
	public void addJorder(Jorder jorder) throws DAOException;
	
	/**
	 * 根据订单id修改订单状态
	 * @param jid 普通用户id
	 * @return  
	 * @exception DAOException DAO层获取数据过程发生的异常
	 **/
	public void updateIs_valByJid(int orid,int is_val) throws DAOException;
	
	
	

}
