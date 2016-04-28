package com.jmei.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jmei.bean.Product;
import com.jmei.dao.ProductDAO;
import com.jmei.exception.DAOException;
import com.jmei.utils.DBUtils;
/**
 * ��Ʒ��ProductDAO��ʵ����
 * @since 2016-4-24
 * @author ����
 * **/
public class ProductDAOImpl implements ProductDAO {

	//������Ʒ
	public void insertProduct(Product product) throws DAOException {
		//����DButils���߰���������������ȡ����
		String sql = "insert into product(pid,pname,p_isVal)"+
		"values(pro_seq.nextVal,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getPname());
			pstmt.setInt(2, product.getIsval());
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

	//ɾ����Ʒ
	public void deleteProduct(int pid) throws DAOException {
		//����DBUtils���߰�,������������ȡ����
		String sql = "update product set p_isVal=?"+
		" where pid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,1);	//����1Ϊ��ƷʧЧ
			pstmt.setInt(2,pid);
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

	//������Ʒ
	public void updateProduct(Product product) throws DAOException {
		//����DBUtils���߰�,������������ȡ����
		String sql = "update product set pname=?"+
		" where pid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,product.getPname());
			pstmt.setInt(2,product.getPid());
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

	//��ѯ������Ʒ��Ϣ
	public List<Product> queryAllProduct() throws DAOException {
		//����DBUtils���߰���������������ȡ����
		String sql = "select pid,pname,p_isVal from product"+
		" where p_isVal=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,0);
			rs = pstmt.executeQuery();
			List<Product> products = new ArrayList<Product>();
			while(rs.next()) {
				int pid = rs.getInt("pid");
				String pname = rs.getString("pname");
				int val = rs.getInt("p_isVal");
				Product p = new Product(pid,pname,val);
				products.add(p);
			}
			return products;
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

	//ͨ����Ʒid��ѯ��Ʒ��Ϣ
	public Product queryById(int pid) throws DAOException {
		//����DBUtils���߰���������������ȡ����
		String sql = "select pid,pname,p_isVal from product "+
		"where pid=? and p_isVal=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,pid);
			pstmt.setInt(2,0);
			rs = pstmt.executeQuery();
			if(rs.next()){
				String pname = rs.getString("pname");
				int val = rs.getInt("p_isVal");
				Product p = new Product(pid,pname,val);
				return p;
			}
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
		return null;
	}

	//ͨ����Ʒ����ѯ��Ʒ��Ϣ
	public Product queryByPname(String pname) throws DAOException {
		//����DBUtils���߰���������������ȡ����
		String sql = "select pid,p_isVal from product"+
		" where pname=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,pname);
			rs = pstmt.executeQuery();
			if(rs.next()){
				int pid = rs.getInt("pid");
				int val = rs.getInt("p_isVal");
				Product p = new Product(pid,pname,val);
				return p;
			}
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		} finally {
			try {
				DBUtils.close(conn, pstmt);
			} catch (SQLException e) {
				throw new DAOException(e.getMessage());
			}
		}
		return null;
	}

}
