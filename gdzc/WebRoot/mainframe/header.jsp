<%@ page language="java" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>header</title>
	<LINK href="../css/header_style.css" type=text/css rel=stylesheet>
	<SCRIPT language=JavaScript src="../js/pinbi.js"></SCRIPT>
	<META http-equiv=Content-Type content="text/html; charset=utf-8">
	<META content="MSHTML 6.00.2900.3354" name=GENERATOR>
  </head>
  
  <SCRIPT>
	function showdate() {
		var today=new Date();  
		var theyear=today.getYear(); 
		var themonth=today.getMonth()+1;
		var thedate=today.getDate(); 
		var theday=today.getDay();

		var dName=new Array("&ETH;&Ccedil;&AElig;&Uacute;&Igrave;ì",
		"&ETH;&Ccedil;&AElig;&Uacute;&Ograve;&raquo;",
		"&ETH;&Ccedil;&AElig;&Uacute;&para;&thorn;",
		"&ETH;&Ccedil;&AElig;&Uacute;&Egrave;&yacute;",
		"&ETH;&Ccedil;&AElig;&Uacute;&Euml;&Auml;",
		"&ETH;&Ccedil;&AElig;&Uacute;&Icirc;&aring;",
		"&ETH;&Ccedil;&AElig;&Uacute;&Aacute;ù");  
		for (i=0;i<7;i++){ 
			if (theday==i){ 
				theday=dName[i];break;
			}
		}
		document.write (theyear+"年" + themonth+"月" + thedate+"日"); 
	}

	function showweek(){
		var deat1=new Date();
		switch(deat1.getDay()){
			case 0:var thisDay="日";
			  break;
			case 1:var thisDay="一";
			  break;
			case 2:var thisDay="二";
			  break;
			case 3:var thisDay="三";
			  break;
			case 4:var thisDay="四";
			  break;
			case 5:var thisDay="五";
			  break;
			case 6:var thisDay="六";
			  break;
		}
		document.write(" 星期"+thisDay);
	}
	
	</SCRIPT>
	
    <BODY bgColor=#669999>
	<FORM name=form1>
	<TABLE width="100%" height=76 border=0 cellPadding=0 cellSpacing=0 background=../images/0000.gif>
	  <TBODY>
	  <TR nowrap>
	    <TD noWrap align=middle width="68%" rowSpan=2><div align="left"><img src="../images/top_bg.gif" width="778" height="80"></div></TD>
	    <TD height=30 colspan="2" vAlign=bottom noWrap>
	      <P align=right>
	      <FONT face=宋体 color=#006766>
	      <SCRIPT>showdate()</SCRIPT>
	      &nbsp;
	      <SCRIPT>showweek()</SCRIPT>
	       &nbsp;&nbsp;</FONT></P>	       </TD>
	   </TR>
	  <TR nowrap>
	 
	    <TD width="21%" height=46 noWrap></TD>
	    <TD width="4%" noWrap><div align="right"><A onclick='top.location.href="../login/login.jsp";' href="#"><FONT color=#006766>注销用户</FONT></A> <FONT color=#006766>|</FONT>&nbsp;</div></TD>
	     <TD width="7%" height=46 noWrap>
	     <p>
	      <A  onclick='if(confirm("确定退出资产管理系统吗?"))top.location.href="../login/login.jsp";' href="#"><FONT color=#006766>退出系统</FONT></A>
         <FONT color=#006766>|</FONT>&nbsp;&nbsp;&nbsp;</P>	     </TD>
	  </TR>
	  </TBODY>
	  </TABLE>
    </FORM>
	  </BODY>
</html>
