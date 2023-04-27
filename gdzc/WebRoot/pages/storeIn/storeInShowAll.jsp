<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>入库单列表</title>

		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="${pageContext.request.contextPath }/css/admin.css"
			type="text/css" rel="stylesheet" />
		<script type="text/javascript"
			src="${pageContext.request.contextPath }/js/rep/main.js"></script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath }/js/rep/jquery.js"></script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath }/js/rep/myjs.js"></script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath }/js/rep/vote.js"></script>
		
	</head>
	<body bgcolor="#f5ffff" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
		<form action="${pageContext.request.contextPath }/storeInDelete.do" method="POST" onsubmit="return checkDeleteForm();">
			<input type="hidden" name="method" value="deleteVoteInfo">
			<table width="100%" border="0" cellspacing="0">
				<tr class="top_td">
					<td valign="middle" background="${pageContext.request.contextPath }/images/main/admin_08.jpg"> &nbsp;&nbsp;&nbsp;当前操作：入库管理
					</td>
				</tr>
				<tr>
					<td bgcolor="#dbe9e8" style="border: 1px solid #c2c2c2; padding-left: 10px;"></td>
				</tr>
				<tr>
					<td class="top_dq">
						<span class="td_padding"> <input type="submit" name="submit" value="删除所选项目" class="type_button"  /> </span>
						<span class="td_padding"> <input type="button" name="back" value="返回" class="type_button" onclick="javaScript:history.back();" /> </span>
					</td>
				</tr>
				<tr>
					<td>
						<table width="100%" border="0" cellspacing="1">
							<tr align="center" class="top1_td">

								<td  align="center" class="td_padding">
									资产编号
								</td>
								<td  align="center" class="td_padding">
									资产名称
								</td>
								<td  align="center" class="td_padding">
									资产类型 
								</td>
								<td  align="center" class="td_padding">
									供应商
								</td>
								<td  align="center" class="td_padding">
									单价
								</td>
								<td  align="center" class="td_padding">
									出产日期
								</td>
								<td  align="center" class="td_padding">
									购买日期							</td>
								<td  align="center" class="td_padding">
									购买者
								</td>
								<td  align="center" class="td_padding">
									资产状态
								</td>
							</tr>
							<c:forEach var="StoreIn" items="${requestScope.StoreInlist }">
								<tr class="top_other_td" onMouseOut="changeColorOut(this)"
									onMouseOver="changeColorOver(this)">

									<td align="center" class="td_padding">
										${StoreIn.zcId}
									</td>
									<td align="center" class="td_padding">
										${StoreIn.zcName}
									</td>
									<td align="center" class="td_padding">
										${StoreIn.zcType}
									</td>
									<td align="center" class="td_padding">
										${StoreIn.zcFactory }
									</td>
									<td align="center" class="td_padding">
										${StoreIn.zcPrice }
									</td>
									<td align="center" class="td_padding">
										${StoreIn.zcProduceTime}
									</td>
									<td align="center" class="td_padding">
										${StoreIn.zcBuyTime}
									</td>
									<td align="center" class="td_padding">
										${StoreIn.zcBuyer}
									</td>
									<td align="center" class="td_padding">
										${StoreIn.zcStatus}
									</td>
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
				<tr>
					<td class="td_padding">
						<div>
							<font class="top1_td"> <jsp:include page="/pages/common/pageman.jsp"></jsp:include> </font>
						</div>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>