package com.jmei.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jmei.bean.Foreshow;
import com.jmei.bean.Gtype;
import com.jmei.dao.GtypeDAO;
import com.jmei.exception.DAOException;
import com.jmei.utils.DBUtils;
/**
 * ҵ��������GtypeDAO��ʵ����
 * @author �ӽ�
 * @date 2016-04-23
 **/
public class GtypeDAOImpl implements GtypeDAO {
	/**
	 * ��ѯ���е�����
	 * @return List< Gtype>  �������Ͷ���ļ��� 
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 **/
	public List<Gtype> queryByAll() throws DAOException {
		//1.����DBUtils���߰� �������� Ȼ���ȡ����
				String sql ="SELECT TID,TNAME" +
						" FROM GTYPE";
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				try {
					conn = DBUtils.getConnection();
					pstmt = conn.prepareStatement(sql);
					rs  = pstmt.executeQuery();
					List<Gtype> gtypes = new ArrayList<Gtype>();
					while(rs.next()){
					   int tid = rs.getInt("tid");
					   String tname = rs.getString("tname");
					   Gtype gtype = new Gtype(tid,tname);
					   gtypes.add(gtype);
					}
					return gtypes;

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

	
	public Gtype queryByTid(int tid) throws DAOException {
		//1.����DBUtils���߰� �������� Ȼ���ȡ����
		String sql ="SELECT TID,TNAME" +
				" FROM GTYPE WHERE TID=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, tid);
			rs  = pstmt.executeQuery();
			if(rs.next()){
			
			   String tname = rs.getString("tname");
			   Gtype gtype = new Gtype(tid,tname);
			   return gtype;
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


	@Override
	public Gtype queryByTname(String tname) throws DAOException {
		//1.����DBUtils���߰� �������� Ȼ���ȡ����
				String sql ="SELECT TID,TNAME" +
						" FROM GTYPE WHERE TNAME=?";
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				try {
					conn = DBUtils.getConnection();
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, tname);
					rs  = pstmt.executeQuery();
					if(rs.next()){
					
					   int tid = rs.getInt("tid");
					   Gtype gtype = new Gtype(tid,tname);
					   return gtype;
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

	@Override
	public void inserGtype(Gtype gtype) throws DAOException {
		//1.����DBUtils���߰� �������� Ȼ���ȡ����
				String sql ="INSERT INTO GTYPE (TID,TNAME)" +
						"VALUES(TYPE_SEQ.NEXTVAL,?)";
				Connection conn = null;
				PreparedStatement pstmt = null;
				try {
					conn = com.jmei.utils.DBUtils.getConnection();
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, gtype.getTname());
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

	@Override
	public void updateGtype(Gtype gtype) throws DAOException {
		//1.����DBUtils���߰� �������� Ȼ���ȡ����
				String sql ="UPDATE gtype SET tname=?"
						+" WHERE tid=?";
				Connection conn = null;
				PreparedStatement pstmt = null;
				try {
					conn = DBUtils.getConnection();
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, gtype.getTname());
					pstmt.setInt(2, gtype.getTid());
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


	@Override
	public void delete(int tid) throws DAOException {
		//1.����DBUtils���߰� �������� Ȼ���ȡ����
		String sql = "delete from gtype where tid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,tid);
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
		
		
		GtypeDAOImpl a=new GtypeDAOImpl();
		//Buser b = new Buser();
		Gtype act = new Gtype(123,"shjkk");
		Gtype g = new Gtype(10000014,"���Ӳ�����");
		try {
			 //a.delete(10000015);
			 a.inserGtype(act);
			 a.updateGtype(g);
			 //System.out.println(a.queryByTname("�4"));
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



