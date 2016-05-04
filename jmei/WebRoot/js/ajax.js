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
			//1.����xhr����
			var xhr = this.createXhr();
			if(method == "POST"){
				xhr.open(method,url);
				//2.������
				//3.����ͷ����Ϣ
				xhr.setRequestHeader("enctype","application/x-www-form-urlencoded");
				//4.������Ϣ
				xhr.send(data);
			}else if(method == "GET"){
				//2.������
				xhr.open(method,url+"?"+data);
				xhr.send(null);
			}
			//5.����״ֵ̬��״̬��
			 xhr.onreadystatechange = function(){
	       	 	 if(xhr.readyState == 4){ //������Ľ��յ�������
	       	 	 	 if(xhr.status == 200) { //�������ȡ����ȷ��Ӧ��Ϣ\
	       	 	 		 //1.���ص���text ���ص�xml
	       	 	 		 var val = {
	       	 	 			 text: xhr.responseText,
	       	 	 			 xml:xhr.responseXML
	       	 	 		 };
	       	 	 	 	 callback(val); //�����ص�
	       	 	 	 }	
	       	 	 }
	       	 }
			
		}
		
}