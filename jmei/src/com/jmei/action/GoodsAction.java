package com.jmei.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jmei.bean.Buser;
import com.jmei.bean.Effect;
import com.jmei.bean.Goods;
import com.jmei.bean.GoodsToType;
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
 * method=type 通过类型查询商品
 * method=effect 通过功效查询商品
 * method=buser 通过企业品牌查询商品
 * method=price 通过价格段查询商品
 * method=priceDesc 通过商品的价格降序查询
 * method=saleDesc 通过商品的销量降序查询
 * method=colDesc 通过商品的人气（收藏量）查询
 * method=account 结账
 * method = setKey 保存搜索的关键字
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
		}else if("type".equals(method)){
			searchByType(req,resp);
		}else if("effect".equals(method)){
			searchByEffect(req,resp);
		}else if("buser".equals(method)){
			searchByBuser(req,resp);
		}else if("price".equals(method)){
			searchByPriceArea(req,resp);
		}else if("priceDesc".equals(method)){
			priceDesc(req,resp);
		}else if("saleDesc".equals(method)){
			saleDesc(req,resp);
		}else if("colDesc".equals(method)){
			colDesc(req,resp);
		}else if("account".equals(method)){
			account(req,resp);
		}else if("setKey".equals(method)){
			setKey(req,resp);
		}
	}

	/**
	 * 保存搜索的关键字
	 * @param req
	 * @param resp
	 */
	private void setKey(HttpServletRequest req, HttpServletResponse resp) {
		BufferedReader buf = null;
		try {
			buf = req.getReader();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String key = null;
		try {
			key = buf.readLine();
			//key = new String(key.getBytes("ISO-8859-1")."utf-8");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] keys = key.split("=");
		key = keys[1];
		//获得session
		HttpSession session = req.getSession();
		if(key != null && !"".equals(key)){
			session.setAttribute("skey", key);
		}
		System.out.println("key:"+key);
	}

	/**
	 * 对商品进行结账
	 * @param req 用户的请求
 	 * @param resp 服务端做出的响应
	 */
	private void account(HttpServletRequest req, HttpServletResponse resp) {
		
	}

	/**
	 * 通过商品的收藏量对商品进行降序
	 * @param req 用户的请求
	 * @param resp 服务端做出的响应
	 */
	private void colDesc(HttpServletRequest req, HttpServletResponse resp) {
		//获得session
		HttpSession session = req.getSession();
		//获得处理商品的services
		GoodsServices gservice = (GoodsServices) ServiceFactory.newInstance(GOODSKEY);
		//获得待筛选的商品集合
		List<Goods> goodslist = (List<Goods>) session.getAttribute("goodslist");
		PicService picservice = (PicService) ServiceFactory.newInstance(PICKEY);
	}

	/**通过商品的销量对商品进行降序
	 * @param req 用户的请求
	 * @param resp 服务端做出的响应
	 */
	private void saleDesc(HttpServletRequest req, HttpServletResponse resp) {
		//获得session
		HttpSession session = req.getSession();
		//获得处理商品的services
		GoodsServices gservice = (GoodsServices) ServiceFactory.newInstance(GOODSKEY);
		//获得待筛选的商品集合
		List<Goods> goodslist = (List<Goods>) session.getAttribute("goodslist");
		PicService picservice = (PicService) ServiceFactory.newInstance(PICKEY);
		try {
			goodslist = gservice.orderBySaleVol(goodslist);
			session.setAttribute("goodslist", goodslist);
			//查找对应的图片
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
			//重定向到searchResult.jsp
			resp.sendRedirect(req.getContextPath()+"/view/searchResult.jsp");
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchGoodsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PicNotExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 通过商品的价格降序排序
	 * @param req 用户的请求
	 * @param resp 服务端的响应
	 */
	private void priceDesc(HttpServletRequest req, HttpServletResponse resp) {
		//获得session
		HttpSession session = req.getSession();
		//获得处理商品的services
		GoodsServices gservice = (GoodsServices) ServiceFactory.newInstance(GOODSKEY);
		//获得待筛选的商品集合
		List<Goods> goodslist = (List<Goods>) session.getAttribute("goodslist");
		PicService picservice = (PicService) ServiceFactory.newInstance(PICKEY);
		try {
			goodslist = gservice.orderByPriDesc(goodslist);
			session.setAttribute("goodslist", goodslist);
			//查找对应的图片
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
			//重定向到searchResult.jsp
			resp.sendRedirect(req.getContextPath()+"/view/searchResult.jsp");
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchGoodsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PicNotExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 通过价格段筛选商品
	 * @param req 用户的请求
	 * @param resp 服务端的响应
	 */
	private void searchByPriceArea(HttpServletRequest req,
			HttpServletResponse resp) {
		//获得价格段
		String low = req.getParameter("low");
		String high = req.getParameter("high");
		//获得session
		HttpSession session = req.getSession();
		//获得处理商品的services
		GoodsServices gservice = (GoodsServices) ServiceFactory.newInstance(GOODSKEY);
		//获得待筛选的商品集合
		List<Goods> goodslist = (List<Goods>) session.getAttribute("goodslist");
		PicService picservice = (PicService) ServiceFactory.newInstance(PICKEY);
		try {
			//获得筛选后的商品
			goodslist = gservice.searchByPriArea(goodslist, Integer.parseInt(low), Integer.parseInt(high));
			session.setAttribute("goodslist", goodslist);
			//查找对应的图片
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
			//重定向到searchResult.jsp
			resp.sendRedirect(req.getContextPath()+"/view/searchResult.jsp");
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
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 通过品牌查询商品
	 * @param req 用户的请求
	 * @param resp 服务端的响应
	 */
	private void searchByBuser(HttpServletRequest req, HttpServletResponse resp) {
		//获得选择的品牌
		String buser = req.getParameter("buser");
		//获得分页
		String curPage = req.getParameter("curPage");
		//对get请求转码
		try {
			buser = new String(buser.getBytes("ISO-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//获得session对象
		HttpSession session = req.getSession();
		//获得处理逻辑的services对象
		GoodsServices gservice = (GoodsServices) ServiceFactory.newInstance(GOODSKEY);
		PicService picservice = (PicService) ServiceFactory.newInstance(PICKEY);
		try {
			//获得查询后的商品
			List<Goods> buserlist = gservice.searchGoodsByBname(buser);
			session.setAttribute("goodslist", buserlist);
			//获得商品总数量
			int size = buserlist.size();
			//设置分页数量
			int pageCount = (size%12==0)?(size/12):(size/12+1);
			session.setAttribute("pageCount", pageCount);
			
			//查出商品对应的图片
			ArrayList<Pic> piclist = new ArrayList<Pic>();
			for(Goods g:buserlist){
				List<Pic> list = picservice.searchAllMibPicByGid(g);
				if(list != null && list.size() > 0){
					piclist.add(list.get(0));
				}else{
					piclist.add(new Pic());
				}
			}
			session.setAttribute("piclist", piclist);
			//重定向到searchResult.jsp
			resp.sendRedirect(req.getContextPath()+"/view/searchResult.jsp");
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchGoodsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PicNotExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 通过商品的功效筛选商品
	 * @param req 用户的请求
	 * @param resp 服务器端的响应
	 */
	private void searchByEffect(HttpServletRequest req, HttpServletResponse resp) {
		//获得商品的功效
		String effect = req.getParameter("effect");
		//获得分页信息
		String curPage = req.getParameter("curPage");
		//设置编码集
		try {
			effect = new String(effect.getBytes("ISO-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//获得session
		HttpSession session = req.getSession();
		//获得待筛选的商品集合
		List<Goods> goodslist = (List<Goods>) session.getAttribute("goodslist");
		//获得处理的逻辑的service对象
		GoodsServices eservices = (GoodsServices) ServiceFactory.newInstance(GOODSKEY);
		PicService picservice = (PicService) ServiceFactory.newInstance(PICKEY);
		try {
			//获得筛选后的商品集合
			List<Goods> effectlist = eservices.searchGoodsByEffect(effect, goodslist);
			session.setAttribute("goodslist", effectlist);
			//设置分页查询
			if(curPage == null){
				session.setAttribute("curPage", 0);
			}else{
				session.setAttribute("curPage", curPage);
			}
			//获得商品总数量
			int size = effectlist.size();
			//设置分页总数
			int pageCount = (size%12==0)?(size/12):(size/12+1);
			session.setAttribute("pageCount", pageCount);
			
			//查出商品对应的图片
			ArrayList<Pic> piclist = new ArrayList<Pic>();
			for(Goods g:effectlist){
				List<Pic> list = picservice.searchAllMibPicByGid(g);
				if(list != null && list.size() > 0){
					piclist.add(list.get(0));
				}else{
					piclist.add(new Pic());
				}
			}
			session.setAttribute("piclist", piclist);
			//重定向到searchResult.jsp页面
			resp.sendRedirect(req.getContextPath()+"/view/searchResult.jsp");
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchGoodsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PicNotExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 通过商品的类型查询商品
	 * @param req 用户的请求
	 * @param resp 服务端做出的响应
	 * @throws IOException 
	 */
	private void searchByType(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//获取商品的类型
		String type = req.getParameter("type");
		//设置编码集
		type = new String(type.getBytes("ISO-8859-1"),"utf-8");
		//分页处理
		String curPage = req.getParameter("curPage");
		if(curPage == null){
			curPage = "0";
		}
		//获得session
		HttpSession session = req.getSession();
		//获得session中的goodslist集合
		List<Goods> goodslist = (List<Goods>) session.getAttribute("goodslist");
		//创建service对象
		GoodsServices gtype = (GoodsServices) ServiceFactory.newInstance(GOODSKEY);
		PicService picservice = (PicService) ServiceFactory.newInstance(PICKEY);
		try {
			//查询符合条件商品对象
			List<Goods> typelist = gtype.searchGoodsByType(type, goodslist);
			//将转换的对象放入session
			session.setAttribute("goodslist", typelist);
			//对搜索的商品进行分页处理
			session.setAttribute("curPage", curPage);
			//得到商品的总数
			int size = typelist.size();
			//每页放置12个商品，计算出可以分几页
			int pageCount = (size%12==0)?(size/12):(size/12+1);
			//将结果放置到session
			session.setAttribute("pageCount", pageCount);
			//查出商品对应的图片
			ArrayList<Pic> piclist = new ArrayList<Pic>();
			for(Goods g:typelist){
				List<Pic> list = picservice.searchAllMibPicByGid(g);
				if(list != null && list.size() > 0){
					piclist.add(list.get(0));
				}else{
					piclist.add(new Pic());
				}
			}
			session.setAttribute("piclist", piclist);
			//重定向到商品结果显示页面
			resp.sendRedirect(req.getContextPath()+"/view/searchResult.jsp");
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

	/**
	 * 提供单个商品展示页面的数据
	 * @param req 用户发送的请求
	 * @param resp 服务端的响应
	 * @throws IOException 
	 */
	private void goodsPlay(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("utf-8");
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
		req.setCharacterEncoding("utf-8");
		//获取的数据
		String key = req.getParameter("searchKey");
		key = new String(key.getBytes("ISO-8859-1"),"utf-8");
		String curPage = req.getParameter("curPage");
		if(curPage == null){
			curPage = "0";
		}
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
			session.setAttribute("curPage", curPage);
			//得到商品的总数
			int size = goodslist.size();
			//每页放置12个商品，计算出可以分几页
			int pageCount = (size%12==0)?(size/12):(size/12+1);
			//将结果放置到session
			session.setAttribute("pageCount", pageCount);
			
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
