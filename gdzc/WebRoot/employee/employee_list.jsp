<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<title>员工列表信息</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">

		<link rel="stylesheet" type="text/css" href="/gdzc/css/style.css">
		<link rel="stylesheet" type="text/css" href="/gdzc/css/style2.css">

		<SCRIPT language=JavaScript src="/gdzc/js/pinbi.js"></SCRIPT>
	</head>

	<body>
		<table width="100%" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td height="22" valign="top" class="word_orange">
					<img src="/gdzc/images/7.gif" width="33" height="33">
					<span class="word_orange2"><strong>员工信息管理</strong> </span>
				</td>
			</tr>
			<tr>
				<td height="22" valign="top" class="word_orange">
					<hr align="center" size="1" noshade>
				</td>
			</tr>
			<tr>
				<td height="22" valign="top" class="word_orange">
					<table width="100%" border="0">
						<tr>
							<td width="7%">
								&nbsp;
							</td>
							<td width="7%">
								&nbsp;
							</td>
							<td width="7%">
								&nbsp;
							</td>
							<td width="7%">
								&nbsp;
							</td>
							<td width="7%">
								&nbsp;
							</td>
							<td width="54%">
								&nbsp;
							</td>

							<td width="8%">
								<label>
									<img src="/gdzc/images/jiaodian_biao.gif" width="21"
										height="17">
									<input name="add" type="submit" class="button" id="add"	value="添加员工" onMouseOver="this.style.color= 'red'"
									onMouseOut="this.style.color= '#1e7977'"
									onclick="window.location='addEmployeeAction.do'">
								</label>
							</td>
							<td width="3%">
							</td>
						</tr>
						<tr>
							<td colspan="8">
								<hr align="center" size="1" noshade>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td align="center" valign="top">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td></td>
						</tr>
					</table>
					<table width="98%" border="1" cellpadding="0" cellspacing="0"
						bordercolor="#FFFFFF" bordercolorlight="#FFFFFF"
						bordercolordark="#D2E3E6" class="tableBorder">
						<tr align="center" bgcolor="#e3F4F7" height="20">
							<td width="8%" bgcolor="#B7E2EA">
								<strong> 员工编号 </strong>
							</td>
							<td width="9%" bgcolor="#B7E2EA">
								<strong> 姓名 </strong>
							</td>
							<td width="9%" bgcolor="#B7E2EA">
								<strong> 性别 </strong>
							</td>
							<td width="9%" bgcolor="#B7E2EA">
								<strong> 年龄 </strong>
							</td>
							<td width="9%" bgcolor="#B7E2EA">
								<strong> 所在部门 </strong>
							</td>
							<td width="10%" bgcolor="#B7E2EA">
								<strong> 现任职务 </strong>
							</td>
							<td width="13%" bgcolor="#B7E2EA">
								<strong> 家庭地址 </strong>
							</td>
							<td width="11%" bgcolor="#B7E2EA">
								<strong> 联系方式 </strong>
							</td>
							<td width="10%" bgcolor="#B7E2EA">
								<strong> 状态 </strong>
							</td>
							<td colspan="3">
								<strong>操作</strong>
							</td>
						</tr>

						<c:forEach items="${requestScope.list}" var="item">
							<tr align="center" height="25">
								<td width="8%">
									${item.comployeeNo}&nbsp;
								</td>
								<td width="9%">
									${item.comployeeName}&nbsp;
								</td>
								<td width="9%">
									${item.sex}&nbsp;
								</td>
								<td width="9%">
									${item.age}&nbsp;
								</td>
								<td width="9%">
									${item.department.dept}&nbsp;
								</td>
								<td width="10%">
									${item.profession}&nbsp;
								</td>
								<td width="13%">
									${item.address}&nbsp;
								</td>
								<td width="11%">
									${item.phone}&nbsp;
								</td>
								<td width="10%">
									${item.comployeeStatus}&nbsp;
								</td>
								<td width="4%">
								<input name="edit" type="submit" class="button" id="edit"
									value="修 改" onMouseOver="this.style.color='red'"
									onMouseOut="this.style.color='#1e7977'"
									onclick="window.location='editEmployeeAction.do?eno=${item.comployeeNo}'">
			
								<td width="4%">
						<input name="delete" type="submit" class="button" id="delete"
							value="删 除" onMouseOver="this.style.color= 'red'"
							onMouseOut="this.style.color= '#1e7977'"
							onclick="if(confirm('您确定要删除编号为${item.comployeeNo}的员工吗?')) window.location='deleteEmployeeAction.do?eno=${item.comployeeNo}'"></td></tr>
						</c:forEach>
					</table>
					
					
       <form name="PageForm" action="/gdzc/servlet/ZcwxContactServlet" method="post">

   
       	<img src="images/advert.gif" alt="">
			每页${pageCount}条
		<img src="images/advert.gif" alt="">
			共${totalCount}条
		<img src="images/advert.gif" alt="">
			当前第 ${pages}页
		<img src="images/advert.gif" alt="">
			共 ${countpage}页
			
		<a href="employeeAction.do?currentPage=1">首页</a>
		<a href="employeeAction.do?currentPage=${pages-1}">上一页</a>
		<a href="employeeAction.do?currentPage=${pages+1}">下一页</a>	
		<a href="employeeAction.do?currentPage=${countpage}">尾页</a>


       </form>
					
					
					
				</td>
			</tr>
		</table>
		<br>
	</body>
</html>
