package com.jmei.service;

import java.util.List;

import com.jmei.bean.Buser;
import com.jmei.bean.Mad_rush;
import com.jmei.exception.DAOException;
import com.jmei.exception.Mad_rushExistException;
import com.jmei.exception.Mad_rushNotExistException;

public interface Mad_rushService {
	/**
	 * ��ȡ���е���Ʒ
	 * @return ��Ʒ�ļ���
	 * @throws DAOException ���ݿ��쳣
	 * @throws Mad_rushNotExistException ��Ʒ�������쳣
	 */
	public List<Mad_rush> searchMad_rushs()throws DAOException,Mad_rushNotExistException;
	/**
	 * ������Ʒ��� ��ȡ��Ʒ
	 * @param madid ��Ʒ���
	 * @throws DAOException ���ݿ��쳣
	 * @throwsMad_rushNotExistException ��Ʒ�������쳣
	 */
	public Mad_rush searchMad_rushByMadid(int madid)throws DAOException,Mad_rushNotExistException;
	/**
	 * ������ƷͼƬ ��ȡ��Ʒ
	 * @param madpic ��Ʒ���
	 * @throws DAOException ���ݿ��쳣
	 * @throwsMad_rushNotExistException ��Ʒ�������쳣
	 */
	public Mad_rush searchMad_rushByAcpic(String madpic)throws DAOException,Mad_rushNotExistException;

	/**
	 * �����Ʒ 
	 * @param Mad_rush ��Ʒ��Ϣ
	 * @throws DAOException ���ݿ��쳣
	 * @throws Mad_rushExistException  ��Ʒ�����쳣
	 */
	public void addMad_rush(Mad_rush mad_rush)throws DAOException,Mad_rushExistException;
    /**
     * �޸���Ʒ��Ϣ
     * @param madid ��Ʒ�ı��
     * @param madpic ��Ʒ��ͼƬ
     * @param bid ��Ʒ����ҵ
     * @throws DAOException ���ݿ��쳣
	 * @throws Mad_rushNotExistException  ��Ʒ�������쳣
     */
	public void updateByMad_rushInfo(int madid,String madpic,Buser bid)throws DAOException,Mad_rushNotExistException;
	/**
	 * �޸���Ʒ��ͼƬ
	 * @param madpicPath ͼƬ��·��
	 * @param madid  ��Ʒ��id
	 * @throws DAOException ���ݿ��쳣
	 * @throws Mad_rushNotExistException  ��Ʒ�������쳣
	 */
	public void updateByMad_rushMadpic(String madpicPath,int madid)throws DAOException,Mad_rushNotExistException;
	
	/**
	 * ɾ����Ʒ
	 * @param madid  ��Ʒ��id
	 * @throws DAOException ���ݿ��쳣
	 * @throws Mad_rushNotExistException  ��Ʒ�������쳣
	 */
	public void removeMad_rush(int madid)throws DAOException,Mad_rushNotExistException;

}
