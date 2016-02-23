<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="popups/projectPopups.jsp" />
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
		<li class="active"><span class="glyphicon glyphicon-folder-open"></span>&nbsp;&nbsp;{{'breadcrumb.projects' | translate}}</li>
	</ol>
	<div class="projectMainDiv">
		<fieldset class="projectFieldSet">
			<legend>	
				<span class="header">{{'section_header.active' | translate}}</span>
			</legend>
			<div class="projectBoxScrollDiv">
				<table>
					<tr>
						<td data-ng-repeat="project in projectList">
							<div class="projectFolder">
								<div class="projectFolderContent">
									<br><br>
									<div style="background-color: #EEE; border-radius: 4px; height:25px;"><font size="3">{{project.projNameTooltip}}</font></div>
								</div>
								<div class="projectSideMenu activeBg">
									<a ng-dialog="projectInfo" ng-dialog-class="ngdialog-theme-default projectInfo" ng-dialog-data="{{project}}" 
										class="projectSideMenuLink" title="Project Details"><i class="flaticon-info28"></i></a><br>
									<a data-ng-click="openEditProjectBox(project)"
										class="projectSideMenuLink" title="Edit"><i class="flaticon-edit45"></i></a><br>
									<a data-ng-click="getProjectTeam(project)"
										class="projectSideMenuLink" title="Project Team"><span class="flaticon-users10"></span></a><br>
									<a data-ng-click="getProjectModules(project.id, project.projName, 'issue')"
										class="projectSideMenuLink" title="Project Issues"><span class="flaticon-menu48"></span></a><br>
									<a data-ng-click="getProjectModules(project.id, project.projName, 'release')"
										class="projectSideMenuLink" title="Project Releases"><span class="glyphicon glyphicon-download-alt"></span></a><br>
									<a confirm-button confirm-action="disableProject(project.id)"
										class="projectSideMenuLink" title="Disable"><span class="flaticon-lock81"></span></a><br>
								</div>
							</div>
						</td>
						<td>
							<div class="projectFolder">
								<div class="newProjectFolderContent">
									<br><br>
									<button data-ng-click="openAddProjectBox()" style="padding: 0 12px;" class="btn btn-link"><font size="3">{{'button.add_project' | translate}}</font></button>
								</div>
							</div>
						</td>
					</tr>
				</table>
			</div>
		</fieldset>
		<fieldset class="arcProjectFieldSet">
			<legend>	
				<span class="header">{{'section_header.archived' | translate}}</span>
			</legend>
			<div class="arcProjectBoxScrollDiv">
				<table>
					<tr data-ng-repeat="project in archivedProjectList">
						<td class="archivedProjectContentTabl">
							<div class="archivedProjectBg">
								<div class="archivedProjectContent">
									<font size="1"><span class="archivedProjectList">{{project.projNameTooltip}}</span></font>
								</div>
								<div class="archivedProjectSideMenu inactiveBg">
									<a data-ng-click="enableProject(project.id)"
										class="projectSideMenuLink" title="Enable"><span class="flaticon-padlock79"></span></a>
									<a data-ng-click="deleteProject(project.id)"
										class="projectSideMenuLink" title="Remove"><span class="flaticon-power6"></span></a>
								</div>
							</div>
						</td>
					</tr>
				</table>
			</div>
		</fieldset>
	</div>
</body>
</html>