package com.jmei.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jmei.exception.DAOException;
import com.jmei.exception.TelHasExist;
import com.jmei.factory.ServiceFactory;
import com.jmei.service.JuserService;
import com.jmei.utils.GetJname;
import com.jmei.utils.Sendsms;
/**
 * menthod = regist ʵ���û���¼��ע�Ṧ��
 * @author ���
 * @since 2016-04-30
 *
 */

public class JuserAction implements Action {
	private final static String JUSER_SERVICE_KEY = "JuserServiceImpl";
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		String method = req.getParameter("method");
		if("regist".equals(method)){
			registByTel(req,resp);
		}
		if("getmessage".equals(method)){
			getMessage(req,resp);
		}
	}

	private void getMessage(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		BufferedReader buf = req.getReader();
		String tel = buf.readLine();
		String[] st = tel.split("=");
		System.out.println(st[1]);
		int verfyCode = Sendsms.getTelVirefy(st[1]);
		//��ȡSession ���쳣����Ϣ���浽Session��������ʾ��jspҳ���� �ṩ���û�
		HttpSession session = req.getSession();
		session.setAttribute("verfyCode", String.valueOf(verfyCode));
	}

	private void registByTel(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//��ȡ�������ֻ����롢�û�������Ϣ
		String jtel = req.getParameter("regtel");
		String pwd = req.getParameter("password");
		String verifyCode =req.getParameter("messagevf");
		
		//��ȡSession ���쳣����Ϣ���浽Session��������ʾ��jspҳ���� �ṩ���û�
		HttpSession session = req.getSession();
		
		//���session
		session.removeAttribute("errortel");
		session.removeAttribute("errorpwd");
		
		 //У���û���Ϣ�绰����
		if(jtel == null || !isTel(jtel)){
			session.setAttribute("errortel","������11λ�ֻ�����!");
			//System.out.println("�û����գ�");	
			resp.sendRedirect(req.getContextPath()+"/view/regist.jsp");
		}
		//У���û�����
		else if(pwd == null || !ispwd(pwd)){
			session.setAttribute("errorpwd", "Ϊ�������˺Ű�ȫ�����볤��ֻ���� 6-16 ���ַ�֮��!");
			//System.out.println("����Ϊ��");
			resp.sendRedirect(req.getContextPath()+"/view/regist.jsp");
		}
		//У���û��ֻ���֤��
		else if(verifyCode == null || !session.getAttribute("verfyCode").equals(verifyCode)){
			session.setAttribute("errorVerify", "��֤�����!");
			//System.out.println("��֤�����!");
			resp.sendRedirect(req.getContextPath()+"/view/regist.jsp");
		}else{
		//��������û���
		String jname = GetJname.getJname();
		JuserService service =(JuserService)ServiceFactory.newInstance(JUSER_SERVICE_KEY);
		try {
			service.reg(jname, pwd, jtel, 0);
			try {
				resp.sendRedirect(req.getContextPath()+"/view/jmei.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (DAOException e) {
			session.setAttribute("error",e.getMessage());
			e.printStackTrace();
		} catch (TelHasExist e) {
			session.setAttribute("error",e.getMessage());
			e.printStackTrace();
		}
		}
		
	}
	
	public boolean isTel(String uname){
		   String telRegx ="^(13[0-9]|14[0-9]|15[0-9]|18[0-9])\\d{8}$";
		   Pattern pattern =Pattern.compile(telRegx);
		   Matcher m =  pattern.matcher(uname);
		   return m.matches();
		}
	public boolean ispwd(String pwd){
		   String telRegx ="^[a-zA-Z0-9_-]{6,16}$";
		   Pattern pattern =Pattern.compile(telRegx);
		   Matcher m =  pattern.matcher(pwd);
		   return m.matches();
		}

}
