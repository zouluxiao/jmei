<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@page import="com.jubaobar.pay.JubaoPay"%>
<%@page import="com.jubaobar.pay.AESUltil"%>
<%@page import="com.jubaobar.pay.RSAUltil"%>
<%@page import="com.jubaobar.pay.RSA"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Pragma" content="no-cache" />  
<meta http-equiv="Expires" content="-1" />  
<meta http-equiv="Cache-Control" content="no-cache" /> 
<title>pay</title>
<style>
.box{ width:450px; height:240px; margin:0 auto; position:absolute; top:50%; left:50%; margin-top:-99px; margin-left:-225px; text-align:center;}
</style>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
	String payid = "pre_" + String.valueOf(System.currentTimeMillis());
	String partnerid = "16050250521730655757";
	String amount = request.getParameter("amount");
	String payerName = request.getParameter("payerName");
	String goodsName = request.getParameter("goodsName");
	String returnURL = "http://localhost:8080/return.jsp";
	String callBackURL = "http://localhost:8080/callback.jsp";
	String remark = request.getParameter("remark");
	String payMethod = request.getParameter("payMethod");
	
	RSA.intialize();
	
	JubaoPay jubaoPay = new JubaoPay();
	jubaoPay.setEncrypt("payid",payid);
	jubaoPay.setEncrypt("partnerid",partnerid);//商户合作号，由聚宝云计费生成的唯一标识
	jubaoPay.setEncrypt("amount",amount);
	jubaoPay.setEncrypt("payerName",payerName);
	jubaoPay.setEncrypt("goodsName",goodsName);
	jubaoPay.setEncrypt("returnURL",returnURL);
	jubaoPay.setEncrypt("callBackURL",callBackURL);
	jubaoPay.setEncrypt("payMethod",payMethod);
	jubaoPay.setEncrypt("remark", remark);
	jubaoPay.interpret();         
    String message = jubaoPay.getMessage();
    String signature = jubaoPay.getSignature();
    System.out.println("message : " + message);
    System.out.println("signature : " + signature);
%>

      <form id="payBillForm" action="https://www.jubaopay.com/apipay.htm" method="post">
              <!-- WAP环境action="https://www.jubaopay.com/apiwapsyt.htm" -->
              <input type="hidden" name="message" value="<%=message%>"/>
              <input type="hidden" name="signature" value="<%=signature%>"/>
              <input type="hidden" name="payMethod" value="<%=payMethod%>"/>
      </form>
</body>
</html>
<script language="javascript" type="text/javascript">
window.onload=function(){
	document.getElementById("payBillForm").submit();
}
</script>
