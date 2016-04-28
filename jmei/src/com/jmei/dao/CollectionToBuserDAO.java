package com.jmei.dao;

import java.util.List;

import com.jmei.bean.CollectionToBuser;
import com.jmei.exception.DAOException;

/**
 * 操作collectionToBuser表获取数据的DAO
 * @since 2016-4-23
 * @author 邹璐
 * */

public interface CollectionToBuserDAO {
	/**
	 * 根据普通用户id查询所有收藏店铺
	 * @param jid 普通用户id
	 * @return List<CollectionToBuser> 返回的CollectionToGoods对象集合
	 * @exception  DAOException DAO层获取数据过程发生的异常
	 * 
	 **/
	public List<CollectionToBuser> queryCollectionToBuserByJid(int jid)throws DAOException ;
	
	/**
	 * 根据普通用户id取消收藏
	 * @param jid 普通用户id
	 * @return 
	 * @exception  DAOException DAO层获取数据过程发生的异常
	 * 
	 **/
	public void deleteCollectionBuserByJid(int jid,int bid)throws DAOException ;
	
	/**
	 * 添加企业收藏
	 * @param collectionGoods collectionGoods对象
	 * @return 
	 * @exception  DAOException DAO层获取数据过程发生的异常
	 * 
	 **/
	public void addCollectionBuserByJid(CollectionToBuser collectionBuser)throws DAOException ;
}
