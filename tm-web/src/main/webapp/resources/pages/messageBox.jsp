<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TM</title>
<style type="text/css">
.ng-cloak {
  display: none !important;
}
</style>
</head>
<body>
	<div data-ng-if="successBoxFlag" class="alert alert-success overlay-panel errorSuccessPanel" >
	    <button type="button" class="close" data-ng-click="closePanel()">x</button>
	    <span class="glyphicon glyphicon-ok successPanelIcon"></span>
	    <strong>SUCCESS! </strong>
	    {{panelMessage}}
	</div>
	<div data-ng-if="errorBoxFlag" class="alert alert-danger overlay-panel errorSuccessPanel" >
	    <button type="button" class="close" data-ng-click="closePanel()">x</button>
	    <span class="glyphicon glyphicon-remove errorPanelIcon"></span>
	    <strong>OOPS! </strong>
	    {{panelMessage}}
	</div>
</body>
</html>