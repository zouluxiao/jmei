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
 * 商品表ProductDAO的实现类
 * @since 2016-4-24
 * @author 阳桂东
 * **/
public class AdminDAOImpl implements AdminDAO {

	//增加管理员
	public void insertAdmin(Admin admin) throws DAOException {
		//调用DButils工具包，加载驱动，获取连接
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

	//删除管理员
	public void deleteAdmin(int adminid) throws DAOException {
		//调用DBUtils工具包,加载驱动，获取连接
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

	//更改管理员信息
	public void updateAdmin(Admin admin) throws DAOException {
		//调用DBUtils工具包,加载驱动，获取连接
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

	//查询所有管理员
	public List<Admin> queryAllAdmin() throws DAOException {
		//调用DBUtils工具包，加载驱动，获取连接
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

	//通过Id查询管理员
	public Admin queryAdminById(int adminid) throws DAOException {
		//调用DBUtils工具包，加载驱动，获取连接
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
