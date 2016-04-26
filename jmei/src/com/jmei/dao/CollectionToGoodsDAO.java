package com.jmei.dao;

import java.util.List;



import com.jmei.bean.CollectionToGoods;
import com.jmei.exception.DAOException;

/**
 * ����CollectionToGoods���ȡ���ݵ�DAO
 * @since 2016-4-23
 * @author ���
 * */
public interface CollectionToGoodsDAO {
	/**
	 * ������ͨ�û�id��ѯ�����ղ���Ʒ
	 * @param jid ��ͨ�û�id
	 * @return List<CollectionToGoods> ���ص�CollectionToGoods���󼯺�
	 * @exception  DAOException DAO���ȡ���ݹ��̷������쳣
	 * 
	 **/
	public List<CollectionToGoods> queryCollectionToGoodsByJid(int jid)throws DAOException ;
	
	/**
	 * ������ͨ�û�idȡ���ղ�
	 * @param jid ��ͨ�û�id
	 * @return 
	 * @exception  DAOException DAO���ȡ���ݹ��̷������쳣
	 * 
	 **/
	public void deleteCollectionGoodsByJid(int jid,int cbid)throws DAOException ;
	
	/**
	 * �����Ʒ�ղ�
	 * @param collectionGoods collectionGoods����
	 * @return 
	 * @exception  DAOException DAO���ȡ���ݹ��̷������쳣
	 * 
	 **/
	public void addCollectionGoodsByJid(CollectionToGoods collectionGoods)throws DAOException ;
	
	
}
