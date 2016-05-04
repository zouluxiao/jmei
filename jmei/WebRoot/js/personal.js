
function ajax(){
	var objall=getobj("orderalllist");
	var objwait=getobj("waitlist");
	var objbuy = getobj("buylist");
	var objend = getobj("endlist");
	objall.className="curr";
	objwait.className="";
	objbuy.className="";
	objend.className=""
     //1.创建xhr对象 
     var xhr;
     if(window.XMLHttpRequest){
     	xhr = new XMLHttpRequest(); //firefox
     }else if(window.ActiveXObject){
     	 xhr = new ActiveXObject("Microsoft.XMLHTTP");
     }
     var url="${pageContext.request.contextPath}/order.do?method=alllist"; 
     xhr.open("POST",url);
     //3.设置请求的头部信息   GET不许设置头部信息
     xhr.setRequestHeader("enctype","application/x-www-form-urlencoded");
     //4.监听状态值和状态码
   	 xhr.onreadystatechange = function(){
   	 	 if(xhr.readyState == 4){ //浏览器的接收到了内容
   	 	 	 if(xhr.status == 200) { //浏览器获取了正确响应信息
   	 	 	 	  //6.获取响应的内容 (文本:responseText Xml:responseXML)
   	 	 	 	 // var text = xhr.responseText;
   	 	 	 	  
   	 	 	 	  //处理响应的结果
   	 	 		 var obj1 =  document.getElementById("null_info");
   	 	 	 	 var obj =  document.getElementById("order-list");
   	 	 	 	 if(session.getAttribute("orderalllist") == null){
   	 	 	 		 obj.className = "order_table non";
   	 	 	 		 obj1.className="null_info blok";
   	 	 	 	 }
   	 	 	
   	 	 	 	 //obj.innerText = text;
   	 	 	 }	
   	 	 }
   	 }
     
}


function getobj(id){
	return document.getElementById(id);
}