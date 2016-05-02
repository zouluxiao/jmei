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
	<link rel="stylesheet" type="text/css" href="../css/foot.css">
	<link rel="stylesheet" type="text/css" href="../css/base.css">
  </head>
  <script type="text/javascript">
  	function addCart(gid){
		alert("进入函数");
		//创建XMLHttp对象
		var xmlHttp;
		if(window.XMLHttpRequest){//分浏览器创建XMLHttp对象
			xmlHttp = new XMLHttpRequest();
		}else if(window.ActiveXObject){
			xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		alert("xmlHttp对象创建："+xmlHttp);
		
		//function getCustomerInfo(){
		alert("请求方式已确定,传入的id为："+document.getElementById("hid_"+gid).value);
		//设置请求方式
		var url = "${pageContext.request.contextPath }/ShoppingCart.do?method=add";
		xmlHttp.open("POST", url);
			
		//}
		//注册回调方法
		
		//发送请求
		 var params = "gid=" + document.getElementById("hid_"+gid).value;  
	
		alert("发送的数据:"+params);
		//这行代码很关键，用来把字符串类型的参数序列化成Form Data  
		xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xmlHttp.send(params);
	}
  </script>
  
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
					<button type="submit" class="header_search_btn" onclick="changeVal();">搜索</button>
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
   	<!--右侧贴边导航quick_links.js控制-->
        <div class="mui-mbar-tabs">
            <div class="quick_link_mian">
                <div class="quick_links_panel">
                    <div id="quick_links" class="quick_links">
                        <li><a href="#" class="my_qlinks"><i class="setting"></i></a>
                            <div class="ibar_login_box status_login">
                                <div class="avatar_box">
                                    <p class="avatar_imgbox">
                                        <img src="../images/no-img_mid_.jpg" /></p>
                                    <ul class="user_info">
                                        <li>用户名：sl19931003</li>
                                        <li>级&nbsp;别：普通会员</li>
                                    </ul>
                                </div>
                                <div class="login_btnbox">
                                    <a href="#" class="login_order">我的订单</a> <a href="#" class="login_favorite">我的收藏</a>
                                </div>
                                <i class="icon_arrow_white"></i>
                            </div>
                        </li>
                        <li id="shopCart" onclick="Test();"><a class="message_list"><i class="message"></i>
                                <div class="span">
                                    购物车</div>
                                <span class="cart_num">0</span></a> </li>
                        <li><a href="#" class="history_list"><i class="view"></i></a>
                            <div class="mp_tooltip" style="visibility: hidden;">
                                我的资产<i class="icon_arrow_right_black"></i></div>
                        </li>
                        <li><a href="#" class="mpbtn_histroy"><i class="zuji"></i></a>
                            <div class="mp_tooltip">
                                我的足迹<i class="icon_arrow_right_black"></i></div>
                        </li>
                        <li><a href="#" class="mpbtn_wdsc"><i class="wdsc"></i></a>
                            <div class="mp_tooltip">
                                我的收藏<i class="icon_arrow_right_black"></i></div>
                        </li>
                        <li><a href="#" class="mpbtn_recharge"><i class="chongzhi"></i></a>
                            <div class="mp_tooltip">
                                我要充值<i class="icon_arrow_right_black"></i></div>
                        </li>
                    </div>
                    <div class="quick_toggle">
                        <li><a href="#"><i class="kfzx"></i></a>
                            <div class="mp_tooltip">
                                客服中心<i class="icon_arrow_right_black"></i></div>
                        </li>
                        <li><a href="#none"><i class="mpbtn_qrcode"></i></a>
                            <div class="mp_qrcode" style="display: none;">
                                <img src="../images/weixin_code_145.png" width="148" height="175" /><i class="icon_arrow_white"></i></div>
                        </li>
                        <li><a href="#top" class="return_top"><i class="top"></i></a></li>
                    </div>
                </div>
                <div id="quick_links_pop" class="quick_links_pop hide"></div>
            </div>
        </div>
    <!-- 隐含的框 -->
    <div id="shoppingcartdisplay">
    	<div class="cart_title">购物车</div>
    	<div class="cart_group">
    		<div class="cart_head">
    			<div class="ibar_cart_group_title">聚美优品</div>
    			<div class=""></div>
    		</div>
    		<ul>
    			<!-- 商品展示栏 -->
    			<c:forEach var="u" varStatus="s1" items="${sessionScope.ShoppingCart.GoodsCart }">
    			<li class="cart_product">
	   				<span style="height: 100px;width: 100px;padding-left:13px;padding-left:13px;">
	   					<img alt="" src="../images/goodspic/2/${sessionScope.pl[s1.index].picpname }" height="87px" width="87px">
	   				</span>
	   				<span class="detail">${u.detailname }</span>
	   				<span class="cart_price">￥${u.price }</span>
   				</li>
   				</c:forEach>
    		</ul>
    	</div>
    	<!-- 结算栏 -->
		<div class="ibar">
			<div class="ibar_num">共&nbsp;&nbsp;<font color="red">1</font>&nbsp;&nbsp;件商品</div>
			<div class="ibar_pri">￥98.00</div>
			<a class="ibar_cart_go_btn" href="www.baidu.com">结算</a>
		</div>
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
	    				<li><a href="${pageContext.request.contextPath }/search.do?method=buser&buser=${u.bname}">${u.bname }</a></li>
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
	    				<li><a href="${pageContext.request.contextPath }/search.do?method=type&type=${u.tname}">${u.tname }</a></li>
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
	    				<li><a href="${pageContext.request.contextPath }/search.do?method=effect&effect=${u.ename}">${u.ename }</a></li>
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
	    			<li><a href="${pageContext.request.contextPath }/search.do?method=price&low=0&high=100">0-100</a></li>
	    			<li><a href="${pageContext.request.contextPath }/search.do?method=price&low=100&high=200">100-200</a></li>
	    			<li><a href="${pageContext.request.contextPath }/search.do?method=price&low=200&high=300">200-300</a></li>
	    			<li><a href="${pageContext.request.contextPath }/search.do?method=price&low=300&high=400">300-400</a></li>
	    			<li><a href="${pageContext.request.contextPath }/search.do?method=price&low=400&high=500">400-500</a></li>
	    			<li><a href="${pageContext.request.contextPath }/search.do?method=price&low=500&high=600">500-600</a></li>
	    			<li><a href="${pageContext.request.contextPath }/search.do?method=price&low=600&high=1000">600-1000</a></li>
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
	    	<ul class="sort_u">
	    		<li class="selected">
	    			<div class="down"><a href="#">默认</a></div>
	    		</li>
	    		<li class="select">
	    			<div class="down"><a href="${pageContext.request.contextPath }/search.do?method=priceDesc">价格</a></div>
	    		</li>
	    		<li class="select">
	    			<div class="down"><a href="${pageContext.request.contextPath }/search.do?method=saleDesc">销量</a></div>
	    		</li>
	    		<li class="select">
	    			<div class="down"><a href="${pageContext.request.contextPath }/search.do?method=colDesc">人气</a></div>
	    		</li>
	    	</ul>
	    	<div class="oth"><a href="">下一页</a></div>
	    	<div class="oth"><a href="">上一页</a></div>
	    	<div class="oth"><font style="color:red;">2</font>/11页</div>
	    	<div class="oth">共<font style="color:red;">363</font>个商品</div>
	    </div>
	    <!-- 商品展示 -->
	    <div id="goods" class="w" style="padding: 20px;margin: 0 -32px 0 0;">
	    	<ul>
	    		<c:forEach var="u" varStatus="s1" items="${sessionScope.goodslist }" begin="${sessionScope.curPage*12 }" end="${sessionScope.curPage*12+11 }">
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
	    				<input type="hidden" id="hid_${s1.index }" value="${u.gid}">
	    				<a id="addcart_${s1.index }" onclick="addCart(${s1.index });" class="goods_button_add btnCart" href="javascript:;"></a>
	    				<a id="addcol" class="goods_button_addcol"></a>
	    			</div>
	    			<div id="flyItem" class="fly_item">
              			<img src="../images/goodspic/2/${sessionScope.piclist[s1.index].picpname }" width="50" height="50"/>
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
	    		<c:forEach var="i" begin="2" end="${sessionScope.pageCount }" step="1">
	    			<li class="current">
	    				<a href="${pageContext.request.contextPath }/search.do?method=searchGoods&curPage=${i -1}&searchKey=K">
	    				${i }</a>
	    			</li>
	    		</c:forEach>
	    		<li class="current">
	    			<a class="next" href="${pageContext.request.contextPath }/search.do?method=searchGoods&curPage=${curPage }&searchKey=K">下一页</a>
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
    <!-- 尾部开始 -->
	<div id="footer" class="footer">
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
	<!-- 尾部结束 -->
  </body>
	   <script type="text/javascript" src="http://www.sucaihuo.com/Public/js/other/jquery.js"></script> 
        <script type="text/javascript" src="../js/common.js"></script>
        <!--[if lte IE 8]>
    <script src="js/ieBetter.js"></script>
    <![endif]-->
        <script type="text/javascript" src="../js/parabola.js"></script>
         <script type="text/javascript" src="../js/shoppingcart.js"></script>
        <script type="text/javascript">
            $(".quick_links_panel li").mouseenter(function() {
                $(this).children(".mp_tooltip").animate({left: -92, queue: true});
                $(this).children(".mp_tooltip").css("visibility", "visible");
                $(this).children(".ibar_login_box").css("display", "block");
            });
            $(".quick_links_panel li").mouseleave(function() {
                $(this).children(".mp_tooltip").css("visibility", "hidden");
                $(this).children(".mp_tooltip").animate({left: -121, queue: true});
                $(this).children(".ibar_login_box").css("display", "none");
            });
            $(".quick_toggle li").mouseover(function() {
                $(this).children(".mp_qrcode").show();
            });
            $(".quick_toggle li").mouseleave(function() {
                $(this).children(".mp_qrcode").hide();
            });

            // 元素以及其他一些变量
            var eleFlyElement = document.querySelector("#flyItem"), eleShopCart = document.querySelector("#shopCart");
            var numberItem = 0;
            // 抛物线运动
            var myParabola = funParabola(eleFlyElement, eleShopCart, {
                speed: 400, //抛物线速度
                curvature: 0.0008, //控制抛物线弧度
                complete: function() {
                    eleFlyElement.style.visibility = "hidden";
                    eleShopCart.querySelector("span").innerHTML = ++numberItem;
                }
            });
            // 绑定点击事件
            if (eleFlyElement && eleShopCart) {

                [].slice.call(document.getElementsByClassName("btnCart")).forEach(function(button) {
                    button.addEventListener("click", function(event) {
                        var src = $(this).parents("li").find('.p-img').find("img").attr("src");
                        $("#flyItem").find("img").attr("src", src);
                        // 滚动大小
                        var scrollLeft = document.documentElement.scrollLeft || document.body.scrollLeft || 0,
                                scrollTop = document.documentElement.scrollTop || document.body.scrollTop || 0;
                        eleFlyElement.style.left = event.clientX + scrollLeft + "px";
                        eleFlyElement.style.top = event.clientY + scrollTop + "px";
                        eleFlyElement.style.visibility = "visible";

                        // 需要重定位
                        myParabola.position().move();
                    });
                });
            }
        </script>
</html>








