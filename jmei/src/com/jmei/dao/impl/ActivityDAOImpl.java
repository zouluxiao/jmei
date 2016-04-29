package com.jmei.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.jmei.utils.DBUtils;
import com.jmei.bean.Activity;
import com.jmei.bean.Buser;
import com.jmei.bean.Country;
import com.jmei.dao.ActivityDAO;
import com.jmei.exception.DAOException;
/**
 * ҵ��������ActivityDAO��ʵ����
 * @author �ӽ�
 * @date 2016-04-23
 **/
public class ActivityDAOImpl implements ActivityDAO {
	/**
	 * ��ѯ���е���Ʒ
	 * @return List<Activity>  ������Ʒ����ļ��� 
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 **/
	public List<Activity> queryByAll()throws DAOException {
		//1.����DBUtils���߰� �������� Ȼ���ȡ����
				String sql ="SELECT a.acid,a.acpic,b.bid,"
						+ "b.bname,b.blogo,b.B_isVal,b.bpwd,"
						+ "b.bintroduction,b.bpic,b.bmpic,"
						+ "b.col_val,cou.countryid,cou.country,"
						+ "cou.cpic"+
						" FROM ACTIVITY a,BUSER b,COUNTRY cou "+
						" WHERE a.bid = b.bid and b.countryid = cou.countryid";
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				try {
					conn = DBUtils.getConnection();
					pstmt = conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
					List<Activity> activitys = new ArrayList<Activity>();
					if(rs.next()){
						//int acid = rs.getInt("acid");
						int acid = rs.getInt("acid");
						String acpic = rs.getString("acpic");
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
						Activity activity = new Activity(acid, acpic, buser);
	                    activitys.add(activity);
						return activitys;
					}
				} catch (SQLException e) {
				   //��DAO�㷢�����쳣 ����  ���ݿ�  ȫ����װ��һ���쳣   ��Ϊ��Щ�쳣�û��޷����� 
				    //�����û�����֪��.
				   throw new DAOException(e.getMessage());
					//e.printStackTrace();
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
	 * ����acid��ѯ��ѡ��Ʒ
	 * @param acid ͼƬ�ı��
	 * @return ����Activity����
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 **/
	public Activity queryByAcid(int acid) throws DAOException {
		//1.����DBUtils���߰� �������� Ȼ���ȡ����
		String sql ="SELECT a.acid,a.acpic,b.bid,"
				+ "b.bname,b.blogo,b.B_isVal,b.bpwd,"
				+ "b.bintroduction,b.bpic,b.bmpic,"
				+ "b.col_val,cou.countryid,cou.country,"
				+ "cou.cpic"+
				" FROM ACTIVITY a,BUSER b,COUNTRY cou "+
				" WHERE a.bid = b.bid and b.countryid = cou.countryid"+
				" and a.acid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, acid);
			rs = pstmt.executeQuery();
			if(rs.next()){
				//int acid = rs.getInt("acid");
				String acpic = rs.getString("acpic");
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
				Activity activity = new Activity(acid, acpic, buser);
				return activity;
			}
		} catch (SQLException e) {
		   //��DAO�㷢�����쳣 ����  ���ݿ�  ȫ����װ��һ���쳣   ��Ϊ��Щ�쳣�û��޷����� 
		    //�����û�����֪��.
		   throw new DAOException(e.getMessage());
			//e.printStackTrace();
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
	 * ����acpic��ѯ��ѡ��Ʒ
	 * @param acpic ��ƷͼƬ
	 * @return ����Activity����
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 **/
	public Activity queryByAcpic(String acpic) throws DAOException {
		//1.����DBUtils���߰� �������� Ȼ���ȡ����
				String sql ="SELECT a.acid,a.acpic,b.bid,"
						+ "b.bname,b.blogo,b.B_isVal,b.bpwd,"
						+ "b.bintroduction,b.bpic,b.bmpic,"
						+ "b.col_val,cou.countryid,cou.country,"
						+ "cou.cpic "+
						" FROM ACTIVITY a,BUSER b,COUNTRY cou "+
						" WHERE a.bid = b.bid and b.countryid = cou.countryid "+
						" and a.acpic=?";
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				try {
					conn = DBUtils.getConnection();
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, acpic);
					rs = pstmt.executeQuery();
					if(rs.next()){
						int acid = rs.getInt("acid");
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
						Activity activity = new Activity(acid, acpic, buser);
						return activity;
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
	 * ���뾫ѡ��Ʒ
	 * @param Activity ��Ʒ����
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 **/
	public void inserActivity(Activity activity) throws DAOException {
		//1.����DBUtils���߰� �������� Ȼ���ȡ����
		String sql ="INSERT INTO ACTIVITY a(a.acid,a.acpic,a.bid)"
				+ "VALUES (activity_seq.NEXTVAL,?,?)";
			
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, activity.getAcpic());
			pstmt.setInt(2, activity.getBuser().getBid());
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
	 * ����acpic���ľ�ѡ��Ʒ
	 * @param acppic ��Ʒ���
	 * @param activity ��Ʒ����
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 **/
	public void updateActivity(Activity activity) throws DAOException {
		//1.����DBUtils���߰� �������� Ȼ���ȡ����
		String sql = "UPDATE ACTIVITY SET acpic=?,bid=?"
				+" WHERE acid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, activity.getAcpic());
			pstmt.setInt(2, activity.getBuser().getBid());
			pstmt.setInt(3, activity.getAcid());
			pstmt.executeUpdate();
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
		}


	/**
	 * ����acidɾ����ѡ��Ʒ
	 * @param acid ͼƬ�ı��
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 **/
	public void delete(int acid) throws DAOException {
		//1.����DBUtils���߰� �������� Ȼ���ȡ����
				String sql = "delete from activity where acid=?";
				Connection conn = null;
				PreparedStatement pstmt = null;
				try {
					conn = DBUtils.getConnection();
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1,acid);
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
		
		
		ActivityDAOImpl a=new ActivityDAOImpl();
		Buser b = new Buser();
		Activity act = new Activity(123,"������",b);
		Activity aaa = new Activity(10000004,"�ɹ�",b);
		try {
			// a.delete(10000003);
			 a.inserActivity(act);
			 //a.updateActivity(aaa);
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
