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
	<br>
	<ol class="breadcrumb">
		<li><a style="color: #aaa;" data-ng-click="redirectToMyApps()" data-ng-controller="rootController"><span class="glyphicon glyphicon-th"></span> {{'breadcrumb.applications' | translate}}</a></li>
		<li class="active"><span class="glyphicon glyphicon-calendar"></span> Calendar</li>
	</ol>
	<br>
	<pre>		Show : <input type="checkbox" data-ng-model="calendarChkAll" data-ng-change="updateCalendarFilters('All')"/> All		<input type="checkbox" data-ng-model="calendarChkIssues" data-ng-change="updateCalendarFilters('Other')"/> Issues Only		<input type="checkbox" data-ng-model="calendarChkReleases" data-ng-change="updateCalendarFilters('Other')"/> Releases Only		<input type="checkbox"  data-ng-model="calendarChkMeetings" data-ng-change="updateCalendarFilters('Other')"/> Meetings Only</pre>
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
				<div>
					<div style="float: left;">
						<table data-ng-hide="date.value == 0">
							<tr>
								<td>
									<div data-ng-hide="!date.events.issues || !calendarChkIssues">
										<img src="resources/images/bug.png" height="16" width="16"></img><span style="font-size:12px;">{{date.events.issues.length}}</span>
									</div>
								</td>
							</tr>
							<tr>
								<td>
									<div data-ng-hide="!date.events.releases || !calendarChkReleases">
										<img src="resources/images/release.png" height="16" width="16"></img><span style="font-size:12px;">{{date.events.releases.length}}</span>
									</div>
								</td>
							</tr>
							<tr>
								<td>
									<div data-ng-hide="!date.events.meetings || !calendarChkMeetings">
										<img src="resources/images/meeting.png" height="16" width="16"></img><span style="font-size:12px;">{{date.events.meetings.length}}</span>
									</div>
								</td>
							</tr>
						</table>
					</div>
					<div style="float: right;">
						<span>{{date.value}}</span>
					</div>
				</div>
			</td>
		</tr>
	</table>
</body>
</html>