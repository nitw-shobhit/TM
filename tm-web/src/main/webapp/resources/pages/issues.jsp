<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="popups/issuePopups.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TM</title>
</head>
<body>
	<div>
		<button class="btn btn-default btn-xs" data-ng-click="openAddIssueBox()"><span class="glyphicon glyphicon-plus"></span> {{'button.add_issue' | translate}}</button>
		<button class="btn btn-default btn-xs" data-ng-click="exportIssues(moduleId)" style="margin-left:5px;"><span class="glyphicon glyphicon-export"></span> {{'button.export' | translate}}</button>
		<button class="btn btn-danger btn-xs" data-ng-click="getIssuesByModule(moduleId)" style="margin-left:5px;"><span class="glyphicon glyphicon-refresh"></span> {{'button.refresh' | translate}}</button>
	</div>
	<br>
	<table class="table table-striped issueTable" at-table at-paginated at-list="issues" at-config="config">
		<thead></thead>
		<tbody>
			<tr>
				<td>
					<a data-ng-show="!item.issSubscribed" data-ng-click="addIssueSubscription(item)">
						<span class="glyphicon glyphicon-star" style="color: #AAA; font-size: 15px;"></span>
					</a>
					<a data-ng-show="item.issSubscribed" data-ng-click="removeIssueSubscription(item)">
						<span class="glyphicon glyphicon-star" style="color: #DCEB14; font-size: 15px;"></span>
					</a>
				</td>
				<td>
					<img data-ng-show="item.issPriority == 'High'" src="<%= request.getContextPath()%>/resources/images/flag_red.ico" height="20" width="20" />
					<img data-ng-show="item.issPriority == 'Medium'" src="<%= request.getContextPath()%>/resources/images/flag_blue.ico" height="20" width="20" />
					<img data-ng-show="item.issPriority == 'Low'" src="<%= request.getContextPath()%>/resources/images/flag_green.ico" height="20" width="20" />
				</td>
				<td at-implicit at-sortable at-attribute="id" at-initial-sorting="asc" at-title="ID" ></td>
				<td at-implicit at-sortable at-attribute="issName" at-title="NAME" ></td>
				<td at-title="STATUS">
					<a class="underlinedLink" data-ng-click="viewIssueStatus(item)">{{item.issStatus}}</a>
				</td>
				<td at-implicit at-sortable at-attribute="userIdString" at-title="ASSIGNEE" ></td>
				<td at-implicit at-sortable at-attribute="issOwnerString" at-title="OWNER" ></td>
				<td at-implicit at-sortable at-attribute="dtCreated" at-title="CREATED-ON" ></td>
				<td at-title="ACTIONS">
					<a data-ng-click="viewIssue(item)"><span class="glyphicon glyphicon-eye-open"></span></a>
				</td>
			</tr>
		</tbody>
	</table>
	<at-pagination at-list="issues" at-config="config"></at-pagination>
</body>
</html>