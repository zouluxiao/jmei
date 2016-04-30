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
	}

	private void getMessage(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		BufferedReader buf = req.getReader();
		String tel = buf.readLine();
		String[] st = tel.split("=");
		System.out.println(st[1]);
		int verfyCode = Sendsms.getTelVirefy(st[1]);
		//获取Session 将异常的消息保存到Session中最终显示到jsp页面上 提供给用户
		HttpSession session = req.getSession();
		session.setAttribute("verfyCode", String.valueOf(verfyCode));
	}

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
