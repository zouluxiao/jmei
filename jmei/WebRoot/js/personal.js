
function ajax(){
	var objall=getobj("orderalllist");
	var objwait=getobj("waitlist");
	var objbuy = getobj("buylist");
	var objend = getobj("endlist");
	objall.className="curr";
	objwait.className="";
	objbuy.className="";
	objend.className=""
     //1.����xhr���� 
     var xhr;
     if(window.XMLHttpRequest){
     	xhr = new XMLHttpRequest(); //firefox
     }else if(window.ActiveXObject){
     	 xhr = new ActiveXObject("Microsoft.XMLHTTP");
     }
     var url="${pageContext.request.contextPath}/order.do?method=alllist"; 
     xhr.open("POST",url);
     //3.���������ͷ����Ϣ   GET��������ͷ����Ϣ
     xhr.setRequestHeader("enctype","application/x-www-form-urlencoded");
     //4.����״ֵ̬��״̬��
   	 xhr.onreadystatechange = function(){
   	 	 if(xhr.readyState == 4){ //������Ľ��յ�������
   	 	 	 if(xhr.status == 200) { //�������ȡ����ȷ��Ӧ��Ϣ
   	 	 	 	  //6.��ȡ��Ӧ������ (�ı�:responseText Xml:responseXML)
   	 	 	 	 // var text = xhr.responseText;
   	 	 	 	  
   	 	 	 	  //������Ӧ�Ľ��
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