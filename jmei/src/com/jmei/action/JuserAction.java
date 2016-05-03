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
 * menthod = regist 实现用户登录、注册功能
 * @author 邹璐
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
	
	//获取修改密码验证码
	private void getmessage(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//获取Session 将异常的消息保存到Session中最终显示到jsp页面上 提供给用户
		HttpSession session = req.getSession();
		Juser user = (Juser)session.getAttribute("juser");
		String jtel = user.getJtel();
		int verfyCode = Sendsms.getMessage(jtel);
		session.setAttribute("verfyCodeupdatepwd", String.valueOf(verfyCode));
		
	}

	//修改密码
	private void updatepwd(HttpServletRequest req, HttpServletResponse resp) {
		//获取页面信息
		String telverify = req.getParameter("verify_code");
		String pwd =req.getParameter("password");
		String verify =req.getParameter("hash_code");
		//获取Session 将异常的消息保存到Session中最终显示到jsp页面上 提供给用户
		HttpSession session = req.getSession();
				
		if(telverify == null || !telverify.equals(session.getAttribute("verfyCodeupdatepwd"))){
			session.setAttribute("error", "短信验证码错误!");
		}else if(pwd ==null || !ispwd(pwd)){
			session.setAttribute("error", "密码错误!");
		}else if(verify == null || verify.equals(session.getAttribute("check"))){
			session.setAttribute("error", "验证码错误!");
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
		//获取页面信息
		String verfyCode = req.getParameter("confirm_code");
		String verify =req.getParameter("verify_code");
		String email =req.getParameter("email");
		//获取Session 将异常的消息保存到Session中最终显示到jsp页面上 提供给用户
		HttpSession session = req.getSession();
				
		Juser user = (Juser)session.getAttribute("juser");
		int jid =user.getJid();
		
		if(verfyCode == null || !verfyCode.equals(session.getAttribute("verfyCode2"))){
			session.setAttribute("errorverfy", "请输入正确的手机验证码!");
		}else if(verify == null || !verify.equals(session.getAttribute("check"))){
			session.setAttribute("errorverify", "请输入正确的验证码!");
		}else if(email == null || !isemail(email)){
			session.setAttribute("erroremail", "请输入正确的邮箱!");
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
		//获取Session 将异常的消息保存到Session中最终显示到jsp页面上 提供给用户
		HttpSession session = req.getSession();
		Juser user = (Juser)session.getAttribute("juser");
		String jtel = user.getJtel();
		int verfyCode = Sendsms.getMessage(jtel);
		session.setAttribute("verfyCode2", String.valueOf(verfyCode));
		
	}

	//通过手机号码或邮箱登录
	private void logincommon(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//获取页面信息
		String username = req.getParameter("username");
		String password =req.getParameter("login_password");
		
		//获取Session 将异常的消息保存到Session中最终显示到jsp页面上 提供给用户
		HttpSession session = req.getSession();
				
		//清空session
		session.removeAttribute("errortel");
		session.removeAttribute("dynamic_password");
		
		if(username == null || (!isTel(username) && !isemail(username)) ){
			session.setAttribute("errortel", "请输入手机号码或邮箱!");
			//System.out.println("手机号码错误!");
			resp.sendRedirect(req.getContextPath()+"/view/login.jsp");
		}else if(password == null){
			session.setAttribute("dynamic_password", "请输入密码，密码可能为字母、数字或符号的组合!");
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
	
	//获取动态密码
	private void getMessge(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		BufferedReader buf = req.getReader();
		String tel = buf.readLine();
		String[] st = tel.split("=");
		System.out.println(st[1]);
		int verfyCode = Sendsms.getMessage(st[1]);
		//获取Session 将异常的消息保存到Session中最终显示到jsp页面上 提供给用户
		HttpSession session = req.getSession();
		session.setAttribute("verfyCode1", String.valueOf(verfyCode));
		
	}
	
	//通过手机动态验证码登录
	private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//获取页面信息
		String ltel = req.getParameter("dynamic_mobile");
		String verifyCode =req.getParameter("dynamic_password");
		
		//获取Session 将异常的消息保存到Session中最终显示到jsp页面上 提供给用户
		HttpSession session = req.getSession();
		
		//清空session
		session.removeAttribute("errortel");
		session.removeAttribute("dynamic_password");
		
		//判断电话号码
		if(ltel == null || !isTel(ltel)){
			session.setAttribute("errortel", "请输入11手机号码!");
			System.out.println("手机号码错误!");
			resp.sendRedirect(req.getContextPath()+"/view/login.jsp");
		}else if(verifyCode == null || !session.getAttribute("verfyCode1").equals(verifyCode)){
			session.setAttribute("dynamic_password", "请输入6位动态密码!");
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

	//获取动态验证码
	private void getMessage(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		BufferedReader buf = req.getReader();
		String tel = buf.readLine();
		String[] st = tel.split("=");
		System.out.println(st[1]);
		int verfyCode =Sendsms.getMessage(st[1]);
		//获取Session 将异常的消息保存到Session中最终显示到jsp页面上 提供给用户
		HttpSession session = req.getSession();
		session.setAttribute("verfyCode", String.valueOf(verfyCode));
	}
	
	//注册
	private void registByTel(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//获取的数据手机号码、用户密码信息
		String jtel = req.getParameter("regtel");
		String pwd = req.getParameter("password");
		String verifyCode =req.getParameter("messagevf");
		
		//获取Session 将异常的消息保存到Session中最终显示到jsp页面上 提供给用户
		HttpSession session = req.getSession();
		
		//清空session
		session.removeAttribute("errortel");
		session.removeAttribute("errorpwd");
		session.removeAttribute("errorVerify");
		 //校验用户信息电话号码
		if(jtel == null || !isTel(jtel)){
			session.setAttribute("errortel","请输入11位手机号码!");
			//System.out.println("用户名空！");	
			resp.sendRedirect(req.getContextPath()+"/view/regist.jsp");
		}
		//校验用户密码
		else if(pwd == null || !ispwd(pwd)){
			session.setAttribute("errorpwd", "为了您的账号安全，密码长度只能在 6-16 个字符之间!");
			//System.out.println("密码为空");
			resp.sendRedirect(req.getContextPath()+"/view/regist.jsp");
		}
		//校验用户手机验证码
		else if(verifyCode == null || !session.getAttribute("verfyCode").equals(verifyCode)){
			session.setAttribute("errorVerify", "验证码错误!");
			//System.out.println("验证码错误!");
			resp.sendRedirect(req.getContextPath()+"/view/regist.jsp");
		}else{
		//生成随机用户名
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
