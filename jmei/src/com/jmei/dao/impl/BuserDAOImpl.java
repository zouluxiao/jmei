package com.jmei.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jmei.bean.Buser;
import com.jmei.bean.Country;
import com.jmei.dao.BuserDAO;
import com.jmei.exception.DAOException;
import com.jmei.utils.DBUtils;

/**
 * @author ����
 * @since 2016-04-24
 * ����ฺ��ʵ��BuserDAO�ӿ�
 *
 */
public class BuserDAOImpl implements BuserDAO {
	
	/**
	 * ������ҵ�û���Ų�ѯ��ҵ�û���Ϣ
	 * @param bid ��ҵ�û����
	 * @return Buser ���ص�Buser���� 
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * */
	public Buser queryByBuserId(int bid) throws DAOException {
		//ͨ���û���Ų�ѯ��ҵ�û�
		String sql = "SELECT bid,bname,blogo,B_isVal,bpwd,"
				+ "bintroduction,bpic,bmpic,col_val,"
				+ "cou.countryid,cou.country,cou.cpic "
				+ "FROM country cou,BUSER bu "
				+ "where bu.countryid = cou.countryid "
				+ "and bu.bid = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try{
			conn = DBUtils.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, bid);
			rs = pstm.executeQuery();
			while(rs.next()){
				String bname = rs.getString("bname");
				String blogo = rs.getString("blogo");
				int isVal = rs.getInt("B_isVal");
				String bpwd = rs.getString("bpwd");
				String bintroduction = rs.getString("bintroduction");
				String bpic = rs.getString("bpic");
				String bmpic = rs.getString("bmpic");
				int col_val = rs.getInt("col_val");
				int countryid = rs.getInt("countryid");
				String country = rs.getString("country");
				String cpic = rs.getString("cpic");
				Country countryObj = new Country(countryid, country, cpic);
				Buser buser = new Buser(bid, bname, blogo, isVal, bpwd, bintroduction, bpic, bmpic, col_val, countryObj);
				return buser;
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
	 * ������ҵ�û�����ѯ��ҵ�û���Ϣ
	 * @param bname ��ҵ�û���
	 * @return Buser ���ص�Buser���� 
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * 
	 **/
	public Buser queryByBuserName(String bname) throws DAOException {
		//ͨ���û����Ʋ�ѯ��ҵ�û�
		String sql = "SELECT bid,bname,blogo,B_isVal,bpwd,"
				+ "bintroduction,bpic,bmpic,col_val,"
				+ "cou.countryid,cou.country,cou.cpic "
				+ "FROM country cou,BUSER bu "
				+ "where bu.countryid = cou.countryid "
				+ "and bu.bname = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try{
			conn = DBUtils.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, bname);
			rs = pstm.executeQuery();
			if(rs.next()){
				int bid = rs.getInt("bid");
				//String bname = rs.getString("bname");
				String blogo = rs.getString("blogo");
				int isVal = rs.getInt("B_isVal");
				String bpwd = rs.getString("bpwd");
				String bintroduction = rs.getString("bintroduction");
				String bpic = rs.getString("bpic");
				String bmpic = rs.getString("bmpic");
				int col_val = rs.getInt("col_val");
				int countryid = rs.getInt("countryid");
				String country = rs.getString("country");
				String cpic = rs.getString("cpic");
				Country countryObj = new Country(countryid, country, cpic);
				Buser buser = new Buser(bid, bname, blogo, isVal, bpwd, bintroduction, bpic, bmpic, col_val, countryObj);
				return buser;
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
	 * ��ѯ������ҵ�û�����Ϣ
	 * @return List<Buser> ���ص�Buser����ļ��� 
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * 
	 **/
	
	public List<Buser> queryAllBusiness() throws DAOException {
		//ͨ���û����Ʋ�ѯ��ҵ�û�
		String sql = "SELECT bid,bname,blogo,B_isVal,bpwd,"
				+ "bintroduction,bpic,bmpic,col_val,"
				+ "cou.countryid,cou.country,cou.cpic "
				+ "FROM country cou,BUSER bu "
				+ "where bu.countryid = cou.countryid ";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		ArrayList<Buser> list = new ArrayList<Buser>();
		try{
			conn = DBUtils.getConnection();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()){
				int bid = rs.getInt("bid");
				String bname = rs.getString("bname");
				String blogo = rs.getString("blogo");
				int isVal = rs.getInt("B_isVal");
				String bpwd = rs.getString("bpwd");
				String bintroduction = rs.getString("bintroduction");
				String bpic = rs.getString("bpic");
				String bmpic = rs.getString("bmpic");
				int col_val = rs.getInt("col_val");
				int countryid = rs.getInt("countryid");
				String country = rs.getString("country");
				String cpic = rs.getString("cpic");
				Country countryObj = new Country(countryid, country, cpic);
				Buser buser = new Buser(bid, bname, blogo, isVal, bpwd, bintroduction, bpic, bmpic, col_val, countryObj);
				list.add(buser);
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

	/**
	 * ������ҵ�û����ɾ���û����޸�isVal�ֶε�ֵ��
	 * @param bid ��ҵ�û����
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * 
	 **/
	public void deleteBuser(int bid) throws DAOException {
		//ͨ���û����ɾ���û����޸ı�־��
		String sql ="UPDATE BUSER SET ISVAL=?" +
				" WHERE BID=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 1); //�����û���1״̬ʧЧ
			pstmt.setInt(2, bid);
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
	 * �����ҵ�û�
	 * @param bid ��ҵ�û����
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * 
	 **/
	public void addBuser(Buser buser) throws DAOException {
		//������ҵ�û�
		String sql ="INSERT INTO BUSER (BID,BNAME,BLOGO,B_ISVAL,BPWD,BINTRODUCTION,BPIC,BMPIC,COL_VAL,COUNTRYID) " +
				"VALUES(bu_seq.nextval,?,?,0,?,?,?,?,0,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, buser.getBname());
			pstmt.setString(2, buser.getBlogo());
			pstmt.setString(3, buser.getBpwd());
			pstmt.setString(4, buser.getBintroduction());
			pstmt.setString(5,buser.getBpic());
			pstmt.setString(6, buser.getBmpic());
			pstmt.setInt(7, buser.getCountry().getCountryid());
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
	 * ������ҵ�û�
	 * @param bid ��ҵ�û����
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * 
	 **/
	public void updateBuser(Buser buser) throws DAOException {
		//������ҵ�û���Ϣ
		String sql ="UPDATE BUSER SET "
				+ "BNAME=?,BLOGO=?,B_ISVAL=?,BPWD=?, BINTRODUCTION=?,"
				+ "BPIC=?,BMPIC=?,COL_VAL=?,COUNTRYID=? "
				+ "WHERE BID=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,buser.getBname());
			pstmt.setString(2,buser.getBlogo());
			pstmt.setInt(3,buser.getIsVal());
			pstmt.setString(4,buser.getBpwd());
			pstmt.setString(5,buser.getBintroduction());
			pstmt.setString(6,buser.getBpic());
			pstmt.setString(7, buser.getBmpic());
			pstmt.setInt(8, buser.getCol_val());
			pstmt.setInt(9, buser.getCountry().getCountryid());
			pstmt.setInt(10,buser.getBid());
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
	 * �����ղ������ղ�����1��
	 * @param bid ��ҵ�û����
	 * @throws DAOException DAO���ȡ���ݹ��̷������쳣��
	 */
	public void updateBuserColVal(int bid) throws DAOException {
		//������ҵ���ղ�����+1��
		String sql ="UPDATE BUSER SET COL_VAL=COL_VAL+1" +
				" WHERE BID=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
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

}
