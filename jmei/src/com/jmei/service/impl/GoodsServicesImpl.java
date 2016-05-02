package com.jmei.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import com.jmei.bean.Goods;
import com.jmei.bean.GoodsToEffect;
import com.jmei.bean.GoodsToType;
import com.jmei.dao.GoodsDAO;
import com.jmei.dao.GoodsToEffectDAO;
import com.jmei.dao.GoodsToTypeDAO;
import com.jmei.dao.impl.GoodsDAOImpl;
import com.jmei.exception.DAOException;
import com.jmei.exception.NoSuchGoodsException;
import com.jmei.factory.DAOFactory;
import com.jmei.factory.ServiceFactory;
import com.jmei.service.GoodsServices;

public class GoodsServicesImpl implements GoodsServices {
	private final static String Goods_KEY = "GoodsDAOImpl";
	private final static String GoodsToEffect_KEY = "GoodsToEffectDAOImpl";
	private final static String GoodsToType_KEY = "GoodsToTypeDAOImpl";

	/**
	 * 添加商品
	 * @param goods 添加商品的
	 * @throws DAOException 数据库异常
	 * @throws NoSuchGoodsException 这个商品不存在
	 */
	public void addGoods(Goods goods) throws DAOException, NoSuchGoodsException {
		//创建DAO对象
		GoodsDAO goodsdao = (GoodsDAO) DAOFactory.newInstance(Goods_KEY);
		if(goods == null){
			throw new NoSuchGoodsException("传入的商品为空");
		}
		goodsdao.insertGoods(goods);
	}

	/**
	 * 通过商品编号删除商品
	 * @param gid 商品编号
	 * @throws DAOException 数据库异常
	 * @throws NoSuchGoodsException 没有这样的商品
	 */
	public void deleteGoods(int gid) throws DAOException, NoSuchGoodsException {
		GoodsDAO goodsdao = (GoodsDAO) DAOFactory.newInstance(Goods_KEY);
		goodsdao.deleteGoods(gid);
	}

	/**
	 * 更新商品
	 * @param goods 更新商品的封装类
	 * @throws DAOException 数据库异常
	 */
	public void updateGoods(Goods goods) throws DAOException, NoSuchGoodsException {
		GoodsDAO goodsdao = (GoodsDAO) DAOFactory.newInstance(Goods_KEY);
		if(goods == null){
			throw new NoSuchGoodsException("传入的值为空");
		}
		goodsdao.updateGoods(goods);
	}

	
	/**
	 * 查询商品
	 * @param name 商品的名称
	 * @return 商品的对象集合
	 * @throws DAOException 数据库异常
	 * @throws NoSuchGoodsException 没有找到商品
	 */
	public List<Goods> searchGoodsByName(String name) throws DAOException,
			NoSuchGoodsException {
		GoodsDAO goodsdao = (GoodsDAO) DAOFactory.newInstance(Goods_KEY);
		List<Goods> list = goodsdao.queryGoodsByPname(name);
		if(list == null || list.size() == 0){
			throw new NoSuchGoodsException("没有找到相应商品");
		}
		return list;
	}

	/**
	 * 通过企业编号查询商品
	 * @param bid 企业编号
	 * @return 商品对象的集合
	 * @throws DAOException 数据库异常
	 * @throws NoSuchGoodsException 没有找到商品
	 */
	public List<Goods> searchGoodsByBid(int bid) throws DAOException,
			NoSuchGoodsException {
		GoodsDAO goodsdao = (GoodsDAO) DAOFactory.newInstance(Goods_KEY);
		List<Goods> list = goodsdao.queryGoodsByBid(bid);
		if(list == null || list.size() == 0){
			throw new NoSuchGoodsException("没有找到相应商品");
		}
		return list;
	}

	/**
	 * 通过企业名称查询商品
	 * @param bname 企业名称
	 * @return 商品对象的集合
	 * @throws DAOException 数据库异常
	 * @throws NoSuchGoodsException 没有找到商品
	 */
	public List<Goods> searchGoodsByBname(String bname) throws DAOException,
			NoSuchGoodsException {
		GoodsDAO goodsdao = (GoodsDAO) DAOFactory.newInstance(Goods_KEY);
		List<Goods> list = goodsdao.queryGoodsByBname(bname);
		if(list == null || list.size() == 0){
			throw new NoSuchGoodsException("没有找到相应商品");
		}
		return list;
	}

	/**
	 * 通过商品编号查询商品
	 * @param pid 商品编号
	 * @return 商品的对象集合
	 * @throws DAOException 数据库异常
	 * @throws NoSuchGoodsException 没有找到商品
	 */
	public List<Goods> searchGoodsByPid(int pid) throws DAOException,
			NoSuchGoodsException {
		GoodsDAO goodsdao = (GoodsDAO) DAOFactory.newInstance(Goods_KEY);
		List<Goods> list = goodsdao.queryGoodsByPid(pid);
		if(list == null || list.size() == 0){
			throw new NoSuchGoodsException("没有找到相应商品");
		}
		return list;
	}

	/**
	 * 通过商品类型查询商品
	 * @param type 商品类型的数组（存放多个类型）
	 * @param list 待筛选的集合
	 * @return 商品类型的对象集合
	 * @throws DAOException 数据库异常
	 * @throws NoSuchGoodsException 没有找到商品
	 */
	public List<Goods> searchGoodsByType(String type,List list)
			throws DAOException, NoSuchGoodsException {
		if(type == null ){
			return list;
		}
		if(list == null){
			throw new NoSuchGoodsException("商品列表已空");
		}
		//定义集合保存筛选出来的Goods类
		ArrayList<Goods> alist = new ArrayList<Goods>();
		//定义service
		GoodsToTypeDAO gtype =  (GoodsToTypeDAO) DAOFactory.newInstance(GoodsToType_KEY);
		//通过Goods集合找出对应的GoodsToType类
		for(int i = 0 ; i < list.size(); i++){
			Goods g = (Goods) list.get(i);
			ArrayList<GoodsToType> tlist = (ArrayList<GoodsToType>) gtype.queryGoodsToTypeBygid(g.getGid());
			for(GoodsToType t: tlist){
				if(type.equals(t.getType().getTname())){
					alist.add(g);
					break;
				}
			}
			
		}
		return alist;
	}

	/**
	 * 通过商品的功效查询商品
	 * @param effect 商品的功效数组（
	 * @param list 带筛选的集合
	 * @return 商品对象集合
	 * @throws DAOException 数据库异常
	 * @throws NoSuchGoodsException 没有找到商品
	 */
	public List<Goods> searchGoodsByEffect(String effect,List list)
			throws DAOException, NoSuchGoodsException {
		if(effect == null){
			return list;
		}
		if(list == null){
			throw new NoSuchGoodsException("商品列表已空");
		}
		//存放筛选后的商品的对象
		ArrayList<Goods> alist = new ArrayList<Goods>();
		//获得与数据库交互的dao对象
		GoodsToEffectDAO dao = (GoodsToEffectDAO) DAOFactory.newInstance(GoodsToEffect_KEY);
		//查找待筛选集合的功效对象
		for(int i=0;i<list.size();i++){
			Goods g = (Goods) list.get(i);
			List<GoodsToEffect> glist = dao.queryGoodsToEffectBygid(g.getGid());
			if(glist != null && glist.size() > 0){
				for(GoodsToEffect ef:glist){
					if(effect.equals(ef.getEffect().getEname())){
						alist.add(g);
					}
				}
			}
		}
		return alist;
	}

	/**
	 * 通过商品的编号查询商品的功效
	 * @param gid 商品的编号
	 * @return 返回商品的功效对象集合
	 * @throws DAOException 数据库异常
	 * @throws NoSuchGoodsException 没有找到商品
	 */
	public List<GoodsToEffect> searchGoodsToEffectByGid(int gid)
			throws DAOException, NoSuchGoodsException {
		GoodsToEffectDAO goodsdao = (GoodsToEffectDAO) DAOFactory.newInstance(GoodsToEffect_KEY);
		ArrayList<GoodsToEffect> list = new ArrayList<GoodsToEffect>();
		list = (ArrayList<GoodsToEffect>) goodsdao.queryGoodsToEffectBygid(gid);
		if(list == null || list.size() == 0){
			throw new NoSuchGoodsException("没有找到商品");
		}
		return list;
	}

	/**
	 * 通过商品的编号查询商品的类型
	 * @param gid 商品的编号
	 * @return 返回商品的类型对象集合
	 * @throws DAOException 数据库异常
	 * @throws NoSuchGoodsException 没有找到商品
	 */
	public List<GoodsToType> searchGoodsToTypeByGid(int gid)
			throws DAOException, NoSuchGoodsException {
		GoodsToTypeDAO goodsdao = (GoodsToTypeDAO) DAOFactory.newInstance(GoodsToType_KEY);
		ArrayList<GoodsToType> list = new ArrayList<GoodsToType>();
		list = (ArrayList<GoodsToType>) goodsdao.queryGoodsToTypeBygid(gid);
		if(list == null || list.size() == 0){
			throw new NoSuchGoodsException("没有找到商品");
		}
		return list;
	}

	/**
	 * 通过数量查询商品
	 * @param num 商品的数量
	 * @return 返回商品对象集合
	 * @throws DAOException 数据库异常
	 * @throws NoSuchGoodsException 没有找到商品
	 */
	public List<Goods> searchGoodsByNumber(int num) throws DAOException,
			NoSuchGoodsException {
		GoodsDAOImpl goodsdao = (GoodsDAOImpl) DAOFactory.newInstance(Goods_KEY);
		ArrayList<Goods> list = new ArrayList<Goods>();
		list = (ArrayList<Goods>) goodsdao.queryGoodsByNumber(num);
		if(list == null || list.size() == 0){
			throw new NoSuchGoodsException("没有找到商品");
		}
		return list;
	}

	/**
	 * 按商品销量降序排序
	 * @param list 商品的集合
	 * @return 返回排序后的的商品集合
	 * @throws DAOException 数据库异常
	 * @throws NoSuchGoodsException 没有找到商品
	 */
	@SuppressWarnings("unchecked")
	public List<Goods> orderBySaleVol(List list) throws DAOException,
			NoSuchGoodsException {
		if(list == null || list.size() == 0){
			return list;
		}
		
		Collections.sort(list,new Comparator<Goods>() {

			public int compare(Goods o1, Goods o2) {
				return o2.getSale_val() - o1.getSale_val();
			}
		});
		
		return list;
	}

	/**
	 * 按上架时间排序降序
	 * @param list 商品集合对象
	 * @return 返回商品的排序后的集合
	 * @throws DAOException 数据库异常
	 * @throws NoSuchGoodsException 没有找到商品
	 */
	@SuppressWarnings("unchecked")
	public List<Goods> orderByUptime(List list) throws DAOException,
			NoSuchGoodsException {
		if(list == null || list.size() == 0){
			return list;
		}
		Collections.sort(list, new Comparator<Goods>() {

			@Override
			public int compare(Goods o1, Goods o2) {
				return o1.getUptime().compareTo(o2.getUptime());
			}
		});
		return list;
			
	}

	/**
	 * 按价格降序排序
	 * @param list 商品的集合
	 * @return 返回商品排序后的集合
	 * @throws DAOException 数据库异常
	 * @throws NoSuchGoodsException 没有找到商品
	 */
	@SuppressWarnings("unchecked")
	public List<Goods> orderByPriDesc(List list) throws DAOException,
			NoSuchGoodsException {
		if(list == null || list.size() == 0){
			return list;
		}
		
		Collections.sort(list,new Comparator<Goods>() {

			public int compare(Goods o1, Goods o2) {
				return (int) (o2.getPrice() - o1.getPrice());
			}
		});
		
		return list;
	}

	/**
	 * 按价格升序排序
	 * @param list 商品的集合
	 * @return 返回商品排序后的集合
	 * @throws DAOException 数据库异常
	 * @throws NoSuchGoodsException 没有找到商品
	 */
	@SuppressWarnings("unchecked")
	public List<Goods> orderByPriAsc(List list) throws DAOException,
			NoSuchGoodsException {
		if(list == null || list.size() == 0){
			return list;
		}
		
		Collections.sort(list,new Comparator<Goods>() {

			public int compare(Goods o1, Goods o2) {
				return (int) (o1.getPrice() - o2.getPrice());
			}
		});
		
		return list;
	}

	/**
	 * 按商品价格段查询商品
	 * @param list 商品的集合
	 * @param low 价格下限
	 * @param high 价格上限
	 * @return 返回商品排序后的集合
	 * @throws DAOException 数据库异常
	 * @throws NoSuchGoodsException 没有找到商品 
	 */
	public List<Goods> searchByPriArea(List list,int low,int high) throws DAOException,
			NoSuchGoodsException {
		if(list == null || list.size() == 0){
			return list;
		}
		Iterator<Goods> it = list.iterator();
		while(it.hasNext()){
			Goods goods = it.next();
			if(goods.getPrice() < low || goods.getPrice() > high){
				it.remove();
			}
		}
		return list;
	}

	/**
	 * 通过商品的名称查询商品
	 * @param pname 商品的名称
	 * @return 返回商品的对象集合
	 * @throws DAOException 数据库异常
	 * @throws NoSuchGoodsException 没有找到商品
	 */
	public List<Goods> searchGoodsByPname(String pname) throws DAOException,
			NoSuchGoodsException {
		if(pname == null){
			throw new NoSuchGoodsException("传入的值为空");
		}
		GoodsDAO dao = (GoodsDAO) DAOFactory.newInstance(Goods_KEY);
		List<Goods> goodslist = dao.queryGoodsByPname(pname);
		if(goodslist == null || goodslist.size() == 0){
			throw new NoSuchGoodsException("没有找到该类商品");
		}
		return goodslist;
	}
	
	/**
	 * 通过gid找出商品，更新商品的详细名称
	 * @param gid 商品的编号
	 * @param Detail 更新后的商品的详细名称
	 * @throws DAOException DAO层获取数据发生异常
	 * @throws NoSuchGoodsException 没有找到商品
	 */
	public List<Goods> searchGoodsByDetail(String detail)
			throws DAOException,NoSuchGoodsException {
		if(detail == null){
			throw new NoSuchGoodsException("没有这个商品");
		}
		GoodsDAO dao = (GoodsDAO) DAOFactory.newInstance(Goods_KEY);
		List<Goods> list = dao.queryGoodsByDetail(detail);
		if(list == null || list.size() == 0){
			throw new NoSuchGoodsException("没有找到您要找的商品");
		}
		return list;
	}

	/**
	 * 增加商品的销量（+1）
	 * @param gid 库存编号
	 * @throws DAOException DAO层获取数据发生异常
	 */
	public void addSaleVol(int gid) throws DAOException, NoSuchGoodsException {
		GoodsDAO dao = (GoodsDAO) DAOFactory.newInstance(Goods_KEY);
		Goods goods = dao.queryGoodsByGid(gid);
		if(goods == null){
			throw new NoSuchGoodsException("没有找到该对象");
		}
		dao.addGoodsSaleVol(gid);
		
	}

	/**
	 * 增加商品的收藏（+1）
	 * @param gid 库存编号
	 * @throws DAOException DAO层获取数据发生异常
	 */
	public void addColVol(int gid) throws DAOException, NoSuchGoodsException {
		GoodsDAO dao = (GoodsDAO) DAOFactory.newInstance(Goods_KEY);
		Goods goods = dao.queryGoodsByGid(gid);
		if(goods == null){
			throw new NoSuchGoodsException("没有找到该对象");
		}
		dao.addGoodsColVol(gid);
		
	}
	
	/**
	 * 查询商品通过商品编号
	 * @param gid 库存编号
	 * @return Goods 商品对象
	 * @throws DAOException DAO层获取数据发生异常
	 */
	public Goods searchGoodsByGid(int gid)
			throws DAOException,NoSuchGoodsException {
		GoodsDAO dao = (GoodsDAO) DAOFactory.newInstance(Goods_KEY);
		Goods goods = dao.queryGoodsByGid(gid);
		if(goods == null){
			throw new NoSuchGoodsException("没有找到该商品");
		}
		return goods;
	}

	/**
	 * 按商品编号查找商品对应的功效
	 * @param gid 商品编号
	 * @return 商品对应功效的集合对象
	 * @throws DAOException DAO层获取数据发生异常
	 *//*
	public List<GoodsToEffect> searchGoodsToEffectBygid(int gid) 
			throws DAOException,NoSuchGoodsException {
		GoodsToEffectDAO dao = (GoodsToEffectDAO) DAOFactory.newInstance(GoodsToEffect_KEY);
		List<GoodsToEffect> glist = dao.queryGoodsToEffectBygid(gid);
		if(glist == null){
			throw new NoSuchGoodsException("没有找到这个功效的商品");
		}
		return glist;
	}
	
	*//**
	 * 按商品的编号查询商品对应的类型
	 * @param gid 商品的编号
	 * @return 商品对应类型的集合对象
	 * @throws DAOException DAO层获取数据发生异常
	 *//*
	public List<GoodsToType> searchGoodsToTypeBygid(int gid) 
			throws DAOException,NoSuchGoodsException {
		GoodsToTypeDAO dao = (GoodsToTypeDAO) DAOFactory.newInstance(GoodsToEffect_KEY);
		List<GoodsToType> glist = dao.queryGoodsToTypeBygid(gid);
		if(glist == null){
			throw new NoSuchGoodsException("没有找到这个类型的商品");
		}
		return glist;
	}*/
}
