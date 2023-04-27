<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<title>资产维修信息查找</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<link rel="stylesheet" type="text/css" href="/gdzc/css/style.css">
		<link rel="stylesheet" type="text/css" href="/gdzc/css/style2.css">

		<SCRIPT language="JavaScript" src="/gdzc/js/pinbi.js"></SCRIPT>

		<script language="JavaScript" src="/gdzc/js/setday.js"></script>
	</head>

	<body>
		<br>
		<table width="100%" border="0">
			<tr>
				<td>
					<table width="98%" border="0" align="center">
						<tr>
							<td>
								<img src="/gdzc/images/9.gif" width="36" height="30">
								<span class="word_orange2"><strong>资产维修信息查找/更新</strong>
								</span>
							</td>
						</tr>
						<tr>
							<td>
								<hr align="center" size="1" noshade>
							</td>
						</tr>
						<tr>
							<td height="146">

								<html:form method="post" action="findPerAssetbyPro">


									<table width="100%" border="0" bgcolor="#E3F4F7"
										class="tableBorder">
										<tr>
											<td width="14%" height="36">
												<img src="/gdzc/images/Favorites.gif" width="16" height="16">
												维修流水号：
											</td>
											<td width="28%">
												<label>
													<html:text property="repair_no" size="25" maxlength="25" />
												</label>
											</td>
											<td width="15%">
												<img src="/gdzc/images/Favorites.gif" width="16" height="16">
												经手人：
											</td>
											<td width="43%">
												<label>
													<html:text property="login_user" size="20" maxlength="20" />
												</label>
											</td>
										</tr>
										<tr>
											<td height="34">
												<img src="/gdzc/images/Favorites.gif" width="16" height="16">
												送修时间：
											</td>
											<td>
												<label>
													<html:text  property="send_time" onclick="setday(this)" onfocus="setday(this)"  
                  readonly="true"  size="25" maxlength="30"/>
												</label>
											</td>
											<td>
												<img src="/gdzc/images/Favorites.gif" width="16" height="16">
												送修人：
											</td>
											<td>
												<label>
													<html:text property="sender" size="20" maxlength="20" />
												</label>
											</td>
										</tr>
										<tr>
											<td height="31">
												<img src="/gdzc/images/Favorites.gif" width="16" height="16">
												维修结果：
											</td>
											<td>
												<label>
													<html:select property="wx_result">
														<html:option value="">
														</html:option>
														<html:option value="已完成">已完成
														</html:option>
														<html:option value="未完成">未完成
														</html:option>
													</html:select>
												</label>
											</td>
											<td>
												&nbsp;
											</td>
											<td>
												<label></label>
											</td>
										</tr>

										<tr>
											<td>
												&nbsp;
											</td>
											<td>
												&nbsp;
											</td>
											<td>
												&nbsp;
											</td>
											<td>
												<table width="98%" border="0">
													<tr>
														<td width="25%">
															&nbsp;
														</td>
														<td width="26%">
															<label>
																<input name="check" type="submit" class="button"
																	id="check" value="查   找">
															</label>
														</td>
											
														<td width="13%">
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
							<td>
								<img src="/gdzc/images/10.gif" width="37" height="34">
								<span class="word_orange"><strong>资产维修详细信息列表</strong>
								</span>
							</td>
						</tr>
						<tr>
							<td>
								<table width="100%" class="tableBorder" border="1"
									cellpadding="0" cellspacing="0" bordercolor="#CCCCCC"
									bordercolorlight="#FFFFFF" bordercolordark="#D2E3E6">
									<tr>
										<td bgcolor="#F9D695">
											<div align="center">
												<strong>维修流水号</strong>
											</div>
										</td>
										<td bgcolor="#F9D695">
											<div align="center">
												<strong>资产编号</strong>
											</div>
										</td>
										<td  bgcolor="#F9D695">
											<div align="center">
												<strong>送修时间</strong>
											</div>
										</td>
										<td bgcolor="#F9D695">
											<div align="center">
												<strong>送修人</strong>
											</div>
										</td>
										<td bgcolor="#F9D695">
											<div align="center">
												<strong>经手人</strong>
											</div>
										</td>
										<td bgcolor="#F9D695">
											<div align="center">
												<strong>故障原因</strong>
											</div>
										</td>
										<td bgcolor="#F9D695">
											<div align="center">
												<strong>维修时间</strong>
											</div>
										</td>
										<td  bgcolor="#F9D695">
											<div align="center">
												<strong>维修结果</strong>
											</div>
										</td>
										<td bgcolor="#F9D695">
											<div align="center">
												<strong>维修费用</strong>
											</div>
										</td>
										<td  bgcolor="#F9D695">
											<div align="center">
												<strong>维修备注</strong>
											</div>
											<div align="center"></div>
										</td>
									</tr>

									<c:forEach items="${requestScope.listbypro}" var="item">
										<tr align="center" >
											<td>
											&nbsp;	${item.repairNo}
											</td>
											<td>
												&nbsp;${item.zcInfo.zcId}
											</td>
											<td>
												&nbsp;${item.sendTime}
											</td>
											<td>
											&nbsp;	${item.sender}
											</td>
											<td>
											&nbsp;	${item.loginUser}
											</td>
											<td>
												&nbsp;${item.reason}
											</td>
											<td>
												&nbsp;${item.wx_time}
											</td>
											<td>
											&nbsp;	${item.wx_result}
											</td>
											<td>
												&nbsp;${item.cost}
											</td>
											<td>
												&nbsp;${item.wx_comment}
											</td>
											<td>
										</tr>
									</c:forEach>
								</table>
							</td>
						</tr>
						<tr>
							<td>
								&nbsp;
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</body>
</html>
