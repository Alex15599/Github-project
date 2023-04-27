<%@ page language="java" pageEncoding="utf-8"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>资产借出归还信息浏览/查询</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	
	<link rel="stylesheet" type="text/css" href="/gdzc/css/style.css">
    <link rel="stylesheet" type="text/css" href="/gdzc/css/style2.css">
	
	<SCRIPT language=JavaScript src="/gdzc/js/pinbi.js"></SCRIPT>
</head>
  
  
	<script language="javascript" type="text/javascript">
	function checkzcinfo(myform){
		
		if(myform.zc_id.value.length==0 && myform.comployeeNo.value.length==0){
			alert("查询条件至少填一个！");
			return false;
		}
	}
  </script>
  
  <body>
  <table width="100%" border="0" align="center">
    <tr>
      <td><table width="98%" border="0" align="center">
        <tr>
          <td><img src="/gdzc/images/weifu.gif" width="30" height="30"><span class="word_orange2"><strong>资产借出归还信息浏览/查询</strong></span></td>
        </tr>
        <tr>
          <td><hr align="center" size="1" noshade></td>
        </tr>
        <tr>
          <td><form name="myform" method="post" action="/gdzc/zcInOut.do">
            <table width="98%" border="0" align="center" background="/gdzc/images/bg.gif" class="tableBorder">
              <tr>
                <td colspan="4"><img src="/gdzc/images/point.gif" width="17" height="16"><span class="word_orange"><strong>填写查询条件</strong></span></td>
              </tr>
              <tr>
                <td width="12%" height="24"><img src="/gdzc/images/point.gif" width="17" height="16">资产编号：</td>
                <td width="32%"><label>
                 <input name="zc_id" type="text" class="logininput" id="zc_id" size="30">
                </label></td>
                <td width="12%"><img src="/gdzc/images/point.gif" width="17" height="16">员工编号：</td>
                <td width="43%"><label>
                <input name="comployeeNo" type="text" class="logininput" id="comployeeNo" size="30">
                </label><font color=red>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                ${requestScope['gdzc.zcinout.error'] }</font></td>
              </tr>
              
              <tr>
                <td height="30">&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td><label></label>
                  <table width="98%" border="0">
                    <tr>
                      <td width="47%"></td>
                      <td width="17%">
                      <input name="select" type="submit" class="button" id="select"
							value="查  询" onMouseOver="this.style.color='red'"
							onMouseOut="this.style.color='#1e7977'"
							onClick="return checkzcinfo(myform)">
                      
                      </td>
                      <td width="7%">&nbsp;</td>
                    </tr>
                  </table></td>
              </tr>
            </table>
          </form></td>
        </tr>
        <tr>
          <td>&nbsp;</td>
        </tr>
        <tr>
          <td>
          <table width="100%"  border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" 
        	bordercolorlight="#FFFFFF" bordercolordark="#D2E3E6" class="tableBorder">
        	<tr align="center" bgcolor="#e3F4F7">
              <td width="12%" bgcolor="#F2E3AE"><strong>借用流水号</strong></td>
              <td width="12%" bgcolor="#F2E3AE"><strong>资产编号</strong></td>
              <td width="5%" bgcolor="#F2E3AE"><strong>员工编号</strong></td>
              <td width="12%" bgcolor="#F2E3AE"><strong>借用时间 </strong></td>
              <td width="11%" bgcolor="#F2E3AE"><strong>应还时间</strong></td>
              <td width="10%" bgcolor="#F2E3AE"><strong>归还时间</strong></td>
              </tr>
              
           <c:forEach items="${requestScope.list}" var="item"> 
           	<tr align="center" height="25">
             		<td width="12%">${item.inoutNo}&nbsp;</td>
             		<td width="12%">${item.zcInfo.zcId}&nbsp;</td>
             		<td width="12%">${item.comployeeNo}&nbsp;</td>
             		<td width="12%">${item.shouldTime}&nbsp;</td>
             		<td width="12%">${item.outTime}&nbsp;</td>
             		<td width="12%">${item.backTime}&nbsp;</td>
            </c:forEach>
            </table></td>
     
        </tr>
      </table></td>
    </tr>
  </table>
    
</body>
</html>
