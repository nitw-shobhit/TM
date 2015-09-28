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
	<ol class="breadcrumb">
		<li><a data-ng-click="redirectToProjects()" data-ng-controller="rootController">Projects</a></li>
		<li class="active">Modules</li>
	</ol>
	<table>
		<tr>
			<td>
				<span style="font-size: 11px;">Need a new module? Click <a data-ng-click="openAddModuleBox()" class="btn-link">here</a> to get started.</span>
			</td>
		</tr>
	</table>
	<br>
	<table style="vertical-align: middle;">
		<tr>
			<td style="width:.5%; border-bottom: 1px solid;"></td>
			<td data-ng-repeat="module in projectModules" data-ng-class="module.open ? 'moduleTabActive' : 'moduleTabInActive'">
				
					<div class="moduleTabs">
						<div>
							<a class="underlinedLink" data-ng-click="getModuleIssues(module.module.id)" style="margin-right:5px;">
								{{module.module.modName}}
							</a>
							<a><span class="badge">4</span></a>
							<a data-ng-click="openEditModuleBox(module)" style="margin-left: 5px;">
								<span class="glyphicon glyphicon-pencil editModule"></span>
							</a>
						</div>
					</div>
			</td>
			<td style="width:100%; border-bottom: 1px solid;"></td>
		</tr>
	</table>
	{{emptyListMessage}}
	<br>
	<div data-ui-view="issue"></div>
</body>
</html>