package com.jmei.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jmei.bean.Address;
import com.jmei.bean.Juser;
import com.jmei.dao.AddressDAO;
import com.jmei.exception.DAOException;
import com.jmei.utils.DBUtils;
/**
 * AddressDAO�ӿڵ�ʵ����
 * @author ���
 * @since 2016-04-24
 *
 */

public class AddressDAOImpl implements AddressDAO {
	
	/**
	 * �����û�id��ѯ���е�ַ
	 * @param jid ��ͨ�û�id
	 * @return List<Address> Address���󼯺�
	 */
	@Override//detailaddress juserisval
	public List<Address> queryAllAdressByJid(int jid) throws DAOException{
		//1.����DBUtils���߰� �������� Ȼ���ȡ����
				String sql ="SELECT AID,JU.JID,JU.JNAME,JU.JPWD,JU.JEMAIL,JU.JTEL,"
						+ "JU.JGENDER,JU.JBIR,JU.JUSERISVAL,JU.JPIC,"
						+ "ADDRESS,CONSIGNEENAME,"
						+ "CONSIGNEEID,DETAILADDRESS,TEL,PNUMBER" +
						" FROM ADDRESS AD,JUSER JU "
						+ "WHERE AD.JID=JU.JID AND JU.JID=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,jid);
			rs  = pstmt.executeQuery();
			List<Address> addresses= new ArrayList<Address>();
			while(rs.next()){
			   int aid = rs.getInt("aid");
			   String jname=rs.getString("jname");
			   String jpwd=rs.getString("jpwd");
			   String jemail=rs.getString("jemail");
			   String jtel=rs.getString("jtel");
			   int jgender=rs.getInt("jgender");
			   String jbir=rs.getString("jbir");
			   int isval=rs.getInt("juserisval");
			   String jpic=rs.getString("jpic");
			   String address1 = rs.getString("address");
			   String consigneename = rs.getString("consigneename");
			   String consigneeid = rs.getString("consigneeid");
			   String detailaddress = rs.getString("detailaddress");
			   String tel = rs.getString("tel");
			   String pnumber = rs.getString("pnumber");
			   Juser juser=new Juser(jid,jname,jpwd,jemail,jtel,jgender,jbir,isval,jpic);
			   Address address = new Address(aid,juser,address1,consigneename,
					   consigneeid,detailaddress,tel,pnumber);
			   addresses.add(address);
			}
			return addresses;
			
		} catch (SQLException e) {
		   //��DAO�㷢�����쳣 ����  ���ݿ�  ȫ����װ��һ���쳣   ��Ϊ��Щ�쳣�û��޷����� 
		    //�����û�����֪��.
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
	 * ���ݵ�ַidɾ����ַ
	 * @param aid ��ַid
	 * @return
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣
	 * 
	 **/
	@Override
	public void addAddress(Address address) throws DAOException {
		String sql="INSERT INTO ADDRESS VALUES(AD_SEQ.NEXTVAL,?,?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,address.getJuser().getJid());
			pstmt.setString(2,address.getAddress());
			pstmt.setString(3,address.getConsigneename());
			pstmt.setString(4,address.getConsigneeid());
			pstmt.setString(5,address.getDetailaddress());
			pstmt.setString(6,address.getTel());
			pstmt.setString(7,address.getPnumber());
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
	 * ���ݵ�ַidɾ����ַ
	 * @param aid ��ַid
	 * @return
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣
	 * 
	 **/
	@Override
	public void deleteAddressByJid(int aid)throws DAOException{
		String sql="DELETE FROM ADDRESS WHERE AID=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,aid);
			pstmt.execute();	
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
	 * �����޸��ջ���ַ��Ϣ
	 * @param address Address����
	 * @return
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣
	 * 
	 **/
	@Override
	public void updateAddressByJid(Address address)throws DAOException{
		String sql="UPDATE ADDRESS SET ADDRESS=?,CONSIGNEENAME=?,"
			+ "CONSIGNEEID=?,DETAILADDRESS=?,TEL=?,PNUMBER=?" +
			" WHERE AID=?  ";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, address.getAddress());
			pstmt.setString(2, address.getConsigneename());
			pstmt.setString(3, address.getConsigneeid());
			pstmt.setString(4, address.getDetailaddress());
			pstmt.setString(5, address.getTel());
			pstmt.setString(6, address.getPnumber());
			pstmt.setInt(7, address.getAid());
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
	

}
