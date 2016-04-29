package com.jmei.dao;

import java.util.List;
import com.jmei.bean.Mad_rush;
import com.jmei.exception.DAOException;
/**
 * 业务描述：对疯抢商品表的增删改查
 * @author 钟进
 * @date 2016-04-23
 **/
public interface Mad_rushDAO {
	/**
	 * 查询所有的商品
	 * @return List<Mad_rush>  返回商品对象的集合 
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 **/
	public List<Mad_rush> queryByAll()throws DAOException;
	/**
	 * 根据madid查询疯抢商品
	 * @param madid 编号
	 * @return Gtype 返回的商品类型对象 
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * 
	 **/
	
	public Mad_rush queryByMadid(int madid)throws DAOException;
	/**
	 * 根据图片查询商品
	 * @return  Mad_rush 返回商品
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 **/
	public Mad_rush queryByMadpic(String madpic)throws DAOException;
	/**
	 * 插入疯抢商品
	 * @param Mad_rush  商品对象
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * */
	public void inserMad_rush(Mad_rush mad_rush)throws DAOException; 
	/**
	 * 更新疯抢商品信息
	 * @param Mad_rush  商品对象
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * */
	public void updateMad_rush(Mad_rush mad_rush)throws DAOException;
	/**
	 * 根据nadid删除商品
	 * @param madid 商品对象
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * */
	public void delete(int madid )throws DAOException;
}


