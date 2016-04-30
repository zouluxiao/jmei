<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<title>用户中心-聚美优品</title>
	<link rel="stylesheet" type="text/css" href="../css/common.css"/>
	<link rel="stylesheet" type="text/css" href="../css/personal.css"/>
</head>
<body class="OnSale">
	<div class="profile">
		<div class="nav">
			<div class="notice">
				<a style="border-bottom: 0;padding:0;" target="_blank" href="">
					<img src="..//images/personal/64_64.png">
				</a>
				<p class="nickname">
					<a target="_blank" href="" style="padding-left:0;line-height: 1.8;color:#ed145b" id="username">JM153AWHW0309</a>
				</p>
				<p>
					<a href="" target="_blank" style="padding-left:0;line-height: normal;">普通会员</a>
				</p>
				<p id="juserid" class="uid">用户ID: 106073332</p>
			</div>
			<h2>
				<b></b>
				我的聚美优品
			</h2>
			<a href="" class="list selected">
				<b></b>
				我的订单
			</a>
			<a href="" class="wish">
				<b></b>
				我的心愿单
			</a>
			<a href="" class="fav">
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
			<a href="" class="settings">
				<b></b>
				设置账户信息
			</a>
			<a href="" class="password">
				<b></b>
				修改密码
			</a>
			<a href="" class="bind">
				<b></b>
				绑定手机
			</a>
			<a href="" class="addr">
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
		<div id="myorder" style="display:none;">
			<h1>
			<a target="_blank" href="http://www.jumei.com/i/activity/download_app">手机客户端，随时随地查看物流详情</a>
			我的订单
			</h1>
			<div class="content">
				<div class="filter">
					<a class="curr" href="" id="orderalllist">全部订单</a>
					<a href="">等待付款</a>
					<a href="">已付款</a>
					<a href="">交易完成</a>
					<a href="">预售订单</a>
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
		<div id="mycollection" style="display:none;">
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
		<div id="personal" style="display:none;">
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
						<input type="text" id="personname" class="t_input" value="JM153AWHW0309" name="username" size="30" required="">
					</div>
					<dl class="formlist">
						<dt>Email</dt>
						<dd>
							<span class="data">您还未绑定邮箱</span>
							<a href="" class="btn_mid_pink">立即绑定</a>
						</dd>
					</dl>
					<dl class="formlist" style="margin-top:16px;">
						<dt>手机号</dt>
						<dd>
							<span class="data" id="ptel">153****0309
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
		<div id="updatepwd" style="display:none;" >
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
		<div id="address">
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
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>