package com.jmei.service.impl;

import java.util.List;

import com.jmei.bean.Product;
import com.jmei.dao.ProductDAO;
import com.jmei.exception.DAOException;
import com.jmei.exception.ProductExistException;
import com.jmei.exception.ProductNotExistException;
import com.jmei.factory.DAOFactory;
import com.jmei.service.ProductService;
/**
 * ProductService�ӿ�ʵ����
 * @since 2016-04-27
 * @author ����
 * **/
public class ProductServiceImpl implements ProductService {
	private  final String  KEY ="ProductDAOImpl";
	//�����Ʒ 
	public void addProduct(Product pro) throws DAOException,
			ProductExistException {
		//1.��ȡDAO
		ProductDAO dao = (ProductDAO)DAOFactory.newInstance(KEY);
		//2.����id��ѯ��Ʒ����
		Product p = dao.queryById(pro.getPid());
		//3.�ж�p�Ƿ���� ������ڲ����쳣
		if(p !=null)
			throw new ProductExistException("��Ʒ�Ѵ���");
		//4.������Ʒ��Ϣ
		dao.insertProduct(pro);
	}

	//ɾ����Ʒ
	public void removeProduct(Product pro) throws DAOException,
			ProductNotExistException {
		//1.��ȡDAO
		ProductDAO dao = (ProductDAO)DAOFactory.newInstance(KEY);
		//2.����id��ѯ��Ʒ����
		Product p = dao.queryById(pro.getPid());
		//3.�ж�p�Ƿ���� ��������ڲ����쳣
		if(p == null)
			throw new ProductNotExistException("��Ʒ������");
		//4.������Ʒ��Ϣ
		dao.deleteProduct(pro.getPid());
	}

	//�޸���Ʒ��Ϣ
	public void updateByProductInfo(int pid, String name, int isVal)
			throws DAOException, ProductNotExistException {
		//1.��ȡDAO
		ProductDAO dao = (ProductDAO)DAOFactory.newInstance(KEY);
		//2.���ݲ��ز�ѯ��Ʒ
		Product pro = dao.queryById(pid);
		//3.�ж�list�Ƿ�Ϊ��
		if(pro == null)
			throw new ProductNotExistException("��Ʒ�����ڣ�");
	    //4.������Ʒ��Ϣ
		pro.setPname(name);
		pro.setIsval(isVal);
	}

	//��ȡ������Ʒ
	public List<Product> searchAllProduct() throws DAOException,
			ProductNotExistException {
		//1.��ȡDAO
		ProductDAO dao = (ProductDAO)DAOFactory.newInstance(KEY);
		//2.���ݲ��ز�ѯ��Ʒ
		List<Product> list = dao.queryAllProduct();
		//3.�ж�list�Ƿ�Ϊ��
		if(list.size() == 0)
			throw new ProductNotExistException("��Ʒ�����ڣ�");
		//4.������Ʒ��Ϣ
	    return list;
	}

	//������Ʒ��� ��ȡ��Ʒ
	public Product searchProductById(int id) throws DAOException,
			ProductNotExistException {
		//1.��ȡDAO
		ProductDAO dao = (ProductDAO)DAOFactory.newInstance(KEY);
		//2.���ݲ��ز�ѯ��Ʒ
		Product pro = dao.queryById(id);
		//3.�ж�list�Ƿ�Ϊ��
		if(pro == null)
			throw new ProductNotExistException("��Ʒ�����ڣ�");
		//4.������Ʒ��Ϣ
	    return pro;
	}

	//������Ʒ�� ��ȡ��Ʒ
	public Product searchProductByPname(String pname) throws DAOException,
			ProductNotExistException {
		//1.��ȡDAO
		ProductDAO dao = (ProductDAO)DAOFactory.newInstance(KEY);
		//2.���ݲ��ز�ѯ��Ʒ
		Product pro = dao.queryByPname(pname);
		//3.�ж�list�Ƿ�Ϊ��
		if(pro == null)
			throw new ProductNotExistException("��Ʒ�����ڣ�");
		//4.������Ʒ��Ϣ
	    return pro;
	}

}
