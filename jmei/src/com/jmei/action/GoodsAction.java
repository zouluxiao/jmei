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
 * method=searchGoods ͨ���ؼ��ֲ�ѯ��Ʒ
 * method=goods ͨ���ؼ��ֲ���Ҫ��ʾ��ĳ����Ʒ
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
		}
	}

	/**
	 * �ṩ������Ʒչʾҳ�������
	 * @param req �û����͵�����
	 * @param resp ����˵���Ӧ
	 * @throws IOException 
	 */
	private void goodsPlay(HttpServletRequest req, HttpServletResponse resp) throws IOException {
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
		//��ȡ������
		String key = req.getParameter("searchKey");
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
			//�õ���Ʒ������
			int size = goodslist.size();
			//ÿҳ����36����Ʒ����������Էּ�ҳ
			int pageCount = (size%36==0)?(size/36):(size/36+1);
			//��������õ�session
			session.setAttribute("pageCount", pageCount);
			session.setAttribute("36",36);
			
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
