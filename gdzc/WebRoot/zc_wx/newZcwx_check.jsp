<%@ page language="java"  import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>新增资产维修信息查看</title>
    
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
  <table width="80%" border="0" align="center">
    <tr>
      <td><table width="98%" border="0" align="center">
        <tr>
          <td><img src="   images/3.gif" width="34" height="34"><span class="word_orange2"><strong>新增资产维修详细信息查看</strong></span></td>
        </tr>
        <tr>
          <td><hr align="center" size="1" noshade></td>
        </tr>
        <tr>
          <td>&nbsp;</td>
        </tr>
        <tr>
          <td>
           <html:form method="post" action="updatePerAssetAction">
         
          <table width="98%" border="0" align="center" background=" images/wdmap.gif" class="tableBorder">
            <tr>
              <td width="15%" height="41"><img src="  images/home.gif" width="15" height="15">维修流水号：</td>
              <td width="35%"><label>
                <html:text  property="repair_no"  size="25" maxlength="30" readonly="true"/>
              </label></td>
              <td width="15%"><img src="   images/home.gif" width="15" height="15">资产编号：</td>
              <td width="35%"><label>
                <html:text property="zc_id"  size="25" maxlength="30" readonly="true" />
              </label></td>
            </tr>
            <tr>
              <td height="40"><img src="   images/home.gif" width="15" height="15">送修时间：</td>
              <td><label>
                <html:text property="send_time" onclick="setday(this)" onfocus="setday(this)"  size="25" maxlength="30" readonly="true" />
              </label></td>
              <td><img src="   images/home.gif" width="15" height="15">送修人：</td>
              <td><label>
                <html:text property="sender"  size="20" maxlength="20" readonly="true" />
              </label></td>
            </tr>
            <tr>
              <td height="40"><img src="   images/home.gif" width="15" height="15">经手人：</td>
              <td><label>
                <html:text property="login_user" size="20" maxlength="20"  readonly="true" />
              </label></td>
              <td><img src="   images/home.gif" width="15" height="15">维修时间：</td>
              <td><label>
                <html:text property="wx_time" onclick="setday(this)" onfocus="setday(this)"  size="25" maxlength="30"  readonly="true"/>
              </label></td>
            </tr>
            <tr>
              <td height="37"><img src="   images/home.gif" width="15" height="15">维修结果：</td>
              <td><label>
                <html:select property="wx_result" >
                		<html:option  value="已完成">已完成</html:option>
                		<html:option  value="未完成">未完成</html:option>                
                </html:select>
              </label></td>
              <td><img src="   images/home.gif" width="15" height="15">维修费用：</td>
              <td><label>
                <html:text property="cost" size="15" maxlength="15" />
              </label></td>
            </tr>
            <tr>
              <td height="34"><img src="   images/home.gif" width="30" height="15">故障原因：</td>
              <td colspan="3"><label>
                <html:textarea property="reason" cols="45" rows="5" />
              </label></td>
              </tr>
            <tr>
              <td><img src="   images/home.gif" width="30" height="15">维修备注：</td>
              <td colspan="3"><label>
                <html:textarea property="wx_comment" cols="45" rows="5" />
              </label></td>
              </tr>
            <tr>
              <td>&nbsp;</td>
              <td colspan="3"><table width="98%" border="0" align="center">
                <tr>
                  <td width="38%">&nbsp;</td>
                  <td width="10%"><label>
                    <td>  <input name="submit" type="submit"  class="button" id="submit" value="保   存" 
                  onmouseover="this.style.color='red'" onMouseOut="this.style.color='#1e7977'" ></td>
                  <td>&nbsp;&nbsp;
                    <input name="back" type="button" class="button" id="back" value="返   回" onClick="window.history.back();">
                  </label></td>
                  <td width="39%">&nbsp;</td>
                  <td width="13%">&nbsp;</td>
                </tr>
              </table></td>
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
