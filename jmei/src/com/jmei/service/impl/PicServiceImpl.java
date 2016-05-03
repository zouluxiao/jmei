package com.jmei.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.jmei.bean.Goods;
import com.jmei.bean.Pic;
import com.jmei.dao.PicDAO;
import com.jmei.exception.DAOException;
import com.jmei.exception.PicExistException;
import com.jmei.exception.PicNotExistException;
import com.jmei.factory.DAOFactory;
import com.jmei.service.PicService;

public class PicServiceImpl implements PicService {
	private  final String  KEY ="PicDAOImpl";

	//增加图片
	public void addPic(Pic pic) throws DAOException, PicExistException {
		//1.获取DAO
		PicDAO dao = (PicDAO)DAOFactory.newInstance(KEY);
		//2.根据id查询图片
		Pic p = dao.queryPicByPicid(pic.getPicid());
		//3.判断p是否存在 如果存在产生异常
		if(p !=null)
			throw new PicExistException("图片已存在");
		//4.插入图片信息
		dao.insertPic(pic);
	}

	//删除所有图片
	public void removeAllPic() throws DAOException, PicNotExistException {
		//1.获取DAO
		PicDAO dao = (PicDAO)DAOFactory.newInstance(KEY);
		//2.查询图片
		List<Pic> p = dao.queryAllPic();
		//3.判断p是否存在 如果不存在产生异常
		if(p == null)
			throw new PicNotExistException("图片不存在");
		//4.删除图片信息
		dao.deleteAllPic();
	}

	//根据id删除图片
	public void removePicByPicid(int picid) throws DAOException,
			PicNotExistException {
		//1.获取DAO
		PicDAO dao = (PicDAO)DAOFactory.newInstance(KEY);
		//2.查询图片
		Pic p = dao.queryPicByPicid(picid);
		//3.判断p是否存在 如果不存在产生异常
		if(p == null)
			throw new PicNotExistException("图片不存在");
		//4.删除图片信息
		dao.deletePicByPicid(picid);
	}

	//根据图片名删除图片
	public void removeAllPicByName(String picname) throws DAOException,
			PicNotExistException {
		//1.获取DAO
		PicDAO dao = (PicDAO)DAOFactory.newInstance(KEY);
		//2.查询图片
		List<Pic> p = dao.queryPicByPicname(picname);
		//3.判断p是否存在 如果不存在产生异常
		if(p == null)
			throw new PicNotExistException("图片不存在");
		//4.删除图片信息
		dao.deleteAllPicByName(picname);
	}

	//根据库存编号删除图片
	public void removeGoodsAllPic(Goods goods) throws DAOException,
			PicNotExistException {
		//1.获取DAO
		PicDAO dao = (PicDAO)DAOFactory.newInstance(KEY);
		//2.查询图片
		List<Pic> p = dao.queryPicByGid(goods);
		//3.判断p是否存在 如果不存在产生异常
		if(p == null)
			throw new PicNotExistException("图片不存在");
		//4.删除图片信息
		dao.deleteGoodsAllPic(goods);
	}

	//根据库存编号删除所有小图片
	public void removeGoodsAllSmaPic(Goods goods) throws DAOException,
			PicNotExistException {
		//1.获取DAO
		PicDAO dao = (PicDAO)DAOFactory.newInstance(KEY);
		//2.查询图片
		List<Pic> p = dao.queryAllSmaPicByGid(goods);
		//3.判断p是否存在 如果不存在产生异常
		if(p == null)
			throw new PicNotExistException("图片不存在");
		//4.删除图片信息
		dao.deleteGoodsAllSmaPic(goods);
	}

	//根据库存编号删除所有中型图片
	public void removeGoodsAllMidPic(Goods goods) throws DAOException,
			PicNotExistException {
		//1.获取DAO
		PicDAO dao = (PicDAO)DAOFactory.newInstance(KEY);
		//2.查询图片
		List<Pic> p = dao.queryAllMidPicByGid(goods);
		//3.判断p是否存在 如果不存在产生异常
		if(p == null)
			throw new PicNotExistException("图片不存在");
		//4.删除图片信息
		dao.deleteGoodsAllMidPic(goods);
	}

	//根据库存编号删除所有中偏图片
	public void removeGoodsAllMibPic(Goods goods) throws DAOException,
			PicNotExistException {
		//1.获取DAO
		PicDAO dao = (PicDAO)DAOFactory.newInstance(KEY);
		//2.查询图片
		List<Pic> p = dao.queryAllMibPicByGid(goods);
		//3.判断p是否存在 如果不存在产生异常
		if(p == null)
			throw new PicNotExistException("图片不存在");
		//4.删除图片信息
		dao.deleteGoodsAllMibPic(goods);
	}

	//根据库存编号删除所有大型图片
	public void removeGoodsAllBigPic(Goods goods) throws DAOException,
			PicNotExistException {
		//1.获取DAO
		PicDAO dao = (PicDAO)DAOFactory.newInstance(KEY);
		//2.查询图片
		List<Pic> p = dao.queryAllBigPicByGid(goods);
		//3.判断p是否存在 如果不存在产生异常
		if(p == null)
			throw new PicNotExistException("图片不存在");
		//4.删除图片信息
		dao.deleteGoodsAllBigPic(goods);
	}

	//更新图片信息
	public void updatePic(int picid,String picname,Goods gid,int flag) throws DAOException, PicNotExistException {
		//1.获取DAO
		PicDAO dao = (PicDAO)DAOFactory.newInstance(KEY);
		//2.根据id查询图片
		Pic pic = dao.queryPicByPicid(picid);
		//3.判断list是否为空
		if(pic == null)
			throw new PicNotExistException("商品不存在！");
	    //4.更新图片信息
		pic.setPicpname(picname);
		pic.setGid(gid);
		pic.setFlag(flag);
	}

	//查询所有图片
	public List<Pic> searchAllPic() throws DAOException, PicNotExistException {
		//1.获取DAO
		PicDAO dao = (PicDAO)DAOFactory.newInstance(KEY);
		//2.查询图片
		List<Pic> list = dao.queryAllPic();
		//3.判断list是否为空
		if(list.size() == 0)
			throw new PicNotExistException("图片不存在！");
		//4.返回图片信息
	    return list;
	}

	//根据Id查询图片
	public Pic searchPicByPicid(int picid) throws DAOException,
			PicNotExistException {
		//1.获取DAO
		PicDAO dao = (PicDAO)DAOFactory.newInstance(KEY);
		//2.查询图片
		Pic p = dao.queryPicByPicid(picid);
		//3.判断list是否为空
		if(p == null)
			throw new PicNotExistException("图片不存在！");
		//4.返回图片信息
	    return p;
	}

	//根据图片名查询图片
	public List<Pic> searchPicByPicname(String picname) throws DAOException,
			PicNotExistException {
		//1.获取DAO
		PicDAO dao = (PicDAO)DAOFactory.newInstance(KEY);
		//2.查询图片
		List<Pic> list = dao.queryPicByPicname(picname);
		//3.判断list是否为空
		if(list.size() == 0)
			throw new PicNotExistException("图片不存在！");
		//4.返回图片信息
	    return list;
	}

	//根据库存编号查询图片
	public List<Pic> searchPicByGid(Goods gid) throws DAOException,
			PicNotExistException {
		//1.获取DAO
		PicDAO dao = (PicDAO)DAOFactory.newInstance(KEY);
		//2.查询图片
		List<Pic> list = dao.queryPicByGid(gid);
		//3.判断list是否为空
		if(list.size() == 0)
			throw new PicNotExistException("图片不存在！");
		//4.返回图片信息
	    return list;
	}

	//根据库存编号查询小型图片
	public List<Pic> searchAllSmaPicByGid(Goods gid) throws DAOException,
			PicNotExistException {
		//1.获取DAO
		PicDAO dao = (PicDAO)DAOFactory.newInstance(KEY);
		//2.查询图片
		List<Pic> list = dao.queryAllSmaPicByGid(gid);
		//3.判断list是否为空
		if(list.size() == 0)
			throw new PicNotExistException("图片不存在！");
		//4.返回图片信息
	    return list;
	}

	//根据库存编号查询中型图片
	public List<Pic> searchAllMidPicByGid(Goods gid) throws DAOException,
			PicNotExistException {
		//1.获取DAO
		PicDAO dao = (PicDAO)DAOFactory.newInstance(KEY);
		//2.查询图片
		List<Pic> list = dao.queryAllMidPicByGid(gid);
		//3.判断list是否为空
		if(list.size() == 0)
			throw new PicNotExistException("图片不存在！");
		//4.返回图片信息
	    return list;
	}

	//根据库存编号查询中偏图片
	public List<Pic> searchAllMibPicByGid(Goods gid) throws DAOException,
			PicNotExistException {
		//1.获取DAO
		PicDAO dao = (PicDAO)DAOFactory.newInstance(KEY);
		//2.查询图片
		List<Pic> list = dao.queryAllMibPicByGid(gid);
		//3.判断list是否为空
		//if(list.size() == 0)
		//	throw new PicNotExistException("图片不存在！");
		//4.返回图片信息
	    return list;
	}

	//根据库存编号查询大型图片
	public List<Pic> searchAllBigPicByGid(Goods gid) throws DAOException,
			PicNotExistException {
		//1.获取DAO
		PicDAO dao = (PicDAO)DAOFactory.newInstance(KEY);
		//2.查询图片
		List<Pic> list = dao.queryAllMibPicByGid(gid);
		//3.判断list是否为空
	/*	if(list.size() == 0)
			throw new PicNotExistException("图片不存在！");*/
		//4.返回图片信息
	    return list;
	}

	//根据商品库存编号查询小型图片和中型图片
	public List<List<Pic>> searchAllSmaMidPicByGid(Goods gid) throws DAOException,
			PicNotExistException {
		//1.获取DAO
		PicDAO dao = (PicDAO)DAOFactory.newInstance(KEY);
		//2.查询图片
		List<List<Pic>> list = new ArrayList<List<Pic>>();
		List<Pic> list1 = dao.queryAllSmaPicByGid(gid);
		List<Pic> list2 = dao.queryAllMidPicByGid(gid);
		list.add(list1);
		list.add(list2);
		//3.判断list是否为空
		if(list1.size() == 0 || list1.size() == 0)
			throw new PicNotExistException("图片不存在！");
		//4.返回图片信息
	    return list;
	}

	//根据商品库存编号查询小型图片和中偏图片
	public List<List<Pic>> searchAllSmaMibPicByGid(Goods gid) throws DAOException,
			PicNotExistException {
		//1.获取DAO
		PicDAO dao = (PicDAO)DAOFactory.newInstance(KEY);
		//2.查询图片
		List<List<Pic>> list = new ArrayList<List<Pic>>();
		List<Pic> list1 = dao.queryAllSmaPicByGid(gid);
		List<Pic> list2 = dao.queryAllMibPicByGid(gid);
		list.add(list1);
		list.add(list2);
		//3.判断list是否为空
		if(list1.size() == 0 || list1.size() == 0)
			throw new PicNotExistException("图片不存在！");
		//4.返回图片信息
	    return list;
	}

	//根据商品库存编号查询小型图片和大型图片
	public List<List<Pic>> searchAllSmaBigPicByGid(Goods gid) throws DAOException,
			PicNotExistException {
		//1.获取DAO
		PicDAO dao = (PicDAO)DAOFactory.newInstance(KEY);
		//2.查询图片
		List<List<Pic>> list = new ArrayList<List<Pic>>();
		List<Pic> list1 = dao.queryAllSmaPicByGid(gid);
		List<Pic> list2 = dao.queryAllBigPicByGid(gid);
		list.add(list1);
		list.add(list2);
		//3.判断list是否为空
		if(list1.size() == 0 || list1.size() == 0)
			throw new PicNotExistException("图片不存在！");
		//4.返回图片信息
	    return list;
	}

	//根据商品库存编号查询中型图片和中偏图片
	public List<List<Pic>> searchAllMidMibPicByGid(Goods gid) throws DAOException,
			PicNotExistException {
		//1.获取DAO
		PicDAO dao = (PicDAO)DAOFactory.newInstance(KEY);
		//2.查询图片
		List<List<Pic>> list = new ArrayList<List<Pic>>();
		List<Pic> list1 = dao.queryAllMidPicByGid(gid);
		List<Pic> list2 = dao.queryAllMibPicByGid(gid);
		list.add(list1);
		list.add(list2);
		//3.判断list是否为空
		if(list1.size() == 0 || list1.size() == 0)
			throw new PicNotExistException("图片不存在！");
		//4.返回图片信息
	    return list;
	}

	//根据商品库存编号查询中型图片和大型图片
	public List<List<Pic>> searchAllMidBigPicByGid(Goods gid) throws DAOException,
			PicNotExistException {
		//1.获取DAO
		PicDAO dao = (PicDAO)DAOFactory.newInstance(KEY);
		//2.查询图片
		List<List<Pic>> list = new ArrayList<List<Pic>>();
		List<Pic> list1 = dao.queryAllMidPicByGid(gid);
		List<Pic> list2 = dao.queryAllBigPicByGid(gid);
		list.add(list1);
		list.add(list2);
		//3.判断list是否为空
		if(list1.size() == 0 || list1.size() == 0)
			throw new PicNotExistException("图片不存在！");
		//4.返回图片信息
	    return list;
	}

	//根据商品库存编号查询中偏图片和大型图片
	public List<List<Pic>> searchAllMibBigPicByGid(Goods gid) throws DAOException,
			PicNotExistException {
		//1.获取DAO
		PicDAO dao = (PicDAO)DAOFactory.newInstance(KEY);
		//2.查询图片
		List<List<Pic>> list = new ArrayList<List<Pic>>();
		List<Pic> list1 = dao.queryAllMibPicByGid(gid);
		List<Pic> list2 = dao.queryAllBigPicByGid(gid);
		list.add(list1);
		list.add(list2);
		//3.判断list是否为空
		if(list1.size() == 0 || list1.size() == 0)
			throw new PicNotExistException("图片不存在！");
		//4.返回图片信息
	    return list;
	}

}
