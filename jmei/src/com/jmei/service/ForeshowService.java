package com.jmei.service;

import java.util.List;
import com.jmei.bean.Buser;
import com.jmei.bean.Foreshow;
import com.jmei.exception.DAOException;
import com.jmei.exception.ForeshowExistException;
import com.jmei.exception.ForeshowNotExistException;
/**
 * @author �ӽ�
 * @since 2016-04-27
 * ����Ԥѡ���service�ӿ�
 */
public interface ForeshowService {
	/**
	 * ��ȡ���е���Ʒ
	 * @return ��Ʒ�ļ���
	 * @throws DAOException ���ݿ��쳣
	 * @throws ForeshowNotExistException ��Ʒ�������쳣
	 */
	public List<Foreshow> searchForeshows()throws DAOException,ForeshowNotExistException;
	/**
	 * ������Ʒ��� ��ȡ��Ʒ
	 * @param foreid ��Ʒ���
	 * @throws DAOException ���ݿ��쳣
	 * @throwsForeshowNotExistException ��Ʒ�������쳣
	 */
	public Foreshow searchForeshowByForeid(int foreid)throws DAOException,ForeshowNotExistException;
	
	/**
	 * ������ƷͼƬ ��ȡ��Ʒ
	 * @param forepic ��Ʒ���
	 * @throws DAOException ���ݿ��쳣
	 * @throwsForeshowNotExistException ��Ʒ�������쳣
	 */
	public Foreshow searchForeshowByForepic(String forepic)throws DAOException,ForeshowNotExistException;

	/**
	 * �����Ʒ 
	 * @param Foreshow ��Ʒ��Ϣ
	 * @throws DAOException ���ݿ��쳣
	 * @throws ForeshowExistException  ��Ʒ�����쳣
	 */
	public void addForeshow(Foreshow foreshow)throws DAOException,ForeshowExistException;
	
    /**
     * �޸���Ʒ��Ϣ
     * @param foreid ��Ʒ�ı��
     * @param forepic ��Ʒ��ͼƬ
     * @param bid ��Ʒ����ҵ
     * @throws DAOException ���ݿ��쳣
	 * @throws ForeshowNotExistException  ��Ʒ�������쳣
     */
	public void updateByForeshowInfo(int foreid,String forepic,Buser bid)throws DAOException,ForeshowNotExistException;
	
	/**
	 * �޸���Ʒ��ͼƬ
	 * @param forepicPath ͼƬ��·��
	 * @param foreid  ��Ʒ��id
	 * @throws DAOException ���ݿ��쳣
	 * @throws ForeshowNotExistException  ��Ʒ�������쳣
	 */
	public void updateByForeshowForepic(String forepicPath,int foreid)throws DAOException,ForeshowNotExistException;
	
	
	
	/**
	 * ɾ����Ʒ
	 * @param acid  ��Ʒ��id
	 * @throws DAOException ���ݿ��쳣
	 * @throws ProductNotExistException  ��Ʒ�������쳣
	 */
	public void removeForeshow(int foreid)throws DAOException,ForeshowNotExistException;
	
}


