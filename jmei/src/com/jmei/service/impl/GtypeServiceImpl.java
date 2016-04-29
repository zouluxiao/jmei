package com.jmei.service.impl;

import java.util.List;
import com.jmei.bean.Gtype;
import com.jmei.dao.GtypeDAO;
import com.jmei.exception.DAOException;
import com.jmei.exception.GtypeExistException;
import com.jmei.exception.GtypeNotExistException;
import com.jmei.factory.DAOFactory;
import com.jmei.service.GtypeService;
/**
 * @author 钟进
 * @date 2016-04-27
 **/
public class GtypeServiceImpl implements GtypeService {
	private  final String  KEY ="GtypeDAOImpl";
	public List<Gtype> searchGtypes() throws DAOException, GtypeNotExistException {
		        //1.获取DAO
	           	GtypeDAO dao = (GtypeDAO)DAOFactory.newInstance(KEY);
				//2.查询所有商品
				List<Gtype> list = dao.queryByAll();
				//3.判断list是否为空
				if(list.size() == 0)
					throw new GtypeNotExistException("商品不存在！");
				//4.返回商品信息
			    return list;
			}
	public Gtype searchGtypeByTid(int tid) throws DAOException,
			GtypeNotExistException {
		//1.获取DAO
		GtypeDAO dao = (GtypeDAO)DAOFactory.newInstance(KEY);
		//2.查询所有商品
		Gtype g = dao.queryByTid(tid);
		//3.判断商品是否为空
		if(g == null)
			throw new GtypeNotExistException("商品不存在！");
		//4.返回商品信息
	    return g;
	}
	public Gtype searchGtypeByTname(String tname) throws DAOException,
			GtypeNotExistException {
		//1.获取DAO
				GtypeDAO dao = (GtypeDAO)DAOFactory.newInstance(KEY);
				//2.查询所有商品
				Gtype g = dao.queryByTname(tname);
				//3.判断商品是否为空
				if(g == null)
					throw new GtypeNotExistException("商品不存在！");
				//4.返回商品信息
			    return g;
			}
	public void addGtype(Gtype gtype) throws DAOException, GtypeExistException {
		//1.获取DAO
		GtypeDAO dao = (GtypeDAO)DAOFactory.newInstance(KEY);
				//2.根据id查询商品对象
		Gtype g = dao.queryByTid(gtype.getTid());
				//3.判断商品是否存在 如果存在产生异常
				if(g !=null)
					throw new GtypeExistException("商品已存在");
				//4.插入商品
				dao.inserGtype(gtype);
			}
	public void updateByGtypeInfo(int tid, String tname) throws DAOException,
			GtypeNotExistException {
		//1.获取DAO
		GtypeDAO dao = (GtypeDAO)DAOFactory.newInstance(KEY);
				//2.根据产地查询商品
		Gtype g = dao.queryByTid(tid);
				//3.判断商品是否为空
				if(g == null)
					throw new GtypeNotExistException("商品不存在！");
			    //4.更新商品信息
				g.setTname(tname);
	}	
	public void removeGtype(int tid) throws DAOException,
			GtypeNotExistException {
		//1.获取DAO
		GtypeDAO dao = (GtypeDAO)DAOFactory.newInstance(KEY);
				//2.根据id查询商品对象
		Gtype g = dao.queryByTid(tid);
				//3.判断ac是否存在 如果存在产生异常
				if(g ==null)
					throw new GtypeNotExistException("商品不存在");
				//4.插入商品信息
				dao.delete(tid);
			}
		}
