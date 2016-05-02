var flag = 1;
function Test(){
	var obj = document.getElementById("shoppingcartdisplay");
	if(flag == 0){
		obj.style.display="none";
		flag = 1;
	}else{
		obj.style.display="block";
		flag = 0;
	}
}

