package com.jmei.dao;
import java.util.List;

import com.jmei.bean.Activity;
import com.jmei.bean.Foreshow;
import com.jmei.exception.DAOException;
/**
 * 业务描述：对疯抢明日查询表的增删改查
 * @author 钟进
 * @date 2016-04-23
 **/
public interface ForeshowDAO {
	/**
	 * 查询所有的商品
	 * @return List<Foreshow>  返回商品对象的集合 
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 **/
	public List<Foreshow> queryByAll()throws DAOException;
	/**
	 * 根据foreid查询明日预告商品
	 * @param foreid 编号
	 * @return ForeShow 返回商品对象
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * 
	 **/
	
	public Foreshow queryByForeid(int foreid)throws DAOException;
	/**
	 * 根据图片查询商品
	 * @param forepic 图片
	 * @return  ForeShow 返回商品对象
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 **/
	public Foreshow queryByForepic(String forepic)throws DAOException;
	/**
	 * 插入商品
	 * @param ForeShow  商品对象
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * */
	public void inserForeShow(Foreshow foreShow)throws DAOException; 
	/**
	 * 更新疯抢商品信息
	 * @param ForeShow  商品对象
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * */
	public void updateForeShow(Foreshow foreShow)throws DAOException;
	/**
	 * 根据foreid删除商品
	 * @param foreid 商品类型编号
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * */
	public void delete(int foreid)throws DAOException;
}


