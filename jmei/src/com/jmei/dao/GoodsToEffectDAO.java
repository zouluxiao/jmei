package com.jmei.dao;

import java.util.List;

import com.jmei.bean.Goods;
import com.jmei.bean.GoodsToEffect;
import com.jmei.exception.DAOException;

/**
 * @author ����
 * @since 2016-04-23
 * ʵ�ֶ�GoodsToEffect�����ɾ�Ĳ����
 */
public interface GoodsToEffectDAO {
	//��������
	/**
	 * ������Ʒ�Ĺ�Ч
	 * @param gid ��Ʒ�ı��
	 * @param eid ��Ч�ı��
	 * @throws DAOException DAO���ȡ���ݷ����쳣
	 */
	public void addGoodsToEffect(int gid,int eid) throws DAOException;
	//�޸�����
	/**
	 * �޸���Ʒ�Ĺ�Ч
	 * @param gid ��Ʒ�ı��
	 * @param eid ��Ч�ı��
	 * @param neweid �޸ĺ�ı��
	 * @throws DAOException DAO���ȡ���ݷ����쳣
	 */
	public void updateGoodsToEffect(int gid,int eid,int neweid) throws DAOException;
	//ɾ������
	/**
	 * ɾ����Ʒ�Ĺ�Ч
	 * @param gid ��Ʒ�ı��
	 * @param eid ��Ч�ı��
	 * @throws DAOException DAO���ȡ���ݷ����쳣
	 */
	public void deleteGoodsToEffect(int gid,int eid) throws DAOException;
	//��������
	/**
	 * ����Ʒ��Ų�����Ʒ��Ӧ�Ĺ�Ч
	 * @param gid ��Ʒ���
	 * @return ��Ʒ��Ӧ��Ч�ļ��϶���
	 * @throws DAOException DAO���ȡ���ݷ����쳣
	 */
	public List<GoodsToEffect> queryGoodsToEffectBygid(int gid) throws DAOException;
	/**
	 * ����Ч�ı�Ų�ѯ��Ʒ��Ӧ�Ĺ�Ч
	 * @param eid ��Ч�ı��
	 * @return ��Ʒ��Ӧ��Ч�ļ��϶���
	 * @throws DAOException DAO���ȡ���ݷ����쳣
	 */
	public List<GoodsToEffect> queryGoodsToEffectByeid(int eid) throws DAOException;
	
	//��ѯ��Ʒͨ����Ʒ�Ĺ�Ч
	/**
	 * ͨ��Ʒ�Ĺ�Ч��ѯ��Ʒ
	 * @param effect ��Ʒ�Ĺ�Ч
	 * @return List<Goods> ������Ʒ�ļ��϶���
	 * @throws DAOException DAO���ȡ���ݷ����쳣
	 */
	public List<GoodsToEffect> queryGoodsByEffect(String effect) throws DAOException;
		
}
