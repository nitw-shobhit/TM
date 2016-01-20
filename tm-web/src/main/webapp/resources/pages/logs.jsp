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
	
	<table ng-table="tableParams" class="table table-striped logTable" show-filter="true">
	    <tr ng-repeat="log in $data">
	        <td data-title="'ID'" filter="{ id: 'text'}" sortable="'id'" style="text-align: left;">
	            {{log.id}}</td>
            <td data-title="'LEVEL'" filter="{ log_level: 'text'}" sortable="'log_level'" style="text-align: left;">
            	{{log.log_level}}</td>
            <td data-title="'LOGGER'" filter="{ log_logger: 'text'}" sortable="'log_logger'" style="text-align: left;">
            	{{log.log_logger}}</td>
            <td data-title="'MESSAGE'" filter="{ log_message: 'text'}" sortable="'log_message'" style="text-align: left;">
           		{{log.log_message}}</td>
            <td data-title="'USER'" filter="{ log_signed_user: 'text'}" sortable="'log_signed_user'" style="text-align: left;">
            	{{log.log_signed_user}}</td>
            <td data-title="'ADDRESS'" filter="{ log_ip_address: 'text'}" sortable="'log_ip_address'" style="text-align: left;">
            	{{log.log_ip_address}}</td>
            <td data-title="'CREATED-DATE'" filter="{ dt_created: 'text'}" sortable="'dt_created'" style="text-align: left;">
            	{{log.dt_created}}</td>
	    </tr>
	</table>
</body>
</html>