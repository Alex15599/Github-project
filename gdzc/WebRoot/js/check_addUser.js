function checkUser(myform){
	if(myform.comployee_no.value.length==0){
		alert("员工编号不能为空！")
		myform.comployee_no.focus();
		return false;
	}
	if(myform.userName.value.length==0){
		alert("用户名不能为空！")
		myform.userName.focus();
		return false;
	}
	if(myform.password.value.length==0){
		alert("用户密码不能为空！")
		myform.password.focus();
		return false;
	}
	if(myform.password.value.length<6){
		alert("用户密码长度不能小于6位！")
		myform.password.focus();
		return false;
	}
	 if(myform.password.value!=myform.password2.value)
	{
		alert("两次输入的密码不相同!!!");
		myform.password2.select();
		return false;
	}
}