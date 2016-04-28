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

	//增加图片
	public void insertPic(Pic pic) throws DAOException {
		//调用DButils工具包，加载驱动，获取连接
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

	//删除所有图片
	public void deleteAllPic() throws DAOException {
		//调用DButils工具包，加载驱动，获取连接
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
	
	//根据图片id删除图片
	public void deletePicByPicid(int picid) throws DAOException {
		//调用DButils工具包，加载驱动，获取连接
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

	//删除所有某一名字的图片
	public void deleteAllPicByName(String picname) throws DAOException {
		//调用DButils工具包，加载驱动，获取连接
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

	//删除某商品所有图片
	public void deleteGoodsAllPic(Goods goods) throws DAOException {
		//调用DButils工具包，加载驱动，获取连接
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

	//删除某商品所有小型图片
	public void deleteGoodsAllSmaPic(Goods goods) throws DAOException {
		//调用DButils工具包，加载驱动，获取连接
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

	//删除某商品所有中型图片
	public void deleteGoodsAllMidPic(Goods goods) throws DAOException {
		//调用DButils工具包，加载驱动，获取连接
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

	//删除某商品所有中偏图片
	public void deleteGoodsAllMibPic(Goods goods) throws DAOException {
		//调用DButils工具包，加载驱动，获取连接
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

	//删除某商品所有大型图片
	public void deleteGoodsAllBigPic(Goods goods) throws DAOException {
		//调用DButils工具包，加载驱动，获取连接
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

	//更新图片信息(图片名，库存编号，图片类型)
	public void updatePic(Pic pic) throws DAOException {
		//调用DButils工具包，加载驱动，获取连接
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

	//查询所有图片信息
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

	//根据图片编号查询图片信息
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

	//根据商品图片名查询图片信息
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

	//根据商品库存编号查询所有图片
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

	//根据商品库存编号查询所有小型图片
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

	//根据商品库存编号查询所有中型图片
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

	//根据商品库存编号查询所有中偏图片
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

	//根据商品库存编号查询所有大型图片
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
