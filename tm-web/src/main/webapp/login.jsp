<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TM</title>
	<link rel="icon" type="image/x-icon" href="resources/images/favicon.ico" />
	<link rel="stylesheet" href="resources/css/tm.css">
	<link rel="stylesheet" href="resources/css/bootstrap.css">
</head>
<body>
	<div class="baseBody">
		<div class="logoBoxSp">
			<div class="logo">
			</div>
		</div>
		<br><br><br><br><br><br><br><br><br><br>
		<div class="loginBox">
			<form:form method="POST" action="/tm-web/tmLogin/validateLogin.do">
				<input type= "text" placeholder="User Name" class= "loginFields loginUserNameBox" name="userId" />
				<input type= "password" placeholder="Password" class="loginFields loginPasswordBox" name="userPass" />
				<table class="loginButtons">
					<tr>
						<td>
							<button class= "btn btn-primary loginSubmit">Login</button>
						</td>
					</tr>
				</table>
			</form:form>
		</div>
	</div>
</body>
</html>