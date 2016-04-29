package com.jmei.dao;
import java.util.List;
import com.jmei.bean.Activity;
import com.jmei.exception.DAOException;
/**
 * ҵ���������Ծ�ѡ��Ʒ�����ɾ�Ĳ�
 * @author �ӽ�
 * @date 2016-04-23
 **/
public interface ActivityDAO {
	/**
	 * ��ѯ���е���Ʒ
	 * @return List<Activity>  ������Ʒ����ļ��� 
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 **/
	public List<Activity> queryByAll()throws DAOException;
	/**
	 * ����acid��ѯ��ѡ��Ʒ
	 * @param acid ���
	 * @return Activity ������Ʒ����
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * 
	 **/
	
	public Activity queryByAcid(int acid)throws DAOException;
	/**
	 * ����ͼƬ��ѯ��Ʒ
	 * @param acpic ͼƬ
	 * @return  Activity ������Ʒ����
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 **/
	public Activity queryByAcpic(String acpic)throws DAOException;
	/**
	 * ������Ʒ
	 * @param Activity ��Ʒ����
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * */
	public void inserActivity(Activity activity)throws DAOException; 
	/**
	 * ����adid���¾�ѡ��Ʒ��Ϣ
	 * @param Activity ��Ʒ����
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * */
	public void updateActivity(Activity activity)throws DAOException;
	/**
	 * ����acidɾ����ѡ��Ʒ
	 * @param acid ��Ʒ���
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * */
	public void delete(int acid)throws DAOException;
}



