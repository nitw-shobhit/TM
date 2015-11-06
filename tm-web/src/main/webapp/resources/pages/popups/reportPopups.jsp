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
					<button class="btn btn-primary">GO</button>
				</td>
			</tr>
		</table>
    </div>
</fieldset>
</script>
</head>
</html>