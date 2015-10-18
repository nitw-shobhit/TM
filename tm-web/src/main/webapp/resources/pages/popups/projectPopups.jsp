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
		<span class="header">{{'section_header.add_project' | translate}}</span>
	</legend>
	<table class="formStructure">
		<tr>
			<td style="padding: 2px;float:left;"><label>Project name</label></td>
			<td style="padding: 2px;">
				<input name="Project Name" class="form-control input-sm" type="text" data-ng-model="ngDialogData.proj.projName"/>
			</td>
		</tr>
		<tr>
			<td style="padding: 2px;float:left;"><label>Project description</label></td>
			<td style="padding: 2px;">
 				<textarea name="Project Description" class="form-control" rows="2" data-ng-model="ngDialogData.proj.projDesc"></textarea>
			</td>
		</tr>
		<tr>
			<td style="padding: 2px;float:left;"><label>Add preset modules</label></td>
			<td style="padding: 2px;">
 				<input type="checkbox" style="float:left;" data-ng-model="ngDialogData.addDefaultModulesFlag" />
			</td>
		</tr>
		<tr>
			<td style="padding: 10px; float: right;">
				<button class="btn btn-primary btn-xs" data-ng-click="addProject(ngDialogData)">{{'button.add' | translate}}</button>
			</td>
			<td style="padding: 10px;">
				<button class="btn btn-default btn-xs" data-ng-click="closeThisDialog('button')" style="float: left;">{{'button.cancel' | translate}}</button>
			</td>		
		</tr>
	</table>
</fieldset>
</script>
<!-- ##########################################EDIT PROJECT############################################# -->
<script type="text/ng-template" id="editProject">
<fieldset class="popupFieldset">
	<legend>
		<span class="header">{{'section_header.edit_project' | translate}}</span>
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
				<button class="btn btn-primary btn-xs" data-ng-click="editProject(ngDialogData)">{{'button.update' | translate}}</button>
			</td>
			<td style="padding: 10px;">
				<button class="btn btn-default btn-xs" data-ng-click="closeThisDialog('button')" style="float: left;">{{'button.cancel' | translate}}</button>
			</td>		
		</tr>
	</table>
</fieldset>
</script>
<!-- ##########################################PROJECT DETAILS############################################# -->
<script type="text/ng-template" id="projectInfo">
<fieldset class="popupFieldset">
	<legend>
		<span class="header">{{'section_header.project_details' | translate}}</span>
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
		<span class="header">{{'section_header.team' | translate}}</span>
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
</head>
</html>