<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<script type="text/ng-template" id="editProject">
<fieldset>
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
<script type="text/ng-template" id="userSearchBox">
<fieldset>
	<legend>
		<span class="header">USERS</span>
	</legend>
	<table class="formStructure">
		<tr data-ng-repeat="user in ngDialogData">
			<td style="padding: 2px;">{{user.userId}}-</td>
			<td style="padding: 2px;">{{user.userName}}-</td>
			<td style="padding: 2px;">{{user.userEmail}}-</td>
			<td style="padding: 2px;">{{user.userPhone}}-</td>
			<td style="padding: 2px;">{{user.userAddress}}</td>
		</tr>
	</table>
</fieldset>
</script>
</head>
</html>