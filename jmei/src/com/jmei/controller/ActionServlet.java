package com.jmei.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jmei.action.Action;
import com.jmei.action.GoodsAction;

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
		}else if("/product.do".equalsIgnoreCase(servletPath)){
		
		}
		
	}
	
}
