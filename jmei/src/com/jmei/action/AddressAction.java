package com.jmei.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jmei.bean.Address;
import com.jmei.bean.CollectionToBuser;
import com.jmei.bean.Juser;
import com.jmei.exception.AddressExistException;
import com.jmei.exception.AddressIsNotExistException;
import com.jmei.exception.DAOException;
import com.jmei.exception.HasCollectionBuser;
import com.jmei.exception.NotHasAddress;
import com.jmei.exception.NotHasDetailAddress;
import com.jmei.exception.NotHasUsername;
import com.jmei.exception.TelNotExistException;
import com.jmei.factory.ServiceFactory;
import com.jmei.service.AddressService;
import com.jmei.utils.Sendsms;

public class AddressAction implements Action{
	private final static String Address_SERVICE_KEY = "AddressServiceImpl";
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		String method = req.getParameter("method");
		if("getaddress".equals(method)){
			searchAddress(req,resp);
		}
		if("deleteaddress".equals(method)){
			deteleAddress(req,resp);
		}
		if("addaddress".equals(method)){
			addAddress(req,resp);
		}
	}
	private void addAddress(HttpServletRequest req, HttpServletResponse resp) {
		String name =req.getParameter("recipient_name");
		String id =req.getParameter("id_card_no");
		String detailAddress =req.getParameter("recipient_street");
		try {
			detailAddress = new String(detailAddress.getBytes("ISO-8859-1"),"UTF-8");
			System.out.println("detailAddress : "+ detailAddress);
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String tel =req.getParameter("recipient_hp");
		String pnumber1 =req.getParameter("recipient_tel_area");
		String pnumber2 =req.getParameter("recipient_tel_number");
		String pnumber =pnumber1+pnumber2;
		//获取Session 将异常的消息保存到Session中最终显示到jsp页面上 提供给用户
		HttpSession session = req.getSession();
		Juser user =(Juser)session.getAttribute("juser");
		Address address =new Address(0,user,"湖南省长沙",name,id,detailAddress,tel,pnumber);
				
		AddressService service =(AddressService)ServiceFactory.newInstance(Address_SERVICE_KEY);
		
		try {
			service.addAddress(address);
			try {
				resp.sendRedirect(req.getContextPath()+"/view/personal.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (DAOException e) {
			e.printStackTrace();
		} catch (AddressExistException e) {
			session.setAttribute("error",e.getMessage());
			e.printStackTrace();
		} catch (TelNotExistException e) {
			session.setAttribute("error",e.getMessage());
			e.printStackTrace();
		} catch (NotHasUsername e) {
			session.setAttribute("error",e.getMessage());
			e.printStackTrace();
		} catch (NotHasAddress e) {
			session.setAttribute("error",e.getMessage());
			e.printStackTrace();
		} catch (NotHasDetailAddress e) {
			session.setAttribute("error",e.getMessage());
			e.printStackTrace();
		}
		
		
	}
	private void deteleAddress(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//获取Session 将异常的消息保存到Session中最终显示到jsp页面上 提供给用户
		HttpSession session = req.getSession();
		
		AddressService service =(AddressService)ServiceFactory.newInstance(Address_SERVICE_KEY);
		
		BufferedReader buf = req.getReader();
		String tel = buf.readLine();
		String[] st = tel.split("=");
		try {
			service.deleteAddressByJid(Integer.parseInt(st[1]));
			searchAddress(req,resp);
		} catch (NumberFormatException e) {
			session.setAttribute("error",e.getMessage());
			e.printStackTrace();
		} catch (DAOException e) {
			e.printStackTrace();
		} catch (AddressIsNotExistException e) {
			session.setAttribute("error",e.getMessage());
			e.printStackTrace();
		}
	}
	private void searchAddress(HttpServletRequest req, HttpServletResponse resp) {
		//获取Session 将异常的消息保存到Session中最终显示到jsp页面上 提供给用户
		HttpSession session = req.getSession();
		
		Juser user = (Juser)session.getAttribute("juser");
		AddressService service =(AddressService)ServiceFactory.newInstance(Address_SERVICE_KEY);
		System.out.println(user);
		try {
			List<Address> list = service.searchAllAdressByJid(user.getJid());
			for(int i=0;i<list.size();i++){
				/*String s = list.get(i).getDetailaddress();
				System.out.println("原s:"+s);
				s = new String(s.getBytes("ISO-8859-1"),"UTF-8");
				System.out.println("s:"+s);
				list.get(i).setDetailaddress(s);*/
				System.out.println("详细收货地址："+list.get(i).getDetailaddress());
			}
			System.out.println("加入session");
			session.setAttribute("address", list);
		} catch (DAOException e) {
			e.printStackTrace();
		} catch (AddressIsNotExistException e) {
			session.setAttribute("error","您目前没有订单");
			e.printStackTrace();
		}
	}

}
