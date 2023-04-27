function check_zcwx(form){
	if(form.zc_id.value.length==0){
		alert("资产编号不能为空！");
		form.zc_id.focus();
		return false;
	}
	if(form.send_time.value.length==0){
		alert("资产送修时间不能为空！");
		return false;
	}
	if(form.sender.value.length==0){
		alert("资产维修送修人不能为空！");
		form.sender.focus();
		return false;
	}
	if(form.login_user.value.length==0){
		alert("维修负责人不能为空！");
		form.login_user.focus();
		return false;
	}
	if(form.reason.value.length==0){
		alert("请填写资产故障原因！");
		form.reason.focus();
		return false;
	}
}