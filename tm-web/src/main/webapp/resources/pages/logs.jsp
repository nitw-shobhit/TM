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
		<li class="active"><span class="glyphicon glyphicon-duplicate"></span> Logs</li>
	</ol>
	<table class="table table-striped logTable" at-table at-paginated at-list="logs" at-config="config">
		<thead></thead>
		<tbody>
			<tr>
				<td at-implicit at-sortable at-attribute="id" at-title="ID" ></td>
				<td at-implicit at-sortable at-attribute="log_level" at-initial-sorting="asc" at-title="LEVEL" ></td>
				<td at-implicit at-sortable at-attribute="log_logger" at-title="LOGGER" ></td>
				<td at-implicit at-sortable at-attribute="log_message" at-title="MESSAGE" ></td>
				<td at-implicit at-sortable at-attribute="log_signed_user" at-title="USER" ></td>
				<td at-implicit at-sortable at-attribute="log_ip_address" at-title="IP ADDRESS" ></td>
				<td at-implicit at-sortable at-attribute="dt_created" at-title="CREATED-ON" ></td>
			</tr>
		</tbody>
	</table>
	<at-pagination at-list="logs" at-config="config"></at-pagination>
</body>
</html>