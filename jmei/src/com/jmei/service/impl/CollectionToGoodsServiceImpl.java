package com.jmei.service.impl;

import java.util.Iterator;
import java.util.List;

import com.jmei.bean.CollectionToGoods;
import com.jmei.dao.CollectionToGoodsDAO;
import com.jmei.dao.impl.CollectionToGoodsDAOImpl;
import com.jmei.exception.DAOException;
import com.jmei.exception.HasCollectionGoods;
import com.jmei.exception.NotCollectionThisCollection;
import com.jmei.exception.NotCollectionnGoods;
import com.jmei.exception.collectionGoodsIsNull;
import com.jmei.factory.DAOFactory;
import com.jmei.service.CollectionToGoodsService;
/**
 * 实现CollectionToGoodsService接口的类
 * @author 邹璐
 * @since 2016-04-27
 *
 */

public class CollectionToGoodsServiceImpl implements CollectionToGoodsService {
	
	private final static String COG_DAO_KEY = "CollectionToGoodsDAOImpl";
	@Override
	public List<CollectionToGoods> searchCollectionToGoodsByJid(int jid)
			throws DAOException, NotCollectionnGoods {
		//1.创建对象UserDAOImpl对象
		CollectionToGoodsDAO coGDAO = (CollectionToGoodsDAO)DAOFactory.newInstance(COG_DAO_KEY);
		//调用查询所有收藏商品方法
		List<CollectionToGoods> list = coGDAO.queryCollectionToGoodsByJid(jid);
		//判断收藏商品是否为空
		if(list.size() == 0)
			throw new NotCollectionnGoods("没有收藏的商品!");
		return list;
	}

	@Override
	public void deleteCollectionGoodsByJid(int jid, int cbid)
			throws DAOException, NotCollectionThisCollection {
		//1.创建对象UserDAOImpl对象
		CollectionToGoodsDAOImpl coGDAO =  (CollectionToGoodsDAOImpl) DAOFactory.newInstance(COG_DAO_KEY);
		//调用通过cbid查询jid的方法
		int jidt = coGDAO.queryJidByCbid(cbid);
		//判断是否已经收藏该商品
		if(jidt != jid)
			throw new NotCollectionThisCollection("该用户没有收藏该商品!");
		//调用取消收藏方法
		coGDAO.deleteCollectionGoodsByJid(jidt, cbid);
	}

	@Override
	public void addCollectionGoodsByJid(CollectionToGoods collectionGoods)
			throws DAOException, HasCollectionGoods,collectionGoodsIsNull {
		//1.创建对象UserDAOImpl对象
		CollectionToGoodsDAO coGDAO = (CollectionToGoodsDAO)DAOFactory.newInstance(COG_DAO_KEY);
		//判断collectionGoods是否为空
		if(collectionGoods == null)
			throw new collectionGoodsIsNull("添加商品为空!");
		//调用通过用户id查询所有收藏商品方法
		List<CollectionToGoods> list = coGDAO.queryCollectionToGoodsByJid(collectionGoods.getJuser().getJid());
		//迭代所有收藏商品
		Iterator<CollectionToGoods> it= list.iterator();
		
		while(it.hasNext()){
			 CollectionToGoods c =(CollectionToGoods) it.next();
			 //判断是否已经收藏该商品
			 if(c.getGoods().getGid() == collectionGoods.getGoods().getGid())
				 throw new HasCollectionGoods("已收藏该商品!");
		 }
		 //调用添加收藏方法
		 coGDAO.addCollectionGoodsByJid(collectionGoods);

	}

}
