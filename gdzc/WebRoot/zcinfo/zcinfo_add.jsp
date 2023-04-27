<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title></title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	
	<link rel="stylesheet" type="text/css" href="/gdzc/css/style2.css">
    <link rel="stylesheet" type="text/css" href="/gdzc/css/style.css">
    
    <SCRIPT language="JavaScript" src="/gdzc/js/check_addZcInfo.js"></SCRIPT>
    
	<SCRIPT language="JavaScript" src="/gdzc/js/pinbi.js"></SCRIPT>
    
    <script language="JavaScript" src="/gdzc/js/setday.js"></script>
</head>
  
  <body>
  <table width="55%" border="0" align="center">
    <tr>
      <td>
      <html:form method="post" action="add">
        <table width="100%" border="0" background="/gdzc/images/bg.gif" class="tableBorder">
          <tr>
            <td colspan="2"><img src="/gdzc/images/weifu.gif" width="30" height="30"><span class="word_orange2"><strong>资产信息添加</strong></span><font color=red>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          </tr>
          <tr>
            <td height="3" colspan="2"><hr align="center" size="1" noshade></td>
          </tr>
          
           <tr>
            <td width="21%" height="41" background="/gdzc/images/background.jpg"><img src="/gdzc/images/point.gif" width="17" height="16"><span class="word_Green">资产编号：</span></td>
            <td width="79%"><label>
              <html:text property="zc_id" styleClass="logininput" size="30"></html:text><font color=red><html:errors property="zc_id"/> ${requestScope['gdzc.add.error2']}  </font>
            </label></td>
          </tr>
          
          <tr>
            <td width="21%" height="41" background="/gdzc/images/background.jpg"><img src="/gdzc/images/point.gif" width="17" height="16"><span class="word_Green">资产型号：</span></td>
            <td width="79%"><label>
              <html:text property="zc_no" styleClass="logininput" size="30"></html:text><font color=red><html:errors property="zc_no"/></font>
            </label></td>
          </tr>
          <tr>
            <td height="39" background="/gdzc/images/background.jpg"><img src="/gdzc/images/point.gif" alt="" width="17" height="16"><span class="word_Green">资产名称：</span></td>
            <td><label>
              <html:text property="zc_name" styleClass="logininput" size="30"></html:text><font color=red><html:errors property="zc_name"/></font>
            </label></td>
          </tr>
          <tr>
            <td height="34" background="/gdzc/images/background.jpg"><img src="/gdzc/images/point.gif" alt="" width="17" height="16"> <span class="word_Green">生产日期：</span></td>
            <td><html:text  property="zc_produceTime" onclick="setday(this)" onfocus="setday(this)" readonly="true"  size="25" maxlength="30"/><font color=red><html:errors property="zc_produceTime"/></font></td>          
          </tr>
          
          <tr>
            <td height="34" background="/gdzc/images/background.jpg"><img src="/gdzc/images/point.gif" alt="" width="17" height="16"><span class="word_Green">单价：</span></td>
            <td><label>
              <html:text property="zc_price" styleClass="logininput" size="10"></html:text>
              <span class="word_Green">(RMB)</span></label><font color=red><html:errors property="zc_price"/></font></td>
          </tr>
    
          <tr>
            <td height="37" background="/gdzc/images/background.jpg"><img src="/gdzc/images/point.gif" alt="" width="17" height="16"><span class="word_Green">生产厂商：</span></td>
            <td><label>
               <html:text property="zc_factory" styleClass="logininput" size="35"></html:text><font color=red><html:errors property="zc_factory"/></font>
            </label></td>
          </tr>
          
          <tr>
            <td height="38" background="/gdzc/images/background.jpg"><img src="/gdzc/images/point.gif" alt="" width="17" height="16"><span class="word_Green">入库时间：</span></td>
            <td><label>
             <html:text  property="zc_buyTime" onclick="setday(this)" onfocus="setday(this)" readonly="true"  size="25" maxlength="30"/><font color=red><html:errors property="zc_buyTime"/> ${requestScope['gdzc.add.error1']}  </font>
            </label></td>
          </tr>
          <tr>
            <td height="36" background="/gdzc/images/background.jpg"><img src="/gdzc/images/point.gif" alt="" width="17" height="16"><span class="word_Green">购买人：</span></td>
            <td><label>
              <html:text property="zc_buyer" styleClass="logininput" size="20"></html:text><font color=red><html:errors property="zc_buyer"/></font>
            </label></td>
          </tr>
          <tr>
            <td height="39" background="/gdzc/images/background.jpg"><img src="/gdzc/images/point.gif" alt="" width="17" height="16"><span class="word_Green">资产类型：</span></td>
            <td><label>
              <html:select property="zc_type" >
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
                  </html:select><font color=red><html:errors property="zc_type"/></font>
            </label></td>
          </tr>
          <tr>
            <td height="35" background="/gdzc/images/background.jpg"><img src="/gdzc/images/point.gif" alt="" width="17" height="16"><span class="word_Green">资产状态：</span></td>
            <td><label>
             <html:select property="zc_status" >
                <html:option value="正常">正常</html:option>
                <html:option value="维修">维修</html:option>
                <html:option value="借出">借出</html:option>
                <html:option value="报废">报废</html:option>
             </html:select><font color=red><html:errors property="zc_status"/></font>
            </label></td>
          </tr>
          <tr>
            <td height="35" background="/gdzc/images/background.jpg"><img src="/gdzc/images/point.gif" width="17" height="16">备注信息：</td>
            <td><label>
              <textarea name="zc_bzxx" cols="50" rows="7" id="zc_bzxx"></textarea>
            </label></td>
          </tr>
          <tr>
            <td height="3" colspan="2"><hr align="center" size="1" noshade></td>
          </tr>
          <tr>
            <td height="26" colspan="2" ><table width="100%" border="0">
              <tr>
                <td width="10%">&nbsp;</td>
                <td width="20%">&nbsp;</td>
                <td height="30" colspan="2" align="center">
				</td>
				
                <td width="18%"><label>
               <input name="submit" type="submit" class="button" value="提   交" onmouseover="this.style.color='red'" onMouseOut="this.style.color='#1e7977'">
                </label></td>
                <td width="16%"><label>
                  <input name="reset" type="reset" class="button" value="重  置" onmouseover="this.style.color='red'" onMouseOut="this.style.color='#1e7977'">
                </label></td>
                <td width="26%"><label>
                  <input name="back" type="button" class="button" id="back" value="返   回"
                  onMouseOver="this.style.color='red'" onClick=" window.history.back();" 
                  onMouseOut="this.style.color='#1e7977'">
                </label></td>
                <td width="10%">&nbsp;</td>
              </tr>
            </table></td>
          </tr>
        </table>
      </html:form></td>
    </tr>
  </table>
</body>
</html>
