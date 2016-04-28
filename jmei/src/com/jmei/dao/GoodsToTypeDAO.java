package com.jmei.dao;

import java.util.List;

import com.jmei.bean.Goods;
import com.jmei.bean.GoodsToType;
import com.jmei.exception.DAOException;

/**
 * @author ����
 * @since 2016-04-23
 * GoodsToType�����ɾ�Ĳ�
 *
 */
public interface GoodsToTypeDAO {
	//��������
	/**
	 * ������Ʒ������
	 * @param gid ��Ʒ�ı��
	 * @param tid ���͵ı��
	 * @throws DAOException DAO���ȡ���ݷ����쳣
	 */
	public void addGoodsToType(int gid,int tid) throws DAOException;
	//�޸�����
	/**
	 * ������Ʒ������
	 * @param gid ��Ʒ�ı��
	 * @param tid ���͵ı��
	 * @param newtid �޸ĺ�ı��
	 * @throws DAOException DAO���ȡ���ݷ����쳣
	 */
	public void updateGoodsToType(int gid,int tid,int newtid) throws DAOException;
	//ɾ������
	/**
	 * ɾ����Ʒ�Ĺ�Ч
	 * @param gid ��Ʒ�ı��
	 * @param tid ���͵ı��
	 * @throws DAOException DAO���ȡ���ݷ����쳣
	 */
	public void deleteGoodsToType(int gid,int tid) throws DAOException;
	//��������
	/**
	 * ����Ʒ�ı�Ų�ѯ��Ʒ��Ӧ������
	 * @param gid ��Ʒ�ı��
	 * @return ��Ʒ��Ӧ���͵ļ��϶���
	 * @throws DAOException DAO���ȡ���ݷ����쳣
	 */
	public List<GoodsToType> queryGoodsToTypeBygid(int gid) throws DAOException;
	/**
	 * �����͵ı�Ų�ѯ��Ʒ��Ӧ�Ĺ�Ч
	 * @param tid ���͵ı��
	 * @return ��Ʒ��Ӧ���͵ļ��϶���
	 * @throws DAOException DAO���ȡ���ݷ����쳣
	 */
	public List<GoodsToType> queryGoodsToTypeBytid(int tid) throws DAOException;
	
	//��ѯ��Ʒͨ����Ʒ����
	/**
	 * ͨ����Ʒ�����Ͳ�ѯ��Ʒ
	 * @param type ��Ʒ������
	 * @return List<Goods> ������Ʒ�ļ��϶���
	 * @throws DAOException DAO���ȡ���ݷ����쳣
	 */
	public List<GoodsToType> queryGoodsByType(String type) throws DAOException;
		
}
