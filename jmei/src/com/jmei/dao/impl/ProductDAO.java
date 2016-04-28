package com.jmei.dao;

import java.util.List;

import com.jmei.bean.Product;
import com.jmei.exception.DAOException;
/****
 * 	pid number(20) primary key,  	--���--
	pname varchar2(20),    			--��Ʒ��--
	p_isVal number (2)				--�Ƿ�ɾ��--
 **/


/**
 * ����Product���ȡ���ݵ�DAO
 * @since 2016-4-24
 * @author ����
 * */

public interface ProductDAO {	
	/**
	 * ������Ʒ��Ϣ
	 * @param product  ��Ʒ����
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * */
	public void insertProduct(Product product)throws DAOException;
	
	/**
	 * ɾ����Ʒ
	 * @param pid ��Ʒ���
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * */
	public void deleteProduct(int pid )throws DAOException;
	
	/**
	 * ������Ʒ��Ϣ(��ţ���Ʒ������Ʒ�Ƿ�ɾ��)
	 * @param product  ��Ʒ����
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * */
	public void updateProduct(Product product)throws DAOException;
	
	/**
	 * ��ѯ������Ʒ��Ϣ
	 * @return List<Product> ���ص���Ʒ���󼯺� 
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * 
	 **/
	public List<Product> queryAllProduct()throws DAOException;
	
	/**
	 * ����PID��ѯ��Ʒ��Ϣ
	 * @param pid ��Ʒ���
	 * @return Product ���ص���Ʒ���� 
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * 
	 **/
	public Product queryById(int pid)throws DAOException;
	
	/**
	 * ������Ʒ����ѯ��Ʒ��Ϣ
	 * @param pname ��Ʒ��
	 * @return Product ���ص���Ʒ����
	 * @exception DAOException DAO���ȡ���ݹ��̷������쳣��
	 * 
	 **/
	public Product queryByPname(String pname)throws DAOException;
	
}
