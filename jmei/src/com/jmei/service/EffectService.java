package com.jmei.service;

import java.util.List;

import com.jmei.bean.Effect;
import com.jmei.exception.DAOException;
import com.jmei.exception.EffectExistException;
import com.jmei.exception.EffectNotExistException;
/**
 * EffectService接口
 * @since 2016-04-27
 * @author 阳桂东
 * **/

public interface EffectService {
	/**
	 * 添加功效
	 * @param  effect 功效对象
	 * @throws DAOException 数据库异常
	 * @throws EffectExistException  功效存在异常
	 */
	public void addEffect(Effect effect)throws DAOException,EffectExistException;
	
	/**
	 * 删除功效
	 * @param  eid 功效id
	 * @throws DAOException 数据库异常
	 * @throws EffectNotExistException  管理员不存在异常
	 */
	public void removeEffect(int eid)throws DAOException,EffectNotExistException;
	
    /**
     * 修改功效信息
     * @param eid 功效的id
     * @param ename 功效名
     * @throws DAOException 数据库异常
	 * @throws EffectNotExistException  功效不存在异常
     */
	public void updateByEffectInfo(int eid,String ename)throws DAOException,EffectNotExistException;
	
	/**
	 * 获取所有功效
	 * @return 功效的集合
	 * @throws DAOException 数据库异常
	 */
	public List<Effect> searchAllEffect()throws DAOException,EffectNotExistException;
	
}
