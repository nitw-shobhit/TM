<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TM</title>
<!-- ##########################################UPDATE PROFILE############################################# -->
<script type="text/ng-template" id="userProfile">
<fieldset>
	<legend>
		<span class="header">UPDATE PROFILE</span>
	</legend>
	<table class="formStructure">
		<tr>
			<td style="vertical-align:top; padding: 10px;">
				<img height="80" width="80" src="<%= request.getContextPath()%>/resources/images/default_p_img.png" /><br>
				<input type="file" class="underlinedLink" tm-upload="ngDialogData.image">Change Photo</input>
			</td>
			<td style="padding: 10px;">
				<table style="font-size: 12px;">
					<tr>
						<td style="padding: 2px;"><label>Name</label></td>
						<td style="padding: 2px;">
							<input class="form-control input-sm" type="text" data-ng-model ="ngDialogData.userName" disabled="disabled"/>
						</td>
						<td>
						</td>
					</tr>
					<tr>
						<td style="padding: 2px;"><label>Id</label></td>
						<td style="padding: 2px;">
							<input class="form-control input-sm" type="text" data-ng-model ="ngDialogData.userId" disabled="disabled"/>
						</td>
						<td>
						</td>
					</tr>
					<tr>
						<td style="padding: 2px;"><label>Email</label></td>
						<td style="padding: 2px;">
							<input class="form-control input-sm" type="text" data-ng-model ="ngDialogData.userEmail" />
						</td style="padding: 2px;">
						<td>
						</td>
					</tr>
					<tr>
						<td style="padding: 2px;"><label>Access Type</label></td>
						<td style="padding: 2px;">
							<input class="form-control input-sm" type="text" data-ng-model ="ngDialogData.userType" disabled="disabled"/>
						</td>
						<td>
						</td>
					</tr>
					<tr>
						<td style="padding: 2px;"><label>Phone</label></td>
						<td style="padding: 2px;">
							<input class="form-control input-sm" type="text" data-ng-model ="ngDialogData.userPhone" />
						</td>
						<td>
						</td>
					</tr>
					<tr>
						<td style="padding: 10px; float: right;">
							<button class="btn btn-primary btn-xs" data-ng-click="updateProfile(ngDialogData)">Update</button>
						</td>
						<td style="padding: 10px;">
							<button class="btn btn-default btn-xs" data-ng-click="closeThisDialog('button')" style="float: left;">Cancel</button>
						</td>
						<td>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</fieldset>
</script>
<!-- ##########################################CHANGE PASSWORD############################################# -->
<script type="text/ng-template" id="changePassword">
<fieldset>
	<legend>
		<span class="header">CHANGE PASSWORD</span>
	</legend>
	<table class="formStructure">
		<tr>
			<td style="padding: 2px;"><label>Old password</label></td>
			<td style="padding: 2px;">
				<input class="form-control input-sm" type="password" data-ng-model ="ngDialogData.oldPassword" />
			</td>
		</tr>
		<tr>
			<td style="padding: 2px;"><label>New password</label></td>
			<td style="padding: 2px;">
				<input class="form-control input-sm" type="password" data-ng-model ="ngDialogData.newPassword" />
			</td>
		</tr>
		<tr>
			<td style="padding: 2px;"><label>Confirm new password</label></td>
			<td style="padding: 2px;">
				<input class="form-control input-sm" type="password" data-ng-model ="ngDialogData.confirmNewPassword" />
			</td>
		</tr>
		<tr>
			<td style="padding: 10px; float: right;">
				<button class="btn btn-primary btn-xs" data-ng-click="changePassword()">Update</button>
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