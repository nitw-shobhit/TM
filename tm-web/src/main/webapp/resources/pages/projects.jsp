<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TM</title>
<script type="text/ng-template" id="addProject">
<fieldset>
	<legend>
		<span class="header">ADD PROJECT</span>
	</legend>
	<table class="formStructure">
		<tr>
			<td style="padding: 2px;"><label>Project name</label></td>
			<td style="padding: 2px;">
				<input class="form-control input-sm" type="text" data-ng-model="ngDialogData.projName" />
			</td>
		</tr>
		<tr>
			<td style="padding: 2px;"><label>Project description</label></td>
			<td style="padding: 2px;">
 				<textarea class="form-control" rows="2" data-ng-model="ngDialogData.projDesc"></textarea>
			</td>
		</tr>
		<tr>
			<td style="padding: 10px; float: right;">
				<button class="btn btn-primary btn-xs" data-ng-click="addProject(ngDialogData)">Add</button>
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
	<fieldset>
		<legend>	
			<span class="header">PROJECTS</span>
		</legend>
		<div class="projectBoxScrollDiv">
			<table>
				<tr>
					<td data-ng-repeat="project in projectList">
						<div class="projectFolder">
							<div class="projectFolderContent">
								<br>
								<button class="btn btnLink" data-ng-click=""><font size="3">{{project.projName}}</font></button>
								<br><br>
								<div class="projectDescription">{{project.projDesc}}</div>
							</div>
							<div data-ng-class="project.visible ? 'projectSideMenu activeBg' : 'projectSideMenu inactiveBg'">
								<a data-ng-click=""
									class="projectSideMenuLink"><span class="glyphicon glyphicon-pencil"></span></a><br>
								<a data-ng-click=""
									class="projectSideMenuLink"><span class="glyphicon glyphicon-wrench"></span></a><br>
								<a data-ng-click="disableProject(project.id)"
									class="projectSideMenuLink"><span class="glyphicon glyphicon-off"></span></a><br>
								<a data-ng-click="deleteProject(project.id)"
									class="projectSideMenuLink"><span class="glyphicon glyphicon-trash"></span></a>
							</div>
						</div>
					</td>
					<td>
						<div class="projectFolder">
							<div class="newProjectFolderContent">
								<br><br>
								<button ng-dialog-controller="projectController" ng-dialog="addProject" ng-dialog-class="ngdialog-theme-default addProject" class="btn btnLink"><font size="2">ADD A PROJECT</font></button>
							</div>
						</div>
					</td>
				</tr>
			</table>
		</div>
	</fieldset>
	<br>
	<div data-ui-view="schema">
	</div>
</body>
</html>