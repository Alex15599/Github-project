function check_update(myform){
	if(myform.username.value==0){
		alert("用户名不能为空！");
		myform.username.focus();
		return false;
	}
	if(myform.old_pwd.value.length==0){
		alert("用户的原密码不能为空！");
		myform.old_pwd.focus();
		return false;
	}
	if(myform.new_pwd.value.length==0){
		alert("请输入新密码！");
		myform.new_pwd.focus();
		return false;
	}
	if(myform.new_pwd2.value.length==0){
		alert("请再次输入新密码！");
		myform.new_pwd2.focus();
		return false;
	}
	if(myform.new_pwd.value!=myform.new_pwd2.value){
		alert("两次输入的密码不相同，请再次输入！");
		myform.new_pwd2.select();
		return false;
	}
}