<%@page pageEncoding="GBK" errorPage="/pages/error/jspErrorPage.jsp"%>
<%@page contentType="text/html;charset=GBK" %>
<%@taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table width=100% border="0" style="height:12px;" cellspacing="1">
	<tr>
		<td colspan="5" style="font-size:12px;"><div align="center"><strong>
              [��${requestScope.countRecord}����¼] 
                 ��${requestScope.currentPage}ҳ/��${requestScope.countPage}ҳ 
               [
              	<a href="${pageContext.request.contextPath }/storeInShowAll.do?currentPage=${requestScope.currentPage -1 }">��һҳ</a>
              /
              	<a href ="${pageContext.request.contextPath }/storeInShowAll.do?currentPage=${requestScope.currentPage +1 }">��һҳ</a>
               
               ]
             <span >ת��</span> 
              <select name="select" id="myoption" onChange="a()">
              	<option>����ѡ��</option>
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