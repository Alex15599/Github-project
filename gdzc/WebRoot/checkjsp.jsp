<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*"%>
<%//防止sql注入%>
<%
String Fy_Url=null;
StringTokenizer queryStr_token=null;
Fy_Url = request.getQueryString();

if(Fy_Url!=null){
    queryStr_token=new StringTokenizer(Fy_Url,"&");
    while(queryStr_token.hasMoreElements()){
        String compStr=(String)queryStr_token.nextElement();

        if(compStr!=null){
            String requestStr = compStr.substring(0,compStr.indexOf("="));
            String getStr = request.getParameter(requestStr);
            getStr = getStr.toLowerCase();
            if ((getStr.indexOf("'")!=-1)||(getStr.indexOf("and")!=-1)||(getStr.indexOf("select")!=-1)
            ||(getStr.indexOf("update")!=-1)||(getStr.indexOf("chr")!=-1)||(getStr.indexOf("delete%20from")!=-1)
            ||(getStr.indexOf(";")!=-1)||(getStr.indexOf("insert")!=-1)||(getStr.indexOf("mid")!=-1)
            ||(getStr.indexOf("master.")!=-1)){
				out.println("<script>window.location='/index.jsp';</script>");
				return;
            }
        }      
    }
}
%>