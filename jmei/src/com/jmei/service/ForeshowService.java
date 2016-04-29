package com.jmei.service;

import java.util.List;
import com.jmei.bean.Buser;
import com.jmei.bean.Foreshow;
import com.jmei.exception.DAOException;
import com.jmei.exception.ForeshowExistException;
import com.jmei.exception.ForeshowNotExistException;
/**
 * @author 钟进
 * @since 2016-04-27
 * 明日预选表的service接口
 */
public interface ForeshowService {
	/**
	 * 获取所有的商品
	 * @return 商品的集合
	 * @throws DAOException 数据库异常
	 * @throws ForeshowNotExistException 商品不存在异常
	 */
	public List<Foreshow> searchForeshows()throws DAOException,ForeshowNotExistException;
	/**
	 * 根据商品编号 获取商品
	 * @param foreid 商品编号
	 * @throws DAOException 数据库异常
	 * @throwsForeshowNotExistException 商品不存在异常
	 */
	public Foreshow searchForeshowByForeid(int foreid)throws DAOException,ForeshowNotExistException;
	
	/**
	 * 根据商品图片 获取商品
	 * @param forepic 商品编号
	 * @throws DAOException 数据库异常
	 * @throwsForeshowNotExistException 商品不存在异常
	 */
	public Foreshow searchForeshowByForepic(String forepic)throws DAOException,ForeshowNotExistException;

	/**
	 * 添加商品 
	 * @param Foreshow 商品信息
	 * @throws DAOException 数据库异常
	 * @throws ForeshowExistException  商品存在异常
	 */
	public void addForeshow(Foreshow foreshow)throws DAOException,ForeshowExistException;
	
    /**
     * 修改商品信息
     * @param foreid 商品的编号
     * @param forepic 商品的图片
     * @param bid 商品的企业
     * @throws DAOException 数据库异常
	 * @throws ForeshowNotExistException  商品不存在异常
     */
	public void updateByForeshowInfo(int foreid,String forepic,Buser bid)throws DAOException,ForeshowNotExistException;
	
	/**
	 * 修改商品的图片
	 * @param forepicPath 图片的路径
	 * @param foreid  商品的id
	 * @throws DAOException 数据库异常
	 * @throws ForeshowNotExistException  商品不存在异常
	 */
	public void updateByForeshowForepic(String forepicPath,int foreid)throws DAOException,ForeshowNotExistException;
	
	
	
	/**
	 * 删除商品
	 * @param acid  商品的id
	 * @throws DAOException 数据库异常
	 * @throws ProductNotExistException  商品不存在异常
	 */
	public void removeForeshow(int foreid)throws DAOException,ForeshowNotExistException;
	
}


