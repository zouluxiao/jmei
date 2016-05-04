<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

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
<link rel="stylesheet" type="text/css" href="../css/jmeihead.css"></link>
<link rel="stylesheet" type="text/css" href="../css/foreshow.css"></link>
<link rel="stylesheet" type="text/css" href="../css/foot.css"></link>
<script type="text/javascript">
	function getorderlist(){
		alert("daozhel");
		 var xhr;
      	 if(window.XMLHttpRequest){
      	 	xhr = new XMLHttpRequest(); //firefox
      	 }else if(window.ActiveXObject){
      	 	xhr = new ActiveXObject("Microsoft.XMLHTTP");
      	 }
      	 var url="${pageContext.request.contextPath}/order.do?method=alllist"; 
      	 xhr.open("GET",url);
      	 //3.设置请求的头部信息   GET不许设置头部信息
      	 //xhr.setRequestHeader("enctype","application/x-www-form-urlencoded");
      	 
      	//4.发送消息   GET: 
      	xhr.send(null);
	}
</script>
</head>
<body style="width:1349px;height: 100%;">
	<div class="header header_wide_lv2">
		<div class="header_top">
			<div class="header_top_box">
				<!--login-->
				<ul class="header_top_left" id="headerTopLeft">
						<li>欢迎来到聚美！</li>
						<li><a href="login.jsp">请登录</a></li>
						<li><a href="regist.jsp">快速注册</a></li>
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
					<li class="item_ijumei"><a href="personal.jsp" onclick="getorderlist();">我的聚美 <s
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
				<form action="" method="">
					<input id="search" type="text" class="header_search_input">
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
		<div class="site_body">
			<div id="site_switch" class="ecope_switchable site_switch">
				<div class="sc_container">
					<ul>
						<li
							style="position: absolute; display: block; z-index: 2; top: 0px; left: 0px; background: url(../images/jmeihead/75172_1920_350_002-web.jpg) 50% 0px no-repeat;"></li>
					</ul>
				</div>
				<div class="sc_index">
					<a href="#" class="current"></a> <a href="#"></a>
				</div>
			</div>
		</div>
	</div>
	<div id="Mad_rush" class="Mad_rush">
      <ul class = "Mad_rushtop">
         <li class = "current">
                                   今日疯抢
         </li>
         <li class = "m">
                                    明日预告
           <em>20</em>
         </li>
      </ul>
      <div class="Mad_rushcenter">
        <a href = "">
          <img src = "../images/foreshow/75581_535_212_001-web.jpg"></img>
        </a>
        <a href = "">
          <img src = "../images/foreshow/75587_535_212_002-web.jpg"></img>
        </a>
        <a href = "">
          <img src = "../images/foreshow/75589_535_212_004-web.jpg"></img>
        </a>
        <a href = "">
          <img src = "../images/foreshow/75592_535_212_002-web.jpg"></img>
        </a>
        <a href = "">
          <img src = "../images/foreshow/75598_535_212_002-web.jpg"></img>
        </a>
        <a href = "">
          <img src = "../images/foreshow/75601_535_212_002-web.jpg"></img>
        </a>
        <a href = "">
          <img src = "../images/foreshow/75604_535_212_002-web.jpg"></img>
        </a>
        <a href = "">
          <img src = "../images/foreshow/75606_535_212_002-web.jpg"></img>
        </a>
        <a href = "">
          <img src = "../images/foreshow/75608_535_212_002-web.jpg"></img>
        </a>
        <a href = "">
          <img src = "../images/foreshow/75610_535_212_002-web.jpg"></img>
        </a>
        <a href = "">
          <img src = "../images/foreshow/75612_535_212_001-web.jpg"></img>
        </a>
        <a href = "">
          <img src = "../images/foreshow/75616_535_212_002-web.jpg"></img>
        </a>
        <a href = "">
          <img src = "../images/foreshow/75619_535_212_002-web.jpg"></img>
        </a>
        <a href = "">
          <img src = "../images/foreshow/75620_535_212_002-web.jpg"></img>
        </a>
        <a href = "">
          <img src = "../images/foreshow/75623_535_212_002-web.jpg"></img>
        </a>
        <a href = "">
          <img src = "../images/foreshow/75625_535_212_002-web.jpg"></img>
        </a>
        <a href = "">
          <img src = "../images/foreshow/75626_535_212_002-web.jpg"></img>
        </a>
        <a href = "">
          <img src = "../images/foreshow/75630_535_212_002-web.jpg"></img>
        </a>
        <a href = "">
          <img src = "../images/foreshow/75633_535_212_002-web.jpg"></img>
        </a>
        <a href = "">
          <img src = "../images/foreshow/75636_535_212_002-web.jpg"></img>
        </a>
    </div>
   </div>
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