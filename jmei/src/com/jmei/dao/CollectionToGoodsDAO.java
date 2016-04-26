package com.jmei.dao;

import java.util.List;



import com.jmei.bean.CollectionToGoods;
import com.jmei.exception.DAOException;

/**
 * 操作CollectionToGoods表获取数据的DAO
 * @since 2016-4-23
 * @author 邹璐
 * */
public interface CollectionToGoodsDAO {
	/**
	 * 根据普通用户id查询所有收藏商品
	 * @param jid 普通用户id
	 * @return List<CollectionToGoods> 返回的CollectionToGoods对象集合
	 * @exception  DAOException DAO层获取数据过程发生的异常
	 * 
	 **/
	public List<CollectionToGoods> queryCollectionToGoodsByJid(int jid)throws DAOException ;
	
	/**
	 * 根据普通用户id取消收藏
	 * @param jid 普通用户id
	 * @return 
	 * @exception  DAOException DAO层获取数据过程发生的异常
	 * 
	 **/
	public void deleteCollectionGoodsByJid(int jid,int cbid)throws DAOException ;
	
	/**
	 * 添加商品收藏
	 * @param collectionGoods collectionGoods对象
	 * @return 
	 * @exception  DAOException DAO层获取数据过程发生的异常
	 * 
	 **/
	public void addCollectionGoodsByJid(CollectionToGoods collectionGoods)throws DAOException ;
	
	
}
