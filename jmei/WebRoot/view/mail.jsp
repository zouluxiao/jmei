<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<c:set value="${pageContext.request.contextPath}" var="contextPath" scope="session"></c:set>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>聚美优品 - 【极速免税店 品牌防伪码】正品化妆品团购网站GZ,千万用户推荐,拆封30天无条件退货!</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="../css/common.css"></link>
<link rel="stylesheet" type="text/css" href="../css/mallhead.css"></link>

<link rel="stylesheet" type="text/css" href="../css/foot.css"></link>
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/myindex.js"></script>
<script type="text/javascript">
 	var i = 0;
	var time = 0;
	function junmper() {
		i++;
		if (i > 2)
			i = 0;
		$(".scc_container ul li").eq(i).fadeIn(100).siblings().fadeOut(100);
		$(".sc_index a").eq(i).addClass("bg").siblings().removeClass("bg");
	}
	time = setInterval("junmper()", 3000); 
</script>
</head>
<body style="width:1349px;height: 100%;" onload="malllunbo()">
	<!-- 头部开始 -->
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
					<span class="add-city-icons">送至<span
						class="add-default-city">广东</span><s class="icon_arrow_down"></s>
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
					<li><a href=""> <s class="icon_favorite"></s>收藏的品牌
					</a></li>
					<li id="myjmei" class="item_ijumei" onmouseover="onMyJmei()" onmouseout="leaveMyJmei()"><a href="">我的聚美 <s
							class="icon_arrow_down"></s>
					</a> <i class="icon_arrow_back"></i>
					<div  id="myjmeiuldiv" class="sub_nav" style="display: none; height: auto; overflow: visible; padding-top: 8px; margin-top: 0px; padding-bottom: 8px; margin-bottom: 0px;">
                    <ul id="myjmeiul">
                        <li><a href="">我的订单</a></li>
                        <li><a href="" rel="nofollow">我的现金券</a></li>
                        <li><a href="" rel="nofollow">我的红包</a></li>
                        <li><a href="" rel="nofollow">我的余额</a></li>
                        <li><a href="" rel="nofollow">我的提现退款</a></li>
                        <li><a href="" rel="nofollow">我的收藏</a></li>
                        <li><a href="" rel="nofollow">我的心愿单</a></li>
                        <li><a href="" rel="nofollow">会员中心</a></li>
                        <li><a href="" rel="nofollow">兑换礼品卡</a></li>
                    </ul>
                </div>
					</li>
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
				<form action="" method="">
					<input id="search" type="text" class="header_search_input">
					<button type="submit" class="header_search_btn">搜索</button>
				</form>
				<ul class="hot_word">
					<li><a href="">保湿</a><s class="line"></s></li>
					<li><a href="">面膜</a><s class="line"></s></li>
					<li><a href="">洗面奶</a><s class="line"></s></li>
					<li><a href="">补水</a><s class="line"></s></li>
					<li><a href="">香水</a><s class="line"></s></li>
					<li><a href="">眼霜</a><s class="line"></s></li>
					<li><a href="">口红</a><s class="line"></s></li>
					<li><a href="">护肤套装</a><s class="line"></s></li>
					<li><a href="">BB霜</a></li>
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
						<li class=""><a href="" class="home">首页</a></li>
						<li class=""><a href="">极速免税店</a></li>
						<li class="gif_301_wrap"><a href="" class="gif_301"> <img
								src="../images/jmeihead/muy1.gif"></img>
						</a></li>
						<li class="current"><a href="">美妆商城<b></b></a></li>
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
	<!-- 头部结束 -->
	<!-- 美妆商城导航条开始 -->
	<div id="mall_nav_box" class="mall_nav_list_wrap_new">
		<div class="mall_nav_list_wrap w1090">
			<ul class="mall_nav_list clearfix">
				<li class="current"><a href="">美妆商城首页</a></li>
				<li class=""><a href="">个人护理</a></li>
				<li class=""><a href="">奢品美妆</a></li>
				<li class=""><a href="">护肤</a></li>
				<li class=""><a href="">彩妆</a></li>
				<li class=""><a href="">香氛</a></li>
			</ul>
		</div>
	</div>
	<!-- 美妆商城导航条结束 -->
	<!-- 美妆商城品牌商品展示部分开始 -->
	<div class="new_admall_box">
		<div class="new_admall_topContent clearfix">
			<!-- 左边区域开始 -->
			<div id="mtsCategory" class="new_admall_left_area mtsCategory">
				<div class="pmggw_left">
					<!-- 左边上面文字导航部分开始 -->
					<div class="mtsCategory_box" style="z-index:100;">
						<div class="mtsCategory-con">
							<div id="mallCategory" class="first_menu">
								<div class="mc_content">
									<h3 class="new_admall_eric_menu">全部分类</h3>
									<ul class="new_admall_menu_content">
										<li id="recBuserLi" class="new_admall_menu_li0 item" onmouseover="showRecBuser()" onmouseout="hideRecBuser()">
											<h3 class="new_admall_menu_title">推荐品牌</h3>
											<p class="new_admall_menu_cont">
												<a href="">欧莱雅</a> <a href="">菲诗小铺</a> <a href="">雅诗兰黛</a> <a
													href="">兰蔻</a> <a href="">韩束</a> <a href="">倩碧</a> <a
													href="">雅顿</a> <a href="">佰草集</a>
											</p>
										</li>
										<li class="new_admall_menu_li0 item">
											<h3 class="new_admall_menu_title">护肤</h3>
											<p class="new_admall_menu_cont">
												<a href="">洁面</a> <a href="">化妆水</a> <a href="">精华</a> <a
													href="">乳液</a> <a href="">面霜</a> <a href="">眼霜</a> <a
													href="">面膜</a> <a href="">护肤套装</a>
											</p>
										</li>
										<li class="new_admall_menu_li0 item">
											<h3 class="new_admall_menu_title">彩妆</h3>
											<p class="new_admall_menu_cont">
												<a href="">卸妆</a> <a href="">防晒霜</a> <a href="">BB霜</a> <a
													href="">粉饼干</a> <a href="">眼影</a> <a href="">睫毛膏</a> <a
													href="">唇彩</a> <a href="">腮红</a> <a href="">彩妆套装</a>
											</p>
										</li>
										<li class="new_admall_menu_li0 item">
											<h3 class="new_admall_menu_title">香氛</h3>
											<p class="new_admall_menu_cont">
												<a href="">女士香水</a> <a href="">男士香水</a> <a href="">中性香水</a>
												<a href="">Q版香水</a> <a href="">香水套装</a>
											</p>
										</li>
										<li class="new_admall_menu_li0 item">
											<h3 class="new_admall_menu_title">个人护理</h3>
											<p class="new_admall_menu_cont">
												<a href="">洗发</a> <a href="">护发</a> <a href="">沐浴</a> <a
													href="">润肤乳</a> <a href="">牙膏</a> <a href="">发膜</a> <a
													href="">脱毛</a> <a href="">护理套装</a>
											</p>
										</li>
										<li class="new_admall_menu_li0 item">
											<h3 class="new_admall_menu_title">男士专区</h3>
											<p class="new_admall_menu_cont">
												<a href="">洁面</a> <a href="">爽肤水</a> <a href="">乳液</a> <a
													href="">面霜</a> <a href="">精华</a> <a href="">洗发</a> <a
													href="">沐浴</a> <a href="">男香</a> <a href="">奢品美妆</a>
											</p>
										</li>
										<li class="new_admall_menu_li0 item bottom_last">
											<h3 class="new_admall_menu_title">奢品美妆</h3>
											<p class="new_admall_menu_cont">
												<a href="">雅诗兰黛</a> <a href="">迪奥</a> <a href="">海蓝之谜</a> <a
													href="">希思黎</a> <a href=""></a>
											</p>
										</li>
									</ul>
								</div>
							</div>
							<div id="subCategory" class="subCategory"
								style="top: 34px; left: 216px; display: block;">
								<!-----国际品牌子导航 start--->
								<div id="recBuserDiv" class="subc_con subc_con3 subc_con3_gj"
									style="display: none;">
									<div class="fl sub_cat_con sub_cat_con3 clearfix">
										<div class="subc3_left_area fl">
											<div class="subc3_item">
												<h2 class="subc3_item_title">国际品牌</h2>
												<div class="subc3_item_body">
													<div class="subc3_area">
														<a
															href="http://arden.jumei.com/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">伊丽莎白雅顿</a> <a
															href="http://lancome.jumei.com/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">兰蔻</a> <a
															href="http://kiehls.jumei.com/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">科颜氏</a> <a
															href="http://search.jumei.com/?filter=0-11-1&amp;search=%E8%BF%AA%E5%A5%A5&amp;from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">迪奥</a> <a
															href="http://clinique.jumei.com/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">倩碧</a> <a
															href="http://clarins.jumei.com/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">娇韵诗</a> <a
															href="http://search.jumei.com/?filter=0-11-1&amp;search=%E9%9B%85%E8%AF%97%E5%85%B0%E9%BB%9B&amp;from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">雅诗兰黛</a> <a
															href="http://skii.jumei.com/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">SK-II</a> <a
															href="http://loccitane.jumei.com/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">欧舒丹</a> <a
															href="http://sekkisei.jumei.com/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">雪肌精</a> <a
															href="http://biotherm.jumei.com/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">碧欧泉</a> <a
															href="http://guerlain.jumei.com/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">娇兰</a> <a
															href="http://benefit.jumei.com/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">贝玲妃</a>
													</div>
												</div>
											</div>
											<div class="subc3_item">
												<h2 class="subc3_item_title">欧美品牌</h2>
												<div class="subc3_item_body">
													<div class="subc3_area">
														<a
															href="http://marykay.jumei.com/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">玫琳凯</a> <a
															href="http://lancome.jumei.com/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">兰蔻</a> <a
															href="http://search.jumei.com/?filter=0-11-1&amp;search=%E9%9B%85%E6%BC%BE&amp;from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">雅漾</a> <a
															href="http://biotherm.jumei.com/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">碧欧泉</a> <a
															href="http://clinique.jumei.com/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">倩碧</a> <a
															href="http://clarins.jumei.com/ ?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">娇韵诗</a> <a
															href="http://maybelline.jumei.com/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">美宝莲</a> <a
															href="http://olay.jumei.com/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">玉兰油</a> <a
															href="http://decleor.jumei.com/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">思妍丽</a> <a
															href="http://search.jumei.com/?filter=0-11-1&amp;search=%E8%8F%B2%E6%8B%89%E6%A0%BC%E6%85%95&amp;from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">菲拉格慕</a> <a
															href="http://nivea.jumei.com/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">妮维雅</a> <a
															href="http://aaskincare.jumei.com/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">英国AA网</a> <a
															href="http://neutrogena.jumei.com/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">露得清</a> <a
															href="http://2n.jumei.com/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">2N</a>
													</div>
												</div>
											</div>
											<div class="subc3_item clear_bottom_line">
												<h2 class="subc3_item_title">独家品牌</h2>
												<div class="subc3_item_body">
													<div class="subc3_area">


														<a
															href="http://drwu.jumei.com/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">DR.WU</a> <a
															href="http://mall.jumei.com/magiccastle/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">魔法城堡</a> <a
															href="http://mall.jumei.com/hippofamily/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">河马家</a> <a
															href="http://mall.jumei.com/premiumcare/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">芙优润</a> <a
															href="http://mall.jumei.com/beautydiary/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">我的美丽日志</a> <a
															href="http://mall.jumei.com/jiyufang/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">肌御坊</a> <a
															href="http://mall.jumei.com/kalisetin/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">凯莉丝汀</a> <a
															href="http://mall.jumei.com/mimime/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">咪咪蜜</a> <a
															href="http://mall.jumei.com/suee/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">舒医</a> <a
															href="http://mall.jumei.com/fruitlover/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">水果诱惑</a> <a
															href="http://mall.jumei.com/eyeknow/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">眼睛说</a> <a
															href="http://mall.jumei.com/yinquanzhiyu/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">隐泉之语</a> <a
															href="http://mall.jumei.com/ueeti/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">优仪态</a> <a
															href="http://mall.jumei.com/pleaseme/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">悦己美</a> <a
															href="http://mall.jumei.com/flreons/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">梵柏莎</a>



													</div>
												</div>
											</div>
										</div>
										<div class="subc3_center_area fl">
											<div class="subc3_item">
												<h2 class="subc3_item_title">日韩品牌</h2>
												<div class="subc3_item_body">
													<div class="subc3_area">
														<a
															href="http://mall.jumei.com/skii/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">SK-II</a> <a
															href="http://innisfree.jumei.com/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">悦诗风吟</a> <a
															href="http://kose.jumei.com/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">高丝</a> <a
															href="http://aupres.jumei.com/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">欧珀莱</a> <a
															href="http://missha.jumei.com/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">谜尚</a> <a
															href="http://puremild.jumei.com/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">泊美</a> <a
															href="http://mamonde.jumei.com/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">梦妆</a> <a
															href="http://shuuemura.jumei.com/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">植村秀</a> <a
															href="http://thefaceshop.jumei.com/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">菲诗小铺</a> <a
															href="http://xiyanzhuanke.jumei.com/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">洗颜专科</a> <a
															href="http://dhc.jumei.com/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">DHC</a> <a
															href="http://charmzone.jumei.com/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">婵真</a> <a
															href="http://search.jumei.com/?filter=0-11-1&amp;brand=48&amp;from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">FANCL</a> <a
															href="http://justbb.jumei.com/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">嘉丝肤缇</a> <a
															href="http://search.jumei.com/?filter=0-11-1&amp;search=freeplus&amp;from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">freeplus</a>
													</div>
												</div>
											</div>
											<div class="subc3_item">
												<h2 class="subc3_item_title">国货品牌</h2>
												<div class="subc3_item_body">
													<div class="subc3_area">
														<a
															href="http://yunifang.jumei.com/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">御泥坊</a> <a
															href="http://baiqueling.jumei.com/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">百雀羚</a> <a
															href="http://meifubao.jumei.com/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">美肤宝</a> <a
															href="http://inoherb.jumei.com/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">相宜本草</a> <a
															href="http://kans.jumei.com/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">韩束</a> <a
															href="http://magiccastle.jumei.com/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">魔法城堡</a> <a
															href="http://afu.jumei.com/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">阿芙</a> <a
															href="http://danzi.jumei.com/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">丹姿</a> <a
															href="http://fanxishop.jumei.com/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">凡茜</a> <a
															href="http://maskfamily1908.jumei.com/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">膜法世家1908</a> <a
															href="http://missface.jumei.com/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">miss face</a> <a
															href="http://gf.jumei.com/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">高夫</a> <a
															href="http://myscheming.jumei.com/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">我的心机</a> <a
															href="http://mgmask.jumei.com/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">美即</a> <a
															href="http://marubi.jumei.com/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">丸美</a> <a
															href="http://jiyufang.jumei.com/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">肌御坊</a> <a
															href="http://pleaseme.jumei.com/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">悦己美</a>

													</div>
												</div>
											</div>
											<div class="subc3_item clear_bottom_line">
												<h2 class="subc3_item_title">洗护品牌</h2>
												<div class="subc3_item_body">
													<div class="subc3_area">
														<a
															href="http://crest.jumei.com/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">宝洁</a> <a
															href="http://dove.jumei.com/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">联合利华</a> <a
															href="http://tsubaki.jumei.com/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">丝蓓绮</a> <a
															href="http://lion.jumei.com/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">狮王</a> <a
															href="http://ora2.jumei.com/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">皓乐齿</a> <a
															href="http://spongeables.jumei.com/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">曼妮丝露</a> <a
															href="http://sebamed.jumei.com/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">施巴</a> <a
															href="http://algemarin.jumei.com/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">爱姬玛琳</a> <a
															href="http://malizia.jumei.com/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">玛莉吉亚</a> <a
															href="http://xuanqi.jumei.com/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">宣琪</a> <a
															href="http://oulaiya.jumei.com/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">巴黎欧莱雅</a> <a
															href="http://schwarzkopf.jumei.com/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank">施华蔻</a>


													</div>
												</div>
											</div>
										</div>
										<div class="subc3_right_area fl">
											<div class="subc3_brands_area">
												<h2 class="subc3_brands_title">推荐品牌</h2>
												<div class="subc3_brands_body clearfix">



													<div class="sub_brand_img fl">
														<a
															href="http://search.jumei.com/?filter=0-11-1&amp;search=%E9%9B%85%E8%AF%97%E5%85%B0%E9%BB%9B&amp;cat=1&amp;bid=2_c&amp;from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank"><img
															src="http://images2.jumei.com/dev_test/banner/3826/3855_180_90_021-web.jpg"
															alt=""></a>
													</div>
													<div class="sub_brand_img fl">
														<a
															href="http://arden.jumei.com/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank"><img
															src="http://images2.jumei.com/dev_test/banner/3826/3855_180_90_013-web.jpg"
															alt=""></a>
													</div>
													<div class="sub_brand_img fl">
														<a
															href="http://clinique.jumei.com/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank"><img
															src="http://images2.jumei.com/dev_test/banner/3826/3855_180_90_024-web.jpg"
															alt=""></a>
													</div>
													<div class="sub_brand_img fl">
														<a
															href="http://loreal.jumei.com/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank"><img
															src="http://images2.jumei.com/dev_test/banner/3826/3855_180_90_017-web.jpg"
															alt=""></a>
													</div>
													<div class="sub_brand_img fl">
														<a
															href="http://search.jumei.com/?filter=0-11-1&amp;search=%E9%9B%85%E6%BC%BE&amp;from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank"><img
															src="http://images2.jumei.com/dev_test/banner/3826/3855_180_90_022-web.jpg"
															alt=""></a>
													</div>
													<div class="sub_brand_img fl">
														<a
															href="http://laneige.jumei.com/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank"><img
															src="http://images2.jumei.com/dev_test/banner/3826/3855_180_90_012-web.jpg"
															alt=""></a>
													</div>
													<div class="sub_brand_img fl">
														<a
															href="http://lancome.jumei.com/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank"><img
															src="http://images2.jumei.com/dev_test/banner/3826/3855_180_90_015-web.jpg"
															alt=""></a>
													</div>
													<div class="sub_brand_img fl">
														<a
															href="http://thefaceshop.jumei.com/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank"><img
															src="http://images2.jumei.com/dev_test/banner/3826/3855_180_90_023-web.jpg"
															alt=""></a>
													</div>
													<div class="sub_brand_img fl">
														<a
															href="http://mamonde.jumei.com/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank"><img
															src="http://images2.jumei.com/dev_test/banner/3826/3855_180_90_018-web.jpg"
															alt=""></a>
													</div>
													<div class="sub_brand_img fl">
														<a
															href="http://baiqueling.jumei.com/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank"><img
															src="http://images2.jumei.com/dev_test/banner/3826/3855_180_90_019-web.jpg"
															alt=""></a>
													</div>



													<div class="sub_brand_img fl">
														<a
															href="http://carslan.jumei.com/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank"><img
															src="http://images2.jumei.com/dev_test/banner/3826/4459_180_90_004-web.jpg"
															alt=""></a>
													</div>


													<div class="sub_brand_img fl">
														<a
															href="http://za.jumei.com/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank"><img
															src="http://images2.jumei.com/dev_test/banner/3826/4459_180_90_005-web.jpg"
															alt=""></a>
													</div>
													<div class="sub_brand_img fl">
														<a
															href="http://search.jumei.com/?filter=0-11-1&amp;search=%E8%BF%AA%E5%A5%A5&amp;from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank"><img
															src="http://images2.jumei.com/dev_test/banner/3826/4459_180_90_007-web.jpg"
															alt=""></a>
													</div>


													<div class="sub_brand_img fl">
														<a
															href="http://shuuemura.jumei.com/?from=mall_null_index30_top_cate_null&amp;lo=3435&amp;mat=33548"
															target="_blank"><img
															src="http://images2.jumei.com/dev_test/banner/3826/4459_180_90_011-web.jpg"
															alt=""></a>
													</div>




												</div>
											</div>
										</div>
									</div>
									<div class="clear"></div>
								</div>
								<!-----国际品牌子导航 end--->
							</div>
						</div>
					</div>
					<!-- 左边上面文字导航部分结束 -->
					<!-- 左边下面图片开始 -->
					<div id="J_left_tuijianAd" class="left_tuijianAd" style="left:0px;">
						<a> <img src="../images/mallhead/73374_198_150_002-web.jpg"></img>
						</a>
					</div>
					<!-- 左边下面图片结束 -->
				</div>
			</div>
			<!-- 左边区域结束 -->
			<!-- 右边区域开始 -->
			<div class="new_admall_right_area clearfix">
				<!-- 图片轮播部分 -->
				<div id="box" class="new_admall_adBanner J_new_admall_adBanner">
					<div class="scc_container">
						<ul class="new_admall_content">
							<li><a href=""> <img
									src="../images/mallhead/73371_675_435_002-web.jpg"></img>
							</a></li>
							<li><a href=""> <img
									src="../images/mallhead/73368_675_435_003-web.jpg"></img>
							</a></li>
							<li><a href=""> <img
									src="../images/mallhead/73370_675_435_002-web.jpg"></img>
							</a></li>
						</ul>
					</div>
					<a href="##" class="prev" style="display: none;"></a> <a href="##"
						class="next" style="display: none;"></a>
					<div class="sc_index">
						<a class="bg" val="0"></a> <a val="1"></a> <a val="2"></a>
					</div>
				</div>
				<!-- 右边图片区域开始 -->
				<div class="new_admall_tuijianAd">
					<div class="tuijianAd" style="left: 0px;">
						<a><img src="../images/mallhead/73415_212_145_001-web.jpg"></img></a>
						<span class="tuijianAd_bottombg"></span>
					</div>
					<div class="tuijianAd" style="left: 0px;">
						<a><img src="../images/mallhead/73407_212_145_002-web.jpg"></img></a>
						<span class="tuijianAd_bottombg"></span>
					</div>
					<div class="tuijianAd" style="left: 0px;">
						<a><img src="../images/mallhead/73397_212_145_001-web.jpg"></img></a>
						<span class="tuijianAd_bottombg"></span>
					</div>
				</div>
				<!-- 右边图片区域结束 -->
				<!-- 品牌墙开始 -->
				<div id="brandWallSwitchable"
					class="brand_wall_switchable ecope_switchable">
					<div class="sc_index clearfix">
						<a href="" class="current">推荐品牌</a> <a href="" class="">独家品牌</a> <a
							href="" class="">欧美品牌</a> <a href="" class="">日韩品牌</a> <a href=""
							class="">国货品牌</a> <a href="" class="">洗护品牌</a>
						<div class="arrow_line" style="left:0px;">
							<s class="arrow"></s>
						</div>
					</div>
					<div class="sc_container" style="overflow: hidden;">
						<ul class="sc_list">
							<li
								style="position: relative; display: block; z-index: 2; top: 0px; left: 0px;">
								<ul class="brand_wall_left clearfix">
								<%-- <c:forEach var="u" items="${sessionScope.blogos }">
									<li><a> <img
											src="${contextPath }/images/Buser/logo/${u.blogo}"></img>
									</a></li>
									</c:forEach> --%>
									 <li><a> <img
											src="../images/mallhead/28437_163_100_003-web.jpg"></img>
									</a></li>
									<li><a> <img
											src="../images/mallhead/28437_163_100_003-web.jpg"></img>
									</a></li>
									<li><a> <img
											src="../images/mallhead/28437_163_100_003-web.jpg"></img>
									</a></li>
									<li><a> <img
											src="../images/mallhead/28437_163_100_003-web.jpg"></img>
									</a></li>
									<li><a> <img
											src="../images/mallhead/28437_163_100_003-web.jpg"></img>
									</a></li>
									<li><a> <img
											src="../images/mallhead/28437_163_100_003-web.jpg"></img>
									</a></li>
									<li><a> <img
											src="../images/mallhead/28437_163_100_003-web.jpg"></img>
									</a></li>
									<li><a> <img
											src="../images/mallhead/28437_163_100_003-web.jpg"></img>
									</a></li>
									<li><a> <img
											src="../images/mallhead/28437_163_100_003-web.jpg"></img>
									</a></li>
									<li><a> <img
											src="../images/mallhead/28437_163_100_003-web.jpg"></img>
									</a></li>
									<li><a> <img
											src="../images/mallhead/28437_163_100_003-web.jpg"></img>
									</a></li> 
								</ul>
								<div class="brand_wall_right">
									<a href=""> <img
										src="../images/mallhead/38506_202_202_002-web.jpg"></img>
									</a>
								</div>
							</li>
						</ul>
					</div>
					<!-- 箭头部分 -->
					<div class="sc_change">
						<a href="" class="sc_prev"></a> <a href="" class="sc_next"></a>
					</div>
				</div>
				<!-- 品牌墙结束 -->
			</div>
			<!-- 右边区域结束 -->
		</div>
	</div>
	<!-- 美妆商城品牌商品展示部分结束 -->
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
</html>