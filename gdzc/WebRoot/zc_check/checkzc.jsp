<%@ page language="java" pageEncoding="utf-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>资产信息浏览/查询</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	
	<link rel="stylesheet" type="text/css" href="/gdzc/css/style.css">
    <link rel="stylesheet" type="text/css" href="/gdzc/css/style2.css">
	
	<SCRIPT language=JavaScript src="/gdzc/js/pinbi.js"></SCRIPT>
</head>
  
  <body>
  <table width="100%" border="0" align="center">
    <tr>
      <td><table width="98%" border="0" align="center">
        <tr>
          <td><img src="/gdzc/images/weifu.gif" width="30" height="30"><span class="word_orange2"><strong>资产信息浏览/查询</strong></span></td>
        </tr>
        <tr>
          <td><hr align="center" size="1" noshade></td>
        </tr>
        <tr>
          <td><html:form method="post" action="checkzc">
            <table width="98%" border="0" align="center" background="/gdzc/images/bg.gif" class="tableBorder">
              <tr>
                <td colspan="4"><img src="/gdzc/images/point.gif" width="17" height="16"><span class="word_orange"><strong>填写查询条件</strong></span></td>
              </tr>
              <tr>
                <td width="12%" height="24"><img src="/gdzc/images/point.gif" width="17" height="16">资产编号：</td>
                <td width="32%"><label>
                  <html:text property="zc_id" styleClass="logininput" size="30"></html:text>
                </label></td>
                <td width="12%"><img src="/gdzc/images/point.gif" width="17" height="16">生产厂商：</td>
                <td width="43%"><label>
                 <html:text property="zc_factory" styleClass="logininput" size="30"></html:text>
                </label></td>
              </tr>
              <tr>
                <td height="24"><img src="/gdzc/images/point.gif" width="17" height="16">资产型号：</td>
                <td><label>
                 <html:text property="zc_no" styleClass="logininput" size="30"></html:text>
                </label></td>
                <td><img src="/gdzc/images/point.gif" width="17" height="16">资产类型：</td>
                <td><label>
                 <html:select property="zc_type" >
                 <html:option value=""></html:option>
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
                </label></td>
              </tr>
              <tr>
                <td height="24"><img src="/gdzc/images/point.gif" width="17" height="16">资产名称：</td>
                <td><label>
                  <html:text property="zc_name" styleClass="logininput" size="30"></html:text>
                </label></td>
                <td><img src="/gdzc/images/point.gif" width="17" height="16">状态：</td>
                <td><label>
                  <html:select property="zc_status" >
                  <html:option value=""></html:option>
                  <html:option value="正常">正常</html:option>
                  <html:option value="维修">维修</html:option>
                  <html:option value="借出">借出</html:option>
                  <html:option value="报废">报废</html:option>
                  </html:select>
                </label></td>
              </tr>
              
              <tr>
                <td height="24"><img src="/gdzc/images/point.gif" width="17" height="16">购买人：</td>
                <td><label>
                   <html:text property="zc_buyer" styleClass="logininput" size="30"></html:text>
                </label></td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
              
              <tr>
                <td height="30">&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td><label></label>
                  <table width="98%" border="0">
                    <tr>
                      <td width="47%"><font color=red>${requestScope['gdzc.check.error'] }</font></td>
                      <td width="17%">
                      <input name="submit" type="submit" class="button" id="submit" value="查  询"
                      onmouseover="this.style.color='red'" onMouseOut="this.style.color='#1e7977'"></td>
                      <td width="7%">&nbsp;</td>
                    </tr>
                  </table></td>
              </tr>
            </table>
          </html:form></td>
        </tr>
        <tr>
          <td>&nbsp;</td>
        </tr>
        <tr>
          <td>
          <table width="100%"  border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" 
        	bordercolorlight="#FFFFFF" bordercolordark="#D2E3E6" class="tableBorder">
        	<tr align="center" bgcolor="#e3F4F7">
              <td width="13%" height="20" bgcolor="#F2E3AE"><strong>资产编号</strong></td>
              <td width="12%" bgcolor="#F2E3AE"><strong>资产型号</strong></td>
              <td width="12%" bgcolor="#F2E3AE"><strong>资产名称</strong></td>
              <td width="5%" bgcolor="#F2E3AE"><strong>单价</strong></td>
              <td width="12%" bgcolor="#F2E3AE"><strong>生产厂商 </strong></td>
              <td width="11%" bgcolor="#F2E3AE"><strong>生产日期</strong></td>
              <td width="10%" bgcolor="#F2E3AE"><strong>入库时间</strong></td>
              <td width="7%" bgcolor="#F2E3AE"><strong>购买人</strong></td>
              <td width="8%" bgcolor="#F2E3AE"><strong>资产类型</strong></td>
              <td width="5%" bgcolor="#F2E3AE"><strong>状态</strong></td>
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
            </c:forEach>
            </table></td>
     
        </tr>
      </table></td>
    </tr>
  </table>
    
</body>
</html>
