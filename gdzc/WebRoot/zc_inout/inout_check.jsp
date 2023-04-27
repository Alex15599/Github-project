<%@ page language="java" pageEncoding="utf-8"%>
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
	
	<link rel="stylesheet" type="text/css" href="/gdzc/css/style.css">
    <link rel="stylesheet" type="text/css" href="/gdzc/css/style2.css">
	
	<SCRIPT language=JavaScript src="/gdzc/js/pinbi.js"></SCRIPT>
</head>
  
  <body>
  <table width="80%" border="0" align="center">
    <tr>
      <td><img src="/gdzc/images/weifu.gif" width="30" height="30"><span class="word_orange2"><strong>借用资产详细信息</strong></span></td>
    </tr>
    
    <tr>
      <td><hr align="center" size="1" noshade></td>
    </tr>
    <tr>
      <td><img src="/gdzc/images/7.gif" width="33" height="33"><strong>资产借用人信息：</strong></td>
    </tr>
    <tr>
      <td><table width="98%" border="0" align="center" background="/gdzc/images/bg.gif" class="tableBorder">
        <tr>
          <td width="13%" height="34"><img src="/gdzc/images/point.gif" width="17" height="16">员工编号：</td>
          <td width="27%"><label>
            <input name="e_no" type="text" class="logininput" id="e_no" size="30" readonly value="${sessionScope.comployee.comployeeNo}">
          </label></td>
          <td width="10%">&nbsp;</td>
          <td width="13%">&nbsp;</td>
          <td width="37%">&nbsp;</td>
        </tr>
        <tr>
          <td height="34"><img src="/gdzc/images/point.gif" width="17" height="16">姓名：</td>
          <td><label>
            <input name="e_name" type="text" class="logininput" id="e_name" size="25" readonly value="${sessionScope.comployee.comployeeName}">
          </label></td>
          <td>&nbsp;</td>
          <td><img src="/gdzc/images/point.gif" width="17" height="16">现任职务：</td>
          <td><label>
            <input name="pro" type="text" class="logininput" id="pro" size="20" readonly value="${sessionScope.comployee.profession}">
          </label></td>
        </tr>
        <tr>
          <td height="33"><img src="/gdzc/images/point.gif" width="17" height="16">性别：</td>
          <td><label>
            <input name="sex" type="text" class="logininput" id="sex" size="6" readonly value="${sessionScope.comployee.sex}">
          </label></td>
          <td>&nbsp;</td>
          <td><img src="/gdzc/images/point.gif" width="17" height="16">家庭住址：</td>
          <td><label>
            <input name="addr" type="text" class="logininput" id="addr" size="35" readonly value="${sessionScope.comployee.address}">
          </label></td>
        </tr>
        <tr>
          <td height="35"><img src="/gdzc/images/point.gif" width="17" height="16">年龄：</td>
          <td><label>
            <input name="age" type="text" class="logininput" id="age" size="6" readonly value="${sessionScope.comployee.age}">
          </label></td>
          <td>&nbsp;</td>
          <td><img src="/gdzc/images/point.gif" width="17" height="16">联系方式：</td>
          <td><label>
            <input name="phone" type="text" class="logininput" id="phone" size="20" readonly value="${sessionScope.comployee.phone}">
          </label></td>
        </tr>
        <tr>
          <td height="33"><img src="/gdzc/images/point.gif" width="17" height="16">所在部门：</td>
          <td><label>
            <input name="dept" type="text" class="logininput" id="dept" size="25" readonly value="${sessionScope.comployee.department.dept}">
          </label></td>
          <td>&nbsp;</td>
          <td><img src="/gdzc/images/point.gif" width="17" height="16">员工状态：</td>
          <td><label>
            <input name="e_status" type="text" class="logininput" id="e_status" size="15" readonly value="${sessionScope.comployee.comployeeStatus}">
          </label></td>
        </tr>
      </table></td>
    </tr>
    <tr>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td><img src="/gdzc/images/4.gif" width="39" height="34"><strong>被借资产详细信息</strong></td>
    </tr>
    <tr>
      <td><table width="98%" border="0" align="center" background="/gdzc/images/background.jpg" class="tableBorder">
        <tr>
          <td width="12%" height="32"><img src="/gdzc/images/point.gif" width="17" height="16">资产编号：</td>
          <td width="35%"><label>
            <input name="zc_id" type="text" class="logininput" id="zc_id" size="30" readonly value="${sessionScope.zcinfo.zcId}">
          </label></td>
          <td width="3%">&nbsp;</td>
          <td width="12%"><img src="/gdzc/images/point.gif" width="17" height="16">生产日期：</td>
          <td width="38%"><label>
            <input name="pro_time" type="text" class="logininput" id="pro_time" size="30" readonly value="${sessionScope.zcinfo.zcProduceTime}">
          </label></td>
        </tr>
        <tr>
          <td height="31"><img src="/gdzc/images/point.gif" width="17" height="16">型号：</td>
          <td><label>
            <input name="zc_no" type="text" class="logininput" id="zc_no" size="25" readonly value="${sessionScope.zcinfo.zcNo}">
          </label></td>
          <td>&nbsp;</td>
          <td><img src="/gdzc/images/point.gif" width="17" height="16">入库时间</td>
          <td><label>
            <input name="buy_time" type="text" class="logininput" id="buy_time" size="30" readonly value="${sessionScope.zcinfo.zcBuyTime}">
          </label></td>
        </tr>
        <tr>
          <td height="32"><img src="/gdzc/images/point.gif" width="17" height="16">名称：</td>
          <td><label>
            <input name="zc_name" type="text" class="logininput" id="zc_name" size="30" readonly value="${sessionScope.zcinfo.zcName}">
          </label></td>
          <td>&nbsp;</td>
          <td><img src="/gdzc/images/point.gif" width="17" height="16">购买人：</td>
          <td><label>
            <input name="buyer" type="text" class="logininput" id="buyer" size="20" readonly value="${sessionScope.zcinfo.zcBuyer}">
          </label></td>
        </tr>
        <tr>
          <td height="30"><img src="/gdzc/images/point.gif" width="17" height="16">价格：</td>
          <td><label>
            <input name="price" type="text" class="logininput" id="price" size="8" readonly value="${sessionScope.zcinfo.zcPrice}">
          </label></td>
          <td>&nbsp;</td>
          <td><img src="/gdzc/images/point.gif" width="17" height="16">类型：</td>
          <td><label>
            <input name="type" type="text" class="logininput" id="type" size="20" readonly value="${sessionScope.zcinfo.zcType}">
          </label></td>
        </tr>
        <tr>
          <td height="34"><img src="/gdzc/images/point.gif" width="17" height="16">生产厂商：</td>
          <td><label>
            <input name="factory" type="text" class="logininput" id="factory" size="35" readonly value="${sessionScope.zcinfo.zcFactory}">
          </label></td>
          <td>&nbsp;</td>
          <td><img src="/gdzc/images/point.gif" width="17" height="16">状态：</td>
          <td><label>
            <input name="zc_status" type="text" class="logininput" id="zc_status" size="15" readonly value="${sessionScope.zcinfo.zcStatus}">
          </label></td>
        </tr>
      </table></td>
    </tr>
    <tr>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td><table width="98%" border="0">
        <tr>
          <td width="20%">&nbsp;</td>
          <td width="24%">&nbsp;</td>
          <td width="8%"><label>
            <input name="back" type="button" class="button" id="back" value="关   闭" onClick="window.history.back();">
          </label></td>
          <td width="28%">&nbsp;</td>
          <td width="20%">&nbsp;</td>
        </tr>
      </table></td>
    </tr>
  </table>
</body>
</html>
