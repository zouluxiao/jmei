package com.jmei.service.impl;

import java.util.Iterator;
import java.util.List;

import com.jmei.bean.CollectionToBuser;
import com.jmei.dao.impl.CollectionToBuserDAOImpl;
import com.jmei.exception.CollectionBuserNotExist;
import com.jmei.exception.DAOException;
import com.jmei.exception.HasCollectionBuser;
import com.jmei.exception.NotCollectionThisBuser;
import com.jmei.exception.collectionBuserIsNull;
import com.jmei.factory.DAOFactory;
import com.jmei.service.CollectionToBuserService;
/**
 * 实现CollectionToBuserService接口的类
 * @author 邹璐
 * @since 2016-04-27
 *
 */

public class CollectionToBuserServiceImpl implements CollectionToBuserService {
	private final static String COBUSER_DAO_KEY = "CollectionToBuserDAOImpl";
	
	@Override
	public List<CollectionToBuser> searchCollectionToBuserByJid(int jid)
			throws DAOException, CollectionBuserNotExist {
		//1.创建对象CollectionToBuserDAOImpl对象
		CollectionToBuserDAOImpl coBDAO = (CollectionToBuserDAOImpl)DAOFactory.newInstance(COBUSER_DAO_KEY);
		//调用查询所有收藏企业方法
		List<CollectionToBuser> list=coBDAO.queryCollectionToBuserByJid(jid);
		//判断收藏是否为空
		if(list.size()==0)
			throw new CollectionBuserNotExist("没有收藏的企业!");
		return list;
	}

	@Override
	public void deleteCollectionBuserByJid(int jid, int bid)
			throws DAOException,NotCollectionThisBuser {
		//1.创建对象CollectionToBuserDAOImpl对象
		CollectionToBuserDAOImpl coBDAO = (CollectionToBuserDAOImpl)DAOFactory.newInstance(COBUSER_DAO_KEY);
		//判断是否收藏该企业
		if(coBDAO.queryJidByBid(bid) != bid)
			throw new NotCollectionThisBuser("该用户没有收藏该企业!");
		//调用取消收藏方法
		coBDAO.deleteCollectionBuserByJid(jid, bid);
	}

	@Override
	public void addCollectionBuserByJid(CollectionToBuser collectionBuser)
			throws DAOException, HasCollectionBuser,collectionBuserIsNull {
		//1.创建对象CollectionToBuserDAOImpl对象
		CollectionToBuserDAOImpl coBDAO = (CollectionToBuserDAOImpl)DAOFactory.newInstance(COBUSER_DAO_KEY);
		//判断添加企业是否为空
		if(collectionBuser == null)
			throw new collectionBuserIsNull("添加企业为空!");
		//调用查询收藏企业方法
		List<CollectionToBuser> list=coBDAO.queryCollectionToBuserByJid(collectionBuser.getJuser().getJid());
		//迭代所有收藏企业
		Iterator<CollectionToBuser> it= list.iterator();
		 while(it.hasNext()){
			 CollectionToBuser c =(CollectionToBuser) it.next();
			 if(c.getBuser().getBid() == collectionBuser.getBuser().getBid())
				 throw new HasCollectionBuser("已收藏该企业!");
		 }
		//调用收藏企业方法
		coBDAO.addCollectionBuserByJid(collectionBuser);
	}

}

