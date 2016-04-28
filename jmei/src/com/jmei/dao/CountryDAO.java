package com.jmei.dao;

import java.util.List;

import com.jmei.bean.Country;
import com.jmei.exception.DAOException;

/**
 * ʵ�ֶ�Country���DAO
 * @author ����
 * @since 2016-04-23
 *
 *
 */
public interface CountryDAO {
	//���ӹ���
	/**
	 * �����ݿ�����������
	 * @param country ���ӵĹ��Ҷ���
 	 * @throws DAOException DAO���ȡ���ݷ����쳣
	 */
	public void addCountry(Country country) throws DAOException;
	//ɾ������
	/**
	 * ͨ�����ұ��ɾ������
	 * @param countryid ���ұ�� 
	 * @throws DAOException DAO���ȡ���ݷ����쳣
	 */
	public void deleteCountry(int countryid) throws DAOException;
	//���¹���
	/**
	 * ���¹�����Ϣ
	 * @param country ���¹�����Ϣ�����ƣ����죩
	 * @throws DAOException DAO���ȡ���ݷ����쳣
	 */
	public void updateCountry(Country country) throws DAOException;
	//��ѯ����ͨ�����
	/**
	 * ͨ�����ұ�Ų�ѯ����
	 * @param cid ���ұ��
	 * @return Country ���ع��Ҷ���
	 * @throws DAOException DAO���ȡ���ݷ����쳣
	 */
	public Country queryCountryByid(int cid) throws DAOException;
	//��ѯ����ͨ����������
	/**
	 * ͨ�����ҵ����Ʋ�ѯ����
	 * @param country ���ҵ�����
	 * @return Country ���ع��ҵĶ���
	 * @throws DAOException DAO���ȡ���ݷ����쳣
	 */
	public Country queryCountryByName(String country) throws DAOException;
	
	/**
	 * ��ѯ���й���
	 * @return List<Country> ���ع��ҵĶ���
	 * @throws DAOException DAO���ȡ���ݷ����쳣
	 */
	public List<Country> queryAllCountry() throws DAOException;
}
