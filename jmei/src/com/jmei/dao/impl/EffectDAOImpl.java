package com.jmei.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import com.jmei.bean.Effect;
import com.jmei.dao.EffectDAO;
import com.jmei.exception.DAOException;
import com.jmei.utils.DBUtils;
/**
 * 商品表ProductDAO的实现类
 * @since 2016-4-24
 * @author 阳桂东
 * **/
public class EffectDAOImpl implements EffectDAO {

	//增加功效
	public void insertEffect(Effect effect) throws DAOException {
		//调用DBUtils工具包,加载驱动，获取连接
		String sql = "insert into effect (eid,ename)"+
		" values(ef_seq.nextVal,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,effect.getEname());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		} finally {
			try {
				DBUtils.close(conn, pstmt);
			} catch (SQLException e) {
				throw new DAOException(e.getMessage());
			}
		}
	}

	//删除功效
	public void deleteEffect(int eid) throws DAOException {
		//调用DBUtils工具包,加载驱动，获取连接
		String sql = "delete from effect"+
		" where eid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,eid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		} finally {
			try {
				DBUtils.getConnection();
			} catch (SQLException e) {
				throw new DAOException(e.getMessage());
			}
		}
	}

	//更改功效
	public void updateEffect(Effect effect) throws DAOException {
		//调用DBUtils工具包,加载驱动，获取连接
		String sql = "update  effect set ename=?"+
		"where eid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,effect.getEname());
			pstmt.setInt(2,effect.getEid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		} finally {
			try {
				DBUtils.close(conn, pstmt);
			} catch (SQLException e) {
				throw new DAOException(e.getMessage());
			}
		}
	}

	//查询所所有功效
	public List<Effect> queryAllEffect() throws DAOException {
		//调用DBUtils工具包,加载驱动，获取连接
		String sql = "select eid,ename from effect";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<Effect> effects = new ArrayList<Effect>();
			while(rs.next()){
				int eid = rs.getInt("eid");
				String ename = rs.getString("ename");
				Effect e = new Effect(eid,ename);
				effects.add(e);
			}
			return effects;
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		} finally {
			try {
				DBUtils.close(conn, pstmt);
			} catch (SQLException e) {
				throw new DAOException(e.getMessage());
			}
		}
	}

	//通过功效id查找功效信息
	public Effect queryById(int eid) throws DAOException {
		//调用DBUtils工具包，加载驱动，获取链接
		String sql = "select ename from effect"+
		" where eid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, eid);
			rs = pstmt.executeQuery();
			if(rs.next()){
				String ename = rs.getString("ename");
				Effect e = new Effect(eid,ename);
				return e;
			}
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		} finally {
			try {
				DBUtils.close(conn, pstmt);
			} catch (SQLException e) {
				throw new DAOException(e.getMessage());
			}
		}
		return null;
	}

}
