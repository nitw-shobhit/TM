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
		<li><a data-ng-click="redirectToProjects()" data-ng-controller="rootController">Projects</a></li>
		<li><a data-ng-click="loadNotifications()" >Notifications-Inbox</a></li>
		<li class="active">Notifications-Archived</li>
	</ol>
	<br>
	<div>
		<button class="btn btn-default btn-xs" data-ng-click="getUserNotifications()"><span class="glyphicon glyphicon-refresh"></span> Refresh</button>
		<button class="btn btn-default btn-xs" data-ng-click="unArchiveSelectedNotifications()" style="margin-left:5px;"><span class="glyphicon glyphicon-list-alt"></span> Un-Archive selected</button>
		<button class="btn btn-default btn-xs" data-ng-click="markAsReadSelectedNotifications('archived')" style="margin-left:5px;"><span class="glyphicon glyphicon-check"></span> Mark as read</button>
		<button class="btn btn-danger btn-xs" data-ng-click="deleteSelectedNotifications()" style="margin-left:5px;"><span class="glyphicon glyphicon-trash"></span> Delete selected</button>
	</div>
	<br>
	<table class="table notificationTable" at-table at-paginated at-list="archivedNotifications" at-config="config">
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
	<at-pagination at-list="archivedNotifications" at-config="config"></at-pagination>
</body>
</html>