package com.jmei.dao;

import java.util.List;
import com.jmei.bean.Gtype;
import com.jmei.exception.DAOException;
/**
 * ҵ������������Ʒ���ͱ����ɾ�Ĳ�
 * @author �ӽ�
 * @date 2016-04-23
 **/

public interface GtypeDAO {
	/**
	 * ��ѯ���е�����
	 * @return List<Gtype>  �������Ͷ���ļ��� 
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 **/
	public List<Gtype> queryByAll()throws DAOException;
	/**
	 * ����tid��ѯ��Ʒ����
	 * @param tid ���
	 * @return Gtype ������Ʒ���Ͷ��� 
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * 
	 **/ 
	public Gtype queryByTid(int tid)throws DAOException;
	/**
	 * �����������ֲ�ѯ��Ʒ��Ϣ
	 * @return  gtype ������Ʒ���Ͷ���
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 **/
	public Gtype queryByTname(String tname)throws DAOException;
	/**
	 * ������Ʒ����
	 * @param Gtype  ��Ʒ�������Ͷ���
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * */
	public void inserGtype(Gtype gtype)throws DAOException; 
	/**
	 * ������Ʒ������Ϣ
	 * @param gtype  ��Ʒ��������
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * */
	public void updateGtype(Gtype gtype)throws DAOException;
	/**
	 * ����tidɾ����Ʒ����
	 * @param tid ��Ʒ���
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * */
	public void delete(int tid )throws DAOException;
}