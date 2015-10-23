<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="popups/userInfoPopups.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TM</title>
</head>
<body>
	<div class="logoBox">
		<div class="logo">
		</div>
		<div style="float: left;">
			<img data-ng-show="{{userBean.userImage == null}}" class="userInfoProfilePic" src="<%= request.getContextPath()%>/resources/images/default_p_img.png" />
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
				          				<label>Phone :</label> {{userBean.userPhone}}<br>
				        			</div>
								</td>
							</tr>
							<tr>
								<td>
									<button class="btn btn-default btn-xs" data-ng-click="openProfileBox()">{{'button.view_profile' | translate}}</button>
								</td>
								<td>
									<button class="btn btn-primary btn-xs" data-ng-click="openChangePasswordBox()">{{'button.change_password' | translate}}</button>
									<button class="btn btn-danger btn-xs" data-ng-click="logout()">{{'button.logout' | translate}}</button>
								</td>
							</tr>
						</table>
				    </div>
				</div>
			</div>
		</div>
		<div style="float: left;" data-ng-controller="notificationController">
			<a data-ng-click="loadNotifications()" style="margin-left: 15px;">
				<span class="glyphicon glyphicon-envelope" style="font-size:25px;"><span data-ng-show="countUnreadNotifications > 0" class="badge" ngCloak>{{countUnreadNotifications}}</span></span>
			</a>
		</div>
		<div style="float: left;" data-ng-controller="internalController">
			<a data-ng-click="showAboutMe()" style="margin-left: 10px;">
				<span class="glyphicon glyphicon-info-sign" style="font-size:25px; color: #FFF;"></span>
			</a>
		</div>
		<%@include file="locale.jsp"%>
	</div>
</body>
</html>