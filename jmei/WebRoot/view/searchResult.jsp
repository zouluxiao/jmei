<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
  </head>
  
  <body id="searchResult">
  	<!-- 头部搜索框、导航条 -->
    <div id="head" style="height: 117px;width: 100%;background-color: #aaa;"></div>
    <!-- 右部个人条 -->
   	<!-- <div id="right">
    	
    </div> -->
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
	    <div id="buserName">
	    	<div class="buser_name">
	    		<span>品牌:</span>
	    	</div>
	    	<div class="buser_all">
	    		<ul>
	    			<li>美宝莲</li>
	    			<li>伊蒂之屋</li>
	    			<li>迪奥</li>
	    			<li>魅可</li>
	    			<li>光芮</li>
	    			<li>思亲肤</li>
	    			<li>欧莱雅</li>
	    			<li>曼秀雷敦</li>
	    			<li>倩碧</li>
	    			<li>美宝莲</li>
	    			<li>伊蒂之屋</li>
	    			<li>迪奥</li>
	    			<li>魅可</li>
	    			<li>光芮</li>
	    			<li>思亲肤</li>
	    			<li>欧莱雅</li>
	    			<li>曼秀雷敦</li>
	    			<li>倩碧</li>
	    		</ul>
	    	</div>
	    	<div class="buser_right"></div>
	    </div>
	    <!-- 分类 -->
	    <div id="type"></div>
	    <!-- 功效 -->
	    <div id="effect"></div>
	    <!-- 价格 -->
	    <div id="price"></div>
    </div>
    <!-- 排序 -->
    <div id="sort"></div>
    <!-- 商品展示 -->
    <div id="Goods"></div>
    <!-- 分页 -->
    <div id="page"></div>
    <!-- 底部搜索条 -->
    <div id="butSearch"></div>
    <!-- 最近查看条 -->
    <div id="recent"></div>
    <!-- 最近查看商品 -->
    <div id="recentGoods"></div>
    <!-- 底部链接 -->
    <div id="foot"></div>
  </body>
</html>








