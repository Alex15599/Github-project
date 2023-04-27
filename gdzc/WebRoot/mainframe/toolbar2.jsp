<%@ page language="java" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	
	<link type="text/css" href="../css/toolbar_style.css" rel="stylesheet">
	<SCRIPT language=JavaScript src="../js/pinbi.js"></SCRIPT>
  </head>
	
	<body>
	<table width="100%" border="0" class="tableborder">
      <tr>
        <td><table width="98%" border="0" align="center" class="bgcontain" id="menu">
          <tr>
            <td width="5%"><b><font color=blue  face="Arial, Helvetica, sans-serif" size="-1">您好：${sessionScope.username }</font></b></td>
               			
            <td width="5%"><a href="../zcgl.do" target="main">资产管理</a></td>
            
            <td width="5%"><a href="/gdzc/zc_check/checkzc.jsp" target="main">资产查询</a></td>
            
            <td width="5%"><a href="../lendInfos.do" target="main" target="main">借还管理</a></td>
            
            <td width="5%"><a href="/gdzc/zc_inout/zcInOutCheck.jsp" target="main">借还查询</a></td>
            
            <td width="5%"><a href="../assetPerAction.do"  target="main">维修管理</a></td>
            
            <td width="5%"><a href="/gdzc/zc_wx/checkZcwxInfo.jsp" target="main">维修查询</a></td>
            
            <td width="5%"><a href="/gdzc/employeeAction.do" target="main">员工管理</a></td>
            
            <td width="5%"><a href="../printStoreIn.do" target="main">打印报表</a></td>
            
			<c:if test="${sessionScope.competence == '管理员' }">
            <td width="5%"><a href="/gdzc/userManaAction.do"target="main">用户管理</a></td>
            </c:if>
            
            <td width="5%"><a href="/gdzc/user_info/updatepwd.jsp" target="main">修改密码</a></td>

          </tr>
          
        </table></td>
      </tr>
    </table>
</body>
    </html>
