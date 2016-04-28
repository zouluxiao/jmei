package com.jmei.service.impl;

import java.util.List;

import com.jmei.bean.Jorder;
import com.jmei.dao.JorderDAO;
import com.jmei.dao.impl.JorderDAOImpl;
import com.jmei.exception.DAOException;
import com.jmei.exception.JorderHasNotExist;
import com.jmei.exception.JorderIsNotExist;
import com.jmei.exception.JorderIsNull;
import com.jmei.exception.JorderNotExist;
import com.jmei.factory.DAOFactory;
import com.jmei.service.JorderService;
/**
 * 实现JorderService接口的类
 * @author 邹璐
 * @since 2016-04-27
 *
 */

public class JorderServiceImpl implements JorderService {
	
	private final static String JORDER_DAO_KEY = "JorderDAOImpl";
	
	@Override
	public List<Jorder> searchAllOrder(int jid) throws DAOException,
			JorderNotExist {
		//1.创建对象UserDAOImpl对象
		JorderDAO jorderDAO = (JorderDAO)DAOFactory.newInstance(JORDER_DAO_KEY);
		//调用查询所有订单方法
		List<Jorder> list = jorderDAO.queryAllOrder(jid);
		//判断用户订单是否为空
		if(list.size() == 0)
			throw new JorderNotExist("该用户没有订单!");
		return list;
	}

	@Override
	public List<Jorder> queryOrderByIs_Val(int jid, int is_val)
			throws DAOException, JorderHasNotExist {
		//1.创建对象UserDAOImpl对象
		JorderDAO jorderDAO = (JorderDAO)DAOFactory.newInstance(JORDER_DAO_KEY);
		//调用查询所有订单方法
		List<Jorder> list = jorderDAO.queryOrderByIs_Val(jid, is_val);
		//判断是否有订单
		if(list.size() == 0)
			throw new JorderHasNotExist("没有订单!");
		return list;
	}

	@Override
	public void addJorder(Jorder jorder) throws DAOException,JorderIsNull {
		//1.创建对象UserDAOImpl对象
		JorderDAO jorderDAO = (JorderDAO)DAOFactory.newInstance(JORDER_DAO_KEY);
		//判断jorder是否为空
		if(jorder == null){
			throw new JorderIsNull("订单为空!");
		}
		//调用添加订单方法
		jorderDAO.addJorder(jorder);
	}

	@Override
	public void updateIs_valByJid(int orid, int is_val) throws DAOException,JorderIsNotExist {
		//1.创建对象UserDAOImpl对象
		JorderDAOImpl jorderDAO = (JorderDAOImpl)DAOFactory.newInstance(JORDER_DAO_KEY);
		//调用查询订单方法
		Jorder jorder = jorderDAO.queryJorderByOrid(orid);
		//判断是否有该订单
		if(jorder == null)
			throw new JorderIsNotExist("订单不存在");
		//调用修改订单状态方法
		jorderDAO.updateIs_valByJid(orid, is_val);
	}

}
