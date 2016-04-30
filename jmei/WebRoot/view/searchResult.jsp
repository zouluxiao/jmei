<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>SearchResult</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="../css/common.css">
	<link rel="stylesheet" type="text/css" href="../css/searchResult.css">
	<link rel="stylesheet" type="text/css" href="../css/shoppingcartRight.css">
	<link rel="stylesheet" type="text/css" href="../css/jmeihead.css">
  </head>
  
  <body id="searchResult">
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
    <!-- 右部个人条 -->
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
    <!-- 化妆品首页 -->
    <div id="frist" class="w">
    	<ul class="ful">
    		<li class="fli">
    			<a href="#">化妆品首页</a>
    		</li>
    	</ul>
    	<span class="span">></span>
    	<div id="frist_search">
    		<form action="">
    			<span class="frist_search_span">在当下条件下搜索</span>
    			<input type="text" name="" value="" class="frist_search_input">
    			<input type="submit" value="" class="bread_search_img">
    		</form>
    	</div>
    </div>
    <!-- 在筛选 -->
    <div id="searchOther" class="w">
    	<div class="inline">
    		<span class="span">在</span>
    		<span id="searchOther_span"></span>
    		<span class="span">中筛选</span>
    	</div>
    </div>
    <!-- 品牌、分类、功效、价格 -->
    <div id="btep" class="w">
    	<!-- 品牌 -->
	    <div id="buserName" class="w">
	    	<div class="buser_name">
	    		<span>品牌:</span>
	    	</div>
	    	<div class="buser_all">
	    		<ul class="buser_all_ul">
	    			<c:forEach var="u" varStatus="s1" items="${sessionScope.buserlist }">
	    				<li><a href="#">${u.bname }</a></li>
	    			</c:forEach>
	    		</ul>
	    	</div>
	    	<div class="buser_right">
	    		<span>展开</span><a></a>
	    	</div>
	    </div>
	    <!-- 分类 -->
	    <div id="type" class="w">
	    	<div class="buser_name">
	    		<span>分类:</span>
	    	</div>
	    	<div class="buser_all">
	    		<ul class="buser_all_ul">
	    			<c:forEach var="u" varStatus="s1" items="${sessionScope.typelist }">
	    				<li><a href="#">${u.tname }</a></li>
	    			</c:forEach>
	    		</ul>
	    	</div>
	    	<div class="buser_right">
	    		<span>展开</span><a></a>
	    	</div>
	    </div>
	    <!-- 功效 -->
	    <div id="effect" class="w">
	    	<div class="buser_name">
	    		<span>功效:</span>
	    	</div>
	    	<div class="buser_all">
	    		<ul class="buser_all_ul">
	    			<c:forEach var="u" varStatus="s1" items="${sessionScope.effectlist }">
	    				<li><a href="#">${u.ename }</a></li>
	    			</c:forEach>
	    		</ul>
	    	</div>
	    	<div class="buser_right">
	    		<span>展开</span><a></a>
	    	</div>
	    </div>
	    <!-- 价格 -->
	    <div id="price" class="w">
	    	<div class="buser_name">
	    		<span>价格:</span>
	    	</div>
	    	<div class="buser_all">
	    		<ul class="buser_all_ul">
	    			<li><a>0-100</a></li>
	    			<li><a>100-200</a></li>
	    			<li><a>200-300</a></li>
	    			<li><a>300-400</a></li>
	    			<li><a>400-500</a></li>
	    			<li><a>500-600</a></li>
	    			<li><a>600-100</a></li>
	    		</ul>
	    	</div>
	    	<div class="buser_right">
	    		<span>展开</span><a></a>
	    	</div>
	    </div>
    </div>
    <!-- 搜索商品的结果 -->
    <div id="search_list_wrap" class="w">
	    <!-- 排序 -->
	    <div id="sort" class="w">
	    	<div class="search_list_head_fiex">
	    		<div class="sort_s">排序:</div>
	    	</div>
	    	<!-- <ul class="sort_u">
	    		<li class="selected">
	    			<a class="down">默认</a>
	    		</li>
	    	</ul> -->
	    </div>
	    <!-- 商品展示 -->
	    <div id="goods" class="w" style="padding: 20px;margin: 0 -32px 0 0;">
	    	<ul>
	    		<c:forEach var="u" varStatus="s1" items="${sessionScope.goodslist }">
	    			<li class="Goods_item"><a href="${pageContext.request.contextPath }/goods.do?method=goods&gid=${u.gid}">
	    			<img src="../images/goodspic/2/${sessionScope.piclist[s1.index].picpname }" height="216px;" width="216px;"/>
	    			<br>
	    			<div id="goods_item_span" class="Goods_item_span">${u.detailname }</div>
	    			<div id="goods_item_price" class="Goods_item_price">
	    				<label>￥</label>	
	    				<span>${u.price }</span>
	    			</div></a>
	    			<div id="salevol" class="goods_sale">${u.sale_val }人已经购买|</div>
	    			<span id="" class="">时间</span>
	    			<div id="goods_button" class="goods_button">
	    				<a id="addcart" class="goods_button_add"></a>
	    				<a id="addcol" class="goods_button_addcol"></a>
	    			</div>
	    		</li>
	    		</c:forEach>
	    	</ul>
	    </div>
	    <!-- 分页 -->
	    <div id="page" class="w">
	    	<ul class="page-nav">
	    		<li class="current">
	    			<span>1</span>
	    		</li>
	    		<li class="current">
	    			<a>2</a>
	    		</li>
	    		<li class="current">
	    			<a>3</a>
	    		</li>
	    		<li class="current">
	    			<a>...</a>
	    		</li>
	    		<li class="current">
	    			<a>10</a>
	    		</li>
	    		<li class="current">
	    			<a class="next">下一页</a>
	    		</li>
	    	</ul>
	    </div>
    </div>
    <!-- 底部搜索条 -->
    <div id="butSearch" class="w" style="width: 982px;">
    	<div class="butSearch_se" class="w"></div>
   		<div class="search_se_text">搜索全部</div>
   		<form action="${pageContext.request.contextPath }/search.do?method=searchGoods" method="post">
   			<input type="text" value="" class="butSearch_se_input" name="searchKey"/>
   			<button type="submit">搜索</button>
   		</form>
    	
    	<div class="bottom_othersearch">去口碑中心搜索</div>
    </div>
    <!-- 最近查看条 -->
    <div id="recent"></div>
    <!-- 最近查看商品 -->
    <div id="recentGoods"></div>
    <!-- 底部链接 -->
    <div id="foot"></div>
  </body>
</html>








