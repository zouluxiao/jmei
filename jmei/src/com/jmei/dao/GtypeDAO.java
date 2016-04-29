package com.jmei.dao;

import java.util.List;
import com.jmei.bean.Gtype;
import com.jmei.exception.DAOException;
/**
 * 业务描述：对商品类型表的增删改查
 * @author 钟进
 * @date 2016-04-23
 **/

public interface GtypeDAO {
	/**
	 * 查询所有的类型
	 * @return List<Gtype>  返回类型对象的集合 
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 **/
	public List<Gtype> queryByAll()throws DAOException;
	/**
	 * 根据tid查询商品类型
	 * @param tid 编号
	 * @return Gtype 返回商品类型对象 
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * 
	 **/ 
	public Gtype queryByTid(int tid)throws DAOException;
	/**
	 * 根据类型名字查询商品信息
	 * @return  gtype 返回商品类型对象
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 **/
	public Gtype queryByTname(String tname)throws DAOException;
	/**
	 * 插入商品类型
	 * @param Gtype  商品对象类型对象
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * */
	public void inserGtype(Gtype gtype)throws DAOException; 
	/**
	 * 更新商品类型信息
	 * @param gtype  商品对象类型
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * */
	public void updateGtype(Gtype gtype)throws DAOException;
	/**
	 * 根据tid删除商品类型
	 * @param tid 商品编号
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * */
	public void delete(int tid )throws DAOException;
}