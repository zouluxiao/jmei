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
 * ��Ʒ��ProductDAO��ʵ����
 * @since 2016-4-24
 * @author ����
 * **/
public class EffectDAOImpl implements EffectDAO {

	//���ӹ�Ч
	public void insertEffect(Effect effect) throws DAOException {
		//����DBUtils���߰�,������������ȡ����
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

	//ɾ����Ч
	public void deleteEffect(int eid) throws DAOException {
		//����DBUtils���߰�,������������ȡ����
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

	//���Ĺ�Ч
	public void updateEffect(Effect effect) throws DAOException {
		//����DBUtils���߰�,������������ȡ����
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

	//��ѯ�����й�Ч
	public List<Effect> queryAllEffect() throws DAOException {
		//����DBUtils���߰�,������������ȡ����
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

	//ͨ����Чid���ҹ�Ч��Ϣ
	public Effect queryById(int eid) throws DAOException {
		//����DBUtils���߰���������������ȡ����
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
