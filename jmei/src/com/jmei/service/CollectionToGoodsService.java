package com.jmei.service;

import java.util.List;

import com.jmei.bean.CollectionToGoods;
import com.jmei.exception.DAOException;
import com.jmei.exception.HasCollectionGoods;
import com.jmei.exception.NotCollectionThisCollection;
import com.jmei.exception.NotCollectionnGoods;
import com.jmei.exception.collectionGoodsIsNull;

/**
 * 收藏商品模块Service接口
 * @author 邹璐
 * @since 2016-04-26
 *
 */

public interface CollectionToGoodsService {
	
	/**
	 * 根据普通用户id查询所有收藏商品
	 * @param jid 普通用户id
	 * @return List<CollectionToGoods> 返回的CollectionToGoods对象集合
	 * @exception  DAOException 数据库异常
	 * @exception NotCollectionnGoods 没有收藏商品异常
	 **/
	public List<CollectionToGoods> searchCollectionToGoodsByJid(int jid)throws DAOException
	,NotCollectionnGoods;
	
	/**
	 * 根据普通用户id取消收藏
	 * @param jid 普通用户id
	 * @return 
	 * @exception  DAOException 数据库异常
	 * @exception NotCollectionThisCollection 没有收藏此商品;
	 **/
	public void deleteCollectionGoodsByJid(int jid,int cbid)throws DAOException,NotCollectionThisCollection ;
	
	/**
	 * 添加商品收藏
	 * @param collectionGoods collectionGoods对象
	 * @return 
	 * @exception  DAOException 数据库异常
	 * @exception  HasCollectionGoods 商品已收藏异常
	 * @exception  collectionGoodsIsNull 添加商品为空异常
	 **/
	public void addCollectionGoodsByJid(CollectionToGoods collectionGoods)throws DAOException,HasCollectionGoods,collectionGoodsIsNull ;
}
