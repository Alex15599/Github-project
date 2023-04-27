<%@page pageEncoding="GBK" errorPage="/pages/error/jspErrorPage.jsp"%>
<%@page contentType="text/html;charset=GBK" %>
<%@taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table width=100% border="0" style="height:12px;" cellspacing="1">
	<tr>
		<td colspan="5" style="font-size:12px;"><div align="center"><strong>
              [共${requestScope.countRecord}条记录] 
                 第${requestScope.currentPage}页/共${requestScope.countPage}页 
               [
              	<a href="${pageContext.request.contextPath }/storeInShowAll.do?currentPage=${requestScope.currentPage -1 }">上一页</a>
              /
              	<a href ="${pageContext.request.contextPath }/storeInShowAll.do?currentPage=${requestScope.currentPage +1 }">下一页</a>
               
               ]
             <span >转到</span> 
              <select name="select" id="myoption" onChange="a()">
              	<option>－请选择－</option>
               <c:forEach var="i" begin="1" end="${requestScope.countPage}">
                <option value="${i}">${i}</option>
               </c:forEach>
              </select>
             </div>
         </td>
    </tr>
   </table>

<script type="text/javascript">
function a(){
	var selectval = window.document.getElementById("myoption").value;
	window.location.href ="${pageContext.request.contextPath }/storeInShowAll.do?currentPage="+selectval ;
}
</script>