package com.jmei.service;

import java.util.List;

import com.jmei.bean.Goods;
import com.jmei.bean.Pic;
import com.jmei.exception.DAOException;
import com.jmei.exception.PicExistException;
import com.jmei.exception.PicNotExistException;
/**
 * PicService�ӿ�
 * @since 2016-04-27
 * @author ����
 * **/

public interface PicService {
	/**
	 * ����ͼƬ
	 * @param pic  ͼƬ����
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * */
	public void addPic(Pic pic)throws DAOException,PicExistException;
	
	/**
	 * ɾ������ͼƬ
	 * @param void
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * */
	public void removeAllPic()throws DAOException,PicNotExistException;
	
	/**
	 * ����ͼƬidɾ��ͼƬ
	 * @param picid ͼƬ���
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * */
	public void removePicByPicid(int picid)throws DAOException,PicNotExistException;
	
	/**
	 * ɾ������ĳһ���ֵ�ͼƬ
	 * @param picname ͼƬ��
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * */
	public void removeAllPicByName(String picname)throws DAOException,PicNotExistException;
	
	/**
	 * ɾ��ĳ��Ʒ����ͼƬ
	 * @param goods ��Ʒ����
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * */
	public void removeGoodsAllPic(Goods goods)throws DAOException,PicNotExistException;
	
	/**
	 * ɾ��ĳ��Ʒ����С��ͼƬ
	 * @param goods ��Ʒ����
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * */
	public void removeGoodsAllSmaPic(Goods goods)throws DAOException,PicNotExistException;
	
	/**
	 * ɾ��ĳ��Ʒ��������ͼƬ
	 * @param goods ��Ʒ����
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * */
	public void removeGoodsAllMidPic(Goods goods)throws DAOException,PicNotExistException;
	
	/**
	 * ɾ��ĳ��Ʒ������ƫͼƬ
	 * @param goods ��Ʒ����
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * */
	public void removeGoodsAllMibPic(Goods goods)throws DAOException,PicNotExistException;
	
	/**
	 * ɾ��ĳ��Ʒ���д���ͼƬ
	 * @param goods ��Ʒ����
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * */
	public void removeGoodsAllBigPic(Goods goods)throws DAOException,PicNotExistException;
	
	/**
	 * ����ͼƬ��Ϣ(ͼƬ��������ţ�ͼƬ����)
	 * @param pic  ͼƬ����
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * */
	public void updatePic(int picid,String picname,Goods Goods,int flag)throws DAOException,PicNotExistException;
	
	/**
	 * ��ѯ����ͼƬ��Ϣ
	 * @return List<Pic> ���ص�ͼƬ���󼯺�
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * 
	 **/
	public List<Pic> searchAllPic()throws DAOException,PicNotExistException;
	
	/**
	 * ����ͼƬ��Ų�ѯͼƬ��Ϣ
	 * @param picid ͼƬ���
	 * @return Product ���ص�ͼƬ���� 
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * 
	 **/
	public Pic searchPicByPicid(int picid)throws DAOException,PicNotExistException;
	
	/**
	 * ������ƷͼƬ����ѯͼƬ��Ϣ
	 * @param picname ��ƷͼƬ��
	 * @return Pic ���ص�ͼƬ���󼯺� 
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * 
	 **/
	public List<Pic> searchPicByPicname(String picname)throws DAOException,PicNotExistException;
	
	/**
	 * ������Ʒ����Ų�ѯ����ͼƬ
	 * @param gid ��Ʒ�����
	 * @return List<Pic> ���ص�ͼƬ���� ����
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * 
	 **/
	public List<Pic> searchPicByGid(Goods gid)throws DAOException,PicNotExistException;
	
	/**
	 * ������Ʒ����Ų�ѯ����С��ͼƬ
	 * @param gid ��Ʒ�����
	 * @return List<Pic> ���ص�ͼƬ���� ����
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * 
	 **/
	public List<Pic> searchAllSmaPicByGid(Goods gid)throws DAOException,PicNotExistException;
	
	/**
	 * ������Ʒ����Ų�ѯ��������ͼƬ
	 * @param gid ��Ʒ�����
	 * @return List<Pic> ���ص�ͼƬ���� ����
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * 
	 **/
	public List<Pic> searchAllMidPicByGid(Goods gid)throws DAOException,PicNotExistException;
	
	/**
	 * ������Ʒ����Ų�ѯ������ƫͼƬ
	 * @param gid ��Ʒ�����
	 * @return List<Pic> ���ص�ͼƬ���� ����
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * 
	 **/
	public List searchAllMibPicByGid(Goods gid)throws DAOException,PicNotExistException;
	
	/**
	 * ������Ʒ����Ų�ѯ���д���ͼƬ
	 * @param gid ��Ʒ�����
	 * @return List<Pic> ���ص�ͼƬ���� ����
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * 
	 **/
	public List searchAllBigPicByGid(Goods gid)throws DAOException,PicNotExistException;
	
	/**
	 * ������Ʒ����Ų�ѯ����С��ͼƬ������ͼƬ
	 * @param gid ��Ʒ�����
	 * @return List<Pic> ���ص�ͼƬ���� ����
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * 
	 **/
	public List searchAllSmaMidPicByGid(Goods gid)throws DAOException,PicNotExistException;
	
	/**
	 * ������Ʒ����Ų�ѯ����С��ͼƬ����ƫͼƬ
	 * @param gid ��Ʒ�����
	 * @return List<Pic> ���ص�ͼƬ���� ����
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * 
	 **/
	public List searchAllSmaMibPicByGid(Goods gid)throws DAOException,PicNotExistException;
	
	/**
	 * ������Ʒ����Ų�ѯ����С��ͼƬ�ʹ���ͼƬ
	 * @param gid ��Ʒ�����
	 * @return List<Pic> ���ص�ͼƬ���� ����
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * 
	 **/
	public List searchAllSmaBigPicByGid(Goods gid)throws DAOException,PicNotExistException;
	
	/**
	 * ������Ʒ����Ų�ѯ��������ͼƬ����ƫͼƬ
	 * @param gid ��Ʒ�����
	 * @return List<Pic> ���ص�ͼƬ���� ����
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * 
	 **/
	public List searchAllMidMibPicByGid(Goods gid)throws DAOException,PicNotExistException;
	
	/**
	 * ������Ʒ����Ų�ѯ��������ͼƬ�ʹ���ͼƬ
	 * @param gid ��Ʒ�����
	 * @return List<Pic> ���ص�ͼƬ���� ����
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * 
	 **/
	public List searchAllMidBigPicByGid(Goods gid)throws DAOException,PicNotExistException;
	
	/**
	 * ������Ʒ����Ų�ѯ������ƫͼƬ�ʹ���ͼƬ
	 * @param gid ��Ʒ�����
	 * @return List<Pic> ���ص�ͼƬ���� ����
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * 
	 **/
	public List searchAllMibBigPicByGid(Goods gid)throws DAOException,PicNotExistException;
}
