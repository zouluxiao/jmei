package com.jmei.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jmei.bean.Jorder;
import com.jmei.bean.Juser;
import com.jmei.exception.DAOException;
import com.jmei.exception.JorderNotExist;
import com.jmei.factory.ServiceFactory;
import com.jmei.service.JorderService;

public class JorderAction implements Action {
	private final static String JORDER_SERVICE_KEY = "JorderServiceImpl";
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		String method = req.getParameter("method");
		if("alllist".equals(method)){
			searchAll(req,resp);
		}
	}
	private void searchAll(HttpServletRequest req, HttpServletResponse resp) {
		//��ȡSession ���쳣����Ϣ���浽Session��������ʾ��jspҳ���� �ṩ���û�
		HttpSession session = req.getSession();
		//��ȡ��ǰ��¼�û���Ϣ;
		Juser user = (Juser) session.getAttribute("juser");
		
		JorderService service =(JorderService)ServiceFactory.newInstance(JORDER_SERVICE_KEY);
		
		try {
			List<Jorder> orders = service.searchAllOrder(user.getJid());
			session.setAttribute("orderalllist", orders);
		} catch (DAOException e) {
			e.printStackTrace();
		} catch (JorderNotExist e) {
			session.setAttribute("error","��Ŀǰû�ж���");
			e.printStackTrace();
		}
	}

}
