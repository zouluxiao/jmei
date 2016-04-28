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
 * ʵ��CollectionToGoodsService�ӿڵ���
 * @author ���
 * @since 2016-04-27
 *
 */

public class CollectionToGoodsServiceImpl implements CollectionToGoodsService {
	
	private final static String COG_DAO_KEY = "CollectionToGoodsDAOImpl";
	@Override
	public List<CollectionToGoods> searchCollectionToGoodsByJid(int jid)
			throws DAOException, NotCollectionnGoods {
		//1.��������UserDAOImpl����
		CollectionToGoodsDAO coGDAO = (CollectionToGoodsDAO)DAOFactory.newInstance(COG_DAO_KEY);
		//���ò�ѯ�����ղ���Ʒ����
		List<CollectionToGoods> list = coGDAO.queryCollectionToGoodsByJid(jid);
		//�ж��ղ���Ʒ�Ƿ�Ϊ��
		if(list.size() == 0)
			throw new NotCollectionnGoods("û���ղص���Ʒ!");
		return list;
	}

	@Override
	public void deleteCollectionGoodsByJid(int jid, int cbid)
			throws DAOException, NotCollectionThisCollection {
		//1.��������UserDAOImpl����
		CollectionToGoodsDAOImpl coGDAO =  (CollectionToGoodsDAOImpl) DAOFactory.newInstance(COG_DAO_KEY);
		//����ͨ��cbid��ѯjid�ķ���
		int jidt = coGDAO.queryJidByCbid(cbid);
		//�ж��Ƿ��Ѿ��ղظ���Ʒ
		if(jidt != jid)
			throw new NotCollectionThisCollection("���û�û���ղظ���Ʒ!");
		//����ȡ���ղط���
		coGDAO.deleteCollectionGoodsByJid(jidt, cbid);
	}

	@Override
	public void addCollectionGoodsByJid(CollectionToGoods collectionGoods)
			throws DAOException, HasCollectionGoods,collectionGoodsIsNull {
		//1.��������UserDAOImpl����
		CollectionToGoodsDAO coGDAO = (CollectionToGoodsDAO)DAOFactory.newInstance(COG_DAO_KEY);
		//�ж�collectionGoods�Ƿ�Ϊ��
		if(collectionGoods == null)
			throw new collectionGoodsIsNull("�����ƷΪ��!");
		//����ͨ���û�id��ѯ�����ղ���Ʒ����
		List<CollectionToGoods> list = coGDAO.queryCollectionToGoodsByJid(collectionGoods.getJuser().getJid());
		//���������ղ���Ʒ
		Iterator<CollectionToGoods> it= list.iterator();
		
		while(it.hasNext()){
			 CollectionToGoods c =(CollectionToGoods) it.next();
			 //�ж��Ƿ��Ѿ��ղظ���Ʒ
			 if(c.getGoods().getGid() == collectionGoods.getGoods().getGid())
				 throw new HasCollectionGoods("���ղظ���Ʒ!");
		 }
		 //��������ղط���
		 coGDAO.addCollectionGoodsByJid(collectionGoods);

	}

}
