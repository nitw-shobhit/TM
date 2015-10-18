<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TM</title>
<!-- ##########################################NOTIFICATION DETAILS############################################# -->
<script type="text/ng-template" id="notificationInfo">
<fieldset class="popupFieldset">
	<legend>
		<span class="header">{{'section_header.notification_details' | translate}}</span>
	</legend>
	<table style="width:100%; font-size:10px;">
		<tr>
			<td style="padding: 2px; text-align: left;"><label>From: </label></td>
			<td style="padding: 2px; padding-left: 4px; text-align: left; float:right;">
				<input type="text" value="ADMIN" readonly="readonly" style="width:445px;"/>
			</td>
		</tr>
		<tr>
			<td style="padding: 2px; text-align: left;"><label>Subject: </label></td>
			<td style="padding: 2px; padding-left: 4px; text-align: left; float:right;">
				<input type="text" style="width:445px;" readonly="readonly" data-ng-model="ngDialogData.notSubject">
			</td>
		</tr>
		<tr>
			<td></td>
			<td style="padding: 2px; padding-left: 4px; text-align: left; float:right;">
				<label>{{ngDialogData.dtCreated}}</label>
			</td>
		</tr>
	</table>
	<div style="width:500px; padding:5px; height: 170px; background-color: #FFF; position: relative;">
		<div style="font-size:11px; position: absolute; " >Dear User,<br>{{ngDialogData.notContent}}</div>
		<div style="font-size:9px; position: absolute; bottom: 0;" >{{ngDialogData.notFooter}}</div>
	</div>
</fieldset>
</script>
</head>
</html>