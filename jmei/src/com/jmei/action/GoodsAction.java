package com.jmei.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jmei.bean.Goods;
import com.jmei.exception.DAOException;
import com.jmei.exception.NoSuchGoodsException;
import com.jmei.factory.ServiceFactory;
import com.jmei.service.GoodsServices;

/**
 * method=searchGoods ͨ���ؼ��ֲ�ѯ��Ʒ
 * 
 * @author ����
 *	2016-04-29
 */
public class GoodsAction implements Action {
	private static final String GOODSKEY = "GoodsServiceImpl";
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		String method = req.getParameter("method");
		if("searchGoods".equals(method)){
			searchByKey(req,resp);
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
		
		GoodsServices service = (GoodsServices) ServiceFactory.newInstance(GOODSKEY);
		try {
			//��ѯ��Ʒ
			List<Goods> goodslist = service.searchGoodsByDetail(key);
			session.setAttribute("goodslist", goodslist);
			resp.sendRedirect(req.getContextPath()+"/view/searchResult.jsp");
		} catch (DAOException e) {
			session.setAttribute("GOODS_ERROR", e.getMessage());
			resp.sendRedirect(req.getContextPath()+"error.jsp");
		} catch (NoSuchGoodsException e) {
			session.setAttribute("GOODS_ERROR", e.getMessage());
			resp.sendRedirect(req.getContextPath()+"error.jsp");
		} catch (IOException e) {
			session.setAttribute("GOODS_ERROR", e.getMessage());
			resp.sendRedirect(req.getContextPath()+"error.jsp");
		}
	}

}
