package com.jmei.dao;

import java.util.List;
import com.jmei.bean.Mad_rush;
import com.jmei.exception.DAOException;
/**
 * ҵ���������Է�����Ʒ�����ɾ�Ĳ�
 * @author �ӽ�
 * @date 2016-04-23
 **/
public interface Mad_rushDAO {
	/**
	 * ��ѯ���е���Ʒ
	 * @return List<Mad_rush>  ������Ʒ����ļ��� 
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 **/
	public List<Mad_rush> queryByAll()throws DAOException;
	/**
	 * ����madid��ѯ������Ʒ
	 * @param madid ���
	 * @return Gtype ���ص���Ʒ���Ͷ��� 
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * 
	 **/
	
	public Mad_rush queryByMadid(int madid)throws DAOException;
	/**
	 * ����ͼƬ��ѯ��Ʒ
	 * @return  Mad_rush ������Ʒ
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 **/
	public Mad_rush queryByMadpic(String madpic)throws DAOException;
	/**
	 * ���������Ʒ
	 * @param Mad_rush  ��Ʒ����
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * */
	public void inserMad_rush(Mad_rush mad_rush)throws DAOException; 
	/**
	 * ���·�����Ʒ��Ϣ
	 * @param Mad_rush  ��Ʒ����
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * */
	public void updateMad_rush(Mad_rush mad_rush)throws DAOException;
	/**
	 * ����nadidɾ����Ʒ
	 * @param madid ��Ʒ����
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * */
	public void delete(int madid )throws DAOException;
}


