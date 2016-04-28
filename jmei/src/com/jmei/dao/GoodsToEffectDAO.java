package com.jmei.dao;

import java.util.List;

import com.jmei.bean.Goods;
import com.jmei.bean.GoodsToEffect;
import com.jmei.exception.DAOException;

/**
 * @author 汤亮
 * @since 2016-04-23
 * 实现对GoodsToEffect表的增删改查操作
 */
public interface GoodsToEffectDAO {
	//增加类型
	/**
	 * 增加商品的功效
	 * @param gid 商品的编号
	 * @param eid 功效的编号
	 * @throws DAOException DAO层获取数据发生异常
	 */
	public void addGoodsToEffect(int gid,int eid) throws DAOException;
	//修改类型
	/**
	 * 修改商品的功效
	 * @param gid 商品的编号
	 * @param eid 功效的编号
	 * @param neweid 修改后的编号
	 * @throws DAOException DAO层获取数据发生异常
	 */
	public void updateGoodsToEffect(int gid,int eid,int neweid) throws DAOException;
	//删除类型
	/**
	 * 删除商品的功效
	 * @param gid 商品的编号
	 * @param eid 功效的编号
	 * @throws DAOException DAO层获取数据发生异常
	 */
	public void deleteGoodsToEffect(int gid,int eid) throws DAOException;
	//查找类型
	/**
	 * 按商品编号查找商品对应的功效
	 * @param gid 商品编号
	 * @return 商品对应功效的集合对象
	 * @throws DAOException DAO层获取数据发生异常
	 */
	public List<GoodsToEffect> queryGoodsToEffectBygid(int gid) throws DAOException;
	/**
	 * 按功效的编号查询商品对应的功效
	 * @param eid 功效的编号
	 * @return 商品对应功效的集合对象
	 * @throws DAOException DAO层获取数据发生异常
	 */
	public List<GoodsToEffect> queryGoodsToEffectByeid(int eid) throws DAOException;
	
	//查询商品通过商品的功效
	/**
	 * 通商品的功效查询商品
	 * @param effect 商品的功效
	 * @return List<Goods> 返回商品的集合对象
	 * @throws DAOException DAO层获取数据发生异常
	 */
	public List<GoodsToEffect> queryGoodsByEffect(String effect) throws DAOException;
		
}
