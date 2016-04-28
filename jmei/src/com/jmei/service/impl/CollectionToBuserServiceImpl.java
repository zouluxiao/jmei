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
 * ʵ��CollectionToBuserService�ӿڵ���
 * @author ���
 * @since 2016-04-27
 *
 */

public class CollectionToBuserServiceImpl implements CollectionToBuserService {
	private final static String COBUSER_DAO_KEY = "CollectionToBuserDAOImpl";
	
	@Override
	public List<CollectionToBuser> searchCollectionToBuserByJid(int jid)
			throws DAOException, CollectionBuserNotExist {
		//1.��������CollectionToBuserDAOImpl����
		CollectionToBuserDAOImpl coBDAO = (CollectionToBuserDAOImpl)DAOFactory.newInstance(COBUSER_DAO_KEY);
		//���ò�ѯ�����ղ���ҵ����
		List<CollectionToBuser> list=coBDAO.queryCollectionToBuserByJid(jid);
		//�ж��ղ��Ƿ�Ϊ��
		if(list.size()==0)
			throw new CollectionBuserNotExist("û���ղص���ҵ!");
		return list;
	}

	@Override
	public void deleteCollectionBuserByJid(int jid, int bid)
			throws DAOException,NotCollectionThisBuser {
		//1.��������CollectionToBuserDAOImpl����
		CollectionToBuserDAOImpl coBDAO = (CollectionToBuserDAOImpl)DAOFactory.newInstance(COBUSER_DAO_KEY);
		//�ж��Ƿ��ղظ���ҵ
		if(coBDAO.queryJidByBid(bid) != bid)
			throw new NotCollectionThisBuser("���û�û���ղظ���ҵ!");
		//����ȡ���ղط���
		coBDAO.deleteCollectionBuserByJid(jid, bid);
	}

	@Override
	public void addCollectionBuserByJid(CollectionToBuser collectionBuser)
			throws DAOException, HasCollectionBuser,collectionBuserIsNull {
		//1.��������CollectionToBuserDAOImpl����
		CollectionToBuserDAOImpl coBDAO = (CollectionToBuserDAOImpl)DAOFactory.newInstance(COBUSER_DAO_KEY);
		//�ж������ҵ�Ƿ�Ϊ��
		if(collectionBuser == null)
			throw new collectionBuserIsNull("�����ҵΪ��!");
		//���ò�ѯ�ղ���ҵ����
		List<CollectionToBuser> list=coBDAO.queryCollectionToBuserByJid(collectionBuser.getJuser().getJid());
		//���������ղ���ҵ
		Iterator<CollectionToBuser> it= list.iterator();
		 while(it.hasNext()){
			 CollectionToBuser c =(CollectionToBuser) it.next();
			 if(c.getBuser().getBid() == collectionBuser.getBuser().getBid())
				 throw new HasCollectionBuser("���ղظ���ҵ!");
		 }
		//�����ղ���ҵ����
		coBDAO.addCollectionBuserByJid(collectionBuser);
	}

}

