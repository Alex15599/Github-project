function showmenu(c){
 if (document.all("Menu" +c +"").style.display=="")
   document.all("Menu"+c+"").style.display="none";
 else
   document.all("Menu"+c+"").style.display="";
}

//处理全选的
 function chkall(input1,input2)
{
    var objForm = document.forms[input1];
    var objLen = objForm.length;
    for (var iCount = 0; iCount < objLen; iCount++)
    {
        if (input2.checked == true)
        {
            if (objForm.elements[iCount].type == "checkbox")
            {
                objForm.elements[iCount].checked = true;
            }
        }
        else
        {
            if (objForm.elements[iCount].type == "checkbox")
            {
                objForm.elements[iCount].checked = false;
            }
        }
    }
}

// 处理全选的
function checkall(id) {
	var chk = $(":checkbox");
	if ($("#" + id).attr("checked") == true) {
		chk.each(function() {
					$(this).attr("checked", "checked");
				});
	} else {
		chk.each(function() {
					$(this).attr("checked", "");
				});
	}
}