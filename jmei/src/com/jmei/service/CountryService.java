package com.jmei.service;

import java.util.List;

import com.jmei.bean.Country;
import com.jmei.exception.DAOException;
import com.jmei.exception.NoCountryException;

/**
 * �Թ����ࣨCountry�������߼�����
 * @author ����
 * @since 2016-04-26
 *
 */
public interface CountryService {
	//���ӹ���
	/**
	 * �����ݿ�����������
	 * @param country ���ӵĹ��Ҷ���
 	 * @throws DAOException DAO���ȡ���ݷ����쳣
 	 * @throws NoCountryException ���Ҳ����� 
	 */
	public void addCountry(Country country) 
			throws DAOException,NoCountryException;
	//ɾ������
	/**
	 * ͨ�����ұ��ɾ������
	 * @param countryid ���ұ�� 
	 * @throws DAOException DAO���ȡ���ݷ����쳣
	 * NoCountryException û���ҵ��������
	 */
	public void deleteCountry(int countryid) 
			throws DAOException,NoCountryException;
	//���¹���
	/**
	 * ���¹�����Ϣ
	 * @param country ���¹�����Ϣ�����ƣ����죩
	 * @throws DAOException DAO���ȡ���ݷ����쳣
	 * NoCountryException û���ҵ��������
	 */
	public void updateCountry(Country country) 
			throws DAOException,NoCountryException;
	//��ѯ����ͨ�����
	/**
	 * ͨ�����ұ�Ų�ѯ����
	 * @param cid ���ұ��
	 * @return Country ���ع��Ҷ���
	 * @throws DAOException DAO���ȡ���ݷ����쳣
	 * NoCountryException û���ҵ��������
	 */
	public Country queryCountryByid(int cid) 
			throws DAOException,NoCountryException;
	//��ѯ����ͨ����������
	/**
	 * ͨ�����ҵ����Ʋ�ѯ����
	 * @param country ���ҵ�����
	 * @return Country ���ع��ҵĶ���
	 * @throws DAOException DAO���ȡ���ݷ����쳣
	 * NoCountryException û���ҵ��������
	 */
	public Country queryCountryByName(String country) 
			throws DAOException,NoCountryException;
	
	/**
	 * ��ѯ���й���
	 * @return List<Country> ���ع��ҵĶ���
	 * @throws DAOException DAO���ȡ���ݷ����쳣
	 * NoCountryException û���ҵ�����
	 */
	public List<Country> queryAllCountry() 
			throws DAOException,NoCountryException;
}
