package com.jmei.service;

import java.util.List;
import com.jmei.bean.Gtype;
import com.jmei.exception.DAOException;
import com.jmei.exception.GtypeExistException;
import com.jmei.exception.GtypeNotExistException;
/**
 * @author �ӽ�
 * @since 2016-04-27
 * ���ͱ�service�ӿ�
 */
public interface GtypeService {
	/**
	 * ��ȡ���е�����
	 * @return ���͵ļ���
	 * @throws DAOException ���ݿ��쳣
	 * @throws GtypeNotExistException ��Ʒ�������쳣
	 */
	public List<Gtype> searchGtypes()throws DAOException,GtypeNotExistException;
	/**
	 * �������ͱ�� ��ȡ����
	 * @param tid ���ͱ��
	 * @throws DAOException ���ݿ��쳣
	 * @throwsGtypeNotExistException ��Ʒ�������쳣
	 */
	public Gtype searchGtypeByTid(int tid)throws DAOException,GtypeNotExistException;
	
	/**
	 * ����tid ��ȡ����
	 * @param tname��������
	 * @throws DAOException ���ݿ��쳣
	 * @throwsGtypeNotExistException ��Ʒ�������쳣
	 */
	public Gtype searchGtypeByTname(String tname)throws DAOException,GtypeNotExistException;

	/**
	 * �����Ʒ 
	 * @param Gtype ����
	 * @throws DAOException ���ݿ��쳣
	 * @throws GtypeExistException  ��Ʒ�����쳣
	 */
	public void addGtype(Gtype gtype)throws DAOException,GtypeExistException;
	
    /**
     * �޸�����
     * @param tid ���͵ı��
     * @param tname ��������
     * @throws DAOException ���ݿ��쳣
	 * @throws GtypeNotExistException  ��Ʒ�������쳣
     */
	public void updateByGtypeInfo(int tid,String tname)throws DAOException,GtypeNotExistException;

	/**
	 * ɾ����Ʒ
	 * @param tid ���͵�id
	 * @throws DAOException ���ݿ��쳣
	 * @throws GtypeNotExistException  ��Ʒ�������쳣
	 */
	public void removeGtype(int tid)throws DAOException,GtypeNotExistException;
	
}

