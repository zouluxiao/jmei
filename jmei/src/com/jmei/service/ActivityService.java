package com.jmei.service;
import java.util.List;

import com.jmei.bean.Activity;
import com.jmei.bean.Buser;
import com.jmei.exception.ActivityExistException;
import com.jmei.exception.ActivityNotExistException;
import com.jmei.exception.DAOException;
/**
 * @author 钟进
 * @since 2016-04-27
 * 精选活动表的service接口
 */
public interface ActivityService {

	/**
	 * 获取所有的商品
	 * @return 商品的集合
	 * @throws DAOException 数据库异常
	 * @throws ActivityNotExistException 商品不存在异常
	 */
	public List<Activity> searchActivitys()throws DAOException,ActivityNotExistException;
	/**
	 * 根据商品编号 获取商品
	 * @param acid 商品编号
	 * @throws DAOException 数据库异常
	 * @throwsActivityNotExistException 商品不存在异常
	 */
	public Activity searchActivityByAcid(int acid)throws DAOException,ActivityNotExistException;
	
	/**
	 * 根据商品图片 获取商品
	 * @param acpic 商品编号
	 * @throws DAOException 数据库异常
	 * @throwsActivityNotExistException 商品不存在异常
	 */
	public Activity searchActivityByAcpic(String acpic)throws DAOException,ActivityNotExistException;

	/**
	 * 添加商品 
	 * @param activity 商品信息
	 * @throws DAOException 数据库异常
	 * @throws ActivityExistException  商品存在异常
	 */
	public void addActivity(Activity activity)throws DAOException,ActivityExistException;
	
    /**
     * 修改商品信息
     * @param acid 商品的编号
     * @param acpic 商品的图片
     * @param bid 商品的企业
     * @throws DAOException 数据库异常
	 * @throws ActivityNotExistException  商品不存在异常
     */
	public void updateByActivityInfo(int acid,String acpic,Buser bid)throws DAOException,ActivityNotExistException;
	
	/**
	 * 修改商品的图片
	 * @param acpicPath 图片的路径
	 * @param acid  商品的id
	 * @throws DAOException 数据库异常
	 * @throws ActivityNotExistException  商品不存在异常
	 */
	public void updateByActivityAcpic(String acpicPath,int acid)throws DAOException,ActivityNotExistException;
	
	
	
	/**
	 * 删除商品
	 * @param acid  商品的id
	 * @throws DAOException 数据库异常
	 * @throws ProductNotExistException  商品不存在异常
	 */
	public void removeActivity(int acid)throws DAOException,ActivityNotExistException;
	
}
