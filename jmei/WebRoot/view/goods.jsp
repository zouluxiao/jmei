<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>商品展示</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="../css/common.css">
	<link rel="stylesheet" type="text/css" href="../css/goods.css">
	<link rel="stylesheet" type="text/css" href="../css/shoppingcartRight.css">
	<link rel="stylesheet" type="text/css" href="../css/jmeihead.css">
  </head>
  
  <body id="goods">
  	<!-- 头部搜索框、导航条 -->
   	<div class="header header_wide_lv2">
		<div class="header_top">
			<div class="header_top_box">
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
		<div class="header_center">
			<h1 class="logo">
				<a></a>
			</h1>
			<div class="header_searchbox header_out_searchbox">
				<form action="${pageContext.request.contextPath }/search.do?method=searchGoods" method="post">
					<input name="searchKey" id="search" type="text" class="header_search_input">
					<button type="submit" class="header_search_btn">搜索</button>
				</form>
				<ul class="hot_word">
					<li><a href="">保湿</a> <s class="line"></s></li>
					<li><a href="">面膜</a> <s class="line"></s></li>
					<li><a href="">洗面奶</a> <s class="line"></s></li>
					<li><a href="">补水</a> <s class="line"></s></li>
					<li><a href="">香水</a> <s class="line"></s></li>
					<li><a href="">眼霜</a> <s class="line"></s></li>
					<li><a href="">口红</a> <s class="line"></s></li>
					<li><a href="">护肤套装</a> <s class="line"></s></li>
					<li><a href="">BB霜</a> <s class="line"></s></li>
				</ul>
			</div>
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
			<div class="channel_nav_box">
				<div class="channel_nav_list_wrap">
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
  	<div id="right">
   		<ul>
   			<li id="person">
	    		<s></s>
   			</li>
   			<li id="shoppingcart">
	    		<s></s>
	    		<div class="text">购物车</div>
	    		<div class="cart_num">0</div>
   			</li>
   			<li id="money">
	    		<s></s>
   			</li>
   			<li id="heart">
	    		<s></s>
   			</li>
   			<li id="see">
	    		<s></s>
   			</li>
   			<li id="twocode">
	    		<s></s>
   			</li>
   			<li id="service">
	    		<s></s>
   			</li>
   		</ul>
    	
    </div>
  	<!-- 商品路径 -->
  	<div id="load" class="w">
  		<a>聚美优品首页</a>>
  		<a>${sessionScope.goods.buser.bname }</a>>
  		<a>${sessionScope.goods.pro.pname }</a>>
  		<span>${sessionScope.goods.detailname }</span>
  	</div>
  	<!-- 商品简介 -->
  	<div id="logotro" class="w">
	  	<div id="introduction">
	  		<span class="deal_title_detail">
	  			${sessionScope.goods.introduction }
	  		</span>
	  	</div>
	  	<!-- 企业的logo -->
	  	<div id="logo">
	  		<div class="logo">
	  			<img src="../images/goods/410.jpg"/>
	  		</div>
	  	</div>
  	</div>
  	<!-- 商品大图 -->
  	<div id="imginfo" class="w">
	  	<div id="bigimg">
	  		<center><img src="../images/goodspic/3/${sessionScope.BigPic.picpname }" height="400px;" width="570px;"/></center>
	  	</div>
	  	<!-- 商品的基本信息 -->
	  	<div id="info">
	  		<div class="deal_ori_price">
	  		<!-- 价格 -->
	  			<span class="deal_accout_one">￥</span>
	  			<span class="deal_accout_two">${sessionScope.goods.price}</span>
	  		</div>
	  		<div class="full_cut_dialog">
	  			<em>满减</em>
	  			<span>
	  				<a>植村秀满499减50</a>
	  			</span>
	  		</div>
	  		<div class="deal_buynum">
	  			<a></a>
	  			<span>剩余${sessionScope.goods.number}</span>
	  		</div>
	  		<dl>
	  			<dd>包邮政策：满2件或299包邮</dd>
	  			<dd>服务政策：30天拆封无条件退货</dd>
	  		</dl>
	  		<div class="button_list">
	  			<div class="button_list_1"></div>
	  			<div class="button_list_2"></div>
	  		</div>
	  	</div>
  	</div>
  	<!-- 商品的特性 -->
  	<div class="w" id="de">
  		<div id="deal">
  			<ul></ul>
  			<div class="share">分享到 ></div>
  			<div class="collect">收藏(1994)</div>
  			<div class="collectImg"></div>
  		</div>
  	</div>
  	<!-- 商品的其他 -->
  	<div id="other_de" class="w">
  		<div id="other">
  			<div class="other1">
  				<div class="img1"></div>
  				<div style="padding-top: 5px;">值得信赖美妆电商</div>
  				<div>四千万注册用户 / 已在美上市</div>
  			</div>
  			<div class="other1">
  				<div class="img1" style="background-position: 0 -50px;"></div>
  				<div style="padding-top: 5px;">聚美自营</div>
  				<div>由聚美优品拥有并销售</div>
  			</div>
  			<div class="other1">
  				<div class="img1" style="background-position: 0 -150px;"></div>
  				<div style="padding-top: 5px;">正品保证</div>
  				<div>入库检验 / 质量保险</div>
  			</div>
  			<div class="other1">
  				<div class="img1" style="background-position: 0 -250px;"></div>
  				<div style="padding-top: 5px;">30天无条件退货</div>
  				<div>只要您不满意无条件退货</div>
  			</div>
  		</div>
  	</div>
  	
  </body>
</html>
