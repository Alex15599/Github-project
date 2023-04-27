<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>员工详细信息修改</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">

		<link rel="stylesheet" type="text/css" href="/gdzc/css/style.css">
		<link rel="stylesheet" type="text/css" href="/gdzc/css/style2.css">
        
		<script language="javascript" type="text/javascript" src="/gdzc/js/pinbi.js"></script>
</head>

	<body>
		<table width="70%" border="0" align="center">
			<tr>
				<td>
					<table width="98%" border="0" align="center">
				  <tr>
							<td><img src="/gdzc/images/7.gif" width="33" height="33"><span class="word_orange2"><strong>员工信息修改</strong></span>							</td>
					  </tr>
						<tr>
							<td>
								<hr align="center" size="1" noshade>							</td>
						</tr>
						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td>
								<html:form  method="post" action="updateEmployeeAction">
									<table width="98%" border="0" align="center"
										background="/gdzc/images/bg.gif" class="tableBorder">
										<tr>
											<td width="17%" height="38">
												<img src="/gdzc/images/point.gif" width="17" height="16 ">
												员工编号：
											</td>
											<td width="34%">
												<label>
													<html:text property="eno" size="30" readonly="true" value="${com.comployeeNo}"/>
												</label>
											</td>
											<td width="17%">
												<img src="/gdzc/images/point.gif" width="17" height="16">
												姓名：
											</td>
											<td width="32%">
												<label>
													<html:text property="ename" size="30"  value="${com.comployeeName}"/>
												</label>
											</td>
										</tr>
										<tr>
											<td height="43">
												<img src="/gdzc/images/point.gif" width="17" height="16">
												性别：
											</td>
											<td>
												<label>
										<html:radio property="esex" styleClass="radio" value="男" />	男
										<html:radio property="esex" styleClass="radio"value="女"/>女
												</label>
											</td>
											<td>
												<img src="/gdzc/images/point.gif" width="17" height="16">
												年龄：
											</td>
											<td>
												<label>
													<html:text property="eage"   value="${com.age}" size="10"/><font color="red"> <html:errors property="eage"/>   ${requestScope.error}</font>
												</label>
											</td>
										</tr>
										<tr>
											<td height="34">
												<img src="/gdzc/images/point.gif" width="17" height="16">
												所在部门：
											</td>
											<td>
												<label>
										<html:select property="edept" value="${com.department.dept}"  >
										 <c:forEach items="${sessionScope.upemplist}" var="item">
				                		<html:option  value="${item.dept}">${item.dept}</html:option>   
				                		</c:forEach>           
				            		    </html:select>
												</label>
											</td>
											<td>
												<img src="/gdzc/images/point.gif" width="17" height="16">
												现任职务：
											</td>
											<td>
												<label>
													<html:text property="epro"  value="${com.profession}"  size="20"/>
												</label>
											</td>
										</tr>
										<tr>
											<td height="38">
												<img src="/gdzc/images/point.gif" width="17" height="16">
												联系地址：
											</td>
											<td>
												<label>
													<html:text property="eaddr" value="${com.address}"  size="35" />
												</label>
											</td>
											<td>
												<img src="/gdzc/images/point.gif" width="17" height="16">
												联系方式：
											</td>
											<td>
												<label>
													<html:text property="ephone" size="20"  value="${com.phone}"  /><font color="red"> <html:errors  property="ephone"/></font>
												</label>
											</td>
										</tr>
										<tr>
											<td height="35">
												<img src="/gdzc/images/point.gif" width="17" height="16">
												员工状态：
											</td>
											<td>
												<label>
													<html:select property="estatus" value="${com.comployeeStatus}">
													<html:option  value="在职">在职</html:option>   
													<html:option  value="休假">休假</html:option>   
													<html:option  value="离职">离职</html:option>   
													</html:select>
												</label>
											</td>
											<td></td>
											<td></td>
										</tr>
										<tr>
											<td></td>
											<td colspan="3">
											</td>
										</tr>
										<tr>
											<td>
												&nbsp;
											</td>
											<td colspan="3">
												&nbsp;
											</td>
										</tr>
										<tr>
											<td>
												&nbsp;
											</td>
											<td colspan="3">
												<table width="98%" border="0">
													<tr>
														<td width="25%">
															&nbsp;
														</td>
														<td width="12%">
															<label>
																<input name="submit" type="submit" class="button"
																	id="submit" value="保   存"
																	onClick="return checkNoNull()">
															</label>
														</td>
														<td width="13%">
															&nbsp;
														</td>
														<td width="14%">
															<label>
																<input name="back" type="button" class="button"
																	id="back" value="返   回"
																	onClick="window.history.back();">
															</label>
														</td>
														<td width="36%">
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
						<tr>
							<td>&nbsp;							</td>
						</tr>
					</table>
			  </td>
			</tr>
		</table>

	</body>
</html>
