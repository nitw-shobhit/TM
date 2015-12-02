<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TM</title>
<!-- ##########################################SELECT PROJECT############################################# -->
<script type="text/ng-template" id="selectProject">
<fieldset class="popupFieldset">
	<legend>
		<span class="header">SELECT A PROJECT</span>
	</legend>
	<div>
		<table>
			<tr>
				<td>
					<angucomplete-alt id="project" placeholder="Select from your projects" pause="400" selected-object="selectedProject" local-data="ngDialogData.project"
              			search-fields="projName,projDesc" title-field="projName" minlength="1" input-class="form-control form-control-small"/>
				</td>
				<td>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<a data-ng-click="closeSelectProjectBox()" class="btn btn-primary" 
						href="/tm-web/output?__report=resources/reports/issue-status.rptdesign&__format=pdf&project_id={{selectedProject.originalObject.id}}"
						target="_blank">GO</a>
				</td>
			</tr>
		</table>
    </div>
</fieldset>
</script>
</head>
</html>