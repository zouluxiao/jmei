package com.jmei.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jmei.bean.Juser;
import com.jmei.exception.DAOException;
import com.jmei.exception.EmailHasExist;
import com.jmei.exception.JuserIsNull;
import com.jmei.exception.NotHaveThisJuser;
import com.jmei.exception.TelHasExist;
import com.jmei.exception.UserNameOrPwdException;
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
		if("login".equals(method)){
			login(req,resp);
		}
		if("getmessageped".equals(method)){
			getMessge(req,resp);
		}
		if("logincommon".equals(method)){
			logincommon(req,resp);
		}
		if("getaddemail".equals(method)){
			getaddemail(req,resp);
		}
		if("addemail".equals(method)){
			updateemail(req,resp);
		}
		if("updatepwd".equals(method)){
			updatepwd(req,resp);
		}
		if("getmessage".equals(method)){
			getmessage(req,resp);
		}
		
	}
	
	//��ȡ�޸�������֤��
	private void getmessage(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//��ȡSession ���쳣����Ϣ���浽Session��������ʾ��jspҳ���� �ṩ���û�
		HttpSession session = req.getSession();
		Juser user = (Juser)session.getAttribute("juser");
		String jtel = user.getJtel();
		int verfyCode = Sendsms.getMessage(jtel);
		session.setAttribute("verfyCodeupdatepwd", String.valueOf(verfyCode));
		
	}

	//�޸�����
	private void updatepwd(HttpServletRequest req, HttpServletResponse resp) {
		//��ȡҳ����Ϣ
		String telverify = req.getParameter("verify_code");
		String pwd =req.getParameter("password");
		String verify =req.getParameter("hash_code");
		//��ȡSession ���쳣����Ϣ���浽Session��������ʾ��jspҳ���� �ṩ���û�
		HttpSession session = req.getSession();
				
		if(telverify == null || !telverify.equals(session.getAttribute("verfyCodeupdatepwd"))){
			session.setAttribute("error", "������֤�����!");
		}else if(pwd ==null || !ispwd(pwd)){
			session.setAttribute("error", "�������!");
		}else if(verify == null || verify.equals(session.getAttribute("check"))){
			session.setAttribute("error", "��֤�����!");
		}else{
			JuserService service =(JuserService)ServiceFactory.newInstance(JUSER_SERVICE_KEY);
			Juser juser = (Juser)session.getAttribute("juser");
			juser.setJpwd(pwd);
			try {
				service.updateOtherByJid(juser);
				
			} catch (DAOException e) {
				e.printStackTrace();
			} catch (JuserIsNull e) {
				session.setAttribute("error",e.getMessage());
				e.printStackTrace();
			} catch (NotHaveThisJuser e) {
				session.setAttribute("error",e.getMessage());
				e.printStackTrace();
			} catch (TelHasExist e) {
				session.setAttribute("error",e.getMessage());
				e.printStackTrace();
			} catch (EmailHasExist e) {
				session.setAttribute("error",e.getMessage());
				e.printStackTrace();
			}
		}
		
	}

	private void updateemail(HttpServletRequest req, HttpServletResponse resp) {
		//��ȡҳ����Ϣ
		String verfyCode = req.getParameter("confirm_code");
		String verify =req.getParameter("verify_code");
		String email =req.getParameter("email");
		//��ȡSession ���쳣����Ϣ���浽Session��������ʾ��jspҳ���� �ṩ���û�
		HttpSession session = req.getSession();
				
		Juser user = (Juser)session.getAttribute("juser");
		int jid =user.getJid();
		
		if(verfyCode == null || !verfyCode.equals(session.getAttribute("verfyCode2"))){
			session.setAttribute("errorverfy", "��������ȷ���ֻ���֤��!");
		}else if(verify == null || !verify.equals(session.getAttribute("check"))){
			session.setAttribute("errorverify", "��������ȷ����֤��!");
		}else if(email == null || !isemail(email)){
			session.setAttribute("erroremail", "��������ȷ������!");
		}else{
			JuserService service =(JuserService)ServiceFactory.newInstance(JUSER_SERVICE_KEY);
			try {
				service.updateJemailByJid(jid, email);
				try {
					resp.sendRedirect(req.getContextPath()+"/view/personal.jsp");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NotHaveThisJuser e) {
				session.setAttribute("error",e.getMessage());
				e.printStackTrace();
			} catch (EmailHasExist e) {
				session.setAttribute("error",e.getMessage());
				e.printStackTrace();
			}
		}
	}

	private void getaddemail(HttpServletRequest req, HttpServletResponse resp) {
		//��ȡSession ���쳣����Ϣ���浽Session��������ʾ��jspҳ���� �ṩ���û�
		HttpSession session = req.getSession();
		Juser user = (Juser)session.getAttribute("juser");
		String jtel = user.getJtel();
		int verfyCode = Sendsms.getMessage(jtel);
		session.setAttribute("verfyCode2", String.valueOf(verfyCode));
		
	}

	//ͨ���ֻ�����������¼
	private void logincommon(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//��ȡҳ����Ϣ
		String username = req.getParameter("username");
		String password =req.getParameter("login_password");
		
		//��ȡSession ���쳣����Ϣ���浽Session��������ʾ��jspҳ���� �ṩ���û�
		HttpSession session = req.getSession();
				
		//���session
		session.removeAttribute("errortel");
		session.removeAttribute("dynamic_password");
		
		if(username == null || (!isTel(username) && !isemail(username)) ){
			session.setAttribute("errortel", "�������ֻ����������!");
			//System.out.println("�ֻ��������!");
			resp.sendRedirect(req.getContextPath()+"/view/login.jsp");
		}else if(password == null){
			session.setAttribute("dynamic_password", "���������룬�������Ϊ��ĸ�����ֻ���ŵ����!");
			resp.sendRedirect(req.getContextPath()+"/view/login.jsp");
		}else{
			JuserService service =(JuserService)ServiceFactory.newInstance(JUSER_SERVICE_KEY);
			if(isTel(username)){
				try {
					service.loginByJtel(username, password);
					Juser user = service.searchjUserByJtel(username);
					session.setAttribute("juser", user);
					resp.sendRedirect(req.getContextPath()+"/view/jmei.jsp");
				} catch (DAOException e) {
					e.printStackTrace();
				} catch (NotHaveThisJuser e) {
					session.setAttribute("error",e.getMessage());
					e.printStackTrace();
					resp.sendRedirect(req.getContextPath()+"/view/login.jsp");
				} catch (UserNameOrPwdException e) {
					session.setAttribute("error",e.getMessage());
					e.printStackTrace();
					resp.sendRedirect(req.getContextPath()+"/view/login.jsp");
				}
			}
			if(isemail(username)){
				try {
					service.loginByJemail(username, password);
					Juser user =service.searchjUserByJemail(username);
					session.setAttribute("juser", user);
					resp.sendRedirect(req.getContextPath()+"/view/jmei.jsp");
				} catch (DAOException e) {
					e.printStackTrace();
				} catch (NotHaveThisJuser e) {
					session.setAttribute("error",e.getMessage());
					e.printStackTrace();
					resp.sendRedirect(req.getContextPath()+"/view/login.jsp");
				} catch (UserNameOrPwdException e) {
					session.setAttribute("error",e.getMessage());
					e.printStackTrace();
					resp.sendRedirect(req.getContextPath()+"/view/login.jsp");
				}
			}
		}
		
	}
	
	//��ȡ��̬����
	private void getMessge(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		BufferedReader buf = req.getReader();
		String tel = buf.readLine();
		String[] st = tel.split("=");
		System.out.println(st[1]);
		int verfyCode = Sendsms.getMessage(st[1]);
		//��ȡSession ���쳣����Ϣ���浽Session��������ʾ��jspҳ���� �ṩ���û�
		HttpSession session = req.getSession();
		session.setAttribute("verfyCode1", String.valueOf(verfyCode));
		
	}
	
	//ͨ���ֻ���̬��֤���¼
	private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//��ȡҳ����Ϣ
		String ltel = req.getParameter("dynamic_mobile");
		String verifyCode =req.getParameter("dynamic_password");
		
		//��ȡSession ���쳣����Ϣ���浽Session��������ʾ��jspҳ���� �ṩ���û�
		HttpSession session = req.getSession();
		
		//���session
		session.removeAttribute("errortel");
		session.removeAttribute("dynamic_password");
		
		//�жϵ绰����
		if(ltel == null || !isTel(ltel)){
			session.setAttribute("errortel", "������11�ֻ�����!");
			System.out.println("�ֻ��������!");
			resp.sendRedirect(req.getContextPath()+"/view/login.jsp");
		}else if(verifyCode == null || !session.getAttribute("verfyCode1").equals(verifyCode)){
			session.setAttribute("dynamic_password", "������6λ��̬����!");
			resp.sendRedirect(req.getContextPath()+"/view/login.jsp");
		}else{
			JuserService service =(JuserService)ServiceFactory.newInstance(JUSER_SERVICE_KEY);
			if(isTel(ltel)){
				try {
					service.loginByJte(ltel);
					resp.sendRedirect(req.getContextPath()+"/view/jmei.jsp");
				} catch (DAOException e) {
					e.printStackTrace();
				} catch (NotHaveThisJuser e) {
					session.setAttribute("error",e.getMessage());
					e.printStackTrace();
					resp.sendRedirect(req.getContextPath()+"/view/login.jsp");
				}
			}
		}
		
	}

	//��ȡ��̬��֤��
	private void getMessage(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		BufferedReader buf = req.getReader();
		String tel = buf.readLine();
		String[] st = tel.split("=");
		System.out.println(st[1]);
		int verfyCode =Sendsms.getMessage(st[1]);
		//��ȡSession ���쳣����Ϣ���浽Session��������ʾ��jspҳ���� �ṩ���û�
		HttpSession session = req.getSession();
		session.setAttribute("verfyCode", String.valueOf(verfyCode));
	}
	
	//ע��
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
		session.removeAttribute("errorVerify");
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
				e.printStackTrace();
			}
		} catch (DAOException e) {
			session.setAttribute("error",e.getMessage());
			e.printStackTrace();
		} catch (TelHasExist e) {
			session.setAttribute("error",e.getMessage());
			e.printStackTrace();
			resp.sendRedirect(req.getContextPath()+"/view/regist.jsp");
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
	
	public boolean isemail(String email){
		   String telRegx ="^([a-zA-Z0-9_\\.\\-])+\\@(([a-zA-Z0-9\\-])+\\.)+([a-zA-Z0-9]{2,4})+$";
		   Pattern pattern =Pattern.compile(telRegx);
		   Matcher m =  pattern.matcher(email);
		   return m.matches();
	}
}
