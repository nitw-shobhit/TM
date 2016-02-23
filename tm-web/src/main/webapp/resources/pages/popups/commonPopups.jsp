<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TM</title>
<script type="text/ng-template" id="confirmButton">
<fieldset class="popupFieldset">
	<legend>
		<span class="header">Confirm</span>
	</legend>
	Are you sure you wanna continue?
	<br><br>
	<button class="btn btn-primary btn-xs" data-ng-click="confirm(confirmValue)">Confirm</button> 
	<button class="btn btn-default btn-xs" data-ng-click="closeThisDialog('button')">Cancel</button>
</fieldset>
</script>
</head>
</html>