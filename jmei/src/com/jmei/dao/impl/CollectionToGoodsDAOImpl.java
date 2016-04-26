package com.jmei.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jmei.bean.Buser;
import com.jmei.bean.CollectionToGoods;
import com.jmei.bean.Country;
import com.jmei.bean.Goods;
import com.jmei.bean.Juser;
import com.jmei.bean.Product;
import com.jmei.dao.CollectionToGoodsDAO;
import com.jmei.exception.DAOException;
import com.jmei.utils.DBUtils;
/**
 * 实现CollectionToGoodsDAO接口的类
 * @author 邹璐
 * @since 2016-04-25
 *
 */

public class CollectionToGoodsDAOImpl implements CollectionToGoodsDAO {
	/**
	 * cbid number(20) primary key,  --编号--
	jid number(20),				--用户id--
	gid number(20) primary key,  --编号--
	bid number(20),				--企业用户id--
	pid number(20),				--商品id--
	bnumber number,				--商品库存数量--
	pri number(20),				--商品价格--
	sale_val number,			--销量--
	col_val number,				--收藏数量--
	uptime varchar2(20),		--上架时间--
	introduction varchar2(200),	--商品简介--
	detailname varchar2(50) 	--详细名称--
	pid number(20) primary key,  	--编号--
	pname varchar2(20),    			--商品名--
	p_isVal number (2)				--是否删除--
	 */
	@Override
	public List<CollectionToGoods> queryCollectionToGoodsByJid(int jid)
			throws DAOException {
		String sql="SELECT CBID,JU.JID,JU.JNAME,JU.JPWD,JU.JEMAIL,"
				+ "JU.JTEL,JU.JGENDER,JU.JBIR,JU.JUSERISVAL,JU.JPIC,GO.GID,"
				+ "BU.BID,BU.BNAME,BU.BLOGO,BU.B_ISVAL,BU.BPWD,BU.BINTRODUCTION,BU.BPIC,BU.BMPIC,BU.COL_VAL,"
				+ "COU.COUNTRYID,COU.COUNTRY,COU.CPIC,"
				+ "PR.PID,PR.PNAME,PR.P_ISVAL,"
				+ "GO.BNUMBER,GO.PRI,GO.SALE_VAL,GO.COL_VAL,GO.UPTIME,GO.INTRODUCTION,"
				+ "GO.DETAILNAME "
				+ "FROM COLLECTIONTOGOODS COL,JUSER JU,GOODS GO,BUSER BU,PRODUCT PR,COUNTRY COU"
				+ " WHERE COL.JID=JU.JID AND COL.GID=GO.GID AND GO.BID=BU.BID AND GO.PID=PR.PID AND COU.COUNTRYID=BU.COUNTRYID AND JU.JID=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, jid);
			rs  = pstmt.executeQuery();
			List<CollectionToGoods> list=new ArrayList<CollectionToGoods>();
			if(rs.next()){
			   int cbid = rs.getInt("cbid");
			   int jid1=rs.getInt("jid");
			   String jname=rs.getString("jname");
			   String jpwd=rs.getString("jpwd");
			   String jemail=rs.getString("jemail");
			   String jtel=rs.getString("jtel");
			   int jgender =rs.getInt("jgender");
			   String jbir=rs.getString("jbir");
			   int juserisval=rs.getInt("juserisval");
			   String jpic=rs.getString("jpic");
			   int gid=rs.getInt("gid");
			   int bid=rs.getInt("bid");
			   String bname=rs.getString("bname");
			   String blogo=rs.getString("blogo");
			   int isval=rs.getInt("b_isVal");
			   String bpwd =rs.getString("bpwd");
			   String bintroduction =rs.getString("bintroduction");
			   String bpic =rs.getString("bpic");
			   String bmpic=rs.getString("bmpic");
			   int col_val=rs.getInt("col_val");
			   int countryid =rs.getInt("countryid");
			   String country1= rs.getString("country");
			   String cpic= rs.getString("cpic");
			   int pid=rs.getInt("pid");
			   String pname=rs.getString("pname");
			   int p_isVal=rs.getInt("p_isVal");
			   int bnumber =rs.getInt("bnumber");
			   int pri=rs.getInt("pri");
			   int sale_val =rs.getInt("sale_val");
			   int col_val1 =rs.getInt("col_val");
			   String uptime=rs.getString("uptime");
			   String introduction= rs.getString("introduction");
			   String detailname= rs.getString("detailname");
			   Juser juser=new Juser(jid1,jname,jpwd,jemail,jtel,jgender,jbir,juserisval,jpic);
			   Country country=new Country(countryid,country1,cpic);
			   Buser buser=new Buser(bid,bname,blogo,isval,bpwd,bintroduction,bpic,bmpic,col_val,country);
			   Product pro=new Product(pid,pname,p_isVal);
			   Goods goods=new Goods(gid,buser,pro,bnumber,pri,sale_val,col_val1,uptime,introduction,detailname);
			   CollectionToGoods ctb= new CollectionToGoods(cbid,juser,goods);
			   list.add(ctb);
			   return list;
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

	@Override
	public void deleteCollectionGoodsByJid(int jid,int cbid) throws DAOException {
		String sql="DELETE FROM COLLECTIONTOGOODS WHERE JID=? AND CBID=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,jid);
			pstmt.setInt(2,cbid);
			pstmt.execute();	
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

	@Override
	public void addCollectionGoodsByJid(CollectionToGoods collectionGoods)
			throws DAOException {
		String sql="INSERT INTO COLLECTIONTOGOODS VALUES(COG_SEQ.NEXTVAL,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, collectionGoods.getJuser().getJid());
			pstmt.setInt(2,collectionGoods.getGoods().getGid());
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
