<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TM</title>
	<script type="text/javascript">
		$(document).ready(function(e) {
			$('#firstLink').addClass('menuSelect');
		});
		$(function() {
		$('td').click(
			function() {
				$(this).parents('table').find('td').each(
				function(index, element) {
					$(element).removeClass('menuSelect');
				});
				$(this).addClass('menuSelect');
			});
		});
	</script>
</head>
<body>
	<table>
		<tr>
			<td id="firstLink" class="menuBg"><a data-ng-click="home()" class="menuLink"><font class="underline">H</font>ome</a></td>
			<td class="menuBg"><a data-ng-click="projects()" class="menuLink"><font class="underline">P</font>rojects</a></td>
			<td class="menuBg"><a data-ng-click="settings()" class="menuLink"><font class="underline">S</font>ettings</a></td>
			<td class="menuBg"><a data-ng-click="help()" class="menuLink"><font class="underline">H</font>elp</a></td>
			<td class="menuBg"><a data-ng-click="about()" class="menuLink"><font class="underline">A</font>bout</a></td>
		</tr>
	</table>
</body>
</html>