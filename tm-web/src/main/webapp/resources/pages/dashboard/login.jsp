<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TM</title>
</head>
<body>
	<br><br><br><br><br><br><br><br><br><br>
	<div class="loginBox">
		<input type= "text" placeholder="User Name" class= "loginFields loginUserNameBox" data-ng-model="userId" />
		<input type= "password" placeholder="Password" class="loginFields loginPasswordBox" data-ng-model="userPass" />
		<table class="loginButtons">
			<tr>
				<td>
					<button class= "btn btn-primary loginSubmit" data-ng-click="login()">Login</button>
				</td>
				<td>
					<button data-ng-click="loginFacebook()" class="ml btn btn-block btn-social btn-md btn-facebook"><b class="facebook-icon">f</b>Facebook</button>
				</td>
			</tr>
		</table>
		<span class="registerSpan">Don't have an account yet?</span> <a data-ng-click="register()" class="registerLink">Signup</a>
	</div>
</body>
</html>