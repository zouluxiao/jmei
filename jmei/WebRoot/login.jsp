<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<title>登录聚美</title>
	<Link Rel="SHORTCUT ICON" href="">
	<link rel="stylesheet" type="text/css" href="css/common.css"/>
	<link rel="stylesheet" type="text/css" href="css/login.css"/>
</head>
<body>
	<div id="header">
		<div id="logo">
			<a id="home" href="jmei.jsp"></a>
			<div class="header_login_box">
				<a href="" class="lighting top_link"></a>
				<a href="" class="top_link gild"></a>
				<a href="" class="top_link credit"></a>
			</div>
		</div>
	</div>
	<div id="content">
		<div id="login-text" class="loginWrap loginVerify">
			<div class="loginBox">
				<div class="loginImage"></div>
				<div class="loginBord">
					<div class="loginTit">
						<div class="signup">还没有聚美账号？<a href="regist.jsp">30秒注册</a></div>
						<h1>
							<strong>登录聚美</strong>
						</h1>
					</div>
					<div class="radio_wrapper" style="display:block;">
						<span>
							<input type="radio" checked="checked"></input>
							<label>手机动态密码登录</label>
						</span>
						<span>
							<input type="radio"></input>
							<label>普通登录</label>
						</span>
					</div>
					<form id="login-dynamic-form" style="display: block;" action="" method="post">
						<div class="textbox_ui user">
							<input id="dynamic_mobile" type="text" value="" placeholder="已注册的手机号码">
							<div class="focus_text">请输入11位电话号码</div>
							<div class="invalid">
								<i></i>
								<div class="msg">您输入的手机号码格式有误，需为 11 位数字格式</div>
							</div>
						</div>
						<div class="dynamic_pass_wrap line">
							
						</div>
					</form>
				</div>
				
			</div>
		</div>
	</div>
	<div id="foot">
		<div id="footer_copyright" class="footer-con">
			
		</div>
	</div>
</body>
</html>