<%@ page language="java" pageEncoding="utf-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>资产借出登记</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">

		<link rel="stylesheet" type="text/css" href="/gdzc/css/style.css">
		<link rel="stylesheet" type="text/css" href="/gdzc/css/style2.css">
        
		<SCRIPT language=JavaScript src="/gdzc/js/pinbi.js"></SCRIPT>
</head>

	<script language="javascript" type="text/javascript">
	function checkzcinfo(myform){
		
		if(myform.zc_id.value.length==0){
			alert("请输入要借用资产的编号！");
			myform.zc_id.focus();
			return;
		}
		if(myform.em_id.value.length==0){
			alert("请输入员工编号！");
			myform.c_id.focus();
			return ;
		}
		myform.submit();
	}
  </script>
	<body>
		<table width="100%" border="0" align="center">
	  <tr>
				<td height="180">
				<table width="98%" border="0" align="center">
		  <tr>
				<td>
				<img src="/gdzc/images/9.gif" width="36" height="30">
				<span class="word_orange2"><strong>资产借出/归还管理</strong></span>	</td>
			</tr>
			<tr>
				<td>
					<hr align="center" size="1" noshade></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>

			<tr>
				<td>
				<table width="98%" border="0" align="center" bgcolor="#E3F4F7" class="tableBorder">
			<tr>
				<td><form name="myform" method="post" action="lendZC.do">
				<label>
				
					<img src="/gdzc/images/weifu.gif" width="30" height="30"><strong>资产编号：</strong>
<input name="zc_id" type="text" class="logininput" id="zc_id" size="30">
														&nbsp;&nbsp;&nbsp;&nbsp;
					<img src="/gdzc/images/11.gif" width="46" height="33"><strong>员工编号：</strong>
<input name="em_id" type="text" id="em_id" size="30">
						&nbsp;&nbsp;&nbsp;
						<input name="lend" type="button" class="button" id="lend"
							value="借  出" onMouseOver="this.style.color='red'"
							onMouseOut="this.style.color='#1e7977'"
							onClick="return checkzcinfo(myform)">
				</label>
				</form>
				<center>				
				<font color=red>${requestScope['gdzc.status.message'] }</font>
				</center>
				</td>
			</tr>
			<tr>
				<td height="23" class="word_orange">
					<table width="98%" align="center" border="1" cellpadding="0"
							cellspacing="0" bordercolor="#FFFFFF"
									bordercolorlight="#FFFFFF" bordercolordark="#D2E3E6"
										bgcolor="#FFFFFF">
					<tr>
						<td width="13%" height="20" bgcolor="#F9D695">
					  <div align="center"><strong>借用流水号</strong></div></td>
					  <td width="18%" bgcolor="#F9D695">
					  <div align="center"><strong>资产编号</strong></div></td>
					  <td width="14%" bgcolor="#F9D695">
					  <div align="center"><strong>员工编号</strong></div></td>
					  <td width="16%" bgcolor="#F9D695">
					  <div align="center"><strong>借用时间</strong></div></td>
					  <td width="17%" bgcolor="#F9D695">
					  <div align="center"><strong>应还时间</strong></div></td>
					  <td width="10%" bgcolor="#F9D695">
					  <div align="center"><strong>归还时间</strong></div></td>
					  <td width="6%" bgcolor="#F9D695">
					  <div align="center">查看</div></td>
					  <td width="6%" bgcolor="#F9D695">
					  <div align="center">归还</div></td>
					</tr>

				 <c:forEach items="${sessionScope.list}" var="item">
					 <tr align="center" height="25">
             		<td width="12%">${item.inoutNo}&nbsp;</td>
             		<td width="12%">${item.zcInfo.zcId}&nbsp;</td>
             		<td width="12%">${item.comployeeNo}&nbsp;</td>
             		<td width="12%">${item.outTime}&nbsp;</td>
             		<td width="12%">${item.shouldTime}&nbsp;</td>
             		<td width="12%">${item.backTime}&nbsp;</td>
					<td>
						<input name="check" type="submit" class="button"
							id="check" value="查  看" 
							onmouseover="this.style.color='red'"
							onMouseOut="this.style.color='#1e7977'" 
							onclick="window.location='checkInOut.do?zc_id=${item.zcInfo.zcId}&e_id=${item.comployeeNo}'"></td>
					<td>
						<input name="back" type="submit" class="button" id="back"
							value="归  还" onMouseOver="this.style.color='red'" 
							onMouseOut="this.style.color='#1e7977'" 
							onclick="window.location='backZC.do?inout_no=${item.inoutNo}&zc_id=${item.zcInfo.zcId}'"></td>
					</tr>
				</c:forEach>
				</table>
		</td>
		</tr>
		</table>
		<center>
       	<img src="images/advert.gif" alt="">
			每页${pageCount}条
		<img src="images/advert.gif" alt="">
			共${totalCount}条
		<img src="images/advert.gif" alt="">
			当前第 ${pages}页
		<img src="images/advert.gif" alt="">
			共 ${countpage}页
			
		<a href="lendInfos.do?currentPage=1">首页</a>
		<a href="lendInfos.do?currentPage=${pages-1}">上一页</a>
		<a href="lendInfos.do?currentPage=${pages+1}">下一页</a>	
		<a href="lendInfos.do?currentPage=${countpage}">尾页</a>
		</center>
		
		</td>
		</tr>
		</table>
		
		</td>
		  </tr>
		</table>
</body>
</html>
