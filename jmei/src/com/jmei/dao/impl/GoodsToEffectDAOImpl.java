package com.jmei.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jmei.bean.Buser;
import com.jmei.bean.Country;
import com.jmei.bean.Effect;
import com.jmei.bean.Goods;
import com.jmei.bean.GoodsToEffect;
import com.jmei.bean.Product;
import com.jmei.dao.GoodsToEffectDAO;
import com.jmei.exception.DAOException;
import com.jmei.utils.DBUtils;

/**
 * GoodsToEffectDAO接口的实现类
 * @author 汤亮
 * @since 2016-04-25
 *
 */
public class GoodsToEffectDAOImpl implements GoodsToEffectDAO {

	/**
	 * 增加商品的功效
	 * @param gid 商品的编号
	 * @param eid 功效的编号
	 * @throws DAOException DAO层获取数据发生异常
	 */
	public void addGoodsToEffect(int gid, int eid) throws DAOException {
		String sql ="INSERT INTO GOODSTOEFFECT" +
				" VALUES(?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, gid); //设置用户的1状态失效
			pstmt.setInt(2, eid);
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
	 * 修改商品的功效
	 * @param gid 商品的编号
	 * @param eid 功效的编号
	 * @param neweid 修改后的编号
	 * @throws DAOException DAO层获取数据发生异常
	 */
	public void updateGoodsToEffect(int gid, int eid,int neweid) throws DAOException {
		String sql ="UPDATE GOODSTOEFFECT SET EID=?"
				+ " where GID = ? and EID = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, neweid); 
			pstmt.setInt(2, gid);
			pstmt.setInt(3,eid);
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
	 * 删除商品的功效
	 * @param gid 商品的编号
	 * @param eid 功效的编号
	 * @throws DAOException DAO层获取数据发生异常
	 */
	public void deleteGoodsToEffect(int gid, int eid) throws DAOException {
		String sql ="DELETE GOODSTOEFFECT"
				+ " where GID = ? AND EID = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, gid); 
			pstmt.setInt(2, eid);
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
	 * 按商品编号查找商品对应的功效
	 * @param gid 商品编号
	 * @return 商品对应功效的集合对象
	 * @throws DAOException DAO层获取数据发生异常
	 */
	public List<GoodsToEffect> queryGoodsToEffectBygid(int gid)
			throws DAOException {
		String sql = "SELECT g.gid,g.eid,good.gid,good.bid,good.pid,good.bnumber,"+
				"good.pri,good.sale_val,good.col_val,good.uptime,good.introduction,"+
				"good.detailname,b.bid, b.bname, b.blogo, b.b_isval, "+
				"b.bpwd, b.bintroduction, b.bpic, b.bmpic, b.col_val,"+
				"p.pid, p.pname, p.p_isval,c.countryid, c.country, c.cpic,e.ename "+
				"FROM goodsToEffect g,GOODS good,BUSER b,PRODUCT p, country c,Effect e"+
				" WHERE g.gid = good.gid and c.countryid = b.countryid and "+
				"p.pid = good.pid and good.bid = b.bid and g.gid=? and e.eid = g.eid";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try{
			conn = DBUtils.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, gid);
			rs = pstm.executeQuery();
			ArrayList<GoodsToEffect> list = new ArrayList<GoodsToEffect>();
			while(rs.next()){
				Country country = new Country();
				country.setCountryid(rs.getInt("countryid"));
				country.setCountry(rs.getString("country"));
				country.setCpic(rs.getString("cpic"));
				
				Product product = new Product();
				product.setPid(rs.getInt("pid"));
				product.setPname(rs.getString("pname"));
				product.setIsval(rs.getInt("p_isval"));
				
				Buser buser = new Buser();
				buser.setBid(rs.getInt("bid"));
				buser.setBintroduction(rs.getString("Bintroduction"));
				buser.setBlogo(rs.getString("Blogo"));
				buser.setBmpic(rs.getString("bmpic"));
				buser.setBname(rs.getString("bname"));
				buser.setBpic(rs.getString("bpic"));
				buser.setBpwd(rs.getString("bpwd"));
				buser.setCol_val(rs.getInt("col_val"));
				buser.setCountry(country);
				buser.setIsVal(rs.getInt("b_isval"));
				
				Effect effect = new Effect();
				effect.setEid(rs.getInt("eid"));
				effect.setEname(rs.getString("ename"));
				
				Goods goods = new Goods();
				goods.setBuser(buser);
				goods.setCol_val(rs.getInt(9));
				goods.setDetailname(rs.getString("Detailname"));
				goods.setGid(rs.getInt("gid"));
				goods.setIntroduction(rs.getString(11));
				goods.setNumber(rs.getInt("bnumber"));
				goods.setPrice(rs.getInt("pri"));
				goods.setPro(product);
				goods.setSale_val(rs.getInt(8));
				goods.setUptime(rs.getString("uptime"));
				
				GoodsToEffect gtoe = new GoodsToEffect(goods, effect);
				list.add(gtoe);
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
	 * 按功效的编号查询商品对应的功效
	 * @param eid 功效的编号
	 * @return 商品对应功效的集合对象
	 * @throws DAOException DAO层获取数据发生异常
	 */
	public List<GoodsToEffect> queryGoodsToEffectByeid(int eid)
			throws DAOException {
		String sql = "SELECT g.gid,g.eid,good.gid,good.bid,good.pid,good.bnumber,"+
				"good.pri,good.sale_val,good.col_val,good.uptime,good.introduction,"+
				"good.detailname,b.bid, b.bname, b.blogo, b.b_isval, "+
				"b.bpwd, b.bintroduction, b.bpic, b.bmpic, b.col_val,"+
				"p.pid, p.pname, p.p_isval,c.countryid, c.country, c.cpic,e.ename "+
				"FROM goodsToEffect g,GOODS good,BUSER b,PRODUCT p, country c,Effect e"+
				" WHERE g.gid = good.gid and c.countryid = b.countryid and "+
				"p.pid = good.pid and good.bid = b.bid and g.eid=? and e.eid = g.eid";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try{
			conn = DBUtils.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, eid);
			rs = pstm.executeQuery();
			ArrayList<GoodsToEffect> list = new ArrayList<GoodsToEffect>();
			while(rs.next()){
				Country country = new Country();
				country.setCountryid(rs.getInt("countryid"));
				country.setCountry(rs.getString("country"));
				country.setCpic(rs.getString("cpic"));
				
				Product product = new Product();
				product.setPid(rs.getInt("pid"));
				product.setPname(rs.getString("pname"));
				product.setIsval(rs.getInt("p_isval"));
				
				Buser buser = new Buser();
				buser.setBid(rs.getInt("bid"));
				buser.setBintroduction(rs.getString("Bintroduction"));
				buser.setBlogo(rs.getString("Blogo"));
				buser.setBmpic(rs.getString("bmpic"));
				buser.setBname(rs.getString("bname"));
				buser.setBpic(rs.getString("bpic"));
				buser.setBpwd(rs.getString("bpwd"));
				buser.setCol_val(rs.getInt(21));
				buser.setCountry(country);
				buser.setIsVal(rs.getInt("b_isval"));
				
				Effect effect = new Effect();
				effect.setEid(rs.getInt("eid"));
				effect.setEname(rs.getString("ename"));
				
				Goods goods = new Goods();
				goods.setBuser(buser);
				goods.setCol_val(rs.getInt(9));
				goods.setDetailname(rs.getString("Detailname"));
				goods.setGid(rs.getInt("gid"));
				goods.setIntroduction(rs.getString(11));
				goods.setNumber(rs.getInt("bnumber"));
				goods.setPrice(rs.getInt("pri"));
				goods.setPro(product);
				goods.setSale_val(rs.getInt(8));
				goods.setUptime(rs.getString("uptime"));
				
				GoodsToEffect gtoe = new GoodsToEffect(goods, effect);
				list.add(gtoe);
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
	 * 通商品的功效查询商品
	 * @param effect 商品的功效
	 * @return List<Goods> 返回商品的集合对象
	 * @throws DAOException DAO层获取数据发生异常
	 */
	public List<GoodsToEffect> queryGoodsByEffect(String effect) throws DAOException {
		String sql = "SELECT g.gid,g.eid,good.gid,good.bid,good.pid,good.bnumber,"+
				"good.pri,good.sale_val,good.col_val,good.uptime,good.introduction,"+
				"good.detailname,b.bid, b.bname, b.blogo, b.b_isval, "+
				"b.bpwd, b.bintroduction, b.bpic, b.bmpic, b.col_val,"+
				"p.pid, p.pname, p.p_isval,c.countryid, c.country, c.cpic,e.ename "+
				"FROM goodsToEffect g,GOODS good,BUSER b,PRODUCT p, country c,Effect e"+
				" WHERE g.gid = good.gid and c.countryid = b.countryid and "+
				"p.pid = good.pid and good.bid = b.bid  and e.eid = g.eid and e.ename = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try{
			conn = DBUtils.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, effect);
			rs = pstm.executeQuery();
			ArrayList<GoodsToEffect> list = new ArrayList<GoodsToEffect>();
			while(rs.next()){
				Country country = new Country();
				country.setCountryid(rs.getInt("countryid"));
				country.setCountry(rs.getString("country"));
				country.setCpic(rs.getString("cpic"));
				
				Product product = new Product();
				product.setPid(rs.getInt("pid"));
				product.setPname(rs.getString("pname"));
				product.setIsval(rs.getInt("p_isval"));
				
				Buser buser = new Buser();
				buser.setBid(rs.getInt("bid"));
				buser.setBintroduction(rs.getString("Bintroduction"));
				buser.setBlogo(rs.getString("Blogo"));
				buser.setBmpic(rs.getString("bmpic"));
				buser.setBname(rs.getString("bname"));
				buser.setBpic(rs.getString("bpic"));
				buser.setBpwd(rs.getString("bpwd"));
				buser.setCol_val(rs.getInt(21));
				buser.setCountry(country);
				buser.setIsVal(rs.getInt("b_isval"));
				
				Effect effect1 = new Effect();
				effect1.setEid(rs.getInt("eid"));
				effect1.setEname(rs.getString("ename"));
				
				Goods goods = new Goods();
				goods.setBuser(buser);
				goods.setCol_val(rs.getInt(9));
				goods.setDetailname(rs.getString("Detailname"));
				goods.setGid(rs.getInt("gid"));
				goods.setIntroduction(rs.getString(11));
				goods.setNumber(rs.getInt("bnumber"));
				goods.setPrice(rs.getInt("pri"));
				goods.setPro(product);
				goods.setSale_val(rs.getInt(8));
				goods.setUptime(rs.getString("uptime"));
				
				GoodsToEffect gtoe = new GoodsToEffect(goods, effect1);
				list.add(gtoe);
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

}
