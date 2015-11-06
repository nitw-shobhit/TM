<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="popups/reportPopups.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TM</title>
</head>
<body>
	<ol class="breadcrumb">
		<li><a data-ng-click="redirectToMyApps()" data-ng-controller="rootController"><span class="glyphicon glyphicon-th"></span> {{'breadcrumb.applications' | translate}}</a></li>
		<li class="active"><span class="glyphicon glyphicon-signal"></span> Reports</li>
	</ol>
	<table class="table table-striped" style="font-size: 10px;">
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>VIEW AS</th>
		</tr>
		<tr>
			<td>TM-000000001</td>
			<td>Issue Status report</td>
			<td>
				<a data-ng-click="openSelectProjectBox()" style="margin-left: 20px;"><img src="resources/images/pdf.png" class="reportIcon" height="24" width="24" /></a>
				<a href="/tm-web/output?__report=resources/reports/issue-status.rptdesign&__format=xls" 
					target="_blank" style="margin-left: 20px;" class="underlinedLink"><img src="resources/images/excel.png" class="reportIcon" height="24" width="24" /></a>
				<a href="/tm-web/output?__report=resources/reports/issue-status.rptdesign&__format=doc" 
					target="_blank" style="margin-left: 20px;" class="underlinedLink"><img src="resources/images/doc.gif" class="reportIcon" height="24" width="24" /></a>
				<a href="/tm-web/output?__report=resources/reports/issue-status.rptdesign&__format=ppt" 
					target="_blank" style="margin-left: 20px;" class="underlinedLink"><img src="resources/images/ppt.png" class="reportIcon" height="24" width="24" /></a>
			</td>
		</tr>
	</table>
</body>
</html>