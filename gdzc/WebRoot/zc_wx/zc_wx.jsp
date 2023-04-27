<%@ page language="java"  import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>资产维修</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href=" css/style.css">
	<link rel="stylesheet" type="text/css" href=" css/style2.css">
    
    <script language="JavaScript" src=" js/zcwx_check.js"></script>
	
	<SCRIPT language="JavaScript" src=" js/pinbi.js"></SCRIPT>
    
    <script language="JavaScript" src=" js/setday.js"></script>
    
</head>
  
  <body>
  
  
  <table width="100%" border="0" align="center">
    <tr>
      <td><table width="98%" border="0" align="center">
        <tr>
          <td><img src=" images/weifu.gif" width="30" height="30"><span class="word_orange2"><strong>资产维修操作</strong></span></td>
        </tr>
        <tr>
          <td><hr align="center" size="1" noshade></td>
        </tr>
        
        <tr>
          <td height="25">
          <html:form method="post" action="addPerAssetAction">
            <table width="100%" border="0" bgcolor="#E3F4F7" class="tableBorder">
              <tr>
                <td><img src=" images/home.gif" width="15" height="15">资产编号：</td>
                <td height="30"><label>
                  <html:text  property="zc_id"  size="25" maxlength="30"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  <font color=red><html:errors property="zc_id"/>${requestScope.errorzcid}</font>
                  </label>
                    <label></label></td>
                <td><img src=" images/Favorites.gif" width="16" height="16">送修时间：</td>
                <td><label>
                  <html:text  property="send_time" onclick="setday(this)" onfocus="setday(this)"  
                  readonly="true"  size="25" maxlength="30"/>
                  <font color=red><html:errors property="send_time"/> </font>
                </label></td>
              </tr>
              <tr>
                <td width="12%"><img src=" images/home.gif" width="15" height="15">送修负责人：</td>
                <td width="22%" height="31"><label>
                  <html:text property="sender" size="25" maxlength="30"/> <font color=red><html:errors property="sender"/>${requestScope.erroremp} </font>
                </label></td>
                <td width="13%"><img src=" images/Favorites.gif" width="16" height="16">经手人：</td>
                <td width="53%"><label>
                  <html:text property="login_user" value="${sessionScope.username}" readonly="true"  size="25" maxlength="30"  />
                </label></td>
              </tr>
              <tr>
                <td><img src=" images/home.gif" width="15" height="15">故障原因：</td>
                <td height="35" colspan="3"><label>
                  <html:textarea property="reason" cols="50" rows="6"></html:textarea> <font color=red><html:errors property="reason"/> </font>
                </label></td>
              </tr>
              <tr>
                <td height="3" colspan="4"><hr align="center" size="1" noshade></td>
              </tr>
              <tr>
                <td height="37" colspan="4"><table width="98%" border="0" align="center">
                    <tr>
                      <td width="20%" height="31">&nbsp;</td>
                      <td width="18%">&nbsp;</td>
                      <td width="12%"><label></label></td>
                      <td width="7%">&nbsp;</td>
                      <td width="43%"><label></label>
                          <table width="100%" border="0">
                         
                            <tr>
                              <td width="34%">&nbsp;</td>
                              <td width="14%">
                              <input name="submit" type="submit"  class="button" id="submit" value="确定送修" 
                                onmouseover="this.style.color='red'" onMouseOut="this.style.color='#1e7977'"  
                              	onclick="return check_zcwx(form1)"></td>
                              <td width="7%">&nbsp;</td>
                            </tr>
                        </table></td>
                    </tr>
                </table></td>
              </tr>
            </table>
                    </html:form>     
          </td>
        </tr>
        
        <tr>
          <td height="23" class="word_orange"><img src="images/msn_20x20.gif" width="20" height="20"><strong>资产送修详细信息</strong></td>
        </tr>
        <tr>
          <td height="23" class="word_orange">
          <table width="100%"  border="1" cellpadding="0" cellspacing="0" bordercolor="#CCCCCC" 
        	bordercolorlight="#FFFFFF" bordercolordark="#D2E3E6" class="tableBorder">
            <tr bgcolor="#F9D695">
              <td width="10%" height="24"><div align="center"><strong>维修流水号</strong></div></td>
              <td width="13%"><div align="center"><strong>资产编号</strong></div></td> 
              <td width="11%"><div align="center"><strong>送修时间</strong></div></td>
              <td width="10%" bgcolor="#F9D695"><div align="center"><strong>送修人</strong></div></td>
              <td width="11%"><div align="center"><strong>经手人</strong></div></td>
              <td width="28%"><div align="center"><strong>故障原因</strong></div></td>
              <td colspan="3"><div align="center"><strong>操作</strong></div></td>
            </tr>
            <c:forEach items="${requestScope.list}" var="item">
           <tr align="center" height="25">
             <td width="12%">${item.repairNo}</td>
             <td width="10%">${item.zcInfo.zcId}</td>
             <td width="13%">${item.sendTime}</td>
             <td width="5%">${item.sender}</td>
             <td width="11%">${item.loginUser}</td>
             <td width="9%">${item.reason}</td>
             
              <td >
              <input name="check" type="button" class="button" id="check" value="修改"
               onmouseover="this.style.color='red'" onMouseOut="this.style.color='#1e7977'" 
                onclick="window.location='findPerAssetAction.do?repair_no=${item.repairNo}'"> </td>

             
             <td>
              <input name="check" type="button" class="button" id="check" value="删除"
               onmouseover="this.style.color='red'" onMouseOut="this.style.color='#1e7977'" 
           	   onclick="window.location='deletePerAssetAction.do?repair_no=${item.repairNo}'"> </td>
            </tr> 
              </c:forEach>

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
			
		<a href="assetPerAction.do?currentPage=1">首页</a>
		<a href="assetPerAction.do?currentPage=${pages-1}">上一页</a>
		<a href="assetPerAction.do?currentPage=${pages+1}">下一页</a>	
		<a href="assetPerAction.do?currentPage=${countpage}">尾页</a>
		</center>

           </td>
        </tr>
        <tr  bgcolor=""#E3F4F7"">
          <td height="20">&nbsp;</td>
        </tr>
        <tr><td height="2"></td></tr>
      </table></td>
    </tr>
  </table>
</body>
</html>
