<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

		<script language="javascript" type="text/javascript"
			src="/gdzc/js/check_addEmployee.js"></script>

		<script language="javascript" type="text/javascript"
			src="/gdzc/js/pinbi.js"></script>
	</head>

	<body>
		<table width="55%" border="0" align="center">

			<tr>
				<td>
					<html:form method="post" action="addEmployeeInfo">
						<table width="100%" border="0" background="/gdzc/images/bg.gif"
							class="tableBorder">
							<tr>
								<td colspan="2">
									<img src="/gdzc/images/4.gif" width="39" height="34">
									<span class="word_orange2"><strong>员工信息添加</strong>
									</span>
								</td>
							</tr>
							<tr>
								<td height="3" colspan="2">
									<hr align="center" size="1" noshade>
								</td>
							</tr>
							<tr>
							
								<td height="28">
								
								</td>
								<td>
									&nbsp;
								</td>
							</tr>
							<tr>
								<td width="20%" height="41"
									background="/gdzc/images/background.jpg">
									<span class="word_Green"><img
											src="/gdzc/images/point.gif" width="17" height="16">员工编号：</span>
								</td>
								<td width="80%">
									<label>
										<html:text property="eno" 	size="30" /><font color="red"> <html:errors property="eno"/> ${requestScope.errorno}    </font>  
									</label>
								</td>
							</tr>
							<tr>
								<td height="39" background="/gdzc/images/background.jpg">
									<span class="word_Green"><img
											src="/gdzc/images/point.gif" width="17" height="16">姓名：</span>
								</td>
								<td>
									<label>
										<html:text property="ename" size="25"/><font color="red"> <html:errors property="ename"/></font>
									</label>
								</td>
							</tr>
							<tr>
								<td height="34" background="/gdzc/images/background.jpg">
									<span class="word_Green"><img
											src="/gdzc/images/point.gif" width="17" height="16">性别：</span>
								</td>
								<td>
									<label>
										<html:radio property="esex" styleClass="radio" value="男" />	男
										<html:radio property="esex" styleClass="radio"value="女"/>女
										
									</label>
								</td>
							</tr>
							<tr>
								<td height="36" background="/gdzc/images/background.jpg">
									<span class="word_Green"><img
											src="/gdzc/images/point.gif" width="17" height="16">年龄：</span>
								</td>
								<td>
									<label>
										<html:text property="eage" size="10"/><font color="red"> <html:errors property="eage"/>  ${requestScope.errorage }</font>
									</label>
								</td>
							</tr>
							<tr>
								<td height="37" background="/gdzc/images/background.jpg">
									<span class="word_Green"><img
											src="/gdzc/images/point.gif" width="17" height="16">所在部门：</span>
								</td>
								<td>
									<label>
										<html:select property="edept" >
										 <c:forEach items="${sessionScope.list}" var="item">
				                		<html:option  value="${item.dept}">${item.dept}</html:option>   
				                		</c:forEach>           
				            		    </html:select>

									</label>
								</td>
							</tr>
							<tr>
								<td height="38" background="/gdzc/images/background.jpg">
									<span class="word_Green"><img
											src="/gdzc/images/point.gif" width="17" height="16">现任职务：</span>
								</td>
								<td>
									<label>
										<html:text property="epro" size="20"/>
									</label>
								</td>
							</tr>
							<tr>
								<td height="36" background="/gdzc/images/background.jpg">
									<span class="word_Green"><img
											src="/gdzc/images/point.gif" width="17" height="16">家庭地址：</span>
								</td>
								<td>
									<label>
										<html:text property="eaddr" size="35"/>
									</label>
								</td>
							</tr>
							<tr>
								<td height="36" background="/gdzc/images/background.jpg">
									<span class="word_Green"><img
											src="/gdzc/images/point.gif" width="17" height="16">联系方式：</span>
								</td>
								<td>
									<label>
										<html:text property="ephone" size="20"/><font color="red"> <html:errors property="ephone"/> </font>
									</label>
								</td>
							</tr>
							<tr>
								<td height="35" background="/gdzc/images/background.jpg">
									<span class="word_Green"><img
											src="/gdzc/images/point.gif" width="17" height="16">员工状态：</span>
								</td>
								<td>
									<label>
									<html:select property="estatus" >
				                		<html:option  value="在职">在职</html:option>   
				                		<html:option  value="休假">休假</html:option>   
				                		<html:option  value="离职">离职</html:option>   
				            	  </html:select>
									</label>
								</td>
							</tr>
							<tr>
								<td height="3" colspan="2">
									<hr align="center" size="1" noshade>
								</td>
							</tr>
							<tr>
								<td height="26" colspan="2">
									<table width="100%" border="0">
										<tr>
											<td width="10%">
												&nbsp;
											</td>
											<td width="20%">
												&nbsp;
											</td>
											<td width="18%">
												<label>
													<input name="submit" type="submit" class="button"
														id="submit" value="添   加"
														onmouseover=this.style.color = 'red';
onMouseOut=this.style.color = '#1e7977';
onclick=return checkEmployee(form1);/></label>
											</td>
											<td width="16%">
												<label>
													<input name="reset" type="reset" class="button" id="reset"
														value="重  置" onMouseOver=
	this.style.color = 'red';
onMouseOut=
	this.style.color = '#1e7977';
>
												</label>
											</td>
											<td width="26%">
												<label>
													<input name="back" type="button" class="button" id="back"
														value="返  回" onMouseOver=
	this.style.color = 'red';
onClick=
	window.history.back();;
onMouseOut=
	this.style.color = '#1e7977';
>
												</label>
											</td>
											<td width="10%">
												&nbsp;
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</html:form>
				</td>
			</tr>
		</table>
	</body>
</html>
