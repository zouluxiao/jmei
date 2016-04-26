package com.jmei.dao;

import java.util.List;

import com.jmei.bean.Jorder;
import com.jmei.exception.DAOException;
/**
 * ����jorder���ȡ���ݵ�DAO
 * @since 2016-4-23
 * @author ���
 * */
public interface JorderDAO {
	/**
	 * ������ͨ�û�id��ѯ���ж���
	 * @param jid ��ͨ�û�id
	 * @return  List<Jorder> ���ص�Jorder���� 
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣
	 **/
	public List<Jorder> queryAllOrder(int jid) throws DAOException;
	
	/**
	 * ������ͨ�û�id��ѯָ��״̬����
	 * @param jid ��ͨ�û�id
	 * @param is_val ����״̬
	 * @return  List<Jorder> ���ص�Jorder���� 
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣
	 * 
	 **/
	public List<Jorder> queryOrderByIs_Val(int jid,int is_val) throws DAOException;
	
	/**
	 * ��Ӷ���
	 * @param Jorder Jorder����
	 * @return  
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣
	 **/
	public void addJorder(Jorder jorder) throws DAOException;
	
	/**
	 * ���ݶ���id�޸Ķ���״̬
	 * @param jid ��ͨ�û�id
	 * @return  
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣
	 **/
	public void updateIs_valByJid(int orid,int is_val) throws DAOException;
	
	
	

}
