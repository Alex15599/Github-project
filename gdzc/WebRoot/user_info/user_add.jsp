<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" type="text/css">
<title>添加系统用户</title>
<link rel="stylesheet" type="text/css" href="/gdzc/css/style.css">
<link rel="stylesheet" type="text/css" href="/gdzc/css/style2.css">

<SCRIPT language=JavaScript src="/gdzc/js/check_addUser.js"></SCRIPT>

<SCRIPT language=JavaScript src="/gdzc/js/pinbi.js"></SCRIPT>

<style type="text/css">
<!--
.STYLE1 {
	font-size: 10pt;
	font-weight: bold;
}
.STYLE5 {font-size: 11pt}
-->
</style>
</head>

<body bgcolor="#FFFFFF" text="#000000">

<html:form method="post" action="addUserAction">

<table width="90%" border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td valign="bottom" height="50"><img src="/gdzc/images/weifu.gif" width="30" height="30"><span class="word_orange STYLE1"><span class="STYLE5">添加系统用户</span></span></td>
  </tr>
</table>

<table width="90%" border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td>
      <HR noShade SIZE=1> <center ></center>
    </td>
  </tr>
</table>
<br>

<table width="50%" border="0" align="center" cellpadding="0" cellspacing="1" class="tableBorder">
    <tr bgcolor="#FFFFFF">
  
    <td width="225" height="42" align="right" background="/gdzc/images/bg.gif"><img src="/gdzc/images/point.gif" width="17" height="16">员工编号：</td>
    <td width="41" align="right" background="/gdzc/images/bg.gif">&nbsp;</td>
    <td width="344" background="/gdzc/images/bg.gif">
      <html:text  property="comployeeNo" size="30"/>  <font color="red"> <html:errors property="comployeeNo"/> ${requestScope.error}</font>  </td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td height="38" align="right" background="/gdzc/images/bg.gif"><img src="/gdzc/images/point.gif" width="17" height="16">用&nbsp; 户&nbsp; 名：</td>
    <td height="38" align="right" background="/gdzc/images/bg.gif">&nbsp;</td>
    <td width="344" background="/gdzc/images/bg.gif">
     <html:text property="userName" size="20"/>  <font color="red"> <html:errors property="userName"/></font> </td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td height="38" align="right" background="/gdzc/images/bg.gif"><img src="/gdzc/images/point.gif" width="17" height="16">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 码：</td>
    <td height="38" align="right" background="/gdzc/images/bg.gif">&nbsp;</td>
    <td background="/gdzc/images/bg.gif">
      <html:password property="password"  size="30"/> <font color="red"> <html:errors property="password"/></font>    </td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td height="38" align="right" background="/gdzc/images/bg.gif"><img src="/gdzc/images/point.gif" width="17" height="16">确认密码：</td>
    <td height="38" align="right" background="/gdzc/images/bg.gif">&nbsp;</td>
    <td background="/gdzc/images/bg.gif">
      <html:password  property="rePassword" size="30"/> <font color="red"> <html:errors property="rePassword"/></font>    </td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td height="39" align="right" background="/gdzc/images/bg.gif"><img src="/gdzc/images/point.gif" width="17" height="16">权&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 限：</td>
    <td height="39" align="right" background="/gdzc/images/bg.gif">&nbsp;</td>
    <td background="/gdzc/images/bg.gif">
      <div class="box2">
    <div class="box3">
		<html:select property="competence" >
  		<html:option  value="管理员">管理员</html:option>   
  		<html:option  value="操作员">操作员</html:option>   
    </html:select>
        </div>
      </div>    </td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td height="26" align="right" background="/gdzc/images/bg.gif">&nbsp;</td>
    <td height="26" align="right" background="/gdzc/images/bg.gif">&nbsp;</td>
    <td background="/gdzc/images/bg.gif">&nbsp;</td>
  </tr>
 	
  <tr bgcolor="#FFFFFF">
    <td colspan="3" align="center" background="/gdzc/images/bg.gif">
      <input type="submit" class="button" value=" 保 存 " 
      onMouseOver="this.style.color='red'" onMouseOut="this.style.color='#1e7977'">
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
      
      <input type="button" class="button" value=" 返 回 " 
      onMouseOver="this.style.color='red'" 
      onClick=" window.history.back();" onMouseOut="this.style.color='#1e7977'">  </td>
  </tr>
</table>
</html:form>
</body>
</html>
