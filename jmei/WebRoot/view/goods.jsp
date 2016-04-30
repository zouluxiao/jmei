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
  </head>
  
  <body id="goods">
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
	  		<center><img src="../images/goods/1937140_350_350.jpg"/></center>
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
