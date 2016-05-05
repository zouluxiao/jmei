<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	 <script type="text/javascript" src="../js/ajax.js"></script>
	  <script type="text/javascript" src="../js/jquery-1.7.min.js"></script>
	<script type="text/javascript">
		function change(){
			var obj1 = document.getElementById("tellogin");
			var obj2 = document.getElementById("commonlogin");
			var formobj1 = document.getElementById("login-dynamic-form");
			var formobj2 = document.getElementById("login-user-form");
			formobj1.className = "blok";
			formobj2.className = "non";
			obj2.checked = false;
		}
		function commonchange(){
			var obj1 = document.getElementById("tellogin");
			var formobj1 = document.getElementById("login-dynamic-form");
			var formobj2 = document.getElementById("login-user-form");
			formobj1.className = "non";
			formobj2.className = "blok";
			obj1.checked = false;
		}
		function ajax(){
	      	 //1.创建xhr对象 
	      	 var xhr;
	      	 if(window.XMLHttpRequest){
	      	 	xhr = new XMLHttpRequest(); //firefox
	      	 }else if(window.ActiveXObject){
	      	 	xhr = new ActiveXObject("Microsoft.XMLHTTP");
	      	 }
	      	 var url="${pageContext.request.contextPath}/user.do?method=getmessageped"; 
	      	 xhr.open("POST",url);
	      	 //3.设置请求的头部信息   GET不许设置头部信息
	      	 xhr.setRequestHeader("enctype","application/x-www-form-urlencoded");
	      	 
	      	 //4.发送消息   GET: xhr.send(null);
	      	 xhr.send("regtel="+document.getElementById("dynamic_mobile").value);
		}
		
		var count = 1;
		function selectPic(num){
			if(count == 1){
				var oimg = document.getElementById("img_1");
				var img = document.createElement("img");
				img.id="img1";
				img.src = document.getElementById("imgCode_"+num).src;
				img.style.height="40px";
	       	 	img.style.width="40px";
	       	 	img.style.position="relative";
	       	 	img.style.top="-2px";
				oimg.appendChild(img);
				count++;
				//document.getElementById("lowcode_1").value = document.getElementById("upCode_"+num).value;
				
			}else if(count == 2){
				var oimg = document.getElementById("img_2");
				var img = document.createElement("img");
				img.id="img2";
				img.src = document.getElementById("imgCode_"+num).src;
				img.style.height="40px";
	       	 	img.style.width="40px";
	       	 	img.style.position="relative";
	       	 	img.style.top="-2px";
				oimg.appendChild(img);
				count++;
				//document.getElementById("lowcode_2").value = document.getElementById("upCode_"+num).value;
				
			}else if(count == 3){
				var oimg = document.getElementById("img_3");
				var img = document.createElement("img");
				img.id="img3";
				img.src = document.getElementById("imgCode_"+num).src;
				img.style.height="40px";
	       	 	img.style.width="40px";
	       	 	img.style.position="relative";
	       	 	img.style.top="-2px";
				oimg.appendChild(img);
				//document.getElementById("lowcode_3").value = document.getElementById("upCode_"+num).value;
				count++;
				var url = "${pageContext.request.contextPath }/Verify";
				var jsonText = "gid=p";
				AjaxUtils.request("POST",url,jsonText,callback);
			}
			
		}
		//加载验证码
		function loadVerifyCode(){
			
		}
		
		function callback() {
			//判断验证码是否正确
			var code_1 = document.getElementById("code_1").value;
			var code_2 = document.getElementById("code_2").value;
			var code_3 = document.getElementById("code_3").value;
			
			var lowcode_1 = document.getElementById("lowcode_1").value;
			var lowcode_2 = document.getElementById("lowcode_2").value;
			var lowcode_3 = document.getElementById("lowcode_3").value;
			
			/* if((code_1 == lowcode_1) && (code_2 == lowcode_2) &&(code_3 == lowcode_3)){
				alert("验证码正确");
				return;
			} */
			
			//不正确切换
			updateCode();
		    //移除图片
		    var oimg1 = document.getElementById("img_1");
		    oimg1.removeChild(document.getElementById("img1"));
		    var oimg2 = document.getElementById("img_2");
		    oimg2.removeChild(document.getElementById("img2"));
		    var oimg3 = document.getElementById("img_3");
		    oimg3.removeChild(document.getElementById("img3"));
		    //计算器重置为1
		    count = 1;
		}
		
		/* $(document).ready(function(){
			var url = "${pageContext.request.contextPath }/Verify";
			var jsonText = "gid=1";
			AjaxUtils.request("POST",url,jsonText,callback);
		}) */
		
		function changei(obj){
			obj.style.boxShadow="0 0 5px rgba(12,82,248,.9)";
		}
		
		function changey(obj){
			obj.style.boxShadow="";
		}
		
		//验证码后退
		function subCode(){
			if(count == 2){
				var oimg1 = document.getElementById("img_1");
			    oimg1.removeChild(document.getElementById("img1"));
				count--;
			}else if(count == 3){
				var oimg2 = document.getElementById("img_2");
			    oimg2.removeChild(document.getElementById("img2"));
				count--;
			}			
		}
		//验证码图片更新
		function updateCode(){
			//访问Verify
			var url = "${pageContext.request.contextPath }/Verify";
			var jsonText = "gid=p";
			AjaxUtils.request("POST",url,jsonText,null);
			//更新图片
			var date = new Date();
			var imgObj = document.getElementById("imgCode_1");
			imgObj.src="${pageContext.request.contextPath}/Verify1?rand="+date.getTime();
			var imgObj = document.getElementById("imgCode_2");
			imgObj.src="${pageContext.request.contextPath}/Verify2?rand="+date.getTime();
			var imgObj = document.getElementById("imgCode_3");
			imgObj.src="${pageContext.request.contextPath}/Verify3?rand="+date.getTime();
			var imgObj = document.getElementById("imgCode_4");
			imgObj.src="${pageContext.request.contextPath}/Verify4?rand="+date.getTime();
			var imgObj = document.getElementById("imgCode_5");
			imgObj.src="${pageContext.request.contextPath}/Verify5?rand="+date.getTime();
			var imgObj = document.getElementById("imgCode_6");
			imgObj.src="${pageContext.request.contextPath}/Verify6?rand="+date.getTime();
			//切换下方验证码
			var imgObj = document.getElementById("verImg_id");
		    imgObj.src="${pageContext.request.contextPath}/VerifyCode?rand="+date.getTime();
			//更换隐含框的值
		    document.getElementById("code_1").value = "${sessionScope.code[0]}";
			document.getElementById("code_2").value = "${sessionScope.code[1]}";
			document.getElementById("code_3").value = "${sessionScope.code[2]}";
		}
	</script>
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
							<input type="radio" checked="checked" id="tellogin" onclick="change();"></input>
							<label>手机动态密码登录</label>
						</span>
						<span>
							<input type="radio" id="commonlogin" onclick="commonchange();"></input>
							<label>普通登录</label>
						</span>
					</div>
					<form id="login-dynamic-form" class="blok" action="${pageContext.request.contextPath}/user.do?method=login" method="post">
						<div class="textbox_ui user">
							<input id="dynamic_mobile" name="dynamic_mobile" type="text" value="" placeholder="已注册的手机号码">
							<div class="focus_text">请输入11位电话号码</div>
							<div class="invalid">
								<i></i>
								<div class="msg">您输入的手机号码格式有误，需为 11 位数字格式</div>
							</div>
						</div>
						<div class="dynamic_pass_wrap line">
							<div class="textbox_ui dynamic_pass pass">
								<input id="dynamic_password" name="dynamic_password" type="text" placeholder="动态密码" >
								<a id="getPhoneCode" class="phonecode" onclick="ajax();">
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
					<form id="login-user-form" method="post" action="${pageContext.request.contextPath}/user.do?method=logincommon" class="non">
						<div class="textbox_ui user">
							<input id="username" name="username" type="text" placeholder="已验证手机/邮箱">
						</div>
						<div class="textbox_ui pass">
							<input id="login_password" name="login_password" type="password" autocomplete="off" placeholder="密码">
						</div>
						<div class="ver_text">
							<div style="line-height:30px;">验证码：点击与验证码相应的文字到验证码输入框内</div>
							<div class="textBtnsWrap">
								<c:if test="${empty sessionScope.Code_1}">
									
								</c:if>
								<input type="hidden" value="${sessionScope.Code_1 }" id="upcode_1"/>
								<input type="hidden" value="${sessionScope.Code_2 }" id="upcode_2"/>
								<input type="hidden" value="${sessionScope.Code_3 }" id="upcode_3"/>
								<input type="hidden" value="${sessionScope.Code_4 }" id="upcode_4"/>
								<input type="hidden" value="${sessionScope.Code_5 }" id="upcode_5"/>
								<input type="hidden" value="${sessionScope.Code_6 }" id="upcode_6"/>
								<img onmousemove="changei(this);" onmouseout="changey(this);" class="t_v_txt_btn" id="imgCode_1" onclick="selectPic(1);" src="${pageContext.request.contextPath }/Verify1"></img>
								<img onmousemove="changei(this);" onmouseout="changey(this);" class="t_v_txt_btn" id="imgCode_2" onclick="selectPic(2);" src="${pageContext.request.contextPath }/Verify2"></img>
								<img onmousemove="changei(this);" onmouseout="changey(this);" class="t_v_txt_btn" id="imgCode_3" onclick="selectPic(3);" src="${pageContext.request.contextPath }/Verify3"></img>
								<img onmousemove="changei(this);" onmouseout="changey(this);" class="t_v_txt_btn" id="imgCode_4" onclick="selectPic(4);" src="${pageContext.request.contextPath }/Verify4"></img>
								<img onmousemove="changei(this);" onmouseout="changey(this);" class="t_v_txt_btn" id="imgCode_5" onclick="selectPic(5);" src="${pageContext.request.contextPath }/Verify5"></img>
								<img onmousemove="changei(this);" onmouseout="changey(this);" class="t_v_txt_btn" id="imgCode_6" onclick="selectPic(6);" src="${pageContext.request.contextPath }/Verify6"></img>
							</div>
							<div class="input_big_wrap">
								<div class="inputWrap">
									<input type="hidden" value="" id="lowcode_1"/>
									<input type="hidden" value="" id="lowcode_2"/>
									<input type="hidden" value="" id="lowcode_3"/>
									<div class="t_v_input" id="img_1"></div>
									<div class="t_v_input" id="img_2"></div>
									<div class="t_v_input" id="img_3"></div>
									<a class="t_v_delBtn" onclick="subCode();"></a>
								</div>
								<input type="hidden" value="${sessionScope.Code[0] }" id="code_1"/>
								<input type="hidden" value="${sessionScope.Code[1] }" id="code_2"/>
								<input type="hidden" value="${sessionScope.Code[2] }" id="code_3"/>
								<img onclick="updateCode();" class="verImg" id="verImg_id" src="${pageContext.request.contextPath }/VerifyCode"></img>
								<a onclick="updateCode();" class="refresh_btn">换一张</a>
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