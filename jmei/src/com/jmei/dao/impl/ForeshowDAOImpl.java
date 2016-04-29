package com.jmei.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.jmei.bean.Buser;
import com.jmei.bean.Country;
import com.jmei.bean.Foreshow;
import com.jmei.dao.ForeshowDAO;
import com.jmei.exception.DAOException;
import com.jmei.utils.DBUtils;
/**
 * ҵ��������ForeshowDAO��ʵ����
 * @author �ӽ�
 * @date 2016-04-23
 **/
public class ForeshowDAOImpl implements ForeshowDAO {
	/**
	 * ��ѯ���е���Ʒ
	 * @return List<Foreshow>  ������Ʒ����ļ��� 
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 **/
	public List<Foreshow> queryByAll()throws DAOException {
		//1.����DBUtils���߰� �������� Ȼ���ȡ����
		String sql ="SELECT f.foreid,f.forepic,b.bid,"
				+ "b.bname,b.blogo,b.B_isVal,b.bpwd,"
				+ "b.bintroduction,b.bpic,b.bmpic,"
				+ "b.col_val,cou.countryid,cou.country,"
				+ "cou.cpic"+
				" FROM FORESHOW f,BUSER b,COUNTRY cou "+
				" WHERE f.foreid = b.bid and b.countryid = cou.countryid";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<Foreshow> foreshows = new ArrayList<Foreshow>();
			if(rs.next()){
				int foreid = rs.getInt("foreid");
				String forepic = rs.getString("forepic");
				int bid = rs.getInt("bid");
				String bname = rs.getString("bname");
				String blogo = rs.getString("blogo");
				int B_isVal = rs.getInt("B_isVal");
				String bpwd = rs.getString("bpwd");
				String bintroduction = rs.getString("bintroduction");
				String bpic = rs.getString("bpic");
				String bmpic = rs.getString("bmpic");
				int col_val = rs.getInt("col_val");
				int countryid = rs.getInt("countryid");
				String country = rs.getString("country");
				String cpic = rs.getString("cpic");
				Country cou = new Country(countryid, country, cpic);
				Buser buser = new Buser(bid, bname, blogo, B_isVal, bpwd, bintroduction, bpic, bmpic, col_val, cou);
				Foreshow foreshow = new Foreshow(foreid, forepic, buser);
				foreshows.add(foreshow);
				return foreshows;
			}
		} catch (SQLException e) {
		   //��DAO�㷢�����쳣 ����  ���ݿ�  ȫ����װ��һ���쳣   ��Ϊ��Щ�쳣�û��޷����� 
		    //�����û�����֪��.
		   throw new DAOException(e.getMessage());
		}finally{
			try {
				DBUtils.close(conn, pstmt, rs);
			} catch (SQLException e) {
				 throw new DAOException(e.getMessage());
			}
		}
		return null;
		}
	/**
	 * ����foreid��ѯ����Ԥѡ��Ʒ
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 **/
	public Foreshow queryByForeid(int foreid) throws DAOException {
		//1.����DBUtils���߰� �������� Ȼ���ȡ����
				String sql ="SELECT f.foreid,f.forepic,b.bid,"
						+ "b.bname,b.blogo,b.B_isVal,b.bpwd,"
						+ "b.bintroduction,b.bpic,b.bmpic,"
						+ "b.col_val,cou.countryid,cou.country,"
						+ "cou.cpic"+
						" FROM FORESHOW f,BUSER b,COUNTRY cou "+
						" WHERE f.foreid = b.bid and b.countryid = cou.countryid"+
						" and f.foreid=?";
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				try {
					conn = DBUtils.getConnection();
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, foreid);
					rs = pstmt.executeQuery();
					if(rs.next()){
						//int foreid = rs.getInt("foreid");
						String forepic = rs.getString("forepic");
						int bid = rs.getInt("bid");
						String bname = rs.getString("bname");
						String blogo = rs.getString("blogo");
						int B_isVal = rs.getInt("B_isVal");
						String bpwd = rs.getString("bpwd");
						String bintroduction = rs.getString("bintroduction");
						String bpic = rs.getString("bpic");
						String bmpic = rs.getString("bmpic");
						int col_val = rs.getInt("col_val");
						int countryid = rs.getInt("countryid");
						String country = rs.getString("country");
						String cpic = rs.getString("cpic");
						Country cou = new Country(countryid, country, cpic);
						Buser buser = new Buser(bid, bname, blogo, B_isVal, bpwd, bintroduction, bpic, bmpic, col_val, cou);
						Foreshow foreshow = new Foreshow(foreid, forepic, buser);
						return foreshow;
					}
				} catch (SQLException e) {
				   //��DAO�㷢�����쳣 ����  ���ݿ�  ȫ����װ��һ���쳣   ��Ϊ��Щ�쳣�û��޷����� 
				    //�����û�����֪��.
				   throw new DAOException(e.getMessage());
				}finally{
					try {
						DBUtils.close(conn, pstmt, rs);
					} catch (SQLException e) {
						 throw new DAOException(e.getMessage());
					}
				}
				return null;
				}
	/**
	 * ����forepic��ѯ����Ԥѡ��Ʒ
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 **/
	public Foreshow queryByForepic(String forepic) throws DAOException {
		//1.����DBUtils���߰� �������� Ȼ���ȡ����
		String sql ="SELECT f.foreid,f.forepic,b.bid,"
				+ "b.bname,b.blogo,b.B_isVal,b.bpwd,"
				+ "b.bintroduction,b.bpic,b.bmpic,"
				+ "b.col_val,cou.countryid,cou.country,"
				+ "cou.cpic"+
				" FROM FORESHOW f,BUSER b,COUNTRY cou "+
				" WHERE f.foreid = b.bid and b.countryid = cou.countryid"+
				" and f.forepic=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, forepic);
			rs = pstmt.executeQuery();
			if(rs.next()){
				int foreid = rs.getInt("foreid");
				int bid = rs.getInt("bid");
				String bname = rs.getString("bname");
				String blogo = rs.getString("blogo");
				int B_isVal = rs.getInt("B_isVal");
				String bpwd = rs.getString("bpwd");
				String bintroduction = rs.getString("bintroduction");
				String bpic = rs.getString("bpic");
				String bmpic = rs.getString("bmpic");
				int col_val = rs.getInt("col_val");
				int countryid = rs.getInt("countryid");
				String country = rs.getString("country");
				String cpic = rs.getString("cpic");
				Country cou = new Country(countryid, country, cpic);
				Buser buser = new Buser(bid, bname, blogo, B_isVal, bpwd, bintroduction, bpic, bmpic, col_val, cou);
				Foreshow foreshow = new Foreshow(foreid, forepic, buser);
				return foreshow;
			}
		} catch (SQLException e) {
		   //��DAO�㷢�����쳣 ����  ���ݿ�  ȫ����װ��һ���쳣   ��Ϊ��Щ�쳣�û��޷����� 
		    //�����û�����֪��.
		   throw new DAOException(e.getMessage());
		}finally{
			try {
				DBUtils.close(conn, pstmt, rs);
			} catch (SQLException e) {
				 throw new DAOException(e.getMessage());
			}
		}
		return null;
		}

	/**
	 * ��������Ԥѡ��Ʒ
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 **/
	public void inserForeShow(Foreshow foreShow) throws DAOException {
		//1.����DBUtils���߰� �������� Ȼ���ȡ����
				String sql ="INSERT INTO FORESHOW f(f.foreid,f.forepic,f.bid)"
						+ "VALUES (fore_seq.NEXTVAL,?,?)";
					
				Connection conn = null;
				PreparedStatement pstmt = null;
				try {
					conn = DBUtils.getConnection();
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, foreShow.getForepic());
					pstmt.setInt(2, foreShow.getBuser().getBid());
					pstmt.executeUpdate();
				} catch (SQLException e) {
				   //��DAO�㷢�����쳣 ����  ���ݿ�  ȫ����װ��һ���쳣   ��Ϊ��Щ�쳣�û��޷����� 
				    //�����û�����֪��.
				   //throw new DAOException(e.getMessage());
					e.printStackTrace();
				}finally{
					try {
						DBUtils.close(conn, pstmt);
					} catch (SQLException e) {
						 throw new DAOException(e.getMessage());
					}
				}
				}
	/**
	 * ����foreid��������Ԥѡ��Ʒ
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 **/
	public void updateForeShow(Foreshow foreShow) throws DAOException {
		//1.����DBUtils���߰� �������� Ȼ���ȡ����
		String sql = "UPDATE foreshow SET forepic=?,bid=?"
				+" WHERE foreid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,foreShow.getForepic());
			pstmt.setInt(2,foreShow.getBuser().getBid());
			pstmt.setInt(3,foreShow.getForeid());
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
	 * ����foreidɾ������Ԥѡ��Ʒ
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 **/
	public void delete(int foreid) throws DAOException {
		//1.����DBUtils���߰� �������� Ȼ���ȡ����
		String sql = "delete from foreshow where foreid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,foreid);
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
public static void main(String[] args) {
		
		
		ForeshowDAOImpl a=new ForeshowDAOImpl();
		Buser b = new Buser();
		Foreshow act = new Foreshow(1000005,"���ӾͲ�����",b);
		try {
			 //a.delete(10000006);
			 a.inserForeShow(act);
			 a.updateForeShow(act);
			// System.out.println(a.queryByForeid(10000002));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			//System.out.println("few");
			
			e.printStackTrace();
		}
		//a.delete(10000001);
		//System.out.println(a.queryByAcid(1));
		//System.out.println(a.inserActivity(););
		//System.out.println(a.queryByAcpic("zj.jpg"));
	}
}
