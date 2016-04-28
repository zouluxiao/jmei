package com.jmei.service;

import java.util.List;

import com.jmei.bean.CollectionToBuser;
import com.jmei.exception.CollectionBuserNotExist;
import com.jmei.exception.DAOException;
import com.jmei.exception.HasCollectionBuser;
import com.jmei.exception.NotCollectionThisBuser;
import com.jmei.exception.collectionBuserIsNull;

/**
 * �ղ���ҵģ��service�ӿ�
 * @author ���
 * @since 2016-04-26
 *
 */

public interface CollectionToBuserService {
	
	/**
	 * ������ͨ�û�id��ѯ�����ղص���
	 * @param jid ��ͨ�û�id
	 * @return List<CollectionToBuser> ���ص�CollectionToGoods���󼯺�
	 * @exception  DAOException ���ݿ��쳣
	 * @exception 	CollectionBuserNotExist û���ղ���ҵ
	 **/
	public List<CollectionToBuser> searchCollectionToBuserByJid(int jid)throws DAOException,
	CollectionBuserNotExist;
	
	/**
	 * ������ͨ�û�idȡ���ղ�
	 * @param jid ��ͨ�û�id
	 * @return 
	 * @exception  DAOException ���ݿ��쳣
	 * @exception  NotCollectionThisBuser û���ղ���ҵ�쳣
	 **/
	public void deleteCollectionBuserByJid(int jid,int bid)throws DAOException,NotCollectionThisBuser ;
	
	/**
	 * �����ҵ�ղ�
	 * @param collectionGoods collectionGoods����
	 * @return 
	 * @exception  DAOException ���ݿ��쳣
	 * @exception HasCollectionBuser ��ҵ���ղ��쳣
	 * @exception collectionBuserIsNull �����ҵΪ���쳣
	 **/
	public void addCollectionBuserByJid(CollectionToBuser collectionBuser)throws DAOException,HasCollectionBuser,collectionBuserIsNull ;
	
	
}
