package com.jmei.dao;

import java.util.List;

import com.jmei.bean.Goods;
import com.jmei.bean.Pic;
import com.jmei.exception.DAOException;
/**
 * 	picid number(20) primary key,		--编号--
	picname varchar2(20),				--商品图片名--					
	gid number(20),						--商品库存编号--
	flag number                         --商品图片的类型0 代表小型图片，1代表中等图片，2代表中偏图片， 3代表大型图片--
 * **/

/**
 * 操作Pic表获取数据的DAO
 * @since 2016-4-26
 * @author 阳桂东
 *
 */
public interface PicDAO {	
	/**
	 * 增加图片
	 * @param pic  图片对象
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * */
	public void insertPic(Pic pic)throws DAOException;
	
	/**
	 * 删除所有图片
	 * @param void
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * */
	public void deleteAllPic()throws DAOException;
	
	/**
	 * 根据图片id删除图片
	 * @param picid 图片编号
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * */
	public void deletePicByPicid(int picid)throws DAOException;
	
	/**
	 * 删除所有某一名字的图片
	 * @param picname 图片名
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * */
	public void deleteAllPicByName(String picname)throws DAOException;
	
	/**
	 * 删除某商品所有图片
	 * @param goods 商品对象
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * */
	public void deleteGoodsAllPic(Goods goods)throws DAOException;
	
	/**
	 * 删除某商品所有小型图片
	 * @param goods 商品对象
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * */
	public void deleteGoodsAllSmaPic(Goods goods)throws DAOException;
	
	/**
	 * 删除某商品所有中型图片
	 * @param goods 商品对象
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * */
	public void deleteGoodsAllMidPic(Goods goods)throws DAOException;
	
	/**
	 * 删除某商品所有中偏图片
	 * @param goods 商品对象
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * */
	public void deleteGoodsAllMibPic(Goods goods)throws DAOException;
	
	/**
	 * 删除某商品所有大型图片
	 * @param goods 商品对象
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * */
	public void deleteGoodsAllBigPic(Goods goods)throws DAOException;
	
	/**
	 * 更新图片信息(图片名，库存编号，图片类型)
	 * @param pic  图片对象
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * */
	public void updatePic(Pic pic)throws DAOException;
	
	/**
	 * 查询所有图片信息
	 * @return List<Pic> 返回的图片对象集合
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * 
	 **/
	public List<Pic> queryAllPic()throws DAOException;
	
	/**
	 * 根据图片编号查询图片信息
	 * @param picid 图片编号
	 * @return Product 返回的图片对象 
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * 
	 **/
	public Pic queryPicByPicid(int picid)throws DAOException;
	
	/**
	 * 根据商品图片名查询图片信息
	 * @param picname 商品图片名
	 * @return Pic 返回的图片对象集合 
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * 
	 **/
	public List<Pic> queryPicByPicname(String picname)throws DAOException;
	
	/**
	 * 根据商品库存编号查询所有图片
	 * @param gid 商品库存编号
	 * @return List<Pic> 返回的图片对象 集合
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * 
	 **/
	public List<Pic> queryPicByGid(Goods gid)throws DAOException;
	
	/**
	 * 根据商品库存编号查询所有小型图片
	 * @param gid 商品库存编号
	 * @return List<Pic> 返回的图片对象 集合
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * 
	 **/
	public List<Pic> queryAllSmaPicByGid(Goods gid)throws DAOException;
	
	/**
	 * 根据商品库存编号查询所有中型图片
	 * @param gid 商品库存编号
	 * @return List<Pic> 返回的图片对象 集合
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * 
	 **/
	public List<Pic> queryAllMidPicByGid(Goods gid)throws DAOException;
	
	/**
	 * 根据商品库存编号查询所有中偏图片
	 * @param gid 商品库存编号
	 * @return List<Pic> 返回的图片对象 集合
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * 
	 **/
	public List<Pic> queryAllMibPicByGid(Goods gid)throws DAOException;
	
	/**
	 * 根据商品库存编号查询所有大型图片
	 * @param gid 商品库存编号
	 * @return List<Pic> 返回的图片对象 集合
	 * @exception DAOException DAO层获取数据过程发生的异常。
	 * 
	 **/
	public List<Pic> queryAllBigPicByGid(Goods gid)throws DAOException;
}
