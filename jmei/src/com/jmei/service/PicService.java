package com.jmei.service;

import java.util.List;

import com.jmei.bean.Goods;
import com.jmei.bean.Pic;
import com.jmei.exception.DAOException;
import com.jmei.exception.PicExistException;
import com.jmei.exception.PicNotExistException;
/**
 * PicService接口
 * @since 2016-04-27
 * @author 阳桂东
 * **/

public interface PicService {
	/**
	 * 增加图片
	 * @param pic  图片对象
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * */
	public void addPic(Pic pic)throws DAOException,PicExistException;
	
	/**
	 * 删除所有图片
	 * @param void
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * */
	public void removeAllPic()throws DAOException,PicNotExistException;
	
	/**
	 * 根据图片id删除图片
	 * @param picid 图片编号
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * */
	public void removePicByPicid(int picid)throws DAOException,PicNotExistException;
	
	/**
	 * 删除所有某一名字的图片
	 * @param picname 图片名
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * */
	public void removeAllPicByName(String picname)throws DAOException,PicNotExistException;
	
	/**
	 * 删除某商品所有图片
	 * @param goods 商品对象
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * */
	public void removeGoodsAllPic(Goods goods)throws DAOException,PicNotExistException;
	
	/**
	 * 删除某商品所有小型图片
	 * @param goods 商品对象
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * */
	public void removeGoodsAllSmaPic(Goods goods)throws DAOException,PicNotExistException;
	
	/**
	 * 删除某商品所有中型图片
	 * @param goods 商品对象
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * */
	public void removeGoodsAllMidPic(Goods goods)throws DAOException,PicNotExistException;
	
	/**
	 * 删除某商品所有中偏图片
	 * @param goods 商品对象
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * */
	public void removeGoodsAllMibPic(Goods goods)throws DAOException,PicNotExistException;
	
	/**
	 * 删除某商品所有大型图片
	 * @param goods 商品对象
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * */
	public void removeGoodsAllBigPic(Goods goods)throws DAOException,PicNotExistException;
	
	/**
	 * 更新图片信息(图片名，库存编号，图片类型)
	 * @param pic  图片对象
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * */
	public void updatePic(int picid,String picname,Goods Goods,int flag)throws DAOException,PicNotExistException;
	
	/**
	 * 查询所有图片信息
	 * @return List<Pic> 返回的图片对象集合
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * 
	 **/
	public List<Pic> searchAllPic()throws DAOException,PicNotExistException;
	
	/**
	 * 根据图片编号查询图片信息
	 * @param picid 图片编号
	 * @return Product 返回的图片对象 
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * 
	 **/
	public Pic searchPicByPicid(int picid)throws DAOException,PicNotExistException;
	
	/**
	 * 根据商品图片名查询图片信息
	 * @param picname 商品图片名
	 * @return Pic 返回的图片对象集合 
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * 
	 **/
	public List<Pic> searchPicByPicname(String picname)throws DAOException,PicNotExistException;
	
	/**
	 * 根据商品库存编号查询所有图片
	 * @param gid 商品库存编号
	 * @return List<Pic> 返回的图片对象 集合
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * 
	 **/
	public List<Pic> searchPicByGid(Goods gid)throws DAOException,PicNotExistException;
	
	/**
	 * 根据商品库存编号查询所有小型图片
	 * @param gid 商品库存编号
	 * @return List<Pic> 返回的图片对象 集合
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * 
	 **/
	public List<Pic> searchAllSmaPicByGid(Goods gid)throws DAOException,PicNotExistException;
	
	/**
	 * 根据商品库存编号查询所有中型图片
	 * @param gid 商品库存编号
	 * @return List<Pic> 返回的图片对象 集合
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * 
	 **/
	public List<Pic> searchAllMidPicByGid(Goods gid)throws DAOException,PicNotExistException;
	
	/**
	 * 根据商品库存编号查询所有中偏图片
	 * @param gid 商品库存编号
	 * @return List<Pic> 返回的图片对象 集合
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * 
	 **/
	public List searchAllMibPicByGid(Goods gid)throws DAOException,PicNotExistException;
	
	/**
	 * 根据商品库存编号查询所有大型图片
	 * @param gid 商品库存编号
	 * @return List<Pic> 返回的图片对象 集合
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * 
	 **/
	public List searchAllBigPicByGid(Goods gid)throws DAOException,PicNotExistException;
	
	/**
	 * 根据商品库存编号查询所有小型图片和中型图片
	 * @param gid 商品库存编号
	 * @return List<Pic> 返回的图片对象 集合
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * 
	 **/
	public List searchAllSmaMidPicByGid(Goods gid)throws DAOException,PicNotExistException;
	
	/**
	 * 根据商品库存编号查询所有小型图片和中偏图片
	 * @param gid 商品库存编号
	 * @return List<Pic> 返回的图片对象 集合
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * 
	 **/
	public List searchAllSmaMibPicByGid(Goods gid)throws DAOException,PicNotExistException;
	
	/**
	 * 根据商品库存编号查询所有小型图片和大型图片
	 * @param gid 商品库存编号
	 * @return List<Pic> 返回的图片对象 集合
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * 
	 **/
	public List searchAllSmaBigPicByGid(Goods gid)throws DAOException,PicNotExistException;
	
	/**
	 * 根据商品库存编号查询所有中型图片和中偏图片
	 * @param gid 商品库存编号
	 * @return List<Pic> 返回的图片对象 集合
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * 
	 **/
	public List searchAllMidMibPicByGid(Goods gid)throws DAOException,PicNotExistException;
	
	/**
	 * 根据商品库存编号查询所有中型图片和大型图片
	 * @param gid 商品库存编号
	 * @return List<Pic> 返回的图片对象 集合
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * 
	 **/
	public List searchAllMidBigPicByGid(Goods gid)throws DAOException,PicNotExistException;
	
	/**
	 * 根据商品库存编号查询所有中偏图片和大型图片
	 * @param gid 商品库存编号
	 * @return List<Pic> 返回的图片对象 集合
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * 
	 **/
	public List searchAllMibBigPicByGid(Goods gid)throws DAOException,PicNotExistException;
}
