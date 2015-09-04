<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TM</title>
<!-- ##########################################ADD PROJECT############################################# -->
<script type="text/ng-template" id="addProject">
<fieldset class="popupFieldset">
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
<!-- ##########################################EDIT PROJECT############################################# -->
<script type="text/ng-template" id="editProject">
<fieldset class="popupFieldset">
	<legend>
		<span class="header">EDIT PROJECT</span>
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
				<button class="btn btn-primary btn-xs" data-ng-click="editProject(ngDialogData)">Update</button>
			</td>
			<td style="padding: 10px;">
				<button class="btn btn-default btn-xs" data-ng-click="closeThisDialog('button')" style="float: left;">Cancel</button>
			</td>		
		</tr>
	</table>
</fieldset>
</script>
<!-- ##########################################PROJECT INFORMATION############################################# -->
<script type="text/ng-template" id="projectInfo">
<fieldset class="popupFieldset">
	<legend>
		<span class="header">PROJECT DETAILS</span>
	</legend>
	<table class="formStructure">
		<tr>
			<td style="padding: 2px; text-align: left;"><label>Name: </label></td>
			<td style="padding: 2px; padding-left: 4px; text-align: left;border-bottom:1px solid;">
				<span>{{ngDialogData.projName}}</span>
			</td>
		</tr>
		<tr>
			<td style="padding: 2px; text-align: left;"><label>Description: </label></td>
			<td style="padding: 2px; padding-left: 4px; text-align: left;border-bottom:1px solid;">
				<span>{{ngDialogData.projDesc}}</span>
			</td>
		</tr>
		<tr>
			<td style="padding: 2px; text-align: left;"><label>Created: </label></td>
			<td style="padding: 2px; padding-left: 4px; text-align: left;border-bottom:1px solid;">
				<span>{{ngDialogData.dtCreated}}</span>
			</td>	
		</tr>
	</table>
</fieldset>
</script>
<!-- ##########################################PROJECT TEAM############################################# -->
<script type="text/ng-template" id="projectTeam">
<fieldset class="popupFieldset">
	<legend>
		<span class="header">TEAM</span>
	</legend>
	<div>
		<angucomplete-alt id="users" placeholder="Search users" pause="400" selected-object="addUserToList" local-data="ngDialogData.allUsers"
              search-fields="userId,userName,userEmail" title-field="userId,userName" minlength="1" input-class="form-control form-control-small"/>
    </div>
	<div class="projectTeamMembersBox">
		<div data-ng-repeat="member in ngDialogData.team" class="projectTeamMembers">
			<table style="vertical-align: middle;">
				<tr>
					<td>
						<img data-ng-show="{{member.userImage == null}}" height="27" width="27" src="<%= request.getContextPath()%>/resources/images/default_p_img.png" />
					</td>
					<td>
						{{member.userName}}
					</td>
				</tr>
			</table>
		</div>
	</div>
</fieldset>
</script>
<!-- ##########################################PROJECT MODULES############################################# -->
<script type="text/ng-template" id="projectModules">
<fieldset class="popupFieldset">
	<legend>
		<span class="header">MODULES</span>
	</legend>
	<table>
		<tr>
			<td>
				<span style="font-size: 10px;">Need a new module? Click <a ng-dialog-controller="projectController" ng-dialog="addModule" ng-dialog-data='{"projId" : "{{ngDialogData.projectId}}"}' ng-dialog-class="ngdialog-theme-default addModule" class="btn-link">here</a> to get started.
			</td>
		</tr>
	</table>
	<hr>
	<table style="vertical-align: middle;">
		<tr>
			<td data-ng-repeat="module in ngDialogData.data" style="padding:0;">
				<a class="menuLink" data-ng-click="getModuleIssues(module.id)"><div style="background-color: #FFF; margin-left:5px; padding-left:5px; padding-right:5px; margin-right:5px; font-size:12px;">{{module.modName}}</div></a>
			</td>
		</tr>
	</table>
	<hr>
	{{ngDialogData.emptyListMessage}}
</fieldset>
</script>
<!-- ##########################################ADD MODULE############################################# -->
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
</html>