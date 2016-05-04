package com.jmei.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import com.jmei.bean.Goods;
import com.jmei.bean.Pic;
import com.jmei.exception.DAOException;
import com.jmei.exception.PicNotExistException;
import com.jmei.factory.ServiceFactory;
import com.jmei.service.PicService;

public class PicAction implements Action {
	private static final String PICKEY = "PicServiceImpl";
	
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		String method = req.getParameter("ajaxpic");
		if("ajaxpic".equals(method)){
			ajaxPic(req,resp);
		}

	}

	/**
	 * �����ѯajax����ͼƬ����
	 * @param req �û�������
	 * @param resp ����˵���Ӧ
	 */
	private void ajaxPic(HttpServletRequest req, HttpServletResponse resp) {
		try {
			System.out.println("dsfsdfs");
			
			
			BufferedReader buf = req.getReader();
			String ga = buf.readLine();
			String[] str = ga.split("=");
			ga = str[1];
			
			//��ȡsession
			HttpSession session = req.getSession();
			
			//�����Ʒ��ͼƬservice
			PicService ps = (PicService) ServiceFactory.newInstance(PICKEY);
			
			//�����Ʒ��ͼƬ
			Pic pic = new Pic();
			Goods g = new Goods();
			g.setGid(Integer.parseInt(ga));
			List<Pic> picList = (List<Pic>) ps.searchAllMibPicByGid(g);
			if(picList != null && picList.size() > 0){
				pic = picList.get(0);
				System.out.println("pic: "+pic);
			}
			
			
			JSONObject jo2 = JSONObject.fromObject(pic);
			String jsonStringpic = jo2.toString();
			 //a.������Ӧ���ַ���
		   resp.setContentType("text/plain;charset=utf-8");
		   //b.��ȡ�����
		   PrintWriter out = resp.getWriter();
		   //json�ַ���
		   out.println(jsonStringpic);
		   out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PicNotExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
