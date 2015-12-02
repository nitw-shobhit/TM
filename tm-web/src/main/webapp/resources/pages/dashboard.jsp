<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TM</title>
</head>
<body>
	<br><br>
	<div style="background-color: #FFF; height: 22px; margin-left: auto; margin-right: auto; text-align: center; font-weight: bold;">
  		Welcome {{userBean.userName}}. Choose one of your listed apps to get going!
  	</div>
  	<table style="margin-left:auto; margin-right: auto;">
  		<tr>
  			<td style="padding: 30px;">
  				<div data-ng-click="openApplication('Projects')" class="appBox">
  					<span class="glyphicon glyphicon-folder-open" style="font-size: 90px; margin-right:10px; margin-top:10px;"></span>
  					<br><br>
  					<span>My Projects</span>
  				</div>
  			</td>
  			<td style="padding: 30px;">
  				<div data-ng-click="openApplication('Calendar')" class="appBox">
  					<span class="glyphicon glyphicon-calendar" style="font-size: 20px;font-size: 90px;margin-top:10px; margin-left:10px;"></span>
  					<br><br>
  					<span>My Calendar</span>
  				</div>
  			</td>
  			<td style="padding: 30px;">
  				<div data-ng-click="openApplication('Settings')" class="appBox">
  					<span class="glyphicon glyphicon-cog" style="font-size: 90px; margin-top:10px;"></span>
  					<br><br>
  					<span>Global Settings</span>
  				</div>
  			</td>
  		</tr>
  		<tr>
  			<td style="padding: 30px;">
  				<div data-ng-click="openApplication('Notifications')" class="appBox">
  					<span data-ng-controller="notificationController" class="glyphicon glyphicon-envelope" style="font-size: 90px; margin-top:10px; margin-left: 15px;">
  					</span>
  					<span data-ng-show="countUnreadNotifications > 0" class="badge" ngCloak style="margin-top:10px; height: 16px; width: 15px;">{{countUnreadNotifications}}</span>
  					<br><br>
  					<span>My Notifications</span>
  				</div>
  			</td>
  			<td style="padding: 30px;">
  				<div data-ng-click="openApplication('Reports')" class="appBox">
  					<span class="glyphicon glyphicon-signal" style="font-size: 90px; margin-top:10px;"></span>
  					<br><br>
  					<span>Business Intelligence</span>
  				</div>
  			</td>
  			<td style="padding: 30px;">
  				<div data-ng-click="openApplication('Logs')" class="appBox">
  					<span class="glyphicon glyphicon-duplicate" style="font-size: 90px; margin-top:10px;"></span>
  					<br><br>
  					<span>Application Logs</span>
  				</div>
  			</td>
  		</tr>
  		<tr>
  			<td style="padding: 30px;">
  				<div class="appBox">
  					<br><br><br>
  					<span>This app is under construction!</span>
  				</div>
  			</td>
  		</tr>
  	</table>
</body>
</html>