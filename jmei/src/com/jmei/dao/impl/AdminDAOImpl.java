package com.jmei.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jmei.bean.Admin;
import com.jmei.dao.AdminDAO;
import com.jmei.exception.DAOException;
import com.jmei.utils.DBUtils;
/**
 * ��Ʒ��ProductDAO��ʵ����
 * @since 2016-4-24
 * @author ����
 * **/
public class AdminDAOImpl implements AdminDAO {

	//���ӹ���Ա
	public void insertAdmin(Admin admin) throws DAOException {
		//����DButils���߰���������������ȡ����
		String sql = "insert into admin(adminid,adminpwd)"+
		"values(admin_seq.nextVal,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, admin.getAdminpwd());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}finally{
			try {
				DBUtils.close(conn, pstmt);
			} catch (SQLException e) {
				throw new DAOException(e.getMessage());
			}
		}
	}

	//ɾ������Ա
	public void deleteAdmin(int adminid) throws DAOException {
		//����DBUtils���߰�,������������ȡ����
		String sql = "delete from admin "+
		"where adminid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,adminid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}finally{
			try {
				DBUtils.close(conn, pstmt);
			} catch (SQLException e) {
				throw new DAOException(e.getMessage());
			}
		}
	}

	//���Ĺ���Ա��Ϣ
	public void updateAdmin(Admin admin) throws DAOException {
		//����DBUtils���߰�,������������ȡ����
		String sql = "update admin set adminpwd=?"+
		" where adminid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,admin.getAdminpwd());
			pstmt.setInt(2,admin.getAdminid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		} finally {
			try {
				DBUtils.close(conn, pstmt);
			} catch (SQLException e) {
				throw new DAOException(e.getMessage());
			}
		}
	}

	//��ѯ���й���Ա
	public List<Admin> queryAllAdmin() throws DAOException {
		//����DBUtils���߰���������������ȡ����
		String sql = "select adminid,adminpwd from admin";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<Admin> admins = new ArrayList<Admin>();
			while(rs.next()) {
				int adminid = rs.getInt("adminid");
				String adminpwd = rs.getString("adminpwd");
				Admin a = new Admin(adminid,adminpwd);
				admins.add(a);
			}
			return admins;
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		} finally {
			try {
				DBUtils.close(conn, pstmt);
			} catch (SQLException e) {
				throw new DAOException(e.getMessage());
			}
		}
	}

	//ͨ��Id��ѯ����Ա
	public Admin queryAdminById(int adminid) throws DAOException {
		//����DBUtils���߰���������������ȡ����
		String sql = "select adminid,adminpwd from admin"+
		" where adminid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,adminid);
			rs = pstmt.executeQuery();
			if(rs.next()){
				String adminpwd = rs.getString("adminpwd");
				Admin a = new Admin(adminid,adminpwd);
				return a;
			}
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
		return null;
	}


}
