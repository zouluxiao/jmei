package com.jmei.service;

import java.util.List;

import com.jmei.bean.CollectionToBuser;
import com.jmei.exception.CollectionBuserNotExist;
import com.jmei.exception.DAOException;
import com.jmei.exception.HasCollectionBuser;
import com.jmei.exception.NotCollectionThisBuser;
import com.jmei.exception.collectionBuserIsNull;

/**
 * 收藏企业模块service接口
 * @author 邹璐
 * @since 2016-04-26
 *
 */

public interface CollectionToBuserService {
	
	/**
	 * 根据普通用户id查询所有收藏店铺
	 * @param jid 普通用户id
	 * @return List<CollectionToBuser> 返回的CollectionToGoods对象集合
	 * @exception  DAOException 数据库异常
	 * @exception 	CollectionBuserNotExist 没有收藏企业
	 **/
	public List<CollectionToBuser> searchCollectionToBuserByJid(int jid)throws DAOException,
	CollectionBuserNotExist;
	
	/**
	 * 根据普通用户id取消收藏
	 * @param jid 普通用户id
	 * @return 
	 * @exception  DAOException 数据库异常
	 * @exception  NotCollectionThisBuser 没有收藏企业异常
	 **/
	public void deleteCollectionBuserByJid(int jid,int bid)throws DAOException,NotCollectionThisBuser ;
	
	/**
	 * 添加企业收藏
	 * @param collectionGoods collectionGoods对象
	 * @return 
	 * @exception  DAOException 数据库异常
	 * @exception HasCollectionBuser 企业已收藏异常
	 * @exception collectionBuserIsNull 添加企业为空异常
	 **/
	public void addCollectionBuserByJid(CollectionToBuser collectionBuser)throws DAOException,HasCollectionBuser,collectionBuserIsNull ;
	
	
}
