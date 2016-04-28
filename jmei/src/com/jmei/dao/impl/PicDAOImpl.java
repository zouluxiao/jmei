package com.jmei.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jmei.bean.Goods;
import com.jmei.bean.Pic;
import com.jmei.dao.PicDAO;
import com.jmei.exception.DAOException;
import com.jmei.utils.DBUtils;

public class PicDAOImpl implements PicDAO {

	//����ͼƬ
	public void insertPic(Pic pic) throws DAOException {
		//����DButils���߰���������������ȡ����
		String sql = "insert into pic(picid,picname,gid,flag)"+
		" values(pic_seq.nextVal,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pic.getPicpname());
			pstmt.setInt(2, pic.getGid().getGid());
			pstmt.setInt(3, pic.getFlag());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}finally{
			try {
				DBUtils.close(conn, pstmt);
			} catch (SQLException e) {
				throw new DAOException(e.getMessage());
			}
		}
	}

	//ɾ������ͼƬ
	public void deleteAllPic() throws DAOException {
		//����DButils���߰���������������ȡ����
		String sql = "delete from pic";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}finally{
			try {
				DBUtils.close(conn, pstmt);
			} catch (SQLException e) {
				throw new DAOException(e.getMessage());
			}
		}
	}
	
	//����ͼƬidɾ��ͼƬ
	public void deletePicByPicid(int picid) throws DAOException {
		//����DButils���߰���������������ȡ����
		String sql = "delete from pic"+
		" where  picid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, picid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}finally{
			try {
				DBUtils.close(conn, pstmt);
			} catch (SQLException e) {
				throw new DAOException(e.getMessage());
			}
		}
	}

	//ɾ������ĳһ���ֵ�ͼƬ
	public void deleteAllPicByName(String picname) throws DAOException {
		//����DButils���߰���������������ȡ����
		String sql = "delete from pic"+
		" where  picname=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, picname);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}finally{
			try {
				DBUtils.close(conn, pstmt);
			} catch (SQLException e) {
				throw new DAOException(e.getMessage());
			}
		}
	}

	//ɾ��ĳ��Ʒ����ͼƬ
	public void deleteGoodsAllPic(Goods goods) throws DAOException {
		//����DButils���߰���������������ȡ����
		String sql = "delete from pic"+
		" where  gid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, goods.getGid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}finally{
			try {
				DBUtils.close(conn, pstmt);
			} catch (SQLException e) {
				throw new DAOException(e.getMessage());
			}
		}
	}

	//ɾ��ĳ��Ʒ����С��ͼƬ
	public void deleteGoodsAllSmaPic(Goods goods) throws DAOException {
		//����DButils���߰���������������ȡ����
		String sql = "delete from pic"+
		" where gid=? and flag=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, goods.getGid());
			pstmt.setInt(2, 0);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}finally{
			try {
				DBUtils.close(conn, pstmt);
			} catch (SQLException e) {
				throw new DAOException(e.getMessage());
			}
		}
	}

	//ɾ��ĳ��Ʒ��������ͼƬ
	public void deleteGoodsAllMidPic(Goods goods) throws DAOException {
		//����DButils���߰���������������ȡ����
		String sql = "delete from pic"+
		" where gid=? and flag=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, goods.getGid());
			pstmt.setInt(2, 1);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}finally{
			try {
				DBUtils.close(conn, pstmt);
			} catch (SQLException e) {
				throw new DAOException(e.getMessage());
			}
		}
	}

	//ɾ��ĳ��Ʒ������ƫͼƬ
	public void deleteGoodsAllMibPic(Goods goods) throws DAOException {
		//����DButils���߰���������������ȡ����
		String sql = "delete from pic"+
		" where gid=? and flag=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, goods.getGid());
			pstmt.setInt(2, 2);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}finally{
			try {
				DBUtils.close(conn, pstmt);
			} catch (SQLException e) {
				throw new DAOException(e.getMessage());
			}
		}
	}

	//ɾ��ĳ��Ʒ���д���ͼƬ
	public void deleteGoodsAllBigPic(Goods goods) throws DAOException {
		//����DButils���߰���������������ȡ����
		String sql = "delete from pic"+
		" where gid=? and flag=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, goods.getGid());
			pstmt.setInt(2, 3);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}finally{
			try {
				DBUtils.close(conn, pstmt);
			} catch (SQLException e) {
				throw new DAOException(e.getMessage());
			}
		}
	}

	//����ͼƬ��Ϣ(ͼƬ��������ţ�ͼƬ����)
	public void updatePic(Pic pic) throws DAOException {
		//����DButils���߰���������������ȡ����
		String sql = "update pic set picname=?,gid=?,flag=?"+
		" where picid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pic.getPicpname());
			pstmt.setInt(2, pic.getGid().getGid());
			pstmt.setInt(3, pic.getFlag());
			pstmt.setInt(4, pic.getPicid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}finally{
			try {
				DBUtils.close(conn, pstmt);
			} catch (SQLException e) {
				throw new DAOException(e.getMessage());
			}
		}
	}

	//��ѯ����ͼƬ��Ϣ
	public List<Pic> queryAllPic() throws DAOException {
		String sql ="select picid,picname,gid,flag from pic";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs  = pstmt.executeQuery();
			List<Pic> pics = new ArrayList<Pic>();
			while(rs.next()){
				  int picid = rs.getInt("picid");
				  String picname = rs.getString("picname");
				  int flag = rs.getInt("flag");
				  Goods goods = new Goods();
				  goods.setGid(rs.getInt("gid"));
				  Pic p = new Pic(picid,picname,goods,flag);
				  pics.add(p);
			}
			return pics;
		} catch (SQLException e) {
		   throw new DAOException(e.getMessage());
		}finally{
			try {
				DBUtils.close(conn, pstmt, rs);
			} catch (SQLException e) {
				 throw new DAOException(e.getMessage());
			}
		}
	}

	//����ͼƬ��Ų�ѯͼƬ��Ϣ
	public Pic queryPicByPicid(int picid) throws DAOException {
		String sql ="select picid,picname,gid,flag from pic"
		+" where picid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, picid);
			rs  = pstmt.executeQuery();
			if(rs.next()){
				  String picname = rs.getString("picname");
				  int flag = rs.getInt("flag");
				  Goods goods = new Goods();
				  goods.setGid(rs.getInt("gid"));
				  Pic p = new Pic(picid,picname,goods,flag);
				  return p;
			}
		} catch (SQLException e) {
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

	//������ƷͼƬ����ѯͼƬ��Ϣ
	public List<Pic> queryPicByPicname(String picname) throws DAOException {
		String sql ="select picid,picname,gid,flag from pic"
		+" where picname=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, picname);
			rs  = pstmt.executeQuery();
			List<Pic> pics = new ArrayList<Pic>();
			while(rs.next()){
				int picid = rs.getInt("picid");
				int flag = rs.getInt("flag");
				Goods goods = new Goods();
				goods.setGid(rs.getInt("gid"));
				Pic p = new Pic(picid,picname,goods,flag);
				pics.add(p);
			}
			return pics;
		} catch (SQLException e) {
		   throw new DAOException(e.getMessage());
		}finally{
			try {
				DBUtils.close(conn, pstmt, rs);
			} catch (SQLException e) {
				 throw new DAOException(e.getMessage());
			}
		}
	}

	//������Ʒ����Ų�ѯ����ͼƬ
	public List<Pic> queryPicByGid(Goods gid) throws DAOException {
		String sql ="select picid,picname,gid,flag from pic"
		+" where gid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			int goodsId = gid.getGid();
			pstmt.setInt(1, goodsId);
			rs  = pstmt.executeQuery();
			List<Pic> pics = new ArrayList<Pic>();
			while(rs.next()){
				int picid = rs.getInt("picid");
				String picname = rs.getString("picname");
				int flag = rs.getInt("flag");
				Pic p = new Pic(picid,picname,gid,flag);
				pics.add(p);
			}
			return pics;
		} catch (SQLException e) {
		   throw new DAOException(e.getMessage());
		}finally{
			try {
				DBUtils.close(conn, pstmt, rs);
			} catch (SQLException e) {
				 throw new DAOException(e.getMessage());
			}
		}
	}

	//������Ʒ����Ų�ѯ����С��ͼƬ
	public List<Pic> queryAllSmaPicByGid(Goods gid) throws DAOException {
		String sql ="select picid,picname,gid,flag from pic"
		+" where gid=? and flag=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			int goodsId = gid.getGid();
			pstmt.setInt(1, goodsId);
			pstmt.setInt(2, 0);
			rs  = pstmt.executeQuery();
			List<Pic> pics = new ArrayList<Pic>();
			while(rs.next()){
				int picid = rs.getInt("picid");
				String picname = rs.getString("picname");
				int flag = rs.getInt("flag");
				Pic p = new Pic(picid,picname,gid,flag);
				pics.add(p);
			}
			return pics;
		} catch (SQLException e) {
		   throw new DAOException(e.getMessage());
		}finally{
			try {
				DBUtils.close(conn, pstmt, rs);
			} catch (SQLException e) {
				 throw new DAOException(e.getMessage());
			}
		}
	}

	//������Ʒ����Ų�ѯ��������ͼƬ
	public List<Pic> queryAllMidPicByGid(Goods gid) throws DAOException {
		String sql ="select picid,picname,gid,flag from pic"
		+" where gid=? and flag=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			int goodsId = gid.getGid();
			pstmt.setInt(1, goodsId);
			pstmt.setInt(2, 1);
			rs  = pstmt.executeQuery();
			List<Pic> pics = new ArrayList<Pic>();
			while(rs.next()){
				int picid = rs.getInt("picid");
				String picname = rs.getString("picname");
				int flag = rs.getInt("flag");
				Pic p = new Pic(picid,picname,gid,flag);
				pics.add(p);
			}
			return pics;
		} catch (SQLException e) {
		   throw new DAOException(e.getMessage());
		}finally{
			try {
				DBUtils.close(conn, pstmt, rs);
			} catch (SQLException e) {
				 throw new DAOException(e.getMessage());
			}
		}
	}

	//������Ʒ����Ų�ѯ������ƫͼƬ
	public List<Pic> queryAllMibPicByGid(Goods gid) throws DAOException {
		String sql ="select picid,picname,gid,flag from pic"
		+" where gid=? and flag=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			int goodsId = gid.getGid();
			pstmt.setInt(1, goodsId);
			pstmt.setInt(2, 2);
			rs  = pstmt.executeQuery();
			List<Pic> pics = new ArrayList<Pic>();
			while(rs.next()){
				int picid = rs.getInt("picid");
				String picname = rs.getString("picname");
				int flag = rs.getInt("flag");
				Pic p = new Pic(picid,picname,gid,flag);
				pics.add(p);
			}
			return pics;
		} catch (SQLException e) {
		   throw new DAOException(e.getMessage());
		}finally{
			try {
				DBUtils.close(conn, pstmt, rs);
			} catch (SQLException e) {
				 throw new DAOException(e.getMessage());
			}
		}
	}

	//������Ʒ����Ų�ѯ���д���ͼƬ
	public List<Pic> queryAllBigPicByGid(Goods gid) throws DAOException {
		String sql ="select picid,picname,gid,flag from pic"
		+" where gid=? and flag=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			int goodsId = gid.getGid();
			pstmt.setInt(1, goodsId);
			pstmt.setInt(2, 3);
			rs  = pstmt.executeQuery();
			List<Pic> pics = new ArrayList<Pic>();
			while(rs.next()){
				int picid = rs.getInt("picid");
				String picname = rs.getString("picname");
				int flag = rs.getInt("flag");
				Pic p = new Pic(picid,picname,gid,flag);
				pics.add(p);
			}
			return pics;
		} catch (SQLException e) {
		   throw new DAOException(e.getMessage());
		}finally{
			try {
				DBUtils.close(conn, pstmt, rs);
			} catch (SQLException e) {
				 throw new DAOException(e.getMessage());
			}
		}
	}

}
