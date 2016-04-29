package com.jmei.service;

import java.util.List;

import com.jmei.bean.Buser;
import com.jmei.bean.Mad_rush;
import com.jmei.exception.DAOException;
import com.jmei.exception.Mad_rushExistException;
import com.jmei.exception.Mad_rushNotExistException;

public interface Mad_rushService {
	/**
	 * 获取所有的商品
	 * @return 商品的集合
	 * @throws DAOException 数据库异常
	 * @throws Mad_rushNotExistException 商品不存在异常
	 */
	public List<Mad_rush> searchMad_rushs()throws DAOException,Mad_rushNotExistException;
	/**
	 * 根据商品编号 获取商品
	 * @param madid 商品编号
	 * @throws DAOException 数据库异常
	 * @throwsMad_rushNotExistException 商品不存在异常
	 */
	public Mad_rush searchMad_rushByMadid(int madid)throws DAOException,Mad_rushNotExistException;
	/**
	 * 根据商品图片 获取商品
	 * @param madpic 商品编号
	 * @throws DAOException 数据库异常
	 * @throwsMad_rushNotExistException 商品不存在异常
	 */
	public Mad_rush searchMad_rushByAcpic(String madpic)throws DAOException,Mad_rushNotExistException;

	/**
	 * 添加商品 
	 * @param Mad_rush 商品信息
	 * @throws DAOException 数据库异常
	 * @throws Mad_rushExistException  商品存在异常
	 */
	public void addMad_rush(Mad_rush mad_rush)throws DAOException,Mad_rushExistException;
    /**
     * 修改商品信息
     * @param madid 商品的编号
     * @param madpic 商品的图片
     * @param bid 商品的企业
     * @throws DAOException 数据库异常
	 * @throws Mad_rushNotExistException  商品不存在异常
     */
	public void updateByMad_rushInfo(int madid,String madpic,Buser bid)throws DAOException,Mad_rushNotExistException;
	/**
	 * 修改商品的图片
	 * @param madpicPath 图片的路径
	 * @param madid  商品的id
	 * @throws DAOException 数据库异常
	 * @throws Mad_rushNotExistException  商品不存在异常
	 */
	public void updateByMad_rushMadpic(String madpicPath,int madid)throws DAOException,Mad_rushNotExistException;
	
	/**
	 * 删除商品
	 * @param madid  商品的id
	 * @throws DAOException 数据库异常
	 * @throws Mad_rushNotExistException  商品不存在异常
	 */
	public void removeMad_rush(int madid)throws DAOException,Mad_rushNotExistException;

}
