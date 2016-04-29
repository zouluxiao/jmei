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
  </head>
  
  <body id="searchResult">
  	<!-- 头部搜索框、导航条 -->
   <!--  <div id="head" style="height: 117px;width: 100%;background-color: #aaa;"></div> -->
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
    			<input type="text" name="search" value="" class="frist_search_input">
    			<input type="submit" value="" class="bread_search_img">
    		</form>
    	</div>
    </div>
    <!-- 在筛选 -->
    <div id="searchOther" class="w">
    	<div class="inline">
    		<span class="span">在</span>
    		<span id="searchOther_span">口红</span>
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
	    			<li><a>美宝莲</a></li>
	    			<li><a>伊蒂之屋</a></li>
	    			<li><a>迪奥</a></li>
	    			<li><a>魅可</a></li>
	    			<li><a>光芮</a></li>
	    			<li><a>美宝莲</a></li>
	    			<li><a>伊蒂之屋</a></li>
	    			<li><a>迪奥</a></li>
	    			<li><a>魅可</a></li>
	    			<li><a>光芮</a></li>
	    			<li><a>美宝莲</a></li>
	    			<li><a>伊蒂之屋</a></li>
	    			<li><a>迪奥</a></li>
	    			<li><a>魅可</a></li>
	    			<li><a>光芮</a></li>
	    			<li><a>美宝莲</a></li>
	    			<li><a>伊蒂之屋</a></li>
	    			<li><a>迪奥</a></li>
	    			<li><a>魅可</a></li>
	    			<li><a>光芮</a></li>
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
	    			<li><a href="#">美宝莲</a></li>
	    			<li><a>伊蒂之屋</a></li>
	    			<li><a>迪奥</a></li>
	    			<li><a>魅可</a></li>
	    			<li><a>光芮</a></li>
	    			<li><a>美宝莲</a></li>
	    			<li><a>伊蒂之屋</a></li>
	    			<li><a>迪奥</a></li>
	    			<li><a>魅可</a></li>
	    			<li><a>光芮</a></li>
	    			<li><a>美宝莲</a></li>
	    			<li><a>伊蒂之屋</a></li>
	    			<li><a>迪奥</a></li>
	    			<li><a>魅可</a></li>
	    			<li><a>光芮</a></li>
	    			<li><a>美宝莲</a></li>
	    			<li><a>伊蒂之屋</a></li>
	    			<li><a>迪奥</a></li>
	    			<li><a>魅可</a></li>
	    			<li><a>光芮</a></li>
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
	    			<li><a>美宝莲</a></li>
	    			<li><a>伊蒂之屋</a></li>
	    			<li><a>迪奥</a></li>
	    			<li><a>魅可</a></li>
	    			<li><a>光芮</a></li>
	    			<li><a>美宝莲</a></li>
	    			<li><a>伊蒂之屋</a></li>
	    			<li><a>迪奥</a></li>
	    			<li><a>魅可</a></li>
	    			<li><a>光芮</a></li>
	    			<li><a>美宝莲</a></li>
	    			<li><a>伊蒂之屋</a></li>
	    			<li><a>迪奥</a></li>
	    			<li><a>魅可</a></li>
	    			<li><a>光芮</a></li>
	    			<li><a>美宝莲</a></li>
	    			<li><a>伊蒂之屋</a></li>
	    			<li><a>迪奥</a></li>
	    			<li><a>魅可</a></li>
	    			<li><a>光芮</a></li>
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
	    			<li class="Goods_item">
	    			<img src="../images/cssSearchResult/23429_1_350_350.jpg" height="216px;" width="216px;"/>
	    			<br>
	    			<div id="goods_item_span" class="Goods_item_span">${u.detailname }</div>
	    			<div id="goods_item_price" class="Goods_item_price">
	    				<label>￥</label>	
	    				<span>${u.price }</span>
	    			</div>
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








