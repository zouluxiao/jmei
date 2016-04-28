package com.jmei.service;

import java.util.List;

import com.jmei.bean.Goods;
import com.jmei.bean.GoodsToEffect;
import com.jmei.bean.GoodsToType;
import com.jmei.exception.DAOException;
import com.jmei.exception.NoSuchGoodsException;

public interface GoodsServices {
	/**
	 * 添加商品
	 * @param goods 添加商品的
	 * @throws DAOException 数据库异常
	 * @throws NoSuchGoodsException 这个商品不存在
	 */
	public void addGoods(Goods goods)
			throws DAOException,NoSuchGoodsException;
	
	/**
	 * 通过商品编号删除商品
	 * @param gid 商品编号
	 * @throws DAOException 数据库异常
	 * @throws NoSuchGoodsException 没有这样的商品
	 */
	public void deleteGoods(int gid)
			throws DAOException,NoSuchGoodsException;
	
	/**
	 * 更新商品
	 * @param goods 更新商品的封装类
	 * @throws DAOException 数据库异常
	 */
	public void updateGoods(Goods goods)
			throws DAOException,NoSuchGoodsException;
	
	/**
	 * 查询商品
	 * @param name 商品的名称
	 * @return 商品的对象集合
	 * @throws DAOException 数据库异常
	 * @throws NoSuchGoodsException 没有找到商品
	 */
	public List<Goods> searchGoodsByName(String name)
			throws DAOException,NoSuchGoodsException;
	
	/**
	 * 通过企业编号查询商品
	 * @param bid 企业编号
	 * @return 商品对象的集合
	 * @throws DAOException 数据库异常
	 * @throws NoSuchGoodsException 没有找到商品
	 */
	public List<Goods> searchGoodsByBid(int bid)
			throws DAOException,NoSuchGoodsException;
	
	/**
	 * 通过企业名称查询商品
	 * @param bname 企业名称
	 * @return 商品对象的集合
	 * @throws DAOException 数据库异常
	 * @throws NoSuchGoodsException 没有找到商品
	 */
	public List<Goods> searchGoodsByBname(String bname)
			throws DAOException,NoSuchGoodsException;
	
	/**
	 * 通过商品编号查询商品
	 * @param pid 商品编号
	 * @return 商品的对象集合
	 * @throws DAOException 数据库异常
	 * @throws NoSuchGoodsException 没有找到商品
	 */
	public List<Goods> searchGoodsByPid(int pid)
			throws DAOException,NoSuchGoodsException;
	
	/**
	 * 通过商品类型查询商品
	 * @param type 商品类型的数组（存放多个类型）
	 * @param list 带筛选的集合
	 * @return 商品类型的对象集合
	 * @throws DAOException 数据库异常
	 * @throws NoSuchGoodsException 没有找到商品
	 */
	public List<GoodsToType> searchGoodsByType(String[] type,List list)
			throws DAOException,NoSuchGoodsException;
	/**
	 * 通过商品的功效查询商品
	 * @param effect 商品的功效数组（存放多个商品的功效）
	 * @param list 带筛选的集合
	 * @return 商品的功效对象集合
	 * @throws DAOException 数据库异常
	 * @throws NoSuchGoodsException 没有找到商品
	 */
	public List<GoodsToEffect> searchGoodsByEffect(String[] effect,List list)
			throws DAOException,NoSuchGoodsException;
	
	/**
	 * 通过商品的编号查询商品的功效
	 * @param gid 商品的编号
	 * @return 返回商品的功效对象集合
	 * @throws DAOException 数据库异常
	 * @throws NoSuchGoodsException 没有找到商品
	 */
	public List<GoodsToEffect> searchGoodsToEffectByGid(int gid)
			throws DAOException,NoSuchGoodsException;
	
	/**
	 * 通过商品的编号查询商品的类型
	 * @param gid 商品的编号
	 * @return 返回商品的类型对象集合
	 * @throws DAOException 数据库异常
	 * @throws NoSuchGoodsException 没有找到商品
	 */
	public List<GoodsToType> searchGoodsToTypeByGid(int gid)
			throws DAOException,NoSuchGoodsException;
	
	/**
	 * 通过数量查询商品
	 * @param num 商品的数量
	 * @return 返回商品对象集合
	 * @throws DAOException 数据库异常
	 * @throws NoSuchGoodsException 没有找到商品
	 */
	public List<Goods> searchGoodsByNumber(int num)
			throws DAOException,NoSuchGoodsException;
	
	/**
	 * 按商品销量降序排序
	 * @param list 商品的集合
	 * @return 返回排序后的的商品集合
	 * @throws DAOException 数据库异常
	 * @throws NoSuchGoodsException 没有找到商品
	 */
	public List<Goods> orderBySaleVol(List list)
			throws DAOException,NoSuchGoodsException;
	/**
	 * 按上架时间排序降序
	 * @param list 商品集合对象
	 * @return 返回商品的排序后的集合
	 * @throws DAOException 数据库异常
	 * @throws NoSuchGoodsException 没有找到商品
	 */
	public List<Goods> orderByUptime(List list)
			throws DAOException,NoSuchGoodsException;
	/**
	 * 按价格降序排序
	 * @param list 商品的集合
	 * @return 返回商品排序后的集合
	 * @throws DAOException 数据库异常
	 * @throws NoSuchGoodsException 没有找到商品
	 */
	public List<Goods> orderByPriDesc(List list)
			throws DAOException,NoSuchGoodsException;
	/**
	 * 按价格升序排序
	 * @param list 商品的集合
	 * @return 返回商品排序后的集合
	 * @throws DAOException 数据库异常
	 * @throws NoSuchGoodsException 没有找到商品
	 */
	public List<Goods> orderByPriAsc(List list)
			throws DAOException,NoSuchGoodsException;
	
	/**
	 * 按商品价格段查询商品
	 * @param list 商品的集合
	 * @param low 价格下限
	 * @param high 价格上限
	 * @return 返回商品排序后的集合
	 * @throws DAOException 数据库异常
	 * @throws NoSuchGoodsException 没有找到商品 
	 */
	public List<Goods> searchByPriArea(List list,int low,int high)
			throws DAOException,NoSuchGoodsException;
	
	/**
	 * 通过商品的名称查询商品
	 * @param pname 商品的名称
	 * @return 返回商品的对象集合
	 * @throws DAOException 数据库异常
	 * @throws NoSuchGoodsException 没有找到商品
	 */
	public List<Goods> searchGoodsByPname(String pname)
			throws DAOException,NoSuchGoodsException;
	
	/**
	 * 通过gid找出商品，更新商品的详细名称
	 * @param gid 商品的编号
	 * @param Detail 更新后的商品的详细名称
	 * @throws DAOException DAO层获取数据发生异常
	 * @throws NoSuchGoodsException 没有找到商品
	 */
	public List<Goods> searchGoodsByDetail(String detail)
			throws DAOException,NoSuchGoodsException;
	
	/**
	 * 增加商品的销量（+1）
	 * @param gid 库存编号
	 * @throws DAOException DAO层获取数据发生异常
	 */
	public void addSaleVol(int gid)
			throws DAOException,NoSuchGoodsException;
	
	/**
	 * 增加商品的收藏（+1）
	 * @param gid 库存编号
	 * @throws DAOException DAO层获取数据发生异常
	 */
	public void addColVol(int gid)
			throws DAOException,NoSuchGoodsException;
	
	/**
	 * 查询商品通过商品编号
	 * @param gid 库存编号
	 * @return 商品对象
	 * @throws DAOException DAO层获取数据发生异常
	 */
	public Goods searchGoodsByGid(int gid)
			throws DAOException,NoSuchGoodsException;
	
	/**
	 * 按商品编号查找商品对应的功效
	 * @param gid 商品编号
	 * @return 商品对应功效的集合对象
	 * @throws DAOException DAO层获取数据发生异常
	 *//*
	public List<GoodsToEffect> searchGoodsToEffectBygid(int gid) 
			throws DAOException,NoSuchGoodsException;
	
	*//**
	 * 按商品的编号查询商品对应的类型
	 * @param gid 商品的编号
	 * @return 商品对应类型的集合对象
	 * @throws DAOException DAO层获取数据发生异常
	 *//*
	public List<GoodsToType> searchGoodsToTypeBygid(int gid) 
			throws DAOException,NoSuchGoodsException;*/
}
