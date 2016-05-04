var AjaxUtils={
		createXhr: function(){
		 	var xhr;
	 		if(window.XMLHttpRequest){
	    	 	xhr = new XMLHttpRequest(); //firefox
	    	 }else if(window.ActiveXObject){
	    	 	xhr = new ActiveXObject("Microsoft.XMLHTTP");
	    	 }
	 		return xhr;
		},
		request:function(method,url,data,callback){
			//1.创建xhr对象
			var xhr = this.createXhr();
			if(method == "POST"){
				xhr.open(method,url);
				//2.打开连接
				//3.设置头部信息
				xhr.setRequestHeader("enctype","application/x-www-form-urlencoded");
				//4.发送信息
				xhr.send(data);
			}else if(method == "GET"){
				//2.打开连接
				xhr.open(method,url+"?"+data);
				xhr.send(null);
			}
			//5.监听状态值和状态码
			 xhr.onreadystatechange = function(){
	       	 	 if(xhr.readyState == 4){ //浏览器的接收到了内容
	       	 	 	 if(xhr.status == 200) { //浏览器获取了正确响应信息\
	       	 	 		 //1.返回的是text 返回的xml
	       	 	 		 var val = {
	       	 	 			 text: xhr.responseText,
	       	 	 			 xml:xhr.responseXML
	       	 	 		 };
	       	 	 	 	 callback(val); //函数回调
	       	 	 	 }	
	       	 	 }
	       	 }
			
		}
		
}