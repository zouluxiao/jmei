package com.jmei.action;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jmei.bean.Goods;
import com.jmei.bean.Pic;
import com.jmei.bean.ShoppingCart;
import com.jmei.exception.DAOException;
import com.jmei.exception.NoSuchGoodsException;
import com.jmei.exception.PicNotExistException;
import com.jmei.factory.ServiceFactory;
import com.jmei.service.GoodsServices;
import com.jmei.service.PicService;

/**
 * 实现购物车的商品处理
 * @author 汤亮
 * @since 2016-05-01
 */
public class ShoppingCartAction implements Action{
	private static final String GOODSKEY = "GoodsServiceImpl";
	private static final String PICKEY = "PicServiceImpl";
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		String method = req.getParameter("method");
		if("add".equals(method)){
			addGoodsToCart(req,resp);
		}
	}

	/**
	 * 将商品加入购物车
	 * @param req 用户的请求
	 * @param resp 服务端的响应
	 */
	private void addGoodsToCart(HttpServletRequest req, HttpServletResponse resp) {
		//获得商品的编号
		String gid = req.getParameter("gid");
		System.out.println("ajax进入,gid为："+gid);
		//获得session中的购物车
		HttpSession session = req.getSession();
		//获得商品的图片service
		PicService ps = (PicService) ServiceFactory.newInstance(PICKEY);
		//获得处理商品的services
		GoodsServices gs = (GoodsServices) ServiceFactory.newInstance(GOODSKEY);
		//获得商品
		try {
			Goods g = gs.searchGoodsByGid(Integer.parseInt(gid));
			//获得商品的图片
			Pic pic = new Pic();
			List<Pic> picList = (List<Pic>) ps.searchAllMibPicByGid(g);
			if(picList != null && picList.size() > 0){
				pic = picList.get(0);
			}
			//获得购物车
			ShoppingCart car = (ShoppingCart) session.getAttribute("ShoppingCart");
			if(car == null){
				ArrayList<Goods> arr = new ArrayList<Goods>();
				car = new ShoppingCart(arr,0);
			}
			car.getGoodsCart().add(g);
			System.out.println("GoodsCart:"+car.getGoodsCart());
			//放置到session
			session.setAttribute("ShoppingCart", car);
			//获得购物车商品图片
			List<Pic> pl = (List<Pic>) session.getAttribute("pl");
			if(pl == null){
				pl = new ArrayList<Pic>();
			}
			pl.add(pic);
			session.setAttribute("pl", pl);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchGoodsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PicNotExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
