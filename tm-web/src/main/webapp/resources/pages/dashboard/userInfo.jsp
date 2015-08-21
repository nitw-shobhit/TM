<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TM</title>
<script type="text/ng-template" id="userProfile">
<fieldset>
	<legend>
		<span class="header">UPDATE PROFILE</span>
	</legend>
	<table class="formStructure">
		<tr>
			<td style="vertical-align:top; padding: 10px;">
				<img height="80" width="80" src="<%= request.getContextPath()%>/resources/images/default_p_img.png" />
			</td>
			<td style="padding: 10px;">
				<table style="font-size: 12px;">
					<tr>
						<td style="padding: 2px;"><label>Name</label></td>
						<td style="padding: 2px;">
							<input class="form-control input-sm" type="text" data-ng-model ="ngDialogData.userName" disabled="disabled"/>
						</td>
						<td style="padding: 2px;">
						</td>
					</tr>
					<tr>
						<td style="padding: 2px;"><label>Id</label></td>
						<td style="padding: 2px;">
							<input class="form-control input-sm" type="text" data-ng-model ="ngDialogData.userId" disabled="disabled"/>
						</td>
						<td style="padding: 2px;">
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
						<td style="padding: 2px;"><label>Password</label></td>
						<td style="padding: 2px;">
							<button ng-dialog-controller="userInfoController" ng-dialog="changePassword" ng-dialog-class="ngdialog-theme-default changePassword" class="btn btn-link btn-xs" >Change Password</button>
						</td>
						<td style="padding: 2px;">
						</td>
					</tr>
					<tr>
						<td style="padding: 2px;"><label>Access Type</label></td>
						<td style="padding: 2px;">
							<input class="form-control input-sm" type="text" data-ng-model ="ngDialogData.userType" disabled="disabled"/>
						</td>
						<td style="padding: 2px;">
							<button class="btn btn-link btn-xs">Update privileges</button>
						</td>
					</tr>
					<tr>
						<td style="padding: 2px;"><label>Phone</label></td>
						<td style="padding: 2px;">
							<input class="form-control input-sm" type="text" data-ng-model ="ngDialogData.userPhone" />
						</td>
						<td style="padding: 2px;">
						</td>
					</tr>
					<tr>
						<td style="padding: 10px; float: right;">
							<button class="btn btn-primary btn-xs" data-ng-click="updateProfile(ngDialogData)">Update</button>
						</td>
						<td style="padding: 10px;">
							<button class="btn btn-default btn-xs" data-ng-click="closeThisDialog('button')" style="float: left;">Cancel</button>
						</td>
						<td style="padding: 10px;">
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</fieldset>
</script>
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
<body>
	<img data-ng-show="{{userBean.userImage == null}}" class="userInfoProfilePic" src="../resources/images/default_p_img.png" />
	<div class="btn-group" role="group" aria-label="...">
		<div class="btn-group" role="group">
		    <span class="userInfoNameSpan">{{userBean.userId}}</span>
		    <a class="dropdown-toggle userInfoLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" ><img src="<%= request.getContextPath()%>/resources/images/open-link.ico" class="userInfoLinkImg" /></a>
		    <div class="dropdown-menu userInfoDropdown">
				<table class="userInfoTable">
					<tr>
						<td>
							<img data-ng-show="{{userBean.userImage == null}}" height="64" width="64" src="<%= request.getContextPath()%>/resources/images/default_p_img.png" />
						</td>
						<td>
							<div class="userInfoContent">
		          				<label>Name :</label> {{userBean.userName}}<br>
		          				<label>Email :</label> {{userBean.userEmail}}<br>
		         				<label>Access Type :</label> {{userBean.userType}}<br>
		          				<label>Phone :</label> {{userBean.userPhone}}
		        			</div>
						</td>
					</tr>
					<tr>
						<td></td>
						<td>
							<button class="btn btn-default btn-xs" data-ng-click="openProfileBox()">View Profile</button>
							<button class="btn btn-danger btn-xs" data-ng-click="logout()">Logout</button>
						</td>
					</tr>
				</table>
		    </div>
		</div>
	</div>
</body>
</html>