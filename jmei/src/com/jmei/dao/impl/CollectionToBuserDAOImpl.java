package com.jmei.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jmei.bean.Buser;
import com.jmei.bean.CollectionToBuser;
import com.jmei.bean.Country;
import com.jmei.bean.Juser;
import com.jmei.dao.CollectionToBuserDAO;
import com.jmei.exception.DAOException;
import com.jmei.utils.DBUtils;
/**
 * 实现CollectionToBuserDAO接口
 * @author 邹璐
 * @since 2016-04-24
 */

public class CollectionToBuserDAOImpl implements CollectionToBuserDAO {

	/**
	 * 根据普通用户id查询所有收藏店铺
	 * @param jid 普通用户id
	 * @return List<CollectionToBuser> 返回的CollectionToGoods对象集合
	 * @exception 
	 **/
	@Override
	public List<CollectionToBuser> queryCollectionToBuserByJid(int jid)throws DAOException  {
		String sql="SELECT CID,JU.JID,JU.JNAME,JU.JPWD,JU.JEMAIL,"
				+ "JU.JTEL,JU.JGENDER,JU.JBIR,JU.JUSERISVAL,JU.JPIC,"
				+ "BU.BID,BU.BNAME,BU.BLOGO,BU.B_ISVAL,BU.BPWD,BU.BINTRODUCTION,"
				+ "BU.BPIC,BU.BMPIC,BU.COL_VAL,BU.COUNTRYID,COU.COUNTRYID,COU.COUNTRY,COU.CPIC "
				+ "FROM COLLECTIONTOBUSER COL,JUSER JU,BUSER BU,COUNTRY COU"
				+ " WHERE COL.JID=JU.JID AND COL.BID=BU.BID AND COU.COUNTRYID=BU.COUNTRYID  AND JU.JID=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, jid);
			rs  = pstmt.executeQuery();
			List<CollectionToBuser> list=new ArrayList<CollectionToBuser>();
			while(rs.next()){
			   int cid = rs.getInt("cid");
			   int jid1=rs.getInt("jid");
			   String jname=rs.getString("jname");
			   String jpwd=rs.getString("jpwd");
			   String jemail=rs.getString("jemail");
			   String jtel=rs.getString("jtel");
			   int jgender =rs.getInt("jgender");
			   String jbir=rs.getString("jbir");
			   int juserisval=rs.getInt("juserisval");
			   String jpic=rs.getString("jpic");
			   int bid=rs.getInt("bid");
			   String bname=rs.getString("bname");
			   String blogo=rs.getString("blogo");
			   int isval=rs.getInt("b_isval");
			   String bpwd =rs.getString("bpwd");
			   String bintroduction =rs.getString("bintroduction");
			   String bpic =rs.getString("bpic");
			   String bmpic=rs.getString("bmpic");
			   int col_val=rs.getInt("col_val");
			   int countryid =rs.getInt("countryid");
			   String country1= rs.getString("country");
			   String cpic= rs.getString("cpic");
			   Juser juser=new Juser(jid1,jname,jpwd,jemail,jtel,jgender,jbir,juserisval,jpic);
			   Country country=new Country(countryid,country1,cpic);
			   Buser buser=new Buser(bid,bname,blogo,isval,bpwd,bintroduction,bpic,bmpic,col_val,country);
			   CollectionToBuser ctb= new CollectionToBuser(cid,juser,buser);
			   list.add(ctb);
			}
			return list;
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

	@Override
	public void deleteCollectionBuserByJid(int jid,int bid)throws DAOException  {
		String sql="DELETE FROM COLLECTIONTOBUSER WHERE JID=? AND BID=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,jid);
			pstmt.setInt(2,bid);
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
	public void addCollectionBuserByJid(CollectionToBuser collectionBuser) throws DAOException {
		String sql="INSERT INTO COLLECTIONTOBUSER VALUES(COB_SEQ.NEXTVAL,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, collectionBuser.getJuser().getJid());
			pstmt.setInt(2,collectionBuser.getBuser().getBid());
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
	 * 通过收藏企业id查询用户id
	 * @param bid  收藏企业id
	 * @return jid 用户id
	 * @throws DAOException 
	 */
	public int queryJidByBid(int bid)throws DAOException {
		String sql="SELECT JU.JID FROM COLLECTIONTOBUSER COL,JUSER JU"
				+ " WHERE COL.JID=JU.JID AND COL.BID=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			rs  = pstmt.executeQuery();
			if(rs.next()){
			   int jid1=rs.getInt("jid");
			   return jid1;
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
		return 0;
		
	}

}
