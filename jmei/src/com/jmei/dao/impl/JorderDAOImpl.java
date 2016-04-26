package com.jmei.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jmei.bean.Address;
import com.jmei.bean.Buser;
import com.jmei.bean.Country;
import com.jmei.bean.Goods;
import com.jmei.bean.Jorder;
import com.jmei.bean.Juser;
import com.jmei.bean.Product;
import com.jmei.dao.JorderDAO;
import com.jmei.exception.DAOException;
import com.jmei.utils.DBUtils;

/**
 * JorderDAO接口的实现类
 * 
 * @author 邹璐
 * @since 2016-04-25
 */

public class JorderDAOImpl implements JorderDAO {

	/**
	 * 根据普通用户id查询所有订单
	 * @param jid 普通用户id
	 * @return  List<Jorder> 返回的Jorder集合 
	 * @exception DAOException DAO层获取数据过程发生的异常
	 **/
	@Override
	public List<Jorder> queryAllOrder(int jid) throws DAOException {
		String sql="SELECT "+
				"j.orid,j.gid,j.jis_val,j.onumber,j.jid,j.aid, "+
				"g.gid,g.bid,g.pid,g.bnumber,g.pri,g.sale_val,g.col_val, "+
				"g.uptime,g.introduction,g.detailname, "+
				"a.aid,a.jid,a.address,a.consigneename,a.consigneeid,"+
				"a.tel,a.pnumber,a.detailaddress,"+
				"b.bid,b.bname,b.blogo,b.B_isVal,b.bpwd,b.bintroduction,"+
				"b.bpic,b.bmpic,b.col_val,b.countryid,"+
				"p.pid,p.pname,p.p_isVal,"+
				"ac.countryid,ac.country,ac.cpic,"+
				"ju.jid,ju.jname,ju.jpwd,ju.jemail,ju.jtel,ju.jgender,"+
				"ju.jbir,ju.juserisval,ju.jpic "+
				"FROM jorder j,address a,goods g,buser b,product p,country ac,"+
				"juser ju "+
				"WHERE b.countryid = ac.countryid and g.bid = b.bid and g.pid=p.pid " +
				" and j.jid = ju.jid and a.aid = j.aid and j.gid = g.gid and j.jid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, jid);
			rs = pstmt.executeQuery();
			
			List<Jorder> orders = new ArrayList<Jorder>();
			while(rs.next()) {
				
				Country country = new Country();
				country.setCountry(rs.getString("country"));
				country.setCountryid(rs.getInt("countryid"));
				country.setCpic(rs.getString("cpic"));
				
				Buser buser = new Buser();
				buser.setBid(rs.getInt("bid"));
				buser.setBintroduction(rs.getString("bintroduction"));
				buser.setBlogo(rs.getString("Blogo"));
				buser.setBmpic(rs.getString("Bmpic"));
				buser.setBname(rs.getString("bname"));
				buser.setBpic(rs.getString("bpic"));
				buser.setBpwd(rs.getString("bpwd"));
				buser.setCol_val(rs.getInt(33));
				buser.setCountry(country);
				buser.setIsVal(rs.getInt("B_isVal"));
				
				Product pro = new Product();
				pro.setPid(rs.getInt("pid"));
				pro.setPname(rs.getString("pname"));
				pro.setIsval(rs.getInt("p_isVal"));
				
				Goods goods = new Goods();
				goods.setBuser(buser);
				goods.setCol_val(rs.getInt(13));
				goods.setDetailname(rs.getString("Detailname"));
				goods.setGid(rs.getInt("gid"));
				goods.setIntroduction(rs.getString("Introduction"));
				goods.setNumber(rs.getInt("bnumber"));
				goods.setPrice(rs.getDouble("pri"));
				goods.setPro(pro);
				goods.setSale_val(rs.getInt("sale_val"));
				goods.setUptime(rs.getString("uptime"));
				
				Juser juser = new Juser();
				juser.setIsVal(rs.getInt("juserisval"));
				juser.setJbir(rs.getString("Jbir"));
				juser.setJemail(rs.getString("Jemail"));
				juser.setJgender(rs.getInt("Jgender"));
				juser.setJid(rs.getInt("jid"));
				juser.setJname(rs.getString("jname"));
				juser.setJpic(rs.getString("jpic"));
				juser.setJpwd(rs.getString("jpwd"));
				juser.setJtel(rs.getString("jtel"));
				
				Address ads = new Address();
				ads.setAddress(rs.getString("Address"));
				ads.setAid(rs.getInt("aid"));
				ads.setConsigneeid(rs.getString("consigneeid"));
				ads.setConsigneename(rs.getString("consigneename"));
				ads.setDetailaddress(rs.getString("detailaddress"));
				ads.setJuser(juser);
				ads.setPnumber(rs.getString("Pnumber"));
				ads.setTel(rs.getString("tel"));
				
				Jorder jorder = new Jorder();
				jorder.setAddress(ads);
				jorder.setGoods(goods);
				jorder.setJuser(juser);
				jorder.setIs_Val(rs.getInt("jis_val"));
				jorder.setOnumber(rs.getInt("Onumber"));
				jorder.setOrid(rs.getInt("orid"));
				
				orders.add(jorder);
			}
			return orders;
		} catch (SQLException e) {
			// 把DAO层发生的异常 网络 数据库 全部封装成一个异常 因为这些异常用户无法处理。
			// 但是用户必须知晓.
			throw new DAOException(e.getMessage());
		} finally {
			try {
				DBUtils.close(conn, pstmt, rs);
			} catch (SQLException e) {
				throw new DAOException(e.getMessage());
			}
		}
	}
	/**
	 * 根据普通用户id查询指定状态订单
	 * @param jid 普通用户id
	 * @param is_val 订单状态
	 * @return  List<Jorder> 返回的Jorder集合 
	 * @exception DAOException DAO层获取数据过程发生的异常
	 * 
	 **/
	@Override
	public List<Jorder> queryOrderByIs_Val(int jid, int is_val)
			throws DAOException {
		String sql="SELECT "+
				"j.orid,j.gid,j.jis_val,j.onumber,j.jid,j.aid, "+
				"g.gid,g.bid,g.pid,g.bnumber,g.pri,g.sale_val,g.col_val, "+
				"g.uptime,g.introduction,g.detailname, "+
				"a.aid,a.jid,a.address,a.consigneename,a.consigneeid,"+
				"a.tel,a.pnumber,a.detailaddress,"+
				"b.bid,b.bname,b.blogo,b.B_isVal,b.bpwd,b.bintroduction,"+
				"b.bpic,b.bmpic,b.col_val,b.countryid,"+
				"p.pid,p.pname,p.p_isVal,"+
				"ac.countryid,ac.country,ac.cpic,"+
				"ju.jid,ju.jname,ju.jpwd,ju.jemail,ju.jtel,ju.jgender,"+
				"ju.jbir,ju.juserisval,ju.jpic "+
				"FROM jorder j,address a,goods g,buser b,product p,country ac,"+
				"juser ju "+
				"WHERE b.countryid = ac.countryid and g.bid = b.bid and g.pid=p.pid " +
				" and j.jid = ju.jid and a.aid = j.aid and j.gid = g.gid and j.jid=? and j.jis_val=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, jid);
			pstmt.setInt(2, is_val);
			rs = pstmt.executeQuery();
			List<Jorder> orders = new ArrayList<Jorder>();
			while (rs.next()) {
				Country country = new Country();
				country.setCountry(rs.getString("country"));
				country.setCountryid(rs.getInt("countryid"));
				country.setCpic(rs.getString("cpic"));
				
				Buser buser = new Buser();
				buser.setBid(rs.getInt("bid"));
				buser.setBintroduction(rs.getString("bintroduction"));
				buser.setBlogo(rs.getString("Blogo"));
				buser.setBmpic(rs.getString("Bmpic"));
				buser.setBname(rs.getString("bname"));
				buser.setBpic(rs.getString("bpic"));
				buser.setBpwd(rs.getString("bpwd"));
				buser.setCol_val(rs.getInt(33));
				buser.setCountry(country);
				buser.setIsVal(rs.getInt("B_isVal"));
				
				Product pro = new Product();
				pro.setPid(rs.getInt("pid"));
				pro.setPname(rs.getString("pname"));
				pro.setIsval(rs.getInt("p_isVal"));
				
				Goods goods = new Goods();
				goods.setBuser(buser);
				goods.setCol_val(rs.getInt(13));
				goods.setDetailname(rs.getString("Detailname"));
				goods.setGid(rs.getInt("gid"));
				goods.setIntroduction(rs.getString("Introduction"));
				goods.setNumber(rs.getInt("bnumber"));
				goods.setPrice(rs.getDouble("pri"));
				goods.setPro(pro);
				goods.setSale_val(rs.getInt("sale_val"));
				goods.setUptime(rs.getString("uptime"));
				
				Juser juser = new Juser();
				juser.setIsVal(rs.getInt("juserisval"));
				juser.setJbir(rs.getString("Jbir"));
				juser.setJemail(rs.getString("Jemail"));
				juser.setJgender(rs.getInt("Jgender"));
				juser.setJid(rs.getInt("jid"));
				juser.setJname(rs.getString("jname"));
				juser.setJpic(rs.getString("jpic"));
				juser.setJpwd(rs.getString("jpwd"));
				juser.setJtel(rs.getString("jtel"));
				
				Address ads = new Address();
				ads.setAddress(rs.getString("Address"));
				ads.setAid(rs.getInt("aid"));
				ads.setConsigneeid(rs.getString("consigneeid"));
				ads.setConsigneename(rs.getString("consigneename"));
				ads.setDetailaddress(rs.getString("detailaddress"));
				ads.setJuser(juser);
				ads.setPnumber(rs.getString("Pnumber"));
				ads.setTel(rs.getString("tel"));
				
				Jorder jorder = new Jorder();
				jorder.setAddress(ads);
				jorder.setGoods(goods);
				jorder.setJuser(juser);
				jorder.setIs_Val(rs.getInt("jis_val"));
				jorder.setOnumber(rs.getInt("Onumber"));
				jorder.setOrid(rs.getInt("orid"));
				
				orders.add(jorder);
				
			}

		} catch (SQLException e) {
			// 把DAO层发生的异常 网络 数据库 全部封装成一个异常 因为这些异常用户无法处理。
			// 但是用户必须知晓.
			throw new DAOException(e.getMessage());
		} finally {
			try {
				DBUtils.close(conn, pstmt, rs);
			} catch (SQLException e) {
				throw new DAOException(e.getMessage());
			}
		}
		return null;
	}

	/**
	 * 添加订单
	 * @param Jorder Jorder对象
	 * @return  
	 * @exception DAOException DAO层获取数据过程发生的异常
	 **/
	@Override
	public void addJorder(Jorder jorder) throws DAOException {
		String sql="INSERT INTO JORDER VALUES(ORDER_SEQ.NEXTVAL,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,jorder.getGoods().getGid());
			pstmt.setInt(2,jorder.getJuser().getJid());
			pstmt.setInt(3,jorder.getAddress().getAid());
			pstmt.setInt(4,jorder.getIs_Val());
			pstmt.setInt(5,jorder.getOnumber());
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
	 * 根据普通用户id修改订单状态
	 * @param jid 普通用户id
	 * @return  
	 * @exception DAOException DAO层获取数据过程发生的异常
	 **/
	@Override
	public void updateIs_valByJid(int orid,int is_val) throws DAOException {
		String sql="UPDATE 	JORDER SET IS_VAL=? WHERE ORID=?  ";
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				conn = DBUtils.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1,is_val);
				pstmt.setInt(2, orid);
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

}
