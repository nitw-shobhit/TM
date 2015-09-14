<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TM</title>
<!-- ##########################################ADD ISSUE############################################# -->
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
				<input class="form-control input-sm" type="text" data-ng-model="ngDialogData.userIdString" />
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
<!-- ##########################################ISSUE DETAILS############################################# -->
<script type="text/ng-template" id="viewIssue">
<fieldset class="popupFieldset">
	<legend>
		<span class="header">ISSUE DETAILS</span>
	</legend>
	<div style="width: 745px; height:360px;">
		<div style="width: 550px; height:355px; border:1px solid; float:left;">
			<table class="formStructure" style="width:540px; font-size:10px;">
				<tr>
					<td>
						<table style="width:100%;">
							<tr>
								<td style="padding: 2px; text-align: left;"><label>Name: </label></td>
								<td style="padding: 2px; padding-left: 4px; text-align: left; float:right;">
									<input type="text" readonly="readonly" value="{{ngDialogData.issName}}" style="width:463px;"/>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td>
						<table style="width:100%;">
							<tr>
								<td style="padding: 2px; text-align: left;"><label>Description: </label></td>
								<td style="padding: 2px; padding-left: 4px; text-align: left; float:right;">
									<textarea row="2" readonly="readonly" style="width:463px;">{{ngDialogData.issDesc}}</textarea>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td>
						<table style="width:100%;">
							<tr>
								<td style="padding: 2px; text-align: left;"><label>Priority: </label></td>
								<td style="padding: 2px; padding-left: 4px; text-align: left; float:right;">
									<input data-ng-show="ngDialogData.issPriority == 'Low'" type="text" readonly="readonly" value="LOW" style="width:463px; background-color: green; color:white; font-weight: bold;"/>
									<input data-ng-show="ngDialogData.issPriority == 'Medium'" type="text" readonly="readonly" value="MEDIUM" style="width:463px; background-color: blue; color:white; font-weight: bold;"/>
									<input data-ng-show="ngDialogData.issPriority == 'High'" type="text" readonly="readonly" value="HIGH" style="width:463px; background-color: red; color:white; font-weight: bold;"/>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td>
						<table style="width:100%;">
							<tr>
								<td style="padding: 2px; text-align: left;"><label>Created on: </label></td>
								<td style="padding: 2px; padding-left: 4px; text-align: left; float:right;">
									<input type="text" readonly="readonly" value="{{ngDialogData.dtCreated}}" style="width:179px;"/>
								</td>
								<td style="padding: 2px; text-align: left;"><label>Last update: </label></td>
								<td style="padding: 2px; padding-left: 4px; text-align: left; float:right;">
									<input type="text" readonly="readonly" value="{{ngDialogData.dtModified}}" style="width:200px;"/>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td>
						<table style="width:100%;">
							<tr>
								<td style="padding: 2px; text-align: left;"><label>Assigned to: </label></td>
								<td style="padding: 2px; padding-left: 4px; text-align: left; float:right;">
									<input type="text" readonly="readonly" value="{{ngDialogData.userIdString}}" style="width:192px;"/>
								</td>
								<td style="padding: 2px; text-align: left;"><label>Logged by: </label></td>
								<td style="padding: 2px; padding-left: 4px; text-align: left; float:right;">
									<input type="text" readonly="readonly" value="{{ngDialogData.issOwnerString}}" style="width:200px;"/>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td>
						<table style="width:100%;">
							<tr>
								<td style="padding: 2px; text-align: left;"><label>Status: </label></td>
								<td style="padding: 2px; padding-left: 4px; text-align: left; float:right;">
									<input type="text" readonly="readonly" value="{{ngDialogData.issStatus}}" style="width:463px;"/>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<br><br><br>
			<table style="width:99%; margin-left:auto; margin-right:auto;">
				<tr>
					<td>
						<button class="btn btn-default" data-ng-click="" style="font-size: 11px; padding:5px;"><span class="glyphicon glyphicon-thumbs-up"></span>&nbsp;Accept</button>
					</td>
					<td>
						<button class="btn btn-default" data-ng-click="" style="font-size: 11px; padding:5px;"><span class="glyphicon glyphicon-thumbs-down"></span>&nbsp;Reject</button>
					</td>
					<td>
						<button class="btn btn-default" data-ng-click="" style="font-size: 11px; padding:5px;"><span class="glyphicon glyphicon-random"></span>&nbsp;Reassign</button>
					</td>
					<td>
						<button class="btn btn-default" data-ng-click="" style="font-size: 11px; padding:5px;"><span class="glyphicon glyphicon-ban-circle"></span>&nbsp;Remove</button>
					</td>
					<td>
						<button class="btn btn-default" data-ng-click="" style="font-size: 11px; padding:5px;"><span class="glyphicon glyphicon-repeat"></span>&nbsp;Reopen</button>
					</td>
					<td>
						<button class="btn btn-default" data-ng-click="" style="font-size: 11px; padding:5px;"><span class="glyphicon glyphicon-tag"></span>&nbsp;Mark as fixed</button>
					</td>
					<td>
						<button class="btn btn-default" data-ng-click="" style="font-size: 11px; padding:5px;"><span class="glyphicon glyphicon-ok"></span>&nbsp;Complete</button>
					</td>
				</tr>
			</table>
		</div>
		<div style="border: 1px solid; width: 190px; height: 355px; margin-left:5px; float:left; font-size:10px;">
			<div style="height:300px; background-color:white;margin2px; border:1px solid;">
				<div data-ng-repeat="comment in ngDialogData.issComments" style="margin:4px;">
					<b>{{comment.userIdString}}</b> : {{comment.comContent}}
				</div>
			</div>
			<textarea style="margin-left:2px; margin-top:4px; height:45px; width:135px;" data-ng-model="ngDialogData.newComment"></textarea>
			<button data-ng-click="addCommentToIssue(ngDialogData)" class="btn btn-primary" style="height:45px; margin-top:4px; width: 47px; font-size:11px; padding:0;vertical-align:top;">Add</button>
		</div>
	</div>
	<div style="width: 745px; height:70px; border: 1px solid;">
	</div>
</fieldset>
</script>
</head>
</html>