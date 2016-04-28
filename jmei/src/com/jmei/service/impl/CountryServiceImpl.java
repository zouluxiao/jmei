package com.jmei.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.jmei.bean.Country;
import com.jmei.dao.CountryDAO;
import com.jmei.exception.DAOException;
import com.jmei.exception.NoCountryException;
import com.jmei.factory.DAOFactory;
import com.jmei.service.CountryService;

/**
 * ������ұ�������߼�����
 * @author ����
 * @since 2016-04-27
 */
public class CountryServiceImpl implements CountryService {
	private final static String COUNTRY_KEY = "CountryDAOImpl";
	
	/**
	 * �����ݿ�����������
	 * @param country ���ӵĹ��Ҷ���
 	 * @throws DAOException DAO���ȡ���ݷ����쳣
 	 * @throws NoCountryException ���Ҳ����� 
	 */
	@Override
	public void addCountry(Country country) 
			throws DAOException,NoCountryException {
		if(country == null){
			throw new NoCountryException("�������Ϊ��");
		}
		CountryDAO dao = (CountryDAO) DAOFactory.newInstance(COUNTRY_KEY);
		Country cou = dao.queryCountryByName(country.getCountry());
		if(cou != null){
			throw new DAOException("�����Ѵ���");
		}
		dao.addCountry(country);
	}

	/**
	 * ͨ�����ұ��ɾ������
	 * @param countryid ���ұ�� 
	 * @throws DAOException DAO���ȡ���ݷ����쳣
	 * NoCountryException û���ҵ��������
	 */
	@Override
	public void deleteCountry(int countryid) throws DAOException,
			NoCountryException {
		CountryDAO dao = (CountryDAO) DAOFactory.newInstance(COUNTRY_KEY);
		Country cou = dao.queryCountryByid(countryid);
		if(cou == null){
			throw new DAOException("���Ҳ�����");
		}
		dao.deleteCountry(countryid);
	}

	/**
	 * ���¹�����Ϣ
	 * @param country ���¹�����Ϣ�����ƣ����죩
	 * @throws DAOException DAO���ȡ���ݷ����쳣
	 * NoCountryException û���ҵ��������
	 */
	@Override
	public void updateCountry(Country country) throws DAOException,
			NoCountryException {
		CountryDAO dao = (CountryDAO) DAOFactory.newInstance(COUNTRY_KEY);
		Country cou = dao.queryCountryByid(country.getCountryid());
		if(cou == null){
			throw new DAOException("���Ҳ�����");
		}
		dao.updateCountry(country);
	}

	/**
	 * ͨ�����ұ�Ų�ѯ����
	 * @param cid ���ұ��
	 * @return Country ���ع��Ҷ���
	 * @throws DAOException DAO���ȡ���ݷ����쳣
	 * NoCountryException û���ҵ��������
	 */
	@Override
	public Country queryCountryByid(int cid) throws DAOException,
			NoCountryException {
		CountryDAO dao = (CountryDAO) DAOFactory.newInstance(COUNTRY_KEY);
		Country cou = dao.queryCountryByid(cid);
		if(cou == null){
			throw new DAOException("���Ҳ�����");
		}
		return cou;
	}

	/**
	 * ͨ�����ҵ����Ʋ�ѯ����
	 * @param country ���ҵ�����
	 * @return Country ���ع��ҵĶ���
	 * @throws DAOException DAO���ȡ���ݷ����쳣
	 * NoCountryException û���ҵ��������
	 */
	@Override
	public Country queryCountryByName(String country) throws DAOException,
			NoCountryException {
		CountryDAO dao = (CountryDAO) DAOFactory.newInstance(COUNTRY_KEY);
		Country cou = dao.queryCountryByName(country);
		if(cou == null){
			throw new DAOException("���Ҳ�����");
		}
		return cou;
	}

	/**
	 * ��ѯ���й���
	 * @return List<Country> ���ع��ҵĶ���
	 * @throws DAOException DAO���ȡ���ݷ����쳣
	 * NoCountryException û���ҵ�����
	 */
	@Override
	public List<Country> queryAllCountry() throws DAOException,
			NoCountryException {
		List<Country> list = new ArrayList<Country>();
		CountryDAO dao = (CountryDAO) DAOFactory.newInstance(COUNTRY_KEY);
		list = dao.queryAllCountry();
		if(list.size() == 0){
			throw new NoCountryException("û���ҵ�����");
		}
		return list;
	}

}
