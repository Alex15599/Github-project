function checkEmployee(myform){
	if(myform.E_no.value.length==0){
		alert("员工编号不能为空！")
		myform.E_no.focus();
		return false;
	}
	if(myform.E_name.value.length==0){
		alert("员工姓名不能为空！")
		myform.E_name.focus();
		return false;
	}
	if(myform.E_age.value.length==0){
		alert("员工年龄不能为空！")
		myform.E_age.focus();
		return false;
	}
	if(myform.E_pro.value.length==0){
		alert("员工职务不能为空！")
		myform.E_pro.focus();
		return false;
	}
	if(myform.E_addr.value.length==0){
		alert("员工联系地址不能为空！")
		myform.E_addr.focus();
		return false;
	}
	if(myform.E_phone.value.length==0){
		alert("员工联系电话不能为空！")
		myform.E_phone.focus();
		return false;
	}
}