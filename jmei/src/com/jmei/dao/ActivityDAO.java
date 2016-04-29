package com.jmei.dao;
import java.util.List;
import com.jmei.bean.Activity;
import com.jmei.exception.DAOException;
/**
 * 业务描述：对精选商品表的增删改查
 * @author 钟进
 * @date 2016-04-23
 **/
public interface ActivityDAO {
	/**
	 * 查询所有的商品
	 * @return List<Activity>  返回商品对象的集合 
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 **/
	public List<Activity> queryByAll()throws DAOException;
	/**
	 * 根据acid查询精选商品
	 * @param acid 编号
	 * @return Activity 返回商品对象
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * 
	 **/
	
	public Activity queryByAcid(int acid)throws DAOException;
	/**
	 * 根据图片查询商品
	 * @param acpic 图片
	 * @return  Activity 返回商品对象
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 **/
	public Activity queryByAcpic(String acpic)throws DAOException;
	/**
	 * 插入商品
	 * @param Activity 商品对象
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * */
	public void inserActivity(Activity activity)throws DAOException; 
	/**
	 * 根据adid更新精选商品信息
	 * @param Activity 商品对象
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * */
	public void updateActivity(Activity activity)throws DAOException;
	/**
	 * 根据acid删除精选商品
	 * @param acid 商品编号
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * */
	public void delete(int acid)throws DAOException;
}



