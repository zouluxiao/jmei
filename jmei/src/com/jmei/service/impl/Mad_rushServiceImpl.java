package com.jmei.service.impl;

import java.util.List;
import com.jmei.bean.Buser;
import com.jmei.bean.Mad_rush;
import com.jmei.dao.Mad_rushDAO;
import com.jmei.exception.DAOException;
import com.jmei.exception.Mad_rushExistException;
import com.jmei.exception.Mad_rushNotExistException;
import com.jmei.factory.DAOFactory;
import com.jmei.service.Mad_rushService;
/**
 * @author 钟进
 * @date 2016-04-27
 **/
public class Mad_rushServiceImpl implements Mad_rushService {
	private  final String  KEY ="Mad_rushDAOImpl";
	public List<Mad_rush> searchMad_rushs() throws DAOException,
			Mad_rushNotExistException {
		//1.获取DAO
		Mad_rushDAO dao = (Mad_rushDAO)DAOFactory.newInstance(KEY);
		//2.查询所有商品
		List<Mad_rush> list = dao.queryByAll();
		//3.判断list是否为空
		if(list.size() == 0)
			throw new Mad_rushNotExistException("商品不存在！");
		//4.返回商品信息
	    return list;
	}
	public Mad_rush searchMad_rushByMadid(int madid) throws DAOException,
			Mad_rushNotExistException {
		//1.获取DAO
		Mad_rushDAO dao = (Mad_rushDAO)DAOFactory.newInstance(KEY);
		//2.查询所有商品
		Mad_rush m = dao.queryByMadid(madid);
		//3.判断商品是否为空
		if(m == null)
			throw new Mad_rushNotExistException("商品不存在！");
		//4.返回商品信息
	    return m;
	}

	public Mad_rush searchMad_rushByAcpic(String madpic) throws DAOException,
			Mad_rushNotExistException {
		//1.获取DAO
				Mad_rushDAO dao = (Mad_rushDAO)DAOFactory.newInstance(KEY);
				//2.查询所有商品
				Mad_rush m = dao.queryByMadpic(madpic);
				//3.判断商品是否为空
				if(m == null)
					throw new Mad_rushNotExistException("商品不存在！");
				//4.返回商品信息
			    return m;
			}

	public void addMad_rush(Mad_rush mad_rush) throws DAOException,
			    Mad_rushExistException {
		        //1.获取DAO
		Mad_rushDAO dao = (Mad_rushDAO)DAOFactory.newInstance(KEY);
				//2.根据id查询商品对象
		Mad_rush m = dao.queryByMadid(mad_rush.getMadid());
				//3.判断商品是否存在 如果存在产生异常
				if(m !=null)
					throw new Mad_rushExistException("商品已存在");
				//4.插入商品
				dao.inserMad_rush(mad_rush);
			}
	public void updateByMad_rushInfo(int madid, String madpic, Buser bid)
			throws DAOException, Mad_rushNotExistException {
		        //1.获取DAO
		Mad_rushDAO dao = (Mad_rushDAO)DAOFactory.newInstance(KEY);
				//2.根据产地查询商品
		Mad_rush m = dao.queryByMadid(madid);
				//3.判断商品是否为空
				if(m == null)
					throw new Mad_rushNotExistException("商品不存在！");
			    //4.更新商品信息
				m.setMadpic(madpic);
		        m.setBuser(bid);
				
			}
	public void updateByMad_rushMadpic(String madpicPath, int madid)
			throws DAOException, Mad_rushNotExistException {
	     //1.获取DAO
			Mad_rushDAO dao = (Mad_rushDAO)DAOFactory.newInstance(KEY);
					//2.根据产地查询商品
			Mad_rush m = dao.queryByMadid(madid);
					//3.判断商品是否为空
					if(m == null)
						throw new Mad_rushNotExistException("商品不存在！");
				    //4.更新商品信息
					m.setMadpic(madpicPath);
			        m.setMadid(madid);
					
				}
	public void removeMad_rush(int madid) throws DAOException,
			Mad_rushNotExistException {
		//1.获取DAO
		Mad_rushDAO dao = (Mad_rushDAO)DAOFactory.newInstance(KEY);
				//2.根据id查询商品对象
		Mad_rush m = dao.queryByMadid(madid);
				//3.判断ac是否存在 如果存在产生异常
				if(m ==null)
					throw new Mad_rushNotExistException("商品不存在");
				//4.插入商品信息
				dao.delete(madid);
}
	}
