<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="GB18030">
<title>��¼�쳣</title>
</head>
<body>
<h3><b>���ĵ�¼��Ϣ�������������룡3���<a href="../login.jsp">����</a>��¼���档</b></h3>
<%
response.setHeader("refresh","3;URL=../login.jsp");
%>
</body>
</html>