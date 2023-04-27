<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>用户修改密码</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	
	<link rel="stylesheet" type="text/css" href="/gdzc/css/style.css">
	<link rel="stylesheet" type="text/css" href="/gdzc/css/style2.css">
	<script language="javascript" src="/gdzc/js/check_updatePwd.js"></script>
	<SCRIPT language=JavaScript src="/gdzc/js/pinbi.js"></SCRIPT>
    <style type="text/css">
<!--
.STYLE1 {font-size: 11pt}
-->
    </style>
</head>
  
  <body>
  <table width="60%" border="0" align="center">
    <tr>
      <td><table width="98%" border="0" align="center">
        <tr>
          <td><img src="/gdzc/images/weifu.gif" width="30" height="30"><span class="word_orange STYLE1"><strong>系统用户修改密码</strong></span></td>
        </tr>
        <tr>
          <td><hr align="center" size="1" noshade></td>
        </tr>
        <tr>
          <td>&nbsp;</td>
        </tr>
        <tr>
          <td>
    
          <html:form  method="post" action="updatepwd">
            <table width="98%" border="0" align="center" background="/gdzc/images/bg.gif" class="tableBorder">
              <tr>
                <td width="19%">&nbsp;</td>
                <td width="23%">&nbsp;</td>
                <td width="39%">&nbsp;</td>
                <td width="9%">&nbsp;</td>
                <td width="10%">&nbsp;</td>
              </tr>
              <tr>
                <td height="30" >&nbsp;</td>
                <td><img src="/gdzc/images/point.gif" width="17" height="16">用户名：</td>
                <td><label>
                  <html:text property="username" size="25" value="${sessionScope.username}" readonly="true"/>
                </label></td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
              <tr >
                <td height="29">&nbsp;</td>
                <td><img src="/gdzc/images/point.gif" width="17" height="16">旧密码：</td>
                <td>
                <label>
                  <html:password property="oldpwd" size="25"/>
                  <font color="red"> <html:errors property="oldpwd"/> ${requestScope.error }</font>
                </label></td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td height="30">&nbsp;</td>
                <td><img src="/gdzc/images/point.gif" width="17" height="16">新密码：</td>
                <td><label>
                  <html:password property="newpwd"  size="25"/><font color="red"> <html:errors property="newpwd"/></font>
                </label></td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td height="31">&nbsp;</td>
                <td><img src="/gdzc/images/point.gif" width="17" height="16">确认密码：</td>
                <td><label>
                  <html:password property="renewpwd" size="25"/><font color="red"> <html:errors property="renewpwd"/></font>
                </label></td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td>&nbsp;</td>
                <td colspan="2"><table width="100%" border="0">
                    <tr>
                      <td width="26%">&nbsp;</td>
                      <td width="20%"><label>
                        <input name="submit" type="submit" class="button" id="submit" 
                        onMouseOver="this.style.color='red'" onMouseOut="this.style.color='#1e7977'"
                        value="提  交" onClick="return check_update(form1);">
                      </label></td>
                      <td width="11%">&nbsp;</td>
                      <td width="43%"><label>
                        <input name="reset" type="reset" class="button" id="reset" value="重  置"
                        onMouseOver="this.style.color='red'" onMouseOut="this.style.color='#1e7977'">
                      </label></td>
                    </tr>
                </table></td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
            </table>
                  </html:form>    
                       </td>
        </tr>
        <tr>
          <td>&nbsp;</td>
        </tr>
      </table></td>
    </tr>
  </table>
</body>
</html>
