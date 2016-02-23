<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="resources/pages/popups/commonPopups.jsp" />
<!DOCTYPE html>
<html data-ng-app="tm-app">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>TM</title>
	<link rel="stylesheet" href="<%= request.getContextPath()%>/resources/css/tm.css">
	<link rel="stylesheet" href="<%= request.getContextPath()%>/resources/css/bootstrap.css">
	<link rel="stylesheet" href="<%= request.getContextPath()%>/resources/css/bootstrap-social.css">
	<link rel="stylesheet" href="<%= request.getContextPath()%>/resources/css/font-awesome.min.css">
	<link rel="stylesheet" href="<%= request.getContextPath()%>/resources/css/ngDialog.css">
	<link rel="stylesheet" href="<%= request.getContextPath()%>/resources/css/ngDialog-theme-default.css">
	<link rel="stylesheet" href="<%= request.getContextPath()%>/resources/css/ui.fancytree.css" >
	<link rel="stylesheet" href="<%= request.getContextPath()%>/resources/css/icons/flaticon.css">
	<link rel="stylesheet" href="<%= request.getContextPath()%>/resources/css/angular.treeview.css">
	<link rel="stylesheet" href="<%= request.getContextPath()%>/resources/css/angular-busy.css">
	<link rel="stylesheet" href="<%= request.getContextPath()%>/resources/css/gh-fork-ribbon.css">
	<link rel="stylesheet" href="<%= request.getContextPath()%>/resources/css/angucomplete-alt.css">
	<script src="<%= request.getContextPath()%>/resources/js/others/jquery-1.11.1.min.js"></script>
	<script src="<%= request.getContextPath()%>/resources/js/others/angular.min.js"></script>
	<script src="<%= request.getContextPath()%>/resources/js/others/bootstrap.js"></script>
	<script src="<%= request.getContextPath()%>/resources/js/others/angular-table.js"></script>
	<script src="<%= request.getContextPath()%>/resources/js/others/angular-route.min.js"></script>
	<script src="<%= request.getContextPath()%>/resources/js/others/angular-ui-router.js"></script>
	<script src="<%= request.getContextPath()%>/resources/js/others/angular-translate.js"></script>
	<script src="<%= request.getContextPath()%>/resources/js/others/angular-translate-loader-static-files.js"></script>
	<script src="<%= request.getContextPath()%>/resources/js/others/ngDialog.js"></script>
	<!-- SERVICES -->
	<!-- DIRECTIVES -->
	<script src="<%= request.getContextPath()%>/resources/js/directives/confirmButtonDirective.js"></script>
	<script src="<%= request.getContextPath()%>/resources/js/directives/toggleTooltipDirective.js"></script>
	<!-- MAIN ANGULAR -->
	<script src="<%= request.getContextPath()%>/resources/js/tmAngular.js"></script>
	<!-- CONTROLLERS -->
	<script src="<%= request.getContextPath()%>/resources/js/controllers/rootController.js"></script>
	<script src="<%= request.getContextPath()%>/resources/js/controllers/loginController.js"></script>
	<script src="<%= request.getContextPath()%>/resources/js/controllers/userInfoController.js"></script>
	<script src="<%= request.getContextPath()%>/resources/js/controllers/dashboardController.js"></script>
	<script src="<%= request.getContextPath()%>/resources/js/controllers/releaseController.js"></script>
	<script src="<%= request.getContextPath()%>/resources/js/controllers/calendarController.js"></script>
	<script src="<%= request.getContextPath()%>/resources/js/controllers/reportController.js"></script>
	<script src="<%= request.getContextPath()%>/resources/js/controllers/projectController.js"></script>
	<script src="<%= request.getContextPath()%>/resources/js/controllers/moduleController.js"></script>
	<script src="<%= request.getContextPath()%>/resources/js/controllers/issueController.js"></script>
	<script src="<%= request.getContextPath()%>/resources/js/controllers/notificationController.js"></script>
	<script src="<%= request.getContextPath()%>/resources/js/controllers/internalController.js"></script>
	<script src="<%= request.getContextPath()%>/resources/js/controllers/loggerController.js"></script>
	
	<script src="<%= request.getContextPath()%>/resources/js/others/jquery-ui.custom.js"></script>
	<script src="<%= request.getContextPath()%>/resources/js/others/jquery.fancytree.js"></script>
	<script src="<%= request.getContextPath()%>/resources/js/tm.js"></script>
    <script src="<%= request.getContextPath()%>/resources/js/others/ui-bootstrap-tpls-0.13.0.js"></script>	
    <script src="<%= request.getContextPath()%>/resources/js/others/angular.treeview.js"></script>
    <script src="<%= request.getContextPath()%>/resources/js/others/angular-animate.js"></script>
    <script src="<%= request.getContextPath()%>/resources/js/others/angular-busy.js"></script>
    <script src="<%= request.getContextPath()%>/resources/js/others/angular-touch.min.js"></script>
    <script src="<%= request.getContextPath()%>/resources/js/others/angucomplete-alt.js"></script>
    <script src="<%= request.getContextPath()%>/resources/js/others/local-storage.js"></script>
	<link rel="icon" type="image/x-icon" href="<%= request.getContextPath()%>/resources/images/favicon.ico" />
</head>
<body>
	<div class="baseBody">
		<div data-ui-view="userInfo"></div>
		<div data-ui-view="messageBox"></div>
		<div class="contentBox">
			<div data-ui-view="content" class="content">
			</div>
		</div>
		<div data-ui-view="footer"></div>
	</div>
</body>
</html>