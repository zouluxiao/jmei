package com.jmei.service;

import java.util.List;
import com.jmei.bean.Gtype;
import com.jmei.exception.DAOException;
import com.jmei.exception.GtypeExistException;
import com.jmei.exception.GtypeNotExistException;
/**
 * @author 钟进
 * @since 2016-04-27
 * 类型表service接口
 */
public interface GtypeService {
	/**
	 * 获取所有的类型
	 * @return 类型的集合
	 * @throws DAOException 数据库异常
	 * @throws GtypeNotExistException 商品不存在异常
	 */
	public List<Gtype> searchGtypes()throws DAOException,GtypeNotExistException;
	/**
	 * 根据类型编号 获取类型
	 * @param tid 类型编号
	 * @throws DAOException 数据库异常
	 * @throwsGtypeNotExistException 商品不存在异常
	 */
	public Gtype searchGtypeByTid(int tid)throws DAOException,GtypeNotExistException;
	
	/**
	 * 根据tid 获取类型
	 * @param tname类型名称
	 * @throws DAOException 数据库异常
	 * @throwsGtypeNotExistException 商品不存在异常
	 */
	public Gtype searchGtypeByTname(String tname)throws DAOException,GtypeNotExistException;

	/**
	 * 添加商品 
	 * @param Gtype 类型
	 * @throws DAOException 数据库异常
	 * @throws GtypeExistException  商品存在异常
	 */
	public void addGtype(Gtype gtype)throws DAOException,GtypeExistException;
	
    /**
     * 修改类型
     * @param tid 类型的编号
     * @param tname 类型名称
     * @throws DAOException 数据库异常
	 * @throws GtypeNotExistException  商品不存在异常
     */
	public void updateByGtypeInfo(int tid,String tname)throws DAOException,GtypeNotExistException;

	/**
	 * 删除商品
	 * @param tid 类型的id
	 * @throws DAOException 数据库异常
	 * @throws GtypeNotExistException  商品不存在异常
	 */
	public void removeGtype(int tid)throws DAOException,GtypeNotExistException;
	
}

