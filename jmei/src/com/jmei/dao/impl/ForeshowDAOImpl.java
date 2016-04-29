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
 * 业务描述：ForeshowDAO的实现类
 * @author 钟进
 * @date 2016-04-23
 **/
public class ForeshowDAOImpl implements ForeshowDAO {
	/**
	 * 查询所有的商品
	 * @return List<Foreshow>  返回商品对象的集合 
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 **/
	public List<Foreshow> queryByAll()throws DAOException {
		//1.调用DBUtils工具包 加载驱动 然后获取连接
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
	 * 根据foreid查询明日预选商品
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 **/
	public Foreshow queryByForeid(int foreid) throws DAOException {
		//1.调用DBUtils工具包 加载驱动 然后获取连接
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
	 * 根据forepic查询明日预选商品
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 **/
	public Foreshow queryByForepic(String forepic) throws DAOException {
		//1.调用DBUtils工具包 加载驱动 然后获取连接
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
	 * 插入明日预选商品
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 **/
	public void inserForeShow(Foreshow foreShow) throws DAOException {
		//1.调用DBUtils工具包 加载驱动 然后获取连接
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
				   //把DAO层发生的异常 网络  数据库  全部封装成一个异常   因为这些异常用户无法处理。 
				    //但是用户必须知晓.
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
	 * 根据foreid更改明日预选商品
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 **/
	public void updateForeShow(Foreshow foreShow) throws DAOException {
		//1.调用DBUtils工具包 加载驱动 然后获取连接
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
	 * 根据foreid删除明日预选商品
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 **/
	public void delete(int foreid) throws DAOException {
		//1.调用DBUtils工具包 加载驱动 然后获取连接
		String sql = "delete from foreshow where foreid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,foreid);
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
		
		
		ForeshowDAOImpl a=new ForeshowDAOImpl();
		Buser b = new Buser();
		Foreshow act = new Foreshow(1000005,"老子就不信了",b);
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
