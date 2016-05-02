<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<title>用户中心-聚美优品</title>
	<link rel="stylesheet" type="text/css" href="../css/common.css"/>
	<link rel="stylesheet" type="text/css" href="../css/jmeihead.css">
	<link rel="stylesheet" type="text/css" href="../css/personal.css"/>
	<link rel="stylesheet" type="text/css" href="../css/foot.css"/>
	<script type="text/javascript" src="../js/personal.js"></script>
	<script type="text/javascript">
		function getmesaage(){
			 //1.创建xhr对象 
	      	 var xhr;
	      	 if(window.XMLHttpRequest){
	      	 	xhr = new XMLHttpRequest(); //firefox
	      	 }else if(window.ActiveXObject){
	      	 	xhr = new ActiveXObject("Microsoft.XMLHTTP");
	      	 }
	      	 var url="${pageContext.request.contextPath}/user.do?method=getaddemail"; 
	      	 xhr.open("GET",url);
	      	 //3.设置请求的头部信息   GET不许设置头部信息
	      	 //xhr.setRequestHeader("enctype","application/x-www-form-urlencoded");
	      	 
	      	 //4.发送消息   GET:
	      	 xhr.send(null);
	      	 //xhr.send("regtel="+document.getElementById("regtel").value);
		}
		
		function change(){
    		var imageObj =document.getElementById("change_code");
    		var date=new Date();
    		imageObj.src="/jmei/verifyServlet?rand="+date.getTime();
    	}
		function getid(id){
			return document.getElementById(id);
		}
		
		function onclick1(){
			var obj6 = getid("myorder");
			var obj7 = getid("mycollection");
			var obj8 = getid("personal");
			var obj9 = getid("mypwd");
			var obj10 = getid("myaddress");
			var obj1 = getid("order");
			var obj2 = getid("collection");
			var obj3 = getid("personalinfo");
			var obj4 = getid("updatepwd");
			var obj5 = getid("address");
			var obj11= getid("updateemail");
			obj11.className="non";
			obj1.className ="list selected";
			obj2.className ="list";
			obj3.className ="list";
			obj4.className ="list";
			obj5.className ="list";
			obj6.className ="blok";
			obj7.className ="non";
			obj8.className ="non";
			obj9.className ="non";
			obj10.className ="non";
			
		}
		function onclick2(){
			var obj6 = getid("myorder");
			var obj7 = getid("mycollection");
			var obj8 = getid("personal");
			var obj9 = getid("mypwd");
			var obj10 = getid("myaddress");
			var obj1 = getid("order");
			var obj2 = getid("collection");
			var obj3 = getid("personalinfo");
			var obj4 = getid("updatepwd");
			var obj5 = getid("address");
			var obj11= getid("updateemail");
			obj11.className="non";
			obj1.className ="list";
			obj2.className ="list selected";
			obj3.className ="list";
			obj4.className ="list";
			obj5.className ="list";
			obj6.className ="non";
			obj7.className ="blok";
			obj8.className ="non";
			obj9.className ="non";
			obj10.className ="non";
			
		}
		function onclick3(){
			var obj6 = getid("myorder");
			var obj7 = getid("mycollection");
			var obj8 = getid("personal");
			var obj9 = getid("mypwd");
			var obj10 = getid("myaddress");
			var obj1 = getid("order");
			var obj2 = getid("collection");
			var obj3 = getid("personalinfo");
			var obj4 = getid("updatepwd");
			var obj5 = getid("address");
			var obj11= getid("updateemail");
			obj11.className="non";
			obj1.className ="list";
			obj2.className ="list";
			obj3.className ="list selected";
			obj4.className ="list";
			obj5.className ="list";
			obj6.className ="non";
			obj7.className ="non";
			obj8.className ="blok";
			obj9.className ="non";
			obj10.className ="non";
		}
		function onclick4(){
			var obj6 = getid("myorder");
			var obj7 = getid("mycollection");
			var obj8 = getid("personal");
			var obj9 = getid("mypwd");
			var obj10 = getid("myaddress");
			var obj1 = getid("order");
			var obj2 = getid("collection");
			var obj3 = getid("personalinfo");
			var obj4 = getid("updatepwd");
			var obj5 = getid("address");
			var obj11= getid("updateemail");
			obj11.className="non";
			obj1.className ="list";
			obj2.className ="list";
			obj3.className ="list";
			obj4.className ="list selected";
			obj5.className ="list";
			obj6.className ="non";
			obj7.className ="non";
			obj8.className ="non";
			obj9.className ="blok";
			obj10.className ="non";
			
		}
		function onclick5(){
			var obj6 = getid("myorder");
			var obj7 = getid("mycollection");
			var obj8 = getid("personal");
			var obj9 = getid("mypwd");
			var obj10 = getid("myaddress");
			var obj1 = getid("order");
			var obj2 = getid("collection");
			var obj3 = getid("personalinfo");
			var obj4 = getid("updatepwd");
			var obj5 = getid("address");
			var obj11= getid("updateemail");
			obj11.className="non";
			obj1.className ="list";
			obj2.className ="list";
			obj3.className ="list";
			obj4.className ="list";
			obj5.className ="list selected";
			obj6.className ="non";
			obj7.className ="non";
			obj8.className ="non";
			obj9.className ="non";
			obj10.className ="blok";
			getaddress();
		}
		function getaddress(){
			alert("到这里了");
			 //1.创建xhr对象 
	      	 var xhr;
	      	 if(window.XMLHttpRequest){
	      	 	xhr = new XMLHttpRequest(); //firefox
	      	 }else if(window.ActiveXObject){
	      	 	xhr = new ActiveXObject("Microsoft.XMLHTTP");
	      	 }
	      	 var url="${pageContext.request.contextPath}/address.do?method=getaddress"; 
	      	 xhr.open("GET",url);
	      	 //3.设置请求的头部信息   GET不许设置头部信息
	      	 //xhr.setRequestHeader("enctype","application/x-www-form-urlencoded");
	      	 
	      	 //4.发送消息   GET:
	      	 xhr.send(null);
	      	 //xhr.send("regtel="+document.getElementById("regtel").value);
		}
		function email(){
			var obj6 = getid("myorder");
			var obj7 = getid("mycollection");
			var obj8 = getid("personal");
			var obj9 = getid("mypwd");
			var obj10 = getid("myaddress");
			var obj1 = getid("order");
			var obj2 = getid("collection");
			var obj3 = getid("personalinfo");
			var obj4 = getid("updatepwd");
			var obj5 = getid("address");
			var obj11= getid("updateemail");
			obj11.className="blok";
			obj1.className ="list";
			obj2.className ="list";
			obj3.className ="list selected";
			obj4.className ="list";
			obj5.className ="list";
			obj6.className ="non";
			obj7.className ="non";
			obj8.className ="non";
			obj9.className ="non";
			obj10.className ="non";
		}
	</script>
</head>
<body class="OnSale">
	<div class="header header_wide_lv2" style="width:1349px;height: 100%;">
		<div class="header_top">
			<div class="header_top_box" style="width:960px;">
				<!--login-->
				<ul class="header_top_left" id="headerTopLeft">
					<li>欢迎来到聚美！</li>
					<li><a href="">请登录</a></li>
					<li><a href="">快速注册</a></li>
				</ul>
				<!--login end-->
				<!--city choose-->
				<div class="default-city" style="visibility:visible">
					<span class="add-city-icons">送至 <span
						class="add-default-city">广东</span> <s class="icon_arrow_down"></s>
						<i class="user-local-icon" style="display:none;"></i>
					</span>
					<div class="header-city-list" style="height:auto;display:none">
						<dl class="user-local-city"></dl>
						<div class="city-loading hidden"></div>
					</div>
				</div>
				<!--city choose end-->
				<!--right list-->
				<ul class="header_top_right" id="headerTopRight">
					<li><a href="">正品保证</a></li>
					<li><a href="">订单查询</a></li>
					<li><a href=""> <s class="icon_favorite"></s>收藏的商品
					</a></li>
					<li class="item_ijumei"><a href="">我的聚美 <s
							class="icon_arrow_back"></s>
					</a> <i class="icon_arrow_back"></i></li>
					<li class="item_mobile"><a href=""> <span class="line"></span>
							<s class="icon_mobile"></s>手机聚美
					</a></li>
					<li class="item_koubei"><a href=""> <s class="icon_koubei"></s>口碑中心
					</a></li>
					<li id="seemore"><span class="line"></span></li>
					<li class="item_more"><a href="">更多 <s
							class="icon_arrow icon_arrow_down"></s></a> <i
						class="icon_arrow_back"></i></li>
				</ul>
				<!--right list end-->
			</div>
		</div>
		<div class="header_center" style="width:960px;">
			<h1 class="logo">
				<a></a>
			</h1>
			<div class="cart_box">
				<a class="cart_link"> <img src="../images/jmeihead/cart.gif"
					class="cart_gif" width="28" height="28"></img> <span class="text">去购物车结算</span>
					<span class="num" style="display: none;"></span> <s
					class="icon_arrow_right"></s>
				</a>
				<div class="cart_content"></div>
			</div>
		</div>
		<div class="header_bottom">
			<div class="channel_nav_box" >
				<div class="channel_nav_list_wrap" style="width:960px;">
					<ul class="channel_nav_list">
						<li class="current"><a href="" class="home">首页</a></li>
						<li class=""><a href="">极速免税店</a></li>
						<li class="gif_301_wrap"><a href="" class="gif_301"> <img
								src="../images/jmeihead/muy1.gif"></img>
						</a></li>
						<li class=""><a href="">美妆商城<b></b></a></li>
						<li class="gif_301_wrap"><a href="" class="gif_301"> <img
								src="../images/jmeihead/lux2.jpg"></img>
						</a></li>
						<li class=""><a href="">服装运动</a></li>
						<li class=""><a href="">鞋包配饰</a></li>
					</ul>
					<div></div>
					<ul class="icon_Wrap">
						<li>
							<div class="divlist divlist01">
								<a href=""> <span class=""></span>
								</a>
							</div>
						</li>
						<li>
							<div class="divlist divlist02">
								<a href=""> <span class="th"></span>
								</a>
							</div>
						</li>
						<li>
							<div class="divlist divlist03">
								<a href=""> <span class="pop_by"></span>
								</a>
							</div>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div class="profile">
		<div class="nav">
			<div class="notice">
				<a style="border-bottom: 0;padding:0;" target="_blank" href="">
					<img src="..//images/personal/64_64.png">
				</a>
				<p class="nickname">
					<a target="_blank" href="" style="padding-left:0;line-height: 1.8;color:#ed145b" id="username">${sessionScope.juser.jname}</a>
				</p>
				<p>
					<a href="" target="_blank" style="padding-left:0;line-height: normal;">普通会员</a>
				</p>
				<p id="juserid" class="uid">用户ID:${sessionScope.juser.jid}</p>
			</div>
			<h2>
				<b></b>
				我的聚美优品
			</h2>
			<a  class="list selected" id="order" onclick="onclick1();">
				<b></b>
				我的订单
			</a>
			<a  class="wish">
				<b></b>
				我的心愿单
			</a>
			<a class="fav" id="collection" onclick="onclick2();">
				<b></b>
				我的收藏
			</a>
			<a href="" class="member">
				<b></b>
				我的会员等级
			</a>
			<a href="" class="cards">
				<b></b>
				我的现金券
			</a>
			<a href="" class="envelope">
				<b></b>
				我的红包
			</a>
			<a href="" class="credit">
				<b></b>
				我的金币
			</a>
			<a href="" class="code new">
				<b></b>
				我的邀请码
			</a>
			<a href="" class="trial">
				<b></b>
				我的Free派
			</a>
			<a href="" class="code new">
				<b></b>
				我的尺码
			</a>
			<a href="" class="subscribe">
				<b></b>
				订阅邮件短信
			</a>
			<h2>
				<b></b>
				管理个人账户
			</h2>
			<a href="" class="balance">
				<b></b>
				我的余额
			</a>
			<a href="" class="balance">
				<b></b>
				我的提现退款
			</a>
			<a href="" class="giftcard">
				<b></b>
				我的礼品卡
			</a>
			<a  class="settings" id="personalinfo" onclick="onclick3();">
				<b></b>
				设置账户信息
			</a>
			<a class="password" id="updatepwd" onclick="onclick4();">
				<b></b>
				修改密码
			</a>
			<a href="" class="bind">
				<b></b>
				绑定手机
			</a>
			<a  class="addr" id="address" onclick="onclick5();">
				<b></b>
				管理收货地址
			</a>
			<a href="" class="share">
				<b></b>
				绑定站外分享
			</a>
			<h2>
				<b></b>
				售后服务
			</h2>
			<a href="" class="rmapre">
				<b></b>
				我的售后咨询
			</a>
			<a href="" class="rmalist">
				<b></b>
				我的退货
			</a>
			<h2>
				<b></b>
				聚美惊喜
			</h2>
			<a href="" class="lucky">
				<b></b>
				我的喜从盒来
			</a>
			<a href="" class="gift">
				<b></b>
				兑换VIP卡
			</a>
		</div>
		<div id="myorder" class="blok">
			<h1>
			<a target="_blank" href="http://www.jumei.com/i/activity/download_app">手机客户端，随时随地查看物流详情</a>
			我的订单
			</h1>
			<div class="content">
				<div class="filter">
					<a class="curr"  id="orderalllist" onclick="ajax();">全部订单</a>
					<a class="" id="waitlist">等待付款</a>
					<a class="" id="buylist">已付款</a>
					<a class="" id="endlist">交易完成</a>
					<a class="">预售订单</a>
				</div>
				<table id="order-list" class="order_table">
				<tbody>
					<tr class="order_list_title">
						<th style="width: 191px">订单信息</th>
						<th style="width: 80px">订购商品</th>
						<th style="width: 40px">件数</th>
						<th style="width: 80px">单价</th>
						<th style="width: 70px">商品操作</th>
						<th style="width: 120px">订单状态</th>
						<th style="width: 90px">订单操作</th>
					</tr>
					<td class="order_info_td"></td>
					<td class="item_title"></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<tr class="separator">
						<td colspan="7"></td>
					</tr>
				</tbody>
				</table>

				<a href="#" class="backtotop">
					<b></b>
					回到顶部
				</a>
				<div class="pageSplit"></div>
				<div class="cross_sale">
					<h2>您也许还喜欢</h2>
					<ul>
						<li>
							<a href="http://item.jumei.com/3848.html" target="_blank">
								<img src="..//images/personal/3848_160_160.jpg">
								<div class="name"> 比度克绿泥净肤面膜220g </div>
							</a>
							<p class="price">
									￥
									<strong>69</strong>
							</p>
							<p class="later">
									最近
									<strong>76</strong>
									人购买
							</p>
						</li>
						<li>
							<a href="http://item.jumei.com/3848.html" target="_blank">
								<img src="..//images/personal/6935_160_160.jpg">
								<div class="name">丝塔芙洁面乳118ml </div>
							</a>
							<p class="price">
									￥
									<strong>46</strong>
								</p>
								<p class="later">
									最近
									<strong>47</strong>
									人购买
								</p>
						</li>
						<li>
							<a href="http://item.jumei.com/3848.html" target="_blank">
								<img src="..//images/personal/17542_160_160.jpg">
								<div class="name">魔法城堡化妆棉  200片 </div>
							</a>
							<p class="price">
									￥
									<strong>24.9</strong>
								</p>
								<p class="later">
									最近
									<strong>684</strong>
									人购买
								</p>
						</li>
						<li>
							<a href="http://item.jumei.com/3848.html" target="_blank">
								<img src="..//images/personal/230856_160_160.jpg">
								<div class="name">珀莱雅新柔皙亮肤补水套装</div>
							</a>
							<p class="price">
									￥
									<strong>155</strong>
								</p>
								<p class="later">
									最近
									<strong>5</strong>
									人购买
								</p>
						</li>
						<li>
							<a href="http://item.jumei.com/3848.html" target="_blank">
								<img src="..//images/personal/231258_160_160.jpg">
								<div class="name">SUEE果酸嫩肤丝滑身体乳 380ml </div>
							</a>
							<p class="price">
									￥
									<strong>63.9</strong>
								</p>
								<p class="later">
									最近
									<strong>3</strong>
									人购买
								</p>
						</li>
						<li>
							<a href="http://item.jumei.com/3848.html" target="_blank">
								<img src="..//images/personal/811427_160_160.jpg">
								<div class="name">森田润透靓白面膜</div>
							</a>
							<p class="price">
									￥
									<strong>39</strong>
								</p>
								<p class="later">
									最近
									<strong>16488</strong>
									人购买
								</p>
						</li>
						<li>
							<a href="http://item.jumei.com/3848.html" target="_blank">
								<img src="..//images/personal/1095430_160_160.jpg">
								<div class="name"> 御泥坊双重莹润透亮面膜套装21片</div>
								
							</a>
							<p class="price">
									￥
									<strong>79.9</strong>
								</p>
								<p class="later">
									最近
									<strong>18273</strong>
									人购买
								</p>
						</li>
						<li>
							<a href="http://item.jumei.com/3848.html" target="_blank">
								<img src="..//images/personal/1098605_160_160.jpg">
								<div class="name">欧诗漫营养美肤晶彩无瑕礼盒</div>
								
							</a>
							<p class="price">
									￥
									<strong>139.9</strong>
								</p>
								<p class="later">
									最近
									<strong>13947</strong>
									人购买
								</p>
						</li>
					</ul>
				</div>
			</div>
		</div>
		<div id="mycollection" class="non" onclick="ajaxcollection();">
			<h1>我的收藏</h1>
			<div class="content myfav">
				<div class="notice_content">收藏心仪的产品或品牌，方便你随时找到它们，也有助于根据你的收藏给你更加贴心的推荐</div>
				<div class="filter">
					<a class="curr" href="http://i.jumei.com/i/product/fav_products">我收藏的产品</a>
					<a href="http://i.jumei.com/i/product/fav_brands">我收藏的品牌</a>
				</div>
				<div id="fav_product_list">
					<div class="fav_product_container faved">
						<div class="fav_product_head">
							<span class="fph_tit">
								您共收藏了
								<label class="pink">1</label>
								个产品 
							</span>
							<div class="head_page">
								<div style="float:left; display:inline;margin-right:5px;">
									<span class="pink">1</span>
									/1页 
								</div>
								<a href="" class="hp_prev"></a>
								<a href="" class="hp_next"></a>
							</div>
						</div>
						<div class="fav_product_list">
							<ul>
								<li class="fav_deal" style="border: 3px solid rgb(255, 255, 255);">
									<a href="" class="img_wrap">
										<img src="">
									</a>
									<p class="pro_tit">
										<a href=""></a>
									</p>
									<a href="" class="pro_price  soldout ">
										<strong>
											<span>￥</span>

										</strong>
									</a>
								</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div id="personal" class="non">
			<h1>设置账户信息</h1>
			<div class="content">
				<form id="settings-form" action="" method="post">
					<div class="avatar_change" id="ppic">
						<img alt="大头像" src="..//images/personal/200_200.png">
						<a href="" class="changeavatar">修改头像</a>
					</div>
					<div class="input_container" >
						<label for="settings-username">
							<span class="spark">
								*
							</span>
							用户名
						</label>
						<input type="text" id="personname" class="t_input" value="${sessionScope.juser.jname}" name="username" size="30" required="">
					</div>
					<dl class="formlist">
						<dt>Email</dt>
						<dd>
							<span class="data">您还未绑定邮箱</span>
							<a class="btn_mid_pink" onclick="email();">立即绑定</a>
						</dd>
					</dl>
					<dl class="formlist" style="margin-top:16px;">
						<dt>手机号</dt>
						<dd>
							<span class="data" id="ptel">${sessionScope.juser.jtel}
							</span>
							<a href="" target="_blank">修改</a>
							<span class="hint">已验证</span>
						</dd>
					</dl>
					<div class="input_container">
						<label>性别</label>
						<label class="radio">
								<input id="pgender" type="radio" checked="checked" value="2" autocomplete="off" name="gender">
							女
						</label>
						<label class="radio">
								<input id="pgenderm" type="radio" checked="checked" value="2" autocomplete="off" name="gender">
							男
						</label>
					</div>
					<div class="input_container">
						<label>
							<span class="spark">*</span>
							生日
						</label>
						<span class="select_ui">
							<div class="select_arrow"></div>
							<select id="birthday_year" name="birthday_year">
								<option value="" selected="selected"></option>
								<option value="2010">2010</option>
								<option value="2009">2009</option>
								<option value="2008">2008</option>
								<option value="2007">2007</option>
								<option value="2006">2006</option>
								<option value="2005">2005</option>
								<option value="2004">2004</option>
								<option value="2003">2003</option>
								<option value="2002">2002</option>
								<option value="2001">2001</option>
								<option value="2000">2000</option>
								<option value="1999">1999</option>
								<option value="1998">1998</option>
								<option value="1997">1997</option>
								<option value="1996">1996</option>
								<option value="1995">1995</option>
								<option value="1994">1994</option>
								<option value="1993">1993</option>
								<option value="1992">1992</option>
								<option value="1991">1991</option>
								<option value="1990">1990</option>
								<option value="1989">1989</option>
								<option value="1988">1988</option>
								<option value="1987">1987</option>
								<option value="1986">1986</option>
								<option value="1985">1985</option>
								<option value="1984">1984</option>
								<option value="1983">1983</option>
								<option value="1982">1982</option>
								<option value="1981">1981</option>
								<option value="1980">1980</option>
								<option value="1979">1979</option>
								<option value="1978">1978</option>
								<option value="1977">1977</option>
								<option value="1976">1976</option>
								<option value="1975">1975</option>
								<option value="1974">1974</option>
								<option value="1973">1973</option>
								<option value="1972">1972</option>
								<option value="1971">1971</option>
								<option value="1970">1970</option>
								<option value="1969">1969</option>
								<option value="1968">1968</option>
								<option value="1967">1967</option>
								<option value="1966">1966</option>
								<option value="1965">1965</option>
								<option value="1964">1964</option>
								<option value="1963">1963</option>
								<option value="1962">1962</option>
								<option value="1961">1961</option>
								<option value="1960">1960</option>
								<option value="1959">1959</option>
								<option value="1958">1958</option>
								<option value="1957">1957</option>
								<option value="1956">1956</option>
								<option value="1955">1955</option>
								<option value="1954">1954</option>
								<option value="1953">1953</option>
								<option value="1952">1952</option>
								<option value="1951">1951</option>
								<option value="1950">1950</option>
								<option value="1949">1949</option>
							</select>
							<div class="select_text_ui"  style="min-width: 2.5em;"> </div>	
						</span>
						<span class="select_ui">
							<div class="select_arrow"></div>
							<select id="birthday_year" name="birthday_year">
								<option value="" selected="selected"></option>
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
								<option value="6">6</option>
								<option value="7">7</option>
								<option value="8">8</option>
								<option value="9">9</option>
								<option value="10">10</option>
								<option value="11">11</option>
								<option value="12">12</option>
							</select>
							<div class="select_text_ui"  style="min-width: 1.5em;"> </div>	
						</span>
						<span class="select_ui">
							<div class="select_arrow"></div>
							<select id="birthday_month" name="birthday_month">
								<option value="" selected="selected"></option>
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
								<option value="6">6</option>
								<option value="7">7</option>
								<option value="8">8</option>
								<option value="9">9</option>
								<option value="10">10</option>
								<option value="11">11</option>
								<option value="12">12</option>
								<option value="13">13</option>
								<option value="14">14</option>
								<option value="15">15</option>
								<option value="16">16</option>
								<option value="17">17</option>
								<option value="18">18</option>
								<option value="19">19</option>
								<option value="20">20</option>
								<option value="21">21</option>
								<option value="22">22</option>
								<option value="23">23</option>
								<option value="24">24</option>
								<option value="25">25</option>
								<option value="26">26</option>
								<option value="27">27</option>
								<option value="28">28</option>
								<option value="29">29</option>
								<option value="30">30</option>
								<option value="31">31</option>
							</select>
							<div class="select_text_ui"  style="min-width: 1.5em;"> </div>	
						</span>
						<div class="act">
							<span class="status_red">准确填写生日，有机会获得更多惊喜哦！</span>
						</div>
					</div>
					<div class="input_container">
							<label>隐私</label>
							<label class="checkbox">
									<input id="hide_privacy" type="checkbox" name="hide_privacy" value="1">
								不显示我的年龄 			
							</label>
							<label class="checkbox">
									<input id="hide_privacy" type="checkbox" name="hide_privacy" value="1">
								在口碑中心显示我的美妆 					
							</label>
					</div>
					<div class="input_container selectwidth">
						<label for="skin_type">
							<span class="spark">
								*
							</span>
							你的皮肤属于
						</label>
						<span class="select_ui">
							<div class="select_arrow"></div>
							<select id="skin_type" name="skin_type">
								<option value="" selected="selected"></option>
								<option value="油性皮肤">油性皮肤</option>
								<option value="干性皮肤">干性皮肤</option>
								<option value="中性皮肤">中性皮肤</option>
								<option value="混合性皮肤">混合性皮肤</option>
								<option value="敏感型皮肤">敏感型皮肤</option>
								<option value="敏感油性皮肤">敏感油性皮肤</option>
								<option value="敏感干性皮肤">敏感干性皮肤</option>
								<option value="敏感中性皮肤">敏感中性皮肤</option>
								<option value="敏感混合性皮肤">敏感混合性皮肤</option>
							</select>
							<div class="select_text_ui"  style="min-width: 6.5em;"> </div>	
						</span>
					</div>
					<div class="input_container selectwidth">
						<label for="skin_type">
							<span class="spark">
								*
							</span>
							你的发质属于
						</label>
						<span class="select_ui">
							<div class="select_arrow"></div>
							<select id="hair_type" name="hair_type">
								<option value="" selected="selected"></option>
								<option value="油性发质">油性发质</option>
								<option value="干性发质">干性发质</option>
								<option value="中性发质">中性发质</option>
								<option value="混合性发质">混合性发质</option>
								<option value="受损发质">受损发质</option>
								<option value="头屑发质">头屑发质</option>
								<option value="无生气发质">无生气发质</option>
								<option value="脱落发质">脱落发质</option>
							</select>
							<div class="select_text_ui"  style="min-width: 6.5em;"> </div>	
						</span>
					</div>
						<div class="input_container selectwidth">
						<label for="skin_type">
							<span class="spark">
								*
							</span>
							你的美容年消费
						</label>
						<span class="select_ui">
							<div class="select_arrow"></div>
							<select id="purchasing_power" name="purchasing_power">
								<option value="" selected="selected"></option>
								<option value="0-499">0-499</option>
								<option value="500-999">500-999</option>
								<option value="1000-2999">1000-2999</option>
								<option value="3000-4999">3000-4999</option>
								<option value="5000-6999">5000-6999</option>
								<option value="7000-9999">7000-9999</option>
								<option value="10000-19999">10000-19999</option>
								<option value="20000-29999">20000-29999</option>
								<option value="30000以上">30000以上</option>
							</select>
							<div class="select_text_ui"  style="min-width: 6.5em;"> </div>	
						</span>
					</div>
					<div class="input_container">
						<label for="comment">美丽宣言</label>
						<textarea id="comment" name="comment" cols="50" rows="8"></textarea>
						<p class="comment_tip">
							您已输入
							<span class="dg dg1">0</span>
							个字符，
							<span class="tip_text2">还能输入</span>
							<span class="dg dg2">200</span>
							个字符
						</p>
						<div style="margin-left: 130px;margin-top: 8px;color: #ed145b;">美丽宣言为个人设置信息,小美不会为您自动填写哦!</div>
					</div>
					<div class="act">
						<input id="settings-submit" type="button" name="commit" value="保存修改">
					</div>
				</form>
			</div>
		</div>
		<div id="updateemail" class="non">
			<h1>修改邮箱</h1>
			<div class="content change_email">
				<div class="notice_content">正确的邮箱，可帮助您进行安全验证等操作，有效保护您的账户安全；也有助于您收到来自聚美的最新特惠通知</div>
				<div class="change_email_cont">
					<p style="padding-left: 2em;">为确保信息安全，重新绑定邮箱需要输入手机校验码</p>
					<form action="${pageContext.request.contextPath}/user.do?method=addemail" id="subscribe_form" class="mobile_subscribe" method="post">
						<dl class="datalist">
							<dt>已绑定手机号：</dt>
							<dd>
								${sessionScope.juser.jtel}
								<input id="get_confirm_code" class="get_confirm_code" type="button" value="获取手机校验码" name="get_confirm_code" onclick="getmesaage();">
							</dd>
						</dl>
						<div class="input_container">
							<label for="confirm_code">校验码：</label>
							<input id="confirm_code" name="confirm_code" class="default_value" type="text" maxlength="6" name="confirm_code">
						</div>
						<div class="input_container">
							<label for="verify_code">验证码：</label>
							<input id="verify_code" name="verify_code" type="text" autocomplete="off" maxlength="4" name="hash_code">
						</div>
						<div class="input_container">
							<label for="email">验证邮箱：</label>
							<input id="email" type="text" name="email" size="20">
						</div>
						<div class="act">
							<img id="code" src="/jmei/verifyServlet">
							<a id="change_code" href="javascript:void(0);" onclick="change();">换一张</a>
						</div>
						<div class="act">
							<input id="change_email" type="button" name="change_email" value="提交验证">
						</div>
					</form>
				</div>
			</div>
		</div>
		<div id="mypwd" class="non" >
			<h1>修改密码</h1>
			<div class="content">
				<div class="container">
					<div class="content" data-reactid=".0"></div>
					<form id="settings-form" data-reactid=".0.0" name="settings_form" action="" method="post">
						<div data-reactid=".0.0.0">
							<div data-reactid=".0.0.0.0">
								<div class="input_container shorter" data-reactid=".0.0.0.0.0">
									<label data-reactid=".0.0.0.0.0.0">
										<span class="spark" data-reactid=".0.0.0.0.0.0.0"> *</span>
										<span data-reactid=".0.0.0.0.0.0.1">选择验证身份方式</span>
									</label>
									<label class="radio" data-reactid=".0.0.0.0.0.1">
										<input class="radiobox" type="radio" data-reactid=".0.0.0.0.0.1.0" checked="" name="method" value="0">
										<span data-reactid=".0.0.0.0.0.1.1"> 手机验证</span>
									</label>
									<label class="radio" data-reactid=".0.0.0.0.0.2">
									<input class="radiobox" type="radio" data-reactid=".0.0.0.0.0.2.0" name="method" value="1">
									<span data-reactid=".0.0.0.0.0.2.1"> 密码验证</span>
									</label>
								</div>
							</div>
							<div data-reactid=".0.0.0.1">
								<div class="input_container shorter" data-reactid=".0.0.0.1.0">
									<label data-reactid=".0.0.0.1.0.0" for="mobile">
										<span class="spark" data-reactid=".0.0.0.1.0.0.0">* </span>
										<span data-reactid=".0.0.0.1.0.0.1">手机号</span>
									</label>
									<span class="mobile_masked" data-reactid=".0.0.0.1.0.1">
										<span data-reactid=".0.0.0.1.0.1.0">153****0309</span>
										<span data-reactid=".0.0.0.1.0.1.1"> </span>
										<a class="change_mobile" data-reactid=".0.0.0.1.0.1.2" target="_blank" href="/i/account/mobile_bind">修改</a>	
									</span>
								</div>
								<div class="input_container" data-reactid=".0.0.0.1.1">
									<label data-reactid=".0.0.0.1.1.0" for="verify_code">
										<span class="spark" data-reactid=".0.0.0.1.1.0.0">* </span>
										<span data-reactid=".0.0.0.1.1.0.1">短信校验码</span>
									</label>
									<input id="verify_code" class="" type="text" data-reactid=".0.0.0.1.1.1" autocomplete="off" name="verify_code" placeholder="">
									<a class="btn_send_sms disabled" data-reactid=".0.0.0.1.1.2">获取短信校验码</a>
									<div class="invalid validWrapper" data-reactid=".0.0.0.1.1.3" style="display:block;">
										<span class="hint valid" data-reactid=".0.0.0.1.1.3.0">
											<span data-reactid=".0.0.0.1.1.3.0.0">请输入6位短信校验码</span>
										</span>
										<div class="clear" data-reactid=".0.0.0.1.1.3.1"></div>
									</div>
								</div>
							</div>
						</div>
						<div class="input_container" data-reactid=".0.0.1" style="margin-top:-20px;">
							<label data-reactid=".0.0.1.0" for="password">
								<span class="spark" data-reactid=".0.0.1.0.0">* </span>
								<span data-reactid=".0.0.1.0.1">新密码</span>
							</label>
							<input id="password" class="" type="password" data-reactid=".0.0.1.1" autocomplete="off" name="password" placeholder="">
							<div class="invalid validWrapper" data-reactid=".0.0.1.2" style="display:block;">
								<span class="hint valid" data-reactid=".0.0.1.2.0">
									<span data-reactid=".0.0.1.2.0.0">6-16 个字符，需使用字母、数字或符号组合，不能使用纯数字、纯字母、纯符号</span>
								</span>
								<div class="clear" data-reactid=".0.0.1.2.1"></div>
							</div>
						</div>
						<div class="input_container" data-reactid=".0.0.2" style="margin-top:-20px;">
							<label data-reactid=".0.0.2.0" for="password_confirm">
								<span class="spark" data-reactid=".0.0.2.0.0">* </span>
								<span data-reactid=".0.0.2.0.1">重复新密码</span>
							</label>
							<input id="password_confirm" class="" type="password" data-reactid=".0.0.2.1" autocomplete="off" name="password_confirm" placeholder="">
							<div class="invalid validWrapper" data-reactid=".0.0.2.2" style="display:block;">
								<span class="hint valid" data-reactid=".0.0.2.2.0">
									<span data-reactid=".0.0.2.2.0.0">请再次输入密码</span>
								</span>
								<div class="clear" data-reactid=".0.0.2.2.1"></div>
							</div>
						</div>
						<div class="input_container" data-reactid=".0.0.3" style="margin-top:-20px;">
							<label data-reactid=".0.0.3.0" for="hash_code">
								<span class="spark" data-reactid=".0.0.3.0.0">* </span>
								<span data-reactid=".0.0.3.0.1">验证码</span>
							</label>
							<input id="hash_code" class="" type="text" data-reactid=".0.0.3.1" autocomplete="off" name="hash_code" placeholder="">
							<a class="pic_verify_code" data-reactid=".0.0.3.2">
								<img data-reactid=".0.0.3.2.0" src="..//images/personal/hash_code.gif">
								<span data-reactid=".0.0.3.2.1">换一张</span>
							</a>
							<div class="invalid validWrapper" data-reactid=".0.0.3.3" style="display:block;">
								<span class="hint valid" data-reactid=".0.0.3.3.0">
									<span data-reactid=".0.0.3.3.0.0">按右图输入验证码，不区分大小写</span>
								</span>
								<div class="clear" data-reactid=".0.0.3.3.1"></div>
							</div>
						</div>
						<div class="act" data-reactid=".0.0.4">
							<input id="settings-submit" class="formbutton" type="submit" data-reactid=".0.0.4.0" name="commit" value="提交">
						</div>
					</form>
				</div>
			</div>
		</div>
		<div id="myaddress" class="non">
			<h1>管理收货地址</h1>
			<div class="content sector">
				<h2>
					<span class="addAddress">新增</span>
					<span class="modifyAddress" style="display: none;">修改</span>
					收货地址
				</h2>
				<form class="shipping_address" method="post" action="">
					<div class="input_container">
						<label for="recipient_name">
							<span class="spark">*</span>
							收件人姓名：
						</label>
						<input id="recipient_name" class="t_input recipient_name" type="text" value="" name="recipient_name" size="20">
						<a class="real_name_cert " title="选择身份验证已通过的收货人" href="javascript:;">
							<span class="real_name_cert_icon"></span>
						</a>
						<label class="label_id_card" style="" for="id_card_no">身份证号码：</label>
						<input id="id_card_no" class="t_input text_id_card_no" type="text" name="id_card_no">
					</div>
					<div class="input_container input_address_select">
						<label for="select_province">
							<span class="spark">*</span>
							收货地址：
						</label>
						<div class="district_selector">
							<span class="select_ui">
								<div class="select_arrow"></div>
								<div class="select_text_ui" style="min-width: 8.5em;"></div>
								<select class="f-input select_province" data-default="省/直辖市">
									<option value="">省/直辖市</option>
									<option value="1">湖南省</option>
								</select>
							</span>
							<span class="select_ui">
								<div class="select_arrow"></div>
								<div class="select_text_ui" style="min-width: 8.5em;"></div>
								<select class="f-input select_province" data-default="市">
									<option value="">市</option>
									<option value="4301">长沙市</option>
									<option value="4302">株洲市</option>
									<option value="4303">湘潭市</option>
									<option value="4304">衡阳市</option>
									<option value="4305">邵阳市</option>
									<option value="4306">岳阳市</option>
									<option value="4307">常德市</option>
									<option value="4308">张家界市</option>
									<option value="4309">益阳市</option>
									<option value="4310">郴州市</option>
									<option value="4311">永州市</option>
									<option value="4312">怀化市</option>
									<option value="4313">娄底市</option>
									<option value="4331">湘西土家族苗族自治州</option>
								</select>
							</span>
							<span class="select_ui">
								<div class="select_arrow"></div>
								<div class="select_text_ui" style="min-width: 8.5em;"></div>
								<select class="f-input select_province" data-default="县/区">
									<option value="">县/区</option>
									<option value="430101">市辖区</option>
									<option value="430102">芙蓉区</option>
									<option value="430103">天心区</option>
									<option value="430104">岳麓区</option>
									<option value="430105">开福区</option>
									<option value="430111">雨花区</option>
									<option value="430112">望城区</option>
									<option value="430121">长沙县</option>
									<option value="430124">宁乡县</option>
									<option value="430181">浏阳市</option>
								</select>
							</span>
						</div>
					</div>
					<div class="input_container">
						<label for="recipient_street">
							<span class="spark">*</span>
							详细地址：
						</label>
						<textarea id="recipient_street" class="t_input recipient_street" name="recipient_street" style="height:auto;resize:none;" cols="60" rows="3"></textarea>
					</div>
					<div class="input_container">
						<label for="recipient_hp">
							<span class="spark">*</span>
							手机号码：
						</label>
						<input id="recipient_hp" class="t_input recipient_hp" type="tel" maxlength="11" value="" name="recipient_hp" size="20">
						<label style="float:none;margin-left:20px;" for="recipient_tel_area">固定号码：</label>
						<input id="recipient_tel_area" class="t_input recipient_tel_area" type="tel" maxlength="4" value="" name="recipient_tel_area" size="5">
						<span class="rod">-</span>
						<input id="recipient_tel_number" class="t_input recipient_tel_number" type="tel" maxlength="8" value="" name="recipient_tel_number" size="10">
						<span class="rod">-</span>
						<input id="recipient_tel_ext" class="t_input recipient_tel_ext" type="tel" maxlength="8" value="" name="recipient_tel_ext" size="5">
					</div>
					<div class="act">
						<input id="shipping_address_submit" class="formbutton" type="submit" name="commit" value="保存收货地址">
						<a id="edit_cancel" href="#" style="display: none;">取消</a>
					</div>
				</form>
				<h2>已保存的地址</h2>
				<div class="notice_content">
					最多保存10个有效地址。每月只能新增或修改10次。您本月已新增或修改
					<span id="modify_count" class="status_red">2</span>
					次
					<a class="view_id_cert_info" target="_blank" href="/i/account/nameauth">查看您的身份验证信息</a>
				</div>
				<div id="shipping_address_list">
					<c:if test="${empty error}">
						<table id="order-list" class="order-tablev2">
							<colgroup>
								<col class="name">
								<col class="address">
								<col class="code">
								<col class="hp">
								<col class="phone">
								<col class="action">
							</colgroup>
							<tbody>
								<tr class="order_list_title">
								<th>收货人</th>
								<th>收货地址</th>
								<th>手机</th>
								<th>固定电话</th>
								<th width="105px">身份证号码</th>
								<th width="80">操作</th>
								</tr>
								<c:forEach var="myaddress" items="${sessionScope.address}">
									<tr>
										<td class="real_name_td">${myaddress.consigneename}</td>
										<td class="order_info_td">${myaddress.detailaddress}</td>
										<td  style="padding:0;">${myaddress.tel}</td>
										<td>${myaddress.pnumber}</td>
										<td>${myaddress.consigneeid}</td>
										<td>
											<a class="sp_address_edit" href="javascript:void(0)" style="display:inline-block;" address_id="108238843">修改</a>
											<a class="sp_address_delete" href="javascript:void(0)" style="display:inline-block;" address_id="108238843">删除</a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>	
					</c:if>
				</div>
			</div>
		</div>
	</div>
	<div id="footer" class="footer" style="width:1349px;height: 100%;">
		<div id="footer_textarea">
			<div class="footer_top">
				<div class="footer_con footer_credit" id="footer_credit">
					<a href="" class="foot_link mostmall" target="_blank"
						rel="nofollow"> <span class="first corn"></span><span
						class="con"><b>值得信赖美妆电商</b></span>四千万用户信赖
					</a> <a href="" class="foot_link quality" target="_blank"
						rel="nofollow"> <span class="corn"></span><span class="con"><b>成功在美上市</b></span>股票代码NYSE:JMEI
					</a> <a href="" class="foot_link back" rel="nofollow" target="_blank">
						<span class="corn"></span><span class="con"><b>品牌防伪码</b></span>支持品牌官网验真
					</a> <a href="" class="foot_link depot" target="_blank" rel="nofollow">
						<span class="corn"></span><span class="con"><b>30天无理由退货</b></span>只要不满意无理由退货
					</a> <a href="" class="foot_link consignment" target="_blank"
						rel="nofollow"> <span class="corn"></span><span class="con"><b>百万用户口碑</b></span>帮你只选对的,不选贵的
					</a> <a href="" class="foot_link packaging" target="_blank"
						rel="nofollow"> <span class="corn"></span><span class="con"><b>订单闪电发货</b></span>1.5小时订单急速出库
					</a> <a href="" class="foot_link confide" target="_blank"
						rel="nofollow"> <span class="corn"></span><span class="con"><b>大牌明星热荐</b></span>打造精致明星脸
					</a>
				</div>
			</div>
			<div class="footer_top_sen">
				<div class="footer_con footer_links" id="footer_links">
					<ul class="linksa">
						<li class="links">服务保障</li>
						<li><a href="" target="_blank" rel="nofollow">品牌真品防伪码</a></li>
						<li><a href="" target="_blank" rel="nofollow">正品保证</a></li>
						<li><a href="" target="_blank" rel="nofollow">30天无条件退货</a></li>
						<li><a href="" target="_blank" rel="nofollow">7×24小时客服服务</a></li>
						<li><span class="footer_zcemail">总裁邮箱ceo@jumei.com</span></li>
					</ul>
					<ul class="linksb">
						<li class="links">使用帮助</li>
						<li><a href="" target="_blank" rel="nofollow">新手指南</a></li>
						<li><a href="" target="_blank" rel="nofollow">常见问题</a></li>
						<li><a href="" target="_blank" rel="nofollow">帮助中心</a></li>
						<li><a href="" target="_blank" rel="nofollow">用户协议</a></li>
						<li><a href="" target="_blank" rel="nofollow">企业用户团购</a></li>
					</ul>
					<ul class="linksc">
						<li class="links">支付方式</li>
						<li><a href="" target="_blank" rel="nofollow">货到付款</a></li>
						<li><a href="" target="_blank" rel="nofollow">在线支付</a></li>
						<li><a href="" target="_blank" rel="nofollow">余额支付</a></li>
						<li><a href="" target="_blank" rel="nofollow">现金券支付</a></li>
					</ul>

					<ul class="linksd">
						<li class="links">配送方式</li>
						<li><a href="" target="_blank" rel="nofollow">包邮政策</a></li>
						<li><a href="" target="_blank" rel="nofollow">配送说明</a></li>
						<li><a href="" target="_blank" rel="nofollow">运费说明</a></li>
						<li><a href="" target="_blank" rel="nofollow">验货签收</a></li>
					</ul>

					<ul class="linkse">
						<li class="links">售后服务</li>
						<li><a href="" target="_blank" rel="nofollow">正品承诺</a></li>
						<li><a href="" target="_blank" rel="nofollow">售后咨询</a></li>
						<li><a href="" target="_blank" rel="nofollow">退货政策</a></li>
						<li><a href="" target="_blank" rel="nofollow">退货办理</a></li>
					</ul>
					<div class="links_er_box">
						<ul class="linksf">
							<li class="links">手机聚美</li>
							<li><span class="link_bottom_pic"></span></li>
							<li>下载移动客户端</li>
						</ul>
						<ul class="linksg">
							<li class="links">聚美微信</li>
							<li><span class="link_bottom_pic"></span></li>
							<li>聚美官方微信</li>
						</ul>
					</div>
				</div>
			</div>

			<div class="footer_dy" id="footer_dy">
				<div class="play_box">
					<span class="play"></span>
				</div>
			</div>
			<div class="footer_center">
				<div class="footer_con" id="footer_link">
					<a href="http://www.jumei.com/about/about_us?from=footer"
						target="_blank" rel="nofollow">关于聚美优品</a> <a
						href="http://jumei.investorroom.com?from=footer" target="_blank"
						rel="nofollow">INVESTOR RELATIONS</a> <a
						href="http://hd.jumei.com/act/9-478-2448-pop_invite_business_page.html?site={$current_site}&amp;from=footer"
						target="_blank" rel="nofollow">商家入驻</a> <a
						href="http://www.jumei.com/help/get_update?from=footer"
						target="_blank" rel="nofollow">获取更新</a> <a
						href="http://jumei.ihrscloud.com/outterSupport/jumei?from=footer"
						target="_blank" rel="nofollow">加入聚美</a> <a
						href="http://www.jumei.com/i/market/cooperation?from=footer"
						target="_blank" rel="nofollow">品牌合作专区</a> <a
						href="http://cps.jumei.com?from=footer" target="_blank"
						rel="nofollow">网站联盟</a> <a
						href="http://www.jumei.com/about/news_center?from=footer"
						target="_blank" rel="nofollow">媒体报道</a> <a
						href="http://www.jumei.com/about/business?from=footer"
						target="_blank" rel="nofollow">商务合作</a>
				</div>
			</div>
			<div id="footer_copyright" class="footer_copyright">
				<div class="footer_con">
					<p class="footer_copy_con">
						COPYRIGHT © 2010-2015 北京创锐文化传媒有限公司 JUMEI.COM 保留一切权利。
						客服热线：400-123-8888 <br> 京公网安备 11010102001226 | <a
							href="http://www.miibeian.gov.cn" target="_blank" rel="nofollow">京ICP证111033号</a>
						| 食品流通许可证 SP1101051110165515（1-1） | <a
							href="http://p2.jmstatic.com/activity/2013_chuangrui.jpeg"
							target="_blank" rel="nofollow">营业执照</a>
					</p>
					<p>
						<a href="javascript:void(0)" class="footer_copy_logo logo01"
							rel="nofollow"></a> <a
							href="https://www.itrust.org.cn/yz/pjwx.asp?wm=1693268180"
							target="_blank" class="footer_copy_logo logo02" rel="nofollow"></a>
						<a href="javascript:void(0)" class="footer_copy_logo logo03"
							rel="nofollow"></a> <a href="javascript:void(0)"
							class="footer_copy_logo logo04" rel="nofollow"></a> <a
							href="https://ss.knet.cn/verifyseal.dll?sn=e12070911010031011307708&amp;ct=df&amp;pa=453163"
							target="_blank" class="footer_copy_logo logo05" rel="nofollow"></a>
					</p>
				</div>
			</div>
		</div>
	</div>
</body>
</html>