package com.jmei.service;

import java.util.List;

import com.jmei.bean.Product;
import com.jmei.exception.DAOException;
import com.jmei.exception.ProductExistException;
import com.jmei.exception.ProductNotExistException;
/**
 * ProductService接口
 * @since 2016-04-27
 * @author 阳桂东
 * **/

public interface ProductService {
	/**
	 * 添加商品 
	 * @param pro 商品信息
	 * @throws DAOException 数据库异常
	 * @throws ProductExistException  商品存在异常
	 */
	public void addProduct(Product pro)throws DAOException,ProductExistException;
	
	/**
	 * 删除商品 
	 * @param pro 商品信息
	 * @throws DAOException 数据库异常
	 * @throws ProductNotExistException  商品不存在异常
	 */
	public void removeProduct(Product pro)throws DAOException,ProductNotExistException;
	
    /**
     * 修改商品信息
     * @param pid 商品的id
     * @param pname 商品的名字
     * @param isVal 商品是否失效
     * @throws DAOException 数据库异常
	 * @throws ProductNotExistException  商品不存在异常
     */
	public void updateByProductInfo(int pid,String name,int isVal)throws DAOException,ProductNotExistException;
	
	/**
	 * 获取所有商品
	 * @return 商品的集合
	 * @throws DAOException 数据库异常
	 * @throws ProductNotExistException 商品不存在异常
	 */
	public List<Product> searchAllProduct()throws DAOException,ProductNotExistException;
	
	/**
	 * 根据商品编号 获取商品
	 * @param id 商品编号
	 * @return 商品的集合
	 * @throws DAOException 数据库异常
	 * @throws ProductNotExistException 商品不存在异常
	 */
	public Product searchProductById(int id)throws DAOException,ProductNotExistException;
	
	/**
	 * 
	 * 根据商品名 获取商品
	 * @param pid 商品编号
	 * @return 商品的集合
	 * @throws DAOException 数据库异常
	 * @throws ProductNotExistException 商品不存在异常
	 */
	public Product searchProductByPname(String pname)throws DAOException,ProductNotExistException;
}
