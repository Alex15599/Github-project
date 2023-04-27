function validateRegisterForm(form){
		if (form.userName.value==""){
			alert("请输入用户名!");form.userName.focus();return false;
		}
		if (form.password.value==""){
			alert("请输入密码!");form.password.focus();return false;
		}
		if (form.password2.value==""){
			alert("确认密码不能为空!");form.password2.focus();return false;
		}
		if(form.password.value!=form.password2.value){
			alert("两次输入的密码不相同，请重新检验!");
			form.password2.select();return false;
		}
		if(form.email.value==""){
			alert("Email地址不能为空!");
			form.email.focus();
			return false;
		}
		if(form.email.value.indexOf("@")<0){
			alert("Email地址不符合规定!");
			form.email.select();
			return false;
		}
	}// JavaScript Document