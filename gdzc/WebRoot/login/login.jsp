<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<html>
	<head>
		<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
		<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">
		<META HTTP-EQUIV="Expires" CONTENT="0">
		<title>固定资产管理系统---用户登陆</title>
		<link href="../css/style.css" rel="stylesheet">
		<link href="../css/style2.css" rel="stylesheet">
		<SCRIPT language=JavaScript src="../js/pinbi.js"></SCRIPT>
	</head>
<script language="javascript">

</script>

	<body>
		<table width="778" border="0" align="center" cellpadding="0"
			cellspacing="0" class="tableBorder">
			<tr>
				<td bgcolor="#F4FEFF">
				<table width="760" height="142" border="0" align="center" cellpadding="0" cellspacing="0">
			    <tr>
				<td height="142" valign="top" bgcolor="#F4FEFF">&nbsp;</td></tr>
				</table>
				</td>
			</tr>
			<td bgcolor="#F4FEff">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
					<td valign="top">
					<table width="100%" height="525" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
					<td height="523" align="center" valign="top">
					<table width="100%" height="531" border="0" cellpadding="0" cellspacing="0">
					<tr>
					<td height="531" align="right" valign="top" class="word_orange">
					<table width="100%" height="457" border="0" cellpadding="0"
										cellspacing="0" background="../images/login.jpg">
					<tr>
					<td height="57"><p>&nbsp;</p>
					<p>&nbsp;</p></td></tr>
					<tr>
					<td height="72" valign="top">
				    <table width="100%" height="63" border="0" cellpadding="0" cellspacing="0">
					<tr>
					<td width="2%">&nbsp;</td>
					<td width="97%" align="center" valign="top">
					<html:form method="post" action="login">
					<table width="100%" height="156" border="0" cellpadding="0" cellspacing="0"
							bordercolorlight="#FFFFFF" bordercolordark="#D2E3E6">
					<tr>
					    <td height="36">&nbsp;</td>
					    <td height="36" align="center"><div align="center">用户名：</div></td>
						<td height="36"><html:text property="username" styleClass="logininput" size="15"></html:text></td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td width="64%" height="26">&nbsp;</td>
						<td width="11%"><div align="center">密码：</div></td>
						<td width="22%"><html:password property="password" styleClass="logininput" size="17"></html:password></td>
						<td width="3%">&nbsp;</td>
					</tr>
					<tr>
						<td height="35">&nbsp;</td>
						<td><div align="center">验证码：</div></td>
						<td align="left">
							<table width="100%" border="0">
								<tr>
								<td width="33%" height="36"><html:text property="checkcode" styleClass="logininput" size="15"></html:text></td>
								<td width="13%">&nbsp;</td>
								<td width="54%"><img src="/gdzc/servlet/RandomCode" border="1" alt=""></td>
								</tr>
							</table>
						</td>
						<td>&nbsp;</td>
					</tr>
				    <tr>
						<td height="24">&nbsp;</td>
						<td height="24" colspan="2" align="center">
						<input name="Submit" type="submit" class="button" value="确  定">
						&nbsp; &nbsp;&nbsp;&nbsp;
						<input name="reset" type="reset" class="button" value="重  置">
						&nbsp;
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td height="30">&nbsp;</td>
						<td height="30" colspan="2" align="center">
							<font color=red>${err}</font>
						</td>
						<td>&nbsp;</td>
					</tr>
					</table>
					</html:form>
					</td>
					<td width="1%">&nbsp;</td>
					</tr>
					</table>
					</td>
					</tr>
					<tr>
						<td height="19">&nbsp;</td>
					</tr>
					</table>
					</td>
					</tr>
					</table>
					<table width="100%" height="27" border="0" cellpadding="0" cellspacing="0">
					<tr>
					<td align="center"></td>
					</tr>
					</table>
					</td>
					</tr>
					</table>
					</td>
					</tr>
				</table>
		</table>
	</body>
</html>
