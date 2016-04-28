package com.jmei.dao;

import java.util.List;

import com.jmei.bean.Product;
import com.jmei.exception.DAOException;
/****
 * 	pid number(20) primary key,  	--编号--
	pname varchar2(20),    			--商品名--
	p_isVal number (2)				--是否删除--
 **/


/**
 * 操作Product表获取数据的DAO
 * @since 2016-4-24
 * @author 阳桂东
 * */

public interface ProductDAO {	
	/**
	 * 插入商品信息
	 * @param product  商品对象
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * */
	public void insertProduct(Product product)throws DAOException;
	
	/**
	 * 删除商品
	 * @param pid 商品编号
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * */
	public void deleteProduct(int pid )throws DAOException;
	
	/**
	 * 更新商品信息(编号，商品名，商品是否删除)
	 * @param product  商品对象
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * */
	public void updateProduct(Product product)throws DAOException;
	
	/**
	 * 查询所有商品信息
	 * @return List<Product> 返回的商品对象集合 
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * 
	 **/
	public List<Product> queryAllProduct()throws DAOException;
	
	/**
	 * 根据PID查询商品信息
	 * @param pid 商品编号
	 * @return Product 返回的商品对象 
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * 
	 **/
	public Product queryById(int pid)throws DAOException;
	
	/**
	 * 根据商品名查询商品信息
	 * @param pname 商品名
	 * @return Product 返回的商品对象
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * 
	 **/
	public Product queryByPname(String pname)throws DAOException;
	
}
