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
 * ProductService接口实现类
 * @since 2016-04-27
 * @author 阳桂东
 * **/
public class ProductServiceImpl implements ProductService {
	private  final String  KEY ="ProductDAOImpl";
	//添加商品 
	public void addProduct(Product pro) throws DAOException,
			ProductExistException {
		//1.获取DAO
		ProductDAO dao = (ProductDAO)DAOFactory.newInstance(KEY);
		//2.根据id查询商品对象
		Product p = dao.queryById(pro.getPid());
		//3.判断p是否存在 如果存在产生异常
		if(p !=null)
			throw new ProductExistException("商品已存在");
		//4.插入商品信息
		dao.insertProduct(pro);
	}

	//删除商品
	public void removeProduct(Product pro) throws DAOException,
			ProductNotExistException {
		//1.获取DAO
		ProductDAO dao = (ProductDAO)DAOFactory.newInstance(KEY);
		//2.根据id查询商品对象
		Product p = dao.queryById(pro.getPid());
		//3.判断p是否存在 如果不存在产生异常
		if(p == null)
			throw new ProductNotExistException("商品不存在");
		//4.插入商品信息
		dao.deleteProduct(pro.getPid());
	}

	//修改商品信息
	public void updateByProductInfo(int pid, String name, int isVal)
			throws DAOException, ProductNotExistException {
		//1.获取DAO
		ProductDAO dao = (ProductDAO)DAOFactory.newInstance(KEY);
		//2.根据产地查询商品
		Product pro = dao.queryById(pid);
		//3.判断list是否为空
		if(pro == null)
			throw new ProductNotExistException("商品不存在！");
	    //4.更新商品信息
		pro.setPname(name);
		pro.setIsval(isVal);
	}

	//获取所有商品
	public List<Product> searchAllProduct() throws DAOException,
			ProductNotExistException {
		//1.获取DAO
		ProductDAO dao = (ProductDAO)DAOFactory.newInstance(KEY);
		//2.根据产地查询商品
		List<Product> list = dao.queryAllProduct();
		//3.判断list是否为空
		if(list.size() == 0)
			throw new ProductNotExistException("商品不存在！");
		//4.返回商品信息
	    return list;
	}

	//根据商品编号 获取商品
	public Product searchProductById(int id) throws DAOException,
			ProductNotExistException {
		//1.获取DAO
		ProductDAO dao = (ProductDAO)DAOFactory.newInstance(KEY);
		//2.根据产地查询商品
		Product pro = dao.queryById(id);
		//3.判断list是否为空
		if(pro == null)
			throw new ProductNotExistException("商品不存在！");
		//4.返回商品信息
	    return pro;
	}

	//根据商品名 获取商品
	public Product searchProductByPname(String pname) throws DAOException,
			ProductNotExistException {
		//1.获取DAO
		ProductDAO dao = (ProductDAO)DAOFactory.newInstance(KEY);
		//2.根据产地查询商品
		Product pro = dao.queryByPname(pname);
		//3.判断list是否为空
		if(pro == null)
			throw new ProductNotExistException("商品不存在！");
		//4.返回商品信息
	    return pro;
	}

}
