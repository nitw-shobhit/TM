<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="project/projectPopups.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TM</title>
</head>
<body>
	<div class="projectMainDiv">
		<fieldset class="projectFieldSet">
			<legend>	
				<span class="header">PROJECTS</span>
			</legend>
			<div class="projectBoxScrollDiv">
				<table>
					<tr>
						<td data-ng-repeat="project in projectList">
							<div class="projectFolder">
								<div class="projectFolderContent">
									<br><br>
									<button class="btn btnLink projectLink" data-ng-click="getProjectData(project)"><font size="3">{{project.projNameTooltip}}</font></button>
								</div>
								<div class="projectSideMenu activeBg">
									<a ng-dialog-controller="projectController" ng-dialog="editProject" ng-dialog-class="ngdialog-theme-default addEditProject" ng-dialog-data="{{project}}"
										class="projectSideMenuLink"><i class="flaticon-edit45"></i></a><br>
									<a data-ng-click=""
										class="projectSideMenuLink"><i class="flaticon-list6"></i></a><br>
									<a data-ng-click="disableProject(project.id)"
										class="projectSideMenuLink"><span class="flaticon-power107"></span></a><br>
								</div>
							</div>
						</td>
						<td>
							<div class="projectFolder">
								<div class="newProjectFolderContent">
									<br><br>
									<button ng-dialog-controller="projectController" ng-dialog="addProject" ng-dialog-class="ngdialog-theme-default addEditProject" class="btn btnLink"><font size="3">ADD A PROJECT</font></button>
								</div>
							</div>
						</td>
					</tr>
				</table>
			</div>
		</fieldset>
		<fieldset class="arcProjectFieldSet">
			<legend>	
				<span class="header">ARCHIVED</span>
			</legend>
			<div class="arcProjectBoxScrollDiv">
				<table>
					<tr data-ng-repeat="project in archivedProjectList">
						<td class="archivedProjectContentTabl">
							<div class="archivedProjectBg">
								<div class="archivedProjectContent">
									<button class="btnLink archivedLink" data-ng-click="getProjectData(project)">
										<font size="1"><span class="archivedProjectList">{{project.projNameTooltip}}</span></font>
									</button>
								</div>
								<div class="archivedProjectSideMenu inactiveBg">
									<a data-ng-click="enableProject(project.id)"
										class="projectSideMenuLink"><span class="flaticon-power107"></span></a>
									<a data-ng-click="deleteProject(project.id)"
										class="projectSideMenuLink"><span class="flaticon-garbage21"></span></a>
								</div>
							</div>
						</td>
					</tr>
				</table>
			</div>
		</fieldset>
	</div>
	<br>
	<div data-ui-view="projectData">
	</div>
</body>
</html>