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
	String payid = null;
	String amount = null;
	String remark = null;
	String orderNo = null;
	String state = null;
	String modifyTime = null;
	// 签名验证成功
	if(result){
		payid = jubaopay.getEncrypt("payid");
		amount = jubaopay.getEncrypt("amount");
		remark = jubaopay.getEncrypt("remark");
		orderNo = jubaopay.getEncrypt("orderNo");
		state = jubaopay.getEncrypt("state");
		modifyTime = jubaopay.getEncrypt("modifyTime");
	} else {
		// 签名验证失败
		payid = "签名验证失败";
	}
%>
<!DOCTYPE HTML>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="keywords" content="聚宝吧,jubaobar.com，"/>
	<meta name="description" content="聚宝吧是由杭州凡伟网络科技有限公司研发的一个中小企业收货款的支付平台，此平台乃中国首创，国内第一家实现收货款的贷款金融功能的服务产品，欢迎新用户注册聚宝吧，马上开始轻松解决企业现金流问题！"/>
	<title> 聚宝支付-让支付更简单</title>
	<link href="http://www.jubaopay.com/resources/new/css/api_base.css" rel="stylesheet" type="text/css" />
	<link href="http://www.jubaopay.com/resources/new/css/api_main.css" rel="stylesheet" type="text/css" />
	<link href="http://www.jubaopay.com/resources/new/css/api_trading.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="http://www.jubaopay.com/libs/jquery.min.js"></script>
	<script type="text/javascript" src="http://www.jubaopay.com/resources/new/js/j_validate.js"></script>
	<link href="http://www.jubaobar.com/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css" />\<script language="javascript" src="http://www.jubaopay.com/resources/new/js/api_pay.js"></script>
	<script language="javascript" src="http://www.jubaopay.com/resources/new/js/api_dialog.js"></script>
</head>

<body>


<div id="header-container">
  <div class="header-content">
    </div>
</div><div class="header-Line"></div>
<div id="all-main-container">
<div class="pay-nav">
    <div class="pay-info-wrap">
        <div class="pay-info f14 clearfix">
	        <div class="L">商户下单demo页面</div>
        </div>
    </div>
</div>

<div class="main clearfix">
    <div class="api-back-res">
		<form method="post" action="/goToPay.jsp">
			<table>
				<tr>
					<td>支付单号：(由商户生成，确保唯一)</td>
					<td><%=payid %></td>
				</tr>
				<tr>
					<td>平台订单号：(由商户生成，确保唯一)</td>
					<td><%=orderNo %></td>
				</tr>
				<tr>
					<td>金额:(单位元，精确到分)</td>
					<td><%=amount %></td>
				</tr>
				<tr>
					<td>备注:</td>
					<td><%=remark %> (非必填信息)</td>
				</tr>
				<tr>
					<td>状态:</td>
					<td><%=state %>"> (2表示支付成功，其他均不是支付成功)</td>
				</tr>
				<tr>
					<td>支付成功时间:</td>
					<td><%=modifyTime %>"> (2表示支付成功，其他均不是支付成功)</td>
				</tr>
			</table>
		</form>
    </div>
</div>
</div>
<div class="footer-container">
  <div class="footer-content">杭州凡伟网络科技有限公司©2014 浙ICP备12040171号&nbsp;&nbsp;
</div>
</div>
</body>
</html>
