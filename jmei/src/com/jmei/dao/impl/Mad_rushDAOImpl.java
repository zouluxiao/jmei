package com.jmei.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jmei.bean.Buser;
import com.jmei.bean.Country;
import com.jmei.bean.Gtype;
import com.jmei.bean.Mad_rush;
import com.jmei.dao.Mad_rushDAO;
import com.jmei.exception.DAOException;
import com.jmei.utils.DBUtils;
/**
 * 业务描述：Mad_rushDAO的实现类
 * @author 钟进
 * @date 2016-04-23
 **/
public class Mad_rushDAOImpl implements Mad_rushDAO {
	/**
	 * 查询所有的商品
	 * @return List< Mad_rush>  返回类型对象的集合 
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 **/
	public List<Mad_rush> queryByAll() throws DAOException {
		//1.调用DBUtils工具包 加载驱动 然后获取连接
				String sql ="SELECT m.madid,m.madpic,b.bid,"
						+ "b.bname,b.blogo,b.B_isVal,b.bpwd,"
						+ "b.bintroduction,b.bpic,b.bmpic,"
						+ "b.col_val,cou.countryid,cou.country,"
						+ "cou.cpic"+
						" FROM MAD_rush m,BUSER b,COUNTRY cou "+
						" WHERE m.bid = b.bid and b.countryid = cou.countryid";
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				try {
					conn = DBUtils.getConnection();
					pstmt = conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
					List<Mad_rush> mad_rushs = new ArrayList<Mad_rush>();
					if(rs.next()){
						int madid = rs.getInt("madid");
						String madpic = rs.getString("madpic");
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
						Mad_rush mad_rush = new Mad_rush(madid, madpic, buser);
						mad_rushs.add(mad_rush);
						return mad_rushs;
					}
				} catch (SQLException e) {
				   //把DAO层发生的异常 网络  数据库  全部封装成一个异常   因为这些异常用户无法处理。 
				    //但是用户必须知晓.
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
	 * 根据madid查询疯狂商品
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 **/@Override
	public Mad_rush queryByMadid(int madid) throws DAOException {
		//1.调用DBUtils工具包 加载驱动 然后获取连接
		String sql ="SELECT m.madid,m.madpic,b.bid,"
				+ "b.bname,b.blogo,b.B_isVal,b.bpwd,"
				+ "b.bintroduction,b.bpic,b.bmpic,"
				+ "b.col_val,cou.countryid,cou.country,"
				+ "cou.cpic"+
				" FROM MAD_rush m,BUSER b,COUNTRY cou "+
				" WHERE m.bid = b.bid and b.countryid = cou.countryid"+
				" and m.madid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, madid);
			rs = pstmt.executeQuery();
			if(rs.next()){
				//int madid = rs.getInt("madid");
				String madpic = rs.getString("madpic");
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
				Mad_rush mad_rush = new Mad_rush(madid, madpic, buser);
				return mad_rush;
			}
		} catch (SQLException e) {
		   //把DAO层发生的异常 网络  数据库  全部封装成一个异常   因为这些异常用户无法处理。 
		    //但是用户必须知晓.
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
		 * 根据madpic查询疯狂商品
		 * @exception DAOException DAO层获取数据过程发生的异常。
		 **/
	public Mad_rush queryByMadpic(String madpic) throws DAOException {
		//1.调用DBUtils工具包 加载驱动 然后获取连接
				String sql ="SELECT m.madid,m.madpic,b.bid,"
						+ "b.bname,b.blogo,b.B_isVal,b.bpwd,"
						+ "b.bintroduction,b.bpic,b.bmpic,"
						+ "b.col_val,cou.countryid,cou.country,"
						+ "cou.cpic"+
						" FROM MAD_rush m,BUSER b,COUNTRY cou "+
						" WHERE m.bid = b.bid and b.countryid = cou.countryid"+
						" and m.madpic=?";
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				try {
					conn = DBUtils.getConnection();
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, madpic);
					rs = pstmt.executeQuery();
					if(rs.next()){
						int madid = rs.getInt("madid");
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
						Mad_rush mad_rush = new Mad_rush(madid, madpic, buser);
						return mad_rush;
					}
				} catch (SQLException e) {
				   //把DAO层发生的异常 网络  数据库  全部封装成一个异常   因为这些异常用户无法处理。 
				    //但是用户必须知晓.
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
	 * 插入疯狂商品
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 **/
	public void inserMad_rush(Mad_rush mad_rush) throws DAOException {
		//1.调用DBUtils工具包 加载驱动 然后获取连接
				String sql ="INSERT INTO mad_rush (madid,madpic,bid)"
						+ "VALUES (mad_seq.NEXTVAL,?,?)";
					
				Connection conn = null;
				PreparedStatement pstmt = null;
				try {
					conn = DBUtils.getConnection();
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, mad_rush.getMadpic());
					pstmt.setInt(2, mad_rush.getBuser().getBid());
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
	 * 根据madid更改疯狂商品
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 **/
	public void updateMad_rush(Mad_rush mad_rush) throws DAOException {
		//1.调用DBUtils工具包 加载驱动 然后获取连接
				String sql = "UPDATE mad_rush SET madpic=?,bid=?"
						+" WHERE madid=?";
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				try {
					conn = DBUtils.getConnection();
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1,mad_rush.getMadpic());
					pstmt.setInt(2,mad_rush.getBuser().getBid());
					pstmt.setInt(3,mad_rush.getMadid());
					pstmt.executeUpdate();
				} catch (SQLException e) {
				   //把DAO层发生的异常 网络  数据库  全部封装成一个异常   因为这些异常用户无法处理。 
				    //但是用户必须知晓.
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
	 * 根据madid删除精选商品
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 **/
	public void delete(int madid) throws DAOException {
		//1.调用DBUtils工具包 加载驱动 然后获取连接
		String sql = "delete from mad_rush where madid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,madid);
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
public static void main(String[] args) {
		
		
		Mad_rushDAOImpl a=new Mad_rushDAOImpl();
		//Country c = new Country ();
		Buser b = new Buser();
		//Mad_rush act = new Mad_rush(123,"shjkk",b);
		Mad_rush mad = new Mad_rush(10000004,"你是一个sb",b);
		try {
			 //a.delete(10000003);
			 //a.inserMad_rush(act);
			 a.updateMad_rush(mad);
			 //System.out.println(a.queryByMadid(10000002));
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