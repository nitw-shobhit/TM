<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TM</title>
</head>
<body>
	<input class="userSearchBox" type="text" class="form-control" data-ng-model="userSearchQuery" placeholder="Search..">
	<a class="btn-link padding" data-ng-click="searchUser()"><span class="glyphicon glyphicon-search"></span></a>
	<br>
	<div class="projectTeamMembersBox">
		<div data-ng-repeat="member in projectTeam" class="projectTeamMembers">
			<table style="vertical-align: middle;">
				<tr>
					<td>
						<img data-ng-show="{{member.userImage == null}}" height="27" width="27" src="<%= request.getContextPath()%>/resources/images/default_p_img.png" />
					</td>
					<td>
						{{member.userName}}
					</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>