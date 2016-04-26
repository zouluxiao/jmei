package com.jmei.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jmei.bean.Juser;
import com.jmei.dao.JuserDAO;
import com.jmei.exception.DAOException;
import com.jmei.utils.DBUtils;
/**
 * JuserDAO接口的实现类;
 * @author 邹璐
 * @since 2016-04-25
 *
 */

public class JuserDAOImpl implements JuserDAO {
	
	@Override
	public Juser queryjUserByJid(int jid)throws DAOException {
		String sql="SELECT JNAME,JPWD,JEMAIL,JTEL,JGENDER,JBIR,ISVAL,JPIC "
				+ "FROM JUSER WHERE JID=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,jid);
			rs  = pstmt.executeQuery();
			if(rs.next()){
			   String jname = rs.getString("jname");
			   String jpwd = rs.getString("jpwd");
			   String jemail = rs.getString("jemail");
			   String jtel = rs.getString("jtel");
			   int jgender = rs.getInt("jgender");
			   String jbir = rs.getString("jbir"); 
			   int isval = rs.getInt("isval");
			   String jpic = rs.getString("jpic");
			   Juser user=new Juser(jid,jname,jpwd,jemail,jtel,jgender,jbir,isval,jpic);
			   return user;
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
	public Juser queryJuserByJname(String jname)throws DAOException {
		String sql="SELECT JID,JPWD,JEMAIL,JTEL,JGENDER,JBIR,ISVAL,JPIC "
				+ "FROM JUSER WHERE JNAME=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,jname);
			rs  = pstmt.executeQuery();
			if(rs.next()){
			   int jid = rs.getInt("jid");
			   String jpwd = rs.getString("jpwd");
			   String jemail = rs.getString("jemail");
			   String jtel = rs.getString("jtel");
			   int jgender = rs.getInt("jgender");
			   String jbir = rs.getString("jbir"); 
			   int isval = rs.getInt("isval");
			   String jpic = rs.getString("jpic");
			   Juser user=new Juser(jid,jname,jpwd,jemail,jtel,jgender,jbir,isval,jpic);
			   return user;
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
	public Juser queryJuserByJtel(String jtel)throws DAOException {
		String sql="SELECT JID,JNAME,JPWD,JEMAIL,JTEL,JGENDER,JBIR,ISVAL,JPIC "
				+ "FROM JUSER WHERE JTEL=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,jtel);
			rs  = pstmt.executeQuery();
			if(rs.next()){
			   int jid = rs.getInt("jid");
			   String jname=rs.getString("jname");
			   String jpwd = rs.getString("jpwd");
			   String jemail = rs.getString("jemail");
			   String jtel1 = rs.getString("jtel");
			   int jgender = rs.getInt("jgender");
			   String jbir = rs.getString("jbir"); 
			   int isval = rs.getInt("isval");
			   String jpic = rs.getString("jpic");
			   Juser user=new Juser(jid,jname,jpwd,jemail,jtel1,jgender,jbir,isval,jpic);
			   return user;
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
	public Juser queryJuserByJemail(String jemail)throws DAOException {
		String sql="SELECT JID,JNAME,JPWD,JTEL,JGENDER,JBIR,ISVAL,JPIC "
				+ "FROM JUSER WHERE JEMAIL=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,jemail);
			rs  = pstmt.executeQuery();
			if(rs.next()){
			   int jid = rs.getInt("jid");
			   String jname=rs.getString("jname");
			   String jpwd = rs.getString("jpwd");
			   String jtel1 = rs.getString("jtel");
			   int jgender = rs.getInt("jgender");
			   String jbir = rs.getString("jbir"); 
			   int isval = rs.getInt("isval");
			   String jpic = rs.getString("jpic");
			   Juser user=new Juser(jid,jname,jpwd,jemail,jtel1,jgender,jbir,isval,jpic);
			   return user;
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
	public List<Juser> queryAllJuser()throws DAOException {
		String sql="SELECT JID,JNAME,JPWD,JEMAIL,JTEL,JGENDER,JBIR,ISVAL,JPIC "
				+ "FROM JUSER";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs  = pstmt.executeQuery();
			List<Juser> juseres=new ArrayList<Juser>();
			if(rs.next()){
			   int jid = rs.getInt("jid");
			   String jname=rs.getString("jname");
			   String jpwd = rs.getString("jpwd");
			   String jemail1 = rs.getString("jemail");
			   String jtel1 = rs.getString("jtel");
			   int jgender = rs.getInt("jgender");
			   String jbir = rs.getString("jbir"); 
			   int isval = rs.getInt("isval");
			   String jpic = rs.getString("jpic");
			   Juser user=new Juser(jid,jname,jpwd,jemail1,jtel1,jgender,jbir,isval,jpic);
			   juseres.add(user);
			   return juseres;
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
	public void updateIsValByjid(int jid, int isVal)throws DAOException {
		String sql="UPDATE JUSER SET ISVAL=? WHERE JID=?";
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				conn = DBUtils.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, isVal);
				pstmt.setInt(2, jid);
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

	@Override
	public void updateJnameByJid(int jid, String jname) throws DAOException{
		String sql="UPDATE JUSER SET JNAME=? WHERE JID=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, jname);
			pstmt.setInt(2, jid);
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

	@Override
	public void updateJemailByJid(int jid, String jemail)throws DAOException {
		String sql="UPDATE JUSER SET JEMAIL=? WHERE JID=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, jemail);
			pstmt.setInt(2, jid);
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

	@Override
	public void updateTelByJid(int jid, String jtel)throws DAOException {
		String sql="UPDATE JUSER SET JTEL=? WHERE JID=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, jtel);
			pstmt.setInt(2, jid);
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

	@Override
	public void updateOtherByJid(Juser juser)throws DAOException {
		String sql="UPDATE JUSER SET JGENDER=?,JBIR=?,ISVAL=?,JPIC=? WHERE JID=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, juser.getJgender());
			pstmt.setString(2, juser.getJbir());
			pstmt.setInt(3, juser.getIsVal());
			pstmt.setString(4, juser.getJpic());
			pstmt.setInt(5, juser.getJid());
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

	@Override
	public void addJuser(Juser juser)throws DAOException {
		String sql="INSERT INTO JUSER VALUES(JU_SEQ.NEXTVAL,?,?,?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,juser.getJname());
			pstmt.setString(2,juser.getJpwd());
			pstmt.setString(3,juser.getJemail());
			pstmt.setString(4,juser.getJtel());
			pstmt.setInt(5,juser.getJgender());
			pstmt.setString(6,juser.getJbir());
			pstmt.setInt(7,juser.getIsVal());
			pstmt.setString(8,juser.getJpic());
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

	@Override// JID,JNAME,JPWD,JEMAIL,JTEL,JGENDER,JBIR,ISVAL,JPIC
	public void addJuser(String jname, String jpwd, String jtel, int isVal) throws DAOException{
		String sql="INSERT INTO JUSER VALUES(JU_SEQ.NEXTVAL,?,?,?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,jname);
			pstmt.setString(2,jpwd);
			pstmt.setString(3,null);
			pstmt.setString(4,jtel);
			pstmt.setInt(5,0);
			pstmt.setString(6,null);
			pstmt.setInt(7,isVal);
			pstmt.setString(8,null);
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
