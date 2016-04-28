package com.jmei.dao;

import java.util.List;

import com.jmei.bean.Goods;
import com.jmei.bean.Pic;
import com.jmei.exception.DAOException;
/**
 * 	picid number(20) primary key,		--���--
	picname varchar2(20),				--��ƷͼƬ��--					
	gid number(20),						--��Ʒ�����--
	flag number                         --��ƷͼƬ������0 ����С��ͼƬ��1�����е�ͼƬ��2������ƫͼƬ�� 3�������ͼƬ--
 * **/

/**
 * ����Pic���ȡ���ݵ�DAO
 * @since 2016-4-26
 * @author ����
 *
 */
public interface PicDAO {	
	/**
	 * ����ͼƬ
	 * @param pic  ͼƬ����
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * */
	public void insertPic(Pic pic)throws DAOException;
	
	/**
	 * ɾ������ͼƬ
	 * @param void
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * */
	public void deleteAllPic()throws DAOException;
	
	/**
	 * ����ͼƬidɾ��ͼƬ
	 * @param picid ͼƬ���
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * */
	public void deletePicByPicid(int picid)throws DAOException;
	
	/**
	 * ɾ������ĳһ���ֵ�ͼƬ
	 * @param picname ͼƬ��
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * */
	public void deleteAllPicByName(String picname)throws DAOException;
	
	/**
	 * ɾ��ĳ��Ʒ����ͼƬ
	 * @param goods ��Ʒ����
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * */
	public void deleteGoodsAllPic(Goods goods)throws DAOException;
	
	/**
	 * ɾ��ĳ��Ʒ����С��ͼƬ
	 * @param goods ��Ʒ����
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * */
	public void deleteGoodsAllSmaPic(Goods goods)throws DAOException;
	
	/**
	 * ɾ��ĳ��Ʒ��������ͼƬ
	 * @param goods ��Ʒ����
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * */
	public void deleteGoodsAllMidPic(Goods goods)throws DAOException;
	
	/**
	 * ɾ��ĳ��Ʒ������ƫͼƬ
	 * @param goods ��Ʒ����
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * */
	public void deleteGoodsAllMibPic(Goods goods)throws DAOException;
	
	/**
	 * ɾ��ĳ��Ʒ���д���ͼƬ
	 * @param goods ��Ʒ����
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * */
	public void deleteGoodsAllBigPic(Goods goods)throws DAOException;
	
	/**
	 * ����ͼƬ��Ϣ(ͼƬ��������ţ�ͼƬ����)
	 * @param pic  ͼƬ����
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * */
	public void updatePic(Pic pic)throws DAOException;
	
	/**
	 * ��ѯ����ͼƬ��Ϣ
	 * @return List<Pic> ���ص�ͼƬ���󼯺�
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * 
	 **/
	public List<Pic> queryAllPic()throws DAOException;
	
	/**
	 * ����ͼƬ��Ų�ѯͼƬ��Ϣ
	 * @param picid ͼƬ���
	 * @return Product ���ص�ͼƬ���� 
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * 
	 **/
	public Pic queryPicByPicid(int picid)throws DAOException;
	
	/**
	 * ������ƷͼƬ����ѯͼƬ��Ϣ
	 * @param picname ��ƷͼƬ��
	 * @return Pic ���ص�ͼƬ���󼯺� 
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * 
	 **/
	public List<Pic> queryPicByPicname(String picname)throws DAOException;
	
	/**
	 * ������Ʒ����Ų�ѯ����ͼƬ
	 * @param gid ��Ʒ�����
	 * @return List<Pic> ���ص�ͼƬ���� ����
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * 
	 **/
	public List<Pic> queryPicByGid(Goods gid)throws DAOException;
	
	/**
	 * ������Ʒ����Ų�ѯ����С��ͼƬ
	 * @param gid ��Ʒ�����
	 * @return List<Pic> ���ص�ͼƬ���� ����
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * 
	 **/
	public List<Pic> queryAllSmaPicByGid(Goods gid)throws DAOException;
	
	/**
	 * ������Ʒ����Ų�ѯ��������ͼƬ
	 * @param gid ��Ʒ�����
	 * @return List<Pic> ���ص�ͼƬ���� ����
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * 
	 **/
	public List<Pic> queryAllMidPicByGid(Goods gid)throws DAOException;
	
	/**
	 * ������Ʒ����Ų�ѯ������ƫͼƬ
	 * @param gid ��Ʒ�����
	 * @return List<Pic> ���ص�ͼƬ���� ����
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * 
	 **/
	public List<Pic> queryAllMibPicByGid(Goods gid)throws DAOException;
	
	/**
	 * ������Ʒ����Ų�ѯ���д���ͼƬ
	 * @param gid ��Ʒ�����
	 * @return List<Pic> ���ص�ͼƬ���� ����
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * 
	 **/
	public List<Pic> queryAllBigPicByGid(Goods gid)throws DAOException;
}
