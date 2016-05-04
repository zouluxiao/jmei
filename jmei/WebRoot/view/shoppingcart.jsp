<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title></title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="../css/shoppingcartRight.css">
	<link rel="stylesheet" type="text/css" href="../css/common.css">
	<link rel="stylesheet" type="text/css" href="../css/jmeihead.css">
	<link rel="stylesheet" type="text/css" href="../css/foot.css">
	<link rel="stylesheet" type="text/css" href="../css/base.css">
	
</head>
<body>
	<!--右侧贴边导航quick_links.js控制-->
        <div class="mui-mbar-tabs" style="width:40px;">
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
                                <span class="cart_num" id="cart_num_id">
                                	<c:if test="${empty sessionScope.ShoppingCart.goodsCart }">0</c:if>
                                	<c:if test="${not empty sessionScope.ShoppingCart.goodsCart }">${sessionScope.ShoppingCart.goodsCart.size() }</c:if>
                                </span></a> </li>
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
                <!-- <div id="quick_links_pop" class="quick_links_pop hide"></div> -->
            </div>
        </div>
    <!-- 隐含的框 -->
    <div id="shoppingcartdisplay" onmousemove="flu();">
    	<div class="cart_title">购物车</div>
    	<div class="cart_group">
    		<div class="cart_head">
    			<div class="ibar_cart_group_title">聚美优品</div>
    			<div class=""></div>
    		</div>
    		<ul id="imp" style="overflow-x: hidden;height: 400px;">
    			<!-- 商品展示栏 -->
    			<c:forEach var="u" varStatus="s1" items="${sessionScope.ShoppingCart.goodsCart }"> 
    			<li class="cart_product">
	   				<img alt="" src="../images/goodspic/2/${sessionScope.pl[s1.index].picpname }" height="87px" width="87px">
	   				<span class="detail">${u.detailname }</span>
	   				<span class="cart_price">￥${u.price }</span>
   				</li>
   				</c:forEach>
    		</ul>
    	</div>
    	<!-- 结算栏 -->
		<div class="ibar">
			<div class="ibar_num"><div>共&nbsp;&nbsp;<span style="color:red;" id="font_id">${sessionScope.ShoppingCart.goodsCart.size() }</span>&nbsp;&nbsp;件商品</div></div>
			<div class="ibar_pri" >￥<span id="ibar_pri_id">${sessionScope.ShoppingCart.sum }</span></div>
			<a href="${pageContext.request.contextPath }/view/cart.jsp" class="ibar_cart_go_btn">
			<span style="position: absolute;right: 55px;">去购物车结算</span></a>
		</div>
		
    </div>
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
						eleShopCart.querySelector("span").innerText = parseInt(eleShopCart.querySelector("span").innerText)+1;
                        // 需要重定位
                        myParabola.position().move();
                    });
                });
            }
        </script>
</html>
	
	