package com.jmei.service;

import java.util.List;

import com.jmei.bean.Jorder;
import com.jmei.exception.DAOException;
import com.jmei.exception.JorderHasNotExist;
import com.jmei.exception.JorderNotExist;

/**
 * 订单模块Service接口
 * @author 邹璐
 * @since  2016-04-26
 *
 */
public interface JorderService {
	/**
	 * 根据普通用户id查询所有订单
	 * @param jid 普通用户id
	 * @return  List<Jorder> 返回的Jorder集合 
	 * @exception DAOException 数据库异常
	 * @exception JorderNotExist 没有订单异常
	 **/
	public List<Jorder> searchAllOrder(int jid) throws DAOException,JorderNotExist;
	
	/**
	 * 根据普通用户id查询指定状态订单
	 * @param jid 普通用户id
	 * @param is_val 订单状态
	 * @return  List<Jorder> 返回的Jorder集合 
	 * @exception DAOException 数据库异常
	 * @exception JorderHasNotExist 没有指定状态订单异常
	 **/
	public List<Jorder> queryOrderByIs_Val(int jid,int is_val) throws DAOException,JorderHasNotExist;
	
	/**
	 * 添加订单
	 * @param Jorder Jorder对象
	 * @return  
	 * @exception DAOException 数据库异常
	 **/
	public void addJorder(Jorder jorder) throws DAOException;
	
	/**
	 * 根据订单id修改订单状态
	 * @param jid 普通用户id
	 * @return  
	 * @exception DAOException 数据库异常
	 **/
	public void updateIs_valByJid(int orid,int is_val) throws DAOException;
	
	

}
