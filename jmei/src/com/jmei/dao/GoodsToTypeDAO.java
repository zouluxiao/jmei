package com.jmei.dao;

import java.util.List;

import com.jmei.bean.Goods;
import com.jmei.bean.GoodsToType;
import com.jmei.exception.DAOException;

/**
 * @author 汤亮
 * @since 2016-04-23
 * GoodsToType表的增删改查
 *
 */
public interface GoodsToTypeDAO {
	//增加类型
	/**
	 * 增加商品的类型
	 * @param gid 商品的编号
	 * @param tid 类型的编号
	 * @throws DAOException DAO层获取数据发生异常
	 */
	public void addGoodsToType(int gid,int tid) throws DAOException;
	//修改类型
	/**
	 * 更新商品的类型
	 * @param gid 商品的编号
	 * @param tid 类型的编号
	 * @param newtid 修改后的编号
	 * @throws DAOException DAO层获取数据发生异常
	 */
	public void updateGoodsToType(int gid,int tid,int newtid) throws DAOException;
	//删除类型
	/**
	 * 删除商品的功效
	 * @param gid 商品的编号
	 * @param tid 类型的编号
	 * @throws DAOException DAO层获取数据发生异常
	 */
	public void deleteGoodsToType(int gid,int tid) throws DAOException;
	//查找类型
	/**
	 * 按商品的编号查询商品对应的类型
	 * @param gid 商品的编号
	 * @return 商品对应类型的集合对象
	 * @throws DAOException DAO层获取数据发生异常
	 */
	public List<GoodsToType> queryGoodsToTypeBygid(int gid) throws DAOException;
	/**
	 * 按类型的编号查询商品对应的功效
	 * @param tid 类型的编号
	 * @return 商品对应类型的集合对象
	 * @throws DAOException DAO层获取数据发生异常
	 */
	public List<GoodsToType> queryGoodsToTypeBytid(int tid) throws DAOException;
	
	//查询商品通过商品类型
	/**
	 * 通过商品的类型查询商品
	 * @param type 商品的类型
	 * @return List<Goods> 返回商品的集合对象
	 * @throws DAOException DAO层获取数据发生异常
	 */
	public List<GoodsToType> queryGoodsByType(String type) throws DAOException;
		
}
