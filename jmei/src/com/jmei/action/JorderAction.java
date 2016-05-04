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
import com.jmei.bean.Jorder;
import com.jmei.bean.Juser;
import com.jmei.bean.Pic;
import com.jmei.exception.DAOException;
import com.jmei.exception.JorderIsNotExist;
import com.jmei.exception.JorderNotExist;
import com.jmei.exception.PicNotExistException;
import com.jmei.factory.ServiceFactory;
import com.jmei.service.JorderService;
import com.jmei.service.PicService;

public class JorderAction implements Action {
	private final static String JORDER_SERVICE_KEY = "JorderServiceImpl";
	private final static String PIC_SERVICE_KEY = "PicServiceImpl";
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		String method = req.getParameter("method");
		if("alllist".equals(method)){
			searchAll(req,resp);
			System.out.println("������");
		}
		if("updateval".equals(method)){
			updateval(req,resp);
		}
	}
	
	//���Ķ���״̬
	private void updateval(HttpServletRequest req, HttpServletResponse resp) {
		String orid = req.getParameter("orid");
		
		String is_val =req.getParameter("is_val");
		//��ȡSession ���쳣����Ϣ���浽Session��������ʾ��jspҳ���� �ṩ���û�
		HttpSession session = req.getSession();
		//��ȡ��ǰ��¼�û���Ϣ;
		Juser user = (Juser) session.getAttribute("juser");
		
		JorderService service =(JorderService)ServiceFactory.newInstance(JORDER_SERVICE_KEY);
		
		try {
			service.updateIs_valByJid(Integer.parseInt(orid), Integer.parseInt(is_val));
		} catch (NumberFormatException e) {
			session.setAttribute("error",e.getMessage());
			e.printStackTrace();
		} catch (DAOException e) {
			session.setAttribute("error",e.getMessage());
			e.printStackTrace();
		} catch (JorderIsNotExist e) {
			session.setAttribute("error",e.getMessage());
			e.printStackTrace();
		}
		
	}
	private void searchAll(HttpServletRequest req, HttpServletResponse resp) {
		//��ȡSession ���쳣����Ϣ���浽Session��������ʾ��jspҳ���� �ṩ���û�
		HttpSession session = req.getSession();
		//��ȡ��ǰ��¼�û���Ϣ;
		Juser user = (Juser) session.getAttribute("juser");
		
		JorderService service =(JorderService)ServiceFactory.newInstance(JORDER_SERVICE_KEY);
		PicService service2 =(PicService)ServiceFactory.newInstance(PIC_SERVICE_KEY);


		try {
			List<Jorder> orders = service.searchAllOrder(user.getJid());
			Iterator<Jorder> jorderlist = orders.iterator();
			List<Pic> pics = new ArrayList<Pic>();
			Pic p = new Pic();
			while(jorderlist.hasNext()){
				Jorder jorder =(Jorder)jorderlist.next();
				List<Pic> pic = new ArrayList<Pic>();
				try {
					pic = service2.searchAllSmaPicByGid(jorder.getGoods());
				} catch (PicNotExistException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(pic != null && pic.size() > 0){
					 p =pic.get(0);
				}
				pics.add(p);
			}
			session.setAttribute("orderalllist", orders);
			session.setAttribute("pics", pics);
			System.out.println("�Ѿ�����session");
		} catch (DAOException e) {
			e.printStackTrace();
		} catch (JorderNotExist e) {
			session.setAttribute("error","��Ŀǰû�ж���");
			e.printStackTrace();
		}
	}

}
