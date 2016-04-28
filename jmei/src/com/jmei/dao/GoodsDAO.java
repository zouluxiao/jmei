package com.jmei.dao;

import java.util.List;

import com.jmei.bean.Goods;
import com.jmei.exception.DAOException;

/**
 * @author ����
 * @since 2016-04-23
 * �ýӿ�ʵ�ֶ���Ʒ���DAO
 */
public interface GoodsDAO {
	//��ѯ��Ʒͨ����Ʒ���
	/**
	 * ͨ����Ʒ�ı�Ų�ѯ��Ʒ
	 * @param pid ��Ʒ�ı��
	 * @return List<Goods> ������Ʒ�Ķ��󼯺�
	 * @throws DAOException DAO���ȡ���ݷ����쳣
	 */
	public List<Goods> queryGoodsByPid(int pid) throws DAOException; 
	//��ѯ��Ʒͨ����Ʒ��
	/**
	 * ͨ����Ʒ�����Ʋ�ѯ��Ʒ
	 * @param pname ��Ʒ������
	 * @return List<Goods> ������Ʒ�ļ��϶���
	 * @throws DAOException DAO���ȡ���ݷ����쳣
	 */
	public List<Goods> queryGoodsByPname(String pname) throws DAOException;
	//��ѯ��Ʒͨ����ҵ���
	/**
	 * ͨ����ҵ��Ų�ѯ����ҵ����Ӫ��������Ʒ
	 * @param bid ��ҵ���
	 * @return List<Goods> ������Ʒ�ļ��϶���
	 * @throws DAOException DAO���ȡ���ݷ����쳣
	 */
	public List<Goods> queryGoodsByBid(int bid) throws DAOException;
	//��ѯ��Ʒͨ����ҵ��
	/**
	 * ͨ����ҵ���Ʋ�ѯ����ҵ����Ӫ��������Ʒ
	 * @param bname ��ҵ����
	 * @return List<Goods> ������Ʒ�ļ��϶���
	 * @throws DAOException DAO���ȡ���ݷ����쳣
	 */
	public List<Goods> queryGoodsByBname(String bname) throws DAOException;
	//��ѯ��Ʒͨ����Ʒ����
	/**
	 * ͨ����Ʒ�����Ͳ�ѯ��Ʒ
	 * @param type ��Ʒ������
	 * @return List<Goods> ������Ʒ�ļ��϶���
	 * @throws DAOException DAO���ȡ���ݷ����쳣
	 */
	//public List<Goods> queryGoodsByType(String type) throws DAOException;
	//��ѯ��Ʒͨ����Ʒ����
	/**
	 * ͨ����Ʒ��������ѯ��Ʒ
	 * @param num ��Ʒ������
	 * @return List<Goods> ������Ʒ�ļ��϶���
	 * @throws DAOException DAO���ȡ���ݷ����쳣
	 */
	public List<Goods> queryGoodsByNumber(int num) throws DAOException;
	//��ѯ��Ʒͨ����Ʒ����
	/**
	 * ͨ����Ʒ��������ѯ��Ʒ
	 * @param vol ��Ʒ������
	 * @return List<Goods> ������Ʒ�ļ��϶���
	 * @throws DAOException DAO���ȡ���ݷ����쳣
	 */
	public List<Goods> queryGoodsBySaleVol(int vol) throws DAOException;
	//��ѯ��Ʒͨ����Ʒ�Ĺ�Ч
	/**
	 * ͨ��Ʒ�Ĺ�Ч��ѯ��Ʒ
	 * @param effect ��Ʒ�Ĺ�Ч
	 * @return List<Goods> ������Ʒ�ļ��϶���
	 * @throws DAOException DAO���ȡ���ݷ����쳣
	 */
	//public List<Goods> queryGoodsByEffect(String effect) throws DAOException;
	//��ѯ��Ʒͨ����Ʒ�ϼ�ʱ��
	/**
	 * ͨ���ϼ�ʱ�������Ʒ
	 * @param t1  ��ʼʱ��
	 * @param t2  ����ʱ��
	 * @return List<Goods> ������Ʒ�ļ��϶���
	 * @throws DAOException DAO���ȡ���ݷ����쳣
	 */
	public List<Goods> queryGoodsByUpTime(String t1,String t2) throws DAOException;
	//��ѯ������Ʒ
	/**
	 * ��ѯ������Ʒ
	 * @return List<Goods> ������Ʒ�ļ��϶���
	 * @throws DAOException DAO���ȡ���ݷ����쳣
	 */
	public List<Goods> queryAllGoods() throws DAOException;
	//������Ʒ��ϸ����
	/**
	 * ͨ��gid�ҳ���Ʒ��������Ʒ����ϸ����
	 * @param gid ��Ʒ�ı��
	 * @param Detail ���º����Ʒ����ϸ����
	 * @throws DAOException DAO���ȡ���ݷ����쳣
	 */
	public void updateGoodsDetail(int gid,String Detail) throws DAOException;
	//ͨ����Ʒ���ɾ����Ʒ
	/**
	 * ͨ����Ʒ���ɾ����Ʒ
	 * @param gid ��Ʒ���
	 * @throws DAOException DAO���ȡ���ݷ����쳣
	 */
	public void deleteGoods(int gid) throws DAOException;
	//������Ʒ
	/**
	 * �����Ʒ
	 * @param goods ��ӵ���Ʒ�Ķ���
	 * @throws DAOException DAO���ȡ���ݷ����쳣
	 */
	public void insertGoods(Goods goods) throws DAOException; 
	//��ѯ��Ʒͨ����ϸ����ģ������
	/**
	 * ģ����ѯ��Ʒ����ϸ����
	 * @param detail ��Ʒ����ϸ����
	 * @return List<Goods> ������Ʒ����ļ���
	 * @throws DAOException DAO���ȡ���ݷ����쳣
	 */
	public List<Goods> queryGoodsByDetail(String detail) throws DAOException;
	//������Ʒ�Ļ���
	/**
	 * ������Ʒ����Ϣ
	 * @param goods �ø��µĶ���
	 * @throws DAOException DAO���ȡ���ݷ����쳣
	 */
	public void updateGoods(Goods goods) throws DAOException;
	
	/**
	 * ������Ʒ��������+1��
	 * @param gid �����
	 * @throws DAOException DAO���ȡ���ݷ����쳣
	 */
	public void addGoodsSaleVol(int gid) throws DAOException;
	/**
	 * ������Ʒ���ղأ�+1��
	 * @param gid �����
	 * @throws DAOException DAO���ȡ���ݷ����쳣
	 */
	public void addGoodsColVol(int gid) throws DAOException;

	/**
	 * ͨ����Ʒ�ı�Ų�ѯ��Ʒ
	 * @param gid ��Ʒ�ı��
	 * @return Goods ������Ʒ�Ķ���
	 * @throws DAOException DAO���ȡ���ݷ����쳣
	 */
	public Goods queryGoodsByGid(int gid) throws DAOException; 
}
