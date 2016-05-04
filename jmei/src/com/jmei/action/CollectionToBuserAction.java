package com.jmei.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jmei.bean.Buser;
import com.jmei.bean.CollectionToBuser;
import com.jmei.bean.Juser;
import com.jmei.exception.CollectionBuserNotExist;
import com.jmei.exception.DAOException;
import com.jmei.exception.HasCollectionBuser;
import com.jmei.exception.NoBuserException;
import com.jmei.exception.NotCollectionThisBuser;
import com.jmei.exception.collectionBuserIsNull;
import com.jmei.factory.ServiceFactory;
import com.jmei.service.BuserService;
import com.jmei.service.CollectionToBuserService;
/**
 * 收藏企业模块action
 * @author 邹璐
 * @since 2014-05-03
 *
 */

public class CollectionToBuserAction implements Action {
	private final static String BUSER_SERVICE_KEY = "CollectionToBuserServiceImpl";
	private final static String BUSERH_SERVICE_KEY = "BuserServiceImpl";
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		String method = req.getParameter("method");
		if("getcollectionbuser".equals(method)){
			getBuser(req,resp);
		}
		if("addcollectionbuser".equals(method)){
			addBuser(req,resp);
		}
		if("updateval".equals(method)){
			updateval(req,resp);
		}
	}
	
	//取消收藏
	private void updateval(HttpServletRequest req, HttpServletResponse resp) {
		String bid = req.getParameter("bid");
		//获取Session 将异常的消息保存到Session中最终显示到jsp页面上 提供给用户
		HttpSession session = req.getSession();
						
		CollectionToBuserService service =(CollectionToBuserService)ServiceFactory.newInstance(BUSER_SERVICE_KEY);
		
		Juser user =(Juser)session.getAttribute("juser");
		
		try {
			service.deleteCollectionBuserByJid(user.getJid(), Integer.parseInt(bid));
		} catch (NumberFormatException e) {
			session.setAttribute("error", e.getMessage());
			e.printStackTrace();
		} catch (DAOException e) {
			session.setAttribute("error", e.getMessage());
			e.printStackTrace();
		} catch (NotCollectionThisBuser e) {
			session.setAttribute("error", e.getMessage());
			e.printStackTrace();
		}
	}

	//添加收藏
	private void addBuser(HttpServletRequest req, HttpServletResponse resp) {
		String bid = req.getParameter("bid");
		//获取Session 将异常的消息保存到Session中最终显示到jsp页面上 提供给用户
		HttpSession session = req.getSession();
						
		CollectionToBuserService service =(CollectionToBuserService)ServiceFactory.newInstance(BUSER_SERVICE_KEY);
		BuserService service2 = (BuserService)ServiceFactory.newInstance(BUSERH_SERVICE_KEY);
		
		Buser buser = new Buser();
		try {
			buser = service2.searchBybid(Integer.parseInt(bid));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (DAOException e) {
			e.printStackTrace();
		} catch (NoBuserException e) {
			e.printStackTrace();
		}
		
		Juser user =(Juser)session.getAttribute("juser");
		
		CollectionToBuser collectionBuser = new CollectionToBuser(0,user,buser);
		
		try {
			service.addCollectionBuserByJid(collectionBuser);
		} catch (DAOException e) {
			e.printStackTrace();
		} catch (HasCollectionBuser e) {
			session.setAttribute("error", e.getMessage());
			e.printStackTrace();
		} catch (collectionBuserIsNull e) {
			session.setAttribute("error", e.getMessage());
			e.printStackTrace();
		}
	}
	private void getBuser(HttpServletRequest req, HttpServletResponse resp) {
		//获取Session 将异常的消息保存到Session中最终显示到jsp页面上 提供给用户
		HttpSession session = req.getSession();
				
	   CollectionToBuserService service =(CollectionToBuserService)ServiceFactory.newInstance(BUSER_SERVICE_KEY);
	   
	   Juser user =(Juser)session.getAttribute("juser");
	   
	   try {
		List<CollectionToBuser> list = service.searchCollectionToBuserByJid(user.getJid());
		session.setAttribute("buserlist",list);
	} catch (DAOException e) {
		e.printStackTrace();
	} catch (CollectionBuserNotExist e) {
		session.setAttribute("error", e.getMessage());
		e.printStackTrace();
	}
	}

}
