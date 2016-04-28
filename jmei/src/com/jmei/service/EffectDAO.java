package com.jmei.dao;

import java.util.List;

import com.jmei.bean.Effect;
import com.jmei.exception.DAOException;
/**
 * 	eid number(20) primary key,  --功效编号--
	ename varchar2(20)			--功效名--**/


/**
 * 操作Effect表获取数据的DAO
 * @since 2016-4-24
 * @author 阳桂东
 * **/
public interface EffectDAO {	
	/**
	 * 增加功效
	 * @param effect  功效对象
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * */
	public void insertEffect(Effect effect)throws DAOException;
	
	/**
	 * 删除功效
	 * @param eid 功效id
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * */
	public void deleteEffect(int eid)throws DAOException;
	
	/**
	 * 更新功效信息(功效编号，功效名)
	 * @param effect  功效对象
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * */
	public void updateEffect(Effect effect)throws DAOException;
	
	/**
	 * 查询所有功效信息
	 * @return List<Effect> 返回的功效对象集合
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * 
	 **/
	public List<Effect> queryAllEffect()throws DAOException;
	
	/**
	 * 根据功效编号查询功效信息
	 * @param eid 功效编号
	 * @return Effect 返回的功效对象 
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * 
	 **/
	public Effect queryById(int eid)throws DAOException;
	
}
