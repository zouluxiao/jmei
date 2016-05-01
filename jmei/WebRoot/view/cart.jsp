<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'cart.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="../css/cart.css">
	


  </head>
  
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
                   <a class = "cart_timer_tip float_box" href = "">
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
                   <tbody>
                    <tr>
                      <td valign = "top">
                       <div class = "cart_item_desc clearfix">
   <!-----选择框不对-------------<input class = "js_item_selector" data-item-key="1057067_d160428p905688zc" data-app = "all" checked = "'checked'/" type="checkbox">
                         </input>------------->
                         <div class = "cart_item_desc_wrapper">
                         <a class = "cart_item_pic href="" target="_blank">
                           <img src = "../images/cart/905688_60_60.jpg" alt = "美宝莲眼部及唇部卸妆液70ml"></img>
                           <span class = "sold_out_pic png"></span>
                         </a>
                          <a class = "cart_item_link" title="美宝莲眼部及唇部卸妆液70ml" href="" target="_blank">美宝莲眼部及唇部卸妆液70ml</a>
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
                               <p class="jumei_price">25.00</p>
                            </div>
                    
                         </td>
                         <td>
                             <div class="cart_item_num">
                                <div class="item_quantity_editer clearfix" data-item-key="1057067_d160428p905688zc">
                                   <span class = "decrease_one disabled">-</span>
                                   <input class="item_quantity" value = "1" type="text"></input>
                                   <span class="increase_one">+</span>
                                </div>
                                  <div class = "item_shortage_tip"></div>
                             </div>
                         </td>
                         <td>
                            <div class = "cart_item_total">
                               <p class="item_total_price">25.00</p>
                            </div>
                         </td>
                         <td>
                             <div class="cart_item_option">
                                <a class="icon_small delete_item png" data-item-key="1057067_d160428p905688zc" href="javascript:void(0)" title="删除">   
                                </a>
                             </div>
                         </td>
                      </tr>
                   </tbody>
                      <tfoot>
                         <tr>
                            <td colspan="5">商品金额:<span class="group_total_price">￥25.00</span></td>   
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
                    <span class="total_amount">1</span>
                      件商品    商品应付总额：
                    <span class="total_price">￥25.00</span>
                    <a id="go_to_order" class="btn" href="javascript:;">去结算</a>
                      
                 </div>
<!---------------------------<div class = "content_footer clearfix">
                               <div class = "cart_timer_wrapper cart_out_of_time">
                                   <i class="icon_small png">
                                      <span class = "cart_timer_out">已超过购物车商品保留时间，请尽快结算。[?]</span>
                                   </i>
                               </div>
                             </div>----------------------->
        </div>
        <div class="htt">
            <a href = "">
            <img src = "../images/cart/zj.png"></img>
            </a>
        </div>
  </body>
</html>
