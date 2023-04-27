function check_editZcInfo(form){
	if(form.zc_no.value.length==0){
		alert("资产编号不能为空！");
		form.zc_id.focus();
		return false;
	}
	if(form.zc_no.value.length==0){
		alert("资产型号不能为空！");
		form.zc_no.focus();
		return false;
	}
	if(form.zc_name.value.length==0){
		alert("资产名称不能为空！");
		form.zc_name.focus();
		return false;
	}
	if(form.date.value.length==0){
		alert("请选择资产的生产日期！")
		return false;
	}
	if(form.price.value.length==0){
		alert("资产的单价不能为空！");
		form.price.focus();
		return false;
	}
	if(form.factory.value.length==0){
		alert("资产的生产厂商信息不能为空！");
		form.factory.focus();
		return false;
	}
	if(form.buyer.value.length==0){
		alert("请填写该资产的购买人信息！");
		form.buyer.focus();
		return false;
	}
}// JavaScript Document