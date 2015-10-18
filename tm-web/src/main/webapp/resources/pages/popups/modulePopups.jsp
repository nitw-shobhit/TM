<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TM</title>
<!-- ##########################################ADD MODULE############################################# -->
<script type="text/ng-template" id="addModule">
<fieldset class="popupFieldset">
	<legend>
		<span class="header">{{'section_header.add_module' | translate}}</span>
	</legend>
	<table class="formStructure">
		<tr>
			<td style="padding: 2px;"><label>Module name</label></td>
			<td style="padding: 2px;">
				<input class="form-control input-sm" type="text" data-ng-model="ngDialogData.modName" />
			</td>
		</tr>
		<tr>
			<td style="padding: 2px;"><label>Module description</label></td>
			<td style="padding: 2px;">
 				<textarea class="form-control" rows="2" data-ng-model="ngDialogData.modDesc"></textarea>
			</td>
		</tr>
		<tr>
			<td style="padding: 10px; float: right;">
				<button class="btn btn-primary btn-xs" data-ng-click="addModuleToProject(ngDialogData);">{{'button.add' | translate}}</button>
			</td>
			<td style="padding: 10px;">
				<button class="btn btn-default btn-xs" data-ng-click="closeThisDialog('button')" style="float: left;">{{'button.cancel' | translate}}</button>
			</td>		
		</tr>
	</table>
</fieldset>
</script>
<!-- ##########################################EDIT MODULE############################################# -->
<script type="text/ng-template" id="editModule">
<fieldset class="popupFieldset">
	<legend>
		<span class="header">{{'section_header.edit_module' | translate}}</span>
	</legend>
	<table class="formStructure">
		<tr>
			<td style="padding: 2px;"><label>Module name</label></td>
			<td style="padding: 2px;">
				<input class="form-control input-sm" type="text" data-ng-model="ngDialogData.modName" readonly="readonly"/>
			</td>
		</tr>
		<tr>
			<td style="padding: 2px;"><label>Module description</label></td>
			<td style="padding: 2px;">
 				<textarea class="form-control" rows="2" data-ng-model="ngDialogData.modDesc"></textarea>
			</td>
		</tr>
		<tr>
			<td style="padding: 10px; float: right;">
				<button class="btn btn-primary btn-xs" data-ng-click="editModule(ngDialogData);">{{'button.update' | translate}}</button>
			</td>
			<td style="padding: 10px;">
				<button class="btn btn-danger btn-xs" data-ng-click="deleteModule(ngDialogData.id);">{{'button.delete_module_permanently' | translate}}</button>
			</td>
			<td style="padding: 10px;">
				<button class="btn btn-default btn-xs" data-ng-click="closeThisDialog('button')" style="float: left;">{{'button.cancel' | translate}}</button>
			</td>
		</tr>
	</table>
</fieldset>
</script>
</head>
</html>