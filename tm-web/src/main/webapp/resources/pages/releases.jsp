<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TM</title>
</head>
<body>
	<div>
		<button class="btn btn-default btn-xs" data-ng-click="openAddReleaseBox()"><span class="glyphicon glyphicon-plus"></span> {{'button.add_release' | translate}}</button>
		<button class="btn btn-default btn-xs" data-ng-click="exportReleases(moduleId)" style="margin-left:5px;"><span class="glyphicon glyphicon-export"></span> {{'button.export' | translate}}</button>
		<button class="btn btn-danger btn-xs" data-ng-click="getReleasesByModule(moduleId)" style="margin-left:5px;"><span class="glyphicon glyphicon-refresh"></span> {{'button.refresh' | translate}}</button>
	</div>
	<br>
	<table class="table table-striped releaseTable" at-table at-paginated at-list="releases" at-config="config">
		<thead></thead>
		<tbody>
			<tr>
				<td at-implicit at-sortable at-attribute="id" at-initial-sorting="asc" at-title="ID" ></td>
				<td at-implicit at-sortable at-attribute="relName" at-title="NAME" ></td>
				<td at-implicit at-sortable at-attribute="relStatus" at-title="STATUS"></td>
				<td at-implicit at-sortable at-attribute="userIdString" at-title="ASSIGNEE" ></td>
				<td at-implicit at-sortable at-attribute="dtCreated" at-title="CREATED-ON" ></td>
				<td at-title="ACTIONS">
					<a data-ng-click="viewRelease(item)"><span class="glyphicon glyphicon-eye-open"></span></a>
				</td>
			</tr>
		</tbody>
	</table>
	<at-pagination at-list="releases" at-config="config"></at-pagination>
</body>
</html>