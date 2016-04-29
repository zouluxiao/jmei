package com.jmei.service.impl;

import java.util.List;
import com.jmei.bean.Buser;
import com.jmei.bean.Foreshow;
import com.jmei.dao.ForeshowDAO;
import com.jmei.exception.DAOException;
import com.jmei.exception.ForeshowExistException;
import com.jmei.exception.ForeshowNotExistException;
import com.jmei.factory.DAOFactory;
import com.jmei.service.ForeshowService;
/**
 * @author 钟进
 * @date 2016-04-27
 **/
public class ForeshowServiceImpl implements ForeshowService {
	private  final String  KEY ="ForeshowDAOImpl";
	public List<Foreshow> searchForeshows() throws DAOException,
			ForeshowNotExistException {
		//1.获取DAO
		ForeshowDAO dao = (ForeshowDAO)DAOFactory.newInstance(KEY);
		//2.查询所有商品
		List<Foreshow> list = dao.queryByAll();
		//3.判断list是否为空
		if(list.size() == 0)
			throw new ForeshowNotExistException("商品不存在！");
		//4.返回商品信息
	    return list;
	}
	public Foreshow searchForeshowByForeid(int foreid) throws DAOException,
			ForeshowNotExistException {
		//1.获取DAO
		ForeshowDAO dao = (ForeshowDAO)DAOFactory.newInstance(KEY);
		//2.查询所有商品
		Foreshow f = dao.queryByForeid(foreid);
		//3.判断商品是否为空
		if(f == null)
			throw new ForeshowNotExistException("商品不存在！");
		//4.返回商品信息
	    return f;
	}
	public Foreshow searchForeshowByForepic(String forepic)
			throws DAOException, ForeshowNotExistException {
		//1.获取DAO
				ForeshowDAO dao = (ForeshowDAO)DAOFactory.newInstance(KEY);
				//2.查询所有商品
				Foreshow f = dao.queryByForepic(forepic);
				//3.判断商品是否为空
				if(f == null)
					throw new ForeshowNotExistException("商品不存在！");
				//4.返回商品信息
			    return f;
			}
	public void addForeshow(Foreshow foreshow) throws DAOException,
			ForeshowExistException {
		//1.获取DAO
		ForeshowDAO dao = (ForeshowDAO)DAOFactory.newInstance(KEY);
				//2.根据id查询商品对象
		Foreshow f = dao.queryByForeid(foreshow.getForeid());
				//3.判断商品是否存在 如果存在产生异常
				if(f !=null)
					throw new ForeshowExistException("商品已存在");
				//4.插入商品
				dao.inserForeShow(foreshow);
			}
	public void updateByForeshowInfo(int foreid, String forepic, Buser bid)
			throws DAOException, ForeshowNotExistException {
		//1.获取DAO
		ForeshowDAO dao = (ForeshowDAO)DAOFactory.newInstance(KEY);
				//2.根据产地查询商品
		Foreshow f = dao.queryByForeid(foreid);
				//3.判断商品是否为空
				if(f == null)
					throw new ForeshowNotExistException("商品不存在！");
			    //4.更新商品信息
				f.setForepic(forepic);
		        f.setBuser(bid);
				
			}
	public void updateByForeshowForepic(String forepicPath, int foreid)
			throws DAOException, ForeshowNotExistException {
		        //1.获取DAO
		        ForeshowDAO dao = (ForeshowDAO)DAOFactory.newInstance(KEY);
				//2.根据产地查询商品
		        Foreshow f = dao.queryByForeid(foreid);
				//3.判断是否为空
				if(f == null)
					throw new ForeshowNotExistException("商品不存在！");
			    //4.更新商品信息
				f.setForepic(forepicPath);
				dao.updateForeShow(f);
			}
	public void removeForeshow(int foreid) throws DAOException,
			ForeshowNotExistException {
		        //1.获取DAO
		        ForeshowDAO dao = (ForeshowDAO)DAOFactory.newInstance(KEY);
				//2.根据id查询商品对象
		        Foreshow f = dao.queryByForeid(foreid);
				//3.判断ac是否存在 如果存在产生异常
				if(f ==null)
					throw new ForeshowNotExistException("商品不存在");
				//4.插入商品信息
				dao.delete(foreid);
			}

}
