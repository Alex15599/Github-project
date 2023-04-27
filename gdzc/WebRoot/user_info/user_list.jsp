<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>用户信息管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<link rel="stylesheet" type="text/css" href="/gdzc/css/style.css">
	<link rel="stylesheet" type="text/css" href="/gdzc/css/style2.css">
	<SCRIPT language=JavaScript src="/gdzc/js/pinbi.js"></SCRIPT>
</head>
  
  <body>
  <table width="80%" border="0" align="center">
    <tr>
      <td><table width="98%" border="0" align="center" class="tableBorder">
        <tr>
          <td><img src="/gdzc/images/11.gif" width="46" height="33"><span class="word_orange2"><strong>系统用户信息</strong></span></td>
        </tr>
        <tr>
          <td><hr align="center" size="1" noshade></td>
        </tr>
        <tr>
          <td><table width="100%" border="0">
            <tr>
              <td width="7%">&nbsp;</td>
              <td width="7%">&nbsp;</td>
              <td width="17%">&nbsp;</td>
              <td width="6%">&nbsp;</td>
              <td width="14%">&nbsp;</td>
              <td width="21%">&nbsp;</td>
              <td width="17%">&nbsp;</td>
              <td width="11%">
              <img src="/gdzc/images/jiaodian_biao.gif" width="21" height="17">
              <input name="addUser" type="button" class="button" id="addUser" value="添加用户"
              onclick="window.location='/gdzc/user_info/user_add.jsp'"></td>
            </tr>
          </table>            <label></label></td>
        </tr>
        <tr>
          <td><table width="98%" align="center" border="1" cellpadding="0"
			cellspacing="0" bordercolor="#FFFFFF"
			bordercolorlight="#FFFFFF" bordercolordark="#D2E3E6"
			bgcolor="#FFFFFF">
            <tr bgcolor="#F9D695"  align="center" height="20">
              <td width="28%"><strong>用户名</strong></td>
              <td width="29%"><strong>员工编号</strong></td>
              <td width="17%"><strong>权限</strong></td>
              <td colspan="2"><strong>操作</strong><strong></strong></td>
              </tr>
          <c:forEach items="${requestScope.list}" var="item">
            <tr align="center" height="25">
              <td>${item.userName}</td>
              <td>${item.comployee.comployeeNo}</td>
              <td>${item.competence}</td>
               <td width="13%">
           	   <input name="edit" type="button" class="button" id="edit" value="修改权限"
               onmouseover="this.style.color='red'" onMouseOut="this.style.color='#1e7977'" 
           	   onclick="window.location='findUserbyname.do?username=${item.userName}'"></td>
           	   <td width="13%">
           	   <input name="delete" type="button" class="button" id="delete" value="删 除"
               onmouseover="this.style.color='red'" onMouseOut="this.style.color='#1e7977'" 
           	   onclick="if(confirm('您确定要删除编号为${item.comployee.comployeeNo}的用户吗?')) 
           	   window.location='deleteUserAction.do?userName=${item.userName}'"></td>
            </tr>
		</c:forEach>
          </table></td>
        </tr>
        <tr>
          <td>&nbsp;</td>
        </tr>
      </table></td>
    </tr>
  </table>

</body>
</html>
