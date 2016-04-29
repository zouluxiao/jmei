package com.jmei.service.impl;

import java.util.List;

import com.jmei.bean.Activity;
import com.jmei.bean.Buser;
import com.jmei.dao.ActivityDAO;
import com.jmei.exception.ActivityExistException;
import com.jmei.exception.ActivityNotExistException;
import com.jmei.exception.DAOException;
import com.jmei.factory.DAOFactory;
import com.jmei.service.ActivityService;
/**
 * @author 钟进
 * @date 2016-04-27
 **/
public class ActivityServiceImpl implements ActivityService {
	private  final String  KEY ="ActivityDAOImpl";
	
	public List<Activity> searchActivitys() throws DAOException,
			ActivityNotExistException {
                //1.获取DAO
		 ActivityDAO dao = (ActivityDAO)DAOFactory.newInstance(KEY);
		//2.查询所有商品
		List<Activity> list = dao.queryByAll();
		//3.判断list是否为空
		if(list.size() == 0)
			throw new ActivityNotExistException("商品不存在！");
		//4.返回商品信息
	    return list;
	}
		
	public Activity searchActivityByAcid(int acid) throws DAOException,
			ActivityNotExistException {
		//1.获取DAO
		 ActivityDAO dao = (ActivityDAO)DAOFactory.newInstance(KEY);
		//2.查询所有商品
		Activity ac = dao.queryByAcid(acid);
		//3.判断商品是否为空
		if(ac == null)
			throw new ActivityNotExistException("商品不存在！");
		//4.返回商品信息
	    return ac;
	}

	public Activity searchActivityByAcpic(String acpic) throws DAOException,
			ActivityNotExistException {
		//1.获取DAO
		 ActivityDAO dao = (ActivityDAO)DAOFactory.newInstance(KEY);
		//2.查询所有商品
		Activity ac = dao.queryByAcpic(acpic);
		//3.判断list是否为空
		if(ac == null)
			throw new ActivityNotExistException("商品不存在！");
		//4.返回商品信息
	    return ac;
	}

	public void addActivity(Activity activity) throws DAOException,
			ActivityExistException {
		//1.获取DAO
		ActivityDAO dao = (ActivityDAO)DAOFactory.newInstance(KEY);
		//2.根据id查询商品对象
		Activity ac = dao.queryByAcid(activity.getAcid());
		//3.判断商品是否存在 如果存在产生异常
		if(ac !=null)
			throw new ActivityExistException("商品已存在");
		//4.插入商品
		dao.inserActivity(activity);
	}
	public void updateByActivityInfo(int acid, String acpic, Buser bid)
			throws DAOException, ActivityNotExistException {
		//1.获取DAO
		ActivityDAO dao = (ActivityDAO)DAOFactory.newInstance(KEY);
		//2.根据产地查询商品
		Activity ac = dao.queryByAcid(acid);
		//3.判断商品是否为空
		if(ac == null)
			throw new ActivityNotExistException("商品不存在！");
	    //4.更新商品信息
		ac.setAcpic(acpic);
        ac.setBuser(bid);
		
	}
	public void updateByActivityAcpic(String acpicPath, int acid)
			throws DAOException, ActivityNotExistException {
		//1.获取DAO
		ActivityDAO dao = (ActivityDAO)DAOFactory.newInstance(KEY);
		//2.根据产地查询商品
		Activity ac = dao.queryByAcid(acid);
		//3.判断是否为空
		if(ac == null)
			throw new ActivityNotExistException("商品不存在！");
	    //4.更新商品信息
		ac.setAcpic(acpicPath);
		dao.updateActivity(ac);
	}
	public void removeActivity(int acid) throws DAOException,
			ActivityNotExistException {
		//1.获取DAO
		ActivityDAO dao = (ActivityDAO)DAOFactory.newInstance(KEY);
		//2.根据id查询商品对象
		Activity ac = dao.queryByAcid(acid);
		//3.判断ac是否存在 如果存在产生异常
		if(ac ==null)
			throw new ActivityNotExistException("商品不存在");
		//4.插入商品信息
		dao.delete(acid);
	}
}
