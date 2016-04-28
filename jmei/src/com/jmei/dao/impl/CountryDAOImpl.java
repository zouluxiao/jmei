package com.jmei.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jmei.bean.Buser;
import com.jmei.bean.Country;
import com.jmei.dao.CountryDAO;
import com.jmei.exception.DAOException;
import com.jmei.utils.DBUtils;

/**
 * ����ฺ��ʵ�ֽӿ�CountryDAO
 * @author ����
 * @since 2016-04-24
 *
 */
public class CountryDAOImpl implements CountryDAO {

	/**
	 * �����ݿ�����������
	 * @param country ���ӵĹ��Ҷ���
 	 * @throws DAOException DAO���ȡ���ݷ����쳣
	 */
	public void addCountry(Country country) throws DAOException {
		String sql ="INSERT INTO COUNTRY (countryid,country,cpic) " +
				"VALUES(country_seq.nextval,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, country.getCountry());
			pstmt.setString(2,country.getCpic());
			pstmt.executeUpdate();
		 
		} catch (SQLException e) {
		   //��DAO�㷢�����쳣 ����  ���ݿ�  ȫ����װ��һ���쳣   ��Ϊ��Щ�쳣�û��޷����� 
		    //�����û�����֪��.
		   throw new DAOException(e.getMessage());
		}finally{
			try {
				DBUtils.close(conn, pstmt);
			} catch (SQLException e) {
				 throw new DAOException(e.getMessage());
			}
		}
	}

	/**
	 * ͨ�����ұ��ɾ������
	 * @param countryid ���ұ�� 
	 * @throws DAOException DAO���ȡ���ݷ����쳣
	 */
	public void deleteCountry(int countryid) throws DAOException {
		String sql ="DELETE COUNTRY " +
				" WHERE COUNTRYID=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, countryid); 
			pstmt.executeUpdate();
		 
		} catch (SQLException e) {
		   //��DAO�㷢�����쳣 ����  ���ݿ�  ȫ����װ��һ���쳣   ��Ϊ��Щ�쳣�û��޷����� 
		    //�����û�����֪��.
		   throw new DAOException(e.getMessage());
		}finally{
			try {
				DBUtils.close(conn, pstmt);
			} catch (SQLException e) {
				 throw new DAOException(e.getMessage());
			}
		}
	}

	/**
	 * ���¹�����Ϣ
	 * @param country ���¹�����Ϣ�����ƣ����죩
	 * @throws DAOException DAO���ȡ���ݷ����쳣
	 */
	public void updateCountry(Country country) throws DAOException {
		String sql ="UPDATE COUNTRY SET COUNTRY=?,CPIC=?" +
				" WHERE COUNTRYID=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, country.getCountry());
			pstmt.setString(2,country.getCpic());
			pstmt.setInt(3, country.getCountryid());
			pstmt.executeUpdate();
		 
		} catch (SQLException e) {
		   //��DAO�㷢�����쳣 ����  ���ݿ�  ȫ����װ��һ���쳣   ��Ϊ��Щ�쳣�û��޷����� 
		    //�����û�����֪��.
		   throw new DAOException(e.getMessage());
		}finally{
			try {
				DBUtils.close(conn, pstmt);
			} catch (SQLException e) {
				 throw new DAOException(e.getMessage());
			}
		}
	}

	/**
	 * ͨ�����ұ�Ų�ѯ����
	 * @param cid ���ұ��
	 * @return Country ���ع��Ҷ���
	 * @throws DAOException DAO���ȡ���ݷ����쳣
	 */
	public Country queryCountryByid(int cid) throws DAOException {
		String sql = "SELECT COUNTRYID,COUNTRY,CPIC FROM COUNTRY WHERE COUNTRYID=?";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try{
			conn = DBUtils.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, cid);
			rs = pstm.executeQuery();
			if(rs.next()){
				int countryid = rs.getInt("COUNTRYID");
				String country = rs.getString("COUNTRY");
				String cpic = rs.getString("CPIC");
				Country cou = new Country(countryid, country, cpic);
				return cou;
			}
		}catch(SQLException e){
			 //��DAO�㷢�����쳣 ����  ���ݿ�  ȫ����װ��һ���쳣   ��Ϊ��Щ�쳣�û��޷����� 
		    //�����û�����֪��.
			throw new DAOException(e.getMessage());
		}finally{
			try {
				DBUtils.close(conn, pstm,rs);
			} catch (SQLException e) {
				 throw new DAOException(e.getMessage());
			}
		}
		return null;
	}

	/**
	 * ͨ�����ҵ����Ʋ�ѯ����
	 * @param country ���ҵ�����
	 * @return Country ���ع��ҵĶ���
	 * @throws DAOException DAO���ȡ���ݷ����쳣
	 */
	public Country queryCountryByName(String country) throws DAOException {
		String sql = "SELECT COUNTRYID,COUNTRY,CPIC FROM COUNTRY WHERE COUNTRY=?";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try{
			conn = DBUtils.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, country);
			rs = pstm.executeQuery();
			if(rs.next()){
				int countryid = rs.getInt("COUNTRYID");
				//String country = rs.getString("COUNTRY");
				String cpic = rs.getString("CPIC");
				Country cou = new Country(countryid, country, cpic);
				return cou;
			}
		}catch(SQLException e){
			 //��DAO�㷢�����쳣 ����  ���ݿ�  ȫ����װ��һ���쳣   ��Ϊ��Щ�쳣�û��޷����� 
		    //�����û�����֪��.
			throw new DAOException(e.getMessage());
		}finally{
			try {
				DBUtils.close(conn, pstm,rs);
			} catch (SQLException e) {
				 throw new DAOException(e.getMessage());
			}
		}
		return null;
	}

	/**
	 * ��ѯ���й���
	 * @return List<Country> ���ع��ҵĶ���
	 * @throws DAOException DAO���ȡ���ݷ����쳣
	 */
	public List<Country> queryAllCountry() throws DAOException {
		String sql = "SELECT COUNTRYID,COUNTRY,CPIC FROM COUNTRY";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		ArrayList<Country> list = new ArrayList<Country>();
		try{
			conn = DBUtils.getConnection();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()){
				int countryid = rs.getInt("countryid");
				String country = rs.getString("country");
				String cpic = rs.getString("cpic");
				Country countryObj = new Country(countryid, country, cpic);
				list.add(countryObj);
			}
			return list;
		}catch(SQLException e){
			 //��DAO�㷢�����쳣 ����  ���ݿ�  ȫ����װ��һ���쳣   ��Ϊ��Щ�쳣�û��޷����� 
		    //�����û�����֪��.
			throw new DAOException(e.getMessage());
		}finally{
			try {
				DBUtils.close(conn, pstm,rs);
			} catch (SQLException e) {
				 throw new DAOException(e.getMessage());
			}
		}
	}

}
