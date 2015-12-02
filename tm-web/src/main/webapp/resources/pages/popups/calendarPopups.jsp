<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TM</title>
<!-- ##########################################MONTHS############################################# -->
<script type="text/ng-template" id="months">
<fieldset>
	<legend>
		<span class="header">{{'section_header.months' | translate}}</span>
	</legend>
	<table style="width: 100%; height: 100%; border-spacing: 5px; border-collapse:separate; ">
		<tr>
			<td class="monthsBox" data-ng-click="setMonth(0)"><span data-ng-class="ngDialogData.value == 0 ? 'boldText underline' : ''">JAN</span></td>
			<td class="monthsBox" data-ng-click="setMonth(1)"><span data-ng-class="ngDialogData.value == 1 ? 'boldText underline' : ''">FEB</span></td>
			<td class="monthsBox" data-ng-click="setMonth(2)"><span data-ng-class="ngDialogData.value == 2 ? 'boldText underline' : ''">MAR</span></td>
			<td class="monthsBox" data-ng-click="setMonth(3)"><span data-ng-class="ngDialogData.value == 3 ? 'boldText underline' : ''">APR</span></td>
		</tr>
		<tr>
			<td class="monthsBox" data-ng-click="setMonth(4)"><span data-ng-class="ngDialogData.value == 4 ? 'boldText underline' : ''">MAY</span></td>
			<td class="monthsBox" data-ng-click="setMonth(5)"><span data-ng-class="ngDialogData.value == 5 ? 'boldText underline' : ''">JUN</span></td>
			<td class="monthsBox" data-ng-click="setMonth(6)"><span data-ng-class="ngDialogData.value == 6 ? 'boldText underline' : ''">JUL</span></td>
			<td class="monthsBox" data-ng-click="setMonth(7)"><span data-ng-class="ngDialogData.value == 7 ? 'boldText underline' : ''">AUG</span></td>
		</tr>
		<tr>
			<td class="monthsBox" data-ng-click="setMonth(8)"><span data-ng-class="ngDialogData.value == 8 ? 'boldText underline' : ''">SEP</span></td>
			<td class="monthsBox" data-ng-click="setMonth(9)"><span data-ng-class="ngDialogData.value == 9 ? 'boldText underline' : ''">OCT</span></td>
			<td class="monthsBox" data-ng-click="setMonth(10)"><span data-ng-class="ngDialogData.value == 10 ? 'boldText underline' : ''">NOV</span></td>
			<td class="monthsBox" data-ng-click="setMonth(11)"><span data-ng-class="ngDialogData.value == 11 ? 'boldText underline' : ''">DEC</span></td>
		</tr>
	</table>
</fieldset>
</script>

<!-- ##########################################YEARS############################################# -->
<script type="text/ng-template" id="years">
<fieldset>
	<legend>
		<span class="header">{{'section_header.years' | translate}}</span>
	</legend>
	<table style="width: 100%; height: 100%; border-spacing: 5px; border-collapse:separate; ">
		<tr>
			<td class="yearsBox" data-ng-click="setYear(ngDialogData.value - 4)">{{ngDialogData.value - 4}}</td>
			<td class="yearsBox" data-ng-click="setYear(ngDialogData.value - 3)">{{ngDialogData.value - 3}}</td>
			<td class="yearsBox" data-ng-click="setYear(ngDialogData.value - 2)">{{ngDialogData.value - 2}}</td>
		</tr>
		<tr>
			<td class="yearsBox" data-ng-click="setYear(ngDialogData.value - 1)">{{ngDialogData.value - 1}}</td>
			<td class="yearsBox" data-ng-click="setYear(ngDialogData.value)"><span class="boldText underline">{{ngDialogData.value}}</span></td>
			<td class="yearsBox" data-ng-click="setYear(ngDialogData.value + 1)">{{ngDialogData.value + 1}}</td>
		</tr>
		<tr>
			<td class="yearsBox" data-ng-click="setYear(ngDialogData.value + 2)">{{ngDialogData.value + 2}}</td>
			<td class="yearsBox" data-ng-click="setYear(ngDialogData.value + 3)">{{ngDialogData.value + 3}}</td>
			<td class="yearsBox" data-ng-click="setYear(ngDialogData.value + 4)">{{ngDialogData.value + 4}}</td>
		</tr>
	</table>
</fieldset>
</script>

<!-- ##########################################DATE DETAILS############################################# -->
<script type="text/ng-template" id="dateBox">
<fieldset class="popupFieldset">
	<legend>
		<span class="header">{{ngDialogData.selectedDate}}/{{ngDialogData.selectedMonth}}/{{ngDialogData.selectedYear}}</span>
	</legend>
</fieldset>
</script>
</head>
</html>