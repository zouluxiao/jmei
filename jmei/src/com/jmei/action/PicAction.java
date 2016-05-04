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
	 * 负责查询ajax传回图片数据
	 * @param req 用户的请求
	 * @param resp 服务端的响应
	 */
	private void ajaxPic(HttpServletRequest req, HttpServletResponse resp) {
		try {
			System.out.println("dsfsdfs");
			
			
			BufferedReader buf = req.getReader();
			String ga = buf.readLine();
			String[] str = ga.split("=");
			ga = str[1];
			
			//获取session
			HttpSession session = req.getSession();
			
			//获得商品的图片service
			PicService ps = (PicService) ServiceFactory.newInstance(PICKEY);
			
			//获得商品的图片
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
			 //a.设置响应的字符集
		   resp.setContentType("text/plain;charset=utf-8");
		   //b.获取输出流
		   PrintWriter out = resp.getWriter();
		   //json字符串
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
