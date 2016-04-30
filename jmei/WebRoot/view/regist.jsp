<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<title>注册-聚美账户</title>
	<Link Rel="SHORTCUT ICON" href="">
	<link rel="stylesheet" type="text/css" href="../css/common.css"/>
	<link rel="stylesheet" type="text/css" href="../css/regist.css"/>
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
		<div class="loginWrap">
			<div class="loginPic">
				<a href="" class="signup_link" target="_blank"></a>
				<div class="loginBord">
					<div class="loginTit">
						<div class="tosignup">
							已有账号
							<a href="">在此登录</a>
						</div>
						<h1>
							<strong>用户注册</strong>
						</h1>
					</div>
					<form id="phone" method="post" action="">
						<div class="line">
							<div class="textbox_ui">
								<input id="regtel" type="text" value="" autocomplete="off" autofocus="" placeholder="手机号">
							</div>
						</div>
						<div class="line verityWrap">
							<div class="textbox_ui sms_verify_wrapper">
								<input id="messagevf" type="text" autocomplete="off" placeholder="短信校验码">
							</div>
							<a href="" id="getPhoneCode" class="phonecode">
									<strong>获取短信校验码</strong>
							</a>
						</div>
						<div class="line">
							<div class="textbox_ui">
								<input id="password" type="password" autocomplete="off" placeholder="密码">
							</div>
						</div>
						<div class="line">
							<div class="textbox_ui">
								<input id="password2" type="password" autocomplete="off" placeholder="重复密码">
							</div>
						</div>
						<div class="act" style="margin-left: 0px;">
							<p>
								<input class="submit_btn" style="width: 100%;" type="submit"  name="mobileCommit" value="同意协议并注册">
							</p>
							<p>
								<a style="color:#ed145b;" target="_blank" rel="nofollow" href="http://www.jumei.com/help/user_terms">《聚美优品用户协议》</a>
							</p>
						</div>
					</form>
					<div class="shadow_l"></div>
					<div class="shadow_r"></div>
				</div>
			</div>
		</div>
	</div>
	<div class="clear"></div>
	<div id="foot">
		<div id="footer_copyright" class="footer-con">
			<p class="footer_copy_con">
				 Copyright &copy;2010-2015 北京创锐文化传媒有限公司 Jumei.com 保留一切权利。客服热线：400-123-8888<br>
				    京公网安备 11010102001226 号 |              | 
				  <a href="">京ICP证111033号</a>
				   | 食品流通许可证 SP1101051110165515（1-1）             | 
				   <a href="">营业执照</a>
			</p>
			<p>
				<a href="" class="footer_copy_logo logo01"></a>
				<a href="" class="footer_copy_logo logo02"></a>
				<a href="" class="footer_copy_logo logo03"></a>
				<a href="" class="footer_copy_logo logo04"></a>
				<a href="" class="footer_copy_logo logo05"></a>
			</p>
		</div>
	</div>
</body>