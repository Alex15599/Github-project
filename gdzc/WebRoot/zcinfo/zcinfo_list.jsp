<%@ page language="java" pageEncoding="utf-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>资产信息详细列表分页显示</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	
	<link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="css/style2.css">
    
    <SCRIPT language=JavaScript src="js/pinbi.js"></SCRIPT>
</head>
  
  <body>
  <table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td height="22" valign="top" class="word_orange"><img src="images/2.gif" width="37" height="27"><span class="word_orange2"><strong>资产详细信息列表</strong></span></td>
    </tr>
    <tr>
      <td height="22" valign="top" class="word_orange"><hr align="center" size="1" noshade></td>
    </tr>
    <tr>
      <td height="22" valign="top" class="word_orange"><table width="100%" border="0">
        <tr>
          <td width="6%">&nbsp;</td>
          <td width="22%">&nbsp;</td>
          <td width="7%">&nbsp;</td>
          <td width="5%">&nbsp;</td>
          <td width="8%">&nbsp;</td>
          <td width="42%">&nbsp;</td>
          <td width="10%"><label>
          <img src="images/jiaodian_biao.gif" width="21" height="17">
          
          <input name="add" type="button" class="button" id="add" value="添加资产"
            onmouseover="this.style.color='red'" onMouseOut="this.style.color='#1e7977'" 
            onclick="window.location='/gdzc/zcinfo/zcinfo_add.jsp'">
            
          </label>
          </td>
        </tr>
        <tr>
          <td colspan="7"><hr align="center" size="1" noshade></td>
        </tr>
      </table></td>
    </tr>
    <tr>
      <td align="center" valign="top"><table width="100%"  border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td></td>
            </tr>
          </table>
        <table width="98%"  border="1" cellpadding="0" cellspacing="0" bordercolor="#999999" borderColorDark="#ffffff">
        <tr align="center">
              <td width="12%" height="20" bgcolor="#ECCD7D"><strong>资产编号</strong></td>
          <td width="10%" bgcolor="#ECCD7D"><strong>资产型号</strong></td>
          <td width="13%" bgcolor="#ECCD7D"><strong>资产名称</strong></td>
          <td width="5%" bgcolor="#ECCD7D"><strong>单价</strong></td>
          <td width="11%" bgcolor="#ECCD7D"><strong>生产厂商 </strong></td>
          <td width="9%" bgcolor="#ECCD7D"><strong>生产日期</strong></td>
          <td width="9%" bgcolor="#ECCD7D"><strong>入库时间</strong></td>
          <td width="6%" bgcolor="#ECCD7D"><strong>购买人</strong></td>
          <td width="7%" bgcolor="#ECCD7D"><strong>资产类型</strong></td>
          <td width="6%" bgcolor="#ECCD7D"><strong>状态</strong></td>
          <td colspan="3"><strong>操作</strong></td>
          </tr>

          <c:forEach items="${requestScope.list}" var="item">
           <tr align="center" height="25">
             <td width="12%">${item.zcId}&nbsp;</td>
             <td width="10%">${item.zcNo}&nbsp;</td>
             <td width="13%">${item.zcName}&nbsp;</td>
             <td width="5%">${item.zcPrice}&nbsp;</td>
             <td width="11%">${item.zcFactory}&nbsp;</td>
             <td width="9%" >${item.zcProduceTime}&nbsp;</td>
             <td width="9%">${item.zcBuyTime}&nbsp;</td>
             <td width="6%">${item.zcBuyer}&nbsp;</td>
             <td width="7%">${item.zcType}&nbsp;</td>
             <td width="6%">${item.zcStatus}&nbsp;</td>
     

               <td width="4%">
           	   <input name="edit" type="button" class="button" id="edit" value="修 改"
               onmouseover="this.style.color='red'" onMouseOut="this.style.color='#1e7977'" 
           	   onclick="window.location='updateAssets.do?zc_id=${item.zcId}'">
           	   <td width="4%">
           	   
   	      	   <input name="delete" type="button" class="button" id="delete" value="删 除"
               onmouseover="this.style.color='red'" onMouseOut="this.style.color='#1e7977'" 
           	   onclick="if(confirm('您确定要删除编号为${item.zcId}的资产吗?')) 
           	   window.location='deleteAssets.do?zc_id=${item.zcId}'"></td></tr>
  </c:forEach>
      </table>

       	<img src="images/advert.gif" alt="">
			每页${pageCount}条
		<img src="images/advert.gif" alt="">
			共${totalCount}条
		<img src="images/advert.gif" alt="">
			当前第 ${pages}页
		<img src="images/advert.gif" alt="">
			共 ${countpage}页
			
		<a href="zcgl.do?currentPage=1">首页</a>
		<a href="zcgl.do?currentPage=${pages-1}">上一页</a>
		<a href="zcgl.do?currentPage=${pages+1}">下一页</a>	
		<a href="zcgl.do?currentPage=${countpage}">尾页</a>

      </td>
    </tr>
  </table>
  <br>
  </body>
</html>
