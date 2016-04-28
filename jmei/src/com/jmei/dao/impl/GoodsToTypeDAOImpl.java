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
import com.jmei.bean.GoodsToType;
import com.jmei.bean.Gtype;
import com.jmei.bean.Product;
import com.jmei.dao.GoodsToTypeDAO;
import com.jmei.exception.DAOException;
import com.jmei.utils.DBUtils;

/**
 * GoodsToTypeDAO�ӿڵ�ʵ����
 * @author ����
 * @since 2016-04-25
 *
 */
public class GoodsToTypeDAOImpl implements GoodsToTypeDAO {

	/**
	 * ������Ʒ������
	 * @param gid ��Ʒ�ı��
	 * @param tid ���͵ı��
	 * @throws DAOException DAO���ȡ���ݷ����쳣
	 */
	public void addGoodsToType(int gid, int tid) throws DAOException {
		String sql ="INSERT INTO GOODSTOTYPE" +
				" VALUES(?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, gid); //�����û���1״̬ʧЧ
			pstmt.setInt(2, tid);
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

	/**
	 * ������Ʒ������
	 * @param gid ��Ʒ�ı��
	 * @param tid ���͵ı��
	 * @param newtid �޸ĺ�ı��
	 * @throws DAOException DAO���ȡ���ݷ����쳣
	 */
	public void updateGoodsToType(int gid, int tid,int newtid) throws DAOException {
		String sql ="UPDATE GOODSTOTYPE SET TID=?"
				+ " where GID = ? and TID = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, newtid); //�����û���1״̬ʧЧ
			pstmt.setInt(2, gid);
			pstmt.setInt(3, tid);
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

	/**
	 * ɾ����Ʒ�Ĺ�Ч
	 * @param gid ��Ʒ�ı��
	 * @param tid ���͵ı��
	 * @throws DAOException DAO���ȡ���ݷ����쳣
	 */
	public void deleteGoodsToType(int gid, int tid) throws DAOException {
		String sql ="DELETE GOODSTOTYPE"
				+ " where GID = ? AND TID = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, gid); 
			pstmt.setInt(2, tid);
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

	/**
	 * ����Ʒ�ı�Ų�ѯ��Ʒ��Ӧ������
	 * @param gid ��Ʒ�ı��
	 * @return ��Ʒ��Ӧ���͵ļ��϶���
	 * @throws DAOException DAO���ȡ���ݷ����쳣
	 */
	public List<GoodsToType> queryGoodsToTypeBygid(int gid) throws DAOException {
		String sql = "SELECT g.gid,g.tid,good.gid,good.bid,good.pid,good.bnumber,"+
					"good.pri,good.sale_val,good.col_val,good.uptime,good.introduction,"+
					"good.detailname,b.bid, b.bname, b.blogo, b.b_isval,"+
					"b.bpwd, b.bintroduction, b.bpic, b.bmpic, b.col_val,"+
					"p.pid, p.pname, p.p_isval,c.countryid, c.country, c.cpic,e.tname "+
					"FROM GoodsToType g,GOODS good,BUSER b,PRODUCT p, country c,gtype e "+
					"WHERE g.gid = good.gid and c.countryid = b.countryid and "+
					"p.pid = good.pid and good.bid = b.bid  and e.tid = g.tid "+
					"and g.gid = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try{
			conn = DBUtils.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, gid);
			rs = pstm.executeQuery();
			ArrayList<GoodsToType> list = new ArrayList<GoodsToType>();
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
				
				Gtype gtype = new Gtype();
				gtype.setTid(rs.getInt("tid"));
				gtype.setTname(rs.getString("tname"));
				
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
				
				GoodsToType gtoe = new GoodsToType(goods, gtype);
				list.add(gtoe);
			}
			return list;
		}catch(SQLException e){
			 //��DAO�㷢�����쳣 ����  ���ݿ�  ȫ����װ��һ���쳣   ��Ϊ��Щ�쳣�û��޷����� 
		    //�����û�����֪��.
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
	 * �����͵ı�Ų�ѯ��Ʒ��Ӧ�Ĺ�Ч
	 * @param tid ���͵ı��
	 * @return ��Ʒ��Ӧ���͵ļ��϶���
	 * @throws DAOException DAO���ȡ���ݷ����쳣
	 */
	public List<GoodsToType> queryGoodsToTypeBytid(int tid) throws DAOException {
		String sql = "SELECT g.gid,g.tid,good.gid,good.bid,good.pid,good.bnumber,"+
				"good.pri,good.sale_val,good.col_val,good.uptime,good.introduction,"+
				"good.detailname,b.bid, b.bname, b.blogo, b.b_isval,"+
				"b.bpwd, b.bintroduction, b.bpic, b.bmpic, b.col_val,"+
				"p.pid, p.pname, p.p_isval,c.countryid, c.country, c.cpic,e.tname "+
				"FROM GoodsToType g,GOODS good,BUSER b,PRODUCT p, country c,gtype e "+
				"WHERE g.gid = good.gid and c.countryid = b.countryid and "+
				"p.pid = good.pid and good.bid = b.bid  and e.tid = g.tid "+
				"and g.tid = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try{
			conn = DBUtils.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, tid);
			rs = pstm.executeQuery();
			ArrayList<GoodsToType> list = new ArrayList<GoodsToType>();
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
				
				Gtype gtype = new Gtype();
				gtype.setTid(rs.getInt("tid"));
				gtype.setTname(rs.getString("tname"));
				
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
				
				GoodsToType gtoe = new GoodsToType(goods, gtype);
				list.add(gtoe);
			}
			return list;
		}catch(SQLException e){
			 //��DAO�㷢�����쳣 ����  ���ݿ�  ȫ����װ��һ���쳣   ��Ϊ��Щ�쳣�û��޷����� 
		    //�����û�����֪��.
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
	 * ͨ����Ʒ�����Ͳ�ѯ��Ʒ
	 * @param type ��Ʒ������
	 * @return List<Goods> ������Ʒ�ļ��϶���
	 * @throws DAOException DAO���ȡ���ݷ����쳣
	 */
	public List<GoodsToType> queryGoodsByType(String type) throws DAOException {
		String sql = "SELECT g.gid,g.tid,good.gid,good.bid,good.pid,good.bnumber,"+
				"good.pri,good.sale_val,good.col_val,good.uptime,good.introduction,"+
				"good.detailname,b.bid, b.bname, b.blogo, b.b_isval,"+
				"b.bpwd, b.bintroduction, b.bpic, b.bmpic, b.col_val,"+
				"p.pid, p.pname, p.p_isval,c.countryid, c.country, c.cpic,e.tname "+
				"FROM GoodsToType g,GOODS good,BUSER b,PRODUCT p, country c,gtype e "+
				"WHERE g.gid = good.gid and c.countryid = b.countryid and "+
				"p.pid = good.pid and good.bid = b.bid  and e.tid = g.tid "+
				"and e.tname = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try{
			conn = DBUtils.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, type);
			rs = pstm.executeQuery();
			ArrayList<GoodsToType> list = new ArrayList<GoodsToType>();
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
				
				Gtype gtype = new Gtype();
				gtype.setTid(rs.getInt("tid"));
				gtype.setTname(rs.getString("tname"));
				
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
				
				GoodsToType gtoe = new GoodsToType(goods, gtype);
				list.add(gtoe);
			}
			return list;
		}catch(SQLException e){
			 //��DAO�㷢�����쳣 ����  ���ݿ�  ȫ����װ��һ���쳣   ��Ϊ��Щ�쳣�û��޷����� 
		    //�����û�����֪��.
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
