<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>修改用户信息</title>
<link rel="stylesheet" type="text/css" href="/gdzc/css/style.css">
<link rel="stylesheet" type="text/css" href="/gdzc/css/style2.css">
<SCRIPT language=JavaScript src="/gdzc/js/pinbi.js"></SCRIPT>
<style type="text/css">
<!--
.STYLE1 {
	font-size: 11pt;
	font-weight: bold;
}
-->
</style>
</head>

<body bgcolor="#FFFFFF" text="#000000"  >
<form action="updateUser.do" method="post">
<table width="90%" border="0" cellspacing="0" cellpadding="0" align="center" >
  <tr >
    <td valign="bottom" height="50">
      <div align="left">
        <span class="title">
          <img src="/gdzc/images/9.gif" width="36" height="30"></span><span class="word_orange STYLE1">修改用户信息        </span> </div>
    </td>
  </tr>
</table>
<HR noShade SIZE=1 width="90%">
<br>

<table width="50%" border="0" align="center" cellpadding="0" cellspacing="1" class="tableBorder">

<tr bgcolor="#FFFFFF">
		<td width="46%" height="40" align="right" background="/gdzc/images/bg.gif"><img src="/gdzc/images/point.gif" width="17" height="16">员工编号：</td>
	  <td width="54%" background="/gdzc/images/bg.gif" >
	  <input type="text"    name="comployeeNo" readonly   value="${requestScope.compno}"size="30"/></td>
	</tr>

	<tr bgcolor="#FFFFFF">
		<td height="38" align="right" background="/gdzc/images/bg.gif"><img src="/gdzc/images/point.gif" width="17" height="16">用&nbsp; 户&nbsp; 名：</td>
	  <td background="/gdzc/images/bg.gif">
	  <input type="text"  name="userName"size="30" value="${requestScope.userName}" readonly/></td>
	</tr>

	<tr bgcolor="#FFFFFF">
		<td height="39" align="right" background="/gdzc/images/bg.gif"><img src="/gdzc/images/point.gif" width="17" height="16">权&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; 限：</td>
<td align="left" background="/gdzc/images/bg.gif">
	  <SELECT NAME="competence" class="logininput" >
		    <option value="管理员"> 管理员</option>
				<option value="操作员">操作员</option>
			</SELECT>		</td>
	</tr>

	<tr bgcolor="#FFFFFF" >
	  <td height="31" colspan="2" align="center" background="/gdzc/images/bg.gif">&nbsp;</td>
    </tr>
	<tr bgcolor="#FFFFFF" >
		<td colspan="2" align="center" background="/gdzc/images/bg.gif">
	    <input name="submit"  type="submit" class="button" id="submit" onClick="return checkNoNull();"onmouseover="this.style.color='red'" onMouseOut="this.style.color='#1e7977'"  value=" 确   定 ">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input name="back"  type="button" class="button" id="back" onClick=" window.history.back();" onMouseOver="this.style.color='red'"onmouseout="this.style.color='#1e7977'"  value=" 返   回 ">		</td>
	</tr>
</table>
</form>
</body>

</html>
