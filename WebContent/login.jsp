<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030" errorPage="error/loginError.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="GB18030">
<title>用户登录</title>
<link href="css/login.css" rel="stylesheet">
</head>
<body>
<div id=container>
	<h1>学生宿舍管理系统</h1>
	<form name="loginform" method="post" action="LoginServlet">
		<fieldset>
			<label for="username">用户名：</label>
				<input id="txtUser" name="username" type="text" placeholder="请输入用户名~">
			<label for="password">密码：</label>
				<input id="txtPwd" name="password" type="password" placeholder="请输入密码~">
			<label for="usertype">用户类型：</label>
				<select id="selUser" name="usertype">
				<option>请选择</option>
				<option value="管理员">管理员</option>
				<option value="学生">学生</option>
				</select>
			<p>
				<input name="submit" type="submit" value="登录">
				<input name="reset" type="reset" value="重置">
			</p>
		</fieldset>
	</form>
</div>
</body>
</html>