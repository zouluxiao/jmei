package com.jmei.dao;

import java.util.List;

import com.jmei.bean.Effect;
import com.jmei.exception.DAOException;
/**
 * 	eid number(20) primary key,  --��Ч���--
	ename varchar2(20)			--��Ч��--**/


/**
 * ����Effect���ȡ���ݵ�DAO
 * @since 2016-4-24
 * @author ����
 * **/
public interface EffectDAO {	
	/**
	 * ���ӹ�Ч
	 * @param effect  ��Ч����
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * */
	public void insertEffect(Effect effect)throws DAOException;
	
	/**
	 * ɾ����Ч
	 * @param eid ��Чid
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * */
	public void deleteEffect(int eid)throws DAOException;
	
	/**
	 * ���¹�Ч��Ϣ(��Ч��ţ���Ч��)
	 * @param effect  ��Ч����
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * */
	public void updateEffect(Effect effect)throws DAOException;
	
	/**
	 * ��ѯ���й�Ч��Ϣ
	 * @return List<Effect> ���صĹ�Ч���󼯺�
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * 
	 **/
	public List<Effect> queryAllEffect()throws DAOException;
	
	/**
	 * ���ݹ�Ч��Ų�ѯ��Ч��Ϣ
	 * @param eid ��Ч���
	 * @return Effect ���صĹ�Ч���� 
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * 
	 **/
	public Effect queryById(int eid)throws DAOException;
	
}
