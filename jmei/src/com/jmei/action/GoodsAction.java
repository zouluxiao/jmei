package com.jmei.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jmei.bean.Buser;
import com.jmei.bean.Effect;
import com.jmei.bean.Goods;
import com.jmei.bean.Gtype;
import com.jmei.bean.Pic;
import com.jmei.exception.DAOException;
import com.jmei.exception.EffectNotExistException;
import com.jmei.exception.GtypeNotExistException;
import com.jmei.exception.NoBuserException;
import com.jmei.exception.NoSuchGoodsException;
import com.jmei.exception.PicNotExistException;
import com.jmei.factory.ServiceFactory;
import com.jmei.service.BuserService;
import com.jmei.service.EffectService;
import com.jmei.service.GoodsServices;
import com.jmei.service.GtypeService;
import com.jmei.service.PicService;

/**
 * method=searchGoods 通过关键字查询商品
 * method=goods 通过关键字查找要显示的某个商品
 * @author 汤亮
 *	2016-04-29
 */
public class GoodsAction implements Action {
	private static final String GOODSKEY = "GoodsServiceImpl";
	private static final String TYPEKEY = "GtypeServiceImpl";
	private static final String BUSERKEY = "BuserServiceImpl";
	private static final String EFFECTKEY = "EffectServiceImpl";
	private static final String PICKEY = "PicServiceImpl";
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		String method = req.getParameter("method");
		if("searchGoods".equals(method)){
			searchByKey(req,resp);
		}else if("goods".equals(method)){
			goodsPlay(req,resp);
		}
	}

	/**
	 * 提供单个商品展示页面的数据
	 * @param req 用户发送的请求
	 * @param resp 服务端的响应
	 * @throws IOException 
	 */
	private void goodsPlay(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//拿到请求的商品ID
		String gid = req.getParameter("gid");
		//获得session
		HttpSession session = req.getSession();
		//通过商品的编号查询商品的大图
		PicService picservice = (PicService) ServiceFactory.newInstance(PICKEY);
		//通过商品的编号查询商品的所属企业
		GoodsServices goodservice = (GoodsServices) ServiceFactory.newInstance(GOODSKEY);
		try {
			//获得大图
			Goods g = new Goods();
			g.setGid(Integer.parseInt(gid));
			List list = picservice.searchAllBigPicByGid(g);
			Pic pic = null;
			if(list != null && list.size() > 0){
				pic = (Pic) list.get(0);
			}
			session.setAttribute("BigPic", pic);
			//获得商品类
			Goods goods = goodservice.searchGoodsByGid(Integer.parseInt(gid));
			session.setAttribute("goods", goods);
			resp.sendRedirect(req.getContextPath()+"/view/goods.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PicNotExistException e) {
			session.setAttribute("PIC_ERROR", e.getMessage());
			resp.sendRedirect(req.getContextPath()+"/NoSuchPICserror.jsp");
		} catch (NumberFormatException e) {
			session.setAttribute("GOODS_ERROR", e.getMessage());
			resp.sendRedirect(req.getContextPath()+"/NoSuchgoodserror.jsp");
		} catch (NoSuchGoodsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * 通过关键字搜索查询商品
	 * @param req 用户的请求
	 * @param resp 服务端做出的响应
	 * @throws IOException 
	 */
	private void searchByKey(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//获取的数据
		String key = req.getParameter("searchKey");
		//获得session
		HttpSession session = req.getSession();
		
		
		GoodsServices goodservice = (GoodsServices) ServiceFactory.newInstance(GOODSKEY);
		GtypeService typeservice = (GtypeService) ServiceFactory.newInstance(TYPEKEY);
		BuserService buserservice = (BuserService) ServiceFactory.newInstance(BUSERKEY);
		EffectService effectService = (EffectService) ServiceFactory.newInstance(EFFECTKEY);
		PicService picservice = (PicService) ServiceFactory.newInstance(PICKEY);
		try {
			//查询分类
			List<Gtype> typelist = typeservice.searchGtypes();
			session.setAttribute("typelist", typelist);
			//查询功效
			List<Effect> effectlist = effectService.searchAllEffect();
			session.setAttribute("effectlist", effectlist);
			//查询品牌
			List<Buser> buserlist = buserservice.searchAllBusiness();
			session.setAttribute("buserlist", buserlist);
			//查询商品
			List<Goods> goodslist = goodservice.searchGoodsByDetail(key);
			session.setAttribute("goodslist", goodslist);
			//对搜索的商品进行分页处理
			//得到商品的总数
			int size = goodslist.size();
			//每页放置36个商品，计算出可以分几页
			int pageCount = (size%36==0)?(size/36):(size/36+1);
			//将结果放置到session
			session.setAttribute("pageCount", pageCount);
			session.setAttribute("36",36);
			
			//查出商品对应的图片
			ArrayList<Pic> piclist = new ArrayList<Pic>();
			for(Goods g:goodslist){
				List<Pic> list = picservice.searchAllMibPicByGid(g);
				if(list != null && list.size() > 0){
					piclist.add(list.get(0));
				}else{
					piclist.add(new Pic());
				}
			}
			session.setAttribute("piclist", piclist);
			//重定向到搜索结果页面
			resp.sendRedirect(req.getContextPath()+"/view/searchResult.jsp");
		} catch (DAOException e) {
			session.setAttribute("GOODS_ERROR", e.getMessage());
			resp.sendRedirect(req.getContextPath()+"GoodsDAOerror.jsp");
		} catch (NoSuchGoodsException e) {
			session.setAttribute("GOODS_ERROR", e.getMessage());
			resp.sendRedirect(req.getContextPath()+"/NoSuchgoodserror.jsp");
		} catch (IOException e) {
			session.setAttribute("GOODS_ERROR", e.getMessage());
			resp.sendRedirect(req.getContextPath()+"/IOgoodserror.jsp");
		} catch (GtypeNotExistException e) {
			session.setAttribute("TYPE_ERROR", e.getMessage());
			resp.sendRedirect(req.getContextPath()+"/typeerror.jsp");
		} catch (EffectNotExistException e) {
			session.setAttribute("EFFECT_ERROR", e.getMessage());
			resp.sendRedirect(req.getContextPath()+"/effecterror.jsp");
		} catch (NoBuserException e) {
			session.setAttribute("BUSER_ERROR", e.getMessage());
			resp.sendRedirect(req.getContextPath()+"/busererror.jsp");
		} catch (PicNotExistException e) {
			session.setAttribute("GOODSPIC_ERROR", e.getMessage());
			resp.sendRedirect(req.getContextPath()+"/goodsPicerror.jsp");
		}
	}

}
