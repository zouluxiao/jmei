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
 * ʵ�ֹ��ﳵ����Ʒ����
 * @author ����
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
	 * ����Ʒ���빺�ﳵ
	 * @param req �û�������
	 * @param resp ����˵���Ӧ
	 */
	private void addGoodsToCart(HttpServletRequest req, HttpServletResponse resp) {
		//�����Ʒ�ı��
		String gid = req.getParameter("gid");
		System.out.println("ajax����,gidΪ��"+gid);
		//���session�еĹ��ﳵ
		HttpSession session = req.getSession();
		//�����Ʒ��ͼƬservice
		PicService ps = (PicService) ServiceFactory.newInstance(PICKEY);
		//��ô�����Ʒ��services
		GoodsServices gs = (GoodsServices) ServiceFactory.newInstance(GOODSKEY);
		//�����Ʒ
		try {
			Goods g = gs.searchGoodsByGid(Integer.parseInt(gid));
			//�����Ʒ��ͼƬ
			Pic pic = new Pic();
			List<Pic> picList = (List<Pic>) ps.searchAllMibPicByGid(g);
			if(picList != null && picList.size() > 0){
				pic = picList.get(0);
			}
			//��ù��ﳵ
			ShoppingCart car = (ShoppingCart) session.getAttribute("ShoppingCart");
			if(car == null){
				ArrayList<Goods> arr = new ArrayList<Goods>();
				car = new ShoppingCart(arr,0);
			}
			car.getGoodsCart().add(g);
			System.out.println("GoodsCart:"+car.getGoodsCart());
			//���õ�session
			session.setAttribute("ShoppingCart", car);
			//��ù��ﳵ��ƷͼƬ
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
