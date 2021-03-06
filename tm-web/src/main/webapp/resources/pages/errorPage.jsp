<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TM</title>
	<link rel="icon" type="image/x-icon" href="../images/favicon.ico" />
	<link rel="stylesheet" href="<%= request.getContextPath()%>/resources/css/tm.css">
	<link rel="stylesheet" href="<%= request.getContextPath()%>/resources/css/bootstrap.css">
	<script src="<%= request.getContextPath()%>/resources/js/tm.js"></script>
	
</head>
<body>
	<div class="baseBody">
		<div class="logoBoxSp">
			<div class="logo">
			</div>
		</div>
	<br><br><br><br><br><br><br><br>
		<div class="errorBox">
			<table class=errorTable>
				<tr>
					<td class="padding-5px">
						<button class="btn btn-default errorButtonHome" onclick="redirectTo('/tm-web/login.jsp')">{{'button.home_error' | translate}}</button>
					</td>
					<td class="padding-5px">
						<button class="btn btn-default errorButtonContact" onclick="alert('Page is under construction!');">{{'button.contact_us_error' | translate}}</button>
					</td>
				</tr>
			</table>
			<div class="errorContent">
			<label>Error Code:&nbsp;&nbsp;</label> ${ErrorCode}<br>
			<label>Error Message:&nbsp;&nbsp;</label> ${ErrorMessage}
		</div>
		</div>
	</div>
</body>
</html>