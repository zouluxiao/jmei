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
 * method=searchGoods ͨ���ؼ��ֲ�ѯ��Ʒ
 * method=goods ͨ���ؼ��ֲ���Ҫ��ʾ��ĳ����Ʒ
 * method=type ͨ�����Ͳ�ѯ��Ʒ
 * method=effect ͨ����Ч��ѯ��Ʒ
 * method=buser ͨ����ҵƷ�Ʋ�ѯ��Ʒ
 * method=price ͨ���۸�β�ѯ��Ʒ
 * method=priceDesc ͨ����Ʒ�ļ۸����ѯ
 * method=saleDesc ͨ����Ʒ�����������ѯ
 * method=colDesc ͨ����Ʒ���������ղ�������ѯ
 * method=account ����
 * method = setKey ���������Ĺؼ���
 * @author ����
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
	 * ���������Ĺؼ���
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
		//���session
		HttpSession session = req.getSession();
		if(key != null && !"".equals(key)){
			session.setAttribute("skey", key);
		}
		System.out.println("key:"+key);
	}

	/**
	 * ����Ʒ���н���
	 * @param req �û�������
 	 * @param resp �������������Ӧ
	 */
	private void account(HttpServletRequest req, HttpServletResponse resp) {
		
	}

	/**
	 * ͨ����Ʒ���ղ�������Ʒ���н���
	 * @param req �û�������
	 * @param resp �������������Ӧ
	 */
	private void colDesc(HttpServletRequest req, HttpServletResponse resp) {
		//���session
		HttpSession session = req.getSession();
		//��ô�����Ʒ��services
		GoodsServices gservice = (GoodsServices) ServiceFactory.newInstance(GOODSKEY);
		//��ô�ɸѡ����Ʒ����
		List<Goods> goodslist = (List<Goods>) session.getAttribute("goodslist");
		PicService picservice = (PicService) ServiceFactory.newInstance(PICKEY);
	}

	/**ͨ����Ʒ����������Ʒ���н���
	 * @param req �û�������
	 * @param resp �������������Ӧ
	 */
	private void saleDesc(HttpServletRequest req, HttpServletResponse resp) {
		//���session
		HttpSession session = req.getSession();
		//��ô�����Ʒ��services
		GoodsServices gservice = (GoodsServices) ServiceFactory.newInstance(GOODSKEY);
		//��ô�ɸѡ����Ʒ����
		List<Goods> goodslist = (List<Goods>) session.getAttribute("goodslist");
		PicService picservice = (PicService) ServiceFactory.newInstance(PICKEY);
		try {
			goodslist = gservice.orderBySaleVol(goodslist);
			session.setAttribute("goodslist", goodslist);
			//���Ҷ�Ӧ��ͼƬ
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
			//�ض���searchResult.jsp
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
	 * ͨ����Ʒ�ļ۸�������
	 * @param req �û�������
	 * @param resp ����˵���Ӧ
	 */
	private void priceDesc(HttpServletRequest req, HttpServletResponse resp) {
		//���session
		HttpSession session = req.getSession();
		//��ô�����Ʒ��services
		GoodsServices gservice = (GoodsServices) ServiceFactory.newInstance(GOODSKEY);
		//��ô�ɸѡ����Ʒ����
		List<Goods> goodslist = (List<Goods>) session.getAttribute("goodslist");
		PicService picservice = (PicService) ServiceFactory.newInstance(PICKEY);
		try {
			goodslist = gservice.orderByPriDesc(goodslist);
			session.setAttribute("goodslist", goodslist);
			//���Ҷ�Ӧ��ͼƬ
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
			//�ض���searchResult.jsp
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
	 * ͨ���۸��ɸѡ��Ʒ
	 * @param req �û�������
	 * @param resp ����˵���Ӧ
	 */
	private void searchByPriceArea(HttpServletRequest req,
			HttpServletResponse resp) {
		//��ü۸��
		String low = req.getParameter("low");
		String high = req.getParameter("high");
		//���session
		HttpSession session = req.getSession();
		//��ô�����Ʒ��services
		GoodsServices gservice = (GoodsServices) ServiceFactory.newInstance(GOODSKEY);
		//��ô�ɸѡ����Ʒ����
		List<Goods> goodslist = (List<Goods>) session.getAttribute("goodslist");
		PicService picservice = (PicService) ServiceFactory.newInstance(PICKEY);
		try {
			//���ɸѡ�����Ʒ
			goodslist = gservice.searchByPriArea(goodslist, Integer.parseInt(low), Integer.parseInt(high));
			session.setAttribute("goodslist", goodslist);
			//���Ҷ�Ӧ��ͼƬ
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
			//�ض���searchResult.jsp
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
	 * ͨ��Ʒ�Ʋ�ѯ��Ʒ
	 * @param req �û�������
	 * @param resp ����˵���Ӧ
	 */
	private void searchByBuser(HttpServletRequest req, HttpServletResponse resp) {
		//���ѡ���Ʒ��
		String buser = req.getParameter("buser");
		//��÷�ҳ
		String curPage = req.getParameter("curPage");
		//��get����ת��
		try {
			buser = new String(buser.getBytes("ISO-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//���session����
		HttpSession session = req.getSession();
		//��ô����߼���services����
		GoodsServices gservice = (GoodsServices) ServiceFactory.newInstance(GOODSKEY);
		PicService picservice = (PicService) ServiceFactory.newInstance(PICKEY);
		try {
			//��ò�ѯ�����Ʒ
			List<Goods> buserlist = gservice.searchGoodsByBname(buser);
			session.setAttribute("goodslist", buserlist);
			//�����Ʒ������
			int size = buserlist.size();
			//���÷�ҳ����
			int pageCount = (size%12==0)?(size/12):(size/12+1);
			session.setAttribute("pageCount", pageCount);
			
			//�����Ʒ��Ӧ��ͼƬ
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
			//�ض���searchResult.jsp
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
	 * ͨ����Ʒ�Ĺ�Чɸѡ��Ʒ
	 * @param req �û�������
	 * @param resp �������˵���Ӧ
	 */
	private void searchByEffect(HttpServletRequest req, HttpServletResponse resp) {
		//�����Ʒ�Ĺ�Ч
		String effect = req.getParameter("effect");
		//��÷�ҳ��Ϣ
		String curPage = req.getParameter("curPage");
		//���ñ��뼯
		try {
			effect = new String(effect.getBytes("ISO-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//���session
		HttpSession session = req.getSession();
		//��ô�ɸѡ����Ʒ����
		List<Goods> goodslist = (List<Goods>) session.getAttribute("goodslist");
		//��ô�����߼���service����
		GoodsServices eservices = (GoodsServices) ServiceFactory.newInstance(GOODSKEY);
		PicService picservice = (PicService) ServiceFactory.newInstance(PICKEY);
		try {
			//���ɸѡ�����Ʒ����
			List<Goods> effectlist = eservices.searchGoodsByEffect(effect, goodslist);
			session.setAttribute("goodslist", effectlist);
			//���÷�ҳ��ѯ
			if(curPage == null){
				session.setAttribute("curPage", 0);
			}else{
				session.setAttribute("curPage", curPage);
			}
			//�����Ʒ������
			int size = effectlist.size();
			//���÷�ҳ����
			int pageCount = (size%12==0)?(size/12):(size/12+1);
			session.setAttribute("pageCount", pageCount);
			
			//�����Ʒ��Ӧ��ͼƬ
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
			//�ض���searchResult.jspҳ��
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
	 * ͨ����Ʒ�����Ͳ�ѯ��Ʒ
	 * @param req �û�������
	 * @param resp �������������Ӧ
	 * @throws IOException 
	 */
	private void searchByType(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//��ȡ��Ʒ������
		String type = req.getParameter("type");
		//���ñ��뼯
		type = new String(type.getBytes("ISO-8859-1"),"utf-8");
		//��ҳ����
		String curPage = req.getParameter("curPage");
		if(curPage == null){
			curPage = "0";
		}
		//���session
		HttpSession session = req.getSession();
		//���session�е�goodslist����
		List<Goods> goodslist = (List<Goods>) session.getAttribute("goodslist");
		//����service����
		GoodsServices gtype = (GoodsServices) ServiceFactory.newInstance(GOODSKEY);
		PicService picservice = (PicService) ServiceFactory.newInstance(PICKEY);
		try {
			//��ѯ����������Ʒ����
			List<Goods> typelist = gtype.searchGoodsByType(type, goodslist);
			//��ת���Ķ������session
			session.setAttribute("goodslist", typelist);
			//����������Ʒ���з�ҳ����
			session.setAttribute("curPage", curPage);
			//�õ���Ʒ������
			int size = typelist.size();
			//ÿҳ����12����Ʒ����������Էּ�ҳ
			int pageCount = (size%12==0)?(size/12):(size/12+1);
			//��������õ�session
			session.setAttribute("pageCount", pageCount);
			//�����Ʒ��Ӧ��ͼƬ
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
			//�ض�����Ʒ�����ʾҳ��
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
	 * �ṩ������Ʒչʾҳ�������
	 * @param req �û����͵�����
	 * @param resp ����˵���Ӧ
	 * @throws IOException 
	 */
	private void goodsPlay(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("utf-8");
		//�õ��������ƷID
		String gid = req.getParameter("gid");
		//���session
		HttpSession session = req.getSession();
		//ͨ����Ʒ�ı�Ų�ѯ��Ʒ�Ĵ�ͼ
		PicService picservice = (PicService) ServiceFactory.newInstance(PICKEY);
		//ͨ����Ʒ�ı�Ų�ѯ��Ʒ��������ҵ
		GoodsServices goodservice = (GoodsServices) ServiceFactory.newInstance(GOODSKEY);
		
		try {
			//��ô�ͼ
			Goods g = new Goods();
			g.setGid(Integer.parseInt(gid));
			List list = picservice.searchAllBigPicByGid(g);
			Pic pic = null;
			if(list != null && list.size() > 0){
				pic = (Pic) list.get(0);
			}
			session.setAttribute("BigPic", pic);
			//�����Ʒ��
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
	 * ͨ���ؼ���������ѯ��Ʒ
	 * @param req �û�������
	 * @param resp �������������Ӧ
	 * @throws IOException 
	 */
	private void searchByKey(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("utf-8");
		//��ȡ������
		String key = req.getParameter("searchKey");
		key = new String(key.getBytes("ISO-8859-1"),"utf-8");
		String curPage = req.getParameter("curPage");
		if(curPage == null){
			curPage = "0";
		}
		//���session
		HttpSession session = req.getSession();
		GoodsServices goodservice = (GoodsServices) ServiceFactory.newInstance(GOODSKEY);
		GtypeService typeservice = (GtypeService) ServiceFactory.newInstance(TYPEKEY);
		BuserService buserservice = (BuserService) ServiceFactory.newInstance(BUSERKEY);
		EffectService effectService = (EffectService) ServiceFactory.newInstance(EFFECTKEY);
		PicService picservice = (PicService) ServiceFactory.newInstance(PICKEY);
		try {
			//��ѯ����
			List<Gtype> typelist = typeservice.searchGtypes();
			session.setAttribute("typelist", typelist);
			//��ѯ��Ч
			List<Effect> effectlist = effectService.searchAllEffect();
			session.setAttribute("effectlist", effectlist);
			//��ѯƷ��
			List<Buser> buserlist = buserservice.searchAllBusiness();
			session.setAttribute("buserlist", buserlist);
			//��ѯ��Ʒ
			List<Goods> goodslist = goodservice.searchGoodsByDetail(key);
			session.setAttribute("goodslist", goodslist);
			//����������Ʒ���з�ҳ����
			session.setAttribute("curPage", curPage);
			//�õ���Ʒ������
			int size = goodslist.size();
			//ÿҳ����12����Ʒ����������Էּ�ҳ
			int pageCount = (size%12==0)?(size/12):(size/12+1);
			//��������õ�session
			session.setAttribute("pageCount", pageCount);
			
			//�����Ʒ��Ӧ��ͼƬ
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
			//�ض����������ҳ��
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
