package com.jmei.service;

import java.util.List;

import com.jmei.bean.Product;
import com.jmei.exception.DAOException;
import com.jmei.exception.ProductExistException;
import com.jmei.exception.ProductNotExistException;
/**
 * ProductService�ӿ�
 * @since 2016-04-27
 * @author ����
 * **/

public interface ProductService {
	/**
	 * �����Ʒ 
	 * @param pro ��Ʒ��Ϣ
	 * @throws DAOException ���ݿ��쳣
	 * @throws ProductExistException  ��Ʒ�����쳣
	 */
	public void addProduct(Product pro)throws DAOException,ProductExistException;
	
	/**
	 * ɾ����Ʒ 
	 * @param pro ��Ʒ��Ϣ
	 * @throws DAOException ���ݿ��쳣
	 * @throws ProductNotExistException  ��Ʒ�������쳣
	 */
	public void removeProduct(Product pro)throws DAOException,ProductNotExistException;
	
    /**
     * �޸���Ʒ��Ϣ
     * @param pid ��Ʒ��id
     * @param pname ��Ʒ������
     * @param isVal ��Ʒ�Ƿ�ʧЧ
     * @throws DAOException ���ݿ��쳣
	 * @throws ProductNotExistException  ��Ʒ�������쳣
     */
	public void updateByProductInfo(int pid,String name,int isVal)throws DAOException,ProductNotExistException;
	
	/**
	 * ��ȡ������Ʒ
	 * @return ��Ʒ�ļ���
	 * @throws DAOException ���ݿ��쳣
	 * @throws ProductNotExistException ��Ʒ�������쳣
	 */
	public List<Product> searchAllProduct()throws DAOException,ProductNotExistException;
	
	/**
	 * ������Ʒ��� ��ȡ��Ʒ
	 * @param id ��Ʒ���
	 * @return ��Ʒ�ļ���
	 * @throws DAOException ���ݿ��쳣
	 * @throws ProductNotExistException ��Ʒ�������쳣
	 */
	public Product searchProductById(int id)throws DAOException,ProductNotExistException;
	
	/**
	 * 
	 * ������Ʒ�� ��ȡ��Ʒ
	 * @param pid ��Ʒ���
	 * @return ��Ʒ�ļ���
	 * @throws DAOException ���ݿ��쳣
	 * @throws ProductNotExistException ��Ʒ�������쳣
	 */
	public Product searchProductByPname(String pname)throws DAOException,ProductNotExistException;
}
