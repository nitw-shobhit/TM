<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="popups/notificationPopups.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TM</title>
</head>
<body>
	<ol class="breadcrumb">
		<li><a data-ng-click="redirectToMyApps()" data-ng-controller="rootController"><span class="glyphicon glyphicon-th"></span> {{'breadcrumb.applications' | translate}}</a></li>
		<li class="active"><span class="glyphicon glyphicon-envelope"></span> {{'breadcrumb.notifications_inbox' | translate}}</li>
	</ol>
	<br>
	<div>
		<button class="btn btn-default btn-xs" data-ng-click="getUserNotifications()"><span class="glyphicon glyphicon-refresh"></span>{{'button.refresh' | translate}}</button>
		<button class="btn btn-default btn-xs" data-ng-click="archiveSelectedNotifications()" style="margin-left:5px;"><span class="glyphicon glyphicon-list-alt"></span> {{'button.archive_selected' | translate}}</button>
		<button class="btn btn-default btn-xs" data-ng-click="markAsReadSelectedNotifications('inbox')" style="margin-left:5px;"><span class="glyphicon glyphicon-check"></span> {{'button.mark_as_read' | translate}}</button>
		<button class="btn btn-primary btn-xs" data-ng-click="showArchivedNotifications()" style="float: right;"><span class="glyphicon glyphicon-new-window"></span> {{'button.archived_notifications' | translate}}</button>
	</div>
	<br>
	<table class="table notificationTable" at-table at-paginated at-list="notifications" at-config="config">
		<thead>
		</thead>
		<tbody>
			<tr>
				<td style="width:4%;"><input type="checkbox" style="float:left;" data-ng-model="selected" data-ng-change="toggleNoficationSelection(selected, item)"/></td>
				<td data-ng-class="item.notIsUnread ? 'notificationUnread' : ''" at-sortable at-title="BY" style="width:10%; text-align:left;">ADMIN</td>
				<td at-sortable at-title="TITLE" style="text-align:left;"><a data-ng-click = "viewNotification(item)" data-ng-class="item.notIsUnread ? 'underlinedLink notificationUnread' : 'underlinedLink'">{{item.notSubject}}</a></td>
				<td data-ng-class="item.notIsUnread ? 'notificationUnread' : ''" at-implicit at-sortable at-initial-sorting="desc" at-attribute="dtCreated" at-title="DATE" style="width:15%;text-align:left;"></td>
			</tr>
		</tbody>
	</table>
	<at-pagination at-list="notifications" at-config="config"></at-pagination>
</body>
</html>