<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="popups/calendarPopups.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TM</title>
</head>
<body>
	<ol class="breadcrumb">
		<li><a data-ng-click="redirectToMyApps()" data-ng-controller="rootController"><span class="glyphicon glyphicon-th"></span> {{'breadcrumb.applications' | translate}}</a></li>
		<li class="active"><span class="glyphicon glyphicon-calendar"></span> Calendar</li>
	</ol>
	<br><br><br>
	<div style="width: 910px; height: 70px; text-align: center; margin-left: auto; margin-right: auto; border: 1px solid rgb(204, 204, 204); background-color: rgb(255, 255, 255); font-size: 27px;" class="ng-scope">
		<div style="margin-top: 15px;">
		    <a data-ng-click="reduceYear()"><span style="margin-right: 20px;" class="glyphicon glyphicon-fast-backward"></span></a>
		    <a data-ng-click="reduceMonth()"><span style="margin-right: 180px;" class="glyphicon glyphicon-backward"></span></a>
		    <a data-ng-click="openMonthsPopUp()">{{calendar.month}}</a>, <a data-ng-click="openYearsPopUp()">{{calendar.year}}</a>
		    <a data-ng-click="increaseMonth()"><span style="margin-left: 180px;" class="glyphicon glyphicon-forward"></span></a>
		    <a data-ng-click="increaseYear()"><span style="margin-left: 20px;" class="glyphicon glyphicon-fast-forward"></span></a>
	  	</div>
	</div>
	<table style="width: 910px; height: 490px; text-align: center; margin-left: auto; margin-right: auto; border: 1px solid #CCC; background-color: #FFF;">
		<tr data-ng-repeat="row in calendar.days">
			<td class="calHeader">{{row.day}}</td>
			<td data-ng-click="openDateBox(date.value, calendar.month, calendar.year)" data-ng-repeat="date in row.dates" data-ng-class="date.value == 0 ? 'disabledCalDates' : 'enabledCalDates'">
				<span>{{date.value}}</span>
			</td>
		</tr>
	</table>
</body>
</html>