<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TM</title>
</head>
<body>
	<br><br><br><br><br><br><br><br><br>
	<div class="loginBox">
		<input type= "text" placeholder="User Name" class= "loginFields loginUserNameBox" data-ng-model="userId" />
		<input type= "password" placeholder="Password" class="loginFields loginPasswordBox" data-ng-model="userPass" />
		<table class="loginButtons">
			<tr>
				<td>
					<button class="btn btn-primary loginSubmit" data-ng-click="login()">{{'button.login' | translate}}</button>
				</td>
			</tr>
		</table>
		<span class="registerSpan">Don't have an account yet?</span> <a data-ng-click="register()" class="registerLink">Signup</a>
	</div>
	<br><br>
	
	<div style="width:170px; margin-left:auto; margin-right:auto;">
		<span class="registerSpan" style="color: #FFF;">Sign in with : </span>
		<table>
			<tr>
				<td>
					<button data-ng-click="loginFacebook()" class="btn btn-social-icon btn-facebook"><i class="fa fa-facebook"></i></button>
				</td>
				<td style="padding-left: 10px">
					<button data-ng-click="loginFacebook()" class="btn btn-social-icon btn-google"><i class="fa fa-google"></i></button>
				</td>
				<td style="padding-left: 10px">
					<button data-ng-click="loginFacebook()" class="btn btn-social-icon btn-twitter"><i class="fa fa-twitter"></i></button>
				</td>
				<td style="padding-left: 10px">
					<button data-ng-click="loginFacebook()" class="btn btn-social-icon btn-linkedin"><i class="fa fa-linkedin"></i></button>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>