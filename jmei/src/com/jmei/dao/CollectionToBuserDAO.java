package com.jmei.dao;

import java.util.List;

import com.jmei.bean.CollectionToBuser;
import com.jmei.exception.DAOException;

/**
 * ����collectionToBuser���ȡ���ݵ�DAO
 * @since 2016-4-23
 * @author ���
 * */

public interface CollectionToBuserDAO {
	/**
	 * ������ͨ�û�id��ѯ�����ղص���
	 * @param jid ��ͨ�û�id
	 * @return List<CollectionToBuser> ���ص�CollectionToGoods���󼯺�
	 * @exception  DAOException DAO���ȡ���ݹ��̷������쳣
	 * 
	 **/
	public List<CollectionToBuser> queryCollectionToBuserByJid(int jid)throws DAOException ;
	
	/**
	 * ������ͨ�û�idȡ���ղ�
	 * @param jid ��ͨ�û�id
	 * @return 
	 * @exception  DAOException DAO���ȡ���ݹ��̷������쳣
	 * 
	 **/
	public void deleteCollectionBuserByJid(int jid,int bid)throws DAOException ;
	
	/**
	 * �����ҵ�ղ�
	 * @param collectionGoods collectionGoods����
	 * @return 
	 * @exception  DAOException DAO���ȡ���ݹ��̷������쳣
	 * 
	 **/
	public void addCollectionBuserByJid(CollectionToBuser collectionBuser)throws DAOException ;
}
