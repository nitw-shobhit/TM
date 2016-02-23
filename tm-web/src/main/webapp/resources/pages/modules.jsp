<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="popups/modulePopups.jsp" />
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
		<li><a style="color: #aaa;" data-ng-click="redirectToProjects()" data-ng-controller="rootController"><span class="glyphicon glyphicon-folder-open"></span> {{'breadcrumb.projects' | translate}}</a></li>
		<li data-ng-show="selectedSubModule == 'issue'" class="active"><span class="glyphicon glyphicon-align-justify"></span> {{'breadcrumb.issues' | translate}}</li>
		<li data-ng-show="selectedSubModule == 'release'" class="active"><span class="glyphicon glyphicon-download-alt"></span> {{'breadcrumb.releases' | translate}}</li>
	</ol>
	<table>
		<tr>
			<td>
				<span style="font-size: 11px;">Need a new module? Click <a data-ng-click="openAddModuleBox()" class="btn-link">here</a> to get started.</span>
			</td>
		</tr>
	</table>
	<br>
	<table style="margin-left:auto; margin-right:auto">
		<tr>
			<td>
				<span class="underline" style="font-size: 14px; font-weight: bold; margin-left: auto; margin-right: auto;">{{projectName}}</span>
			</td>
		</tr>
	</table>
	<br>
	<table style="vertical-align: middle;">
		<tr>
			<td data-ng-repeat="module in projectModules" data-ng-class="module.open ? 'moduleTabActive' : 'moduleTabInActive'">
				
					<div class="moduleTabs">
						<div>
							<a class="underlinedLink" data-ng-click="getModuleComponents(module.module.id)" style="margin-right:5px;">{{module.module.modName}}</a>
							<a data-ng-click="openEditModuleBox(module)" style="margin-left: 5px;">
								<span class="glyphicon glyphicon-pencil editModule"></span>
							</a>
						</div>
					</div>
			</td>
			<td style="width:100%; border-bottom: 1px solid #FFF;"></td>
		</tr>
	</table>
	{{emptyListMessage}}
	<br>
	<div data-ui-view="component"></div>
</body>
</html>