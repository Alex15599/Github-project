<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>资产详细信息修改</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="/gdzc/css/style.css">
    <link rel="stylesheet" type="text/css" href="/gdzc/css/style2.css">
    
    <SCRIPT language="JavaScript" src="js/check_editZcInfo.js"></SCRIPT>
	
	<SCRIPT language=JavaScript src="js/pinbi.js"></SCRIPT>
    
  <script language="JavaScript" src="js/setday.js"></script>
    <style type="text/css">
<!--
.STYLE5 {
	color: #FF0000;
	font-size: 12pt;
}
.STYLE6 {color: #FF0000}
-->
    </style>
</head>
  
  <body>
  <table width="70%" border="0" align="center">
    <tr>
      <td><table width="98%" border="0" align="center">
        <tr>
          <td><img src="images/4.gif" width="39" height="34"><span class="word_orange2"><strong>资产详细信息修改</strong></span></td>
        </tr>
        <tr>
          <td><hr align="center" size="1" noshade></td>
        </tr>
        <tr>
          <td>&nbsp;</td>
        </tr>
        <tr>
          <td><html:form method="post" action="save">
            <table width="98%" border="0" align="center" background="images/wdmap.gif" class="tableBorder">
              <tr>
                <td width="16%" height="39"><img src="images/flash-arrow2.gif" width="7" height="7">资产编号：</td>
                <td width="33%"><label>
                   <html:text property="zc_id" styleClass="logininput" size="30" value="${sessionScope.zcinfo.zcId}" readonly="true"></html:text>
                   <font color=red><html:errors property="zc_id"/></font>
                 </label></td>
                <td width="16%"><img src="images/flash-arrow2.gif" width="7" height="7">资产型号：</td>
                <td width="35%"><label>
                <html:text property="zc_no" styleClass="logininput" size="30" value="${sessionScope.zcinfo.zcNo}"></html:text>
                <font color=red><html:errors property="zc_no"/></font>
                </label></td>
              </tr>
              <tr>
                <td height="39"><img src="images/flash-arrow2.gif" width="7" height="7">生产日期：</td>
                <td><label>
              <html:text property="zc_produceTime" onclick="setday(this)" onfocus="setday(this)"  size="25" maxlength="30" value="${sessionScope.zcinfo.zcProduceTime}"></html:text>  
             <font color=red><html:errors property="zc_produceTime"/></font>
              </label></td>
                <td><img src="images/flash-arrow2.gif" width="7" height="7">入库时间：</td>
                <td><label>
                 <html:text  property="zc_buyTime" onclick="setday(this)" onfocus="setday(this)" size="25" maxlength="30" value="${sessionScope.zcinfo.zcBuyTime}"></html:text>
                 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;      
                <font color=red><html:errors property="zc_buyTime"/>${requestScope['gdzc.update.error']}</font>
                </label></td>
              </tr>
              <tr>
                <td height="34"><img src="images/flash-arrow2.gif" width="7" height="7">资产名称：</td>
                <td><label>
                   <html:text property="zc_name" styleClass="logininput" size="30" value="${sessionScope.zcinfo.zcName}"></html:text> 
                 <font color=red><html:errors property="zc_name"/></font>
                 </label></td>
                <td><img src="images/flash-arrow2.gif" width="7" height="7">购买人：</td>
                <td><label>
                  <html:text property="zc_buyer" styleClass="logininput" size="30" value="${sessionScope.zcinfo.zcBuyer}"></html:text> 
                 <font color=red><html:errors property="zc_buyer"/></font>
                 </label></td>
              </tr>
              <tr>
                <td height="33"><img src="images/flash-arrow2.gif" width="7" height="7">资产价格：</td>
                <td><label>
                  <html:text property="zc_price" styleClass="logininput" size="30" value="${sessionScope.zcinfo.zcPrice}"></html:text> 
                (RMB)<font color=red><html:errors property="zc_price"/></font></label></td>
                <td><img src="images/flash-arrow2.gif" width="7" height="7">资产类型：</td>
                <td><label>
               <html:select property="zc_type" value="${sessionScope.zcinfo.zcType}">
                  <html:option value="办公用品">办公用品</html:option>
                  <html:option value="笔记本">笔记本</html:option>
                  <html:option value="电脑软件">电脑软件</html:option>
                  <html:option value="电脑硬件">电脑硬件</html:option>
                  <html:option value="服务器">服务器</html:option>
                  <html:option value="手机通信">手机通信</html:option>
                  <html:option value="数码产品">数码产品</html:option>
                  <html:option value="数码配件">数码配件</html:option>
                  <html:option value="拓展配件">拓展配件</html:option>
                  <html:option value="网络设备">网络设备</html:option>
                  <html:option value="无线网络">无线网络</html:option>
                  </html:select>
                  <font color=red><html:errors property="zc_type"/></font>
                  </label></td>
              </tr>
              <tr>
                <td height="36"><img src="images/flash-arrow2.gif" width="7" height="7">生产厂商：</td>
                <td><label>
                   <html:text property="zc_factory" styleClass="logininput" size="30" value="${sessionScope.zcinfo.zcFactory}"></html:text> 
                   </label></td>
                <td><img src="images/flash-arrow2.gif" width="7" height="7">资产状态：</td>
                <td><label>
                  <html:select property="zc_status">
                	<html:option value="正常">正常</html:option>
                	<html:option value="维修">维修</html:option>
                	<html:option value="报废">报废</html:option>
             	  </html:select>
                  </td>
              </tr>
              <tr>
                <td><img src="images/flash-arrow2.gif" width="7" height="7">备注信息：</td>
                <td colspan="3"><label>
                  <textarea name="zc_bzxx" cols="60" rows="7" class="tableBorder" id="zc_bzxx"></textarea>
                  <font color=red></font>
                 </label></td>
                </tr>
              <tr>
                <td height="36">&nbsp;</td>
                <td colspan="3"></td>
              </tr>
              <tr>
                <td>&nbsp;</td>
                <td colspan="3"><table width="98%" border="0">
                  <tr>
                    <td width="22%">&nbsp;</td>
                    <td width="15%"><label>
                      <input name="submit" type="submit" class="button" value="保   存" id="submit"
                      onmouseover="this.style.color='red'" onMouseOut="this.style.color='#1e7977'">
                    </label></td>
                    <td width="14%">&nbsp;</td>
                    <td width="13%"><label>
                      <input name="back" type="button" class="button" value="返   回"
                      onmouseover="this.style.color='red'" onMouseOut="this.style.color='#1e7977'"
                       onClick="window.history.back();">
                    </label></td>
                    <td width="36%">&nbsp;</td>
                  </tr>
                </table></td>
              </tr>
            </table>
            </html:form></td>
        </tr>
        <tr>
          <td>&nbsp;</td>
        </tr>
      </table></td>
    </tr>
  </table>
    
</body>
</html>
