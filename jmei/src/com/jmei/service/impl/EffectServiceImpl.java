package com.jmei.service.impl;

import java.util.List;

import com.jmei.bean.Effect;
import com.jmei.dao.EffectDAO;
import com.jmei.exception.DAOException;
import com.jmei.exception.EffectExistException;
import com.jmei.exception.EffectNotExistException;
import com.jmei.factory.DAOFactory;
import com.jmei.service.EffectService;
/**
 * EffectService接口实现类
 * @since 2016-04-27
 * @author 阳桂东
 * **/
public class EffectServiceImpl implements EffectService {
	private  final String  KEY ="EffectDAOImpl";
	//添加功效
	public void addEffect(Effect effect) throws DAOException,
			EffectExistException {
		//1.获取DAO
		EffectDAO dao = (EffectDAO)DAOFactory.newInstance(KEY);
		//2.根据id查询功效
		Effect e = dao.queryById(effect.getEid());
		//3.判断e是否存在 如果存在产生异常
		if(e !=null)
			throw new EffectExistException("功效已存在");
		//4.插入功效信息
		dao.insertEffect(effect);		
	}

	//删除功效
	public void removeEffect(int eid) throws DAOException,
			EffectNotExistException {
		//1.获取DAO
		EffectDAO dao = (EffectDAO)DAOFactory.newInstance(KEY);
		//2.根据id查询功效对象
		Effect e = dao.queryById(eid);
		//3.判断e是否存在 如果存在产生异常
		if(e ==null)
			throw new EffectNotExistException("功效不存在");
		//4.删除功效信息
		dao.deleteEffect(eid);
	}

	//更新功效信息
	public void updateByEffectInfo(int eid, String ename) throws DAOException,
			EffectNotExistException {
		//1.获取DAO
		EffectDAO dao = (EffectDAO)DAOFactory.newInstance(KEY);
		//2.根据id查询功效
		Effect e = dao.queryById(eid);
		//3.判断e是否为空
		if(e == null)
			throw new EffectNotExistException("功效不存在！");
	    //4.更新功效信息
		e.setEname(ename);
		dao.updateEffect(e);
	}

	//查询所有功效
	public List<Effect> searchAllEffect() throws DAOException,
			EffectNotExistException {
		//1.获取DAO
		EffectDAO dao = (EffectDAO)DAOFactory.newInstance(KEY);
		//2.查询所有功效
		List<Effect> list = dao.queryAllEffect();
		//3.判断list是否为空
		if(list.size() == 0)
			throw new EffectNotExistException("功效不存在！");
		//4.返回功效信息
	    return list;
	}

}
