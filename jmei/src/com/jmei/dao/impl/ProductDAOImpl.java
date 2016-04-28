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
 * 商品表ProductDAO的实现类
 * @since 2016-4-24
 * @author 阳桂东
 * **/
public class ProductDAOImpl implements ProductDAO {

	//增加商品
	public void insertProduct(Product product) throws DAOException {
		//调用DButils工具包，加载驱动，获取连接
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

	//删除商品
	public void deleteProduct(int pid) throws DAOException {
		//调用DBUtils工具包,加载驱动，获取连接
		String sql = "update product set p_isVal=?"+
		" where pid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,1);	//设置1为商品失效
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

	//更新商品
	public void updateProduct(Product product) throws DAOException {
		//调用DBUtils工具包,加载驱动，获取连接
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

	//查询所有商品信息
	public List<Product> queryAllProduct() throws DAOException {
		//调用DBUtils工具包，加载驱动，获取连接
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

	//通过商品id查询商品信息
	public Product queryById(int pid) throws DAOException {
		//调用DBUtils工具包，加载驱动，获取连接
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

	//通过商品名查询商品信息
	public Product queryByPname(String pname) throws DAOException {
		//调用DBUtils工具包，加载驱动，获取连接
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
