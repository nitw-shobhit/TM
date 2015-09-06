<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TM</title>
<script type="text/ng-template" id="addModule">
<fieldset class="popupFieldset">
	<legend>
		<span class="header">ADD MODULE</span>
	</legend>
	<table class="formStructure">
		<tr>
			<td style="padding: 2px;"><label>Module name</label></td>
			<td style="padding: 2px;">
				<input class="form-control input-sm" type="text" data-ng-model="ngDialogData.modName" />
			</td>
		</tr>
		<tr>
			<td style="padding: 2px;"><label>Module description</label></td>
			<td style="padding: 2px;">
 				<textarea class="form-control" rows="2" data-ng-model="ngDialogData.modDesc"></textarea>
			</td>
		</tr>
		<tr>
			<td style="padding: 10px; float: right;">
				<button class="btn btn-primary btn-xs" data-ng-click="addModuleToProject(ngDialogData);">Add</button>
			</td>
			<td style="padding: 10px;">
				<button class="btn btn-default btn-xs" data-ng-click="closeThisDialog('button')" style="float: left;">Cancel</button>
			</td>		
		</tr>
	</table>
</fieldset>
</script>
</head>
<body>
<ol class="breadcrumb">
  <li><a data-ng-click="redirectToProjects()">Projects</a></li>
  <li class="active">Modules</li>
</ol>
<fieldset class="moduleBox">
	<legend>
		<span class="header">MODULES</span>
	</legend>
	<table>
		<tr>
			<td>
				<span style="font-size: 10px;">Need a new module? Click <a ng-dialog-controller="projectController" ng-dialog="addModule" ng-dialog-data='{"projId" : "{{ngDialogData.projectId}}"}' ng-dialog-class="ngdialog-theme-default addModule" class="btn-link">here</a> to get started.?</span>
			</td>
		</tr>
	</table>
	<table style="vertical-align: middle;">
		<tr>
			<td data-ng-repeat="module in projectModules" style="padding:5px; border-bottom: 1px solid;">
				<a class="menuLink" data-ng-click="getModuleIssues(module.id)"><div class="moduleTabs">{{module.modName}}</div></a>
			</td>
		</tr>
	</table>
	{{ngDialogData.emptyListMessage}}
</fieldset>
</body>
</html>