package com.jmei.service;

import java.util.List;

import com.jmei.bean.Goods;
import com.jmei.bean.GoodsToEffect;
import com.jmei.bean.GoodsToType;
import com.jmei.exception.DAOException;
import com.jmei.exception.NoSuchGoodsException;

public interface GoodsServices {
	/**
	 * �����Ʒ
	 * @param goods �����Ʒ��
	 * @throws DAOException ���ݿ��쳣
	 * @throws NoSuchGoodsException �����Ʒ������
	 */
	public void addGoods(Goods goods)
			throws DAOException,NoSuchGoodsException;
	
	/**
	 * ͨ����Ʒ���ɾ����Ʒ
	 * @param gid ��Ʒ���
	 * @throws DAOException ���ݿ��쳣
	 * @throws NoSuchGoodsException û����������Ʒ
	 */
	public void deleteGoods(int gid)
			throws DAOException,NoSuchGoodsException;
	
	/**
	 * ������Ʒ
	 * @param goods ������Ʒ�ķ�װ��
	 * @throws DAOException ���ݿ��쳣
	 */
	public void updateGoods(Goods goods)
			throws DAOException,NoSuchGoodsException;
	
	/**
	 * ��ѯ��Ʒ
	 * @param name ��Ʒ������
	 * @return ��Ʒ�Ķ��󼯺�
	 * @throws DAOException ���ݿ��쳣
	 * @throws NoSuchGoodsException û���ҵ���Ʒ
	 */
	public List<Goods> searchGoodsByName(String name)
			throws DAOException,NoSuchGoodsException;
	
	/**
	 * ͨ����ҵ��Ų�ѯ��Ʒ
	 * @param bid ��ҵ���
	 * @return ��Ʒ����ļ���
	 * @throws DAOException ���ݿ��쳣
	 * @throws NoSuchGoodsException û���ҵ���Ʒ
	 */
	public List<Goods> searchGoodsByBid(int bid)
			throws DAOException,NoSuchGoodsException;
	
	/**
	 * ͨ����ҵ���Ʋ�ѯ��Ʒ
	 * @param bname ��ҵ����
	 * @return ��Ʒ����ļ���
	 * @throws DAOException ���ݿ��쳣
	 * @throws NoSuchGoodsException û���ҵ���Ʒ
	 */
	public List<Goods> searchGoodsByBname(String bname)
			throws DAOException,NoSuchGoodsException;
	
	/**
	 * ͨ����Ʒ��Ų�ѯ��Ʒ
	 * @param pid ��Ʒ���
	 * @return ��Ʒ�Ķ��󼯺�
	 * @throws DAOException ���ݿ��쳣
	 * @throws NoSuchGoodsException û���ҵ���Ʒ
	 */
	public List<Goods> searchGoodsByPid(int pid)
			throws DAOException,NoSuchGoodsException;
	
	/**
	 * ͨ����Ʒ���Ͳ�ѯ��Ʒ
	 * @param type ��Ʒ���͵����飨��Ŷ�����ͣ�
	 * @param list ��ɸѡ�ļ���
	 * @return ��Ʒ���͵Ķ��󼯺�
	 * @throws DAOException ���ݿ��쳣
	 * @throws NoSuchGoodsException û���ҵ���Ʒ
	 */
	public List<GoodsToType> searchGoodsByType(String[] type,List list)
			throws DAOException,NoSuchGoodsException;
	/**
	 * ͨ����Ʒ�Ĺ�Ч��ѯ��Ʒ
	 * @param effect ��Ʒ�Ĺ�Ч���飨��Ŷ����Ʒ�Ĺ�Ч��
	 * @param list ��ɸѡ�ļ���
	 * @return ��Ʒ�Ĺ�Ч���󼯺�
	 * @throws DAOException ���ݿ��쳣
	 * @throws NoSuchGoodsException û���ҵ���Ʒ
	 */
	public List<GoodsToEffect> searchGoodsByEffect(String[] effect,List list)
			throws DAOException,NoSuchGoodsException;
	
	/**
	 * ͨ����Ʒ�ı�Ų�ѯ��Ʒ�Ĺ�Ч
	 * @param gid ��Ʒ�ı��
	 * @return ������Ʒ�Ĺ�Ч���󼯺�
	 * @throws DAOException ���ݿ��쳣
	 * @throws NoSuchGoodsException û���ҵ���Ʒ
	 */
	public List<GoodsToEffect> searchGoodsToEffectByGid(int gid)
			throws DAOException,NoSuchGoodsException;
	
	/**
	 * ͨ����Ʒ�ı�Ų�ѯ��Ʒ������
	 * @param gid ��Ʒ�ı��
	 * @return ������Ʒ�����Ͷ��󼯺�
	 * @throws DAOException ���ݿ��쳣
	 * @throws NoSuchGoodsException û���ҵ���Ʒ
	 */
	public List<GoodsToType> searchGoodsToTypeByGid(int gid)
			throws DAOException,NoSuchGoodsException;
	
	/**
	 * ͨ��������ѯ��Ʒ
	 * @param num ��Ʒ������
	 * @return ������Ʒ���󼯺�
	 * @throws DAOException ���ݿ��쳣
	 * @throws NoSuchGoodsException û���ҵ���Ʒ
	 */
	public List<Goods> searchGoodsByNumber(int num)
			throws DAOException,NoSuchGoodsException;
	
	/**
	 * ����Ʒ������������
	 * @param list ��Ʒ�ļ���
	 * @return ���������ĵ���Ʒ����
	 * @throws DAOException ���ݿ��쳣
	 * @throws NoSuchGoodsException û���ҵ���Ʒ
	 */
	public List<Goods> orderBySaleVol(List list)
			throws DAOException,NoSuchGoodsException;
	/**
	 * ���ϼ�ʱ��������
	 * @param list ��Ʒ���϶���
	 * @return ������Ʒ�������ļ���
	 * @throws DAOException ���ݿ��쳣
	 * @throws NoSuchGoodsException û���ҵ���Ʒ
	 */
	public List<Goods> orderByUptime(List list)
			throws DAOException,NoSuchGoodsException;
	/**
	 * ���۸�������
	 * @param list ��Ʒ�ļ���
	 * @return ������Ʒ�����ļ���
	 * @throws DAOException ���ݿ��쳣
	 * @throws NoSuchGoodsException û���ҵ���Ʒ
	 */
	public List<Goods> orderByPriDesc(List list)
			throws DAOException,NoSuchGoodsException;
	/**
	 * ���۸���������
	 * @param list ��Ʒ�ļ���
	 * @return ������Ʒ�����ļ���
	 * @throws DAOException ���ݿ��쳣
	 * @throws NoSuchGoodsException û���ҵ���Ʒ
	 */
	public List<Goods> orderByPriAsc(List list)
			throws DAOException,NoSuchGoodsException;
	
	/**
	 * ����Ʒ�۸�β�ѯ��Ʒ
	 * @param list ��Ʒ�ļ���
	 * @param low �۸�����
	 * @param high �۸�����
	 * @return ������Ʒ�����ļ���
	 * @throws DAOException ���ݿ��쳣
	 * @throws NoSuchGoodsException û���ҵ���Ʒ 
	 */
	public List<Goods> searchByPriArea(List list,int low,int high)
			throws DAOException,NoSuchGoodsException;
	
	/**
	 * ͨ����Ʒ�����Ʋ�ѯ��Ʒ
	 * @param pname ��Ʒ������
	 * @return ������Ʒ�Ķ��󼯺�
	 * @throws DAOException ���ݿ��쳣
	 * @throws NoSuchGoodsException û���ҵ���Ʒ
	 */
	public List<Goods> searchGoodsByPname(String pname)
			throws DAOException,NoSuchGoodsException;
	
	/**
	 * ͨ��gid�ҳ���Ʒ��������Ʒ����ϸ����
	 * @param gid ��Ʒ�ı��
	 * @param Detail ���º����Ʒ����ϸ����
	 * @throws DAOException DAO���ȡ���ݷ����쳣
	 * @throws NoSuchGoodsException û���ҵ���Ʒ
	 */
	public List<Goods> searchGoodsByDetail(String detail)
			throws DAOException,NoSuchGoodsException;
	
	/**
	 * ������Ʒ��������+1��
	 * @param gid �����
	 * @throws DAOException DAO���ȡ���ݷ����쳣
	 */
	public void addSaleVol(int gid)
			throws DAOException,NoSuchGoodsException;
	
	/**
	 * ������Ʒ���ղأ�+1��
	 * @param gid �����
	 * @throws DAOException DAO���ȡ���ݷ����쳣
	 */
	public void addColVol(int gid)
			throws DAOException,NoSuchGoodsException;
	
	/**
	 * ��ѯ��Ʒͨ����Ʒ���
	 * @param gid �����
	 * @return ��Ʒ����
	 * @throws DAOException DAO���ȡ���ݷ����쳣
	 */
	public Goods searchGoodsByGid(int gid)
			throws DAOException,NoSuchGoodsException;
	
	/**
	 * ����Ʒ��Ų�����Ʒ��Ӧ�Ĺ�Ч
	 * @param gid ��Ʒ���
	 * @return ��Ʒ��Ӧ��Ч�ļ��϶���
	 * @throws DAOException DAO���ȡ���ݷ����쳣
	 *//*
	public List<GoodsToEffect> searchGoodsToEffectBygid(int gid) 
			throws DAOException,NoSuchGoodsException;
	
	*//**
	 * ����Ʒ�ı�Ų�ѯ��Ʒ��Ӧ������
	 * @param gid ��Ʒ�ı��
	 * @return ��Ʒ��Ӧ���͵ļ��϶���
	 * @throws DAOException DAO���ȡ���ݷ����쳣
	 *//*
	public List<GoodsToType> searchGoodsToTypeBygid(int gid) 
			throws DAOException,NoSuchGoodsException;*/
}
