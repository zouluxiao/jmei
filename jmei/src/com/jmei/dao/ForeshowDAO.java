package com.jmei.dao;
import java.util.List;

import com.jmei.bean.Activity;
import com.jmei.bean.Foreshow;
import com.jmei.exception.DAOException;
/**
 * ҵ���������Է������ղ�ѯ�����ɾ�Ĳ�
 * @author �ӽ�
 * @date 2016-04-23
 **/
public interface ForeshowDAO {
	/**
	 * ��ѯ���е���Ʒ
	 * @return List<Foreshow>  ������Ʒ����ļ��� 
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 **/
	public List<Foreshow> queryByAll()throws DAOException;
	/**
	 * ����foreid��ѯ����Ԥ����Ʒ
	 * @param foreid ���
	 * @return ForeShow ������Ʒ����
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * 
	 **/
	
	public Foreshow queryByForeid(int foreid)throws DAOException;
	/**
	 * ����ͼƬ��ѯ��Ʒ
	 * @param forepic ͼƬ
	 * @return  ForeShow ������Ʒ����
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 **/
	public Foreshow queryByForepic(String forepic)throws DAOException;
	/**
	 * ������Ʒ
	 * @param ForeShow  ��Ʒ����
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * */
	public void inserForeShow(Foreshow foreShow)throws DAOException; 
	/**
	 * ���·�����Ʒ��Ϣ
	 * @param ForeShow  ��Ʒ����
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * */
	public void updateForeShow(Foreshow foreShow)throws DAOException;
	/**
	 * ����foreidɾ����Ʒ
	 * @param foreid ��Ʒ���ͱ��
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * */
	public void delete(int foreid)throws DAOException;
}


