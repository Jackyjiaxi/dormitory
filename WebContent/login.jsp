<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030" errorPage="error/loginError.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="GB18030">
<title>�û���¼</title>
<link href="css/login.css" rel="stylesheet">
</head>
<body>
<div id=container>
	<h1>ѧ���������ϵͳ</h1>
	<form name="loginform" method="post" action="LoginServlet">
		<fieldset>
			<label for="username">�û�����</label>
				<input id="txtUser" name="username" type="text" placeholder="�������û���~">
			<label for="password">���룺</label>
				<input id="txtPwd" name="password" type="password" placeholder="����������~">
			<label for="usertype">�û����ͣ�</label>
				<select id="selUser" name="usertype">
				<option>��ѡ��</option>
				<option value="����Ա">����Ա</option>
				<option value="ѧ��">ѧ��</option>
				</select>
			<p>
				<input name="submit" type="submit" value="��¼">
				<input name="reset" type="reset" value="����">
			</p>
		</fieldset>
	</form>
</div>
</body>
</html>