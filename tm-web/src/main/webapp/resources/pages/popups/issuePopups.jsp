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
			<table class="formStructure" style="width:540px; font-size:10px;">
				<tr>
					<td>
						<table style="width:100%;">
							<tr>
								<td style="padding: 2px; text-align: left;"><label>Name: </label></td>
								<td style="padding: 2px; padding-left: 4px; text-align: left; float:right;">
									<input type="text" data-ng-model="ngDialogData.issName" style="width:463px;"/>
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
									<textarea style="width:463px;" data-ng-model="ngDialogData.issDesc"></textarea>
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
								<td style="padding: 2px; padding-left: 4px; text-align: left;">
									<select class="input-xlarge" ng-model="ngDialogData.issPriority" style="width:282px; height:23px;">
 										<option selected disabled>Choose one</option>										
										<option value="Low">Low</option>
										<option value="Medium">Medium</option>
										<option value="High">High</option>
									</select>							
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td>
						<table style="width:100%;">
							<tr>
								<td style="padding: 2px; text-align: left;"><label>Comments: </label></td>
								<td style="padding: 2px; padding-left: 4px; text-align: left; float:right;">
 									<textarea style="width:463px;" data-ng-model="ngDialogData.issComment"></textarea>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td>
						<table style="width:100%;">
							<tr>
								<td style="padding: 2px; text-align: left;"><label>Attachments: </label></td>
								<td style="padding: 2px; padding-left: 4px; text-align: left; float:right;">
 									<textarea style="width:463px;" data-ng-model="ngDialogData.issAttachment"></textarea>
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
									<input type="text" data-ng-model="ngDialogData.userIdString" style="width:189px;"/>
								</td>
								<td style="padding: 2px; text-align: left;"><label>Logged by: </label></td>
								<td style="padding: 2px; padding-left: 4px; text-align: left; float:right;">
									<input type="text" readonly="readonly" value="{{ngDialogData.issOwnerString}}" style="width:200px;"/>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<br>
			<table style="width:100%; margin-left:auto; margin-right:auto;">
				<tr>
					<td style="padding: 10px; float: right;">
						<button class="btn btn-primary btn-xs" data-ng-click="addIssueToModule(ngDialogData);">Add</button>
					</td>
					<td>
						<button class="btn btn-default btn-xs" data-ng-click="closeThisDialog('button')" style="float:left;">Cancel</button>
					</td>
				</tr>
			</table>
</fieldset>
</script>
<!-- ##########################################ISSUE DETAILS############################################# -->
<script type="text/ng-template" id="viewIssue">
<fieldset class="popupFieldset">
	<legend>
		<span class="header">ISSUE ID :<b>{{ngDialogData.id}}</b></span>
	</legend>
	<div style="width: 745px; height:405px;">
		<div style="width: 550px; height:400px; border:1px solid; float:left;">
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
									<input type="text" readonly="readonly" value="{{ngDialogData.dtCreated}}" style="width:180px;"/>
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
									<input type="text" readonly="readonly" value="{{ngDialogData.userIdString}}" style="width:189px;"/>
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
				<tr>
					<td>
						<table style="width:100%;">
							<tr>
								<td style="padding: 2px; text-align: left;"><label>Attachments: </label></td>
								<td style="padding: 2px; padding-left: 4px; text-align: left; float:right;">
									<div style="height:100px; width:463px; border: 1px solid; background-color:#FFF; margin-bottom:15px;overflow-y:scroll;">
									</div>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</div>
			</table>
			<table style="width:99%; margin-left:auto; margin-right:auto;">
				<tr>
					<td>
						<button class="btn btn-default" data-ng-click="acceptIssue(ngDialogData)" style="font-size: 11px; padding:5px;"><span class="glyphicon glyphicon-thumbs-up"></span>&nbsp;Accept</button>
					</td>
					<td>
						<button class="btn btn-default" data-ng-click="rejectIssue(ngDialogData)" style="font-size: 11px; padding:5px;"><span class="glyphicon glyphicon-thumbs-down"></span>&nbsp;Reject</button>
					</td>
					<td>
						<button class="btn btn-default" data-ng-click="openReassignIssueBox(ngDialogData)" style="font-size: 11px; padding:5px;"><span class="glyphicon glyphicon-random"></span>&nbsp;Reassign</button>
					</td>
					<td>
						<button class="btn btn-default" data-ng-click="removeIssue(ngDialogData)" style="font-size: 11px; padding:5px;"><span class="glyphicon glyphicon-ban-circle"></span>&nbsp;Remove</button>
					</td>
					<td>
						<button class="btn btn-default" data-ng-click="reOpenIssue(ngDialogData)" style="font-size: 11px; padding:5px;"><span class="glyphicon glyphicon-repeat"></span>&nbsp;Reopen</button>
					</td>
					<td>
						<button class="btn btn-default" data-ng-click="markIssueAsFixed(ngDialogData)" style="font-size: 11px; padding:5px;"><span class="glyphicon glyphicon-tag"></span>&nbsp;Mark as fixed</button>
					</td>
					<td>
						<button class="btn btn-default" data-ng-click="completeIssue(ngDialogData)" style="font-size: 11px; padding:5px;"><span class="glyphicon glyphicon-ok"></span>&nbsp;Complete</button>
					</td>
				</tr>
			</table>
		</div>
		<div style="width: 190px; height: 400px; float:left;">
			<div style="border: 1px solid; width: 190px; height: 250px; margin-left:5px; font-size:10px;">
				<div style="height:196px; background-color:white; border:1px solid; overflow-x:auto;">
					<div data-ng-repeat="comment in ngDialogData.issComments" style="margin:4px; line-height:1.2em;">
						<div><b>{{comment.userIdString}}</b> : {{comment.comContent}}</div>
						<div style="font-size:8px; float:right; color:#999;">{{comment.dtCreated}}</div><br>
					</div>
				</div>
				<textarea placeholder="Add a comment.." style="margin-left:2px; margin-top:4px; height:45px; width:135px;" data-ng-model="ngDialogData.newComment"></textarea>
				<button data-ng-click="addCommentToIssue(ngDialogData)" class="btn btn-primary" style="height:45px; margin-top:4px; width: 47px; font-size:11px; padding:0;vertical-align:top;">Add</button>
			</div>
			<div style="border: 1px solid; width: 190px; height: 145px; margin-left:5px; margin-top:5px;" >
				<span style="margin-left:5px; font-size:11px; background-color:#FFF;"><u>Issue Subscribers</u></span>
				<div data-ng-repeat="sub in ngDialogData.issSubscribe" style="margin-left:5px">
					<font style="font-size:11px;">
						<a style="color: #23527C;" class="underlinedLink" href="#">{{sub.userIdString}}</a>
					</font>
				</div>
			</div>
		</div>
	</div>
	<div style="width: 745px; height:100px; border: 1px solid; overflow-y: scroll;">
		<span style="margin-left:5px; font-size:11px; background-color:#FFF;"><u>Issue History</u></span>
		<div data-ng-repeat="act in ngDialogData.issHistory" style="margin-left:5px">
			<font style="font-size:10px; color:#999;">{{act.hisCreated}}</font> : <font style="font-size:11px;"><a style="color: #23527C;" class="underlinedLink" href="#">{{act.hisUser}}</a>&nbsp;{{act.hisContent}}</font>
		</div>
	</div>
</fieldset>
</script>
</head>
</html>