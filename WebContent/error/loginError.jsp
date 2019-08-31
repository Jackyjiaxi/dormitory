<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="GB18030">
<title>登录异常</title>
</head>
<body>
<h3><b>您的登录信息有误，请重新输入！3秒后将<a href="../login.jsp">返回</a>登录界面。</b></h3>
<%
response.setHeader("refresh","3;URL=../login.jsp");
%>
</body>
</html>