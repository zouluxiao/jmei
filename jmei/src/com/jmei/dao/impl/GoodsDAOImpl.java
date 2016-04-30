package com.jmei.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jmei.bean.Buser;
import com.jmei.bean.Country;
import com.jmei.bean.Goods;
import com.jmei.bean.Product;
import com.jmei.dao.GoodsDAO;
import com.jmei.exception.DAOException;
import com.jmei.utils.DBUtils;

/**
 * 这个类实现接口GoodsDAO
 * @author 汤亮
 * @since 2016-04-24
 *
 */
public class GoodsDAOImpl implements GoodsDAO {

	/**
	 * 通过商品的编号查询商品
	 * @param pid 商品的编号
	 * @return Goods 返回商品的对象
	 * @throws DAOException DAO层获取数据发现异常
	 */
	public List<Goods> queryGoodsByPid(int pid) throws DAOException {
		String sql = "SELECT g.GID,g.BNUMBER,g.PRI,g.SALE_VAL,"
				+ "g.COL_VAL,g.UPTIME,g.INTRODUCTION,"
				+ "g.DETAILNAME,b.bid, b.bname, b.blogo,"
				+ " b.b_isval, b.bpwd, b.bintroduction, "
				+ "b.bpic, b.bmpic, b.col_val,p.pid, p.pname,"
				+ " p.p_isval,c.countryid, c.country, c.cpic"
				+ " FROM GOODS g,BUSER b,PRODUCT p, country c"
				+ " WHERE g.bid = b.bid and p.pid = g.pid and c.countryid = b.countryid and g.pid = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try{
			conn = DBUtils.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, pid);
			rs = pstm.executeQuery();
			ArrayList<Goods> list = new ArrayList<Goods>();
			while(rs.next()){
				int GID = rs.getInt("GID");
				int BNUMBER = rs.getInt("BNUMBER");
				double PRI = rs.getDouble("PRI");
				int SALE_VAL = rs.getInt("SALE_VAL");
				int COL_VAL = rs.getInt("COL_VAL");
				String UPTIME = rs.getString("UPTIME");
				String INTRODUCTION = rs.getString("INTRODUCTION");
				String DETAILNAME = rs.getString("DETAILNAME");
				int bid = rs.getInt("bid");
				String bname = rs.getString("bname");
				String blogo = rs.getString("blogo");
				int b_isval = rs.getInt("b_isval");
				String bpwd = rs.getString("bpwd");
				String bintroduction = rs.getString("bintroduction");
				String bpic = rs.getString("bpic");
				String bmpic = rs.getString("bmpic");
				int bcol_val = rs.getInt(17); 
				//int pid = rs.getInt("pid");
				String pname = rs.getString("pname");
				int p_isval = rs.getInt("p_isval");
				int countryid = rs.getInt("countryid");
				String country = rs.getString("country");
				String cpic = rs.getString("cpic");
				Country cou = new Country(countryid, country, cpic);
				Buser buser = new Buser(bid, bname, blogo, b_isval, bpwd, bintroduction, bpic, bmpic, COL_VAL, cou);
				Product product = new Product(pid, pname, p_isval);
				Goods goods = new Goods(GID, buser, product, BNUMBER, PRI, SALE_VAL, bcol_val, UPTIME, INTRODUCTION, DETAILNAME);
				list.add(goods);
			}
			return list;
		}catch(SQLException e){
			 //把DAO层发生的异常 网络  数据库  全部封装成一个异常   因为这些异常用户无法处理。 
		    //但是用户必须知晓.
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
	 * 通过商品的名称查询商品
	 * @param pname 商品的名称
	 * @return List<Goods> 返回商品的集合对象
	 * @throws DAOException DAO层获取数据发生异常
	 */
	public List<Goods> queryGoodsByPname(String pname) throws DAOException {
		String sql = "SELECT g.GID,g.BNUMBER,g.PRI,g.SALE_VAL,"
				+ "g.COL_VAL,g.UPTIME,g.INTRODUCTION,"
				+ "g.DETAILNAME,b.bid, b.bname, b.blogo,"
				+ " b.b_isval, b.bpwd, b.bintroduction, "
				+ "b.bpic, b.bmpic, b.col_val,p.pid, p.pname,"
				+ " p.p_isval,c.countryid, c.country, c.cpic"
				+ " FROM GOODS g,BUSER b,PRODUCT p, country c"
				+ " WHERE g.bid = b.bid and p.pid = g.pid and c.countryid = b.countryid and p.pname = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try{
			conn = DBUtils.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, pname);
			rs = pstm.executeQuery();
			ArrayList<Goods> list = new ArrayList<Goods>();
			while(rs.next()){
				int GID = rs.getInt("GID");
				int BNUMBER = rs.getInt("BNUMBER");
				double PRI = rs.getDouble("PRI");
				int SALE_VAL = rs.getInt("SALE_VAL");
				int COL_VAL = rs.getInt("COL_VAL");
				String UPTIME = rs.getString("UPTIME");
				String INTRODUCTION = rs.getString("INTRODUCTION");
				String DETAILNAME = rs.getString("DETAILNAME");
				int bid = rs.getInt("bid");
				String bname = rs.getString("bname");
				String blogo = rs.getString("blogo");
				int b_isval = rs.getInt("b_isval");
				String bpwd = rs.getString("bpwd");
				String bintroduction = rs.getString("bintroduction");
				String bpic = rs.getString("bpic");
				String bmpic = rs.getString("bmpic");
				int bcol_val = rs.getInt(17); 
				int pid = rs.getInt("pid");
				//String pname = rs.getString("pname");
				int p_isval = rs.getInt("p_isval");
				int countryid = rs.getInt("countryid");
				String country = rs.getString("country");
				String cpic = rs.getString("cpic");
				Country cou = new Country(countryid, country, cpic);
				Buser buser = new Buser(bid, bname, blogo, b_isval, bpwd, bintroduction, bpic, bmpic, COL_VAL, cou);
				Product product = new Product(pid, pname, p_isval);
				Goods goods = new Goods(GID, buser, product, BNUMBER, PRI, SALE_VAL, bcol_val, UPTIME, INTRODUCTION, DETAILNAME);
				list.add(goods);
			}
			return list;
		}catch(SQLException e){
			 //把DAO层发生的异常 网络  数据库  全部封装成一个异常   因为这些异常用户无法处理。 
		    //但是用户必须知晓.
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
	 * 通过企业编号查询该企业所经营的所有商品
	 * @param bid 企业编号
	 * @return List<Goods> 返回商品的集合对象
	 * @throws DAOException DAO层获取数据发生异常
	 */
	public List<Goods> queryGoodsByBid(int bid) throws DAOException {
		String sql = "SELECT g.GID,g.BNUMBER,g.PRI,g.SALE_VAL,"
				+ "g.COL_VAL,g.UPTIME,g.INTRODUCTION,"
				+ "g.DETAILNAME,b.bid, b.bname, b.blogo,"
				+ " b.b_isval, b.bpwd, b.bintroduction, "
				+ "b.bpic, b.bmpic, b.col_val,p.pid, p.pname,"
				+ " p.p_isval,c.countryid, c.country, c.cpic"
				+ " FROM GOODS g,BUSER b,PRODUCT p, country c"
				+ " WHERE g.bid = b.bid and p.pid = g.pid and c.countryid = b.countryid and g.bid = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try{
			conn = DBUtils.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, bid);
			rs = pstm.executeQuery();
			ArrayList<Goods> list = new ArrayList<Goods>();
			while(rs.next()){
				int GID = rs.getInt("GID");
				int BNUMBER = rs.getInt("BNUMBER");
				double PRI = rs.getDouble("PRI");
				int SALE_VAL = rs.getInt("SALE_VAL");
				int COL_VAL = rs.getInt("COL_VAL");
				String UPTIME = rs.getString("UPTIME");
				String INTRODUCTION = rs.getString("INTRODUCTION");
				String DETAILNAME = rs.getString("DETAILNAME");
				//int bid = rs.getInt("bid");
				String bname = rs.getString("bname");
				String blogo = rs.getString("blogo");
				int b_isval = rs.getInt("b_isval");
				String bpwd = rs.getString("bpwd");
				String bintroduction = rs.getString("bintroduction");
				String bpic = rs.getString("bpic");
				String bmpic = rs.getString("bmpic");
				int bcol_val = rs.getInt(17); 
				int pid = rs.getInt("pid");
				String pname = rs.getString("pname");
				int p_isval = rs.getInt("p_isval");
				int countryid = rs.getInt("countryid");
				String country = rs.getString("country");
				String cpic = rs.getString("cpic");
				Country cou = new Country(countryid, country, cpic);
				Buser buser = new Buser(bid, bname, blogo, b_isval, bpwd, bintroduction, bpic, bmpic, COL_VAL, cou);
				Product product = new Product(pid, pname, p_isval);
				Goods goods = new Goods(GID, buser, product, BNUMBER, PRI, SALE_VAL, bcol_val, UPTIME, INTRODUCTION, DETAILNAME);
				list.add(goods);
			}
			return list;
		}catch(SQLException e){
			 //把DAO层发生的异常 网络  数据库  全部封装成一个异常   因为这些异常用户无法处理。 
		    //但是用户必须知晓.
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
	 * 通过企业名称查询该企业所经营的所有商品
	 * @param bname 企业名称
	 * @return List<Goods> 返回商品的集合对象
	 * @throws DAOException DAO层获取数据发生异常
	 */
	public List<Goods> queryGoodsByBname(String bname) throws DAOException {
		String sql = "SELECT g.GID,g.BNUMBER,g.PRI,g.SALE_VAL,"
				+ "g.COL_VAL,g.UPTIME,g.INTRODUCTION,"
				+ "g.DETAILNAME,b.bid, b.bname, b.blogo,"
				+ " b.b_isval, b.bpwd, b.bintroduction, "
				+ "b.bpic, b.bmpic, b.col_val,p.pid, p.pname,"
				+ " p.p_isval,c.countryid, c.country, c.cpic"
				+ " FROM GOODS g,BUSER b,PRODUCT p, country c"
				+ " WHERE g.bid = b.bid and p.pid = g.pid and c.countryid = b.countryid and b.bname = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try{
			conn = DBUtils.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, bname);
			rs = pstm.executeQuery();
			ArrayList<Goods> list = new ArrayList<Goods>();
			while(rs.next()){
				int GID = rs.getInt("GID");
				int BNUMBER = rs.getInt("BNUMBER");
				double PRI = rs.getDouble("PRI");
				int SALE_VAL = rs.getInt("SALE_VAL");
				int COL_VAL = rs.getInt("COL_VAL");
				String UPTIME = rs.getString("UPTIME");
				String INTRODUCTION = rs.getString("INTRODUCTION");
				String DETAILNAME = rs.getString("DETAILNAME");
				int bid = rs.getInt("bid");
				//String bname = rs.getString("bname");
				String blogo = rs.getString("blogo");
				int b_isval = rs.getInt("b_isval");
				String bpwd = rs.getString("bpwd");
				String bintroduction = rs.getString("bintroduction");
				String bpic = rs.getString("bpic");
				String bmpic = rs.getString("bmpic");
				int bcol_val = rs.getInt(17); 
				int pid = rs.getInt("pid");
				String pname = rs.getString("pname");
				int p_isval = rs.getInt("p_isval");
				int countryid = rs.getInt("countryid");
				String country = rs.getString("country");
				String cpic = rs.getString("cpic");
				Country cou = new Country(countryid, country, cpic);
				Buser buser = new Buser(bid, bname, blogo, b_isval, bpwd, bintroduction, bpic, bmpic, COL_VAL, cou);
				Product product = new Product(pid, pname, p_isval);
				Goods goods = new Goods(GID, buser, product, BNUMBER, PRI, SALE_VAL, bcol_val, UPTIME, INTRODUCTION, DETAILNAME);
				list.add(goods);
			}
			return list;
		}catch(SQLException e){
			 //把DAO层发生的异常 网络  数据库  全部封装成一个异常   因为这些异常用户无法处理。 
		    //但是用户必须知晓.
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
	 * 通过商品的数量查询商品
	 * @param num 商品的数量
	 * @return List<Goods> 返回商品的集合对象
	 * @throws DAOException DAO层获取数据发生异常
	 */
	public List<Goods> queryGoodsByNumber(int num) throws DAOException {
		String sql = "SELECT g.GID,g.BNUMBER,g.PRI,g.SALE_VAL,"
				+ "g.COL_VAL,g.UPTIME,g.INTRODUCTION,"
				+ "g.DETAILNAME,b.bid, b.bname, b.blogo,"
				+ " b.b_isval, b.bpwd, b.bintroduction, "
				+ "b.bpic, b.bmpic, b.col_val,p.pid, p.pname,"
				+ " p.p_isval,c.countryid, c.country, c.cpic"
				+ " FROM GOODS g,BUSER b,PRODUCT p, country c"
				+ " WHERE g.bid = b.bid and p.pid = g.pid and c.countryid = b.countryid and g.number = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try{
			conn = DBUtils.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, num);
			rs = pstm.executeQuery();
			ArrayList<Goods> list = new ArrayList<Goods>();
			while(rs.next()){
				int GID = rs.getInt("GID");
				int BNUMBER = rs.getInt("BNUMBER");
				double PRI = rs.getDouble("PRI");
				int SALE_VAL = rs.getInt("SALE_VAL");
				int COL_VAL = rs.getInt("COL_VAL");
				String UPTIME = rs.getString("UPTIME");
				String INTRODUCTION = rs.getString("INTRODUCTION");
				String DETAILNAME = rs.getString("DETAILNAME");
				int bid = rs.getInt("bid");
				String bname = rs.getString("bname");
				String blogo = rs.getString("blogo");
				int b_isval = rs.getInt("b_isval");
				String bpwd = rs.getString("bpwd");
				String bintroduction = rs.getString("bintroduction");
				String bpic = rs.getString("bpic");
				String bmpic = rs.getString("bmpic");
				int bcol_val = rs.getInt(17); 
				int pid = rs.getInt("pid");
				String pname = rs.getString("pname");
				int p_isval = rs.getInt("p_isval");
				int countryid = rs.getInt("countryid");
				String country = rs.getString("country");
				String cpic = rs.getString("cpic");
				Country cou = new Country(countryid, country, cpic);
				Buser buser = new Buser(bid, bname, blogo, b_isval, bpwd, bintroduction, bpic, bmpic, COL_VAL, cou);
				Product product = new Product(pid, pname, p_isval);
				Goods goods = new Goods(GID, buser, product, BNUMBER, PRI, SALE_VAL, bcol_val, UPTIME, INTRODUCTION, DETAILNAME);
				list.add(goods);
			}
			return list;
		}catch(SQLException e){
			 //把DAO层发生的异常 网络  数据库  全部封装成一个异常   因为这些异常用户无法处理。 
		    //但是用户必须知晓.
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
	 * 通过商品的销量查询商品
	 * @param vol 商品的销量
	 * @return List<Goods> 返回商品的集合对象
	 * @throws DAOException DAO层获取数据发生异常
	 */
	public List<Goods> queryGoodsBySaleVol(int vol) throws DAOException {
		String sql = "SELECT g.GID,g.BNUMBER,g.PRI,g.SALE_VAL,"
				+ "g.COL_VAL,g.UPTIME,g.INTRODUCTION,"
				+ "g.DETAILNAME,b.bid, b.bname, b.blogo,"
				+ " b.b_isval, b.bpwd, b.bintroduction, "
				+ "b.bpic, b.bmpic, b.col_val,p.pid, p.pname,"
				+ " p.p_isval,c.countryid, c.country, c.cpic"
				+ " FROM GOODS g,BUSER b,PRODUCT p, country c"
				+ " WHERE g.bid = b.bid and p.pid = g.pid and c.countryid = b.countryid and g.sale_val = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try{
			conn = DBUtils.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, vol);
			rs = pstm.executeQuery();
			ArrayList<Goods> list = new ArrayList<Goods>();
			while(rs.next()){
				int GID = rs.getInt("GID");
				int BNUMBER = rs.getInt("BNUMBER");
				double PRI = rs.getDouble("PRI");
				int SALE_VAL = rs.getInt("SALE_VAL");
				int COL_VAL = rs.getInt("COL_VAL");
				String UPTIME = rs.getString("UPTIME");
				String INTRODUCTION = rs.getString("INTRODUCTION");
				String DETAILNAME = rs.getString("DETAILNAME");
				int bid = rs.getInt("bid");
				String bname = rs.getString("bname");
				String blogo = rs.getString("blogo");
				int b_isval = rs.getInt("b_isval");
				String bpwd = rs.getString("bpwd");
				String bintroduction = rs.getString("bintroduction");
				String bpic = rs.getString("bpic");
				String bmpic = rs.getString("bmpic");
				int bcol_val = rs.getInt(17); 
				int pid = rs.getInt("pid");
				String pname = rs.getString("pname");
				int p_isval = rs.getInt("p_isval");
				int countryid = rs.getInt("countryid");
				String country = rs.getString("country");
				String cpic = rs.getString("cpic");
				Country cou = new Country(countryid, country, cpic);
				Buser buser = new Buser(bid, bname, blogo, b_isval, bpwd, bintroduction, bpic, bmpic, COL_VAL, cou);
				Product product = new Product(pid, pname, p_isval);
				Goods goods = new Goods(GID, buser, product, BNUMBER, PRI, SALE_VAL, bcol_val, UPTIME, INTRODUCTION, DETAILNAME);
				list.add(goods);
			}
			return list;
		}catch(SQLException e){
			 //把DAO层发生的异常 网络  数据库  全部封装成一个异常   因为这些异常用户无法处理。 
		    //但是用户必须知晓.
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
	 * 通过上架时间查找商品
	 * @param t1  开始时间
	 * @param t2  结束时间
	 * @return List<Goods> 返回商品的集合对象
	 * @throws DAOException DAO层获取数据发生异常
	 */
	public List<Goods> queryGoodsByUpTime(String t1, String t2)
			throws DAOException {
		return null;
	}

	/**
	 * 查询所有商品
	 * @return List<Goods> 返回商品的集合对象
	 * @throws DAOException DAO层获取数据发生异常
	 */
	public List<Goods> queryAllGoods() throws DAOException {
		String sql = "SELECT g.GID,g.BNUMBER,g.PRI,g.SALE_VAL,"
				+ "g.COL_VAL,g.UPTIME,g.INTRODUCTION,"
				+ "g.DETAILNAME,b.bid, b.bname, b.blogo,"
				+ " b.b_isval, b.bpwd, b.bintroduction, "
				+ "b.bpic, b.bmpic, b.col_val,p.pid, p.pname,"
				+ " p.p_isval,c.countryid, c.country, c.cpic"
				+ " FROM GOODS g,BUSER b,PRODUCT p, country c"
				+ " WHERE g.bid = b.bid and p.pid = g.pid and c.countryid = b.countryid";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try{
			conn = DBUtils.getConnection();
			pstm = conn.prepareStatement(sql);
			//pstm.setInt(1, vol);
			rs = pstm.executeQuery();
			ArrayList<Goods> list = new ArrayList<Goods>();
			while(rs.next()){
				int GID = rs.getInt("GID");
				int BNUMBER = rs.getInt("BNUMBER");
				double PRI = rs.getDouble("PRI");
				int SALE_VAL = rs.getInt("SALE_VAL");
				int COL_VAL = rs.getInt("COL_VAL");
				String UPTIME = rs.getString("UPTIME");
				String INTRODUCTION = rs.getString("INTRODUCTION");
				String DETAILNAME = rs.getString("DETAILNAME");
				int bid = rs.getInt("bid");
				String bname = rs.getString("bname");
				String blogo = rs.getString("blogo");
				int b_isval = rs.getInt("b_isval");
				String bpwd = rs.getString("bpwd");
				String bintroduction = rs.getString("bintroduction");
				String bpic = rs.getString("bpic");
				String bmpic = rs.getString("bmpic");
				int bcol_val = rs.getInt(17); 
				int pid = rs.getInt("pid");
				String pname = rs.getString("pname");
				int p_isval = rs.getInt("p_isval");
				int countryid = rs.getInt("countryid");
				String country = rs.getString("country");
				String cpic = rs.getString("cpic");
				Country cou = new Country(countryid, country, cpic);
				Buser buser = new Buser(bid, bname, blogo, b_isval, bpwd, bintroduction, bpic, bmpic, COL_VAL, cou);
				Product product = new Product(pid, pname, p_isval);
				Goods goods = new Goods(GID, buser, product, BNUMBER, PRI, SALE_VAL, bcol_val, UPTIME, INTRODUCTION, DETAILNAME);
				list.add(goods);
			}
			return list;
		}catch(SQLException e){
			 //把DAO层发生的异常 网络  数据库  全部封装成一个异常   因为这些异常用户无法处理。 
		    //但是用户必须知晓.
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
	 * 通过gid找出商品，更新商品的详细名称
	 * @param gid 商品的编号
	 * @param Detail 更新后的商品的详细名称
	 * @throws DAOException DAO层获取数据发生异常
	 */
	public void updateGoodsDetail(int gid, String Detail) throws DAOException {
		String sql ="UPDATE Goods SET detailname=?"
				+ " where gid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,Detail);
			pstmt.setInt(2, gid);
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
	 * 通过商品编号删除商品
	 * @param gid 商品编号
	 * @throws DAOException DAO层获取数据发生异常
	 */
	public void deleteGoods(int gid) throws DAOException {
		String sql ="DELETE Goods "
				+ "WHERE GID = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, gid);
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
	 * 添加商品
	 * @param goods 添加的商品的对象
	 * @throws DAOException DAO层获取数据发生异常
	 */
	public void insertGoods(Goods goods) throws DAOException {
		String sql ="insert into Goods "
				+ "values(goods_seq.nextval,?,?,?,?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, goods.getBuser().getBid());
			pstmt.setInt(2, goods.getPro().getPid());
			pstmt.setInt(3, goods.getNumber());
			pstmt.setDouble(4, goods.getPrice());
			pstmt.setInt(5, goods.getSale_val());
			pstmt.setInt(6,goods.getCol_val());
			pstmt.setString(7,goods.getUptime());
			pstmt.setString(8,goods.getIntroduction());
			pstmt.setString(9,goods.getDetailname());
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
	 * 模糊查询商品的详细名称
	 * @param detail 商品的详细名称
	 * @return List<Goods> 返回商品对象的集合
	 * @throws DAOException DAO层获取数据发生异常
	 */
	public List<Goods> queryGoodsByDetail(String detail) throws DAOException {
		String sql = "SELECT g.GID,g.BNUMBER,g.PRI,g.SALE_VAL,"
				+ "g.COL_VAL,g.UPTIME,g.INTRODUCTION,"
				+ "g.DETAILNAME,b.bid, b.bname, b.blogo,"
				+ " b.b_isval, b.bpwd, b.bintroduction, "
				+ "b.bpic, b.bmpic, b.col_val,p.pid, p.pname,"
				+ " p.p_isval,c.countryid, c.country, c.cpic"
				+ " FROM GOODS g,BUSER b,PRODUCT p, country c"
				+ " WHERE g.bid = b.bid and p.pid = g.pid and c.countryid = b.countryid and"
				+ " GETHZPY.GETHZPYCAP(g.detailname) like ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try{
			conn = DBUtils.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, "%"+detail+"%");
			rs = pstm.executeQuery();
			ArrayList<Goods> list = new ArrayList<Goods>();
			while(rs.next()){
				int GID = rs.getInt("GID");
				int BNUMBER = rs.getInt("BNUMBER");
				double PRI = rs.getDouble("PRI");
				int SALE_VAL = rs.getInt("SALE_VAL");
				int COL_VAL = rs.getInt("COL_VAL");
				String UPTIME = rs.getString("UPTIME");
				String INTRODUCTION = rs.getString("INTRODUCTION");
				String DETAILNAME = rs.getString("DETAILNAME");
				int bid = rs.getInt("bid");
				String bname = rs.getString("bname");
				String blogo = rs.getString("blogo");
				int b_isval = rs.getInt("b_isval");
				String bpwd = rs.getString("bpwd");
				String bintroduction = rs.getString("bintroduction");
				String bpic = rs.getString("bpic");
				String bmpic = rs.getString("bmpic");
				int bcol_val = rs.getInt(17); 
				int pid = rs.getInt("pid");
				String pname = rs.getString("pname");
				int p_isval = rs.getInt("p_isval");
				int countryid = rs.getInt("countryid");
				String country = rs.getString("country");
				String cpic = rs.getString("cpic");
				Country cou = new Country(countryid, country, cpic);
				Buser buser = new Buser(bid, bname, blogo, b_isval, bpwd, bintroduction, bpic, bmpic, COL_VAL, cou);
				Product product = new Product(pid, pname, p_isval);
				Goods goods = new Goods(GID, buser, product, BNUMBER, PRI, SALE_VAL, bcol_val, UPTIME, INTRODUCTION, DETAILNAME);
				list.add(goods);
			}
			return list;
		}catch(SQLException e){
			 //把DAO层发生的异常 网络  数据库  全部封装成一个异常   因为这些异常用户无法处理。 
		    //但是用户必须知晓.
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
	 * 更新商品的信息
	 * @param goods 该更新的对象
	 * @throws DAOException DAO层获取数据发生异常
	 */
	public void updateGoods(Goods goods) throws DAOException {
		String sql ="UPDATE Goods SET "
				+ "bid=?,pid=?,bnumber=?,pri=?,"
				+ "sale_val=?,col_val=?,uptime=?,introduction=?,detailname=?"
				+ " where gid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, goods.getBuser().getBid());
			pstmt.setInt(2, goods.getPro().getPid());
			pstmt.setInt(3, goods.getNumber());
			pstmt.setDouble(4, goods.getPrice());
			pstmt.setInt(5, goods.getSale_val());
			pstmt.setInt(6,goods.getCol_val());
			pstmt.setString(7,goods.getUptime());
			pstmt.setString(8,goods.getIntroduction());
			pstmt.setString(9,goods.getDetailname());
			pstmt.setInt(10, goods.getGid());
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
	 * 增加商品的销量（+1）
	 * @param gid 库存编号
	 * @throws DAOException DAO层获取数据发生异常
	 */
	public void addGoodsSaleVol(int gid) throws DAOException {
		String sql ="UPDATE Goods SET SALE_VAL=SALE_VAL+1"
				+ " where gid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,gid);
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
	 * 增加商品的收藏（+1）
	 * @param gid 库存编号
	 * @throws DAOException DAO层获取数据发生异常
	 */
	public void addGoodsColVol(int gid) throws DAOException {
		String sql ="UPDATE Goods SET COL_VAL=COL_VAL+1"
				+ " where gid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,gid);
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
	 * 通过商品的编号查询商品
	 * @param gid 商品的编号
	 * @return Goods 返回商品的对象
	 * @throws DAOException DAO层获取数据发现异常
	 */
	public Goods queryGoodsByGid(int gid) throws DAOException {
		String sql = "SELECT g.GID,g.BNUMBER,g.PRI,g.SALE_VAL,"
				+ "g.COL_VAL,g.UPTIME,g.INTRODUCTION,"
				+ "g.DETAILNAME,b.bid, b.bname, b.blogo,"
				+ " b.b_isval, b.bpwd, b.bintroduction, "
				+ "b.bpic, b.bmpic, b.col_val,p.pid, p.pname,"
				+ " p.p_isval,c.countryid, c.country, c.cpic"
				+ " FROM GOODS g,BUSER b,PRODUCT p, country c"
				+ " WHERE g.bid = b.bid and p.pid = g.pid and c.countryid = b.countryid and "
				+ " g.gid = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try{
			conn = DBUtils.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, gid);
			rs = pstm.executeQuery();
			while(rs.next()){
				int GID = rs.getInt("GID");
				int BNUMBER = rs.getInt("BNUMBER");
				double PRI = rs.getDouble("PRI");
				int SALE_VAL = rs.getInt("SALE_VAL");
				int COL_VAL = rs.getInt("COL_VAL");
				String UPTIME = rs.getString("UPTIME");
				String INTRODUCTION = rs.getString("INTRODUCTION");
				String DETAILNAME = rs.getString("DETAILNAME");
				int bid = rs.getInt("bid");
				String bname = rs.getString("bname");
				String blogo = rs.getString("blogo");
				int b_isval = rs.getInt("b_isval");
				String bpwd = rs.getString("bpwd");
				String bintroduction = rs.getString("bintroduction");
				String bpic = rs.getString("bpic");
				String bmpic = rs.getString("bmpic");
				int bcol_val = rs.getInt(17); 
				int pid = rs.getInt("pid");
				String pname = rs.getString("pname");
				int p_isval = rs.getInt("p_isval");
				int countryid = rs.getInt("countryid");
				String country = rs.getString("country");
				String cpic = rs.getString("cpic");
				Country cou = new Country(countryid, country, cpic);
				Buser buser = new Buser(bid, bname, blogo, b_isval, bpwd, bintroduction, bpic, bmpic, COL_VAL, cou);
				Product product = new Product(pid, pname, p_isval);
				Goods goods = new Goods(GID, buser, product, BNUMBER, PRI, SALE_VAL, bcol_val, UPTIME, INTRODUCTION, DETAILNAME);
				//list.add(goods);
				return goods;
			}
		}catch(SQLException e){
			 //把DAO层发生的异常 网络  数据库  全部封装成一个异常   因为这些异常用户无法处理。 
		    //但是用户必须知晓.
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
	
	/*public static void main(String[] args) {
		GoodsDAOImpl g = new GoodsDAOImpl();
		try {
			List<Goods> list = g.queryGoodsByDetail("K");
			for(Goods d:list){
				System.out.println(d.getGid());
			}
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/

}
