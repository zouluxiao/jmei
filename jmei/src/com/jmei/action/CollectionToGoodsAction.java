package com.jmei.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jmei.bean.CollectionToGoods;
import com.jmei.bean.Juser;
import com.jmei.bean.Pic;
import com.jmei.exception.DAOException;
import com.jmei.exception.NotCollectionnGoods;
import com.jmei.exception.PicNotExistException;
import com.jmei.factory.ServiceFactory;
import com.jmei.service.CollectionToGoodsService;
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
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		String method = req.getParameter("method");
		if("getgoods".equals(method)){
			getgoods(req,resp);
			System.out.println("daozhel");
		}

	}

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
					// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotCollectionnGoods e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
	}

}
