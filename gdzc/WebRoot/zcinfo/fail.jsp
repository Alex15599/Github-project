<%@page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>Login failed</title>
</head>
<body>
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td>
      <blockquote>
        <div align="center" style="font-size:25px; font-family:方正姚体; ">
          <p>
            <img src="<%=request.getContextPath()%>/images/angry.jpg">
          </p>
          <p>对不起，由于你的非法操作,导致失败！请返回</p>
        </div>
        <p align="center">
          <b>
            <a href="<%=request.getContextPath()%>/zcinfo/zcinfo_edit.jsp" style="font-size:12px; "></a>
          </b>
      </blockquote>
      <p></p>
      <p></p>
    </td>
  </tr>
</table>
</body>
</html>
