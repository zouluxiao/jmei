<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>结算</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="../css/cart.css">
  </head>
  <script type="text/javascript">
  	function dele(num){
  		var obj = document.getElementById("tbody");
  		
  		//更新总价
  		var objtxt = document.getElementById("txt_"+num);
  		var total = document.getElementById("total_id");
  	  	total.innerText = parseInt(total.innerText) - objtxt.value;
  		//更新总数
  		var it = document.getElementById("item_"+num);
  		var sum = document.getElementById("total_pri");
  		sum.innerText = parseInt(sum.innerText) - parseInt(it.innerText);
  		//同步
  		var group_price = document.getElementById("group_price");
  		group_price.innerText = sum.innerText;
  		//移除
  	  	obj.removeChild(document.getElementById("tr_"+num));
  	}
  	//减少
  	function sub(num){
  		var obj = document.getElementById("txt_"+num);
  		if(obj.value <= 0){
  			obj.value = 0;
  		}else{
			obj.value = parseInt(obj.value) - 1;   
			var total = document.getElementById("total_id");
  	  		total.innerText = parseInt(total.innerText) - 1;
  	  		//计算小记
  	  		var it = document.getElementById("item_"+num);
  	  		it.innerText = parseInt(document.getElementById("price_"+num).innerText)*parseInt(obj.value);
  	  		//更新总价
  	  		var sum = document.getElementById("total_pri");
  	  		sum.innerText = parseInt(sum.innerText)-parseInt(document.getElementById("price_"+num).innerText);
  	  		var group_price = document.getElementById("group_price");
  	  		group_price.innerText = sum.innerText;
  		}
  	}
  	//增加
  	function add(num){
  		var obj = document.getElementById("txt_"+num);
  		if(obj.value > 10){
  			obj.value = obj.value;
  		}else{
			obj.value = parseInt(obj.value) + 1;  
			//计算小记
	  		var it = document.getElementById("item_"+num);
	  		it.innerText = parseInt(document.getElementById("price_"+num).innerText)*parseInt(obj.value);
	  		//更新总数
			var total = document.getElementById("total_id");
		  	total.innerText = parseInt(total.innerText) + 1;
		  	//更新总价
	  		var sum = document.getElementById("total_pri");
	  		sum.innerText = parseInt(sum.innerText)+parseInt(document.getElementById("price_"+num).innerText);
	  		var group_price = document.getElementById("group_price");
	  		group_price.innerText = sum.innerText;
  		}
  	}
  </script>
  
  <body>
     <div class = "cart">
        <div class = "cart_top">
           <div id = "JS_user_box" class = "user_box">
               <div>
                  聚美优品欢迎您，
                  <a href = "">登录</a>
                  <i class = "tips">|</i>
                  <a href = "">免费注册</a> 
               </div>
           </div>
        </div>
        <div class = "cart_header_box">
           <div class = "cart_header clearfix">
              <h1 class = "logo_box">
                 <a id = "home" href = "">
                   <img src = "../images/cart/cart_logo.jpg"></img>
                 </a>
              </h1>
              <div class = "order_path order_path_1"></div>
           </div>
        </div>  
     </div>
     <div id = "container" style = "width:auto;">
        <div id = "group_show">
            <div class = "content_header clearfix">
               <div class = "cart_timer_wrapper">
                   <i class = "icon_small png"></i>
   <!------------<span class = "cart_timer_counting">
                    请在
                   <span class = "cart_timer_text">09分50秒</span>
                    内去结账，并在下单后
                   <span class = "pink">20</span>
                   分钟内完成支付
                  </span>--------------->
                  <span class = "cart_timer_out">已超过购物车商品保留时间，请尽快结算。</span>
                  [
                   <a class = "cart_timer_tip float_box">
                     ?
                     <!-------<div class = pop_box>
                        <span class = arrow_t_1>
                            <span class = "arrow_t_2"></span>
                        </span>
                         <div class = "timer_tip_text">
                          由于商品有限，我们只能为您最多保存20分钟，
                          <br></br>
                           20分钟后购物车将被清空，请尽快结算订单。
                         </div>
                     </div>
                   </a>---------->
                   ]
               </div>
             <div class = "top_banner">
                <ul class = "header_icons">
                   <li>
                      <span>
                         <i style="background-position: 0 -107px;" class = "icon_zhenpin header_icon png"></i>
                         真品防伪码
                      </span>
                   </li>

                   <li>
                      <span>
                        <i class = "icon_tuihuo header_icon png"></i>
                         30天无条件退货
                      </span>
                   </li>
                           
                   <li>
                      <span>
                       <i class = "icon_baoyou header_icon png"></i>
                         美妆满2件或299元包邮
                      </span>
                   </li>     
                </ul>
             </div>
             <div class = "common_shippment">
                <i class = "icon_small icon_baoyou png">包邮</i>
                新用户首单满39元包邮，自营非食品类满两件或满299元包邮
             </div>
            </div>
               <div class = "groups_wrapper">
                  <table class = "cart_group_item cart_group_item_product">
                     <thead>
                        <tr>
                           <th class = "cart_overview">
                              <div class = "cart_group_header">
                                 <input class = "js_group_selector cart_group_selecttor" checked = "cheecked" type = "checkbox"></input> 
                                   <h2>聚美优品发货</h2>
                              </div>
                           </th>
                           <th class = "cart_price">聚美(元)</th>
                           <th class = "cart_num">数量</th>
                           <th class = "cart_total">小计(元)</th>
                           <th class = "cart_option">操作</th>
                         </tr>
                     </thead>
                   <tbody id="tbody">
                   <%-- ${sessionScope.ShoppingCart.goodsCart } --%>
                   <c:forEach var="u" varStatus="s1" items="${sessionScope.ShoppingCart.goodsCart }">
                    <tr id="tr_${s1.index }">
                      <td valign = "top">
                       <div class = "cart_item_desc clearfix">
   <!-----选择框不对-------------<input class = "js_item_selector" data-item-key="1057067_d160428p905688zc" data-app = "all" checked = "'checked'/" type="checkbox">
                         </input>------------->
                         <div class = "cart_item_desc_wrapper">
                         <a class = "cart_item_pic href="" target="_blank">
                           <img src = "../images/goodspic/2/${sessionScope.pl[s1.index].picpname }" alt = "美宝莲眼部及唇部卸妆液70ml"></img>
                           <span class = "sold_out_pic png"></span>
                         </a>
                          <a class = "cart_item_link" title="美宝莲眼部及唇部卸妆液70ml" href="" target="_blank">${u.detailname }</a>
                         <p class="sku_info">
                           型号：
                           <span class="cart_item_attribute">70ml</span>
                         </p>
                             <div class="sale_info clearfix">
                                <div class="tips_pop_full float_box JS_tips_pop_full">
                                </div>
                                   <a class="sale_tag gift JS_sale_tag" data-promo-type="gift">
                                     满赠
                                     <i class="icon_small png"></i>
                                   </a>
                
                                <div class="tips_pop_full float_box JS_tips_pop_full">
                                </div>
                                   <a class="sale_tag reduce JS_sale_tag" data-promo-type="reduce">
                                     满减
                                     <i class="icon_small png"></i>
                                   </a>
                             </div> 
                         </div>
                       </div>
                         </td>
                         <td>
                            <div class = "cart_itim_price">
                               <span id="price_${s1.index }" class="jumei_price" style="position: relative;top: -20px;text-align: center;">${u.price }</span>
                            </div>
                    
                         </td>
                         <td>
                             <div class="cart_item_num">
                                <div class="item_quantity_editer clearfix"  style="width: 70px;margin: 0px auto;">
                                   <span class = "decrease_one disabled" style="display: block;float: left;width: 15px;" onclick="sub(${s1.index});">-</span>
                                   <input style="display: block;text-align: center;float: left;" class="item_quantity" value = "1" type="text" id="txt_${s1.index }"></input>
                                   <span class="increase_one" style="float: left;width: 15px;" onclick="add(${s1.index});">+</span>
                                </div>
                                  <div class = "item_shortage_tip"></div>
                             </div>
                         </td>
                         <td>
                            <div class = "cart_item_total">
                               <span class="item_total_price" id="item_${s1.index }">${u.price }</span>
                            </div>
                         </td>
                         <td>
                             <div class="cart_item_option">
                                <a onclick="dele(${s1.index});" class="icon_small delete_item png" data-item-key="1057067_d160428p905688zc" href="javascript:void(0)" title="删除">   
                                </a>
                             </div>
                         </td>
                      </tr>
                      </c:forEach>
                   </tbody>
                      <tfoot>
                         <tr>
                            <td colspan="5">商品金额:￥<span class="group_total_price" id="group_price">${sessionScope.ShoppingCart.sum }</span></td>   
                         </tr>
                      </tfoot>
                  </table>        
            </div>
                 <div class="common_handler">
                  
  
                 <label class="cart_all_selector_wrapper" for="js_all_selector">
                   <input id="js_all_selector" class="js_all_selector all_selector" type="checkbox"></input>
                     全选
                 </label>
                  <a class = "go_back_shopping" href="">继续购物</a>
                    <span class="seperate_line">|</span>
                 <a class="clear_cart_all" href="">清空选中商品</a>
 
                     
                      共 
                    <span class="total_amount" id="total_id">${sessionScope.ShoppingCart.goodsCart.size() }</span>
                      件商品    商品应付总额：
                   	 ￥<span class="total_price" id="total_pri">${sessionScope.ShoppingCart.sum }</span>
                    <a id="go_to_order" class="btn" href="selectAddress.jsp">去结算</a>
                      
                 </div>
<!---------------------------<div class = "content_footer clearfix">
                               <div class = "cart_timer_wrapper cart_out_of_time">
                                   <i class="icon_small png">
                                      <span class = "cart_timer_out">已超过购物车商品保留时间，请尽快结算。[?]</span>
                                   </i>
                               </div>
                             </div>----------------------->
        </div>
        <div id="JS_recommend_box" class="recommend_box">
            <div class="nav_tips">
              <a class="JS_recommend_nav" href="javascript:;">
                                       <!-- 购买的还买了 -->
              <i class="right_border"></i>                           
              </a>
              <a class="JS_recommend_nav active" href="javascript:;"><!-- 今日备受欢迎 --></a>
            </div>
        </div>
        <div style="display:none;margin-left: auto; margin-right: auto; width: 51%;margin-top: -20px">
          <ul class="clearfix JS_recommend_cont" style="display: block;">
             <li class="list">
                <div>
                    <div>
                      <a href="">
                        <img src="../images/cart/1.jpg"></img>
                      </a>
                    </div>
                    <div class="tips_info_box">
                      <a class="tips_info" href = "">
                         五官好，身材好，不如皮肤好!终结无聊沐浴乳！吸出毛孔
                      </a>
                    </div>
                    <div class="price_grey">
                       <span class="price">¥39.9</span>
                    </div>
                    <div>
                       <a class="cart_btn">加入购物车</a>
                    </div>
                </div> 
             </li>
  <!-- ------------------ --> 
             <li class="list">
                <div>
                    <div>
                      <a href="">
                        <img src="../images/cart/2.jpg"></img>
                      </a>
                    </div>
                    <div class="tips_info_box">
                      <a class="tips_info" href = "">
                         Hippo Family 原生矿物火山泥膜  240g
                      </a>
                    </div>
                    <div class="price_grey">
                       <span class="price">¥89.9</span>
                    </div>
                    <div>
                       <a class="cart_btn">加入购物车</a>
                    </div>
                </div> 
             </li>
  <!--  -->  
             <li class="list">
                <div>
                    <div>
                      <a href="">
                        <img src="../images/cart/3.jpg"></img>
                      </a>
                    </div>
                    <div class="tips_info_box">
                      <a class="tips_info" href = "">
                       BEELY彼丽玫瑰滋养身体乳250ml
                      </a>
                    </div>
                    <div class="price_grey">
                       <span class="price">¥39.0</span>
                    </div>
                    <div>
                       <a class="cart_btn">加入购物车</a>
                    </div>
                </div> 
             </li>
             <!--  -->
             <li class="list">
                <div>
                    <div>
                      <a href="">
                        <img src="../images/cart/4.jpg"></img>
                      </a>
                    </div>
                    <div class="tips_info_box">
                      <a class="tips_info" href = "">
                       雅漾舒护活泉喷雾300ml，增强肌肤耐受性，降低敏感度。
                      </a>
                    </div>
                    <div class="price_grey">
                       <span class="price">¥90.0</span>
                    </div>
                    <div>
                       <a class="cart_btn">加入购物车</a>
                    </div>
                </div> 
             </li>
             <!--  -->
             <li class="list">
                <div>
                    <div>
                      <a href="">
                        <img src="../images/cart/5.jpg"></img>
                      </a>
                    </div>
                    <div class="tips_info_box">
                      <a class="tips_info" href = "">
                         好评如潮的护肤品！Suee绵羊油深层滋养，保湿不黏腻，开启你的逆龄美肌
                      </a>
                    </div>
                    <div class="price_grey">
                       <span class="price">¥69.9</span>
                    </div>
                    <div>
                       <a class="cart_btn">加入购物车</a>
                    </div>
                </div> 
             </li>
             <!--  -->
             <li class="list">
                <div>
                    <div>
                      <a href="">
                        <img src="../images/cart/6.jpg"></img>
                      </a>
                    </div>
                    <div class="tips_info_box">
                      <a class="tips_info" href = "">
                         Hippo Family 清润矿物绿竹泥膜 240g
                      </a>
                    </div>
                    <div class="price_grey">
                       <span class="price">¥39.9</span>
                    </div>
                    <div>
                       <a class="cart_btn">加入购物车</a>
                    </div>
                </div> 
             </li>
             <!--  -->
             <li class="list">
                <div>
                    <div>
                      <a href="">
                        <img src="../images/cart/7.jpg"></img>
                      </a>
                    </div>
                    <div class="tips_info_box">
                      <a class="tips_info" href = "">
                         河马家第二代【小灯泡】白泥强势回归，皮肤亮到素颜也能上直播~
                      </a>
                    </div>
                    <div class="price_grey">
                       <span class="price">¥39.9</span>
                    </div>
                    <div>
                       <a class="cart_btn">加入购物车</a>
                    </div>
                </div> 
             </li>
             <!--  -->
             <li class="list">
                <div>
                    <div>
                      <a href="">
                        <img src="../images/cart/8.jpg"></img>
                      </a>
                    </div>
                    <div class="tips_info_box">
                      <a class="tips_info" href = "">
                         宣琪桃花幼嫩(幼白）搓泥浴宝沐浴露200ml*2（两款随机发货）
                      </a>
                    </div>
                    <div class="price_grey">
                       <span class="price">¥39.9</span>
                    </div>
                    <div>
                       <a class="cart_btn">加入购物车</a>
                    </div>
                </div> 
             </li>
             <!--  -->
             <li class="list">
                <div>
                    <div>
                      <a href="">
                        <img src="../images/cart/9.jpg"></img>
                      </a>
                    </div>
                    <div class="tips_info_box">
                      <a class="tips_info" href = "">
                        去你的讨厌不已的鸡皮！满足身体的所有欲望，让他的手一滑到底！
                      </a>
                    </div>
                    <div class="price_grey">
                       <span class="price">¥79.9</span>
                    </div>
                    <div>
                       <a class="cart_btn">加入购物车</a>
                    </div>
                </div> 
             </li>
 <!-----------------------------  -->
          </ul>
        </div>
        <div id="footer_copyright" class="footer_con">
              <p class="footer_copy_con">
              © 2013 北京创锐文化传媒有限公司 Jumei.com 保留一切权利。客服热线：400-123-8888
              <br></br> 
              京公网安备 11010102001226 | 
              <a href="">京ICP证111033号</a>
               | 食品流通许可证 SP1101051110165515（1-1）| 
               <a href="">营业执照</a>
              </p>
              <p>
                <a class="footer_copy_logo logo01" href="" style="background-position: 0px -168px;"></a>
                <a class="footer_copy_logo logo02" href="" style="background-position: 0px -219px;"></a>
                <a class="footer_copy_logo logo03" href="" style="background-position: 0px -270px;"></a>
                <a class="footer_copy_logo logo04" href="" style="background-position: 0px -321px;"></a>
                <a class="footer_copy_logo logo05" href="" style="background-position: 0px -372px;"></a>
              </p>
        </div>
  </body>
</html>
