package com.jmei.service;

import java.util.List;

import com.jmei.bean.CollectionToGoods;
import com.jmei.exception.DAOException;
import com.jmei.exception.HasCollectionGoods;
import com.jmei.exception.NotCollectionThisCollection;
import com.jmei.exception.NotCollectionnGoods;
import com.jmei.exception.collectionGoodsIsNull;

/**
 * �ղ���Ʒģ��Service�ӿ�
 * @author ���
 * @since 2016-04-26
 *
 */

public interface CollectionToGoodsService {
	
	/**
	 * ������ͨ�û�id��ѯ�����ղ���Ʒ
	 * @param jid ��ͨ�û�id
	 * @return List<CollectionToGoods> ���ص�CollectionToGoods���󼯺�
	 * @exception  DAOException ���ݿ��쳣
	 * @exception NotCollectionnGoods û���ղ���Ʒ�쳣
	 **/
	public List<CollectionToGoods> searchCollectionToGoodsByJid(int jid)throws DAOException
	,NotCollectionnGoods;
	
	/**
	 * ������ͨ�û�idȡ���ղ�
	 * @param jid ��ͨ�û�id
	 * @return 
	 * @exception  DAOException ���ݿ��쳣
	 * @exception NotCollectionThisCollection û���ղش���Ʒ;
	 **/
	public void deleteCollectionGoodsByJid(int jid,int cbid)throws DAOException,NotCollectionThisCollection ;
	
	/**
	 * �����Ʒ�ղ�
	 * @param collectionGoods collectionGoods����
	 * @return 
	 * @exception  DAOException ���ݿ��쳣
	 * @exception  HasCollectionGoods ��Ʒ���ղ��쳣
	 * @exception  collectionGoodsIsNull �����ƷΪ���쳣
	 **/
	public void addCollectionGoodsByJid(CollectionToGoods collectionGoods)throws DAOException,HasCollectionGoods,collectionGoodsIsNull ;
}
