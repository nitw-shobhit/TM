<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TM</title>
<script type="text/ng-template" id="addIssue">
<fieldset class="popupFieldset">
	<legend>
		<span class="header">ADD ISSUE</span>
	</legend>
	<table class="formStructure">
		<tr>
			<td style="padding: 2px;"><label>Name : </label></td>
			<td style="padding: 2px;">
				<input class="form-control input-sm" type="text" data-ng-model="ngDialogData.issName" />
			</td>
		</tr>
		<tr>
			<td style="padding: 2px;"><label>Description : </label></td>
			<td style="padding: 2px;">
 				<textarea class="form-control" rows="3" data-ng-model="ngDialogData.issDesc"></textarea>
			</td>
		</tr>
		<tr>
			<td style="padding: 2px;"><label>Assign to : </label></td>
			<td style="padding: 2px;">
				<input class="form-control input-sm" type="text" data-ng-model="ngDialogData.userId" />
			</td>
		</tr>
		<tr>
			<td style="padding: 2px;"><label>Priority : </label></td>
			<td style="padding: 2px;">
				<table>
					<tr>
						<td style="padding-right:50px;"><input class="input-sm" type="radio" data-ng-model="ngDialogData.issPriority" value="Low" /><div style="background-color:green;color:white;padding-left:5px;padding-right:5px;">Low</div></td>
						<td style="padding-right:50px;"><input class="input-sm" type="radio" data-ng-model="ngDialogData.issPriority" value="Medium"/><div style="background-color:blue;color:white;padding-left:5px;padding-right:5px;">Medium</div></td>
						<td><input class="input-sm" type="radio" data-ng-model="ngDialogData.issPriority" value="High"/><div style="background-color:red;color:white;padding-left:5px;padding-right:5px;">High</div></td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td style="padding: 2px;"><label>Due date : </label></td>
			<td style="padding: 2px;">
				<input class="form-control input-sm" type="text" data-ng-model="ngDialogData.issDuedate" />
			</td>
		</tr>
		<tr>
			<td style="padding: 2px;"><label>Comments : </label></td>
			<td style="padding: 2px;">
 				<textarea class="form-control" rows="2" data-ng-model="ngDialogData.issComment"></textarea>
			</td>
		</tr>
		<tr>
			<td style="padding: 2px;"><label>Attachments : </label></td>
			<td style="padding: 2px;">
 				<textarea class="form-control" rows="2" data-ng-model="ngDialogData.issAttachment"></textarea>
			</td>
		</tr>
		<tr>
			<td style="padding: 10px; float: right;">
				<button class="btn btn-primary btn-xs" data-ng-click="addIssueToModule(ngDialogData);">Add</button>
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
	<div>
		<a data-ng-click="openAddIssueBox()"><span class="flaticon-text70"></span></a>
		<a data-ng-click="getIssuesByModule(moduleId)" style="margin-left:5px;"><span class="flaticon-refresh57"></span></a>
	</div>
		<table data-toggle="table" data-url="issues" data-show-columns="true" data-search="true" data-show-refresh="true" data-show-toggle="true" data-show-export="true" data-pagination="true" data-height="299">
		    <thead>
		    <tr>
		        <th data-field="issName">NAME</th>
		        <th data-field="issDesc">DESCRIPTION</th>
		        <th data-field="userId">OWNER</th>
		        <th data-field="issStatus">STATUS</th>
		        <th data-field="dtCreated">ASSIGNED-ON</th>
		        <th data-field="issDuedate">DUE DATE</th>
		        <th data-field="issCommentString">COMMENTS</th>
		        <th>ACTIONS</th>
		    </tr>
		    </thead>
		</table>
</body>
</html>