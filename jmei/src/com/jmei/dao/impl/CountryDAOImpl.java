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
 * 这个类负责实现接口CountryDAO
 * @author 汤亮
 * @since 2016-04-24
 *
 */
public class CountryDAOImpl implements CountryDAO {

	/**
	 * 向数据库中增加数据
	 * @param country 增加的国家对象
 	 * @throws DAOException DAO层获取数据发生异常
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
		   //把DAO层发生的异常 网络  数据库  全部封装成一个异常   因为这些异常用户无法处理。 
		    //但是用户必须知晓.
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
	 * 通过国家编号删除国家
	 * @param countryid 国家编号 
	 * @throws DAOException DAO层获取数据发生异常
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
		   //把DAO层发生的异常 网络  数据库  全部封装成一个异常   因为这些异常用户无法处理。 
		    //但是用户必须知晓.
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
	 * 更新国家信息
	 * @param country 更新国家信息（名称，国旗）
	 * @throws DAOException DAO层获取数据发生异常
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
		   //把DAO层发生的异常 网络  数据库  全部封装成一个异常   因为这些异常用户无法处理。 
		    //但是用户必须知晓.
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
	 * 通过国家编号查询国家
	 * @param cid 国家编号
	 * @return Country 返回国家对象
	 * @throws DAOException DAO层获取数据发生异常
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
			 //把DAO层发生的异常 网络  数据库  全部封装成一个异常   因为这些异常用户无法处理。 
		    //但是用户必须知晓.
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
	 * 通过国家的名称查询国家
	 * @param country 国家的名称
	 * @return Country 返回国家的对象
	 * @throws DAOException DAO层获取数据发生异常
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
			 //把DAO层发生的异常 网络  数据库  全部封装成一个异常   因为这些异常用户无法处理。 
		    //但是用户必须知晓.
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
	 * 查询所有国家
	 * @return List<Country> 返回国家的对象
	 * @throws DAOException DAO层获取数据发生异常
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
			 //把DAO层发生的异常 网络  数据库  全部封装成一个异常   因为这些异常用户无法处理。 
		    //但是用户必须知晓.
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
