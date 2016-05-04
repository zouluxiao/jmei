<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@page import="com.jubaobar.pay.JubaoPay"%>
<%@page import="com.jubaobar.pay.AESUltil"%>
<%@page import="com.jubaobar.pay.RSAUltil"%>
<%@page import="com.jubaobar.pay.RSA"%>

<%
	String message = request.getParameter("message");
	String signature = request.getParameter("signature");
	RSA.intialize();
	// 解密，校验签名，并处理业务逻辑处理
	JubaoPay jubaopay = new JubaoPay();
	boolean result = jubaopay.decrypt(message, signature);
	jubaopay.getEncrypt("payid");
	jubaopay.getEncrypt("mobile");
	jubaopay.getEncrypt("amount");
	jubaopay.getEncrypt("remark");
	jubaopay.getEncrypt("orderNo");
	jubaopay.getEncrypt("state");
	jubaopay.getEncrypt("modifyTime");
	
	// 输出正确的响应
	if(result){
		response.getWriter().write("success");
		response.getWriter().flush();
	} else {
		// 签名验证失败
		response.getWriter().write("failed");
		response.getWriter().flush();
	}
%>