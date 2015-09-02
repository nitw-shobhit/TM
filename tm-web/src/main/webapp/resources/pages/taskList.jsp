<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TM</title>
</head>
<body>
	<table class="table table-striped" at-table at-paginated at-list="requestList" at-config="config">
		<thead></thead>
		<tbody>
			<tr>
				<td at-implicit at-sortable at-attribute="taskName" at-initial-sorting="asc" at-title="NAME" ></td>
			<td at-implicit at-sortable at-attribute="taskDescription" at-title="DESCRIPTION" ></td>
				<td at-implicit at-sortable at-attribute="taskRequestType" at-title="REQUEST-TYPE" ></td>
			<td at-implicit at-sortable at-attribute="taskAssigned" at-title="ASSIGNED-ON"></td>
			<td at-implicit at-sortable at-attribute="taskStarted" at-title="STARTED-ON" ></td>
			<td at-implicit at-sortable at-attribute="taskStatus" at-title="STATUS" ></td>
			<td at-implicit at-sortable at-attribute="taskComments" at-title="COMMENTS" ></td>
			<td at-title="ACTIONS">
				<a data-ng-click="viewTask(item)"><span class="glyphicon glyphicon-eye-open"></span></a>
			</td>
			</tr>
		</tbody>
	</table>
	<at-pagination at-list="worklist" at-config="config"></at-pagination>
</body>
</html>