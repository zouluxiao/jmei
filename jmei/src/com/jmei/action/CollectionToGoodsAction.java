package com.jmei.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.jmei.bean.CollectionToGoods;
import com.jmei.bean.Goods;
import com.jmei.bean.Juser;
import com.jmei.bean.Pic;
import com.jmei.exception.DAOException;
import com.jmei.exception.HasCollectionGoods;
import com.jmei.exception.NoSuchGoodsException;
import com.jmei.exception.NotCollectionThisCollection;
import com.jmei.exception.NotCollectionnGoods;
import com.jmei.exception.PicNotExistException;
import com.jmei.exception.collectionGoodsIsNull;
import com.jmei.factory.ServiceFactory;
import com.jmei.service.CollectionToGoodsService;
import com.jmei.service.GoodsServices;
import com.jmei.service.PicService;
/**
 * ʵ���ղ���Ʒģ��Ĺ���
 * @author ���
 * @since  2016-05-02
 *
 */

public class CollectionToGoodsAction implements Action {
	private final static String GOODS_SERVICE_KEY = "CollectionToGoodsServiceImpl";
	private final static String PIC_SERVICE_KEY = "PicServiceImpl";
	private final static String GOODSH_SERVICE_KEY ="GoodsServiceImpl";
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		String method = req.getParameter("method");
		if("getgoods".equals(method)){
			getgoods(req,resp);
			//System.out.println("daozhel");
		}
		if("addgoods".equals(method)){
			addgoods(req,resp);
		}
		if("delete".equals(method)){
			deleteCollection(req,resp);
		}
	}
/*	private void getgoods(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String str = req.getQueryString();
		//System.out.println(str);
		//a.������Ӧ����ĸ�ʽ���ַ���
		resp.setContentType("text/plain;charset=utf-8");
		//b.��ȡ�����
		PrintWriter pw = resp.getWriter();
		//pw.println("��Ӧ������");
		//��ȡSession ���쳣����Ϣ���浽Session��������ʾ��jspҳ���� �ṩ���û�
		HttpSession session = req.getSession();
				
		CollectionToGoodsService service =(CollectionToGoodsService)ServiceFactory.newInstance(GOODS_SERVICE_KEY);
		PicService service2 =(PicService)ServiceFactory.newInstance(PIC_SERVICE_KEY);
				
		Juser user = (Juser)session.getAttribute("juser");
		try {
			List<CollectionToGoods> list = service.searchCollectionToGoodsByJid(user.getJid());
			
            if(null == list){
                return ;
            }
            JSONArray json = new JSONArray();
            for(CollectionToGoods a : list){
                JSONObject jo = new JSONObject();
                jo.put("id", a.getCid());
                jo.put("goods", a.getGoods());
                jo.put("juser", a.getJuser());
                json.add(jo);
            }
            try {
                //System.out.println(json.toString());
                resp.setContentType("text/plain;charset=utf-8");
                resp.getWriter().write(json.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
          
			Iterator<CollectionToGoods> it= list.iterator();
			List<String> pic = new ArrayList<String>();
			while(it.hasNext()){
				CollectionToGoods collection = (CollectionToGoods) it.next();
				//JSONObject jo1 = JSONObject.fromObject(collection);
				String picname = null;
				try {
					List<Pic> listpic = service2.searchAllBigPicByGid(collection.getGoods());
					if(listpic != null && listpic.size() > 0){
					Pic p = (Pic)listpic.get(0);
					picname = p.getPicpname();
					}
					pic.add(picname);
				} catch (PicNotExistException e) {
					e.printStackTrace();
						}
				//service2.searchPicByGid(collection.getGoods().getGid());
				}
				//session.setAttribute("collectiontogoods", list);
				//session.setAttribute("pic", pic);
				//��java����ת����JSONObject����
				//JSONObject jo1 = JSONObject.fromObject();
				//��JSONObjectת�����ַ���
			   //String jsonString = jo1.toString();
			 } catch (DAOException e) {
			e.printStackTrace();
		} catch (NotCollectionnGoods e) {
			e.printStackTrace();
		}
		//System.out.println("��Ӧ������");
		pw.flush();
		
	}*/

	//ȡ���ղ�
	private void deleteCollection(HttpServletRequest req,
			HttpServletResponse resp) {
		String cbid = req.getParameter("cbid");
		//��ȡSession ���쳣����Ϣ���浽Session��������ʾ��jspҳ���� �ṩ���û�
		HttpSession session = req.getSession();
			
		Juser user = (Juser) session.getAttribute("juser");
		
		CollectionToGoodsService service =(CollectionToGoodsService)ServiceFactory.newInstance(GOODS_SERVICE_KEY);
		
		try {
			service.deleteCollectionGoodsByJid(user.getJid(), Integer.parseInt(cbid));
		} catch (NumberFormatException e) {
			session.setAttribute("error", e.getMessage());
			e.printStackTrace();
		} catch (DAOException e) {
			session.setAttribute("error", e.getMessage());
			e.printStackTrace();
		} catch (NotCollectionThisCollection e) {
			session.setAttribute("error", e.getMessage());
			e.printStackTrace();
		}
	}

	//����ղ�
	private void addgoods(HttpServletRequest req, HttpServletResponse resp) {
		
		String gid = req.getParameter("gid");
		
		//��ȡSession ���쳣����Ϣ���浽Session��������ʾ��jspҳ���� �ṩ���û�
		HttpSession session = req.getSession();
			
		Juser user = (Juser) session.getAttribute("juser");
		
		CollectionToGoodsService service =(CollectionToGoodsService)ServiceFactory.newInstance(GOODS_SERVICE_KEY);
		GoodsServices service2 =(GoodsServices)ServiceFactory.newInstance(GOODSH_SERVICE_KEY);
		
		Goods goods = new Goods();
		try {
			goods = service2.searchGoodsByGid(Integer.parseInt(gid));
		} catch (NumberFormatException e) {
			session.setAttribute("error", e.getMessage());
			e.printStackTrace();
		} catch (DAOException e) {
			session.setAttribute("error", e.getMessage());
			e.printStackTrace();
		} catch (NoSuchGoodsException e) {
			session.setAttribute("error", e.getMessage());
			e.printStackTrace();
		}
		
		CollectionToGoods  collectionGoods = new CollectionToGoods(0,user,goods);
	
		try {
			service.addCollectionGoodsByJid(collectionGoods);
		} catch (DAOException e) {
			session.setAttribute("error", e.getMessage());
			e.printStackTrace();
		} catch (HasCollectionGoods e) {
			session.setAttribute("error", e.getMessage());
			e.printStackTrace();
		} catch (collectionGoodsIsNull e) {
			session.setAttribute("error", e.getMessage());
			e.printStackTrace();
		}
		
	}

	//��ȡ�ղ���Ʒ
	private void getgoods(HttpServletRequest req, HttpServletResponse resp) {
		//��ȡSession ���쳣����Ϣ���浽Session��������ʾ��jspҳ���� �ṩ���û�
		HttpSession session = req.getSession();
		
		CollectionToGoodsService service =(CollectionToGoodsService)ServiceFactory.newInstance(GOODS_SERVICE_KEY);
		PicService service2 =(PicService)ServiceFactory.newInstance(PIC_SERVICE_KEY);
		
		Juser user = (Juser)session.getAttribute("juser");
		
		
		try {
			List<CollectionToGoods> list = service.searchCollectionToGoodsByJid(user.getJid());
			
			Iterator<CollectionToGoods> it= list.iterator();
			List<String> pic = new ArrayList<String>();
			while(it.hasNext()){
				CollectionToGoods collection = (CollectionToGoods) it.next();
				String picname = null;
				try {
					List<Pic> listpic = service2.searchAllBigPicByGid(collection.getGoods());
					if(listpic != null && listpic.size() > 0){
						Pic p = (Pic)listpic.get(0);
						picname = p.getPicpname();
					}
					pic.add(picname);
				} catch (PicNotExistException e) {
					e.printStackTrace();
				}
				//service2.searchPicByGid(collection.getGoods().getGid());
				}
				System.out.println("list : " + list);
				System.out.println("pic : " + pic);
				session.setAttribute("collectiontogoods", list);
				session.setAttribute("pic", pic);
				System.out.println("��ӳɹ���!");
		} catch (DAOException e) {
			e.printStackTrace();
		} catch (NotCollectionnGoods e) {
			e.printStackTrace();
		}			
	}

}
