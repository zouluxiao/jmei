package com.jmei.service;

import java.util.List;

import com.jmei.bean.Jorder;
import com.jmei.exception.DAOException;
import com.jmei.exception.JorderHasNotExist;
import com.jmei.exception.JorderNotExist;

/**
 * ����ģ��Service�ӿ�
 * @author ���
 * @since  2016-04-26
 *
 */
public interface JorderService {
	/**
	 * ������ͨ�û�id��ѯ���ж���
	 * @param jid ��ͨ�û�id
	 * @return  List<Jorder> ���ص�Jorder���� 
	 * @exception DAOException ���ݿ��쳣
	 * @exception JorderNotExist û�ж����쳣
	 **/
	public List<Jorder> searchAllOrder(int jid) throws DAOException,JorderNotExist;
	
	/**
	 * ������ͨ�û�id��ѯָ��״̬����
	 * @param jid ��ͨ�û�id
	 * @param is_val ����״̬
	 * @return  List<Jorder> ���ص�Jorder���� 
	 * @exception DAOException ���ݿ��쳣
	 * @exception JorderHasNotExist û��ָ��״̬�����쳣
	 **/
	public List<Jorder> queryOrderByIs_Val(int jid,int is_val) throws DAOException,JorderHasNotExist;
	
	/**
	 * ��Ӷ���
	 * @param Jorder Jorder����
	 * @return  
	 * @exception DAOException ���ݿ��쳣
	 **/
	public void addJorder(Jorder jorder) throws DAOException;
	
	/**
	 * ���ݶ���id�޸Ķ���״̬
	 * @param jid ��ͨ�û�id
	 * @return  
	 * @exception DAOException ���ݿ��쳣
	 **/
	public void updateIs_valByJid(int orid,int is_val) throws DAOException;
	
	

}
