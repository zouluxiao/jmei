package com.jmei.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jmei.action.Action;
import com.jmei.action.GoodsAction;
import com.jmei.action.JorderAction;
import com.jmei.action.JuserAction;
import com.jmei.action.PicAction;
import com.jmei.action.ShoppingCartAction;

public class ActionServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//System.out.println(req.getServletPath());
		String servletPath  = req.getServletPath();
		if("/search.do".equalsIgnoreCase(servletPath)){
			Action action = new GoodsAction();
			action.execute(req, resp);
		}else if("/goods.do".equalsIgnoreCase(servletPath)){
			Action action = new GoodsAction();
			action.execute(req, resp);
		}else if("/user.do".equalsIgnoreCase(servletPath)){
			Action action = new JuserAction();
			action.execute(req, resp);
		}else if("/order.do".equalsIgnoreCase(servletPath)){
			Action action = new JorderAction();
			action.execute(req, resp);
		}else if("/ShoppingCart.do".equalsIgnoreCase(servletPath)){
			Action action = new ShoppingCartAction();
			action.execute(req, resp);
		}else if("/ajaxcart.do".equalsIgnoreCase(servletPath)){
			Action action = new PicAction();
			action.execute(req, resp);
		}
		
	}
	
}
