package com.jmei.dao;

import java.util.List;

import com.jmei.bean.Goods;
import com.jmei.exception.DAOException;

/**
 * @author 汤亮
 * @since 2016-04-23
 * 该接口实现对商品表的DAO
 */
public interface GoodsDAO {
	//查询商品通过商品编号
	/**
	 * 通过商品的编号查询商品
	 * @param pid 商品的编号
	 * @return List<Goods> 返回商品的对象集合
	 * @throws DAOException DAO层获取数据发现异常
	 */
	public List<Goods> queryGoodsByPid(int pid) throws DAOException; 
	//查询商品通过商品名
	/**
	 * 通过商品的名称查询商品
	 * @param pname 商品的名称
	 * @return List<Goods> 返回商品的集合对象
	 * @throws DAOException DAO层获取数据发生异常
	 */
	public List<Goods> queryGoodsByPname(String pname) throws DAOException;
	//查询商品通过企业编号
	/**
	 * 通过企业编号查询该企业所经营的所有商品
	 * @param bid 企业编号
	 * @return List<Goods> 返回商品的集合对象
	 * @throws DAOException DAO层获取数据发生异常
	 */
	public List<Goods> queryGoodsByBid(int bid) throws DAOException;
	//查询商品通过企业名
	/**
	 * 通过企业名称查询该企业所经营的所有商品
	 * @param bname 企业名称
	 * @return List<Goods> 返回商品的集合对象
	 * @throws DAOException DAO层获取数据发生异常
	 */
	public List<Goods> queryGoodsByBname(String bname) throws DAOException;
	//查询商品通过商品类型
	/**
	 * 通过商品的类型查询商品
	 * @param type 商品的类型
	 * @return List<Goods> 返回商品的集合对象
	 * @throws DAOException DAO层获取数据发生异常
	 */
	//public List<Goods> queryGoodsByType(String type) throws DAOException;
	//查询商品通过商品数量
	/**
	 * 通过商品的数量查询商品
	 * @param num 商品的数量
	 * @return List<Goods> 返回商品的集合对象
	 * @throws DAOException DAO层获取数据发生异常
	 */
	public List<Goods> queryGoodsByNumber(int num) throws DAOException;
	//查询商品通过商品销量
	/**
	 * 通过商品的销量查询商品
	 * @param vol 商品的销量
	 * @return List<Goods> 返回商品的集合对象
	 * @throws DAOException DAO层获取数据发生异常
	 */
	public List<Goods> queryGoodsBySaleVol(int vol) throws DAOException;
	//查询商品通过商品的功效
	/**
	 * 通商品的功效查询商品
	 * @param effect 商品的功效
	 * @return List<Goods> 返回商品的集合对象
	 * @throws DAOException DAO层获取数据发生异常
	 */
	//public List<Goods> queryGoodsByEffect(String effect) throws DAOException;
	//查询商品通过商品上架时间
	/**
	 * 通过上架时间查找商品
	 * @param t1  开始时间
	 * @param t2  结束时间
	 * @return List<Goods> 返回商品的集合对象
	 * @throws DAOException DAO层获取数据发生异常
	 */
	public List<Goods> queryGoodsByUpTime(String t1,String t2) throws DAOException;
	//查询所有商品
	/**
	 * 查询所有商品
	 * @return List<Goods> 返回商品的集合对象
	 * @throws DAOException DAO层获取数据发生异常
	 */
	public List<Goods> queryAllGoods() throws DAOException;
	//更新商品详细名称
	/**
	 * 通过gid找出商品，更新商品的详细名称
	 * @param gid 商品的编号
	 * @param Detail 更新后的商品的详细名称
	 * @throws DAOException DAO层获取数据发生异常
	 */
	public void updateGoodsDetail(int gid,String Detail) throws DAOException;
	//通过商品编号删除商品
	/**
	 * 通过商品编号删除商品
	 * @param gid 商品编号
	 * @throws DAOException DAO层获取数据发生异常
	 */
	public void deleteGoods(int gid) throws DAOException;
	//插入商品
	/**
	 * 添加商品
	 * @param goods 添加的商品的对象
	 * @throws DAOException DAO层获取数据发生异常
	 */
	public void insertGoods(Goods goods) throws DAOException; 
	//查询商品通过详细名称模糊查找
	/**
	 * 模糊查询商品的详细名称
	 * @param detail 商品的详细名称
	 * @return List<Goods> 返回商品对象的集合
	 * @throws DAOException DAO层获取数据发生异常
	 */
	public List<Goods> queryGoodsByDetail(String detail) throws DAOException;
	//更新商品的基本
	/**
	 * 更新商品的信息
	 * @param goods 该更新的对象
	 * @throws DAOException DAO层获取数据发生异常
	 */
	public void updateGoods(Goods goods) throws DAOException;
	
	/**
	 * 增加商品的销量（+1）
	 * @param gid 库存编号
	 * @throws DAOException DAO层获取数据发生异常
	 */
	public void addGoodsSaleVol(int gid) throws DAOException;
	/**
	 * 增加商品的收藏（+1）
	 * @param gid 库存编号
	 * @throws DAOException DAO层获取数据发生异常
	 */
	public void addGoodsColVol(int gid) throws DAOException;

	/**
	 * 通过商品的编号查询商品
	 * @param gid 商品的编号
	 * @return Goods 返回商品的对象
	 * @throws DAOException DAO层获取数据发现异常
	 */
	public Goods queryGoodsByGid(int gid) throws DAOException; 
}
