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
	<link rel="stylesheet" type="text/css" href="../css/common.css"/>
	<link rel="stylesheet" type="text/css" href="../css/login.css"/>
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
							<input id="jtel" type="text" value="" placeholder="已注册的手机号码">
							<div class="focus_text">请输入11位电话号码</div>
							<div class="invalid">
								<i></i>
								<div class="msg" id="Telerror">您输入的手机号码格式有误，需为 11 位数字格式</div>
							</div>
						</div>
						<div class="dynamic_pass_wrap line">
							<div class="textbox_ui dynamic_pass pass">
								<input id="jpwd" type="text" placeholder="动态密码">
								<a href="" id="getPhoneCode" class="phonecode">
									<strong>获取手机动态密码</strong>
								</a>
							</div>	
						</div>
						<p>
							<label>
								<input type="checkbox" checked="checked"> 自动登录
							</label>
						</p>
						<input type="submit" style=" display: block;width: 100%;" value="登 录" class="loginbtn submit_btn">
					</form>
					<form id="login-user-form" method="post" action="" style="display:none;">
						<div class="textbox_ui user">
							<input id="username" type="text" placeholder="已验证手机/邮箱/用户名">
						</div>
						<div class="textbox_ui pass">
							<input id="login_password" type="password" autocomplete="off" placeholder="密码">
						</div>
						<div class="ver_text">
							<div style="line-height:30px;">验证码：点击与验证码相应的文字到验证码输入框内</div>
							<div class="textBtnsWrap">
								<div class="t_v_txt_btn"></div>
								<div class="t_v_txt_btn"></div>
								<div class="t_v_txt_btn"></div>
								<div class="t_v_txt_btn"></div>
								<div class="t_v_txt_btn"></div>
								<div class="t_v_txt_btn"></div>

							</div>
							<div class="input_big_wrap">
								<div class="inputWrap">
									<div class="t_v_input"></div>
									<div class="t_v_input"></div>
									<div class="t_v_input"></div>
									<a href="" class="t_v_delBtn"></a>
								</div>
								<div class="verImg"></div>
								<a href="" class="refresh_btn">换一张</a>
							</div>
							<div class="t_v_err"></div>
							<p>
								<a href="" class="fr">
									忘记密码？
								</a>
								<label>
									<input id="auto_login" type="checkbox" checked="checked">
									自动登陆
								</label>
							</p>
							<input class="loginbtn submit_btn" type="submit" style=" display: block;width: 100%;" value="登 录">
						</div>
					</form>
					<div class="iconAccout">
						<div>你也可以使用以下账号登录</div>
						<p>
							<a href="" class="a1"></a>
							<a href="" class="a2"></a>
							<a href="" class="a3"></a>
							<a href="" class="a4"></a>
							<a href="" class="a5"></a>
							<span>更多
								<i></i>
							</span>
						</p>
					</div>
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
</html>