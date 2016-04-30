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
 * �����ʵ�ֽӿ�GoodsDAO
 * @author ����
 * @since 2016-04-24
 *
 */
public class GoodsDAOImpl implements GoodsDAO {

	/**
	 * ͨ����Ʒ�ı�Ų�ѯ��Ʒ
	 * @param pid ��Ʒ�ı��
	 * @return Goods ������Ʒ�Ķ���
	 * @throws DAOException DAO���ȡ���ݷ����쳣
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
	 * ͨ����Ʒ�����Ʋ�ѯ��Ʒ
	 * @param pname ��Ʒ������
	 * @return List<Goods> ������Ʒ�ļ��϶���
	 * @throws DAOException DAO���ȡ���ݷ����쳣
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
	 * ͨ����ҵ��Ų�ѯ����ҵ����Ӫ��������Ʒ
	 * @param bid ��ҵ���
	 * @return List<Goods> ������Ʒ�ļ��϶���
	 * @throws DAOException DAO���ȡ���ݷ����쳣
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
	 * ͨ����ҵ���Ʋ�ѯ����ҵ����Ӫ��������Ʒ
	 * @param bname ��ҵ����
	 * @return List<Goods> ������Ʒ�ļ��϶���
	 * @throws DAOException DAO���ȡ���ݷ����쳣
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
	 * ͨ����Ʒ��������ѯ��Ʒ
	 * @param num ��Ʒ������
	 * @return List<Goods> ������Ʒ�ļ��϶���
	 * @throws DAOException DAO���ȡ���ݷ����쳣
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
	 * ͨ����Ʒ��������ѯ��Ʒ
	 * @param vol ��Ʒ������
	 * @return List<Goods> ������Ʒ�ļ��϶���
	 * @throws DAOException DAO���ȡ���ݷ����쳣
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
	 * ͨ���ϼ�ʱ�������Ʒ
	 * @param t1  ��ʼʱ��
	 * @param t2  ����ʱ��
	 * @return List<Goods> ������Ʒ�ļ��϶���
	 * @throws DAOException DAO���ȡ���ݷ����쳣
	 */
	public List<Goods> queryGoodsByUpTime(String t1, String t2)
			throws DAOException {
		return null;
	}

	/**
	 * ��ѯ������Ʒ
	 * @return List<Goods> ������Ʒ�ļ��϶���
	 * @throws DAOException DAO���ȡ���ݷ����쳣
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
	 * ͨ��gid�ҳ���Ʒ��������Ʒ����ϸ����
	 * @param gid ��Ʒ�ı��
	 * @param Detail ���º����Ʒ����ϸ����
	 * @throws DAOException DAO���ȡ���ݷ����쳣
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
	 * ͨ����Ʒ���ɾ����Ʒ
	 * @param gid ��Ʒ���
	 * @throws DAOException DAO���ȡ���ݷ����쳣
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
	 * �����Ʒ
	 * @param goods ��ӵ���Ʒ�Ķ���
	 * @throws DAOException DAO���ȡ���ݷ����쳣
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
	 * ģ����ѯ��Ʒ����ϸ����
	 * @param detail ��Ʒ����ϸ����
	 * @return List<Goods> ������Ʒ����ļ���
	 * @throws DAOException DAO���ȡ���ݷ����쳣
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
	 * ������Ʒ����Ϣ
	 * @param goods �ø��µĶ���
	 * @throws DAOException DAO���ȡ���ݷ����쳣
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
	 * ������Ʒ��������+1��
	 * @param gid �����
	 * @throws DAOException DAO���ȡ���ݷ����쳣
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
	 * ������Ʒ���ղأ�+1��
	 * @param gid �����
	 * @throws DAOException DAO���ȡ���ݷ����쳣
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
	 * ͨ����Ʒ�ı�Ų�ѯ��Ʒ
	 * @param gid ��Ʒ�ı��
	 * @return Goods ������Ʒ�Ķ���
	 * @throws DAOException DAO���ȡ���ݷ����쳣
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
